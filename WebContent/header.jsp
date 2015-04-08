<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="arthinfosoft.bts.bean.Client_DetailsBean"%>
<%@page import="arthinfosoft.bts.bean.EmployeeDetailBean"%>
<html lang="en">
<head>
<meta property="og:type" content="website">
<meta property="og:image"
	content="https://bugzilla.mozilla.org/extensions/OpenGraph/web/bugzilla.png">
<meta property="og:title" content="Bugzilla Main Page">
<meta property="og:url" content="https://bugzilla.mozilla.org/">
<title>BUG TRACKING SYSTEM</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link rel="Top" href="">



<link rel="Saved&nbsp;Searches" title="My Bugs" href="">

<link rel="Saved&nbsp;Search"
	title="Bugs Filed Today (nobody@mozilla.org)"
	href="https://bugzilla.mozilla.org/buglist.cgi?cmdtype=dorem&amp;remaction=run&amp;namedcmd=Bugs%20Filed%20Today&amp;sharer_id=1">




<link href="Bugzilla%20Main%20Page_files/global_003.css" title="Classic">
<link href="Bugzilla%20Main%20Page_files/global_003.css"
	rel="stylesheet" type="text/css">
<link href="Bugzilla%20Main%20Page_files/index_003.css" rel="stylesheet"
	type="text/css">
<link href="Bugzilla%20Main%20Page_files/menu.css" rel="stylesheet"
	type="text/css">
<!--[if lte IE 7]>
      


  <link href="skins/standard/IE-fixes.css?1361962556" rel="stylesheet"
        type="text/css" >
<![endif]-->

<link href="Bugzilla%20Main%20Page_files/global_002.css"
	rel="stylesheet" type="text/css" title="Mozilla">
<link href="Bugzilla%20Main%20Page_files/index_002.css" rel="stylesheet"
	type="text/css" title="Mozilla">



<link href="Bugzilla%20Main%20Page_files/global.css" rel="stylesheet"
	type="text/css">
<link href="Bugzilla%20Main%20Page_files/index.css" rel="stylesheet"
	type="text/css">
<!--[if lte IE 7]>
      


  <link href="skins/custom/IE-fixes.css?1361962556" rel="stylesheet" type="text/css" >
<![endif]-->


</head>
<%
	String type = (String) session.getAttribute("type");
//	System.out.println(type);
	EmployeeDetailBean beana = null;
	EmployeeDetailBean beane = null;
	Client_DetailsBean beanc = null;
	String home = null;
	if (type != null
			&& ((EmployeeDetailBean) session.getAttribute("beana") != null)
			|| (EmployeeDetailBean) session.getAttribute("beane") != null
			|| (Client_DetailsBean) session.getAttribute("beanc") != null) {
		if (type.equals("Administrator")) {
			beana = (EmployeeDetailBean) session.getAttribute("beana");
			System.out.println(beana.getEmployee_firstname() + " "
					+ beana.getEmployee_lastname());
			home = "AdminMainPage.jsp";
			if (beana == null) {
				beana = new EmployeeDetailBean();
				System.out.println("Null");
			}
		} else if (type.equals("Employee")) {
			beane = (EmployeeDetailBean) session.getAttribute("beane");
			System.out.println(beane.getEmployee_firstname() + " "
					+ beane.getEmployee_lastname());
			home = "EmployeeMainPage.jsp";
			if (beane == null) {
				beane = new EmployeeDetailBean();
				System.out.println("Null");
			}

		} else if (type.equals("Client")) {
			beanc = (Client_DetailsBean) session.getAttribute("beanc");
			home = "ClientMainPage.jsp";
			if (beanc == null) {
				beanc = new Client_DetailsBean();
			}
		} else {
			response.sendRedirect("Login.jsp");
			System.out.println("re login");
		}
%>


<body onload=""
	class="bugzilla-mozilla-org
               skin-Mozilla yui-skin-sam">
	<div style="z-index: 1; position: absolute; visibility: hidden;"
		class="yui-module yui-overlay yuimenu yui-overlay-hidden"
		id="usermenu_widget">
		<div class="bd">
			<ul class="first-of-type">
				<li index="0" groupindex="0" id="yui-gen0"
					class="yuimenuitem first-of-type"><a target="_blank"
					class="yuimenuitemlabel" href="#">Profile</a></li>
				<li index="1" groupindex="0" id="yui-gen1" class="yuimenuitem"><a
					target="_blank" class="yuimenuitemlabel" href="#">Activity</a></li>
				<li index="2" groupindex="0" id="yui-gen2" class="yuimenuitem"><a
					target="_blank" class="yuimenuitemlabel" href="#">Mail</a></li>
				<li index="3" groupindex="0" id="yui-gen3" class="yuimenuitem"><a
					target="_blank" class="yuimenuitemlabel" href="#">Edit</a></li>
			</ul>
		</div>
	</div>

	<div id="header">

		<div class="wrapper">
			<table id="titles" cellpadding="0" cellspacing="0" border="0">
				<tbody>
					<tr>
						<td id="title"><a href="" title="Home"
							class="animated bounceIn">BUG TRACKING SYSTEM</a></td>
						<td></td>
						<td id="moz_login">
							<ul class="links">
								<li class="dropdown"><span class="anchor">Hello, <%
									if (type.equals("Administrator")) {
								%> <%=beana.getEmployee_firstname() + " "
							+ beana.getEmployee_lastname()%>

										<%
											} else if (type.equals("Employee")) {
										%> <%=beane.getEmployee_firstname() + " "
							+ beane.getEmployee_lastname()%>

										<%
											} else if (type.equals("Client")) {
										%> <%=beanc.getClient_name()%> <%
 	}
 %></span>
									<ul>
										
										<li><a href="LogOut">Log&nbsp;out</a></li>
									</ul></li>
							</ul>
						</td>
						<td id="moz_tab"><a href="" title=""> <img
								src="Bugzilla%20Main%20Page_files/tabzilla.png" border="0"
								height="42" width="154"></a></td>
					</tr>
				</tbody>
			</table>


			<div id="bugzilla_version">version 1.0.0.0</div>
			<iframe
				style="position: absolute; visibility: visible; background-color: yellow; border-width: 0px; width: 2em; height: 2em; left: 0px; top: -27px;"
				role="presentation" tabindex="-1" title="Text Resize Monitor"
				id="_yuiResizeMonitor"></iframe>
			<ul class="links">
				<li><a href="<%=home%>">Home</a></li>
				<li><span class="separator">| </span><a
					href="Bug_DetailsInsert.jsp">New</a></li>
				<li><span class="separator">| </span><a
					href="Bug_DetailsListServlet">Browse</a></li>
				<li><span class="separator">| </span></li>

				<li class="form quicksearch_form"><span class="separator">|
				</span>
					<form action="" method="get"
						onsubmit="if (this.quicksearch.value == '')
                  { alert('Please enter one or more search terms first.');
                    return false; } return true;">
			  </form>
					<a href="ProjectListServlet">Product
					Dashboard</a></li>

			</ul>

		</div>


	</div>

</body>
</html>

<%
	} else {
		response.sendRedirect("Login.jsp");
	}
%>