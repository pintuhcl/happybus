package com.cba.processing;

import java.util.Date;
import java.util.Map;

import javax.jms.JMSException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Service;

import com.cba.beans.Account;
import com.cba.beans.AccountTransactions;
import com.cba.beans.Response;
import com.cba.dao.AccountDAO;
import com.cba.dao.AccountTransactionsDAO;
import com.cba.dao.CustomerDAO;
import com.cba.integration.CBASMSService;
import com.cba.integration.TransactionsServiceMQ;
import com.cba.processing.util.JsonUtil;
import com.cba.processing.util.ResponseCodes;

@Service
public class OperationsServiceImpl 
implements OperationsService{
	private static Logger logger=Logger.getLogger(OperationsServiceImpl.class);
     @Autowired
	private UserAuditService userAuditService;
     @Autowired
     private AccountDAO accountDAO;
     @Autowired
     private AccountTransactionsDAO accountTransactionsDAO;
     @Autowired
     private TransactionsServiceMQ transactionsServiceMQ;
      @Autowired
     private CBAEmailService cbaEmailService;
      @Autowired
      private CustomerDAO customerDAO;
      @Autowired
      private CBASMSService cbaSMSService;
     @Override
	public String deposit(Account account,AccountTransactions accountTransactions,String userRole) {
	
    	 Response response=new Response();
	  response.setStatus(ResponseCodes.RESPONSE_FAILURE);
	  response.setMessage("Deposit is failure!please try Again.");
	  if(account.getAccountNumber()!=null && accountTransactions.getTransactionAmount()!=null&& accountTransactions.getUpdatedBy()!=null){	
	//first accountType,currencyType(INR),convert currency into required currency Type,check userRole
	  try{
		 Double totalBalance=accountTransactionsDAO.getTotalBalance(account.getAccountNumber());
	     totalBalance=totalBalance+accountTransactions.getTransactionAmount();
	   account.setBalance(totalBalance);
	    Map<String,Object> map=accountDAO.updateBalance(account,accountTransactions);
	  if(map!=null && map.size()>0){
		  accountTransactions.setAccountTransactionId((Integer)map.get("ACCOUNT_TRANSACTION_ID_OUT"));
         accountTransactions.setTransactionDate((Date)map.get("TRANSACTION_DATE_OUT"));		 
		  //produce message Queue ==>JMS server
        String jsonAccount=JsonUtil.convertJavaToJson(account);
        String jsonAccountTransactions=JsonUtil.convertJavaToJson(accountTransactions);
		try{  
        transactionsServiceMQ.depositTransactionMessageQueue(jsonAccount,jsonAccountTransactions);
		}catch(JmsException e){
		//re produce as a message Queue	
				  }
		try{
		Map<String,Object> emailAndMobile=customerDAO.getEmailandMobile(account.getAccountNumber());
		//get customer email,mobile from db
		  //send sms  and email to customer
	String subject="Alert Mail From CBA";	
	String body="Dear Customer ,\nThis is  inform you that an Amount of "+accountTransactions.getTransactionAmount()+" has been credited into your account.\n"+"The Transaction id is "+accountTransactions.getAccountTransactionId()+"\nThe Total Available Balance is  "+totalBalance;
	String emailStatus=cbaEmailService.sendOperationsInfoEmail((String)emailAndMobile.get("EMAIL"), subject, body);
	logger.info("Email status : "+emailStatus); 
	String sms="Amount of "+accountTransactions.getTransactionAmount()+" has been credited into your account.";
	String smsStatus=cbaSMSService.sendSms((String)emailAndMobile.get("MOBILE"), sms, null);
	logger.info("Sms status : "+smsStatus); 
	
		}catch(DataAccessException de){
logger.error("Exception Occured while getting the email and mobile : "+de);		  
	  }
		  response.setStatus(ResponseCodes.RESPONSE_SUCCESS);
		 response.setData(map.get("ACCOUNT_TRANSACTION_ID_OUT").toString()); 
		response.setMessage(accountTransactions.getTransactionAmount()+ " Deposited into "+account.getAccountNumber()+" successfully");  
	  }
	  }catch(EmptyResultDataAccessException de){
		response.setMessage("Invalid Account Number"); 
		response.setStatus(ResponseCodes.RESPONSE_FAILURE);
	  }
	  catch(DataAccessException de){
			response.setMessage("Internal Server Problem!Please Try Again.");
			
			response.setStatus(ResponseCodes.RESPONSE_FAILURE);
		  
	  }
	  
	  }
	 String jsonResponse=JsonUtil.convertJavaToJson(response); 
	  return jsonResponse;
	}

	@Override
	public String withdraw(Account acc,
			AccountTransactions accTx, String userRole) {
		Response response=new Response();
		  response.setStatus(ResponseCodes.RESPONSE_FAILURE);
		  response.setMessage("Withdraw is failure!please try Again.");
		  if(acc.getAccountNumber()!=null && accTx.getTransactionAmount()!=null&& accTx.getUpdatedBy()!=null){	
		//first accountType,currencyType(INR),convert currency into required currency Type,check userRole
		  try{
			 Double totalBalance=accountTransactionsDAO.getTotalBalance(acc.getAccountNumber());
		     totalBalance=totalBalance-accTx.getTransactionAmount();
		   acc.setBalance(totalBalance);
		    Map<String,Object> map=accountDAO.updateBalance(acc,accTx);
		  if(map!=null && map.size()>0){
			  accTx.setAccountTransactionId((Integer)map.get("ACCOUNT_TRANSACTION_ID_OUT"));
			  accTx.setTransactionDate((Date)map.get("TRANSACTION_DATE_OUT"));		 
			  //produce message Queue ==>JMS server
	    
			  //send sms  and email to customer
			  response.setStatus(ResponseCodes.RESPONSE_SUCCESS);
			 response.setData(map.get("ACCOUNT_TRANSACTION_ID_OUT").toString()); 
			response.setMessage(accTx.getTransactionAmount()+ " Withdraw Successfully from Account "+acc.getAccountNumber());  
		  }
		  }catch(EmptyResultDataAccessException de){
			response.setMessage("Invalid Account Number"); 
			response.setStatus(ResponseCodes.RESPONSE_FAILURE);
		  }
		  catch(DataAccessException de){
				response.setMessage("Internal Server Problem!Please Try Again.");
				
				response.setStatus(ResponseCodes.RESPONSE_FAILURE);
			  
		  }
		  
		  }
		 String jsonResponse=JsonUtil.convertJavaToJson(response); 
		  return jsonResponse;
	}
}
