<%@page import="arthinfosoft.bts.bean.EmployeeDetailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<form action="" name="ListPage" method="post">
		<input type="hidden" name="tid" id="tid">
		<table border="1">

			<u> Employee Detail Page </u>
			<%
				EmployeeDetailBean bean = (EmployeeDetailBean) request
						.getAttribute("bean");
			%>
<tr><a href="Employee_DetailListServlet">Back</a>
			<tr>
				<th>Email
				<td><%=bean.getEmail()%></td>
			<tr>
				<th>Password
				<td><%=bean.getPassword()%></td>
			<tr>
				<th>Security_question
				<td><%=bean.getSecurity_question()%></td>
			<tr>
				<th>Answer
				<td><%=bean.getAnswer()%></td>
			<tr>
				<th>Employee_firstname
				<td><%=bean.getEmployee_firstname()%></td>
			<tr>
				<th>Employee_lastname
				<td><%=bean.getEmployee_lastname()%></td>
			<tr>
				<th>Permanent_address
				<td><%=bean.getPermanent_address()%></td>
			<tr>
				<th>Temporary_address
				<td><%=bean.getTemporary_address()%></td>
			<tr>
				<th>Mobile
				<td><%=bean.getMobile()%></td>
			<tr>
				<th>Landline
				<td><%=bean.getLandline()%></td>
			<tr>
				<th>Dateofbirth
				<td><%=bean.getDateofbirth()%></td>
			<tr>
				<th>Designation
				<td><%=bean.getDesignation()%></td>
			<tr>
				<th>Joining_date
				<td><%=bean.getJoining_date()%></td>
			<tr>
				<th>Is Active
				<td><%=bean.getIs_active()%></td>
			<tr>
				<th>Role
				<td><%=bean.getRebean().getRole_Description()%></td>
			<tr>
				<th>Department
				<td><%=bean.getDbean().getDepartment_description()%></td>
			<tr>
				<th>Manager
				<td><%=bean.getManager_id()%></td>
			<tr>
				<th>Salary
				<td><%=bean.getSalary()%></td>
		</table>

	</form>

</body>
</html>