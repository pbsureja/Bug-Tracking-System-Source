<%@page import="arthinfosoft.bts.bean.ProjectTechnologyBean"%>
		
<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<hr><center><h1>Project Technology Edit Form</h1></center><hr>
	
	<%
		ProjectTechnologyBean bean = (ProjectTechnologyBean) request
				.getAttribute("bean");
		if (bean != null) {
	%>

	<form action="ProjectTechnologyUpdateServlet"
		id="form" name="ProjectTechnologyEditPage"
		action="post">
		<input type="hidden" name="id" value="<%=bean.getTechnology_id()%>">
		<table align="center">
			<tr>
				<td>Project Technology description:
				<td><input type="text" name="projecttechnologydescription"
					id="projecttechnologydescription" class="validate[required,maxSize[25]] text-input"
					value="<%=bean.getTechnology_description()%>"> ${Technology_description}${Technology_description_length}
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