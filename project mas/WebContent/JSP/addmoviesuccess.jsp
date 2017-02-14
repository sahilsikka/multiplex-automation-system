<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.tcs.ilp.Bean.MovieBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- << %MovieBean mbean = (MovieBean)request.getAttribute("mbean");%>> -->
<center><table>
<tr>
<td><img src="<%=request.getContextPath()%>/images/tickmark.jpeg" width="100px" height="100px;">&nbsp;&nbsp;&nbsp;&nbsp;<b style="font-size: 30px;"></td>
<td><h2 style="font-size: 40px;">Success</h2></tr>
</table></center>
<center><p style="color: green;">Movie details successfully added into the Database</p></center>
<center><table border="1px solid" cellspacing="0px;" cellpadding="10px;">
<th><p>MovieName</p></th><th><p>Language</p></th><th><p>StartDate</p></th><th><p>EndDate</p></th><th><p>Category</p></th><th><p>TheaterId</p></th>
<tr>
<td><%-- <%=mbean.getMovieName()%> --%></td><td><%-- <%=mbean.getLanguage()%> --%></td><td><%-- <%=mbean.getStartDate()%> --%></td><td><%-- <%=mbean.getEndDate()%> --%></td><td><%-- <%=mbean.getCategory()%> --%></td><td><%-- <%=mbean.getTheaterId()%> --%></td>
</tr>
</table></center>


</body>	
</html>