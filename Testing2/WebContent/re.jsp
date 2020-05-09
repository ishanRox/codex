<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
title>Reset Password</title>
<link href="layout/styles/re.css" rel="stylesheet" type="text/css"/>
<link href="https://fonts.googleapis.com/css?family=play" rel="stylesheet">
	<style>
		#msg
		{
			visibility: hidden;
			min-width: 250px;
			background-color:yellow;
			color: #000;
			text-align: center;
			border-radius: 2px;
			padding: 10px;
			position: fixed;
			z-index: 1;
			right: 30%;
			font-size: 17px;
			margin-right:30px;
		}
		
		#msg.show{
			visibility: visible;
			webkit-animation:fadein 0.5s, fadeout 0.5s 2.5s;
		}
		
		@webkit-keyframes fadein{
			from{top: 0;opacity: 0;}
			to{top:30px; opacity:1;}
		}
		
		@keyframes fadein{
			from{top: 0;opacity: 0;}
			to{top:30px; opacity:1;}
		}
		
		@webkit-keyframes fadein{
			from{top: 30;opacity: 1;}
			to{top:0; opacity:0;}
		}
		
		@keyframes fadein{
			from{top: 30;opacity: 1;}
			to{top:0; opacity:0;}
		}
		
	</style>
</head>
<body>
	<div class="reset">
	<form>
	<h2 aling="center" style="color: #3AAFA9;">Sign Up</h2>
	<input type="password" name="username" placeholder="old password">
	<br><br>
	<input type="password" name="username" placeholder="New name">
	<br><br>
	<input type="password" name="username" placeholder="Confirm new password">
	<br><br>
	<input type="button" value="Save" onklick="myFunction()"/><br><br>
	<a href="home.jsp" style="margin-right:0px font-size:130px; font-family:Tahoma, Geneva, sans-serif;">Go back to Home page</a>
		<div id="msg">Your password changed Successfully!</div>
		<script>
		function myFunction(){
			var x = document.getElementById("msg");
			x.className = "show";
			setTimeout(function(){ x.className.replace("show",""); }, 3000);
		}
		</script>
		</form>
	</div>
</body>
</html>