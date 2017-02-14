<%@page import="com.tcs.ilp.Bean.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css" type="text/css" >
<title>Insert title here</title>
</head>
<body>
<%@ include file="loginheader.jsp" %>
 <div id="main">
    <div id="content">
    <div id="news" style="
    margin-left: 185px;">
      <!-- <div class="content">
        <h4> Add Movie </h4>
         </div>
      <div class="content">
        <h4>Add Show</h4>
         </div>
      <div class="content">
        <h4>View All Movies</h4>
        </div>
        
        <div class="content">
        <h4>View All Customers</h4>
        </div>
        
        <div class="content">
        <h4>Update Movie</h4>
        </div>
        
        <div class="content">
        <h4>View All Show</h4>
        </div>
        
         <div class="content">
        <h4>View Movie By Fields</h4>
        </div>
        
         <div class="content">
        <h4>View Bookings</h4>
        </div> -->
        
        <div class="sidebarmenu">
<ul id="sidebarmenu1">

<li style="height: 55px;"><a href="<%=request.getContextPath()%>/movieController?source=addmovie"><b>Add Movie</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/ShowController?source=addshowpage"><b>Add Show</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/movieController?source=updatemovie"><b>Update Movie</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/movieController?source=viewallmovie"><b>View All Movie</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/ShowController?source=viewallshow"><b>View All show</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/CustomerContrller?source=viewallcustomer"><b>View All Customer</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/TicketController?source=viewbooking"><b>View Bookings</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/movieController?source=viewmoviebyfield"><b>View Movie By Field</a></li>
</ul>
</div>
        
    </div>
    
       <div id="coming" style="background-color: #F2F2F2;">
       <div class="form-group">
						<center><h2>
							User Profile</h2></center>
<%
CustomerBean cBean=(CustomerBean)request.getAttribute("customer");
%>							
<div class="form-group"><label> Email Id:</label> <input class="form-control" type="text" name="eid" value="<%= cBean.getEmailId()%>"readonly></div>
<div class="form-group"><label> First Name:</label> <input  class="form-control"type="text" name="fname" value="<%=cBean.getFirstName() %>"readonly></div>
<div class="form-group"><label> Last Name: </label><input type="text" name="lname" class="form-control"value="<%=cBean.getLastName() %>"readonly></div>
<div class="form-group"><label> DOB:</label> <input type="text" name="dob"class="form-control" value="<%=cBean.getDob() %>"readonly></div>
<div class="form-group"><label> Gender:</label> <input type="text" name="gender" class="form-control"value="<%=cBean.getGender() %>"readonly></div>
<div class="form-group"><label> City: </label><input type="text" name="city" class="form-control"value="<%=cBean.getCity() %>"readonly></div>
<div class="form-group"><label> Location: </label><input type="text" name="loc"class="form-control" value="<%=cBean.getLocation() %>"readonly></div>
<div class="form-group"><label> Contact No.:</label> <input type="text"class="form-control" name="phn" value="<%=cBean.getPhone() %>"readonly></div>
<div class="form-group"><label> Status:</label> <input type="text" name="status"class="form-control" value="<%=cBean.getDeactivation() %>"readonly></div>
<br>

  </div>
    <div class="cl">&nbsp;</div>
  </div>
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>