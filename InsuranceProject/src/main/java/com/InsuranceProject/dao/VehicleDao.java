package com.InsuranceProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.InsuranceProject.bean.HealthBean;
import com.InsuranceProject.bean.VehicleBean;
import com.InsuranceProject.dao.MySqlConnection;

public class VehicleDao {
	static Connection con;
	static PreparedStatement ps;
	private ResultSet resultset;

	public VehicleDao() {
		con = MySqlConnection.getInstance();
	}

	public static int Insertdata(VehicleBean ss) {
		int result = 0;

		String query = "insert into vehicle values (?,?,?,?,?)";

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, ss.getVehicle_Type());
			ps.setString(2, ss.getVehicle_Name());
			ps.setString(3, ss.getVehicle_Number());
			ps.setString(4, ss.getVehicle_Model());
			ps.setString(5, ss.getUniqueID1());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return result;
	}

	public List<VehicleBean> fetchAllClaimData() {
		List<VehicleBean> claim = new ArrayList<VehicleBean>();
		String query = "select * from Vehicle";
		try {
			ps = con.prepareStatement(query);
			resultset = ps.executeQuery();
			VehicleBean bean = new VehicleBean();
			while (resultset.next()) {

				bean.setUniqueID1(resultset.getString(1));
				claim.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return claim;

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
		String query2 = "update from vehicle set Vehicle_Type = ? where Vehicle_Number =?";
		try {
			ps = con.prepareStatement(query2);
			ps.setString(1, s.getVehicle_Type());
			Result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Result;

	}

}
