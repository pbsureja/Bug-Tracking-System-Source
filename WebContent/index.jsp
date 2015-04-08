<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<!--
 ____________________________________________________________________
|                                                                    |
|      NAME : Nice Login and Signup Panel using Mootools 1.2         |
|    AUTHOR : Jeeremie { http://web-kreation.com }                   |
|      DATE : August 3, 2008                                         |
|   LICENSE : Creative Common License 2.5                            |
|     EMAIL : info@web-kreation.com                                  |
|____________________________________________________________________|
-->

<head>
  	<title>::Bug Tracking System::</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />

	<!-- The main style sheet -->
  	<link rel="stylesheet" href="style.css" type="text/css" media="screen" />

	<!-- START Fx.Slide -->
	<!-- The CSS -->
  	<link rel="stylesheet" href="fx.slide.css" type="text/css" media="screen" />
    <!-- Mootools - the core -->
	<script type="text/javascript" src="js/mootools-1.2-core-yc.js"></script>
    <!--Toggle effect (show/hide login form) -->
	<script type="text/javascript" src="js/mootools-1.2-more.js"></script>
	<script type="text/javascript" src="js/fx.slide.js"></script>
	<!-- END Fx.Slide -->

</head>

<body>
	<!-- Login -->
	<div id="login">
		<div class="loginContent">
			<form action="LoginServlet" method="post">
				<label for="log"><b>Username: </b></label>
				<input class="field" type="text" name="userName" id="log" value="" size="23" />
				<%=(request.getAttribute("userName")!=null)?request.getAttribute("userName"):""%>
				<label for="pwd"><b>Password:</b></label>
				<input class="field" type="password" name="password" id="pwd" size="23" />
				<%=(request.getAttribute("pwd")!=null)?request.getAttribute("pwd"):""%>
				<input type="submit" name="submit" value="" class="button_login" />
				<input type="hidden" name="redirect_to" value=""/>
			</form>
			<div class="left">
            	<label for="rememberme"><input name="rememberme" id="rememberme" class="rememberme" type="checkbox" checked="checked" value="forever" /> Remember me</label></div>
			<div class="right">Not a member? <a href="#">Register</a> | <a href="forgetpassword.jsp">Lost your password?</a></div>
		</div>
		<div class="loginClose"><a href="#" id="closeLogin">Close Panel</a></div>
	</div> <!-- /login -->

    <div id="container">
		<div id="top">
		<!-- login -->
			<ul class="login">
		    	<li class="left">&nbsp;</li>
		        <li>Hello Guest!</li>
				<li>|</li>
				<li><a id="toggleLogin" href="#">Log In</a></li>
			</ul> <!-- / login -->
		</div> <!-- / top -->

        <div class="clearfix"></div>


		<div id="content">
			<a href="" title="BugTrackingSystem"><img src="bug1.png" alt="BugTrackingSystem" /></a>
			<!-- If javascript is disabled, display message below: -->
			<noscript><p style="color: red;">You must enable Javascript in you browser in order to try this demo.</p></noscript>
        	<p style="margin-top: 60px;">Click <em>"Login"</em> on the upper-right corner of this page to show/hide the login panel. <br />
			<small>(<b>NOTE:</b> The login/signup form is not active! This is just an example to explain you how to use Mootools Fx.Slide to show/hide a login form on your Web page).</small>
			</p>
			<p>Go back to <a href="http://web-kreation.com/index.php/ajax-javascript/nice-login-and-signup-panel-using-mootools-12" title="Back to Tutorial">tutorial &raquo;</a></p>
		</div><!-- / content -->
        <div class="clearfix"></div>
	</div><!-- / container -->

</body>

</html>
