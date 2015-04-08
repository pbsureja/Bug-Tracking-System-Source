<%@page import="arthinfosoft.bts.bean.Reporter_TypeBean"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
		
<%@include file="header.jsp"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Reporter type Insert Page</title>
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
<hr><center><h1>Reporter Type Insert Form</h1></center><hr>
<form action="Reporter_TypeInsertServlet" method="post" id="form">

<table align="center"  >
<tr>
<td>Reporter Type Name</td><td><input name="reporter_type_name" class="validate[required,maxSize[20]] text-input"
  type="text">${reporter_type_name}   ${reporter_type_nameLength}</td>
</tr>

<td colspan="2" align="center"><input type="submit" name="submit" > <input type="reset" name="reset">		

</table>
</form>
</div>
<%@include file="footer.jsp"%>

</body>
</html>