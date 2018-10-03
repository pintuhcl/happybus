package com.cba.dao;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.cba.beans.Account;
import com.cba.beans.AccountStatus;
import com.cba.beans.AccountTransactions;
import com.cba.beans.BalanceEnquiry;
import com.cba.sql.SQLConstants;



@Repository
public class AccountDAOImpl implements AccountDAO{
	@Autowired
private JdbcTemplate jdbcTemplate;

	@Override
	public Map<String,Object> updateBalance(Account account, AccountTransactions accountTransactions) {
	SimpleJdbcCall  jdbcCall=new SimpleJdbcCall(jdbcTemplate);
	jdbcCall.setProcedureName("UPDATE_ACCOUNT_BALANCE");  
	jdbcCall.addDeclaredParameter(new SqlParameter("ACCOUNT_NUM_IN",Types.VARCHAR));
	   jdbcCall.addDeclaredParameter(new SqlParameter("TOTAL_BALANCE_IN",Types.DOUBLE));
	   jdbcCall.addDeclaredParameter(new SqlParameter("UPDATED_BY_IN",Types.INTEGER));
	   jdbcCall.addDeclaredParameter(new SqlParameter("TX_STATUS_IN",Types.VARCHAR));
	   jdbcCall.addDeclaredParameter(new SqlParameter("TX_MODE_IN",Types.VARCHAR));
	   jdbcCall.addDeclaredParameter(new SqlParameter("TX_TYPE_IN",Types.VARCHAR));
	   jdbcCall.addDeclaredParameter(new SqlParameter("TX_AMOUNT_IN",Types.DOUBLE));
	   jdbcCall.addDeclaredParameter(new SqlParameter("TX_DESC_IN",Types.VARCHAR));
	  jdbcCall.addDeclaredParameter(new SqlParameter("DDORCHEQUE_NUMBER_IN",Types.VARCHAR));
	  jdbcCall.addDeclaredParameter(new SqlParameter("ISSUED_BY_IN",Types.VARCHAR));
	  jdbcCall.addDeclaredParameter(new SqlParameter("ISSUED_DATE_IN",Types.DATE));
	  jdbcCall.addDeclaredParameter(new SqlParameter("ISSUED_BRANCH_IN",Types.VARCHAR));
	  
	   
	   jdbcCall.addDeclaredParameter(new SqlOutParameter("ACCOUNT_TRANSACTION_ID_OUT",Types.INTEGER));
	   jdbcCall.addDeclaredParameter(new SqlOutParameter("TRANSACTION_DATE_OUT",Types.DATE));
	   	   
       Map<String,Object> map=new HashMap<>();
         map.put("ACCOUNT_NUM_IN",account.getAccountNumber());
         map.put("TOTAL_BALANCE_IN",account.getBalance());
         map.put("TX_STATUS_IN",accountTransactions.getTransactionStatus());
         map.put("TX_MODE_IN",accountTransactions.getTransactionMode());
         map.put("TX_TYPE_IN",accountTransactions.getTransactionType());
         map.put("TX_AMOUNT_IN",accountTransactions.getTransactionAmount());
         map.put("TX_DESC_IN",accountTransactions.getTransactionDesc());
         map.put("UPDATED_BY_IN",accountTransactions.getUpdatedBy());
         map.put("DDORCHEQUE_NUMBER_IN",accountTransactions.getDdORChequeNumber());
         map.put("ISSUED_BY_IN",accountTransactions.getIssuedBy());
         map.put("ISSUED_DATE_IN",accountTransactions.getIssuedDate());
         map.put("ISSUED_BRANCH_IN",accountTransactions.getIssuedBranch());
                  
	   Map<String,Object> outParams=jdbcCall.execute(map);
	   	   return  outParams;
	
	}

	@Override
	public AccountStatus checkAccountStatus
	(String accountNumber) {
		
  return jdbcTemplate.queryForObject(SQLConstants.SQL_GET_ACCOUNT_STATUS,(ResultSet rs,int rowNum)->{
   AccountStatus accountStatus=new AccountStatus();
   accountStatus.setAccountNumber(accountNumber);
   accountStatus.setAccountId(rs.getInt(1));
   accountStatus.setBranchId(rs.getInt(2));
   accountStatus.setAccountHolderName(rs.getString(3));
   accountStatus.setTotalBalance(rs.getDouble(4));
   accountStatus.setAccountStatus(rs.getString(5));
   accountStatus.setAccountType(rs.getString(6));
   accountStatus.setBranchName(rs.getString(7));
   
   return accountStatus;
  },accountNumber);
	}

	@Override
	public BalanceEnquiry checkBalance(String accountNumber) {
		// TODO Auto-generated method stub
		
		return jdbcTemplate.queryForObject(SQLConstants.SQL_GET_BALANCE_FOR_BALANCE_ENQUIRY,(ResultSet rs,int rowNum)->{
			BalanceEnquiry balanceEnquiry = new BalanceEnquiry();
			balanceEnquiry.setAccountNumber(accountNumber);
			balanceEnquiry.setTotalBalance(rs.getDouble(1));
			balanceEnquiry.setAccountStatus(rs.getString(2));
			balanceEnquiry.setAccountHoldername(rs.getString(3));
			
			return balanceEnquiry;
		} ,accountNumber);
		
		
	}
}








