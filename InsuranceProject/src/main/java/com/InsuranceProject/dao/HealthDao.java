package com.InsuranceProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import com.InsuranceProject.bean.HealthBean;

public class HealthDao {
	static Connection con;
	static PreparedStatement ps;
	private ResultSet result;
	
	public HealthDao() {
		con = MySqlConnection.getInstance();
	}

	public static int Insertdata(HealthBean ss) {
		int result = 0;
		
		String query = "INSERT INTO health VALUES (?, ?, ?, ?, ?, ?,?)"; 

		
		
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, ss.getName());
			ps.setString(2, ss.getAge());
			ps.setString(3, ss.getMobile_no());
			ps.setString(4, ss.getAddress());
			ps.setString(5, ss.getMail_Id());
			ps.setString(6, ss.getHealth_condition());
			ps.setString(7, ss.getUniqueID());
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
		return result;
		
	}
	
	public List<HealthBean> fetchAllClaimData() {
		List<HealthBean> claim = new ArrayList<HealthBean>();
		String query = "select * from health";
		try {
			ps = con.prepareStatement(query);
			result = ps.executeQuery();
			HealthBean healthbean = new HealthBean();
			while(result.next()) {
				
				healthbean.setUniqueID(result.getString(1));
				claim.add(healthbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return claim ;
		
	}
	
	public static int DeleteData(HealthBean s) {
		int Result = 0;
		
		String query1 = "delete from health where Health_Type = ?";
		
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
		String query2= "update from health set Name = ? where Mail_Id =?";
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
