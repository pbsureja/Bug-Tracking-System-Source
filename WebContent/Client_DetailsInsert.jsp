<%@page import="arthinfosoft.bts.bean.Client_DetailsBean"%>
<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@include file="header.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
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
	<%
		int count = 1;
		Client_DetailsBean bean = (Client_DetailsBean) request
				.getAttribute("bean");
		if (bean == null) {
			bean = new Client_DetailsBean();
			count = 0;
		}
	%>
	
	<div id="new">
		
		<hr><center><h1>Client Detail Insert Form</h1></center>
		<hr>

		<form action="Client_DetailsInsertServlet" method="post" id="form">

			<input type="hidden" name="client_details_id"
				value="${bean.client_id}">
				<table align="center">
					<tr>
						<td>Name</td>
						<td><input name="client_details_name" class="validate[required] text-input"
							value="${bean.client_name}" type="text" />${client_details_name}
							${client_details_namelength}</td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input name="client_details_email" type="text"
							class="validate[required,custom[email]] value="${bean.email}" />${client_details_email}
							${client_details_emaillength}</td>
					</tr>
					
					<tr>
						<td>Password</td>
						<td><input name="client_details_password" type="password"
							class="validate[required,minSize[6]] text-input" value="${bean.password}" />${client_details_password}
							${client_details_passwordlength}</td>
					</tr>
					<tr>
						<td>SecurityQuestion</td>
						<td><input name="client_details_securityquestion" type="text"
							class="validate[required] text-input"	value="${bean.securityquestion}" />${client_details_securityquestion}
							${client_details_securityquestionlength}</td>
					</tr>
					<tr>
						<td>Answer</td>
						<td><input name="client_details_answer" type="text"
							class="validate[required] text-input" value="${bean.answer}" />${client_details_answer}
							${client_details_answerlength}</td>
					</tr>
					<tr>
						<td>Phone_No</td>
						<td><input name="client_details_phone_no" type="text"
							class="validate[required,custom[onlyNumberSp]] text-input"
							 value="${bean.phone_no}" />${client_details_phone_no}
							${client_details_phone_nolength}</td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input name="client_details_address" type="text" 
class="validate[required] text-input"
							value="${bean.address}" />${client_details_address}
							${client_details_addresslength}</td>
					</tr>
					<tr>
						<td>Fax</td>
						<td><input name="client_details_fax" type="text"
							value="${bean.fax}" />${client_details_fax}
							${client_details_faxlength}</td>
					</tr>
					<tr>
						<td>Website</td>
						<td><input name="client_details_website" type="text"
							value="${bean.website}" class="validate[required,custom[url]] text-input"/>${client_details_website}
							${client_details_websitelength}</td>
					</tr>

					<tr>
						<td colspan="2" align="center"><input type="submit"	name="submit"> 
						<%
 	if (count == 0) {
 %><input type="reset" name="reset">
									<%
										}
									%>
							</td>
				</table>
		</form>
	</div>
	<%@include file="footer.jsp"%>

</body>
</html>