package com.cba.processing;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cba.beans.AccountStatus;
import com.cba.beans.BalanceEnquiry;
import com.cba.beans.Response;
import com.cba.dao.AccountDAO;
import com.cba.processing.util.JsonUtil;
import com.cba.processing.util.ResponseCodes;



@Service
public class AccountServiceImpl
implements AccountService{
private static Logger logger=Logger.getLogger(AccountServiceImpl.class);
	@Autowired
private AccountDAO accountDAO;
	@Override
	public String checkAccountStatus(String accountNumber) {
	Response response=new Response();
	response.setStatus(ResponseCodes.RESPONSE_FAILURE);
	response.setMessage("Unable to process your request!please try Again.");
		try{
			AccountStatus accountStatus=
					accountDAO.checkAccountStatus(accountNumber);
			if(accountStatus!=null){
				response.setStatus(ResponseCodes.RESPONSE_SUCCESS);
				response.setMessage("Account Found");
				String jsonAccountStatus=JsonUtil.convertJavaToJson(accountStatus);  
				response.setData(jsonAccountStatus);
			}
		}catch(EmptyResultDataAccessException e){
			//invalid account number
			response.setMessage(accountNumber+" Account Does Not Exist");
		}
		catch(DataAccessException e){
			response.setMessage("Unable to process your request!please try Again.");
			logger.error("Exception Occured while checking the Account Status : "+e);
		}	
		String jsonResponse=JsonUtil.convertJavaToJson(response);		
		return jsonResponse;
	}
	@Override
	public String checkBalance(String accountNumber) {
		Response response=new Response();
		response.setStatus(ResponseCodes.RESPONSE_FAILURE);
		response.setMessage("Unable to process your request!please try Again.");
			try{
				BalanceEnquiry accountStatus=
						accountDAO.checkBalance(accountNumber);
				if(accountStatus!=null){
					response.setStatus(ResponseCodes.RESPONSE_SUCCESS);
					response.setMessage("Account Found");
					String jsonAccountStatus=JsonUtil.convertJavaToJson(accountStatus);  
					response.setData(jsonAccountStatus);
				}
			}catch(EmptyResultDataAccessException e){
				//invalid account number
				response.setMessage(accountNumber+" Account Does Not Exist");
			}
			catch(DataAccessException e){
				response.setMessage("Unable to process your request!please try Again.");
				logger.error("Exception Occured while checking the Account Status : "+e);
			}	
			String jsonResponse=JsonUtil.convertJavaToJson(response);		
			return jsonResponse;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
