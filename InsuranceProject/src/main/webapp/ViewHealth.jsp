<%@page import=" com.InsuranceProject.bean.HealthBean"%> 
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
			if (sessionObj == null) {
				out.print("No data Found in Database");
			} else {
				List<HealthBean> healthlist = (ArrayList<HealthBean>) sessionObj;
		%>

		<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Mail_Id</th>
			<th>Mobile_No</th>
			<th>Address</th>
			<th>Health_condition</th>
			
		</tr>
		<%
			for (HealthBean health :  healthlist) {
			
		%>
		<tr>
			<td><%=health.getName()%></td>
			<td><%=health.getAge()%></td>
			<td><%=health.getMail_Id()%></td>
			<td><%=health.getMobile_No()%></td>
			<td><%=health.getAddress()%></td>
			<td><%=health.getHealth_condition()%></td>
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