<%@page import="com.tcs.ilp.Bean.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/table.css" type="text/css" media="all" />
<title>Insert title here</title>
</head>
<body>
<%@ include file="loginheader.jsp" %>
<div id="main">
    <div id="content">
    <div id="news" style="
    margin-left: 185px;">
    
     <div class="sidebarmenu">
<ul id="sidebarmenu1">


<li style="height: 55px;"><a href="<%=request.getContextPath()%>/movieController?source=addmovie"><b>Add Movie</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/ShowController?source=addshowpage"><b>Add Show</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/movieController?source=updatemovie"><b>Update Movie</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/movieController?source=viewallmovie"><b>View All Movie</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/ShowController?source=viewallshow"><b>View All show</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/CustomerContrller?source=viewallcustomer"><b>View All Customer</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/TicketController?source=viewbooking"><b>View Bookings</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/movieController?source=viewmoviebyfield"><b>View Movie By Field</a></li></ul>
</div>
        
    </div>
    
       <div id="coming" style="background-color: #F2F2F2;">
       
       <form action="<%=request.getContextPath()%>/CustomerContrller">
<input type="hidden" name="source" value="deletecustomer"><br>
<%CustomerBean cBean=(CustomerBean)request.getAttribute("delete");%>
 <div class="form-group">
<center><h2>Modify User Status </h2></center>

<div class="form-group"><label>Customer ID:</label><%=cBean.getEmailId()%>

 <input type="hidden" class="form-control" name="emailid" value=<%= cBean.getEmailId()%>></div>
 
<div class="form-group"><label>Present Status: </label><input type="text" class="form-control" readonly value="<%=cBean.getDeactivation()%>"></div>

<div class="form-group"><label>
Change Status:</label>
 <select name="status" class="form-control" required>
	<option>select</option>
	<option> active</option>
	<option> deactivate</option>
	
</select></div>

<div class="form-group"><label>
Write Reason For Deactivation:</label>
<textarea rows="4" cols="50" name="write" class="form-control" required> 
</textarea></div>

<div class="form-group"><center>
<input type="submit" value="change status" onclick="return confirm('Are you sure you want to update?')" class="btn btn-primary" >
</center></div>

 
</form>
  </div>
  
  </div>


<%@ include file="footer.jsp" %>
</body>
</html>