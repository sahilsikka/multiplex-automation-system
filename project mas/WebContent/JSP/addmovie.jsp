<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/table.css" type="text/css"
	media="all" />
<title>Insert title here</title>
</head>
<body>
	<%@ include file="loginheader.jsp"%>
	<div id="main">
		<div id="content">
			<div id="news" style="margin-left: 185px;">
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

						
						<li style="height: 55px;"><a
							href="<%=request.getContextPath()%>/movieController?source=addmovie"><b>Add
									Movie</b></a></li>
						<li style="height: 55px;"><a
							href="<%=request.getContextPath()%>/ShowController?source=addshowpage"><b>Add
									Show</b></a></li>
						<li style="height: 55px;"><a
							href="<%=request.getContextPath()%>/movieController?source=updatemovie"><b>Update
									Movie</b></a></li>
						<li style="height: 55px;"><a
							href="<%=request.getContextPath()%>/movieController?source=viewallmovie"><b>View
									All Movie</b></a></li>
						<li style="height: 55px;"><a
							href="<%=request.getContextPath()%>/ShowController?source=viewallshow"><b>View
									All show</b></a></li>
						<li style="height: 55px;"><a
							href="<%=request.getContextPath()%>/CustomerContrller?source=viewallcustomer"><b>View
									All Customer</b></a></li>
						<li style="height: 55px;"><a
							href="<%=request.getContextPath()%>/TicketController?source=viewbooking"><b>View
									Bookings</b></a></li>
						<li style="height: 55px;"><a
							href="<%=request.getContextPath()%>/movieController?source=viewmoviebyfield"><b>View
									Movie By Field</b></a></li>
					</ul>
				</div>

			</div>

			<div id="coming" style="background-color: #F2F2F2;">
				<form action="<%=request.getContextPath()%>/movieController?source=addmovie">
					<input type="hidden" name="source" value="addmoviesuccess">


					<%
						String msg = (String) request.getAttribute("movieExists");
						if (msg == null)
							msg = "";
					%>
					<%-- <table  style="border: thick;" class="table table-condensed">
<tr>
 
    <td><div class="form-group"><b>Movie Name: </b></td>
    <td><div class="col-sm-10"><input class="form-control" type="text" name="moviename" placeholder="Movie Name" required></div></td></div>
 </tr>
 <tr>
 <td><b> Language:</b></td>
 <td><div class="col-sm-10"><select name="language"placeholder="Language" class="form-control" required>
 <option name="language" value="select"> select</option>
 <option value="hindi"> Hindi</option>
	<option value="english"> English</option>
	<option value="malayalam">Malayalam</option>
	<option value="punjabi">Punjabi</option>
 </select></td></div></tr>
 
<tr>
<td> <b>Start Date:</b></td><td><div class="col-sm-10"><input type="date" name="startdate" class="form-control"placeholder="Start Date" required></td></tr>  
<tr><td><b>End Date:</b></td> <td><div class="col-sm-10"><input type="date" name="enddate" class="form-control"placeholder="End Date" required ></div></td>
</tr> 	

<tr>
<td>
<b>Category:</b></td><td><div class="col-sm-10"><select name="category" class="form-control"placeholder="Category" required>
	<option name="category" value="select"> select</option>
	<option value="nowshowing"> NOW SHOWING</option>
	<option value="upcoming"> UPCOMING</option>
	
</select>
</td></div></tr>
<tr>
<td>
<b>Theater:</b></td><td><div class="col-sm-10"><select name="theaterid" class="form-control"placeholder="Theater Name" required>
	<option name= "theater">1234
	</option>
</select></div>
</td>
</tr>
<tr><td>Select</td><td><input type="file" name="photo" size="50"></td></tr>
<center>

<tr><td colspan="2">
 <input type="submit" value="Add Movie" class="btn btn-primary"onclick="return confirm('Are you sure?')" ></center>
<span><%=msg%></span>
</form>
  
</td></tr>

</table>  --%>
<div class="row">
					<div class="form-group">
						<center><h2>
							Add Movie Details</h2></center>
						
						<span style="color: red">*All fields are mandatory</span> <br>
		</div>
						<div class="form-group">
							<label>Movie Name:</label> <input class="form-control"
								type="text" name="moviename" placeholder="Movie Name" required />
						</div>

						<div class="form-group">
							<label>Language:</label> 
							<input class="form-control" type="text"
								name="language" placeholder="Language" required />
						</div>

						<div class="form-group">
							<label>Start Date:</label> <input class="form-control" input
								type="date" name="startdate" placeholder="Start Date" required />
						</div>

						<div class="form-group">
							<label>End Date:</label> <input class="form-control" input
								type="date" name="enddate" placeholder="End Date" required />
						</div>

						<div class="form-group">
							<label>Category:</label> <select name="category"
								placeholder="Category" class="form-control" required>
								<option name="category" value="select">select</option>
								<option value="nowshowing">NOW SHOWING</option>
								<option value="upcoming">UPCOMING</option>

							</select>
						</div>

						<div class="form-group">
							<label>Theater:</label> <select name="theaterid"
								placeholder="Theater Name" class="form-control" required>
								<option name="theater">1234</option>
							</select>
						</div>


						<div class="submit-container">
							<input type="submit" value="Submit" class="btn btn-primary" />
						</div>


					</div>
					<div class="cl"></div></form>
			</div>
		</div>
</div>
		<%-- <%@ include file="footer.jsp" %> --%>
</body>
</html>