<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.tcs.ilp.Bean.CustomerBean" %>
    <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
  ArrayList<CustomerBean> cList =new ArrayList<CustomerBean>();
  for (CustomerBean cb:cList) {
	  CustomerBean project = new CustomerBean();
    project.getCity();
  
    cList.add(project);
  }
  request.getAttribute("list");
%>
<body>
 <%@ include file="loginheader.jsp" %>
 
 <div class="wrapper col3">
 
  <div id="intro">
	<display:table name="list" sort="list" pagesize="20" id="table1"
		export="true">
		<display:column property="city" title="CITY" group="1" sortable="true"
			headerClass="sortable" />
		
		<display:setProperty name="export.excel.filename"
			value="ActorDetails.xls" />
		<display:setProperty name="export.pdf.filename"
			value="ActorDetails.pdf" />
		<display:setProperty name="export.csv.filename"
			value="ActorDetails.csv" />
		<display:setProperty name="export.pdf" value="true" />
	</display:table>
	
	 <br class="clear">
  </div>
  
</div>
<%@ include file="footer.jsp" %>
</body>
</html>