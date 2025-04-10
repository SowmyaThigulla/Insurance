<%@page import=" com.InsuranceProject.bean.VehicleBean"%> 
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Data</title>
</head>
<body>
	<h2 align="center">Policy Holder Data</h2>
	<table align="center">
		<%
			Object sessionObj = session.getAttribute("Object");
			if (sessionObj ==null) {
				out.print("No data Found in Database");
			} else {
				List<VehicleBean> vehiclelist = (ArrayList<VehicleBean>) sessionObj;
		%>

		<tr>
			<th>Vehicle_Number</th>
			<th>Vehicle_Name</th>
			<th>Vehicle_Type</th>
			<th>Vehicle_Model</th>
			
		</tr>
		<%
			for (VehicleBean vehicle :  vehiclelist) {
			
		%>
		<tr>
			<td><%=vehicle.getVehicle_Number()%></td>
			<td><%=vehicle.getVehicle_Name()%></td>
			<td><%=vehicle.getVehicle_Type()%></td>
			<td><%=vehicle.getVehicle_Model()%></td>
		</tr>
		<%
			}
			}
		%>
		<tr>
			<td><button>
					<a href="HealthInsurance.html">HomePage</a>
				</button></td>
		</tr>
	</table>
</body>
</html>