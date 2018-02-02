package com.luv2code.jdbc;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class TestJdbc {

	public static void main(String[] args) {
		
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
			String user = "hbstudent";
			String password = "hbStudent123+";
			
			System.out.println("Connecting to the database ... " + jdbcUrl);
			java.sql.Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("Connection successfull");
			
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}

	}

}
