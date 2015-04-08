<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="arthinfosoft.bts.bean.GroupBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file="header.jsp"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function del(id){
//	alert(id);
	var f=document.ListPage;
	f.tid.value=id;
	f.action="GroupDeleteServlet";
	f.submit();
}
function edit(id){
//	alert(id);
	var f=document.ListPage;
	f.tid.value=id;
	f.action="GroupEditServlet";
	f.submit();
}
</script>

</head>
<body>
<div id="new"><hr><center><h1>Group List</h1></center><hr></div>

	<form action="" name="ListPage" method="post">
		<input type="hidden" name="tid" id="tid">
		<table class="newcsstablep">
			
			<tr>
				<td>Group Description
				<td>Max Limit
				<td>Manager Name
			</tr>

			<%
				ArrayList<GroupBean> list = (ArrayList<GroupBean>) request
						.getAttribute("list");
				for (int i = 0; i < list.size(); i++) {
					GroupBean bean = list.get(i);
			%>

			<tr>
				<td><%=bean.getGroup_description()%></td>
				<td><%=bean.getMax_limit()%></td>
				<td><%=bean.getEbean().getEmployee_firstname()+" "+bean.getEbean().getEmployee_lastname()%></td>


				<td><a href="#" onclick="edit(<%=bean.getGroup_id()%>)">
						EDIT</a>
						<td> <a href="#" onclick="del(<%=bean.getGroup_id()%>)">DELETE</a>
			</tr>
			<%
				}
			%>
		</table>
		<div id="insert_link"> 
		
	<br><a href="GroupInsertPage.jsp" >INSERT MORE</a>
</div>
<%@include file="footer.jsp"%>

	</form>
	
</body>
</html>