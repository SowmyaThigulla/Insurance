package com.Insurance.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {

	private static MySqlConnection mysql = new MySqlConnection();
	Connection con;
	
	private MySqlConnection() {
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance","root","root");
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	
	public static Connection getInstance() {
		return mysql.con;
	}
	
	public static void main(String[] args) {
		System.out.println(MySqlConnection.getInstance());
	}

}
