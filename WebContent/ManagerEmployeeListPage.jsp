<%@page import="java.util.ArrayList"%>
<%@page import="arthinfosoft.bts.bean.ManagerEmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Employee List Page</title>

<script type="text/javascript">
function del(id){
//	alert(id);
	var f=document.ListPage;
	f.tid.value=id;
	f.action="ManagerEmployeeDeleteServlet";
	f.submit();
}
function edit(id){
//	alert(id);
	var f=document.ListPage;
	f.tid.value=id;
	f.action="ManagerEmployeeEditServlet";
	f.submit();
}
</script>

</head>

<body>
<div id="new"><hr><center><h1>Manager Employee List</h1></center><hr></div>

	<form action="" name="ListPage" method="post">
		<input type="hidden" name="tid" id="tid">
		<table class="newcsstablep">
		
			<tr>
				<td>Employee Id
			</tr>

			<%
				ArrayList<ManagerEmployeeBean> list = (ArrayList<ManagerEmployeeBean>) request
						.getAttribute("list");
				for (int i = 0; i < list.size(); i++) {
					ManagerEmployeeBean bean = list.get(i);
			%>

			<tr>
				<td><%=bean.getEbean().getEmployee_firstname()+" "+bean.getEbean().getEmployee_lastname()%></td>

				<td><a href="#" onclick="edit(<%=bean.getManager_id()%>)">
						EDIT</a><td> <a href="#" onclick="del(<%=bean.getManager_id()%>)">DELETE</a>
			</tr>
			<%
				}
			%>
		</table>
<div id="insert_link"> 

<br><a href="ManagerEmployeeInsertPage.jsp">INSERT MORE</a>
</div>
<%@include file="footer.jsp"%>

	</form>
</body>
</html>