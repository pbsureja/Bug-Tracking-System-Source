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
<hr><center><h1>Task Assign Edit Form</h1></center><hr>

	<%
		TaskAssignBean bean = (TaskAssignBean) request.getAttribute("bean");

		if (bean != null) {
	%>

	<form action="TaskAssignUpdateServlet" name="TaskAssignEditPage"
		id="TaskAssignEditPage" method="post">
		<input type="hidden" name="id" id="form" value="<%=bean.getTaskassign_id()%>">

		<table align="center"  >
			<%
				int task_id = bean.getTask_id();
					int assigned_to = bean.getAssigned_to();
					int assigned_by = bean.getAssigned_by();
					String assigned_date = bean.getAssign_date();
					String complete_date = bean.getComplete_date();
					String isComplete = bean.getIs_completed();
			%>
			<tr>
				<td>Task:
				<td><select name="task_id" id="task_id">
						<option value="0" id="0">--SELECT BUG ID--</option>
						<option value="1" <%if (task_id == 1) {%> selected="selected" <%}%>>1</option>
						<option value="2" <%if (task_id == 2) {%> selected="selected" <%}%>>2</option>
						<option value="3" <%if (task_id == 3) {%> selected="selected" <%}%>>3</option>
						<option value="4" <%if (task_id == 4) {%> selected="selected" <%}%>>4</option>

				</select>${task_id}
			<tr>
				<td>Assign To:
				<td><select name="assigned_to" id="assigned_to">
						<option value="0" id="0">--SELECT ASSIGN TO ID--</option>
						<option value="1" <%if (assigned_to == 1) {%> selected="selected"
							<%}%>>1</option>
						<option value="2" <%if (assigned_to == 2) {%> selected="selected"
							<%}%>>2</option>
						<option value="3" <%if (assigned_to == 3) {%> selected="selected"
							<%}%>>3</option>
						<option value="4" <%if (assigned_to == 4) {%> selected="selected"
							<%}%>>4</option>

				</select>${assigned_to}
			<tr>
				<td>Assign By:
				<td><select name="assigned_by" id="assigned_by">
						<option value="0" id="0">--SELECT ASSIGN BY ID--</option>
						<option value="1" <%if (assigned_by == 1) {%> selected="selected"
							<%}%>>1</option>
						<option value="2" <%if (assigned_by == 2) {%> selected="selected"
							<%}%>>2</option>
						<option value="3" <%if (assigned_by == 3) {%> selected="selected"
							<%}%>>3</option>
						<option value="4" <%if (assigned_by == 4) {%> selected="selected"
							<%}%>>4</option>
				</select> ${assigned_by}
			<tr>
				<td>Assign Date:
				<td><input type="text" class="validate[required,custom[date]] text-input datepicker" name="assign_date" id="assign_date" value="<%=bean.getAssign_date()%>">${assign_date}
			<tr>
				<td>Complete Date:
				<td><input type="text" class="validate[custom[date]] text-input datepicker" name="complete_date" id="complete_date" value="<%=bean.getComplete_date()%>">${complete_date}
			<tr>
				<td>Is complete:
				<td>
				<%
					if (bean.getIs_completed().equals("Y")) {
				%>
				<input type="radio" name="is_completed" id="is_completed" value="Y" checked="checked">Yes
				<%
					} else {
				%>
				
				<input type="radio" name="is_completed" id="is_completed" value="Y">Yes
				
				<%
					}
				%>
				<%
					if (bean.getIs_completed().equals("N")) {
				%>
				
				<input type="radio" name="is_completed" id="is_completed" value="N"
					checked="checked">No
				
				<%
					} else {
				%>
				<input type="radio" name="is_completed" id="is_completed" value="N">No
				<%
					}
				%>
			<tr>    <td colspan="2" align="center"><input type="submit" name="submit" > </td>
		</table>
	</form>
	</div>
<%@include file="footer.jsp"%>
	
	<%
		}
	%>
</body>
</html>