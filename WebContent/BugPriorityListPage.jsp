<%@page import="arthinfosoft.bts.bean.BugPriorityBean"%>
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
	var f=document.BugPriorityListPage;
	f.tid.value=id;
	f.action="BugPriorityDeleteServlet";
	f.submit();
}
function edit(id){
//	alert(id);
	var f=document.BugPriorityListPage;
	f.tid.value=id;
	f.action="BugPriorityEditServlet";
	f.submit();
}
</script>

</head>
<body>
<div id="new"><hr><center><h1>Bug Priority List</h1></center><hr></div>

	<form action="" name="BugPriorityListPage" method="post">
		<input type="hidden" name="tid" id="tid">
		<table class="newcsstablep"  >
			<tr>
				<td> Bug Priority Description
			</tr>
			<%
				ArrayList<BugPriorityBean> list = (ArrayList<BugPriorityBean>) request.getAttribute("list");
				for (int i = 0; i < list.size(); i++) {
					BugPriorityBean bean = list.get(i);
			%>
			<tr>
				<td><%=bean.getBug_priority_description()%>
				<td><a href="#" onclick="edit(<%=bean.getBug_priority_id()%>)">
						EDIT</a> <td><a href="#" onclick="del(<%=bean.getBug_priority_id()%>)">DELETE</a>
			</tr>
			<%
				}
			%>
		</table>
		<div id="insert_link"> 
		  	<br><a href="BugPriorityInsertPage.jsp" >INSERT MORE</a>
		</div>
		<%@include file="footer.jsp"%>
	</form>
</body>
</html>