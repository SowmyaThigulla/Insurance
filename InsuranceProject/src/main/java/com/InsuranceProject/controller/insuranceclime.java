package com.InsuranceProject.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class InsuranceClaim
 */
@WebServlet("/insuranceclaim")  // Fixed naming
public class insuranceclime extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public insuranceclime() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HealthDao dbo=new HealthDao();

		List<HealthBean> result =dbo.fetchAllClaimData();

		

		HttpSession session= request.getSession();

		session.setAttribute("EmployeeObject", result);

		

		RequestDispatcher reqdispatcher=request.getRequestDispatcher("Success.html");

		reqdispatcher.forward(request, response);

		

	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	VehicleDao dbo=new VehicleDao();

		List<VehicleBean> result =dbo.fetchAllClaimData();

		

		HttpSession session= request.getSession();

		session.setAttribute("EmployeeObject", result);

		

		RequestDispatcher reqdispatcher=request.getRequestDispatcher("Success.html");

		reqdispatcher.forward(request, response);
    	
    }
}
