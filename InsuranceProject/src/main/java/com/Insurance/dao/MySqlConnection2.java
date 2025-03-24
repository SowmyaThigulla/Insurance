package com.Insurance.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection2 {

	private static MySqlConnection2 mysql = new MySqlConnection2();
	Connection con;
	
	private MySqlConnection2() {
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Vehicle_Insurance","root","root");
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	
	public static Connection getInstance() {
		return mysql.con;
	}
	
	public static void main(String[] args) {
		System.out.println(MySqlConnection2.getInstance());
	}

}
