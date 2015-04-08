<%@page import="arthinfosoft.bts.bean.EmployeeDetailBean"%>
<%@page import="arthinfosoft.bts.dao.EmployeeDetailDAO"%>
<%@page import="arthinfosoft.bts.bean.ManagerEmployeeBean"%>
<%@page import="java.util.List"%>
<%@page import="arthinfosoft.bts.dao.ManagerEmployeeDAO"%>
<%@page import="arthinfosoft.bts.bean.GroupBean"%>
<%@page import="arthinfosoft.bts.dao.GroupDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@include file="header.jsp"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="jquery-ui-1.10.4.custom/css/start/jquery-ui-1.10.4.custom.css" />
<link rel="stylesheet"
	href="jQuery-Validation/css/validationEngine.jquery.css" />
<script src="jquery-ui-1.10.4.custom/js/jquery-1.10.2.js"></script>
<script src="jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.js"></script>
<script src="jQuery-Validation/js/jquery.validationEngine.js"></script>
<script
	src="jQuery-Validation/js/languages/jquery.validationEngine-en.js"></script>
<script src="js/jq.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div id="new">
<hr><center><h1>Group Insert Form</h1></center><hr>

<form id="form" action="GroupInsertServlet" name="groupinsertpage" method="post">

<%	int count=1;

	GroupBean bean=(GroupBean) request.getAttribute("bean");
	if(bean==null){
		bean=new GroupBean();
		count=0;
	}
	int a=bean.getManager_id();
%>

<table align="center"  >

<tr>
	<td>Group description: 
	<td><input type="text" class="validate[required,maxSize[20]] text-input"
	 id="group_description" name="group_description" value="${bean.group_description}">${group_description}${group_description_length}
<tr>
	<td>Max Group Size:
	<td><input type="text" id="max_limit" name="max_limit" class="validate[required,maxSize[3],custom[onlyNumberSp]] text-input" value="${bean.max_limit}">${max_limit}${max_limit_length}

	        <%	ManagerEmployeeDAO dao_manager=new ManagerEmployeeDAO();
				List<ManagerEmployeeBean> list_manager=dao_manager.listData();
				
			%>
<tr>
	<td>Manager: 
	<td><select name="manager_id" id="manager_id"> 
		<option value="0" id="0" >--SELECT MANAGER--</option>
		<%
						if(list_manager!=null){
							for(int i=0;i<list_manager.size();i++){
								ManagerEmployeeBean bean_manager=(ManagerEmployeeBean)list_manager.get(i);
								int test=bean_manager.getManager_id();
								EmployeeDetailDAO dao_emp=new EmployeeDetailDAO();
								EmployeeDetailBean bean_emp=dao_emp.editData(bean_manager.getEmployee_id());
						%>
						<option value="<%=test%>" <%if (a == test) {%> selected="selected" <%}%>><%=bean_emp.getEmployee_firstname()%>  
						<%
						}
						}
						%>
	
	</select>${manager_id}
	<tr>    <td colspan="2" align="center"><input type="submit" name="submit" > <%if(count==0) { %><input type="reset" name="reset"><%} %> </td>
	
	</table>

</form>
</div>
<%@include file="footer.jsp"%>

</body>
</html>