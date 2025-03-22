package com.InsuranceProject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String Mobileno = request.getParameter("Mobileno");
		String Address = request.getParameter("Address");
		String Email = request.getParameter("Email");
		String Tech = request.getParameter("Tech");
		String College = request.getParameter("College");

		StudentBean s = new StudentBean(); // As we need to use across the project creating the

		s.setName("Name");
		s.setMobileno("Mobileno");
		s.setAddress("Address");
		s.setEmail("Email");
		s.setTech("Tech");
		s.setCollege("College");

		@SuppressWarnings("unused")

		StudentDao rd = new StudentDao();
		int result = StudentDao.Insertdata(s); // we will have value for result

		HttpSession session = request.getSession(); // keeping the session open
		(session).setAttribute("StudentObject", s);

		RequestDispatcher Success = request.getRequestDispatcher("Success.html");
		RequestDispatcher Fail = request.getRequestDispatcher("Fail.html");

		if (result > 0) {
			Success.forward(request, response);
		} else {
			Fail.forward(request, response);
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
