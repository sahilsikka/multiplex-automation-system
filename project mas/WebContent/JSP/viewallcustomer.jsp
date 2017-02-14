<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.tcs.ilp.Bean.*" %>
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
<form name="viewbyname" action="<%=request.getContextPath()%>/CustomerContrller">
			<label style="margin-left: 20px;margin-top: 20px;">Search</label><select name="searchField">
				<option selected="selected">select</option>
				<option value="searchbyname">By Name</option>
				<option value="searchbycity">By City</option>
				<option value="searchbyemail">By Email Id</option>
				<option value="searchbyphn">By Contact Number</option>
				<option value="searchbystatus">By Status</option>
				<option value="searchbygender">By Gender</option>
				<option value="searchbydob">By Date of Birth</option>
				
			</select>

				Enter your option:<input type="text" name="name"><br> <center><input
					type="submit" name="source" value="Go"></center>
				<h2>Customer Details</h2>
				<center>
<%

ArrayList<CustomerBean> cList= (ArrayList<CustomerBean>) (request.getAttribute("customerlist"));
if(cList!=null)
{
%> 
<%-- <!-- <td><a href="<%=request.getContextPath()%>/CustomerContrller?source=deactivatebycid&&customerid=<%=cb.getEmailId()%>&&status=<%= cb.getDeactivation()%>">change status</a></td>
<td><a href="<%=request.getContextPath()%>/CustomerContrller?source=viewprofile&customeremailid=<%= cb.getEmailId()%>">view profile</a></td>

	
	<td><%= cb.getFirstName()%></td>
	<td><%= cb.getLastName() %></td>
	<td><%= cb.getDob()%></td>
	<td><%= cb.getGender()%></td>
	<td><%= cb.getPhone()%></td>
	<td><%= cb.getCity()%></td>
	<td><%= cb.getLocation()%></td>
	<td><%= cb.getEmailId()%></td>
	<td><%= cb.getPassword()%></td>
	<td><%= cb.getDeactivation()%></td>
	
</tr> 
</table>--> --%>

<display:table name="customerlist" sort="list" pagesize="5" id="tList" requestURI="CustomerContrller" class="table table-bordered table-hover">
<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
		<display:column property="firstName"  title="FirstName" sortable="true" />
		<display:column property="lastName"  title="LastName" sortable="true"/>
		<display:column property="gender"  title="Gender" sortable="true"/>
		<display:column property="city"  title="City" sortable="true"/>
		<display:column property="deactivation"  title="Status" sortable="true"/>
	 	
		<display:column media="html" title="Change Status">
		<a href="<%=request.getContextPath()%>/CustomerContrller?source=deactivatebycid&&customerid=${tList.emailId}&&status=${tList.deactivation}">change status</a>
		</display:column><display:column media="html" title="View Profile"><a href="<%=request.getContextPath()%>/CustomerContrller?source=viewprofile&customeremailid=${tList.emailId}">view profile</a>
		</display:column>
 		</display:table>
		
	<%} %>

</center>
</form>
<a href="<%=request.getContextPath()%>/CustomerContrller?source=viewallcustomer">Back</a>
 </div>
 
    <div class="cl">&nbsp;</div>
    
  </div>
</div>
<%@ include file="footer.jsp" %> 

</body>
</html>