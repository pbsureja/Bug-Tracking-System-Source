<%@page import="arthinfosoft.bts.bean.PmtStatusBean"%>
<%@include file="header.jsp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PMT Status List Page</title>

<script type="text/javascript">
function del(id){
//	alert(id);
	var f=document.PmtStatusListPage;
	f.tid.value=id;
	f.action="PmtStatusDeleteServlet";
	f.submit();
}
function edit(id){
//	alert(id);
	var f=document.PmtStatusListPage;
	f.tid.value=id;
	f.action="PmtStatusEditServlet";
	f.submit();
}
</script>

</head>
<body>
<div id="new">
<hr><center><h1>Project Module Task Status List</h1></center><hr></div>

<form action="" name="PmtStatusListPage" method="post">
<input type="hidden" name="tid" id="tid">
<table class="newcsstablep" >
<tr>
<td> Project module Task Status Description 
</tr>
<%
ArrayList<PmtStatusBean> list=(ArrayList<PmtStatusBean>)request.getAttribute("list");
for(int i=0;i<list.size();i++){
	PmtStatusBean bean=list.get(i);

	%>
<tr>
<td><%=bean.getStatus_description()%>

<td><a href="#" onclick="edit(<%=bean.getStatus_id()%>)"> EDIT</a>
<td>	<a href="#" onclick="del(<%=bean.getStatus_id()%>)">DELETE</a>
</tr>	
	<% }%>
</table>
</form>

<div id="insert_link"> 
<br>
<a href="PmtStatusInsertPage.jsp" >INSERT MORE</a>
</div>
<%@include file="footer.jsp"%>

</body>
</html>