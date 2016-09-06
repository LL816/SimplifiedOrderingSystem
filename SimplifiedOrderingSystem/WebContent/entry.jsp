<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<style>
	body{
		margin:0px;
		padding:0px;
		font-size:14px;
		background-color:#9999FF;
		overflow:hidden:
		text-align:center;
	}
	#container{
		width:980px;
		height:800px;
		border:0px solid black;
	}
	#welcomeMessage{
		margin-top:10px;
		font-size:16px;
		color:#00CC33;
		text-shadow: 1px 1px #99CC99;
		text-transform:uppercase;
		font-style:oblique;
	}
	#login{
		position:relative;
		margin-top:100px;
		margin-left:90px;
		background-image:url('background7.jpg');
		width:800px;
		height:333px;
	}
	#input{
		position:absolute;
		top:20px;
		left:250px;
		margin-top:20px;
		margin-bottom:10px;
		text-align:center;

	}
	#input input{
		width:150px;
		height:20px;
		background-color:#C1C1C1;
	}
	#errorMessage{
		color:red;
		margin-top:20px;
		margin-bottom:10px;
		position:absolute;
		top:80px;
		left:250px;
		
	}
	#button{
		position:absolute;
		top:100px;
		left:350px;
		margin-top:20px;
		margin-bottom:10px;
	}
	#button input{
		width:80px;
		height:30px;

	}
	#veriCode{
		position:absolute;
		top:120px;
		left:350px;
		margin-top:20px;
		margin-bottom:10px;
		display:inline;
	}
	#veriInput{
		float:left;
		margin-top:20px;
		margin-bottom:10px;

	}
	#veriInput input{
		width:80px;
		height:20px;
		background-color:#C1C1C1;
	}
	#veriOutput{
		float:left;
		margin-top:20px;
		margin-bottom:10px;

	}

</style>
</head>
<script>
function changeImage(img){
	img.src = img.src+"?"+ new Date().getTime();
}
</script>
<body>
<div id="container">
	<div id="welcomeMessage">
		Welcome to visit our simplified ordering system! Please login first!
	</div>
	<div id="login">
		<form action="/SimplifiedOrderingSystem/main" method="post">
		<div id="input">
			user name: 
			<input type="text" name="username" required="required"/><br>
			password: 
			<input type="password" name="password" required="required"/><br>
		</div>
			<div id="errorMessage">${errorMessage}</div>
			<div id="button">
				<input type="submit" value="Login"/>
			</div>
			<div id="veriCode">
				<div id="veriInput">
					<input type="text" name="verification">
				</div>
				<div id="veriOutput">
					<img src="/SimplifiedOrderingSystem/randomImage" onclick="changeImage(this)"><br>
				</div>
			</div>
		</form>
	</div>
</div>
</body>
</html>