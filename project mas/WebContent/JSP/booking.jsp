<%@page import="com.tcs.ilp.Bean.MovieBean"%>
<%@page import="com.tcs.ilp.Bean.BookingBean"%>
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
    margin-left: 185px;">
    
     <div class="sidebarmenu">
<ul id="sidebarmenu1">


<li style="height: 55px;"><a href="<%=request.getContextPath()%>/CustomerContrller?source=view1&email=<%=user1 %>"><b>View Profile</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/TicketController?source=bookedhistory"><b>Booking History</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/LoginController?source=logout"><b>Log Out</a></li>
</div>
        
    </div>
    
       <div id="coming" style="background-color: #F2F2F2;">
<%BookingBean bookingBean=(BookingBean)request.getAttribute("finalbooking"); %>
<%MovieBean movieBean=(MovieBean)request.getAttribute("finalbookingmovie"); %>
<%String showDate=(String)request.getAttribute("showdate"); %>
<%String showSlot=(String)request.getAttribute("showslot"); %>

<center><h2> Ticket </h2></center>
<table border="1" class="table table-condensed">
<tr>
<td>Booking ID:</td><td><%=bookingBean.getBookingId() %></td></tr>
<tr><td>Email ID:</td><td><%=bookingBean.getEmailId() %></td></tr>
<tr><td>Movie Name:</td><td><%=movieBean.getMovieName() %></td></tr>
<tr><td>Language:</td><td><%=movieBean.getLanguage() %></td></tr>
<tr><td>Show Date:</td><td><%=showDate%></td></tr>
<tr><td>Show Time:</td><td><%=showSlot%></td></tr>
<tr><td>Seats Booked:</td><td><%=bookingBean.getSeatNumber()%></td></tr>
<tr><td>Price:</td><td><%=bookingBean.getPrice()%></td></tr>

</table>

<form action="<%=request.getContextPath()%>/TicketController">
<input type="hidden" name="source" value="makepayment">
<input type="hidden" name="source1" value=<%=bookingBean.getBookingId()%>>
<input type="hidden" name="source2" value=<%=bookingBean.getEmailId()%>>
<input type="hidden" name="source3" value=<%=movieBean.getMovieName()%>>
<input type="hidden" name="source4" value=<%=movieBean.getLanguage()%>>
<input type="hidden" name="source5" value=<%=showDate%>>
<input type="hidden" name="source6" value=<%=showSlot%>>
<input type="hidden" name="source7" value=<%=bookingBean.getSeatNumber()%>>
<input type="hidden" name="source8" value=<%=bookingBean.getPrice()%>>

<input type="submit" name="makepayment" value="payment">

  <div class="cl">&nbsp;</div>
  </div>
</div>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>