<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.tcs.ilp.Bean.ShowBean" import="com.tcs.ilp.Bean.MovieBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%-- <%MovieBean mbean =(MovieBean)request.getAttribute("mbean");%>
<%ShowBean sbean =(ShowBean)request.getAttribute("sbean");%> --%>
<body>
<center><table>
<tr>
<td><img src="<%=request.getContextPath()%>/images/tickmark.jpeg" width="100px" height="100px;" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;<b style="font-size: 30px;"></td>
<td><h2 style="font-size: 40px;">Success</h2></td>
</tr>
</table></center>
<center style="color:green; font-size: 30px;" ><p>Show details added successfully</p></center>
<center><table border="1px solid;" cellpadding="10px;" cellspacing="0px;">
<th><p>Movie Name</p></th><th><p>screen Id</p></th><th><p>start date</p></th><th><p>show slot</p></th>
<tr>
<td><%-- <%=mbean.getMovieName()%> --%></td><td><%-- <%=sbean.getScreenId()%> --%></td><td>
<%-- <%=mbean.getStartDate()%> --%></p></td><td><%-- <%=sbean.getShowSlot()%> --%></td> 
</tr>
</table></center>
</body>
</html>