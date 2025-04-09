package com.InsuranceProject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.InsuranceProject.bean.HealthBean;
import com.InsuranceProject.bean.VehicleBean;
import com.InsuranceProject.dao.HealthDao;
import com.InsuranceProject.dao.VehicleDao;

/**
 * Servlet implementation class InsuranceClaim
 */
@WebServlet("/InsuranceClaim")  // Fixed naming
public class InsuranceClaim extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public InsuranceClaim() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String policy_Id = request.getParameter("Policy_Id");
       
        // Creating the HealthBean object and setting values
        HealthBean healthBean = new HealthBean();
        
        healthBean.setName(policy_Id);
        
        // Insert data using HealthDao instance
        HealthDao healthDao = new HealthDao();
        int result = healthDao.Insertdata(healthBean);  

        // Keeping the session open
        HttpSession session = request.getSession();
        session.setAttribute("HealthObject", healthBean);

        // Forwarding to Success or Fail page based on result
       RequestDispatcher successDispatcher = request.getRequestDispatcher("Success.html");
        RequestDispatcher failDispatcher = request.getRequestDispatcher("Fail.html");

        if (result > 0) {
            successDispatcher.forward(request, response);
        } else {
            failDispatcher.forward(request, response);
        }
        
 
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String Vehicle_Type = request.getParameter("Vehicle_Type");
		
		
		VehicleBean a = new VehicleBean();
		
		a.setVehicle_Type(Vehicle_Type);
		
		
	    VehicleDao vd = new VehicleDao();
	    int result =  VehicleDao.Insertdata(a);
	    
	    HttpSession session = request.getSession(); // keeping the session open
		(session).setAttribute("VehicleObject", a);

		RequestDispatcher Success = request.getRequestDispatcher("Success.html");
		RequestDispatcher Fail = request.getRequestDispatcher("Fail.html");

		if (result > 0) {
			Success.forward(request, response);
		} else {
			Fail.forward(request, response);
		}
		doGet(request, response);
    }
}
