<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.tcs.ilp.Bean.MovieBean" %>
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
       <form name="viewbyname"
				action="<%=request.getContextPath()%>/movieController">
				<select name="searchField">
					<option selected="selected">select</option>
					<option value="searchbyname">search By Movie Name</option>
					<option value="searchbylanguage">search By Language</option>
					<option value="searchbycategory">search By Category</option>


				</select> Enter your option<input type="text" name="name"><br> <input
					type="submit" name="source" value="Find">


				
  <a href="<%=request.getContextPath()%>/movieController?source=admin">Admin Dashboard</a>   
<center>

<h2>Movie Details</h2>

<%

ArrayList<MovieBean> mList= (ArrayList<MovieBean>) request.getAttribute("movielist");	
request.setAttribute("MovieList", mList);
if(!mList.isEmpty())
{%>
	<display:table name="MovieList" sort="list" pagesize="5" id="tList" requestURI="movieController" class="table table-bordered table-hover">
	<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
	<display:column property="movieId"  title="Movie Id" sortable="true" />
	<display:column property="movieName"  title="Movie Name" sortable="true"/>
 	<display:column property="language"  title="Language" sortable="true"/> 
	<display:column property="category"  title="Category" sortable="true"/>
	<display:column property="status"  title="Status" sortable="true"/>
	
	<display:column media="html" title="View">
	<a href="<%=request.getContextPath() %>/movieController?source=viewmoviebyid&&movieid=${tList.movieId}&moviename=${tList.movieName}&movielanguage=${tList.language}">View</a></display:column>
	<display:column media="html" title="Delete">
	<a href="<%=request.getContextPath() %>/movieController?source=deletemovie&&moviename=${tList.movieName}&&movielanguage=${tList.language}" onclick="return confirm('Are you sure you want to delete?')">Delete</a></display:column>
	<display:column media="html" title="Update">
	<a href="<%=request.getContextPath() %>/movieController?source=updatemovie1&&moviename=${tList.movieName}&&movielanguage=${tList.language}" onclick="return confirm('Are you sure you want to update?')">Update</a>

	</display:column> 
		</display:table>
<%}%>
<%--  <% for(MovieBean mb:mList){%>   --%>




<%-- <tr><td><a href="<%=request.getContextPath()%>/movieController?source=viewmoviebyid&movieid=<%= mb.getMovieId()%>&moviename=<%= mb.getMovieName()%>&movielanguage=<%= mb.getLanguage()%>">View</a></td> --%>
<%-- <td><a href="<%=request.getContextPath()%>/movieController?source=deletemovie&moviename=<%= mb.getMovieName()%>&movielanguage=<%= mb.getLanguage()%>"onclick="return confirm('Are you sure you want to delete?')">delete</a></td> --%>
<%-- <td><a href="<%=request.getContextPath()%>/movieController?source=updatemovie1&moviename=<%= mb.getMovieName()%>&movielanguage=<%= mb.getLanguage()%>"onclick="return confirm('Are you sure you want to update?')">update</a></td> --%>

<%-- 	<td><%= mb.getMovieId()%></td> --%>
<%-- 	<td><%= mb.getMovieName()%></td> --%>
<%-- 	<td><%= mb.getLanguage() %></td> --%>
<%-- 	<td><%= mb.getCategory()%></td> --%>
<%-- 	<td><%= mb.getStatus()%></td> --%>
	
<!-- </tr>  -->
<%--  <%} %> --%>
<!-- </table> -->
</center>
<a href="<%=request.getContextPath()%>/movieController?source=viewallmovie">Back</a>
			</form>
  </div>
    <div class="cl">&nbsp;</div>
  </div>
</div>
<%@ include file="footer.jsp" %> 

</body>
</html>