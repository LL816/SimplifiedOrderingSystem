<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="java.io.IOException, javax.servlet.ServletException, javax.servlet.annotation.WebServlet, javax.servlet.http.HttpServlet, javax.servlet.http.HttpServletRequest,
    		javax.servlet.http.HttpServletResponse, cheryl.ordering.comprise.MerchandiseList, cheryl.ordering.comprise.MyPair, java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	MyPair result = MerchandiseList.listMerchandise();
	ArrayList merchandise_name = result.getElement1();
	ArrayList price = result.getElement2();
	int len = merchandise_name.size();
		
	response.getWriter().println("Merchandise Name		Price		" + "\n");
		
	for(int i=0;i<len;i++){
		response.getWriter().println(merchandise_name.get(i) + "	" + price.get(i) + "\n");
	}
%>
</body>
</html>