package com.cba.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cba.beans.Account;
import com.cba.beans.AccountStatus;
import com.cba.beans.AccountTransactions;
import com.cba.beans.Response;
import com.cba.processing.AccountService;
import com.cba.processing.OperationsService;
import com.cba.util.AppConstants;

@Controller
public class BankEmployeeController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private OperationsService operationsService;

	@RequestMapping(value = "dashboard", method = RequestMethod.GET)
	public String showBankEmployeeDashboard(HttpServletRequest req) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       String username=user.getUsername();
       HttpSession session=req.getSession(false); 
       session.setAttribute("userName",username);
       Collection<GrantedAuthority> collection=user.getAuthorities();
           Iterator<GrantedAuthority> itr=collection.iterator();
            if(itr.hasNext()){
           GrantedAuthority ga=itr.next(); 	
           String userRole=ga.getAuthority();
           session.setAttribute("userRole",userRole);
            }
		return "bankEmployeeDashboard";
	}

	@RequestMapping(value = "deposit", method = RequestMethod.GET)
	@ResponseBody
	public String showDeposit() {

		String jsonResponse = "{\"status\":\"SUCCESS\",\"message\":\"Showing Depoit window\"}";
		return jsonResponse;
	}

	@RequestMapping(value = "withdraw", method = RequestMethod.GET)
	@ResponseBody
	public String showWithdraw() {

		String jsonResponse = "{\"status\":\"SUCCESS\",\"message\":\"Showing Withdraw window\"}";
		return jsonResponse;
	}

	@RequestMapping(value = "checkAccountStatus", method = RequestMethod.POST)
	@ResponseBody
	public String checkAccountStatus(@RequestParam("accountNumber") String accountNumber) {
		return accountService.checkAccountStatus(accountNumber);
	}

	@RequestMapping(value = "deposit", method = RequestMethod.POST)
	@ResponseBody
	public String deposit(@RequestParam("accountNumber") String accountNumber,
			@RequestParam("accountId") Integer accountId, @RequestParam("depositAmount") Double txAmount,
			@RequestParam("txDesc") String txDesc, @RequestParam("transactionMode") String txMode,
			@RequestParam("number") String number, @RequestParam("issuedBy") String issuedBy,
			@RequestParam("issuedBranch") String issuedBranch, @RequestParam("issuedDate") String issuedDate,
			HttpServletRequest request) {
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		AccountTransactions accountTransactions = new AccountTransactions();
		accountTransactions.setAccountId(accountId);
		accountTransactions.setTransactionAmount(txAmount);
		accountTransactions.setTransactionDesc(txDesc);
		accountTransactions.setTransactionType(AppConstants.CONS_TRANSACTION_TYPE_CREDIT);
		accountTransactions.setTransactionStatus(AppConstants.CONS_TRANSACTION_SUCCESS_STATUS);
		accountTransactions.setTransactionMode(txMode);
		accountTransactions.setDdORChequeNumber(number);
		accountTransactions.setIssuedBy(issuedBy);
		accountTransactions.setIssuedBranch(issuedBranch);
		if (issuedDate != null && issuedDate.trim().length() > 0) {

			try {
				accountTransactions.setIssuedDate(new SimpleDateFormat("dd-MM-yyyy").parse(issuedDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		accountTransactions.setUpdatedBy(201);// after completing login ,get
												// this value from session and
												// also user role from db
		return operationsService.deposit(account, accountTransactions, "OPERATIONAL MANAGER");
	}

	@RequestMapping(value = "withdraw", method = RequestMethod.POST)
	@ResponseBody
	public String withdraw(@RequestParam("accountNumber") String accountNumber,
			@RequestParam("accountId") Integer accountId, @RequestParam("withdrawAmount") Double txAmount,
			@RequestParam("transDesc") String txDesc, @RequestParam("transactionMode") String txMode,
			HttpServletRequest request) {
		Account acc = new Account();
		acc.setAccountNumber(accountNumber);
		AccountTransactions accTx = new AccountTransactions();
		accTx.setAccountId(accountId);
		accTx.setTransactionAmount(txAmount);
		accTx.setTransactionDesc(txDesc);
		accTx.setTransactionType(AppConstants.CONS_TRANSACTION_TYPE_DEBIT);
		accTx.setTransactionStatus(AppConstants.CONS_TRANSACTION_SUCCESS_STATUS);
		accTx.setTransactionMode(txMode);
		
		

		accTx.setUpdatedBy(301);// after completing login ,get
												// this value from session and
												// also user role from db
		return operationsService.withdraw(acc, accTx, "OPERATIONAL MANAGER");
	}
	
	

	@RequestMapping(value = "transferFunds", method = RequestMethod.POST)
	@ResponseBody
	public String transferFunds(@RequestParam("fromAccountNumber") 

	String fromAccountNumber,
			@RequestParam("toAccountNumber") String toAccountNumber,@RequestParam("transferingAmount") String 	transferingAmount) {
		String jsonResponse = "{\"status\":\"SUCCESS\",\"message\":\"Showing transfer window\"}";
		return jsonResponse;
		
		
		
	}
	@RequestMapping(value="balanceEnquiry")
	@GetMapping
	@ResponseBody
	public String getBalance(@RequestParam("accountNumber") String accountNumber){
		
		//getting acount status object
		AccountStatus accountStatus = new AccountStatus();
		
		//filling account number with requested parameter
		accountStatus.setAccountNumber(accountNumber);
		
		//calling service methods and returning the balance,account status,account holder's name in json form
		
		return accountService.checkBalance(accountNumber);
		
		
	}

}
