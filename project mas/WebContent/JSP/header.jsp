<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css" type="text/css" >
<script type="text/javascript" src="JS/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="JS/jquery-func.js"></script>

<title>Insert title here</title>
</head>
<body>
<div id="shell">
  <div id="header">
    <h1 id="logo"><a href="#">MovieHunter</a></h1>
    <div class="social"> <span>FOLLOW US ON:</span>
      <ul>
        <li><a class="twitter" href="#">twitter</a></li>
        <li><a class="facebook" href="#">facebook</a></li>
        <li><a class="vimeo" href="#">vimeo</a></li>
        <li><a class="rss" href="#">rss</a></li>
      </ul>
    </div>
    <div id="navigation">
      <ul>
      <form method="post" action="<%=request.getContextPath()%>/LoginController?source=loginac">
       <table>
       
       <th>Email</th><th>Password</th>
       <tr>
        <td><li><input type="text" name="id" class="form-control" name="Email" placeholder="Email"></input></li></td>
        <td><li> <input type="password" name="password" name="id" class="form-control" placeholder="password"></input></li></td>
        <td><li><input type="submit" name="Sign In" value="Log In" class="btn btn-primary" ></input></li></td>
        <tr>
        </table>
        </form>
        <p style="float: right">New User? &nbsp;<a href="#">REGISTER</a></p>
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
        <li><a href="#">HOME</a></li>
        <li><a href="#">NOW SHOWING</a></li>
        <li><a href="#">UP COMING</a></li>
        <li><a href="#">BOOK TICKET</a></li>
      </ul>
      <div id="search">
        <form action="#" method="get" accept-charset="utf-8">
          <label for="search-field">SEARCH</label>
          <input type="text" name="search field" value="Enter search here" id="search-field" class="blink search-field"  />
          <input type="submit" value="GO!" class="search-button" />
        </form>
      </div>
    </div>
  </div>
</body>
</html>