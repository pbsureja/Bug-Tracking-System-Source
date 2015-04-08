<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="arthinfosoft.bts.bean.Bug_SnapshotsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"> 
function del(id) {
	var f=document.listpage;
	//alert(id);
	f.tid.value=id;
	f.action="Bug_SnapshotsDeleteServlet";
	f.submit();
}
function edit(id) {
	var f=document.listpage;
	
	//alert(id);
	f.tid.value=id;
	f.action="Bug_SnapshotEditServlet";
	f.submit();
}
</script>
</head>
<body>
<div id="new"><hr><center><h1>Bug Snapshot List</h1></center><hr></div>

<%
		List<Bug_SnapshotsBean> list = (ArrayList<Bug_SnapshotsBean>)request.getAttribute("list");
		ServletContext context = getServletContext();
		String path = context.getRealPath(File.separator)+"images"+File.separator;

	%>
	<form action="" id="listpage" name="listpage" method="post">
		<input type="hidden" name="tid" id="tid">
	</form>
	<table class="newcsstablep" >
		<tr>
<td>Bug_id</td>
<td>Snapshot_Description</td>
<td>View</td>
<td>Bug_Name</td>
		</tr>
		<%
			if (list != null) {
				Bug_SnapshotsBean bean = new Bug_SnapshotsBean();
				for (int i = 0; i < list.size(); i++) {
				bean = list.get(i);
		%>
		<tr>
			<td><%=bean.getBug_id()%></td>
			<td><img src="<%="images"+File.separator+bean.getSnapshot_description()%>" height="200" width="200"></td>
			<td><a href="<%="images"+File.separator+bean.getSnapshot_description()%>">View</a></td>
			<td><%=bean.getBbean().getBug_name()%></td>
			
			<td><a href=# onclick="edit(<%=bean.getSnapshot_id()%>)">Edit</a></td>
			<td><a href=# onclick="del(<%=bean.getSnapshot_id()%>)">Delete</a></td>
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

	<br>	
	<div id="insert_link"> 
	<a href="Bug_SnapshotInsert.jsp">INSERT MORE</a>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>