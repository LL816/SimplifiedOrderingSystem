<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Congrats!</title>
</head>
<body>

<%String refererName = request.getHeader("referer");
  if(refererName==null || !refererName.startsWith("http://localhost")){
	response.sendRedirect("/SimplifiedOrderingSystem/entry.jsp");
	return;
  }	
%>

<%String username = session.getAttribute("user_name").toString(); %>
<%=username %> have been successfully logged in to our system!

<br>

<form action="merchandise.jsp" method="post">
<input type="submit" value="merchandise list"/>
</form>

<br>

<form action="orders.jsp" method="post">
<input type="submit" value="my orders"/>
</form>

<br>

<form action="entry.jsp">
<input type="submit" value="Logout"/>
</form>

</body>
</html>