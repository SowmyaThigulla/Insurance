package com.Insurance.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class InsuranceDao {
	static Connection con;
	static PreparedStatement ps;
	public InsuranceDao() {
		con=MySqlConnection1.getInstance();
		
	}
	public static int Insertdata(HealtheBean s) {
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
			
			
			int result=ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result;
		return result;
	}
	public static int Updatedata(HealtheBean s) {
		String query="UPDATE Health_Insurance SET status = 'Claimed' WHERE policy_id = ?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,s.getpolicyId());
			int result1=ps.executeUpdate();
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
		int result1;
		return result1;
	
	}
			
	}


