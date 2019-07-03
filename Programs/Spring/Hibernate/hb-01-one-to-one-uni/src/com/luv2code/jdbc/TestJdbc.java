package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
		String userName = "postgres";
		String passWord = "Rolta@123";
		try {
			System.out.println("Connection to database :"+jdbcUrl);
			
			Connection myconn = DriverManager.getConnection(jdbcUrl, userName, passWord);
			System.out.println("Connection Successful");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}

	}

}
