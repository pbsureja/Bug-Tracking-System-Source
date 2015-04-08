<%@page import="arthinfosoft.bts.bean.BugTypeBean"%>
<%@page import="java.util.ArrayList"%>
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
	var f=document.BugTypeListPage;
	f.tid.value=id;
	f.action="BugTypeDeleteServlet";
	f.submit();
}
function edit(id){
//	alert(id);
	var f=document.BugTypeListPage;
	f.tid.value=id;
	f.action="BugTypeEditServlet";
	f.submit();
}
</script>

</head>
<body>

<div id="new"><hr><center><h1>Bug Type List</h1></center><hr></div>
	<form action="" name="BugTypeListPage" method="post">
		<input type="hidden" name="tid" id="tid">
		<table class="newcsstablep" align="center" >
			<tr>
				<td>Bug Type Description
			</tr>
			<%
				ArrayList<BugTypeBean> list = (ArrayList<BugTypeBean>) request.getAttribute("list");
				for (int i = 0; i < list.size(); i++) {
					BugTypeBean bean = list.get(i);
			%>
			<tr>
				<td><%=bean.getBug_type_description()%>
				<td><a href="#" onclick="edit(<%=bean.getBug_type_id()%>)">
						EDIT</a> <td><a href="#" onclick="del(<%=bean.getBug_type_id()%>)">DELETE</a>
			</tr>
			<%
				}
			%>
		</table>
	<div id="insert_link"> 
<br><a href="BugTypeInsertPage.jsp" >INSERT MORE</a>
	</div> <%@include file="footer.jsp"%>
	
	</form>
</body>
</html>