<%@page import="arthinfosoft.bts.bean.EmployeeDetailBean"%>
<%@page import="arthinfosoft.bts.dao.EmployeeDetailDAO"%>
<%@page import="java.util.List"%>
<%@page import="arthinfosoft.bts.dao.GroupDAO"%>
<%@page import="arthinfosoft.bts.bean.GroupBean"%>
<%@page import="arthinfosoft.bts.bean.GroupEmployeeBean"%>
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
<hr><center><h1>Group Employee Edit Form</h1></center><hr>

	<%
		GroupEmployeeBean bean = (GroupEmployeeBean) request.getAttribute("bean");

		if (bean != null) {
	%>

	<form action="GroupEmployeeUpdateServlet" name="GroupEmployeeEditPage"
		id="GroupEmployeeEditPage" method="post">
		<input type="hidden" name="tid" id="tid" value="<%=bean.getEmployee_id()%>">
		<table align="center" >
		 		<%
				int id = bean.getGroup_id();
				%>
				<%
				GroupDAO dao_group=new GroupDAO();
				List<GroupBean> list_group=dao_group.listData();
				%>
			<tr>
				<td>Group Name:</td>
				<td><select name="group_id" id="group_id">
						<option value=0>--SELECT GROUP NAME --</option>
						<%
								if (list_group != null) {
								for (int i = 0; i < list_group.size(); i++) {
								GroupBean bean_group = (GroupBean) list_group
											.get(i);
								int test = bean_group.getGroup_id();
						%>
								<option value="<%=test%>" <%if (id == test) {%> selected="selected"<%}%>>
							<%=bean_group.getGroup_description()%>
							<%
								}	}
							%>
						
				</select>${group_id}</td>
			</tr>
 	

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
						<option value="<%=test%>" <%if (eid == test) {%> selected="selected"
							<%}%>><%=bean_emp.getEmployee_firstname()+" "+bean_emp.getEmployee_firstname()%>
							<%
								}
								}
							%>
						
						</select>${employee_id}</td>
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