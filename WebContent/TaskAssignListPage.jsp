
<%@include file="header.jsp"%>
<%@page import="arthinfosoft.bts.bean.TaskAssignBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TaskAssign List Page</title>

<script type="text/javascript">
function del(id){
//	alert(id);
	var f=document.ListPage;
	f.tid.value=id;
	f.action="TaskAssignDeleteServlet";
	f.submit();
}
function edit(id){
//	alert(id);
	var f=document.ListPage;
	f.tid.value=id;
	f.action="TaskAssignEditServlet";
	f.submit();
}
</script>
</head>
<body >
<div id="new"><hr><center><h1>Task Assign List</h1></center><hr></div>

<form action="" name="ListPage" method="post">
<input type="hidden" name="tid" id="tid">
<table class="newcsstablep" >
	
	<tr>
		<td>Task Id
		<td>Task Name
		<td>Assigned To
		<td>Assigned To Name
		<td>Assigned By
		<td>Assigned By Name
		<td>Assigned Date
		<td>Complete Date
		<td>Is completed
	</tr>

	<%ArrayList<TaskAssignBean> list = (ArrayList<TaskAssignBean>) request.getAttribute("list");
		for (int i = 0; i < list.size(); i++) {
			TaskAssignBean bean = list.get(i);%>

	<tr>
		<td><%=bean.getTask_id()%></td>
		<td><%=bean.getTbean().getProject_name()%></td>
		<td><%=bean.getAssigned_to()%></td>
		<td><%=bean.getEbean().getEmployee_firstname()+" "+bean.getEbean().getEmployee_lastname()%></td>
		<td><%=bean.getAssigned_by()%></td>
		<td><%=bean.getEbean2().getEmployee_firstname()+" "+bean.getEbean2().getEmployee_lastname()%></td>
		<td><%=bean.getAssign_date()%></td>
		<td><%=bean.getComplete_date()%></td>
		<td><%=bean.getIs_completed()%></td>

		<td><a href="#" onclick="edit(<%=bean.getTaskassign_id()%>)">
				EDIT</a><td> <a href="#" onclick="del(<%=bean.getTaskassign_id()%>)">DELETE</a>
	</tr>
	<%}%>
</table>
<div id="insert_link"> 

<br><a href="TaskAssignInsertPage.jsp">INSERT MORE</a>

</div>
<%@include file="footer.jsp"%>

</body>
</html>