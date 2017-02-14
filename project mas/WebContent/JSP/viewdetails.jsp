<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.tcs.ilp.Bean.MovieBean" import="com.tcs.ilp.Bean.ShowBean" import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css" type="text/css" >
<script type="text/javascript" src="<%=request.getContextPath()%>/JS/validateupdate.js"></script>
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
       
<%MovieBean mbean = (MovieBean)request.getAttribute("mbean");%>

<%ArrayList<String> catgory = (ArrayList<String>)request.getAttribute("clist");%>


<form action="<%=request.getContextPath()%>/movieController" method="get" name="formOne">

<input type="hidden" name="id" value="<%= request.getAttribute("movieid")%>"> 
<input type="hidden" name="source" value="Update">
  <a href="<%=request.getContextPath()%>/movieController?source=admin">Admin Dashboard</a>
<table class="table table-striped">
<tr><td>
Startdate: (yyyy-mm-dd)</td><td><input type="text" name="startdate" value="<%=mbean.getStartDate()%>" class="form-control" readonly></td></tr>
<tr><td>Enddate: (yyyy-mm-dd)</td><td><input type="text" name="enddate" value="<%=mbean.getEndDate()%>"class="form-control" readonly><br></td></tr>
<tr><td>StartDate:</td><td><input type="date" name="sd"class="form-control" onblur="checkstartdate()" value="<%=mbean.getStartDate()%>" ><span style="color: red" id="startdate"></span></td></tr>
<tr><td>EndDate:</td><td><input type="date" name="ed"class="form-control" onblur="checkenddate()" value="<%=mbean.getEndDate()%>"><span style="color: red" id ="enddate"></span><br></td></tr>



<tr><td>Category:</td><td><select name="category"class="form-control" selected>
<option value="select">select</option>
<option value="<%=catgory.get(0)%>">Now Showing</option>
<option value="<%=catgory.get(1)%>">Up Coming</option>
</select><span style="color: red" id="category1"></span><br></td></tr></table>

<center><input type="submit" value="Update" class="btn btn-primary"class="form-control" style="margin-right: 20px;" onclick=" return validateupdate()">
<input type="reset" value="Reset" class="btn btn-primary"class="form-control" ></center>


</form>
  </div>
    <div class="cl">&nbsp;</div>
  </div>
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>