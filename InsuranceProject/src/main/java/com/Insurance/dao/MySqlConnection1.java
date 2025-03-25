package com.Insurance.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection1 {

	private static MySqlConnection1 mysql = new MySqlConnection1();
	Connection con;
	
	private MySqlConnection1() {
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Health_Insurance","root","root");
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	
	public static Connection getInstance() {
		return mysql.con;
	}
	
	public static void main(String[] args) {
		System.out.println(MySqlConnection1.getInstance());
	}

}
