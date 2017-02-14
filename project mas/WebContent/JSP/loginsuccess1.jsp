<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.tcs.ilp.Bean.CustomerBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <%CustomerBean cbean = (CustomerBean)request.getAttribute("cbean");%> --%>
<img src="<%=request.getContextPath()%>/images/tickmark.jpeg" width="50px" height="50px;" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;<b style="font-size: 30px;">Success</b><br><br><br>
<span style="color:Green; font-size: 20px;">Congratulations!</span>
<p>You have successfully logged in to our Web site</p>
<p style="color:blue">Your email address is: &nbsp; <%-- <%=cbean.getEmailId()%> --%></p>
<p style="color:blue">Your password is: &nbsp; <%-- <%=cbean.getPassword()%> --%></p>
</body>
</html>