<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta  http-equiv="Content-type" content="text/html; charset 8"  charset="ISO-8859-1">
<title>Login</title>
<link href="layout/styles/logn.css" rel="stylesheet" type="text/css" media="all">
<link href="layout/styles/cong.css" rel="stylesheet" type="text/css" media="all">
<link href="https://fonts.googleapis.com/css?family=play" rel="stylesheet">
</head>
<body>
	<div class="singin">
<form action="LoginRegister" methode="post">
	<h2 >Log In</h2>
	
	<input type="text" name="username" placeholder="username">
	<input type="password" name="pass" placeholder="password"><br><br>
	
	 
	<a href="cong.jsp"><input type="button" value="Log In"></a><br><br>
	<div id="container">
	<a href="re.jsp" style="margin-right:0px font-size:130px; font-family:Tahoma, Geneva, sans-serif;">Reset password</a>
	<a href="sgnup.jsp" style="margin-right:0px font-size:130px; font-family:Tahoma, Geneva, sans-serif;">Forgot password</a>
	<a href="sgnup.jsp"></a>
	</div><br><br><br><br><br><br>
	Don`t have account?<a href="sgnup.jsp">&nbsp; Sign Up</a>
	
</form>
</div>
</body>
</html>