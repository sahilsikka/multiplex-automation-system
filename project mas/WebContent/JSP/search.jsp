<%@page import="java.util.ArrayList"%>
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
       
       
       <%ArrayList<String> mlist = (ArrayList<String>)request.getAttribute("mlist");%>
<form action="<%=request.getContextPath()%>/movieController" method="get">
  <a href="<%=request.getContextPath()%>/movieController?source=admin">Admin Dashboard</a>
<div class="form-group">
  <center><h2>Update Movie</h2></center>
  
<div class="form-group"><label>
MovieName:</label><select name="mname" class="form-control">
<option selected="selected">
<%for(int i=0;i<mlist.size();i++ ) 
{ %>
<option value="<%=mlist.get(i)%>"><%=mlist.get(i)%></option>
<% } %><br>
</select>
<!-- MovieName: <select name="mname">
<option selected="selected">select</option>
<option value="creature 3">creature 3</option>
<option value="singham">singham</option>
<option value="QWERTY">QWERTY</option>
</select> -->
</div>
<div class="form-group"><label>
Language:</label> <select name="language" class="form-control">
<option selected="selected">select</option>
<option value="hindi">Hindi</option>
<option value="English">English</option>
</select><br><br>
</div>

<div class="submit-container"><center><input type="submit" name="source" value="search" class="btn btn-primary">
<input type="reset" value="reset"class="btn btn-primary"></center></div>



   </div>
    <div class="cl">&nbsp;</div>
     </form>
  </div>
 
</div>

       
</div>

<%@ include file="footer.jsp" %>

</body>
</html>