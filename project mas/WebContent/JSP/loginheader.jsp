<%response.setHeader("Pragma","no-cache");   
		        response.setHeader("Cache-Control","no-store");   
		        response.setHeader("Expires","0");   
		        response.setDateHeader("Expires",-1); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<body>
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
 
