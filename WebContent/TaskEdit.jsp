<%@page import="arthinfosoft.bts.dao.PmtStatusDAO"%>
<%@page import="arthinfosoft.bts.bean.PmtStatusBean"%>
<%@page import="arthinfosoft.bts.bean.EmployeeDetailBean"%>
<%@page import="arthinfosoft.bts.dao.EmployeeDetailDAO"%>
<%@page import="arthinfosoft.bts.bean.TaskAssignBean"%>
<%@page import="arthinfosoft.bts.dao.TaskAssignDAO"%>
<%@page import="arthinfosoft.bts.bean.ModuleBean"%>
<%@page import="arthinfosoft.bts.dao.ModuleDAO"%>
<%@page import="arthinfosoft.bts.bean.BugStatusBean"%>
<%@page import="java.util.List"%>
<%@page import="arthinfosoft.bts.dao.BugStatusDAO"%>
<%@page import="arthinfosoft.bts.bean.TaskBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Task Edit Page</title>
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
			<h1>Task Edit Form</h1>
		</center>
		<hr>

		<%
			TaskBean bean = (TaskBean) request.getAttribute("bean");
			if (bean == null) {
				bean = new TaskBean();

			}
			int status_id = bean.getStatus_id();
			int module_id = bean.getModule_id();
			int client_id = bean.getClient_id();
			int modified_by = bean.getModified_by();
		%>
		<form action="TaskUpdateServlet" id="form" name="Project"
			method="post">
			<input type="hidden" name="task_id" value="${bean.task_id}">

			<table align="center">

				<tr>
					<td>Name</td>
					<td><input type="text"
						class="validate[required,maxSize[50]] text-input" name="name"
						value="${bean.project_name}">${name} ${name_length}
				</tr>
				<tr>
					<td>Description</td>
					<td><input type="text" name="description"
						class="validate[required,maxSize[100ad	]] text-input"
						value="${bean.description}">${description}
						${description_length}
				</tr>

				<%
					PmtStatusDAO dao_status = new PmtStatusDAO();
					List<PmtStatusBean> list_status = dao_status.listData();
				%>

				<tr>
					<td>Status</td>
					<td><select name="status_id" id="status_id">
							<option value="">----Select status----</option>
							<%
								if (list_status != null) {
									for (int i = 0; i < list_status.size(); i++) {
										PmtStatusBean bean_emp = (PmtStatusBean) list_status.get(i);
										int test = bean_emp.getStatus_id();
							%>
							<option value="<%=test%>" <%if (status_id == test) {%>
								selected="selected" <%}%>>
								<%=bean_emp.getStatus_description()%>
								<%
									}
									}
								%>
							
					</select>${status_id} ${status_id_length}</td>

				</tr>

				<%
					TaskAssignDAO dao_assign = new TaskAssignDAO();
					List<TaskAssignBean> list_assign = dao_assign.listData();
				%>


				<%
					ModuleDAO dao_module = new ModuleDAO();
					List<ModuleBean> list_module = dao_module.listData();
				%>
				<tr>
					<td>Module</td>
					<td><select name="module_id" id="module_id">
							<option value="">----Select module----</option>
							<%
								if (list_module != null) {
									for (int i = 0; i < list_module.size(); i++) {
										ModuleBean bean_module = (ModuleBean) list_module.get(i);
										int test = bean_module.getModule_id();
							%>
							<option value="<%=test%>" <%if (module_id == test) {%>
								selected="selected" <%}%>>
								<%=bean_module.getDescription()%>
								<%
									}
									}
								%>
							
					</select>${module_id} ${module_id_length}</td>
				</tr>





				<tr>
					<td>Estimated Start Date</td>
					<td><input type="text" name="estimated_start_date" id="estimated_start_date"
						class="validate[required,custom[date]] text-input datepicker"
						value="${bean.estimated_start_date}">${estimated_start_date}
						${estimated_start_date_length}</td>
				</tr>
				<tr>
					<td>Estimated End Date</td>
					<td><input type="text" name="estimated_end_date" id="estimated_end_date"
						class="validate[required,custom[date]] text-input datepicker"
						value="${bean.estimated_end_date}">${estimated_end_date}
						${estimated_start_end_length}</td>
				</tr>
				<tr>
					<td>Actual Start Date</td>
					<td><input type="text" name="actual_start_date" id="actual_start_date"
						class="validate[required,custom[date]] text-input datepicker"
						value="${bean.actual_start_date}">${actual_start_date}
						${actual_start_date_length}</td>
				</tr>
				<tr>
					<td>Actual End Date</td>
					<td><input type="text" name="actual_end_date" id="actual_end_date"
						class="validate[required,custom[date]] text-input datepicker"
						value="${bean.actual_start_date}">${actual_end_date}
						${actual_end_date_length}</td>
				</tr>

				<%
					EmployeeDetailDAO dao_emp = new EmployeeDetailDAO();
					List<EmployeeDetailBean> list_emp = dao_emp.listData();
				%>
				<tr>
					<td>Modified By</td>
					<td><select name="modified_by" id="modified_by">
							<option value="">----Select employee who modified it----</option>
							<%
								if (list_emp != null) {
									for (int i = 0; i < list_emp.size(); i++) {
										EmployeeDetailBean bean_emp = (EmployeeDetailBean) list_emp
												.get(i);
										int test = bean_emp.getEmployee_id();
							%>
							<option value="<%=test%>" <%if (modified_by == test) {%>
								selected="selected" <%}%>>
								<%=bean_emp.getEmployee_firstname()%>
								<%
									}
									}
								%>
							
					</select>${modified_by} ${modified_by_length}</td>
				</tr>



				<tr>
					<td>Modified Date</td>
					<td><input type="text" name="modified_date" id="modified_date"
						class="validate[required,custom[date]] text-input datepicker"
						value="${bean.modified_date}">${modified_date}
						${modified_date_length}</td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="submit"></td>
			</table>
		</form>
	</div>
	<%@include file="footer.jsp"%>

</body>
</html>