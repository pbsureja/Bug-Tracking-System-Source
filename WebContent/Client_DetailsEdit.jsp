<%@page import="arthinfosoft.bts.bean.Client_DetailsBean"%>

<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="header.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert Page</title>
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

<form action="Client_DetailsUpdateServlet" method="post" id="form">
<%Client_DetailsBean bean=(Client_DetailsBean)request.getAttribute("bean");

%>
<div id="new">
<hr><center><h1>Client Details Edit Form</h1></center><hr>
<input type="hidden" name="client_details_id" value="<%=bean.getClient_id()%>">
<table align="center" >
<tr>
<td>Name</td><td><input 
class="validate[required] text-input" name="client_details_name" value="<%=bean.getClient_name()%>" type="text" />${client_details_name}   ${client_details_namelength}</td>
</tr>
<tr>
<td>Email</td><td><input class="validate[required,custom[email]] name="client_details_email" type="text" value="<%=bean.getEmail()%>" />${client_details_email}   ${client_details_emaillength}</td>
</tr>
<tr>
<td>Password</td><td><input 
class="validate[required,minSize[6]] text-input" name="client_details_password" type="password" value="<%=bean.getPassword()%>" />${client_details_password}   ${client_details_passwordlength}</td>
</tr>
<tr>
<td>SecurityQuestion</td><td><input 
class="validate[required] text-input" name="client_details_securityquestion" type="text" value="<%=bean.getSecurityquestion()%>" />${client_details_securityquestion}   ${client_details_securityquestionlength}</td>
</tr>
<tr>
<td>Answer</td><td><input 
class="validate[required] text-input" name="client_details_answer" type="text" value="<%=bean.getAnswer()%>" />${client_details_answer}   ${client_details_answerlength}</td>
</tr>
<tr>
<td>Phone_No</td><td><input class="validate[required,custom[onlyNumberSp]] text-input"
 name="client_details_phone_no" type="text" value="<%=bean.getPhone_no()%>" />${client_details_phone_no}   ${client_details_phone_nolength}</td>
</tr>
<tr>
<td>Address</td><td><input 
class="validate[required] text-input" name="client_details_address" type="text" value="<%=bean.getAddress() %>"/>${client_details_address}   ${client_details_addresslength}</td>
</tr>
<tr>
<td>Fax</td><td><input name="client_details_fax" type="text" value="<%=bean.getFax() %>"/>${client_details_fax}   ${client_details_faxlength}</td>
</tr>
<tr>
<td>Website</td><td><input class="validate[required,custom[url]] text-input" name="client_details_website" type="text" value="<%=bean.getWebsite()%>"/>${client_details_website}   ${client_details_websitelength}</td>
</tr>

<tr><td colspan="2" align="center"><input type="submit" name="submit" > </td>

</table>
</form>
</div>
<%@include file="footer.jsp"%>
</body>
</html>