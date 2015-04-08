<%@page import="arthinfosoft.bts.bean.ProjectPlatformBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		
<%@include file="header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Platform Edit Page</title>
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
<hr><center><h1>Project Platform Form</h1></center><hr>
			
	
	<%
		ProjectPlatformBean bean = (ProjectPlatformBean) request
				.getAttribute("bean");
		if (bean != null) {
	%>

	<form action="ProjectPlatformUpdateServlet"
		id="form" name="ProjectPlatformEditPage"
		action="post">
		<input type="hidden" name="id" value="<%=bean.getPlatform_id()%>">
		<table align="center"  >
			<tr>
				<td>Project Platform description:
				<td><input type="text" name="projectplatformdescription"
					id="projectplatformdescription" class="validate[required,maxSize[25]] text-input"
					value="<%=bean.getPlatform_description()%>"> ${Platform_description}${Platform_description_length}
	<tr>    <td colspan="2" align="center"><input type="submit" name="submit" > </td>
	</table>
	</form>
	</div>
<%@include file="footer.jsp"%>
	
	<%
		}
	%>
</body>
</html>