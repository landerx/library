package com.craftioncode.library.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

	private static String DB_URL = "jdbc:mysql://localhost:3306/jee_library" +
			"?user=root&password=root&autoReconnect=true&useSSL=false&serverTimezone=UTC" +
			"&maxReconnects=10&failOverReadOnly=false";
	private static String DB_USERNAME = "root";
	private static String DB_PASSWORD = "root";
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	public static Connection openConnection() throws Exception {
		Class.forName(JDBC_DRIVER).newInstance();
		return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	}



}
