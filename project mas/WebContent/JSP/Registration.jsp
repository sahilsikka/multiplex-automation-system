<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<%=request.getContextPath()%>/JS/validate.js"></script>
<title>Insert title here</title>
</head>
<body>
<%@ include file="loginheader.jsp" %>
 <div id="main">
           <div id="coming" style="margin-left: 185px;background-color: #F2F2F2;width: 982px;background-color: #F2F2F2;">
       
       <% String msg=(String)request.getAttribute("regfail");
    if(msg==null)msg="";%> 
<form action="<%=request.getContextPath()%>/CustomerContrller" name="frmOne" method="post" onsubmit="return validate()"> 

<input type="hidden" name="source" value="registercustomer">

  <span style="color: red"><%=msg %></span>
 <div class="form-group">
      <center style="font-size: 20px">User Registration</center>
       <span style="color: red">*All fields are mandatory</span> <br>
<div class="form-group"><label> First Name:</label>
<input id="fname" type="text" name="firstname" placeholder="firstname" onblur="checkFirstName()"class="form-control"><span style="color: red" id="fname1"></span>
</div>

<div class="form-group"><label>Last Name:</label><input id="lname" type="text" name="lastname" placeholder="lastname"onblur="checkLastName()"class="form-control"><span style="color: red" id="lname1"></span></div>

<div class="form-group"><label> Gender</label>
Male<input type="radio" value="Male" name="gender" id="radio"  onblur=" checkRadio()">
 Female<input type="radio" value="Female" name="gender"><span style="color: red" id="radio1"></span></div>

<div class="form-group"><label>Date Of Birth:</label>
<input id="date" type="date" name="dob"  placeholder="DOB" onblur="checkDob()"class="form-control"><span style="color: red" id="date1"></span></div>

<div class="form-group"><label>Email Id: </label>
<input id="eID" type="text" name="eid" placeholder="emailid" onblur="checkEmailId()"class="form-control" ><span style="color: red" id="eID1"></span></div>

<div class="form-group"><label>Phone Number:</label>
<input id="PNo" type="text" name="phone" placeholder="Phone Number" onblur="checkPhone()"class="form-control" ><span style="color: red" id="PNo1"></span></div>

<div class="form-group"><label>City: </label>
<!-- <input id="city" type="text" name="city" placeholder="City" onblur="checkCity()" class="form-control"> -->

<select  name="city" onmouseover="checkCity()" onchange="setoptions(document.frmOne.city.options[document.frmOne.city.selectedIndex].value);">
  <option value="select" selected="selected">select</option>
  <option value="Delhi">Delhi</option>
  <option value="Pune">Pune</option>
  <option value="Trivandrum">Trivandrum</option>
</select>
<span style="color: red" id="city1"></span></div>

<div class="form-group"><label>Location:</label>
<!-- <input id="location" type="text" name="loc" placeholder="Location" onblur="checkLocation()"class="form-control"> -->

<select name="loc" onmouseover="checkLocation()" onchange="alert(document.frmOne.loc.options[document.frmOne.loc.selectedIndex].value);" size="1">
</select>
<span style="color: red" id="location1"></span></div>


<div class="form-group"><label>Password: (minimum 8 characters) </label>
<input id="password" type="password" name="password" placeholder="password" onblur="checkPassword()"class="form-control"><span style="color: red" id="password1"></span></div>

</div>
<center><input type="submit" value="Register" class="btn btn-primary" class="form-control">
<input value="Reset" type="button" class="btn btn-primary" onclick="reloadval()"></center>

  

</form>
       
        </div>
    <div class="cl">&nbsp;</div>
  </div>

<%@ include file="footer.jsp" %>
</body>
</html>