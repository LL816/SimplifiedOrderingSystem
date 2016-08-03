<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.io.IOException, javax.servlet.ServletException, javax.servlet.annotation.WebServlet, javax.servlet.http.HttpServlet, javax.servlet.http.HttpServletRequest,
    		javax.servlet.http.HttpServletResponse, cheryl.ordering.comprise.validation"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String user_name = request.getParameter("username");
	String passwd = request.getParameter("password");
	boolean result = validation.verify(user_name, passwd);

	request.getSession().setAttribute("user_name", user_name);

	if (result){
		RequestDispatcher dispatcher = request.getRequestDispatcher("/succeed.jsp");
		dispatcher.forward(request, response);
	}
	else{
		request.setAttribute("errorMessage", "invalid username or password! Please try again!");
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/entry.jsp");
		dispatcher.forward(request, response);
	} 
%>
</body>
</html>