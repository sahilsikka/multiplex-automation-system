<%@page import="com.tcs.ilp.Bean.TicketBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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


<li style="height: 55px;"><a href="<%=request.getContextPath()%>/CustomerContrller?source=view1&email=<%=user1 %>"><b>View Profile</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/TicketController?source=bookedhistory"><b>Booking History</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/LoginController?source=logout"><b>Log Out</a></li>
</div>
        
    </div>
       <div id="coming" style="background-color: #F2F2F2;">

<%ArrayList<TicketBean> ticketList=(ArrayList<TicketBean>)request.getAttribute("ticketlist"); 
 request.setAttribute("table", ticketList);%>

<center><h3>View Booking List </h3></center>
<%
if(ticketList!=null){
	 %>
<!-- <table border="1" class="table table-striped">
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
</tr> -->
<%-- <%for(TicketBean ticketbean:ticketList){%>
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
</table>--%>
<display:table name="table" sort="list" id="tList" pagesize="5" requestURI="TicketController" class="table table-bordered table-hover">
<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
		<display:column property="bookingId"  title="BookingId" sortable="true" />
		<display:column property="emailid"  title="Email id" sortable="true"/>
		<display:column property="movieName"  title="Movie Name" sortable="true"/>
		<display:column property="language"  title="language" sortable="true"/>
		<display:column property="showDate"  title="showDate" sortable="true"/>
		<display:column property="showSlot"  title="showSlot" sortable="true"/>
		<display:column property="seatNumber"  title="seatNumber" sortable="true"/>
		<display:column property="price"  title="price" sortable="true"/>
		<display:column property="screenId" title="screenId" sortable="true"/>
		<%-- <display:column media="html" title="view">
		<a href="<%=request.getContextPath() %>/OutletController?source=viewById&&id=${tList.outletId}">View</a>
	
		</display:column> --%>
			</display:table>


<%}%>






  </div>
</div>

<%@ include file="footer.jsp" %> 
  </div>

</body></html>