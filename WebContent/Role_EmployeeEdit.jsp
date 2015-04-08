<%@page import="arthinfosoft.bts.bean.Role_EmployeeBean"%>
		
<%@include file="header.jsp"%>

<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Role Employee Edit Page</title>
<link rel="stylesheet" href="jquery-ui-1.10.4.custom/css/start/jquery-ui-1.10.4.custom.css" />
<link rel="stylesheet"
	href="jQuery-Validation/css/validationEngine.jquery.css" />
<script src="jquery-ui-1.10.4.custom/js/jquery-1.10.2.js"></script>
<script src="jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.js"></script>
<script src="jQuery-Validation/js/jquery.validationEngine.js"></script>
<script
	src="jQuery-Validation/js/languages/jquery.validationEngine-en.js"></script>
<script src="js/jq.js"></script></head>

<body>

 <div id="new">
<hr><center><h1>Role Employee Edit Form</h1></center><hr>
<form action="Role_EmployeeUpdateServlet" method="post" id="form">

		<%
			Role_EmployeeBean bean = (Role_EmployeeBean) request
					.getAttribute("bean");
		
		%>

		<input type="hidden" name="Role_id" value="<%=bean.getRole_id()%>">
			<table align="center" >
				<tr>
					<td>Role Description</td>
					<td><input name="Role_Description" 
class="validate[required,maxSize[20]] text-input" type="text"
						value=<%=bean.getRole_Description()%>  />${Role_Description1}
						${Role_DescriptionLength}</td>
				</tr>

<tr>    <td colspan="2" align="center"><input type="submit" name="submit" > </td>
			</table>
	</form>
	</div>
<%@include file="footer.jsp"%>
	
</body>
</html>