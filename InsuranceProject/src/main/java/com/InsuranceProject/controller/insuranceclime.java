package com.InsuranceProject.controller;

import java.io.IOException;

import com.InsuranceProject.bean.HealthBean;
import com.InsuranceProject.bean.VehicleBean;
import com.InsuranceProject.dao.HealthDao;
import com.InsuranceProject.dao.VehicleDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsuranceClaim
 */
@WebServlet("/insuranceclaim")  // Fixed naming
public class insuranceclime extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public insuranceclime() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uniqueID = request.getParameter("uniqueID");
//        String name = request.getParameter("Name");
//        String age = request.getParameter("Age");
//        String mobileNo = request.getParameter("Mobile_no");
//        String address = request.getParameter("Address");
//        String mailId = request.getParameter("Mail_id");
//        String healthCondition = request.getParameter("Health_condition");

        // Creating the HealthBean object and setting values
        HealthBean healthBean = new HealthBean();
        healthBean.setuniqueID(uniqueID);
//        healthBean.setAge(age);
//        healthBean.setMobile_no(mobileNo);
//        healthBean.setAddress(address);
//        healthBean.setMail_Id(mailId);
//        healthBean.setHealth_condition(healthCondition);

        // Insert data using HealthDao instance
        HealthDao healthDao = new HealthDao();
        int result = healthDao.Insertdata(healthBean);  

        // Keeping the session open
        jakarta.servlet.http.HttpSession session = request.getSession();
        session.setAttribute("HealthObject", healthBean);

        // Forwarding to Success or Fail page based on result
        jakarta.servlet.RequestDispatcher successDispatcher = request.getRequestDispatcher("Success.html");
        jakarta.servlet.RequestDispatcher failDispatcher = request.getRequestDispatcher("Fail.html");

        if (result > 0) {
            successDispatcher.forward(request, response);
        } else {
            failDispatcher.forward(request, response);
        }
        
 
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uniqueID1 = request.getParameter("uniqueID1");
//		String Vehicle_Name = request.getParameter("Vehicle_Name");
//		String Vehicle_No = request.getParameter("Vehicle_No");
//		String Vehicle_Model = request.getParameter("Vehicle_Model");
		
		VehicleBean a = new VehicleBean();
		
		a.setuniqueID1(uniqueID1);
//		a.setVehicle_Name(Vehicle_Name);
//		a.setVehicle_Number(Vehicle_No);
//		a.setVehicle_Model(Vehicle_Model);
		
	    VehicleDao vd = new VehicleDao();
	    int result =  VehicleDao.Insertdata(a);
	    
	    jakarta.servlet.http.HttpSession session = request.getSession(); // keeping the session open
		(session).setAttribute("VehicleObject", a);

		jakarta.servlet.RequestDispatcher Success = request.getRequestDispatcher("Success.html");
		jakarta.servlet.RequestDispatcher Fail = request.getRequestDispatcher("Fail.html");

		if (result > 0) {
			Success.forward(request, response);
		} else {
			Fail.forward(request, response);
		}
		doGet(request, response);
    }
}
