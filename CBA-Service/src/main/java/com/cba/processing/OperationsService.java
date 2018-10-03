package com.cba.processing;

import com.cba.beans.Account;
import com.cba.beans.AccountTransactions;


public interface OperationsService {
public String deposit(Account account,AccountTransactions accountTransaction,String userRole);
public String withdraw(Account account,AccountTransactions accountTransaction,String userRole);
}
