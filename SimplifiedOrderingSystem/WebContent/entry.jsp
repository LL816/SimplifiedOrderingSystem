<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
Welcome to visit our simplified ordering system! Please login first!

<form action="main" method="post">
	user name: 
	<input type="text" name="username" required="required"/><br>
	password: 
	<input type="password" name="password" required="required"/><br>
	<div style="color: #FF0000;">${errorMessage}</div>
	<input type="submit" value="Login"/>
</form>

</body>
</html>