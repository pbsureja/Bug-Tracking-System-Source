<%@page import="arthinfosoft.bts.dao.ManagerEmployeeDAO"%>
<%@page import="arthinfosoft.bts.bean.EmployeeDetailBean"%>
<%@page import="java.util.List"%>
<%@page import="arthinfosoft.bts.dao.EmployeeDetailDAO"%>
<%@page import="arthinfosoft.bts.bean.ManagerEmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div id="new">
		<hr>
		<center>
			<h1>Manager Employee Edit Form</h1>
		</center>
		<hr>

		<%
			ManagerEmployeeBean bean = (ManagerEmployeeBean) request
					.getAttribute("bean");

			if (bean != null) {
		%>

		<form action="ManagerEmployeeUpdateServlet"
			name="ManagerEmployeeEditPage" id="ManagerEmployeeEditPage"
			method="post">
			<input type="hidden" name="manager_id" id="id"
				value="<%=bean.getManager_id()%>">
			<table align="center">



				<%
					int eid = bean.getEmployee_id();
				%>
				<%
					EmployeeDetailDAO dao_emp = new EmployeeDetailDAO();
						List<EmployeeDetailBean> list_emp = dao_emp.listData();
				%>

				<tr>
					<td>Employee:</td>
					<td><select name="employee_id" id="employee_id">
							<option value=0>--SELECT EMPLOYEE--</option>
							<%
								if (list_emp != null) {
										for (int i = 0; i < list_emp.size(); i++) {
											EmployeeDetailBean bean_emp = (EmployeeDetailBean) list_emp
													.get(i);
											int test = bean_emp.getEmployee_id();
							%>
							<option value="<%=test%>" <%if (eid == test) {%>
								selected="selected" <%}%>>
								<%=bean_emp.getEmployee_firstname() + " "
								+ bean_emp.getEmployee_lastname()%>
								<%
									}
										}
								%>
							
					</select>${employee_id}</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="submit"></td>
			</table>
		</form>
		</div>
<%@include file="footer.jsp"%>
		
		<%
			}
		%>
	
</body>
</html>