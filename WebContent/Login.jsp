
<html>
<head>
<link href="Bugzilla%20Main%20Page_files/login.css" rel="stylesheet" type="text/css" title="Mozilla"><link href="Bugzilla%20Main%20Page_files/index_002.css" rel="stylesheet" type="text/css" title="Mozilla">
<link href="Bugzilla%20Main%20Page_files/global_002.css" rel="stylesheet" type="text/css" title="Mozilla"><link href="Bugzilla%20Main%20Page_files/index_002.css" rel="stylesheet" type="text/css" title="Mozilla">

</head>
<body>

<div id="wrapper">

<form action="Login" class="login-form" method="post">
	
		<div class="header">
		<h1>Login Form</h1>
		</div>
			
		<div class="content">
		<br><input type="text" name=id class="input username" placeholder="Username"> ${error}
	
		<div class="user-icon"></div>
		
		<input type=Password name=password class="input password" placeholder="Password" > ${error}
		<div class="pass-icon"></div>	
		
		<br>
		
		<table >
	<tr><td>Administrator    <td><input type=radio name="type" value="Administrator">
	<tr><td>Client     <td><input type=radio name="type" value="Client" checked="checked">
	<tr><td>Employee <td><input type=radio name="type" value="Employee">
		</table>
		</div>
		
		<div class="footer">
		<input type="submit" name="submit" value="Login" class="button" />
		</div>
			

</form>

		<div class="gradient"></div>
		
</div>
</body>
</html>