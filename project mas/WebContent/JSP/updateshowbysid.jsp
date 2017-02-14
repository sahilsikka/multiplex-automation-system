<%@page import="com.tcs.ilp.Bean.ShowBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/movieController?source=viewmoviebyfield"><b>View Movie By Field</a></li></ul>
</div>
        
    </div>
       <div id="coming" style="background-color: #F2F2F2;">
       
       <form action="<%=request.getContextPath() %>/ShowController">
<input type="hidden" name="source" value="updateshow"><br>
<b><%
ShowBean sBean=(ShowBean)request.getAttribute("show");

%></b>
<br>
 <input type="hidden" name="showid" value=<%= sBean.getShowId()%>><br>
 <a href="<%=request.getContextPath()%>/movieController?source=admin">Admin Dashboard</a>
  <center><h2>Update Show</h2></center>
  
 <%out.println("Selected Show is:   " +sBean.getShowId()); %>
 <div class="form-group">
      <center><h2>Show Details </h2></center>
<div class="form-group"><label>Show Date: </label><input type="date" name="showdate" value=<%=sBean.getShowDate() %>class="form-control"></div>

<div class="form-group"><label>Show Slot:</label> <%=sBean.getStartTime() %></div>

<div class="form-group"><label>Change Show Slot:</label> <select name="showslot" class="form-control" >
	<option>select</option>
	<option> 9am-12pm</option>
	<option> 12:30pm-3:30pm</option>
	<option> 4pm-7pm</option>
	<option> 9pm-12am</option>
</select></div>
 <input type="hidden" name="mid" value=<%= sBean.getMovieId()%>><br>
 <% %>
 
<div class="form-group"><label>Movie Id:</label><input type="text" name="movieid" value="<%=sBean.getMovieId()%>" class="form-control" readonly></div>
<div class="form-group"><label>Screen Id:</label><%=sBean.getScreenId() %></div>

<div class="form-group"><label> Change Screen:</label><select name="screenid" class="form-control">
	<option>select</option>
	<option> 123401</option>
	<option> 123402</option>
	<option>123403</option>
	<option> 123404</option>
</select></div>
 
 <div class="submit-container"><center>
<input type="submit" value="Update" class="btn btn-primary" onclick="return confirm('Are you sure you want to update?')" ></center>
</div>
<%-- <a href="<%=request.getContextPath()%>/ShowController?source=updateshow&showid=<%= sBean.getShowId()%>">update</a><br>
 --%></form>
       
       
         </div>
    <div class="cl">&nbsp;</div>
  </div>
</div>

<%@ include file="footer.jsp" %>

</body>
</html>