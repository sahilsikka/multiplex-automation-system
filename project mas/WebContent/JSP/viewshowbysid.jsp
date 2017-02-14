<%@page import="com.tcs.ilp.Bean.ShowBean"%>
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
<%
ShowBean sBean=(ShowBean)request.getAttribute("show");

%>
<a href="<%=request.getContextPath()%>/movieController?source=admin">Admin Dashboard</a>
  <center><h2>View Show Details</h2></center>  
<table class="table table-striped">
<tr><td>Show id:</td><td> <input type="text" name="sid" value="<%= sBean.getShowId()%>" class="form-control" readonly ></td></tr>
<tr><td>Show date:</td><td>  <input type="text" name="sdate" value="<%=sBean.getShowDate()%>"class="form-control" readonly></td></tr>
<tr><td>Show slot:</td><td>  <input type="text" name="slot" value="<%=sBean.getStartTime()%>"class="form-control" readonly></td></tr>
<tr><td>Movie id:</td><td>  <input type="text" name="movieid" value="<%=sBean.getMovieId()%>"class="form-control" readonly></td></tr>
<tr><td>Screen id: </td><td> <input type="text" name="screen" value="<%=sBean.getScreenId()%>"class="form-control" readonly></td></tr>
<br>
</table>

  </div>
    <div class="cl">&nbsp;</div>
  </div>
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>