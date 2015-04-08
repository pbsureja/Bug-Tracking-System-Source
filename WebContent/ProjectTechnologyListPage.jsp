<%@page import="arthinfosoft.bts.bean.ProjectTechnologyBean"%>
<%@page import="arthinfosoft.bts.bean.PmtStatusBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Technology List Page</title>
<script type="text/javascript">
function del(id){
//	alert(id);
	var f=document.ProjectTechnologyListPage;
	f.tid.value=id;
	f.action="ProjectTechnologyDeleteServlet";
	f.submit();
}
function edit(id){
//	alert(id);
	var f=document.ProjectTechnologyListPage;
	f.tid.value=id;
	f.action="ProjectTechnologyEditServlet";
	f.submit();
}
</script>

</head>

<body>
<div id="new"><hr><center><h1>Project Technology List</h1></center><hr></div>

<form action="" name="ProjectTechnologyListPage" method="post">
<input type="hidden" name="tid" id="tid">
<table class="newcsstablep" >
<tr>
<td>Technology Description
</tr>
<%
ArrayList<ProjectTechnologyBean> list=(ArrayList<ProjectTechnologyBean>)request.getAttribute("list");
for(int i=0;i<list.size();i++){
	ProjectTechnologyBean bean=list.get(i);
	%>
<tr>
<td><%=bean.getTechnology_description() %>

<td><a href="#" onclick="edit(<%=bean.getTechnology_id()%>)"> EDIT</a>
<td><a href="#" onclick="del(<%=bean.getTechnology_id()%>)">DELETE</a>
</tr>	
	<% }%>
</table>
<div id="insert_link"> 

<br><a href="ProjectTechnologyInsertPage.jsp" >INSERT MORE</a>
</div>
<%@include file="footer.jsp"%>


</form>
</body>
</html>