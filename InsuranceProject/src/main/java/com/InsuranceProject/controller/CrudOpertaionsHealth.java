package com.InsuranceProject.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.InsuranceProject.bean.HealthBean;
import com.InsuranceProject.dao.HealthDao;

/**
 * Servlet implementation class CrudOpertaions
 */
@WebServlet("/CrudOpertaionsHealth")
public class CrudOpertaionsHealth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudOpertaionsHealth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String health_type = request.getParameter("Health_Type");
		HealthBean s = new HealthBean();
		s.setName(health_type);
		 HealthDao m = new HealthDao();
	        int result = m.DeleteData(s);  

	       
	       HttpSession session =request.getSession();
	       session.setAttribute("HealthObject", s);

	       
	       RequestDispatcher successDispatcher =  request.getRequestDispatcher("Success.html");
	      RequestDispatcher failDispatcher = request.getRequestDispatcher("Fail.html");

	        if (result > 0) {
	            successDispatcher.forward(request, response);
	        } else {
	            failDispatcher.forward(request, response);
	        }
	       
	        
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Mail_Id = request.getParameter("Mail_id");
		
		HealthBean bean = new HealthBean();
		bean.setMail_Id(Mail_Id);
		
		HealthDao dao = new HealthDao();
		int result = dao.UpdateData(bean);
		
		HttpSession session = request.getSession();
	      session.setAttribute("Object",bean);
	      
	      RequestDispatcher SuccessDispatcher = request.getRequestDispatcher("Success.html");
	     RequestDispatcher failDispatcher = request.getRequestDispatcher("Fail.html");
	     
	      if (result>0) {
	    	  SuccessDispatcher.forward(request, response);
	      }
	      else {
	    	  failDispatcher.forward(request,response);
	      }
		
		doGet(request, response);
	}

}
