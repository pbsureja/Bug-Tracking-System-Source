<%@page import="java.util.ArrayList"%>
<%@page import="arthinfosoft.bts.bean.Role_EmployeeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Role Employee List Page</title>
<script type="text/javascript"> 
function del(id) {
	var f=document.listpage;
	alert(id);
	f.tid.value=id;
	f.action="Role_EmployeeDeleteServlet";
	f.submit();
}
function edit(id) {
	var f=document.listpage;
	
	//alert(id);
	f.tid.value=id;
	f.action="Role_EmployeeEditServlet";
	f.submit();
}
</script>
</head>
<body>
<div id="new"><hr><center><h1>Role Employee List</h1></center><hr></div>

<%
		List<Role_EmployeeBean> list = (ArrayList<Role_EmployeeBean>)request.getAttribute("list");
	%>
	<form action="" id="listpage" name="listpage" method="post">
		<input type="hidden" name="tid" id="tid">
	
	<table class="newcsstablep" >
		<tr>
			<td>Description</td>
			
		</tr>
		<%
			if (list != null) {
				Role_EmployeeBean bean = new Role_EmployeeBean();
				for (int i = 0; i < list.size(); i++) {
					
					bean = list.get(i);
		%>
		<tr>
			<td><%=bean.getRole_Description()%></td>
			<td><a href=# onclick="edit(<%=bean.getRole_id()%>)">Edit</a></td>
			<td><a href=# onclick="del(<%=bean.getRole_id()%>)">Delete</a></td>
		</tr>
		<%
			}
			} else {
		%>
		<h2>List is Empty.</h2>


		<%
			}
		%>
	</table>
	</form>
	<div id="insert_link"> 
	
<br><a href="Role_EmployeeInsert.jsp">INSERT MORE</a>
</div>
<%@include file="footer.jsp"%>

</body>
</html>