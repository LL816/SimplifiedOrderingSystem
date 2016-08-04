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

<form action="succeed.jsp">
<input type="submit" value="Back"/>
</form>

<%		
	String user_name = request.getSession().getAttribute("user_name").toString();
	MyPair result = OrdersList.listOrders(user_name);
	ArrayList merchandise_name = result.getElement(0);
	ArrayList total_price = result.getElement(1);
	ArrayList order_id = result.getElement(2);
%>
<div style="color: #FF0000;">${message}</div>

Current user's orders are listed as below

<table>
<tr>
<td>Merchandise Name</td>
<td>Total Price</td>
<td>Number</td>
</tr>
<%
for (int i=0; i<merchandise_name.size();i++)
{
%>
<tr>
<td><%=merchandise_name.get(i) %></td>
<td><%=total_price.get(i) %></td>
<form action="deleteOrders" method="post">
<input type="hidden" name="order_id" value=<%=order_id.get(i) %> />
<td><input type="submit" value="Delete"/></td>
</form>
</tr>
<%} %>
</table>

</body>
</html>