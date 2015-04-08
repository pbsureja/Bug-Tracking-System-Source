<%@page import="arthinfosoft.bts.dao.ModuleDAO"%>
<%@page import="arthinfosoft.bts.dao.ProjectDAO"%>
<%@page import="arthinfosoft.bts.bean.ProjectBean"%>
<%@page import="arthinfosoft.bts.bean.ModuleBean"%>
<%@page import="arthinfosoft.bts.dao.EmployeeDetailDAO"%>
<%@page import="arthinfosoft.bts.bean.EmployeeDetailBean"%>
<%@page import="arthinfosoft.bts.dao.BugTypeDAO"%>
<%@page import="arthinfosoft.bts.bean.BugTypeBean"%>
<%@page import="arthinfosoft.bts.dao.BugPriorityDAO"%>
<%@page import="arthinfosoft.bts.bean.BugPriorityBean"%>
<%@page import="arthinfosoft.bts.dao.Reporter_TypeDAO"%>
<%@page import="arthinfosoft.bts.bean.Reporter_TypeBean"%>
<%@page import="arthinfosoft.bts.dao.BugStatusDAO"%>
<%@page import="arthinfosoft.bts.dao.TaskDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="arthinfosoft.bts.bean.Bug_DetailsBean"%>
<%@page import="arthinfosoft.bts.bean.TaskBean"%>
<%@page import="arthinfosoft.bts.bean.BugStatusBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="arthinfosoft.bts.bean.BugStatusBean"%>
<%@include file="header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bug type Insert Page</title>
<link rel="stylesheet"
	href="jquery-ui-1.10.4.custom/css/start/jquery-ui-1.10.4.custom.css" />
<link rel="stylesheet"
	href="jQuery-Validation/css/validationEngine.jquery.css" />
<script src="jquery-ui-1.10.4.custom/js/jquery-1.10.2.js"></script>
<script src="jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.js"></script>
<script src="jQuery-Validation/js/jquery.validationEngine.js"></script>
<script
	src="jQuery-Validation/js/languages/jquery.validationEngine-en.js"></script>
<script src="js/jq.js"></script>

</head>
<body>
	
	<% int count=1;
		Bug_DetailsBean bean = (Bug_DetailsBean) request.getAttribute("bean");
		if (bean == null) {
			bean = new Bug_DetailsBean();
			count=0;
		}
int a=bean.getTask_id();
int b=bean.getBug_status_id();
int c=bean.getReporter_type_id();
int d=bean.getReported_by();
int e=bean.getBug_Priority_id();
int f=bean.getBug_type_id();
		%>
	
		 <div id="new" >
		 <hr><center><h1>Bug Detail Insert Form</h1></center><hr>
 
	
	<form action="Bug_DetailsInsertServlet" name="bug_details" id="bug_details"
		method="post"  >
	
		<table align="center" >
			<tr>
				<td>Task Name</td>
					<%{
				 List<TaskBean> list = new ArrayList<TaskBean>();
				 
				 TaskDAO dao = new TaskDAO();
			       list = dao.listData(); 
			       TaskBean bean_b=new TaskBean();
			       %>
				<td><select name="task_id" id="task_id" >
						<option value="">----Select Task Name----</option>
				<%if(list!=null){
					for(int i=0;i<list.size();i++)
					{
					
					bean_b=(TaskBean)list.get(i);
				int test=bean_b.getTask_id();%>
						<option value="<%=test%>" <%if(a ==test) {%> selected="selected" <%}%>><%=bean_b.getPbean().getProject_name()%>--><%=bean_b.getMbean().getProject_name()%>--><%=bean_b.getProject_name()%></option>
				<%}} }%>
				
				
				</select>${task_id} </td>
			</tr>
			
			
			<tr>
				<td>Bug Name</td>
				<td><input type="text" name="bug_name"
					value="<%=bean.getBug_name()%>" class="validate[required] text-input">${bug_name}
					${bug_name_length}</td>
			</tr>
			
			
			<tr>
				<td>Bug Status </td>
								<%{
				 List<BugStatusBean> list = new ArrayList<BugStatusBean>();
				 BugStatusDAO dao = new BugStatusDAO();
			       list = dao.listData(); 
			       BugStatusBean bean_b=new BugStatusBean(); 
			       %>
				<td><select name="bug_status_id" id="bug_status_id">
						<option value="">----Select Bug Status----</option>
				<%if(list!=null){
				for(int i=0;i<list.size();i++){ 
					bean_b=(BugStatusBean)list.get(i);
				int test=bean_b.getBug_status_id();%>
						<option value="<%=test%>" <%if(b ==test) {%> selected="selected" <%}%>><%=bean_b.getBug_status_description()%></option>
				<%}}} %>
				</select>${bug_status_id} </td>
			</tr>
			
			
			<tr>
				<td>Reporter Type</td>
										<%{
				 List<Reporter_TypeBean> list = new ArrayList<Reporter_TypeBean>();
				 Reporter_TypeDAO dao = new Reporter_TypeDAO();
			       list = dao.listData(); 
			       Reporter_TypeBean bean_b=new Reporter_TypeBean(); 
			       %>
				<td><select name="reporter_type_id" id="reporter_type_id">
						<option value="">----Select Reporter Type ----</option>
				<%if(list!=null){
				for(int i=0;i<list.size();i++){ 
					bean_b=(Reporter_TypeBean)list.get(i);
				int test=bean_b.getReporter_type_id();%>
						<option value="<%=test%>" <%if(c ==test) {%> selected="selected" <%}%>><%=bean_b.getReporter_type_name()%></option>
				<%}}} %>
				</select>${reporter_type_id} </td>
			</tr>
			
			<tr>
				<td>Reported By</td>
					<%{
				 List<EmployeeDetailBean> list = new ArrayList<EmployeeDetailBean>();
				 EmployeeDetailDAO dao = new EmployeeDetailDAO();
			       list = dao.listData(); 
			       EmployeeDetailBean bean_b=new EmployeeDetailBean(); 
			       %>
				<td><select name="reported_by" id="reported_by">
						<option value="">----Select Reported By----</option>
				<%if(list!=null){
				for(int i=0;i<list.size();i++){ 
					bean_b=(EmployeeDetailBean)list.get(i);
				int test=bean_b.getEmployee_id();%>
						<option value="<%=test%>" <%if(c ==test) {%> selected="selected" <%}%>><%=bean_b.getEmployee_firstname()+" "+bean_b.getEmployee_lastname()%></option>
				<%}}} %>
				</select>${reported_by} </td>
			</tr>
			
			
			<tr>
				<td>Priority</td>
											<%{
				 List<BugPriorityBean> list = new ArrayList<BugPriorityBean>();
				 BugPriorityDAO dao = new BugPriorityDAO();
			       list = dao.listData(); 
			       BugPriorityBean bean_b=new BugPriorityBean(); 
			       %>
				<td><select name="priority_id" id="priority_id">
						<option value="">----Select Priority----</option>
				<%if(list!=null){
				for(int i=0;i<list.size();i++){ 
					bean_b=(BugPriorityBean)list.get(i);
				int test=bean_b.getBug_priority_id();%>
						<option value="<%=test%>" <%if(e ==test) {%> selected="selected" <%}%>><%=bean_b.getBug_priority_description()%></option>
				<%}}} %>
				</select>${priority_id}</td>
			</tr>
			
			<tr>
				<td>Reported Date</td>
				<td><input type="text" name="reported_date" id="reported_date" class="validate[required] text-input datepicker" 
					value="<%=bean.getReported_date()%>" >${reported_date}
					</td>
			</tr>
			
			
			<tr>
				<td>Bug Type</td>
				<%{
				 List<BugTypeBean> list = new ArrayList<BugTypeBean>();
				 BugTypeDAO dao = new BugTypeDAO();
			       list = dao.listData(); 
			       BugTypeBean bean_b=new BugTypeBean(); 
			       %>
				<td><select name="bug_type_id" id="bug_type_id">
						<option value="">----Select Bug type----</option>
				<%if(list!=null){
				for(int i=0;i<list.size();i++){ 
					bean_b=(BugTypeBean)list.get(i);
				int test=bean_b.getBug_type_id();%>
						<option value="<%=test%>" <%if(f ==test) {%> selected="selected" <%}%>><%=bean_b.getBug_type_description()%></option>
				<%}}} %>
				</select>${bug_type_id}</td>
			</tr>	
			<tr>    <td colspan="2" align="center"><input type="submit" name="submit" > <%if(count==0) { %><input type="reset" name="reset"><%} %> </td>
			
		</table>
		
	</form>
	</div>
<%@include file="footer.jsp"%>
</body>

</html>
