<%@page import="java.util.ArrayList"%>
<%@page import="arthinfosoft.bts.bean.Bug_DetailsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    		
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Page</title>
<div id="new">
<hr><center><h1>Bug Detail List</h1></center><hr>
</div>
<script type="text/javascript"> 
function del(id) {
	var f=document.listpage;
	//alert(id);
	f.tid.value=id;
	f.action="Bug_DetailsDeleteServlet";
	f.submit();
}
function edit(id) {
	var f=document.listpage;
	
	//alert(id);
	f.tid.value=id;
	f.action="Bug_DetailsEditServlet";
	f.submit();
}
</script>
</head>
<body>
<%
		List<Bug_DetailsBean> list = (ArrayList<Bug_DetailsBean>)request.getAttribute("list");
	%>
	<form action="" id="listpage" name="listpage" method="post">
		<input type="hidden" name="tid" id="tid">
	</form>
	
	<table class="newcsstablep"  >
		<tr>
<td>Task</td>
<td>Bug_Name</td>
<td>Bug_Status</td>
<td>Reporter_Type</td>
<td>Reported By</td>
<td>Priority</td>
<td>Reported_Date</td>
<td>Bug_Type</td>
			
		</tr>
		<%
			if (list != null) {
				Bug_DetailsBean bean = new Bug_DetailsBean();
				for (int i = 0; i < list.size(); i++) {
					
					bean = list.get(i);
		%>
		<tr>
			<td><%=bean.getTask()%></td>
			<td><%=bean.getBug_name()%></td>
			<td><%=bean.getBug_status()%></td>
			<td><%=bean.getReporter_type_name()%></td>
			<td><%=bean.getReporter()%></td>
			<td><%=bean.getPriority()%></td>
			<td><%=bean.getReported_date()%></td>
			<td><%=bean.getBug_type_name()%></td>
			
			<td><a href=# onclick="edit(<%=bean.getBug_id()%>)">Edit</a></td>
			<td><a href=# onclick="del(<%=bean.getBug_id()%>)">Delete</a></td>
		</tr>
		<%
			}
			} else {
		%>
		<h2>List is Empty</h2>


		<%
			}
		%>
	</table>
	
	<br>	

	<div id="insert_link">
	<a href="Bug_DetailsInsert.jsp" >INSERT MORE</a>
	</div>

</body>

</html>

<%@include file="footer.jsp"%>