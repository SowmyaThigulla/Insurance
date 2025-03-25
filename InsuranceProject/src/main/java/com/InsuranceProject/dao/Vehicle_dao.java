package com.InsuranceProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.InsuranceProject.bean.StudentBean;
import com.InsuranceProject.dao.MySqlConnection;

public class Vehicle_dao {
	static Connection con;
	static PreparedStatement ps;
	
	public Vehicle_dao() {
		con = MySqlConnection.getInstance();
	}

	public static int Insertdata(VehicleBean ss) {
		int result = 0;
		
		String query = "insert into student values (?,?,?,?)";
		
		
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, ss.getVechile_Type());
			ps.setString(2, ss.getVechile_Name());
			ps.setString(3, ss.getVechile_No());
			ps.setString(4, ss.getVechile_Model());
			
			
			result = ps.executeUpdate();	
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
		return result;
	}
	
	public static int DeleteData(VehicleBean s) {
		int Result = 0;
		
		String query1 = "delete from vehicle where Vechile_Type = ?";
		
		try {
			ps = con.prepareStatement(query1);
			ps.setString(1, s.getVechile_Type());
			Result = ps.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return Result;
	}
	public static int UpdateData(VehicleBean s) {
		int Result = 0;
		String query2= "update from vehicle set Vechile_Type = ? where Vechile_No =?";
		try {
			ps= con.prepareStatement (query2);
			ps.setString(1, s.getVechile_Type());
			Result = ps.executeUpdate();
		} catch (SQLException e) {
					e.printStackTrace();
		}
	
		return Result;
		
	}

}
