<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.tcs.ilp.Bean.ShowBean" %>
    <%@taglib uri="http://displaytag.sf.net" prefix="display" %>
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
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/movieController?source=viewmoviebyfield"><b>View Movie By Field</a></li></ul>
</div>
        
    </div>
       <div id="coming" style="background-color: #F2F2F2;">

<a href="<%=request.getContextPath()%>/movieController?source=admin">Admin Dashboard</a>

  <form name="viewbyname" action="<%=request.getContextPath()%>/ShowController">
			<select name="searchField">
			<option selected="selected">select</option>
				<option value="searchbydate">search By Show date</option>
				<option value="searchbytime">search By time</option>
				
				
			</select>

				Enter your option<input type="text" name="name"><br> <input
					type="submit" name="source" value="Find">


  <center><h2>Show Details</h2></center>
  
<%-- <table border="1"class="table table-striped">
<tr><th></th><th></th><th></th><th>show ID</th><th>show Date(yyyy-mm-dd)</th><th>movie Id</th><th>show time</th><th>screen id</th><th>status</th></tr>
<%

ArrayList<ShowBean> sList= (ArrayList<ShowBean>) (request.getAttribute("showlist"));
if(sList!=null)

	
for(ShowBean sb:sList )
{%>
<tr><td><a href="<%=request.getContextPath()%>/ShowController?source=viewshowbysid&showid=<%= sb.getShowId()%>">View</a></td>
<td><a href="<%=request.getContextPath()%>/ShowController?source=deleteshow&showid=<%= sb.getShowId()%>">delete</a></td>

<td><a href="<%=request.getContextPath()%>/ShowController?source=updateshowbysid&showid=<%= sb.getShowId()%>">update by show id</a></td>
	<td><%=sb.getShowId()%></td>
	<td><%= sb.getShowDate()%></td>
	<td><%= sb.getMovieId() %></td>
	<td><%= sb.getStartTime()%></td>
	<td><%= sb.getScreenId()%></td>
	<td><%= sb.getStatus()%></td>
</tr> 
<%}%>
</table>
 --%>
 <%
 ArrayList<ShowBean> sList= (ArrayList<ShowBean>) (request.getAttribute("showlist"));
 request.setAttribute("ShowList", sList);
 out.println("showlist is  "+sList.size());
 if(!sList.isEmpty())
	 
	 
	 {%>
		<display:table name="ShowList" sort="list" pagesize="5" id="tList" requestURI="ShowController" class="table table-bordered table-hover">
		<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
	<display:column property="showId"  title="Show Id" sortable="true" />
	<display:column property="movieId"  title="Movie Id" sortable="true"/> 
	<display:column property="showDate"  title="Show Date" sortable="true"/> 	
	<display:column property="startTime"  title="Start Time" sortable="true"/>

	
		 <display:column media="html" title="View">
	<a href="<%=request.getContextPath()%>/ShowController?source=viewshowbysid&showid=${tList.showId}">View</a></display:column>
	 <display:column media="html" title="Delete">
	<a href="<%=request.getContextPath()%>/ShowController?source=deleteshow&showid=${tList.showId}">Delete</a></display:column>
	 <display:column media="html" title="Update">
	<a href="<%=request.getContextPath()%>/ShowController?source=updateshowbysid&showid=${tList.showId}">Update</a>
	</display:column>  
		</display:table>
<%} %>
         <a href="<%=request.getContextPath()%>/ShowController?source=viewallshow">Back</a></div>
    <div class="cl">&nbsp;</div>
    
</form>
  </div>
</div>

<%@ include file="footer.jsp" %> 

</body>
</html>