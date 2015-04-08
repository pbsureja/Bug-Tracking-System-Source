<%@page import="arthinfosoft.bts.bean.EmployeeDetailBean"%>
<%@page import="arthinfosoft.bts.dao.EmployeeDetailDAO"%>
<%@page import="arthinfosoft.bts.bean.TaskBean"%>
<%@page import="java.util.List"%>
<%@page import="arthinfosoft.bts.dao.TaskDAO"%>
<%@page import="arthinfosoft.bts.bean.TaskAssignBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="jquery-ui-1.10.4.custom/css/start/jquery-ui-1.10.4.custom.css" />
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
			<h1>Task Assign Insert Form</h1>
		</center>
		<hr>

		<form action="TaskAssignInsertServlet" id="form" name="taskassigninsertpage"
			method="post">

			<%
				int count = 1;

				TaskAssignBean bean = (TaskAssignBean) request.getAttribute("bean");
				if (bean == null) {
					bean = new TaskAssignBean();
					count = 0;

				}
				int a = bean.getTask_id();
				int b = bean.getAssigned_to();
				int c = bean.getAssigned_by();
			%>

			<table align="center">
				<%
					TaskDAO dao_task = new TaskDAO();
					List<TaskBean> list_task = dao_task.listData();
				%>
				<tr>
					<td>Task:</td>
					<td><select name="task_id" id="task_id">
							<option value="0" id="0">--SELECT TASK --</option>
							<%
								if (list_task != null) {
									for (int i = 0; i < list_task.size(); i++) {
										TaskBean bean_task = (TaskBean) list_task.get(i);
										int test = bean_task.getTask_id();
							%>

							<option value="<%=test%>" <%if (a == test) {%>
								selected="selected" <%}%>><%=bean_task.getDescription()%>
								<%
									}
									}
								%>
							
					</select>${task_id}</td>
				<tr>
					<%
						EmployeeDetailDAO dao_emp = new EmployeeDetailDAO();
						List<EmployeeDetailBean> list_emp = dao_emp.listData();
					%>

					<td>Assign To:</td>
					<td><select name="assigned_to" id="assigned_to">
							<option value="0" id="0">--SELECT ASSIGN TO--</option>
							<%
								if (list_emp != null) {
									for (int i = 0; i < list_emp.size(); i++) {
										EmployeeDetailBean bean_emp = (EmployeeDetailBean) list_emp
												.get(i);
										int test = bean_emp.getEmployee_id();
							%>
							<option value="<%=test%>" <%if (b == test) {%>
								selected="selected" <%}%>><%=bean_emp.getEmployee_firstname()%>
								<%
									}
									}
								%>
							
					</select>${assigned_to}</td>
				<tr>
					<td>Assign By:</td>
					<td><select name="assigned_by" id="assigned_by">
							<option value="0" id="0">--SELECT ASSIGN BY --</option>
							<%
								if (list_emp != null) {
									for (int i = 0; i < list_emp.size(); i++) {
										EmployeeDetailBean bean_emp = (EmployeeDetailBean) list_emp
												.get(i);
										int test = bean_emp.getEmployee_id();
							%>
							<option value="<%=test%>" <%if (c == test) {%>
								selected="selected" <%}%>><%=bean_emp.getEmployee_firstname()%>
								<%
									}
									}
								%>
							
					</select>${assigned_by}</td>
				<tr>
					<td>Assign Date:</td>
					<td><input type="text" name="assign_date" id="assign_date" class="validate[required,custom[date]] text-input datepicker"
						value="${bean.assign_date}">${assign_date }
				<tr>
					<td>Complete Date:
					<td><input type="text" name="complete_date" id="complete_date" class="validate[custom[date]] text-input datepicker"
						value="${bean.complete_date}">${complete_date }
				<tr>
					<td>Is completed:</td>
					<td><input type="radio" name="is_completed" id="is_complete"
						value="Y" checked="checked">Yes <input type="radio"
						name="is_completed" id="is_complete" value="N">No
						${is_completed}</td>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="submit"> <%
 	if (count == 0) {
 %><input type="reset"
						name="reset">
						<%
							}
						%></td>
			</table>
		</form>
	</div><%@include file="footer.jsp"%>

</body>
</html>