<%@page import="java.io.File"%>
<%@page import="arthinfosoft.bts.dao.Bug_DetailsDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="arthinfosoft.bts.bean.Bug_SnapshotsBean"%>
<%@page import="arthinfosoft.bts.bean.Bug_DetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<%Bug_SnapshotsBean bean=(Bug_SnapshotsBean)request.getAttribute("bean");
int a=bean.getBug_id();
%>
<div id="new">
<hr><center><h1>Bug Snapshot Edit Form</h1></center><hr>
<form action="Bug_SnapshotsUpdateServlet" name="bugsnapshot" method="post" enctype="multipart/form-data">
<input type="hidden" name="snapshot_id" value="<%=bean.getSnapshot_id()%>">
<input type="hidden" name="snapshot_description" value="<%=bean.getSnapshot_description()%>">
<table align="center">
<tr>
<td>Bug_Id</td>
<%
				
List<Bug_DetailsBean> list = new ArrayList<Bug_DetailsBean>();
				 Bug_DetailsDAO dao = new Bug_DetailsDAO();
			       list = dao.listData(); 
			       Bug_DetailsBean bean_bug_details=new Bug_DetailsBean(); 
			       %>
				<td><select name="bug_id" id="bug_id">
						<option value="">----Select Bug_Name----</option>
				<%if(list!=null){
				for(int i=0;i<list.size();i++){ 
				bean_bug_details=(Bug_DetailsBean)list.get(i);
				int test=bean_bug_details.getBug_id();%>
						<option value="<%=test%>" <%if(a ==test) {%> selected="selected" <%}%>><%=bean_bug_details.getBug_name()%></option>
				<%}} %>
				</select>${bug_id}   ${big_id_length}</td></tr>
				
<tr><td>Snapshot</td><td><input type="file" name="snapshot_description" value="<%=bean.getSnapshot_description()%>"></td></tr>
<tr><td>Details</td><td><img src="<%="images"+File.separator+bean.getSnapshot_description()%>" height="200" width="200"></td></tr>
<tr>    <td colspan="2" align="center"><input type="submit" name="submit" > </td>

</table>


</form>
</div>

<%@include file="footer.jsp"%>
</body>
</html>