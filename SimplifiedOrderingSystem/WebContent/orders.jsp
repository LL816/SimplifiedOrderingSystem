<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.io.IOException, javax.servlet.ServletException, javax.servlet.annotation.WebServlet, javax.servlet.http.HttpServlet, javax.servlet.http.HttpServletRequest,
    		javax.servlet.http.HttpServletResponse, cheryl.ordering.comprise.OrdersList, cheryl.ordering.comprise.MyPair, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%		
	String user_name = request.getSession().getAttribute("user_name").toString();
	MyPair result = OrdersList.listOrders(user_name);
	ArrayList merchandise_name = result.getElement1();
	ArrayList total_price = result.getElement2();
	response.getWriter().println("current user's orders are listed as below");
	response.getWriter().println("merchandise name		total price");
	int size = merchandise_name.size();
	for (int i=0; i<size;i++){
		response.getWriter().println(merchandise_name.get(i) + "	" + total_price.get(i));
	}
 %>
</body>
</html>