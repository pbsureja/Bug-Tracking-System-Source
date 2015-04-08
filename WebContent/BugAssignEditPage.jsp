<%@page import="arthinfosoft.bts.bean.EmployeeDetailBean"%>
<%@page import="arthinfosoft.bts.dao.EmployeeDetailDAO"%>
<%@page import="arthinfosoft.bts.bean.Bug_DetailsBean"%>
<%@page import="java.util.List"%>
<%@page import="arthinfosoft.bts.dao.Bug_DetailsDAO"%>
<%@page import="arthinfosoft.bts.bean.BugAssignBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bug Assign Edit Page</title>
<link rel="stylesheet"
	href="jquery-ui-1.10.4.custom/css/start/jquery-ui-1.10.4.custom.css" />
<link rel="stylesheet"
	href="jQuery-Validation/css/validationEngine.jquery.css" />
<script src="jquery-ui-1.10.4.custom/js/jquery-1.10.2.js"></script>
<script src="jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.js"></script>
<script src="jQuery-Validation/js/jquery.validationEngine.js"></script>
<script
	src="jQuery-Validation/js/languages/jquery.validationEngine-en.js"></script>
<script src="js/jq.js"></script>

</head>
<body>
	<div id="new">
		<hr>
		<center>
			<h1>Bug Assign Edit Form</h1>
		</center>
		<hr>


		<%
			BugAssignBean bean = (BugAssignBean) request.getAttribute("bean");

			if (bean != null) {
		%>

		<form action="BugAssignUpdateServlet" id="BugAssignEditPage" name="BugAssignEditPage"
			id="BugAssignEditPage" method="post">
			<input type="hidden" name="id" value="<%=bean.getBugassign_id()%>">

			<table align="center">
				<%
					int bug_id = bean.getBug_id();
						int assigned_to = bean.getAssigned_to();
						int assigned_by = bean.getAssigned_by();
						String assigned_date = bean.getAssign_date();
						String complete_date = bean.getComplete_date();
						String isComplete = bean.getIs_completed();
				%>

				<%
					Bug_DetailsDAO dao_bug = new Bug_DetailsDAO();
						List<Bug_DetailsBean> list_bug = dao_bug.listData();
				%>
				<tr>
					<td>Bug Id:
					<td><select name="bug_id" id="bug_id">
							<option value="0" id="0">--Select BUG NAME-</option>
							<%
								if (list_bug != null) {
										for (int i = 0; i < list_bug.size(); i++) {
											Bug_DetailsBean bean_bug = (Bug_DetailsBean) list_bug
													.get(i);
											int test = bean_bug.getBug_id();
							%>

							<option value="<%=test%>" <%if (bug_id == test) {%>
								selected="selected" <%}%>><%=bean_bug.getBug_name()%>
								<%
									}
										}
								%>
							
					</select>${bug_id} <%
 	EmployeeDetailDAO dao_emp = new EmployeeDetailDAO();
 		List<EmployeeDetailBean> list_emp = dao_emp.listData();
 %>
				<tr>
					<td>Assign To:
					<td><select name="assigned_to" id="assigned_to">
							<option value="0" id="0">--SELECT ASSIGN TO--</option>
							<%
								if (list_emp != null) {
										for (int i = 0; i < list_emp.size(); i++) {
											EmployeeDetailBean bean_emp = (EmployeeDetailBean) list_emp
													.get(i);
											int test = bean_emp.getEmployee_id();
							%>
							<option value="<%=test%>" <%if (assigned_to == test) {%>
								selected="selected" <%}%>><%=bean_emp.getEmployee_firstname()%>
								<%
									}
										}
								%>
							
					</select>${assigned_to}
				<tr>
					<td>Assign By:
					<td><select name="assigned_by" id="assigned_by">
							<option value="0" id="0">--SELECT ASSIGN BY--</option>
							<%
								if (list_emp != null) {
										for (int i = 0; i < list_emp.size(); i++) {
											EmployeeDetailBean bean_emp = (EmployeeDetailBean) list_emp
													.get(i);
											int test = bean_emp.getEmployee_id();
							%>
							<option value="<%=test%>" <%if (assigned_by == test) {%>
								selected="selected" <%}%>><%=bean_emp.getEmployee_firstname()%>
								<%
									}
										}
								%>
							
					</select> ${assigned_by}
				<tr>
					<td>Assign Date:
					<td><input type="text" name="assign_date" id="assign_date"
						value="<%=bean.getAssign_date()%>" 
class="validate[required] text-input datepicker">${assign_date}
				<tr>
					<td>Complete Date:
					<td><input type="text" name="complete_date" id="complete_date"
						value="<%=bean.getComplete_date()%>" 
class=" text-input datepicker">${complete_date}
				<tr>
					<td>Is complete:
					<td>
						<%
							if (bean.getIs_completed().equals("Y")) {
						%> <input type="radio" name="is_completed" id="is_completed"
						value="Y" checked="checked">Yes <%
 	} else {
 %> <input type="radio" name="is_completed" id="is_completed" value="Y">Yes
						<%
 	}
 %> <%
 	if (bean.getIs_completed().equals("N")) {
 %> <input type="radio" name="is_completed" id="is_completed" value="N"
						checked="checked">No <%
 	} else {
 %> <input type="radio" name="is_completed" id="is_completed" value="N">No
						<%
 	}
 %>
					
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