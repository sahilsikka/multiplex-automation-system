<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
 <div id="main">
    <div id="content">
    <%String msg=(String)request.getAttribute("msg"); 
   if(msg==null)msg="";%> 
<form method="post" action="<%=request.getContextPath()%>/LoginController?source=loginac">
    
  <div class="form-group">
    <label>EmailID: </label>
    <input type="email" name="id" class="form-control"  placeholder="Enter email">
  </div>
  <div class="form-group">
    <label>Password</label>
    <input type="password"name="password" class="form-control"  placeholder="Password">
  </div>
  <center><input type="submit" value="Sign in" class="btn btn-primary"></center>
<br><span><%=msg %></span><br class="clear"></div></div>
</form>
    
      </div>
</div>

<%@ include file="footer.jsp" %> 

</body>
</html>