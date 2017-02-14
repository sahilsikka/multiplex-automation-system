<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.tcs.ilp.Bean.MovieBean" %>
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
 <a href="<%=request.getContextPath()%>/movieController?source=admin">Admin Dashboard</a>
  <center><h3>Search Movie </h3></center>
<form action="<%=request.getContextPath() %>/movieController">

<table><tr><td><select name="selectField" class="form-control">
	<option>select</option>
	
	<option value="byname">View Movie By Name</option>
	<option value="bylang">View Movie By Language</option>
	<option value="bycat">View Movie By Category</option>
</select></td>
<td size="20px"><input type="submit" value="Submit" class="btn btn-primary"></td></tr></table>

<input type="hidden" name="source" value="by">
<%
ArrayList<String> mList= (ArrayList<String>)request.getAttribute("mlist");
if(mList!=null){%>
	<table border="1" class="table table-striped">
	<% for(String mb:mList ){%> 
<tr><td><%=mb%></td></tr> 
<%}%>
	</table>
<% }%>

<% ArrayList<MovieBean> lList= (ArrayList<MovieBean>)request.getAttribute("llist");
if(lList!=null){%>
	<table border="1" class="table table-striped">
	<tr><th>Movie Name</th><th>Language</th></tr>
	<% for(MovieBean mb:lList ){%> 
<tr><td><%=mb.getMovieName()%></td>
<td><%=mb.getLanguage()%></td></tr> 

<%}%>
	</table>
<%}%>


<%
ArrayList<String> cList= (ArrayList<String>)request.getAttribute("clist");
if(cList!=null){%>
	<table border="1" class="table table-striped">
	<% for(String mb:cList ){%> 
<tr><td><%=mb%></td></tr> 
<%}%>
	</table>
<% }%>


</form>

 <br class="clear">
  </div>
  
</div>


</body>
</html>