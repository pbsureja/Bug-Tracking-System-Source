<%@page import="arthinfosoft.bts.bean.BugStatusBean"%>
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
	var f=document.BugStatusListPage;
	f.tid.value=id;
	f.action="BugStatusDeleteServlet";
	f.submit();
}
function edit(id){
//	alert(id);
	var f=document.BugStatusListPage;
	f.tid.value=id;
//	alert(f.tid.value);
	f.action="BugStatusEditServlet";
	f.submit();
}
</script>

</head>
<body>
	<div id="new"><hr><center><h1>Bug Status List</h1></center><hr></div>

	<form action="" name="BugStatusListPage" method="post">
		<input type="hidden" name="tid" id="tid">
		<table class="newcsstablep"  >
			<tr>
				<td>Bug Status Description
			</tr>
			<%
				ArrayList<BugStatusBean> list = (ArrayList<BugStatusBean>) request.getAttribute("list");
				for (int i = 0; i < list.size(); i++) {
					BugStatusBean bean = list.get(i);
			%>
			<tr>
				<td><%=bean.getBug_status_description()%>
				<td><a href="#" onclick="edit(<%=bean.getBug_status_id()%>)">
						EDIT</a><td> <a href="#" onclick="del(<%=bean.getBug_status_id()%>)">DELETE</a>
			</tr>
			<%
				}
			%>
		</table>
	<div id="insert_link"> 
<br><a href="BugStatusInsertPage.jsp"  >INSERT MORE</a>
	</div>
<%@include file="footer.jsp"%>
	</form>
</body>
</html>