<%@page import="com.tcs.ilp.Bean.ShowBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function updatevalue()
{
	
	document.getElementById("source").value='updateshow';
	
 	var frm = document.getElementById('frmupdate') || null;
 	if(frm) {
 	   frm.action = '<%=request.getContextPath()%>/ShowController' ;
	}
 	document.forms["frmupdate"].submit();

}

function deletevalue()
{
	document.getElementById("source").value='removeshow';
	
 	var frm = document.getElementById('frmupdate') || null;
 	if(frm) {
 	   frm.action = "<%=request.getContextPath()%>/ShowController";
		}
		document.forms["frmupdate"].submit();
	}
</script>
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


<li style="height: 55px;"><a href="<%=request.getContextPath()%>/movieController?source=addmovie"><b>Add Movie</b></a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/ShowController?source=addshowpage"><b>Add Show</b></a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/movieController?source=updatemovie"><b>Update Movie</b></a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/movieController?source=viewallmovie"><b>View All Movie</b></a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/ShowController?source=viewallshow"><b>View All show</b></a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/CustomerContrller?source=viewallcustomer"><b>View All Customer</b></a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/TicketController?source=viewbooking"><b>View Bookings</b></a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/movieController?source=viewmoviebyfield"><b>View Movie By Field</b></a></li></ul>
</div>
        
    </div>
       <div id="coming" style="background-color: #F2F2F2;">
       
       <center>
		<form name="frmupdate" id="frmupdate" action="">
			<input type="hidden" name="source" id="source" value="showvalue">
			  <div class="form-group">
      <center><h2>Show Details </h2></center>
				<%
					ShowBean sb = (ShowBean) (request.getAttribute("showobj"));
				%>
				<div class="form-group"><label>Show ID:</label><input type="text" value=<%=sb.getShowId()%>
						name="sid"></div>
				<div class="form-group"><label>Movie Id:</label><input type="text" value=<%=sb.getMovieId()%>
						name="mid"></div>
				<div class="form-group"><label>Show Date: </label><input type="text" value=<%=sb.getShowDate()%> name="sdate"></div>
				<div class="form-group"><label>Show Time:</label><input type="text" value=<%=sb.getStartTime()%>
						name="category"></div>
				<div class="form-group"><label>Status:</label><input type="text" value=<%=sb.getStatus()%>
						name="status"></div>
				<div class="form-group"><label>Screen Id:</label><input type="text" value=<%=sb.getScreenId()%>
						name="screenid"></div>


		<div class="submit-container">
			<input type="button" value="Update" onclick="updatevalue();"class="btn btn-primary" class="btn btn-primary" >
			<input type="submit" value="Delete" onclick="deletevalue();"class="btn btn-primary"></div>
		   </div>	
		</form>
	</center>
       
       
             
    <div class="cl">&nbsp;</div>
  </div>
</div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>