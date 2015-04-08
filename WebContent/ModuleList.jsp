<%@page import="java.util.ArrayList"%>
<%@page import="arthinfosoft.bts.bean.ModuleBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Module List Page</title>
<script type="text/javascript"> 
function del(id) {
	var f=document.listpage;
//	alert(id);
	f.module_id.value=id;
	f.action="ModuleDeleteServlet";
	f.submit();
}
function edit(id) {
	var f=document.listpage;
//	alert(id);
	f.module_id.value=id;
	f.action="ModuleEditServlet";
	f.submit();
}
</script>
</head>
<body>
<div id="new"><hr><center><h1>Module List</h1></center><hr></div>

<%
		List<ModuleBean> list = (ArrayList<ModuleBean>)request.getAttribute("list");
	%>
	<form action="" id="listpage" name="listpage" method="post">
		<input type="hidden" name="module_id" id="module_id">
	</form>
	<table class="newcsstablep" >
		<tr>
			<td>Project_Name</td>
			<td>code</td>
			<td>Description</td>
			<td>status</td>
			<td>project</td>
			<td>Estimated_start_date</td>
			<td>Estimated_end_date</td>
			<td>Actual_start_date</td>
			<td>Actual_end_date</td>
			<td>Modified</td>
			<td>Modified_date</td>
			
		</tr>
		<%
			if (list != null) {
				ModuleBean bean = new ModuleBean();
				for (int i = 0; i < list.size(); i++) {
					
					bean = list.get(i);
		%>
		<tr>
			<td><%=bean.getProject_name()%></td>
			<td><%=bean.getCode()%></td>
			<td><%=bean.getDescription()%></td>
			<td><%=bean.getBsbean().getStatus_description()%></td>
			<td><%=bean.getPbean().getProject_name()%></td>
			<td><%=bean.getEstimated_start_date()%></td>
			<td><%=bean.getEstimated_end_date()%></td>
			<td><%=bean.getActual_start_date()%></td>
			<td><%=bean.getActual_end_date()%></td>
			<td><%=bean.getEbean().getEmployee_firstname()+" "+bean.getEbean().getEmployee_firstname()%></td>
			<td><%=bean.getModified_date()%></td>
			
			<td><a href=# onclick="edit(<%=bean.getModule_id()%>)">Edit</a></td>
			<td><a href=# onclick="del(<%=bean.getModule_id()%>)">Delete</a></td>
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
	
<br><a href="ModuleInsert.jsp" >INSERT MORE</a>
	</div>
<%@include file="footer.jsp"%>
	

</body>
</html>