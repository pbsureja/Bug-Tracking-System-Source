<%@page import="arthinfosoft.bts.bean.EmployeeDetailBean"%>
<%@page import="arthinfosoft.bts.dao.EmployeeDetailDAO"%>
<%@page import="arthinfosoft.bts.bean.ManagerEmployeeBean"%>
<%@page import="arthinfosoft.bts.dao.ManagerEmployeeDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="arthinfosoft.bts.dao.DepartmentDAO"%>
<%@page import="arthinfosoft.bts.bean.DepartmentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department Edit Page</title>
<link rel="stylesheet"
	href="jquery-ui-1.10.4.custom/css/start/jquery-ui-1.10.4.custom.css" />
<link rel="stylesheet"
	href="jQuery-Validation/css/validationEngine.jquery.css" />
<script src="jquery-ui-1.10.4.custom/js/jquery-1.10.2.js"></script>
<script src="jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.js"></script>
<script src="jQuery-Validation/js/jquery.validationEngine.js"></script>
<script
	src="jQuery-Validation/js/languages/jquery.validationEngine-en.js"></script>
<script src="js/jq.js"></script></head>
<body>
 <div id="new">
<hr><center><h1>Department Edit Form</h1></center><hr>
	<%
		DepartmentBean bean = (DepartmentBean) request.getAttribute("bean");

		if (bean != null) {
	%>

	<form action="DepartmentUpdateServlet" name="DepartmentEditPage"
		id="form" method="post">
		<input type="hidden" name="id" value="<%=bean.getDepartment_id()%>">
		<table align="center" >

			<tr>
				<td>Department Description :</td>
				<td><input type="text" name="department_description"
					id="department_description" class="validate[required] text-input"
					value=<%=bean.getDepartment_description()%>>${department_description_empty}${department_description_length}</td>
			</tr>

			<tr>
				<td>Max Limit:</td>
				<td><input type="text" name="max_limit" id="max_limit" class="validate[required,custom[onlyNumberSp]] text-input"
					value=<%=bean.getMax_limit()%>>${max_limit_empty}${max_limit_length}</td>
			</tr>

			

			<%
			int id=bean.getManager_id();
			ManagerEmployeeDAO dao_manager=new ManagerEmployeeDAO();
			List<ManagerEmployeeBean> list_manager=dao_manager.listData();
			%>
			<tr>
				<td>Manager Id:</td>
				<td><select name="manager_id" id="manager_id">
						<option value=0>--SELECT MANAGER --</option>
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
				</select>${manager_id}</td>
			</tr>


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