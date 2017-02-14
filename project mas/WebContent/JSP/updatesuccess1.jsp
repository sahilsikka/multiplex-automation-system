<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.tcs.ilp.Bean.MovieBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <%MovieBean mbean = (MovieBean)request.getAttribute("mbean");%> --%>
<img src="<%=request.getContextPath()%>/images/tickmark.jpeg" width="50px" height="50px;" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;<b style="font-size: 30px; color: green;">Success</b><br><br><br>
<p>Movie with the following details<br>
MovieName: <%-- <%=mbean.getMovieName()%> --%><br>
Language: <%-- <%=mbean.getLanguage()%> --%><br>
updated successfully</p>
</body>
</html>