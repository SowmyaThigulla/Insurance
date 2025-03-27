package com.InsuranceProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.InsuranceProject.bean.VehicleBean;
import com.InsuranceProject.dao.MySqlConnection;

public class VehicleDao {
	static Connection con;
	static PreparedStatement ps;
	
	public VehicleDao() {
		con = MySqlConnection.getInstance();
	}

	public static int Insertdata(VehicleBean ss) {
		int result = 0;
		
		String query = "insert into student values (?,?,?,?)";
		
		
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, ss.getVehicle_Type());
			ps.setString(2, ss.getVehicle_Name());
			ps.setString(3, ss.getVehicle_Number());
			ps.setString(4, ss.getVehicle_Model());
			
			
			result = ps.executeUpdate();	
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
		return result;
	}
	
	public static int DeleteData(VehicleBean s) {
		int Result = 0;
		
		String query1 = "delete from vehicle where Vehicle_Type = ?";
		
		try {
			ps = con.prepareStatement(query1);
			ps.setString(1, s.getVehicle_Type());
			Result = ps.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		return Result;
	}
	public static int UpdateData(VehicleBean s) {
		int Result = 0;
		String query2= "update from vehicle set Vehicle_Type = ? where Vehicle_Number =?";
		try {
			ps= con.prepareStatement (query2);
			ps.setString(1, s.getVehicle_Type());
			Result = ps.executeUpdate();
		} catch (SQLException e) {
					e.printStackTrace();
		}
	
		return Result;
		
	}

}
