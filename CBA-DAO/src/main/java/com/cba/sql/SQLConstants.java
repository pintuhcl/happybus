package com.cba.sql;

public class SQLConstants {
public static final String SQL_GET_TOTAL_BALANCE="select total_balance from Account where account_number=?";
public static final String SQL_UPDATE_TOTAL_BALANCE="update account set total_balance=? where account_number=? ";
public static final String SQL_GET_ACCOUNT_STATUS=
"select acc.account_id,acc.branch_id,acc.account_holder_name,"
+ "acc.total_BALANCE,"
+ "acc.account_STATUS, "
+ "acctype.Accounts_TYPE_NAME,"
+ "branch.BRANCH_NAME "

+ " from ACCOUNT acc ,ACCOUNTS_TYPE  acctype,BRANCH branch "
+ " where acc.account_number=? and "
+ " branch.BRANCH_ID=acc.BRANCH_ID and "
+ " acctype.ACCOUT_TYPE_ID=acc.ACCOUNT_TYPE_ID";

public static final String SQL_GET_BALANCE_FOR_BALANCE_ENQUIRY = "select total_balance,account_status,account_holder_name from Account where account_number=?" ;

}
