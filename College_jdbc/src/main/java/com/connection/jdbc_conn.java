package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbc_conn {

	public static Connection con;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root", "pruthvi@123");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
		
	}
}
