package com.InsuranceProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.InsuranceProject.bean.HealthBean;
import com.InsuranceProject.dao.MySqlConnection;

public class HealthDao {
	static Connection con;
	static PreparedStatement ps;
	
	public HealthDao() {
		con = MySqlConnection.getInstance();
	}

	public static int Insertdata(HealthBean ss) {
		int result = 0;
		
		String query = "insert into student values (?,?,?,?,?,?)";
		
		
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, ss.getName());
			ps.setString(2, ss.getAge());
			ps.setString(3, ss.getMobile_no());
			ps.setString(4, ss.getAddress());
			ps.setString(4, ss.getMail_Id());
			ps.setString(4, ss.getHealth_condition());
			
			
			
			result = ps.executeUpdate();	
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
		return result;
	}
	
	public static int DeleteData(HealthBean s) {
		int Result = 0;
		
		String query1 = "delete from Health where Health_Type = ?";
		
		try {
			ps = con.prepareStatement(query1);
			ps.setString(1, s.getName());
			Result = ps.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return Result;
	}
	public static int UpdateData(HealthBean s) {
		int Result = 0;
		String query2= "update from Health set Name = ? where Mail_Id =?";
		try {
			ps= con.prepareStatement (query2);
			ps.setString(1, s.getName());
			Result = ps.executeUpdate();
		} catch (SQLException e) {
					e.printStackTrace();
		}
	
		return Result;
		
	}

}
