package com.InsuranceProject.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.InsuranceProject.bean.HealthBean;
public class InsuranceDao {
	static Connection con;
	static PreparedStatement ps;
	public InsuranceDao() {
		con=MySqlConnection.getInstance();
		
	}
	public static int Insertdata(HealthBean s) {
		int result =0;
		String query="INSERT INTO Health_Insurance (Name,Age,Mobile_No,Address,Mail_Id,Health_condition) VALUES (?,?,?,?,?,?)";

		try {
			ps=con.prepareStatement(query);
			  // Use setInt() for integer values
			ps.setString(1,s.getName());
			ps.setString(2,s.getAge());
			ps.setString(3,s.getMobile_no());
			ps.setString(4, s.getAddress());
			ps.setString(5, s.getMail_Id());
			ps.setString(6, s.getHealth_condition());
		
			result=ps.executeUpdate();
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public static int Updatedata(HealthBean s) {
		int result1 =0;
		String query1="UPDATE Health_Insurance SET status = 'Claimed' WHERE policy_id = ?";
		try {
			ps=con.prepareStatement(query1);
			ps.setString(1,s.getName());
			
			 result1=ps.executeUpdate();
			 
			if (result1 > 0) {
                System.out.println("Insurance policy claimed successfully.");
            } else {
                System.out.println("Policy ID not found.");
            }
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result1;
	
	}
			
	}


