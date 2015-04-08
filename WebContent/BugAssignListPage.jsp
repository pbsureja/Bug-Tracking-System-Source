<%@page import="arthinfosoft.bts.bean.BugAssignBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
function del(id){
//	alert(id);
	var f=document.ListPage;
	f.tid.value=id;
	f.action="BugAssignDeleteServlet";
	f.submit();
}
function edit(id){
//	alert(id);
	var f=document.ListPage;
	f.tid.value=id;
	f.action="BugAssignEditServlet";
	f.submit();
}
</script>
</head>
<body>

<div id="new"><hr><center><h1>Bug Assign List</h1></center><hr></div>
			
<form action="" name="ListPage" method="post">
<input type="hidden" name="tid" id="tid">
<table class="newcsstablep"  >
	
	<tr>
		<td>Bug
		<td>Assigned To
		<td>Assigned By
		<td>Assigned Date
		<td>Complete Date
		<td>Is completed
	</tr>

	<%ArrayList<BugAssignBean> list = (ArrayList<BugAssignBean>) request
				.getAttribute("list");
		for (int i = 0; i < list.size(); i++) {
			BugAssignBean bean = list.get(i);%>

	<tr>
		<td><%=bean.getBug_name()%></td>
		<td><%=bean.getAssigned_to_name()%></td>
		<td><%=bean.getAssigned_by_name()%></td>
		<td><%=bean.getAssign_date()%></td>
		<td><%=bean.getComplete_date()%></td>
		<td><%=bean.getIs_completed()%></td>

		<td><a href="#" onclick="edit(<%=bean.getBugassign_id()%>)">
				EDIT</a> 
		<td><a href="#" onclick="del(<%=bean.getBugassign_id()%>)">DELETE</a>
	</tr>
	<%}%>
</table>

<div id="insert_link"> 
<br><a href="BugAssignInsertPage.jsp">INSERT MORE</a>
</div>	

</form>
<%@include file="footer.jsp"%>

</body>
</html>