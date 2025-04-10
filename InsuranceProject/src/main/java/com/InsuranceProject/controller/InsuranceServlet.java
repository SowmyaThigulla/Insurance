package com.InsuranceProject.controller;

import java.io.IOException;
import java.util.UUID;

import com.InsuranceProject.bean.HealthBean;
import com.InsuranceProject.bean.VehicleBean;
import com.InsuranceProject.dao.HealthDao;
import com.InsuranceProject.dao.VehicleDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class InsuranceServlet
 */
@WebServlet("/InsuranceServlet")
public class InsuranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsuranceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Name = request.getParameter("Name");
		String Age = request.getParameter("Age");
		String Mobile_no = request.getParameter("Mobile_no");
		String Address = request.getParameter("Address");
		String Mail_Id = request.getParameter("Mail_id");
		String Health_condition = request.getParameter("Health_condition");
		String uniqueID =   UUID.randomUUID().toString().substring(0, 8).toUpperCase();

		HealthBean s = new HealthBean(); // As we need to use across the project creating the

		s.setName(Name);
		s.setAge(Age);
		s.setMobile_no(Mobile_no);
		s.setAddress(Address);
		s.setMail_Id(Mail_Id);
		s.setHealth_condition(Health_condition);
        s.setUniqueID(uniqueID)	;

		@SuppressWarnings("unused")

		HealthDao rd = new HealthDao();
		int result = HealthDao.Insertdata(s); // we will have value for result

		HttpSession session = request.getSession(); // keeping the session open
		(session).setAttribute("HealthObject", s);

		RequestDispatcher Success = request.getRequestDispatcher("Success.html");
		RequestDispatcher Fail = request.getRequestDispatcher("Fail.html");

		if (result > 0) {
			Success.forward(request, response);
		} else {
			Fail.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Vehicle_Type = request.getParameter("Vehicle_Type");
		String Vehicle_Name = request.getParameter("Vehicle_Name");
		String Vehicle_No = request.getParameter("Vehicle_No");
		String Vehicle_Model = request.getParameter("Vehicle_Model");
		String uniqueID =   UUID.randomUUID().toString().substring(0, 8).toUpperCase();
		VehicleBean a = new VehicleBean();
		
		a.setVehicle_Type(Vehicle_Type);
		a.setVehicle_Name(Vehicle_Name);
		a.setVehicle_Number(Vehicle_No);
		a.setVehicle_Model(Vehicle_Model);
		a.setUniqueID1(uniqueID);
		
	    VehicleDao vd = new VehicleDao();
	    int result = VehicleDao.Insertdata(a);
	    
	    HttpSession session = request.getSession(); // keeping the session open
		(session).setAttribute("VehicleObject", a);

		RequestDispatcher Success = request.getRequestDispatcher("Success.html");
		RequestDispatcher Fail = request.getRequestDispatcher("Fail.html");

		if (result > 0) {
			Success.forward(request, response);
		} else {
			Fail.forward(request, response);
		}
		

	}
		
	
}
