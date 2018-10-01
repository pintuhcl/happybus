package com.bus24.dao.util;

public class SQLConstants {
	public static final String SQL_INSERT_OTP = "insert into otplog(otp,generated_time,user_id) values(?,?,?)";
	public static final String SQL_GET_PASSWORD = "select password from user where user_name=?";
	public static final String SQL_GET_USER_DETAILS = "select user_id,user_role,mobile,status from user where user_name=?";
	public static final String SQL_SAVE_TOKEN = "insert into user_authentication(token,user_id,status) values(?,?,?)";

	/**
	 * this query is used to save the amenities into Amenities table
	 */
	public static final String SQL_INSERT_AMENITY = "insert into amenity(amenity_id,amenity_name) values(?,?)";
	public static final String SQL_UPDATE_AMENITY = "update amenity set amenity_name=? where amenity_id=?";

	public static final String SQL_SELECT_ALL_AMENITY = "select amenity_id,amenity_name from amenity";
	public static final String SQL_SELECT_AMENITY_BY_BUSID = "select a.amenity_id,a.amenity_name from amenities a join bus_amenities b on a.amenity_id=b.amenity_id where bus_id=?";

	/**
	 * this select the bus information to for super-admin
	 */
	public static final String SQL_SELECT_BUS_FOR_ADMIN_BY_TRAVELID = "select bus_id,bus.travel_id,travel_name,reg_no,bus.status,bus_type_name,bus_model,layout_model,no_of_seats,layout_type,layout_desc from bus join bus_types on bus.bus_type_id=bus_types.bus_type_id left join travels on bus.travel_id=travels.travel_id where bus.travel_id=?";

	public static final String SQL_GET_SHOW_MYPROFILE = "select user_name,user_role,mobile,first_name,last_name,address,zipcode,user_id,email,status from user where user_name=?";
	public static final String SQL_GET_UPDATE_MYPROFILE = "update user set first_name=?,last_name=?,address=?,zipcode =? where user_id=?";

	public static final String SQL_IS_AUTHENTICATED = "select count(user_id) from user_authentication where user_id=? and token=? and status=?";

	/**
	 * this query select get all travel from "travel" table
	 */
	public static final String SQL_SELECT_ALL_TRAVEL = "select travel_id,travel_name,travel_reg_num,website,city,state,zipcode,phonenumber1,phonenumber2,addressline1,addressline2 from travels order by travel_name";
	/**
	 * this query is used to search for travel from Travels table
	 * 
	 * @author Eshwar,Abdul
	 */
	public static final String SEARCH_TRAVELS_DETAILS = "SELECT T.TRAVEL_ID,T.TRAVEL_NAME,T.TRAVEL_REG_NUM,T.WEBSITE,T.CITY,T.STATE,T.ZIPCODE,T.STATUS,"
			+ "T.PHONENUMBER1,T.PHONENUMBER2,T.ADDRESSLINE1 ,T.ADDRESSLINE2,B.BANK_ACC_ID,B.BANK_ACC_NO,B.IFSC_CODE,B.BANK_NAME,"
			+ "B.BRANCH_NAME,B.ACC_HOLDER_NAME FROM TRAVELS AS T  INNER JOIN BANKDETAILS  B ON  T.BANK_ACC_ID=B.BANK_ACC_ID "
			+ "WHERE (T.TRAVEL_NAME IS NOT NULL AND T.TRAVEL_NAME LIKE ?) OR (T.CITY IS NOT NULL AND CITY LIKE ?) ORDER BY TRAVEL_NAME";

	/**
	 * this query is used to Booking tickts
	 * 
	 * @author 9752696735
	 */
	public static final String SQL_BOOKING_RETRIEVE_BOARDING_DROPPING = "select boarding_points,dropping_points,price from routes where route_id=?";

	/**
	 * this query is used to Search Agent
	 * 
	 * @author Damodar,sekhar
	 */
	public static final String SEARCH_AGENT_SQL = "select a.agent_id,a.agency_name,a.agent_reg_no,a.phoneNumber1,a.phoneNumber2,a.email,a.addressLine1,a.addressLine2,a.city,a.state,a.idcard,a.status ,b.bank_acc_no,b.acc_holder_name,b.ifsc_code,b.bank_name,b.branch_name from agents a,bankdetails b,user u where a.user_id=u.user_id and a.bank_acc_id=b.bank_acc_id and agency_name=?";

	/**
	 * this query is used to select user of specific user
	 */
	public static final String SELECT_USER_SQL = "select mobile from user where user_id=?";

	public static final String EDIT_AGENT_SQL = "update agents set agency_name=?,agent_reg_no=?,phoneNumber1=?,phoneNumber2=?,email=?,addressLine1=?,addressLine2=?,city=?,state=?,idcard=?,status=?,bank_acc_no=? where agent_id=?";
	public static final String EDIT_AGENT_BANK_SQL = "update bankdetails set bank_acc_no=?,acc_holder_name=?,ifsc_code=?,bank_name=?,branch_name=? where bank_acc_id=?";

	/**
	 * This query is used to search buses for passenger
	 * 
	 * @author Mulayam
	 */

	// public static final String SQL_SELECT_BUS_FOR_PASSENGER = "select
	// tl.travel_id,tl.travel_name, b.bus_id,bt.no_of_seats, "
	// + "(bt.no_of_seats-(select sum(bookings.number_of_passengers) as
	// route_id"
	// + " from bookings where bookings.route_id=rt.route_id group by
	// bookings.route_id)"
	// + ") as no_of_avaible_seats,rt.route_id,rt.source,rt.destination,"
	// + "rt.departure_time,rt.arrival_time,rt.boarding_points,"
	// + "rt.dropping_points,rt.distance,rt.price,rt.via,bt.bus_type_name,"
	// + "bt.bus_model,bt.layout_model,bt.layout_desc from routes rt "
	// + "left join bus b on rt.bus_id=b.bus_id "
	// + "left join bus_types bt on b.bus_type_id=bt.bus_type_id "
	// + "left join travels tl on tl.travel_id=b.travel_id where "
	// + "rt.source='hyderabad' and rt.destination='banglore'";

		public static final String SQL_SELECT_BUS_FOR_PASSENGER = "select tl.travel_id,tl.travel_name, b.bus_id,bt.no_of_seats, "
				+ "(bt.no_of_seats-(select sum(bookings.number_of_passengers)  as no_of_passenger"
				+ " from bookings where  bookings.route_id=rt.route_id  and date_format(rt.departure_time,'%Y-%m-%d')=?  group by bookings.route_id)"
				+ ") as no_of_avaible_seats,rt.route_id,rt.source,rt.destination,"
				+ "date_format(rt.departure_time,'%H:%i') as 'departure_time',rt.arrival_time,rt.boarding_points,"
				+ "rt.dropping_points,rt.distance,rt.price,rt.via,bt.bus_type_name,"
				+ "bt.bus_model,bt.layout_model,bt.layout_description,bt.layout_type,round(time_to_sec(timediff(rt.arrival_time,rt.departure_time))/3600) as total_time from routes  rt "
				+ "left join bus b on rt.bus_id=b.bus_id " + "left join bus_types bt on b.bus_type_id=bt.bus_type_id "
				+ "left join travels tl on tl.travel_id=b.travel_id " + " where rt.source=? and rt.destination=?and date_format(rt.departure_time,'%Y-%m-%d')=?";

	public static final String SQL_SAVE_BUSTYPE = null;
	public static final String SQL_ADD_ROUTE = "insert into routes (bus_id, travel_id,source,destination,date_of_journey,via,distance,departure_time,arrival_time,boarding_points,dropping_points,status, service_no, price) values (?,?,?, ?,?,?, ?,?,?, ?,?,?, ?,?)";

	public static final String SQL_UPDATE_USER_STATUS = "update user set status=? where user_id=?";
	public static final String SQL_FORGOT_VERIFY = "select user_id,status,mobile,email from user where email=? or mobile=?";
	/**
	 * @author Rakhi
	 */
	public static final String SQL_INSERT_INSURANCE_COMPANY = "insert into insurance(company_name,travel_id,amount)values(?,?,?)";
	public static final String SQL_SELECT_ALL_INSURANCE_COMPANY = "select company_id,company_name,amount,t.travel_id,travel_name from insuracne i join  travel t on t.travel_id=i.travel_id";
	public static final String SQL_SELECT_INSURANCE_COMPANY_BY_TRAVELID = "select company_id,company_name,amount,t.travel_id,travel_name from insuracne i join  travel t on t.travel_id=i.travel_id where t.travel_id=?";

	public static final String SQL_CHANGE_PASSWORD = "update user set password=? where user_name=?";

	/**
	 * 
	 */

		public static final String SQL_INSERT_ISSUE = "insert into issue(issue_id,issue_name)values(?,?)";
	public static final String SQL_SELECT_ALL_ISSUE = "select issue_id,issue_name from issue";

	/**
	 * This query is used for Search Bookings by All Travles
	 * 
	 * @author Sindhu & Pavani
	 */
	public static final String SQL_SEARCH_BOOKINGS_BY_ALL_TRAVELS = "select b.booking_id,b.booking_date,b.date_of_journey,"
			+ "b.number_of_passengers,b.final_fare,t.travel_id,t.travel_name,r.route_id,r.source,"
			+ "r.destination,r.distance,r.arrival_time,r.departure_time from bookings b "
			+ "inner join travels t on b.travel_id=t.travel_id " + "inner join routes r on b.route_id=r.route_id ";
	// + "order by t.travel_name";

	/**
	 * This query is used for Search Bookings by specific Travle_id
	 * 
	 * @author Sindhu & Pavani
	 */
	public static final String SQL_SEARCH_BOOKINGS_BY_TRAVEL_ID = "select b.booking_id,b.booking_date,b.date_of_journey,"
			+ "b.number_of_passengers,b.final_fare,t.travel_id,t.travel_name,r.route_id,r.source,"
			+ "r.destination,r.distance,r.arrival_time,r.departure_time from bookings b "
			+ "inner join travels t on b.travel_id=t.travel_id " + "inner join routes r on b.route_id=r.route_id "
			+ "where t.travel_id=? " + "order by t.travel_name";
	/**
	 * This query is used for Search Bookings by Using From and To Date
	 * 
	 * @author Sindhu & Pavani
	 */
	public static final String SQL_SEARCH_BOOKINGS_BY_USING_FROM_TO_DATE = "select b.booking_id,b.booking_date,b.date_of_journey,"
			+ "b.number_of_passengers,b.final_fare,t.travel_id,t.travel_name,r.route_id,r.source,"
			+ "r.destination,r.distance,r.arrival_time,r.departure_time from bookings b "
			+ "inner join travels t on b.travel_id=t.travel_id " + " " + "inner join routes r on b.route_id=r.route_id "
			+ " " + "where b.date_of_journey >=? and b.date_of_journey<=? " + " " + "order by t.travel_name";
	/**
	 * This query is used for Search Bookings by using Travle_id,From and To
	 * Date
	 * 
	 * @author Sindhu & Pavani
	 */
	public static final String SQL_SEARCH_BOOKINGS_BY_USING_TRAVEL_ID_FROM_AND_TO_DATE = "select b.booking_id,b.booking_date,b.date_of_journey,"
			+ "b.number_of_passengers,b.final_fare,t.travel_id,t.travel_name,r.route_id,r.source,"
			+ "r.destination,r.distance,r.arrival_time,r.departure_time from bookings b "
			+ "inner join travels t on b.travel_id=t.travel_id " + "inner join routes r on b.route_id=r.route_id "
			+ "where t.travel_id=? and b.date_of_journey >=? and b.date_of_journey<=? " + " "
			+ "order by t.travel_name";

	public static final String SQL_UPDATE_LOGOUT_STATUS = "update loginlog set logout_status=? where user_id=?";
	public static final String SQL_INSERT_LOGINLOG = "insert into loginlog(user_id,login_time,user_agent,ipaddress,logout_status,session_id) values(?,?,?,?,?,?)";

	public static final String SQL_CHECK_EMAIL = "select count(email) from user where email like ?";
	public static final String SQL_CHECK_MOBILE = "select count(mobile) from user where mobile like ?";

	/**
	 * @author Lokesh
	 */
	public static final String SQL_INSERT_COUPON = "insert into coupon(coupon_code,coupon_discount,coupon_status,user_id) values(?,?,?,?)";
	public static final String SQL_SELECT_ALL_COUPONS = "select coupon_id,coupon_code,coupon_discount,generated_date,coupon_status from coupon";
	public static final String SQL_SELECT_ROLE = "select user_role from user where userId=?";

	/**
	 * This query is used for Report generation related to payment table
	 * 
	 * @author Suchitra
	 */
	public static final String SQL_SELECT_ALL_FOR_SUPERADMIN_FROM_N_TO = "select payment_id,payment_time,transaction_id,user_id,payment_by,bank_acc_id,amount,status from payment where Date_format(payment_time,'%Y-%m-%d') between ? and ?";// between
																																																												// '2017-06-28'
																																																												// and
																																																												// '2017-07-06'"
	public static final String SQL_SELECT_ALL_FOR_SUPERADMIN_MONTHLY = "select payment_id,payment_time,transaction_id,user_id,payment_by,bank_acc_id,amount,status from payment where date_format(payment_time,'%m')=?";// 7

	/**
	 * This query is used to insert the passenger details into passenger table
	 * 
	 * @author mulayam
	 * 
	 */
	public static final String SQL_INSERT_PASSENGERS = "insert into passenger (name,gender,age,seat_no,booking_id,status) values(?,?,?,?,?,0)";

	/**
	 * This query is used to insert booking details in Bookings table
	 * 
	 * @author mulayam
	 */
	public static final String SQL_INSERT_BOOKING = "insert into bookings(user_id,route_id,travel_id,payment_id,"
			+ "coupon_id,date_of_journey," + "boarding_point,dropping_point,ticket_no,"
			+ "booking_date,number_of_passengers,final_fare,status) values(?,?,?,null,null,?,?,?,?,now(),?,?,0)";

	/**
	 * This query is used to select all passenger of specific routeId
	 * 
	 * @author mulayam
	 */
	public static final String SQL_SELECT_PASSENGER_BY_ROUTE_ID = "select passenger_id,name,gender,age,seat_no,booking_id,status from passenger  where booking_id in(select booking_id from bookings where route_id=?)";
	/**
	 * This query is used to select route of specific routeId
	 * 
	 * @author mulayam
	 */
	public static final String SQL_SELECT_ROUTE_BY_ROUTE_ID = "select bus_id,route_id,travel_id,source,destination,departure_time,arrival_time,boarding_points,dropping_points,price from  routes where route_id=?";
	public static String SQL_SELECT_ALL_SOURCES = "select distinct source from routes";
	public static String SQL_SELECT_ALL_DESTINATION = "select distinct destination from routes";

	public static final String SQL_DELETE_OTP = "delete from otplog where DATEDIFF(now(),generated_time)>=?";

	/**
	 * This query is used to search route and edit route
	 */
	public static final String SQL_ROUTE_DETAILS = "select bus_id,route_id,source,destination,distance,departure_time,arrival_time,boarding_points,dropping_points,status,service_no,price,via,travel_id  from routes where source=?";

	public static final String SQL_ROUTE_EDIT = "update route set bus_id=?,travel_id=?,source=?,destination=?,date_of_journey=?,via=?,distance=?,departure_time=?,arrival_time=?,boarding_time=?,dropping_time=?,status=?,service_no=?,price=? where source=?";

}
