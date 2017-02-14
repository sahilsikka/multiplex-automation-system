<%@page import="com.tcs.ilp.Bean.CustomerBean"%>
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


<li style="height: 55px;"><a href="<%=request.getContextPath()%>/CustomerContrller?source=view1&email=<%=user1 %>"><b>View Profile</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/TicketController?source=bookedhistory"><b>Booking History</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/LoginController?source=logout"><b>Log Out</a></li>
</ul>
</div>
        
    </div>
    
       <div id="coming" style="background-color: #F2F2F2;">
<%
CustomerBean cBean=(CustomerBean)request.getAttribute("customer");
%>
 <% 
    String user = null;
if(session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
}
else
{
	user = (String) session.getAttribute("user");
}
%>
 <div class="form-group">
      <center><h2>View Details </h2></center>
      <div class="form-group"><label >
First Name: </label><input type="text" class="form-control" name="firstname" value=<%=cBean.getFirstName() %> readonly></div>
<div class="form-group"><label >
Last Name:</label>
 <input type="text" class="form-control" name="lastname" value=<%=cBean.getLastName() %> readonly></div>
 
<div class="form-group"><label > 
Date of birth:</label> <input type="text" class="form-control" name="dob" value=<%=cBean.getDob() %> readonly></div>

<div class="form-group"><label >
Gender:
</label> <input type="text" class="form-control" name="gender" value=<%=cBean.getGender() %> readonly></div>

<div class="form-group"><label>
Phone:</label> <input type="text" class="form-control" name="phone" value=<%=cBean.getPhone() %> readonly></div>

<div class="form-group"><label> 
City: </label>
<input type="text"  class="form-control" name="city" value=<%=cBean.getCity() %> readonly></div>

<div class="form-group"><label>
Location:</label> <input type="text" class="form-control" name="loc" value=<%=cBean.getLocation() %> readonly></div>

<div class="submit-container">
<center><a href="<%=request.getContextPath()%>/CustomerContrller?source=Deactivate&emailid=<%=user%>&fname=<%=cBean.getFirstName()%>"onclick="return confirm('Are you sure?')" >Deactivate</a>

<a href="<%=request.getContextPath()%>/CustomerContrller?source=update&&emailid=<%=user%>&&firstname=<%=cBean.getFirstName() %>&&lastname=<%=cBean.getLastName() %>&&dob=<%=cBean.getDob() %>&&gender=<%=cBean.getGender() %>&&phone=<%=cBean.getPhone() %> &&city=<%=cBean.getCity() %>&&loc=<%=cBean.getLocation() %> ">update</a>
</center></div>
  
</div>
</div>
</div>
<%@ include file="footer.jsp" %>

</body>

</html>