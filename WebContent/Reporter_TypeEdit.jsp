<%@page import="arthinfosoft.bts.bean.Reporter_TypeBean"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
		
<%@include file="header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Reportor Type Insert Page</title>
<link rel="stylesheet" href="jquery-ui-1.10.4.custom/css/start/jquery-ui-1.10.4.custom.css" />
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

 <div id="new">
<hr><center><h1>Reporter Type Edit Form</h1></center><hr>

<form action="Reporter_TypeUpdateServlet" method="post" id="form">

<%Reporter_TypeBean bean=(Reporter_TypeBean)request.getAttribute("bean"); %>

<input type="hidden" name="reporter_type_id" value="<%=bean.getReporter_type_id()%>">
<table align="center"  >
<tr>
<td>Reporter_Type_Name</td><td><input name="reporter_type_name" type="text" 
class="validate[required,maxSize[20]] text-input" value="<%=bean.getReporter_type_name()%>">${reporter_type_name}   ${reporter_type_nameLength}</td>
</tr>


<tr>    <td colspan="2" align="center"><input type="submit" name="submit" > </td>
</table>
</form>

</div>
<%@include file="footer.jsp"%>

</body>
</html>