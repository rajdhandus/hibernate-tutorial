package com.raj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try{
			System.out.println("Connecting to DataBase " + jdbcUrl);
			
			Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection was successful");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
