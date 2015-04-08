
<%@page import="arthinfosoft.bts.bean.PmtStatusBean"%>
<%@page import="arthinfosoft.bts.dao.PmtStatusDAO"%>
<%@page import="arthinfosoft.bts.dao.EmployeeDetailDAO"%>
<%@page import="arthinfosoft.bts.bean.EmployeeDetailBean"%>
<%@page import="arthinfosoft.bts.dao.ProjectDAO"%>
<%@page import="arthinfosoft.bts.bean.ProjectBean"%>
<%@page import="java.util.List"%>
<%@page import="arthinfosoft.bts.dao.BugStatusDAO"%>
<%@page import="arthinfosoft.bts.bean.BugStatusBean"%>
<%@page import="arthinfosoft.bts.bean.ModuleBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Page</title>
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
			<h1>Module Insert Form</h1>
		</center>
		<hr>

		<%
			int count = 1;

			ModuleBean bean = (ModuleBean) request.getAttribute("bean");
			if (bean == null) {
				bean = new ModuleBean();
				count = 0;
			}
			int status_id = bean.getStatus_id();
			int project_id = bean.getProject_id();
			int modified_by = bean.getModified_by();
		%>
		<form action="ModuleInsertServlet" id="form" name="Module"
			method="post">
			<table align="center">

				<tr>
					<td>Name</td>
					<td><input type="text" name="name"
						class="validate[required,maxSize[50]] text-input"
						value="${bean.project_name}">${name} ${name_length}
				</tr>
				<tr>
					<td>Code</td>
					<td><input type="text" name="code"
						class="validate[required,maxSize[5]] text-input"
						value="${bean.code}">${code} ${code_length}</td>
				</tr>
				<tr>
					<td>Description</td>
					<td><input type="text" name="description"
						class="validate[required,maxSize[100]] text-input"
						value="${bean.description}">${description}
						${description_length}
				</tr>

				<%
				PmtStatusDAO dao_status = new PmtStatusDAO();
					List<PmtStatusBean> list_status = dao_status.listData();
				%>

				<tr>
					<td>Status</td>
					<td><select name="status_id" id="status_id" class="validate[required]">
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
					ProjectDAO dao_project = new ProjectDAO();
					List<ProjectBean> list_project = dao_project.listData();
				%>
				<tr>
					<td>Project</td>
					<td><select name="project_id"  class="validate[required]" id="project_id">
							<option value="">----Select project----</option>
							<%
								if (list_project != null) {
									for (int i = 0; i < list_project.size(); i++) {
										ProjectBean bean_project = (ProjectBean) list_project
												.get(i);
										int test = bean_project.getProject_id();
							%>
							<option value="<%=test%>" <%if (project_id == test) {%>
								selected="selected" <%}%>>
								<%=bean_project.getProject_name()%>
								<%
									}
									}
								%>
							
					</select>${project_id} ${project_id_length}</td>
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
					<td><input type="text" id="actual_end_date" name="actual_end_date"
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
					<td><select name="modified_by" class="validate[required]" id="modified_by">
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
					<td><input type="text" id="modified_date" name="modified_date"
						class="validate[required,custom[date]] text-input datepicker"
						value="${bean.modified_date}">${modified_date}
						${modified_date_length}</td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="submit"> <%
 	if (count == 0) {
 %><input type="reset" name="reset"> <%
 	}
 %></td>
			</table>
		</form>
	</div><%@include file="footer.jsp"%>

</body>
</html>