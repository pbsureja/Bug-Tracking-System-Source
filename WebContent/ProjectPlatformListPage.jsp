<%@page import="arthinfosoft.bts.bean.ProjectPlatformBean"%>
<%@page import="arthinfosoft.bts.bean.PmtStatusBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Platform List Page</title>
<script type="text/javascript">
function del(id){
//	alert(id);
	var f=document.ProjectPlatformListPage;
	f.tid.value=id;
	f.action="ProjectPlatformDeleteServlet";
	f.submit();
}
function edit(id){
//	alert(id);
	var f=document.ProjectPlatformListPage;
	f.tid.value=id;
	f.action="ProjectPlatformEditServlet";
	f.submit();
}
</script>

</head>

<body>
<div id="new"><hr><center><h1>Project Platform List</h1></center><hr></div>

<form action="" name="ProjectPlatformListPage" method="post">
<input type="hidden" name="tid" id="tid">
<table class="newcsstablep" >
<tr>
<td> Platform Description 
</tr>
<%
ArrayList<ProjectPlatformBean> list=(ArrayList<ProjectPlatformBean>)request.getAttribute("list");
for(int i=0;i<list.size();i++){
	ProjectPlatformBean bean=list.get(i);
	%>
<tr>
<td><%=bean.getPlatform_description() %>

<td> <a href="#" onclick="edit(<%=bean.getPlatform_id()%>)"> EDIT</a>
<td> <a href="#" onclick="del(<%=bean.getPlatform_id()%>)">DELETE</a>
</tr>	
	<% }%>
</table>
	
<div id="insert_link"> 

<br><a href="ProjectPlatformInsertPage.jsp"" >INSERT MORE</a>
</div>
<%@include file="footer.jsp"%>

</form>
</body>
</html>