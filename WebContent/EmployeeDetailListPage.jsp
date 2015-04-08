<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="arthinfosoft.bts.bean.EmployeeDetailBean"%>
<%@include file="header.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
function del(id){
//	alert(id);
	var f=document.ListPage;
	f.tid.value=id;
	f.action="EmployeeDetailDeleteServlet";
	f.submit();
}
function edit(id){
//	alert(id);
	var f=document.ListPage;
	f.tid.value=id;
	f.action="EmployeeDetailEditServlet";
	f.submit();
}
function view(id){
	//alert(id);
	var f=document.ListPage;
	f.tid.value=id;
	//alert(f.tid.value);
	f.show.value="show";
	f.action="EmployeeDetailListServlet";
	f.submit();
}

</script>

</head>
<body>
<div id="new"><hr><center><h1>Employee details List</h1></center><hr></div>

	<form action="" name="ListPage" id="ListPage" method="post">
		<input type="hidden" name="tid" id="tid">
		<input type="hidden" name="show" id="show">
			</form>
		
		<table class="newcsstablep">
			
			
			<%ArrayList<EmployeeDetailBean> list = (ArrayList<EmployeeDetailBean>)request.getAttribute("list");
			String show=request.getParameter("show");
			int id=0;
			if(show==null)
				show=new String();
			else{
			id=Integer.parseInt((String)request.getAttribute("show_id")); 
			}
			
			
			if(!show.equals("show")){
			%>
			<tr>
				<td>Email
				<td>Password
				<td>Employee_firstname
				<td>Employee_lastname
				<td>Designation
				<td>Joining_date
				<td>Is Active
				<td>Role
				<td>Department
				<td>Manager
				<td>Salary
			</tr>
			
			
			<%
			}
			for (int i = 0; i < list.size(); i++) {
					EmployeeDetailBean bean = list.get(i);
			if(show.equals("show")){
			if(id==bean.getEmployee_id()){
			%>	
				<tr></tr>
			<tr><td><a href="EmployeeDetailListServlet">Back</a></tr>
			<tr>
				<td>Email
				<td><%=bean.getEmail()%></td>
			<tr>
				<td>Password
				<td><%=bean.getPassword()%></td>
			<tr>
				<td>Security_question
				<td><%=bean.getSecurity_question()%></td>
			<tr>
				<td>Answer
				<td><%=bean.getAnswer()%></td>
			<tr>
				<td>Employee_firstname
				<td><%=bean.getEmployee_firstname()%></td>
			<tr>
				<td>Employee_lastname
				<td><%=bean.getEmployee_lastname()%></td>
			<tr>
				<td>Permanent_address
				<td><%=bean.getPermanent_address()%></td>
			<tr>
				<td>Temporary_address
				<td><%=bean.getTemporary_address()%></td>
			<tr>
				<td>Mobile
				<td><%=bean.getMobile()%></td>
			<tr>
				<td>Landline
				<td><%=bean.getLandline()%></td>
			<tr>
				<td>Dateofbirth
				<td><%=bean.getDateofbirth()%></td>
			<tr>
				<td>Designation
				<td><%=bean.getDesignation()%></td>
			<tr>
				<td>Joining_date
				<td><%=bean.getJoining_date()%></td>
			<tr>
				<td>Is Active
				<td><%=bean.getIs_active()%></td>
			<tr>
				<td>Role
				<td><%=bean.getRole_name()%></td>
			<tr>
				<td>Department
				<td><%=bean.getDepartment_name()%></td>
			<tr>
				<td>Manager
				<td><%=bean.getManager_name()%></td>
			<tr>
				<td>Salary
				<td><%=bean.getSalary()%></td>
		<%	}
			
			}else{
			%>

			



			<tr>
				<td><%=bean.getEmail()%></td>
				<td><%=bean.getPassword()%></td>
				<td><%=bean.getEmployee_firstname()%></td>
				<td><%=bean.getEmployee_lastname()%></td>
				<td><%=bean.getDesignation()%></td>
				<td><%=bean.getJoining_date()%></td>
				<td><%=bean.getIs_active()%></td>
				<td><%=bean.getRole_name()%></td>
				<td><%=bean.getDepartment_name()%></td>
				<td><%=bean.getManager_name()%></td>
				<td><%=bean.getSalary()%></td>


				<td><a href="#" onclick="edit(<%=bean.getEmployee_id()%>)">EDIT</a> 
				<td><a href="#" onclick="del(<%=bean.getEmployee_id()%>)">DELETE</a>
				<td><a href="#" onclick="view(<%=bean.getEmployee_id()%>)">VIEW</a>
			</tr>
			<%
			}}
			%>
		</table>
	
		<div id="insert_link"> 
		<br><a href="EmployeeDetailInsertPage.jsp">INSERT MORE</a>
		</div> 
		<%@include file="footer.jsp"%>
		


</body>
</html>