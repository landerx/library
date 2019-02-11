package com.craftioncode.library.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.ejb.Stateless;

@Stateless
public class DBManager {

	private static String DB_URL = "jdbc:mysql://localhost:3306/jee_library" +
			"?user=root&password=root&autoReconnect=true&useSSL=false&serverTimezone=UTC" +
			"&maxReconnects=10&failOverReadOnly=false&allowPublicKeyRetrieval=true";
	private static String DB_USERNAME = "root";
	private static String DB_PASSWORD = "root";
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	public  Connection openConnection() {
		Connection connection = null;
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public  void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
