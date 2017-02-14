<%@page import="com.tcs.ilp.Bean.TicketBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://displaytag.sf.net" prefix="display" %>
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
    	<div id="news" style="margin-left: 185px;">
    
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
		<%ArrayList<TicketBean> ticketList=(ArrayList<TicketBean>)request.getAttribute("ticketlist"); 
		request.setAttribute("TicketList", ticketList);%>
		
			<a href="<%=request.getContextPath()%>/movieController?source=admin">Admin Dashboard</a>
			<center><h3>View Booking List </h3></center>
<%
if(ticketList!=null){%>
<%-- 
<table border="1" class="table table-condensed">
<tr>
<td><div class="form-group"><b>Booking ID</b></div></td>
<td><div class="form-group"><b>Email ID</b></div></td>
<td><div class="form-group"><b>Movie Name</b></div></td>
<td><div class="form-group"><b>Language</b></div></td>
<td><div class="form-group"><b>Show Date (yyyy-mm-dd)</b></div></td>
<td><div class="form-group"><b>Show Slot</b></div></td>
<td><div class="form-group"><b>Seat Number</b></div></td>
<td><div class="form-group"><b>Price</b></div></td>
<td><div class="form-group"><b>Screen ID</b></div></td>
</tr>
<%for(TicketBean ticketbean:ticketList){%>
<tr>
<td><div class="form-group"><b><%=ticketbean.getBookingId() %></b></div></td>
<td><div class="form-group"><b><%=ticketbean.getEmailid() %></b></div></td>
<td><div class="form-group"><b><%=ticketbean.getMovieName() %></b></div></td>
<td><div class="form-group"><b><%=ticketbean.getLanguage() %></b></div></td>
<td><div class="form-group"><b><%=ticketbean.getShowDate().substring(0, 11) %></b></div></td>
<td><div class="form-group"><b><%=ticketbean.getShowSlot() %></b></div></td>
<td><div class="form-group"><b><%=ticketbean.getSeatNumber() %></b></div></td>
<td><div class="form-group"><b><%=ticketbean.getPrice() %></b></div></td>
<td><div class="form-group"><b><%=ticketbean.getScreenId() %></b></div></td>
</tr>
<%}}%>
 </table>--%>
 <display:table name="TicketList" sort="list" pagesize="5" id="tList" requestURI="TicketController"  class="table table-bordered table-hover">
 	<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
		<display:column property="bookingId"  title="Booking Id" sortable="true" />
		<display:column property="emailid"  title="Email Id" sortable="true"/>
		<display:column property="movieName"  title="Movie Name" sortable="true"/>
		<display:column property="language"  title="Language" sortable="true"/>
		<display:column property="showDate"  title="Show Date" sortable="true"/>
		<display:column property="showSlot"  title="Show Slot" sortable="true"/>
		<display:column property="seatNumber"  title="Seat Number" sortable="true"/>
		<display:column property="price"  title="Price" sortable="true"/>
		<display:column property="screenId" title="Screen Id" sortable="true"/>
		
	<%-- 		<display:column media="html" title="view"> --%>
	<%-- 		<a href="<%=request.getContextPath() %>/OutletController?source=viewById&&id=${tList.outletId}">View</a> --%>
		
	<%-- 		</display:column> --%>
			</display:table>
 <%} %>

	</div>
	
	
 	<div class="cl">&nbsp;</div>
  </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>