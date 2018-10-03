/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.util;

/**
 * This class is used hold the All SQL Query from FlatFiles
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
public class SQLConstants {
	/**
	 * Hold the SQL-Query
	 */
	public static final String SQL_SAVE_WORKING_HOURS = "insert into WorkingHours(working_hour_id,opening_hours,closing_hours) values(?,?,?) ";
	public static final String SQL_SAVE_BANK_DETAILS = "insert into Bank(bank_id,bank_name,bank_desc) values(?,?,?) ";
	public static final String SQL_SAVE_REGION_DETAILS = "insert into Region(region_id,region_name,region_code,region_head_office,region_desc,region_address,bank_id) values(?,?,?,?,?,?,?)";
	public static final String SQL_SAVE_BRANCH_DETAILS = "insert into Branch(branch_id,branch_name,branch_code,phone_number1,phone_number2,email,swift_code,working_hours_id,branch_address,branch_city,branch_state,branch_country,branch_zipcode,region_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String SQL_GET_ACCOUNT_TRANSACTIONS = "select account_id,transaction_type,transaction_date,transaction_amount,transaction_status,transaction_mode,transaction_desc,updated_by from Account_Transactions where account_transaction_id=?";
	public static final String SQL_UPDATE_ACCOUNT_TRANSACTIONS = "update Account_Transactions set transaction_amount=?,transaction_date=?,transaction_status=?,transaction_mode=?,transaction_type=? where account_transaction_id=?";
	public static final String SQL_SAVE_ACCOUNT_TRANSACTIONS = "insert into Account_Transactions(account_transaction_id,account_id,transaction_amount,transaction_date,transaction_mode,transaction_type,transaction_status,transaction_desc,updated_by) values(?,?,?,?,?,?,?,?,?) ";
	public static final String SQL_SAVE_NOMINEE_DETAILS = "insert into Nominee(nominee_Id,nominee_Name,nominee_DOB,gender,relationship,address,createDate,lastModifiedDate,lastModifiedBy) values(?,?,?,?,?,?,?,?,?,?)";
	public static final String SQL_SAVE_Card_DETAILS = "insert into Card(card_Id,card_Number,card_Holder_Name,expiry_Date,cvv,card_Type_Id)";
	public static final String SQL_SAVE_DEPOSITE_DETAILS = "insert into Deposite(depositeId,depositeTypeName,rateOfInterest,accountNumber)";
public static final String SQL_SAVE_CUSTOMER_DETAILS="insert into Customer(customer_id, first_name,middle_name, last_name, marital_status,occupation,email,mobile,gender,dob,nominee_id,income_range,alternative_email,alternative_mobile,citizenship,passport_number,passport_type,driving_licence,driving_licence_type,other_td_desc,tax_file_number,australian_business_number,address_id,image,signature,existing_account_number)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
public static final String SQL_SAVE_Card_Type_DETAILS = "insert into Card_Type(card_type__id, card_type__name,card_type_number,card_type_distributed_name) values(?,?,?,?)" ;
public static final String SQL_SAVE_EMPLOYEE_DETAILS = "insert into Employee(employee_id,branch_id,date_of_joining,salary,first_name,last_name,middle_name,address1,address2,email,phone,mobile,gender,dob,created_date,created_by,job_title,job_description) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
public static final String SQL_SAVE_AccountTypes_DETAILS = "insert into Account_Types(account_type_id,account_name,account-desc,min_balance_To_open,min_balance_to_maintain) values(?,?,?,?,?)" ;
public static final String SQL_SAVE_LOAN_DETAILS = "insert into Account_Types(loan_id,interest_rate,start_date,loan_type_id) values(?,?,?,?)" ;

}	
