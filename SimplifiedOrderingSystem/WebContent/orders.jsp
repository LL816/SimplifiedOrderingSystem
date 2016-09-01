<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.io.IOException, javax.servlet.ServletException, javax.servlet.annotation.WebServlet, javax.servlet.http.HttpServlet, javax.servlet.http.HttpServletRequest,
    		javax.servlet.http.HttpServletResponse, cheryl.ordering.comprise.OrdersList, cheryl.ordering.comprise.MyPair, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order list</title>
<script type="text/javascript">
//	var iscommitted=false;
	function dosubmit(buttonId){
		/*
		if(!iscommitted){
			iscommitted=true;		
			return true;
		}
		else{
			return false;
		}*/
		var input = document.getElementById(buttonId);
		
		input.disabled = 'disabled';
		return true;
	}
</script>
</head>
<body>
<%String refererName = request.getHeader("referer");
  if(refererName==null || !refererName.startsWith("http://localhost")){
	response.sendRedirect("/SimplifiedOrderingSystem/entry.jsp");
	return;
  }	
%>
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
</tr>
<%
for (int i=0; i<merchandise_name.size();i++)
{
	String buttonId=i+"";
%>
<tr>
<td><%=merchandise_name.get(i) %></td>
<td><%=total_price.get(i) %></td>
<form action="deleteOrders" method="post" onsubmit="return dosubmit('<%=buttonId %>')">
<input type="hidden" name="order_id" value=<%=order_id.get(i) %> />
<td><input id=<%=buttonId %> type="submit" value="Delete"/></td>
</form>
</tr>
<%} %>
</table>

</body>
</html>