<%@page import="com.tcs.ilp.Bean.ScreenBean"%>
<%@page import="com.tcs.ilp.Bean.MovieBean"%>
<%@page import="java.util.ArrayList"%>
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
    margin-left: 185px; height: 530px;">
    
    <div class="sidebarmenu">
<ul id="sidebarmenu1" style="height: 530px;">


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

 <form action="<%=request.getContextPath()%>/ShowController" >

<%String msg=(String)request.getAttribute("showexists"); 
if(msg==null)msg="";%>
<input type="hidden" name="source" value="submitshow">
<a href="<%=request.getContextPath()%>/movieController?source=admin">Admin Dashboard</a>
<div class="form-group">
      <center><h2>Add Show Details </h2></center>
       <span style="color: red">*All fields are mandatory</span> <br>

<div class="form-group"><label>Theater:</label>

<select name="theater" placeholder="theater" class="form-control" required>
	<option name="category" value="select"> select</option>
	<option value="nowshowing"> PVR</option>
	<option value="upcoming"> IONX</option>
	
</select></div>

<div class="form-group">
<label>Movie Name:</label><select name="moviename"class="form-control" required>
<%ArrayList<MovieBean> movieList=(ArrayList<MovieBean>)request.getAttribute("movielist"); 

if(movieList!=null)
{
for(MovieBean mBean:movieList)
{
%>
<option value="<%=mBean.getMovieId()%>"> <%= mBean.getMovieName()+" "+mBean.getLanguage() %></option>
<%}} %>
</select></div><br>

<div class="form-group">
<label>Screen Name:</label>

<%ArrayList<ScreenBean> screenList=(ArrayList<ScreenBean>)request.getAttribute("screenlist");
if(screenList!=null){
int screenCount=1;

for(ScreenBean sBean:screenList){
%>
<input type="radio" name="screenid" value="<%=sBean.getScreenId()%>"required>Screen <%=screenCount++ %>

<%}}%>
</div><br>



<div class="form-group">
<label>Start Date:</label><input type="date" name="startdate1" class="form-control"required><br></div>

<div class="form-group"><label>Show Slot:</label>
<select name="showslot" class="form-control" required>
	<option value="9AM-12PM">9AM-12PM</option>
	<option value="12:30PM-3:30PM">12:30PM-3:30PM</option>
	<option value="4PM-7PM">4PM-7PM</option>
	<option value="9PM-12AM">9PM-12AM</option>
	
</select>
</div>
<!-- class<select name="classname" > -->
<!-- <option value="silver">silver</option> -->
<!-- <option value="gold">gold</option> -->
<!-- </select><br> -->

<div class="form-group"><label>Silver Class Price:</label><input type="text" name="silverprice"class="form-control"required placeholder="Silver Class Price"><br></div>

<div class="form-group"><label>Gold Class Price: </label><input type="text" name="goldprice"class="form-control"required placeholder="Gold Class Price"><br></div>

<div class="submit-container">
<input type="submit" value="Submit"  name="addshow" class="btn btn-primary" onclick="return confirm('Are you sure?')" /><span style="color: red"><%=msg%></span>
</div>
</form>
</div>

     </div>
    <div class="cl">&nbsp;</div>
  </div>
</div>


     <!--   <div class="form-group">
      <center><h2>Add Movie Details </h2></center>
       <span style="color: red">*All fields are mandatory</span> <br>
<div class="form-group"><label>Movie Name:</label>
<input class="form-control" type="text" name="moviename" placeholder="Movie Name" required/> </div>

<div class="form-group"><label>Language:</label>
<input class="form-control" type="text" name="language"placeholder="Language" required /></div>

<div class="form-group"><label>Start Date:</label>
<input class="form-control" input type="date" name="startdate" placeholder="Start Date" required /></div>

<div class="form-group"><label>End Date:</label>
<input class="form-control" input type="date" name="enddate" placeholder="End Date" required /></div>

<div class="form-group"><label>Category:</label>

<select name="category" placeholder="Category" class="form-control" required>
	<option name="category" value="select"> select</option>
	<option value="nowshowing"> NOW SHOWING</option>
	<option value="upcoming"> UPCOMING</option>
	
</select></div>

<div class="form-group"><label>Theater:</label>
<select name="theaterid" placeholder="Theater Name" class="form-control" required>
	<option name= "theater">1234
	</option>
</select></div>


<div class="submit-container">
<input class="submit-button" type="submit" value="Submit" class="btn btn-primary"  />
</div> -->


<%@ include file="footer.jsp" %>
</body>
</html>