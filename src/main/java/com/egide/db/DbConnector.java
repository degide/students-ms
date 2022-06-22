package com.egide.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	private String url = "jdbc:mysql://localhost:3306/students_sms";
	private String user = "egide";
	private String password = "dbadmin_123";
	private Connection connection = null;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		if(connection!=null) return connection;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
}
