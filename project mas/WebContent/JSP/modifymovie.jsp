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
       
   <form name="modifymovie">
   
   
<div class="form-group">
      <center><h2>Update Movie Details </h2></center>
       <span style="color: red">*All fields are mandatory</span> <br>

<div class="form-group"><label>
    Duration:</label><input class="form-control" type="text" name="duration" required/> </div>
    


<div class="form-group"><label>
    Location: </label> <select class="form-control" name="location">
    <option selected="selected">select</option>
    <option value="1">Delhi</option>
    <option value="2">Mumbai</option>
    <option value="3">Chennai</option>
    <option value="4">Bangalore</option>
    </select>
</div>

<div class="form-group"><label>
    BeginDate:</label> <input type="text" class="form-control" name="begindate" > <input type="date" name="startdate">
   </div>
<div class="form-group"><label>
    EndDate:</label> <input type="text" class="form-control" name="enddate"> <input type="date" name="enddate">
   </div>

<div class="form-group"><label>
 	Theatre:</label><select name="theatername" class="form-control">
 	<option selected="selected">select</option>
 	<option value="1">theater1</option>
 	<option value="2">theater2</option>
 	<option value="3">theater3</option>
 	<option value="4">theater4</option>
 	</select>
 	
</div>

<div class="form-group">

	Screens: &nbsp; Screen1<input type="radio" name="screen" value="screen1">
 	screen2<input type="radio" name="screen" value="screen2">
 	screen3<input type="radio" name="screen" value="screen3">
 	</div>  

<div class="form-group"><label>
	Show start Time:</label><input type="time" name="starttime">
	</div>
<div class="form-group"><label>	
	Show end time:</label><input type="time" name="endtime">
</div>
<div class="form-group"><label>
	Class:</label> <label> Silver:</label><input type="radio" name="class" value="silver">
	<label> Gold: </label><input type="radio" name="class" value="gold">
	</div>
	
<div class="form-group"><label>	Price:</label> <input type="text"> </div>


<div>
	<input type="submit" name="submit" value="submit">
	<input type="button" name="reset" value="reset">
</div>
</form>


    </div>
    <div class="cl">&nbsp;</div>
  </div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>