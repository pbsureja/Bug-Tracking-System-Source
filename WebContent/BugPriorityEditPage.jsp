<%@page
	import="arthinfosoft.bts.controller.Bug_Priority.BugPriorityInsertServlet,arthinfosoft.bts.bean.BugPriorityBean"%>
<%@page import="javax.swing.text.DefaultEditorKit.InsertBreakAction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@include file="header.jsp"%>
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
		<hr>
		<center>
			<h1>Bug Priority Edit Form</h1>
		</center>
		<hr>

		<%
			BugPriorityBean bean = (BugPriorityBean) request
					.getAttribute("bean");

			if (bean != null) {
		%>

		<form action="BugPriorityUpdateServlet" id="form"
			name="BugPriorityEditPage" action="post">
			<input type="hidden" name="id" value="<%=bean.getBug_priority_id()%>">
			<table align="center">
				<tr>
					<td>Bug Priority description:
					<td><input type="text" name="bugprioritydescription"
						id="bugprioritydescription" 
						class="validate[required] text-input"
						value="<%=bean.getBug_priority_description()%>">
						${bug_priority_description} ${bug_priority_description_length}
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="submit"></td>
			</table>
		</form>
	</div>
	<%@include file="footer.jsp"%>
	<%
		}
	%>

</body>
</html>