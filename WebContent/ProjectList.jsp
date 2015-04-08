<%@page import="java.util.ArrayList"%>
<%@page import="arthinfosoft.bts.bean.ProjectBean"%>
<%@page import="java.util.List"%>
<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project List Page</title>

<script type="text/javascript"> 
function del(id) {
	var f=document.listpage;
	//alert(id);
	f.project_id.value=id;
	f.action="ProjectDeleteServlet";
	f.submit();
}
function edit(id) {
	var f=document.listpage;
	
//	alert(id);
	f.project_id.value=id;
	f.action="ProjectEditServlet";
	f.submit();
}
</script>
</head>
<body>
<div id="new"><hr><center><h1>Project List</h1></center><hr></div>

<%
		List<ProjectBean> list = (ArrayList<ProjectBean>)request.getAttribute("list");
	%>
	<form action="" id="listpage" name="listpage" method="post">
		<input type="hidden" name="project_id" id="project_id">
	</form>
	<table class="newcsstablep" >
		<tr>
		<td>Project_Name
		<td>code
		<td>Description
		<td>status
		<td>technology
		<td>platform
		<td>client
		<td>Estimated_start_date
		<td>Estimated_end_date
		<td>Actual_start_date
		<td>Actual_end_date
		<td>Modified_by
		<td>Modified_date
		
		</tr>
		<%
			if (list != null) {
				ProjectBean bean = new ProjectBean();
				for (int i = 0; i < list.size(); i++) {
					
					bean = list.get(i);
		%>
		<tr>
			<td><%=bean.getProject_name()%></td>
			<td><%=bean.getCode()%></td>
			<td><%=bean.getDescription()%></td>
			<td><%=bean.getBsbean().getStatus_description()%></td>
			<td><%=bean.getPtbean().getTechnology_description()%></td>
			<td><%=bean.getPpbean().getPlatform_description()%></td>
			<td><%=bean.getCbean().getClient_name()%></td>
			<td><%=bean.getEstimated_start_date()%></td>
			<td><%=bean.getEstimated_end_date()%></td>
			<td><%=bean.getActual_start_date()%></td>
			<td><%=bean.getActual_end_date()%></td>
			<td><%=bean.getEbean().getEmployee_firstname()+" "+bean.getEbean().getEmployee_firstname()%></td>
			<td><%=bean.getModified_date()%></td>
			
			<td><a href=# onclick="edit(<%=bean.getProject_id()%>)">Edit</a></td>
			<td><a href=# onclick="del(<%=bean.getProject_id()%>)">Delete</a></td>
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
	<br><a href="ProjectInsert.jsp" >INSERT MORE</a>
	</div>
	<%@include file="footer.jsp"%>
	

</body>
</html>