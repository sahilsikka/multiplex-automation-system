<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: center;    
}
</style>
</head>
<body>
<form>
	<table style="width:50%">
  <tr>
    <th colspan="2"><center>Your ticket has been booked</center></th>   
  </tr>
  <tr>
    <th rowspan="9"><img src="../images/ticket.jpg" alt="ticket" style="width:300px;height:200px"></th>
   <tr> <td>Booking ID:</td><td> <%=request.getParameter("source1") %></td></tr>
   <tr> <td>Email ID: </td><td><%=request.getParameter("source2") %></td></tr>
    <tr><td>Movie Name: </td><td><%=request.getParameter("source3") %></td></tr>
    <tr> <td>Language: </td><td><%=request.getParameter("source4") %></td></tr>
    <tr> <td>Show Date: </td><td><%=request.getParameter("source5") %></td></tr>
    <tr> <td>Show Time: </td><td><%=request.getParameter("source6") %></td></tr>
    <tr> <td>Seats: </td><td><%=request.getParameter("source7") %></td></tr>
    <tr> <td>Price </td><td><%=request.getParameter("source8") %></td>
  </tr>
  <tr><td colspan="2"><center><input type="submit" value="print" align="middle"></center></td></tr>
  
    
  </tr>
</table>
</form>
</body>
</html>