package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {

	static Connection con;
	
	public static Connection createConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String username = "root";
			String password= "4486";
			String url = "jdbc:mysql://localhost:3306/demo";
//			jdbc:mysql://localhost:3306/<yourdatabasehere>
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

}
