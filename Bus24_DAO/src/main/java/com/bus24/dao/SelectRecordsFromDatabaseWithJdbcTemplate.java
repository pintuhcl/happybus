package com.bus24.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Select records from database with JdbcTemplate is used to perform persistence operations on booking Table
 * 
 * @author vedbhooshan tripathi
 * @since 1.0
 */
public class SelectRecordsFromDatabaseWithJdbcTemplate {
	private static final String driverClassName = "com.mysql.jdbc.Driver";

 	private static final String url = "jdbc:mysql://orcl/bus24";
	private static final String dbUsername = "root";
	private static final String dbPassword = "root";
	private static final String selectSql = "SELECT * FROM booking";
	private static DataSource dataSource;

	public static void main(String[] args) throws Exception {
		/**
		 * this method is used to for connection with database
		 * @return datasource
		 */
dataSource=getDataSource();
JdbcTemplate template = new JdbcTemplate(dataSource);
List<Map<String, Object>> booking = template.queryForList(selectSql);
if (booking!=null && !( booking).isEmpty()) {
for (Map<String, Object> route : booking) {
	for (Iterator<Map.Entry<String, Object>> it = ((Map<String, Object>) booking).entrySet().iterator(); it.hasNext();) {
 Map.Entry<String, Object> entry = it.next();
String key = entry.getKey();
	Object value = entry.getValue();
//System.out.println(key + " = " + value);
	}
	//System.out.println();
	} 
}
	}
	public static DriverManagerDataSource getDataSource() {
		
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
			dataSource.setDriverClassName(driverClassName);
			dataSource.setUrl(url);
		
			dataSource.setUsername(dbUsername);
			dataSource.setPassword(dbPassword);
			/**
			 * @return  the datasource
			 */
		return dataSource;

	}

}
