
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.tcs.ilp.Bean.ClassBean"%>
<%@page import="com.tcs.ilp.Bean.ShowBean"%>
<%@page import="com.tcs.ilp.Bean.MovieBean"%>
<%@page import="com.tcs.ilp.Bean.TheaterBean"%>
<%@page import="com.tcs.ilp.Bean.LocationBean"%>
<%@page import="java.util.ArrayList"%>

<%response.setHeader("Pragma","no-cache");   
		        response.setHeader("Cache-Control","no-store");   
		        response.setHeader("Expires","0");   
		        response.setDateHeader("Expires",-1); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css" type="text/css" media="all" />
<script type="text/javascript" src="<%=request.getContextPath()%>/JS/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/JS/jquery-func.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/table.css" type="text/css" media="all" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css" type="text/css" >
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" type="text/css" >
<title>Insert title here</title>
</head>
<script type="text/javascript">
function back()
{
	//window.history.forward(-1);
};
   function callAnotherOption(a){
	   
	   
	   if(a=='locationAction')
		{
		 
		   if(document.booking.location.value!="Select")
			   {
			  
			   		document.booking.action.value=a;
				   document.booking.submit();
			   }
		   else
			   {
		
			   document.booking.theater.value="Select";
			   document.booking.movie.value="Select";
			   document.booking.showdate.value="Select";
			   document.booking.showslot.value="Select";
			   document.booking.class.value="Select";
			   document.booking.seatselect.value="Select";
			   }
		   
		  }
	   if(a=='theaterAction')
		{
		   
		   if(document.booking.theater.value!="Select")
			   {
			  
			   		document.booking.action.value=a;
				   document.booking.submit();
			   }
		   else
		   {	 
		   document.booking.movie.value="Select";
		   document.booking.showdate.value="Select";
		   document.booking.showslot.value="Select";
		   document.booking.class.value="Select";
		   document.booking.seatselect.value="Select";
		   }
		  }
	 
	   if(a=='movieAction')
		{
		
		   if(document.booking.movie.value!="Select")
			   {	
			   		document.booking.action.value=a;
				   document.booking.submit();
			   }
		   else
		   {
		  
		  
		   document.booking.showdate.value="Select";
		   document.booking.showslot.value="Select";
		   document.booking.class.value="Select";
		   document.booking.seatselect.value="Select";
		   }
		  }
	 
	   if(a=='showDateAction')
		{
		   
		   if(document.booking.showdate.value!="Select")
			   {	document.booking.action.value=a;
				   document.booking.submit();
			   }
		  
	   else
	   {
	  

	   document.booking.showslot.value="Select";
	   document.booking.class.value="Select";
	   document.booking.seatselect.value="Select";
	   }}
	 
	   if(a=='showSlotAction')
		{
		   
		   if(document.booking.showslot.value!="Select")
			   {	document.booking.action.value=a;
				   document.booking.submit();
			   }
		  
	   else
	   {	  
	
	   document.booking.class.value="Select";
	   document.booking.seatselect.value="Select";
	   }
		}
	   if(a=='showClass')
		{
		   
		   if(document.booking.class.value!='Select')
			   {	document.booking.action.value=a;
				   document.booking.submit();
			   }
		  
	   else
	   {
	  
	  
	   document.booking.seatselect.value="Select";
	   }
		}
	   if(a=='seatselection')
		{
		   
		   if(document.booking.seatselect.value!='Select')
			   {	document.booking.action.value=a;
				   document.booking.submit();
			   }
		  }
	   if(a=='finalbook')
		{
		   if(document.booking.location.value!="Select"&&document.booking.theater.value!="Select"&&document.booking.movie.value!="Select"
				   &&document.booking.showdate.value!="Select"&&document.booking.showslot.value!="Select"
				   &&document.booking.class.value!='Select'&&document.booking.seatselect.value!='Select')
		   {	
			   onclick="return confirm('Are you sure?')";
			   document.booking.action.value=a;
				   document.booking.submit();}
		   else
			   alert("Please select all values");
			 
		  }
	 
	  
   }
  
   function seatselect(){
	   
	   document.booking.source2.value=document.getElementById("seats").selected;
	   document.booking.submit();
	   }
	   
   

</script>
</head>
<body onload="back()">
<% String user1=null;String userrole=null;
if(session.getAttribute("user")==null){
user1=null;
userrole=null;
}
else{
	user1=(String)session.getAttribute("user");
	userrole=(String)session.getAttribute("role");
}%>

<div id="shell">
  <div id="header">
    <h1 id="logo"><a href="#">MovieHunter</a></h1>
   
    <div id="navigation">

<%if(user1==null){ %>
  <form method="post" action="<%=request.getContextPath()%>/LoginController?source=loginac">
       <table>
       
       <th style="color: white;">Email</th><th style="color: white;">Password</th>
       <tr>
        <td><div style="margin-right: 10px;"><input type="text" style="width: 200px;" name="id" class="form-control" name="Email" placeholder="Email"></div></td>
        <td><div style="margin-right: 10px;"><input type="password" style="width: 200px;" name="password" name="id" class="form-control" placeholder="password"></div></td>
        <td><input type="submit" name="Sign In" value="Log In" class="btn btn-primary" ></input></td>
        <tr>
        </table>
        </form>
         <br><label style="margin-left: 250px;"><p style="float: right">New User?&nbsp;<a style="color: white;" href="<%=request.getContextPath()%>/CustomerContrller?source=register">REGISTER</a></p></label>
<%} %>
<%if(user1!=null&&userrole.equals("user")) { %>
<ul>

<li class='active has-sub'><a href='#'><span>Welcome, <%=user1 %></span></a>
<ul>
<li class='has-sub'><a href="<%=request.getContextPath()%>/CustomerContrller?source=view1&email=<%=user1 %>"><span>View Profile</span></a>
<ul></ul>
</li>
 <li class='has-sub'><a href="<%=request.getContextPath()%>/LoginController?source=logout"><span>Logout</span></a>     
</li>
<li class='has-sub'><a href="<%=request.getContextPath()%>/TicketController?source=bookedhistory"><span>Booking History</span></a>     
</li>
</ul></li>
</ul>
<%} 
if(user1!=null&&userrole.equals("admin")){%>
<ul>

<li class='active has-sub'><a href='#'><span>Welcome, <%=user1 %></span></a>
<ul>

 <li class='has-sub'><a href="<%=request.getContextPath()%>/LoginController?source=logout"><span>Logout</span></a>     
</li>
</ul></li>
</ul>
<%} %>

</div>
        </li></td>
        <tr>
        </table>
        
        
        
       <!--  <li><a class="active" href="#">sign in</a></li>
        <li><a href="#">NEWS</a></li>
        <li><a href="#">IN THEATERS</a></li>
        <li><a href="#">COMING SOON</a></li>
        <li><a href="#">CONTACT</a></li>
        <li><a href="#">ADVERTISE</a></li>-->
      </ul>
    </div>
    <div id="sub-navigation">
      <ul>
        <li style="margin-left: 20px;">
        <%if(user1!=null&&userrole.equals("user")){%><a href="<%=request.getContextPath()%>/JSP/loginsuccess.jsp">HOME</a><%} else %>
        <%if(user1==null){%><a href="<%=request.getContextPath()%>/JSP/index.jsp">HOME</a><%} %></li>
        <li><a href="#">NOW SHOWING</a></li>
        <li><a href="#">UP COMING</a></li>
        <li><a href="#">BOOK TICKET</a></li>
      </ul>
      <div id="search">
        <form action="#" method="get" accept-charset="utf-8">
          <label for="search-field" style="visibility: hidden; width: 50px;" >SEARCH</label>
          <input type="text" name="search field" value="Enter search here" style="visibility: hidden; width: 50px;"  id="search-field" class="blink search-field"  />
          <input type="submit" value="GO!" class="search-button" style="visibility: hidden; width: 50px;" />
        </form>
      </div>
    </div>
  </div>
 
<%

  ArrayList<LocationBean> listLocation = (ArrayList<LocationBean>)request.getAttribute("locationlist");
  ArrayList<TheaterBean> listTheater = (ArrayList<TheaterBean>)request.getAttribute("theaterlist");
  ArrayList<MovieBean> listMovies = (ArrayList<MovieBean>)request.getAttribute("movielist");
  ArrayList<ShowBean> listShowDates = (ArrayList<ShowBean>)request.getAttribute("showdatelist");
  ArrayList<ShowBean> listShowSlots = (ArrayList<ShowBean>)request.getAttribute("showslotlist");
  ArrayList<ClassBean> listShowClass = (ArrayList<ClassBean>)request.getAttribute("showclasslist");
  String error=(String)request.getAttribute("errormsg");
  
  if(listShowDates!=null)out.print(listShowDates.get(0).getShowDate());
%>
<form name="booking" action="<%=request.getContextPath()%>/BookingController" method="get" >
   
   <input type="hidden" name="action" value="">
   <input type="hidden" name="show" value="">
  	<input type="hidden" name="seats" value="">
   <input type="hidden" name="source" value="finalbook">
   <input type="hidden" name="source" value="">

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


<li style="height: 55px;"><a href="<%=request.getContextPath()%>/CustomerContrller?source=view1&email=<%=session.getAttribute("user") %>"><b>View Profile</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/TicketController?source=bookedhistory"><b>Booking History</a></li>
<li style="height: 55px;"><a href="<%=request.getContextPath()%>/LoginController?source=logout"><b>Log Out</a></li>

</ul>
</div>
        
    </div>
    
       <div id="coming" style="background-color: #F2F2F2;">
       
       <div class="form-group">
       <center><h2>Add Movie Details </h2></center>
       <span style="color: red">*All fields are mandatory</span> <br>
       <div class="form-group">
      <label>
   Location :</label><select name="location" onchange="callAnotherOption('locationAction')" class="form-control">
              <option value="Select">Select Location</option>
               <%
                int selectedLocation=0;       
                if(listLocation!=null){
                	if((Boolean)request.getAttribute("setLocationFlag"))
                		 selectedLocation = (Integer)(request.getAttribute("selectedLocation"));
                	
                	for(LocationBean location : listLocation){                
               %>
               <option  <%if(selectedLocation!=0 && location.getLocationId()==selectedLocation){out.println("selected");}%> value="<%=location.getLocationId()%>"> <%=location.getLocationName()%></option>
               
               <%}}%>
           </select> </div> 
           
       <div class="form-group">    <label>
    Theater : </label><select name="theater" onchange="callAnotherOption('theaterAction')"class="form-control">
               <option value="Select">Select Theater</option>
   				<%
   				int selectedTheater=0;   			 
                if(listTheater!=null){
                	if((Boolean)request.getAttribute("setTheaterFlag"))
                		selectedTheater = (Integer)request.getAttribute("selectedTheater");
                	
                	for(TheaterBean theater : listTheater){
                
               %> 
                 <option <%if(selectedTheater!=0 && theater.getTheaterId()==selectedTheater){out.println("selected");}%> value="<%=theater.getTheaterId()%>" > <%=theater.getTheaterName()%></option> 
                <%}}%> 
           </select> </div>
        <div class="form-group">    <label>
	Movies :</label> <select name="movie" onchange="callAnotherOption('movieAction')"class="form-control">
               <option value="Select">Select Movie</option>
   				<%
   				
   				int selectedMovie=0;
                if(listMovies!=null){
                	if((Boolean)request.getAttribute("setMovieFlag"))
                		selectedMovie = (Integer)request.getAttribute("selectedMovie");
                	for(MovieBean movie : listMovies){                
               %> 
               
                 <option <%if(selectedMovie!=0 && movie.getMovieId()==selectedMovie){out.println("selected");}%> value="<%=movie.getMovieId()%>"> <%=movie.getMovieName()%></option> 
                <%} }%> 
           </select> </div>
          <div class="form-group">  <label>
   Show Dates:</label> <select name="showdate" onchange="callAnotherOption('showDateAction')"class="form-control">
   			<option value="Select">Select Date</option>
   			
   			<% 
   				
   				String selectedShowDate=null;
   				Set<String> hs = new HashSet<String>();
   				if(listShowDates!=null)for(ShowBean s:listShowDates)hs.add(s.getShowDate());
                if(listShowDates!=null){
                	if((Boolean)request.getAttribute("setShowDateFlag")){
                		selectedShowDate = (String)request.getAttribute("selectedshowdate");}
                	for(String sBean : hs){
                
               %> 
                 <option <%if(selectedShowDate!=null && sBean.equals(selectedShowDate)){out.println("selected");}%> value="<%=sBean%>"> <%=sBean%></option> 
                <%}}%> 
           </select> 
     </div>       
     
      <div class="form-group"> <label>
     Show Time: </label> <select name="showslot" onchange="callAnotherOption('showSlotAction')"class="form-control">      
           <option value="Select">Select Time</option>
           
           <% 
   				String selectedShowSlots=null;
   			
                if(listShowSlots!=null){
                	if((Boolean)request.getAttribute("setShowSlotFlag")){
                		selectedShowSlots = (String)request.getAttribute("selectedshowslot");}
                	for(ShowBean sBean : listShowSlots){
                
               %> 
                 <option <%if(selectedShowSlots!=null && sBean.getStartTime().equals(selectedShowSlots)){out.println("selected");}%> value="<%=sBean.getStartTime()+" "+sBean.getShowId()%>"> <%=sBean.getStartTime()%></option> 
                <%}}%>
           </select>
           </div>
              <div class="form-group">  <label>         
           Show Class: </label> <select name="class" onchange="callAnotherOption('showClass')"class="form-control">      
           <option value="Select">Select class</option>           
           <% 
   				int selectedClass=0;
   			
                if(listShowClass!=null){
                 	if((Boolean)request.getAttribute("setShowClassFlag")){
                 		selectedClass = (Integer)request.getAttribute("selectedshowclass");}
                 	for(ClassBean cBean : listShowClass){
                
               %> 
                 <option <%if(selectedClass!=0 && cBean.getClassId()==selectedClass){out.println("selected");}%> value="<%=cBean.getClassId()%>"> <%=cBean.getClassName()+" "+cBean.getPrice()%></option> 
                <%} }%> 
           </select> 
         </div>    
         <div class="form-group"> <label>
       Seat Selection: </label>  <select id="seats" name="seatselect" onchange="callAnotherOption('seatselection')"class="form-control">
         <option value="Select">Select Seats</option>    
        <%
        	int selectedSeats=0;
        	if((Boolean)request.getAttribute("setseatselectionflag"))
        		selectedSeats=(Integer)request.getAttribute("seatselection");
        	
           for(int i=1;i<=10;i++){ %>
           <option <%if(selectedSeats!=0&&selectedSeats==i){out.println("selected");}%> value="<%=i%>" ><%=i%></option><%} %></select>
           
          </select></div>
         <div class="submit-container">
          
           <center><input type="button" name="actionsubmit"value="Book Ticket"  class="btn btn-primary" onclick="callAnotherOption('finalbook')" ></center>
           <span name="error" style="color: red"> <%=error%></span>
           
             </div>
       </div>
       
          </div>
    <div class="cl">&nbsp;</div>
  </div>
</div>

<%@ include file="footer.jsp" %>
</form>
</body>
</html>