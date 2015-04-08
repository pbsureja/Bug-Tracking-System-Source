<%@page import="java.util.ArrayList"%>
<%@include file="header.jsp"%>
<%@page import="arthinfosoft.bts.bean.Client_DetailsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client_Details List Page</title>
<script type="text/javascript"> 
function del(id) {
	var f=document.listpage;
	alert(id);
	f.tid.value=id;
	f.action="Client_DetailsDeleteServlet";
	f.submit();
}
function edit(id) {
	var f=document.listpage;
	
	//alert(id);
	f.tid.value=id;
	f.action="Client_DetailsEditServlet";
	f.submit();
}
</script>
</head>
<body>

<%
		List<Client_DetailsBean> list = (ArrayList<Client_DetailsBean>)request.getAttribute("list");
	%>
	<div id="new"><hr><center><h1>Client Detail List</h1></center><hr></div>
	<form action="" id="listpage" name="listpage" method="post">
		<input type="hidden" name="tid" id="tid">
	</form>
	<table class="newcsstablep">
		<tr>
			<td><b>Name</b></td>
			<td><b>Email</b></td>
			<td><b>Password</b></td>
			<td><b>Security Question</b></td>
			<td><b>Answer</b></td>
			<td><b>Phone No</b></td>
			<td><b>Address<b></td>
			<td><b>Fax</b></td>
			<td><b>Website</b></td>
			</b>
		</tr>
		<%
			if (list != null) {
				Client_DetailsBean bean = new Client_DetailsBean();
				for (int i = 0; i < list.size(); i++) {
					
					bean = list.get(i);
		%>
		<tr>
			<td><%=bean.getClient_name()%></td>
			<td><%=bean.getEmail()%></td>
			<td><%=bean.getPassword()%></td>
			<td><%=bean.getSecurityquestion()%></td>
			<td><%=bean.getAnswer()%></td>
			<td><%=bean.getPhone_no()%></td>
			<td><%=bean.getAddress()%></td>
			<td><%=bean.getFax()%></td>
			<td><%=bean.getWebsite()%></td>
			
			<td><a href=# onclick="edit(<%=bean.getClient_id()%>)">Edit</a></td>
			<td><a href=# onclick="del(<%=bean.getClient_id()%>)">Delete</a></td>
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
<br><a href="Client_DetailsInsert.jsp" >INSERT MORE</a>
</div>
<%@include file="footer.jsp"%>
</body>
</html>