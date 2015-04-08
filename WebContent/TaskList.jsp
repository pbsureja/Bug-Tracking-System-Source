<%@page import="java.util.ArrayList"%>
<%@page import="arthinfosoft.bts.bean.TaskBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> List Page</title>
<script type="text/javascript"> 
function del(id) {
	var f=document.listpage;
	//alert(id);
	f.task_id.value=id;
	f.action="TaskDeleteServlet";
	f.submit();
}
function edit(id) {
	var f=document.listpage;
	
//	alert(id);
	f.task_id.value=id;
	f.action="TaskEditServlet";
	f.submit();
}
</script>
</head>
<body>

<div id="new"><hr><center><h1>Task List</h1></center><hr></div>

<%
		List<TaskBean> list = (ArrayList<TaskBean>)request.getAttribute("list");
	%>
	<form action="" id="listpage" name="listpage" method="post">
		<input type="hidden" name="task_id" id="task_id">
	</form>
	<table class="newcsstablep" >
		<tr>
			<td>Name</td>
			<td>Description</td>
			<td>status</td>
			<td>module</td>
			<td>Project</td>
			<td>Estimated_start_date</td>
			<td>Estimated_end_date</td>
			<td>Actual_start_date</td>
			<td>Actual_end_date</td>
			<td>Modified_by</td>
			<td>Modified_date</td>
			
		</tr>
		<%
			if (list != null) {
				TaskBean bean = new TaskBean();
				for (int i = 0; i < list.size(); i++) {
					
					bean = list.get(i);
		%>
		<tr>
			<td><%=bean.getProject_name()%></td>
			<td><%=bean.getDescription()%></td>
			<td><%=bean.getBsbean().getStatus_description()%></td>
			<td><%=bean.getMbean().getProject_name()%></td>
		<td><%=bean.getPbean().getProject_name()%></td>	
			<td><%=bean.getEstimated_start_date()%></td>
			<td><%=bean.getEstimated_end_date()%></td>
			<td><%=bean.getActual_start_date()%></td>
			<td><%=bean.getActual_end_date()%></td>
			<td><%=bean.getEbean().getEmployee_firstname()+" "+bean.getEbean().getEmployee_lastname()%></td>
			<td><%=bean.getModified_date()%></td>
			<td><a href=# onclick="edit(<%=bean.getTask_id()%>)">Edit</a></td>
			<td><a href=# onclick="del(<%=bean.getTask_id()%>)">Delete</a></td>
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
<div id="insert_link"> 
<br><a href="TaskInsert.jsp" >INSERT MORE</a>
</div>
<%@include file="footer.jsp"%>


</body>
</html>