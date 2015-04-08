<%@page import="arthinfosoft.bts.dao.PmtStatusDAO"%>
<%@page import="arthinfosoft.bts.bean.PmtStatusBean"%>
<%@page import="arthinfosoft.bts.bean.BugStatusBean"%>
<%@page import="arthinfosoft.bts.dao.BugStatusDAO"%>
<%@page import="arthinfosoft.bts.bean.ProjectTechnologyBean"%>
<%@page import="arthinfosoft.bts.dao.ProjectTechnologyDAO"%>
<%@page import="arthinfosoft.bts.bean.ProjectPlatformBean"%>
<%@page import="arthinfosoft.bts.dao.ProjectPlatformDAO"%>
<%@page import="arthinfosoft.bts.bean.Client_DetailsBean"%>
<%@page import="arthinfosoft.bts.dao.Client_DetailsDAO"%>
<%@page import="arthinfosoft.bts.bean.EmployeeDetailBean"%>
<%@page import="arthinfosoft.bts.dao.EmployeeDetailDAO"%>
<%@page import="java.util.List"%>
<%@page import="arthinfosoft.bts.bean.ProjectBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Edit Page</title>
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
			<h1>Project Edit Form</h1>
		</center>
		<hr>

		<%
			int count = 1;
			ProjectBean bean = (ProjectBean) request.getAttribute("bean");
			if (bean == null) {
				bean = new ProjectBean();
				count = 0;
			}
			int status_id = bean.getStatus_id();
			int technology_id = bean.getTechnology_id();
			int platform_id = bean.getPlatform_id();
			int client_id = bean.getClient_id();
			int modified_by = bean.getModified_by();
		%>
		<form action="ProjectUpdateServlet" id="form" name="Project"
			method="post">
			<input type="hidden" name="project_id" value="${bean.project_id}">

			<table align="center">

				<tr>
					<td>Project Name</td>
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
					<td><select name="status_id" class="validate[required]" id="status_id">
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

					<%
						ProjectTechnologyDAO dao_tech = new ProjectTechnologyDAO();
						List<ProjectTechnologyBean> list_tech = dao_tech.listData();
					%>
				
				<tr>
					<td>Technology</td>
					<td><select name="technology_id" class="validate[required]" id="technology_id">
							<option value="">----Select technology----</option>
							<%
								if (list_tech != null) {
									for (int i = 0; i < list_tech.size(); i++) {
										ProjectTechnologyBean bean_tech = (ProjectTechnologyBean) list_tech
												.get(i);
										int test = bean_tech.getTechnology_id();
							%>
							<option value="<%=test%>" <%if (technology_id == test) {%>
								selected="selected" <%}%>>
								<%=bean_tech.getTechnology_description()%>
								<%
									}
									}
								%>
							
					</select>${technology_id} ${technology_id_length}</td>
				</tr>
				<%
					ProjectPlatformDAO dao_plat = new ProjectPlatformDAO();
					List<ProjectPlatformBean> list_plat = dao_plat.listData();
				%>
				<tr>
					<td>Platform</td>
					<td><select name="platform_id" class="validate[required]" id="platform_id">
							<option value="">----Select platform----</option>
							<%
								if (list_plat != null) {
									for (int i = 0; i < list_plat.size(); i++) {
										ProjectPlatformBean bean_plat = (ProjectPlatformBean) list_plat
												.get(i);
										int test = bean_plat.getPlatform_id();
							%>
							<option value="<%=test%>" <%if (platform_id == test) {%>
								selected="selected" <%}%>>
								<%=bean_plat.getPlatform_description()%>
								<%
									}
									}
								%>
							
					</select>${platform_id} ${platform_id_length}</td>
				</tr>

				<%
					Client_DetailsDAO dao_client = new Client_DetailsDAO();
					List<Client_DetailsBean> list_client = dao_client.listData();
				%>
				<tr>
					<td>Client</td>
					<td><select name="client_id" class="validate[required]" id="client_id">
							<option value="">----Select Client----</option>
							<%
								if (list_client != null) {
									for (int i = 0; i < list_client.size(); i++) {
										Client_DetailsBean bean_client = (Client_DetailsBean) list_client
												.get(i);
										int test = bean_client.getClient_id();
							%>
							<option value="<%=test%>" <%if (client_id == test) {%>
								selected="selected" <%}%>>
								<%=bean_client.getClient_name()%>
								<%
									}
									}
								%>
							
					</select>${client_id} ${client_id_length}</td>
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