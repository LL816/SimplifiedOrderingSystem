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


<table>
<% 
	MyPair result = MerchandiseList.listMerchandise();
	ArrayList merchandise_name = result.getElement(0);
	ArrayList price = result.getElement(1);
	int len = merchandise_name.size();
%>
<tr>
<td>Merchandise Name</td>
<td>Price</td>
</tr>
<%		
	for(int i=0;i<len;i++){
%>
<tr>
<form action="newOrder" method="post">  <!--form scope matters-->
<td><%=merchandise_name.get(i) %></td>
<td><%=price.get(i) %>	</td>
<td><input type="number" name="number" value="1"/></td>
<input type="hidden" name="merchandise_name" value=<%=merchandise_name.get(i) %> />
<td><input type="submit" value="order"/></td>
</form>
</tr>				
<%	}%>
</table>

</body>
</html>