package com.cba.integration;

import com.cba.beans.Account;
import com.cba.beans.AccountTransactions;

public interface TransactionsServiceMQ {
public String depositTransactionMessageQueue(String jsonAccount,String accountTransactions);
}
