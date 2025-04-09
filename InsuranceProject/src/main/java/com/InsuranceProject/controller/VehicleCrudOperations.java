package com.InsuranceProject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.InsuranceProject.bean.VehicleBean;
import com.InsuranceProject.dao.VehicleDao;

/**
 * Servlet implementation class VehicleCrudOperations
 */
@WebServlet("/VehicleCrudOperations")
public class VehicleCrudOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleCrudOperations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vehicle_type =request.getParameter("Vehicle_Type");
		VehicleBean vb = new VehicleBean();
		vb.setVehicle_Type(vehicle_type);
		VehicleDao vd = new VehicleDao();
		int result = vd.DeleteData(vb);
		javax.servlet.http.HttpSession session = request.getSession();
				session.setAttribute("Object",vb);
				javax.servlet.RequestDispatcher successDispatcher = request.getRequestDispatcher("Success.html");
				javax.servlet.RequestDispatcher failDispatcher = request.getRequestDispatcher("Fail.html");
				if(result<0) {
					successDispatcher.forward(request, response);
				}
				else {
					failDispatcher.forward(request, response);
				}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Vehicle_Number = request.getParameter("Vehicle_number");
		VehicleBean vehicle = new VehicleBean();
		
		vehicle.setVehicle_Number(Vehicle_Number);
		
		VehicleDao x = new VehicleDao();
		int result =x.UpdateData(vehicle);
		
				javax.servlet.http.HttpSession session = request.getSession();
		session.setAttribute("AKhil",vehicle);
		
		javax.servlet.RequestDispatcher successDispatcher = request.getRequestDispatcher("Success.html");
		javax.servlet.RequestDispatcher failDispatcher = request.getRequestDispatcher("Fail.html");
		
		if (result<0) {
			successDispatcher.forward(request, response);
		}
		else {
			failDispatcher.forward(request,response);
		}

}
}
