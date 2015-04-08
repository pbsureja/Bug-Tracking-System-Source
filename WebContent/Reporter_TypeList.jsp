<%@page import="java.util.ArrayList"%>
<%@page import="arthinfosoft.bts.bean.Reporter_TypeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   

<%@include file="header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporter Type List Page</title>
<script type="text/javascript"> 
function del(id) {
	var f=document.listpage;
//	alert(id);
	f.tid.value=id;
	f.action="Reporter_TypeDeleteServlet";
	f.submit();
}
function edit(id) {
	var f=document.listpage;
	
	//alert(id);
	f.tid.value=id;
	f.action="Reporter_TypeEditServlet";
	f.submit();
}
</script>
</head>
<body>
<div id="new"><hr><center><h1>Reporter Type List</h1></center><hr></div>

<%
		List<Reporter_TypeBean> list = (ArrayList<Reporter_TypeBean>)request.getAttribute("list");
	%>
	<form action="" id="listpage" name="listpage" method="post">
		<input type="hidden" name="tid" id="tid">
	</form>
	<table class="newcsstablep" >
		<tr>
			<td>Description</td>
			
		</tr>
		<%
			if (list != null) {
				Reporter_TypeBean bean = new Reporter_TypeBean();
				for (int i = 0; i < list.size(); i++) {
					
					bean = list.get(i);
		%>
		<tr>
			<td><%=bean.getReporter_type_name()%></td>
			<td><a href=# onclick="edit(<%=bean.getReporter_type_id()%>)">Edit</a></td>
			<td><a href=# onclick="del(<%=bean.getReporter_type_id()%>)">Delete</a></td>
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
	
<br><a href="Reporter_TypeInsert.jsp"">INSERT MORE</a>
</div>
<%@include file="footer.jsp"%>

</body>
</html>