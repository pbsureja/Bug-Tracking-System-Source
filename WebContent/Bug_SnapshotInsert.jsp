<%@page import="java.util.List"%>
<%@page import="arthinfosoft.bts.dao.Bug_DetailsDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="arthinfosoft.bts.bean.Bug_SnapshotsBean"%>
<%@page import="arthinfosoft.bts.bean.Bug_DetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Page</title>
</head>
<body>
 <div id="new">
<hr><center><h1>Bug Snapshot Insert Form</h1></center><hr>

	<% int count=1;
		Bug_SnapshotsBean bean = (Bug_SnapshotsBean) request
				.getAttribute("bean");
		if (bean == null) {
			bean = new Bug_SnapshotsBean();
			count=0;
		}
		int a = bean.getBug_id();
	%>
	<form action="Bug_SnapshotsInsertServlet" name="bugsnapshot"
		method="post" enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td>Bug Name</td>
				<%
				 List<Bug_DetailsBean> list = new ArrayList<Bug_DetailsBean>();
				 Bug_DetailsDAO dao = new Bug_DetailsDAO();
			       list = dao.listData(); 
			       Bug_DetailsBean bean_bug_details=new Bug_DetailsBean(); 
			       %>
				<td><select name="bug_id" id="bug_id">
						<option value="">----Select Bug Name----</option>
				<%if(list!=null){
				for(int i=0;i<list.size();i++){ 
				bean_bug_details=(Bug_DetailsBean)list.get(i);
				int test=bean_bug_details.getBug_id();%>
						<option value="<%=test%>" <%if(a ==test) {%> selected="selected" <%}%>><%=bean_bug_details.getBug_name()%></option>
				<%}} %>
				
				
				</select>${bug_id} ${big_id_length}</td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="file" name="snapshot_description"
					value="<%=bean.getSnapshot_description()%>">${snapshot_description}
					${snapshot_description_length}</td>
			</tr>
	<tr>    <td colspan="2" align="center"><input type="submit" name="submit" > <%if(count==0) { %><input type="reset" name="reset"><%} %> </td>
	</table>
		

	</form>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>