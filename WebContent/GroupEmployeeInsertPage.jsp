<%@page import="arthinfosoft.bts.dao.GroupDAO"%>
<%@page import="arthinfosoft.bts.bean.GroupBean"%>
<%@page import="arthinfosoft.bts.bean.EmployeeDetailBean"%>
<%@page import="java.util.List"%>
<%@page import="arthinfosoft.bts.dao.EmployeeDetailDAO"%>
<%@page import="arthinfosoft.bts.bean.GroupEmployeeBean"%>
<%@page import="arthinfosoft.bts.bean.GroupEmployeeBean"%>
<%@page import="arthinfosoft.bts.dao.GroupEmployeeDAO"%>
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
<hr><center><h1>Group Employee Insert Form</h1></center><hr>

<form action="GroupEmployeeInsertServlet" name="groupemployeeinsertpage" method="post">

<% int count=1;
	GroupEmployeeBean bean=(GroupEmployeeBean) request.getAttribute("bean");
	if(bean==null){
		bean=new GroupEmployeeBean();
		count=0;
	}
	int a=bean.getGroup_id();
int b=bean.getEmployee_id();
%>

<table align="center">
<%
				GroupDAO dao_group=new GroupDAO();
				List<GroupBean> list_group=dao_group.listData();
				%>
<tr>
	<td>Group Id: 
	<td><select name="group_id" id="group_id"> 
		<option value="0" id="0" >--SELECT GROUP --</option>
						<%
							
								if(list_group != null) {
								for (int i = 0; i < list_group.size(); i++) {
								GroupBean bean_group = (GroupBean) list_group
											.get(i);
								int test = bean_group.getGroup_id();
						%>
								<option value="<%=test%>" <%if (a == test) {%> selected="selected"<%}%>>
							<%=bean_group.getGroup_description()%>
							<%
								}	}
							%>	
			
	</select>${group_id}
	
				<%
					EmployeeDetailDAO dao_emp = new EmployeeDetailDAO();
					List<EmployeeDetailBean> list_emp = dao_emp.listData();
				%>
<tr>
	<td>Employee: 
	<td><select name="employee_id" id="employee_id"> 
		<option value="0" id="0" >--SELECT EMPLOYEE--</option>
			
		<%
							if (list_emp != null) {
								for (int i = 0; i < list_emp.size(); i++) {
									EmployeeDetailBean bean_emp = (EmployeeDetailBean) list_emp
											.get(i);
									int test = bean_emp.getEmployee_id();
						%>
						<option value="<%=test%>" <%if (b == test) {%> selected="selected"<%}%>>
						<%=bean_emp.getEmployee_firstname()+" "+bean_emp.getEmployee_lastname()%>
							<%
								}
								}
							%>
				</select>${employee_id}	
	
<tr>    <td colspan="2" align="center"><input type="submit" name="submit" > <%if(count==0) { %><input type="reset" name="reset"><%} %> </td>

</table>

</form>
</div>
<%@include file="footer.jsp"%>

</body>
</html>