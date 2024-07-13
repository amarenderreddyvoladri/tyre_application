package com.edubridge.tyre_application.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This Package With Class DBUtils is just to connect with the Database server.
public class DBUtilsForTyre {
	
	public static Connection getConnection() {
		
		Connection con = null;

		String driver, url, user, password;

		driver = "com.mysql.cj.jdbc.Driver";
		url = "jdbc:mysql://localhost/db11976";
		user = "root";
		password = "root";

		// --------------------------------------------------------------------

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// -----------------------------------------------------------------------

		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

		// ------------------------------------------------------------------------

	}
}
