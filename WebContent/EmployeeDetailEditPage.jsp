<%@page import="arthinfosoft.bts.bean.ManagerEmployeeBean"%>
<%@page import="arthinfosoft.bts.dao.ManagerEmployeeDAO"%>
<%@page import="arthinfosoft.bts.bean.DepartmentBean"%>
<%@page import="arthinfosoft.bts.dao.DepartmentDAO"%>
<%@page import="arthinfosoft.bts.bean.Role_EmployeeBean"%>
<%@page import="arthinfosoft.bts.dao.Role_EmployeeDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="arthinfosoft.bts.dao.EmployeeDetailDAO"%>
<%@page import="arthinfosoft.bts.bean.EmployeeDetailBean"%>
		
<%@include file="header.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<body>
 <div id="new">
<hr><center><h1>Employee Detail Edit Form</h1></center><hr>
	
	<%
		EmployeeDetailBean bean = (EmployeeDetailBean) request
				.getAttribute("bean");

		if (bean != null) {
	%>

	<form action="EmployeeDetailUpdateServlet"
		name="EmployeeDetailEditPage" id="form"
		method="post">
		<input type="hidden" name="id" value="<%=bean.getEmployee_id()%>">
		<table align="center"  >


			<tr>
				<td>Email:
				<td><input type="text" id="email" name="email" class="validate[required,custom[email]]"
					value="${bean.email}">${email}${email_length}${email_match}


				
			<tr>
				<td>Password:
				<td><input type="text" id="password" name="password"
					class="validate[required] text-input"
										value="${bean.password}">${password}${password_length}
			<tr>
				<td>Security Question:
				<td><input type="text" id="security_question"
				class="validate[required] text-input"
					name="security_question" value="${bean.security_question}">${security_question}${security_question_length}




				
			<tr>
				<td>Answer:
				<td><input type="text" id="answer" name="answer"
				class="validate[required] text-input"
					value="${bean.answer}">${answer}${answer_length}
			<tr>
				<td>First Name:
				<td><input type="text" id="employee_firstname"
				class="validate[required] text-input"
					name="employee_firstname" value="${bean.employee_firstname}">${employee_firstname}${employee_firstname_length}




				
			<tr>
				<td>Last Name:
				<td><input type="text" id="employee_lastname"
				class="validate[required] text-input"
					name="employee_lastname" value="${bean.employee_lastname}">${employee_lastname}${employee_lastname_length}




				
			<tr>
				<td>Permanent Address:
				<td><input type="text" id="permanent_address"
				class="validate[required] text-input"
					name="permanent_address" value="${bean.permanent_address}">${permanent_address}${permanent_address_length}




				
			<tr>
				<td>Temporary Address:
				<td><input type="text" id="temporary_address"
					name="temporary_address" value="${bean.temporary_address}">${temporary_address}${temporary_address_length}




				
			<tr>
				<td>Mobile No:
				<td><input type="text" id="mobile" name="mobile"
					class="validate[required,custom[onlyNumberSp]] text-input"

						value="${bean.mobile}">${mobile}${mobile_length}${mobile_matches}


				
			<tr>
				<td>Landline:
				<td><input type="text" id="landline" name="landline"
					class="validate[required,custom[onlyNumberSp]] text-input"

					 value="${bean.landline}">${landline}${landline_length}${landline_matches}


				
			<tr>
				<td>Date of Birth:
				<td><input type="text" id="dateofbirth" name="dateofbirth"
					class="validate[required,custom[date]] text-input datepicker"
					 value="${bean.dateofbirth}">${dateofbirth}${dateofbirth_length}



				
			<tr>

				<%
					int d = bean.getDesignation();
						Role_EmployeeDAO dao_designation = new Role_EmployeeDAO();
						List<Role_EmployeeBean> list_designation = dao_designation
								.listData();
				%>
				<td>Designation:
				<td><select name="designation" id="designation">
						<option value="0" id="0">--SELECT designation--</option>
						<%
							if (list_designation != null) {
									for (int i = 0; i < list_designation.size(); i++) {
										Role_EmployeeBean bean_designation = (Role_EmployeeBean) list_designation
												.get(i);
										int test = bean_designation.getRole_id();
						%>
						<option value="<%=test%>" <%if (d == test) {%> selected="selected"
							<%}%>><%=bean_designation.getRole_Description()%></option>
						<%
							}
								}
						%>

				</select>${designation}
			<tr>
				<td>Joining Date:
				<td><input type="text" id="joining_date" name="joining_date" class="validate[required] text-input datepicker"
				class="validate[required,custom[date]] text-input datepicker"
				
					value="${bean.joining_date}">${joining_date}${joining_date_length}


					<%
						int b = bean.getRole_id();
							int c = bean.getdepartment_id();
							int id = bean.getManager_id();
					%> <%
 	Role_EmployeeDAO dao = new Role_EmployeeDAO();
 		List<Role_EmployeeBean> list_role = dao.listData();
 %>
			<tr>
				<td>Role:
				<td><select name="role_id" id="role_id">
						<option value="0" id="0">--SELECT ROLE--</option>
						<%
							if (list_role != null) {
									for (int i = 0; i < list_role.size(); i++) {
										Role_EmployeeBean bean_role = (Role_EmployeeBean) list_role
												.get(i);
										int test = bean_role.getRole_id();
						%>
						<option value="<%=test%>" <%if (b == test) {%> selected="selected"
							<%}%>>
							<%=bean_role.getRole_Description()%>
						</option>

						<%
							}
								}
						%>

				</select> ${role_id} 
						<%
 							DepartmentDAO dao_depart = new DepartmentDAO();
 							List<DepartmentBean> list_department = dao_depart.listData();
 						%>
			<tr>
				<td>Department:
				<td><select name="department_id" id="department_id">
						<option value="0" id="0">--SELECT DEPARTMENT ID--</option>
						<%
							if (list_department != null) {
									for (int i = 0; i < list_department.size(); i++) {
										DepartmentBean bean_department = (DepartmentBean) list_department
												.get(i);
										int test = bean_department.getDepartment_id();
						%>
						<option value="<%=test%>" <%if (c == test) {%> selected="selected"
							<%}%>>
							<%=bean_department.getDepartment_description()%>
						</option>

						<%
							}
								}
						%>

				</select>${department_id}
			<%
				ManagerEmployeeDAO dao_manager=new ManagerEmployeeDAO();
				List<ManagerEmployeeBean> list_manager=dao_manager.listData();
				
			%>
			<tr>
				<td>Manager :
				<td><select name="manager_id" id="manager_id">
						<option value="0" id="0">--SELECT MANAGER ID--</option>
						<%
						if(list_manager!=null){
							for(int i=0;i<list_manager.size();i++){
								ManagerEmployeeBean bean_manager=(ManagerEmployeeBean)list_manager.get(i);
								int test=bean_manager.getManager_id();
								EmployeeDetailDAO dao_emp=new EmployeeDetailDAO();
								EmployeeDetailBean bean_emp=dao_emp.editData(bean_manager.getEmployee_id());
						%>
						<option value="<%=test%>" <%if (id == test) {%> selected="selected" <%}%>><%=bean_emp.getEmployee_firstname()%>  
						<%
						}
						}
						%>

				</select>${manager_id}

			</tr>
			<tr>
				<td>Salary:
				<td><input type="text" name="salary" id="salary"
				
class="validate[required,custom[onlyNumberSp]] text-input"
					value="${bean.salary}">${salary} ${salary_length}
					${salary_limit}
			</tr>
			<tr>
				<td>Is Active:
				<td>
					<%
						if (bean.getIs_active().equals("Y")) {
					%> <input type="radio" name="is_active" id="is_active" value="Y"
					checked="checked">Yes <%
 	} else {
 %> <input type="radio" name="is_active" id="is_active" value="Y">Yes
					<%
 	}
 		if (bean.getIs_active().equals("N")) {
 %> <input type="radio" name="is_active" id="is_active" value="N"
					checked="checked">No <%
 	} else {
 %> <input type="radio" name="is_active" id="is_active" value="N">No
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