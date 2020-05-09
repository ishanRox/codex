<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-type" content="text/html; charset 8"/>
<title>Sing Up</title>
<link href="layout/styles/sgnup.css" rel="stylesheet" type="text/css"/>
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
	<div class="signup">
	<form>
	<h2>Sign Up</h2>
	<input type="text" name="username" placeholder="First name">
	<br><br>
	<input type="text" name="username" placeholder="Last name">
	<br><br>
	<input type="password" name="pass" placeholder="password">
	<br><br>
	<input type="password" name="pass" placeholder="Confirm password">
	<br><br>
	<input type="text" name="email" placeholder="Email address">
	<br><br>
	
	<input type="button" value="Sing up"    button="myFunction"><br><br>
		<div id="msg">Congratulations you Sing Up Successfully!</div>
		<script>
		function myFunction(){
			var x = document.getElementById("msg");
			x.className = "show";
			setTimeout(function(){ x.className.replace("show",""); }, 3000);
		}
		</script>
			Already have account?<a href="logn.jsp" style="text-decoration: none; font-family: `play`, sans-serif; color: #3AAFA9;">&nbsp;LogIn</a>
	</form>
</div>
</head>
<body>

</body>
</html>