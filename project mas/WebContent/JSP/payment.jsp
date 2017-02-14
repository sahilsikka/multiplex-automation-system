<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/JS/MyScript.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/payment.css" type="text/css" />
</head>
<body onload="selectDivison()">
<div id="credit-card">
		<header>
            <h4 style="color: #336666; text-align: center;"> Payment: Enter payment details</h4>
		</header>
		<section id="content">
        <div class="title"><strong>Payment Mode- Select your payment mode</strong></div>
                
   <input type="radio" id="radio1" name="radios" value="radio1" checked="true" onchange="selectDivison()">
   <label for="radio1">Credit Card</label>
         
<input type="radio" id="radio2" name="radios"value="radio2" onchange="selectDivison()">
   <label for="radio2"">Debit Card</label>
    
    <input type="radio" id="radio3" name="radios"value="radio3" onchange="selectDivison()">
   <label for="radio3">Internet Banking</label>

<%-- //------------------------------------------------------------------------------------------------------------------------------------------------------------------%>            
	
	
	<form id="cardpayment" name="cardpayment" method="get" action="<%=request.getContextPath()%>/TicketController" onsubmit="ConfirmBookTicket('ConfirmTicket')">   
	<input type="hidden" name="action" value="">
	<input type="hidden" name="source" value="paid">   
	<input type="hidden" name="source1" value=<%=request.getParameter("source1")%>>
<input type="hidden" name="source2" value=<%=request.getParameter("source2")%>>
<input type="hidden" name="source3" value=<%=request.getParameter("source3")%>>
<input type="hidden" name="source4" value=<%=request.getParameter("source4")%>>
<input type="hidden" name="source5" value=<%=request.getParameter("source5")%>>
<input type="hidden" name="source6" value=<%=request.getParameter("source6")%>>
<input type="hidden" name="source7" value=<%=request.getParameter("source7")%>>
<input type="hidden" name="source8" value=<%=request.getParameter("source8")%>>                     
    <div class="table form-fields">                   
 	<div class="row">
     	<div class="label">Card Number:</div>
						<div class="input full"><input type="text" name="ccnumber" id="ccnumber" onblur="validateCardNumber()"/>
						<span id="c_error" style="color: red" ></span>
						<br/></div>                   
</div>
			<div class="row">
				<div class="label">Card Type:</div>
				<div class="input full">
					<select class="styled" onblur="validateCardType()" name="cardtype">
						<option value="select">Select</option>
						<option>Visa</option>
						<option>Mastercard</option>
						<option>Maestro</option>
						<option>SBI Maestro</option>
					</select>
				</div>
				<span id="ct_error" style="color: red"></span>
				<div class="valid"></div>
			</div>
			<div class="row">
			<%String custname = (String)request.getParameter("source2");%>
                        <div class="label">Your name:</div>
						<div class="input full">
						<input type="text" name="name" id="name" placeholder="Enter Your Name" onblur="validateName()"
							value=<%if(custname!=null){out.println(custname);} else{out.println("error");} %>/>
						</div>
						<span id="n_error" style="color: red" ></span>						
					</div>
					<div class="row name">
						<div class="label">Expires On:</div>
						<div class="input size50">
<select class="styled" name="selectMonth" onblur="validateMonth()">
<option value="select">Select Month</option>
<option value="01">January</option>
<option value="02">February</option>
<option value="03">March</option>
<option value="04">April</option>
<option value="05">May</option>
<option value="06">June</option>
<option value="07">July</option>
<option value="08">August</option>
<option value="09">September</option>
<option value="10">October</option>
<option value="11">November</option>
<option value="12">December</option>
</select>
<span id="mv_error" style="color: red" ></span>							
<select class="styled" name="selectYear" onblur="validateYear()">
<option value="select">Select Year</option>
<option value="2012">2012</option>
<option value="2013">2013</option>
<option value="2014">2014</option>
<option value="2015">2015</option>
<option value="2016">2016</option>
<option value="2017">2017</option>
<option value="2018">2018</option>
<option value="2019">2019</option>
<option value="2020">2020</option>
<option value="2021">2021</option>
<option value="2022">2022</option>
<option value="2023">2023</option>
<option value="2024">2024</option>
<option value="2025">2025</option>
<option value="2026">2026</option>							
<option value="2027">2027</option>
<option value="2028">2028</option>
<option value="2029">2029</option>
<option value="2030">2030</option>
<option value="2031">2031</option>
<option value="2032">2032</option>
<option value="2033">2033</option>
<option value="2034">2034</option>
<option value="2035">2035</option>
<option value="2036">2036</option>
</select>	
<span id="yv_error" style="color: red" ></span>
</div>
						<div class="valid"></div>
					</div>
					<div class="row name">
						<div class="label">CVV Number:</div>
						<div class="input size50"><input type="password" name="cvv" id="cvv" placeholder="000" maxlength="3" onblur="validateCCV()"/></div>
						<span id="cc_error" style="color: red" ></span>
					</div>
				</div>
				<input type="button" style="float:right" name="proceed" value="Confirm Payment" onclick="ConfirmBookTicketonCard('ConfirmTicket')"/>
</form>
<div> 
<%-- //------------------------------------------------------------------------------------------------------------------------------------------------------------------%>   
    <form id="internetpayment" action="<%=request.getContextPath()%>/TicketController" method="get" name="internetpayment" onsubmit="ConfirmBookTicket('ConfirmTicket')">  
    <input type="hidden" name="action" value="">
    <input type="hidden" name="source" value="paid"> 

<input type="hidden" name="source1" value=<%=request.getParameter("source1")%>>
<input type="hidden" name="source2" value=<%=request.getParameter("source2")%>>
<input type="hidden" name="source3" value=<%=request.getParameter("source3")%>>
<input type="hidden" name="source4" value=<%=request.getParameter("source4")%>>
<input type="hidden" name="source5" value=<%=request.getParameter("source5")%>>
<input type="hidden" name="source6" value=<%=request.getParameter("source6")%>>
<input type="hidden" name="source7" value=<%=request.getParameter("source7")%>>
<input type="hidden" name="source8" value=<%=request.getParameter("source8")%>>
    
    
                      
    <div class="table form-fields">           
    <div class="row name">
	<div class="label">Name:</div>
	<div class="input full">
	<input type="text" name="nameint" id="nameint" placeholder="Enter your name" onblur="validateNameinternet()"/>
	</div>
	<span id="nip_error" style="color: red" ></span>				
	</div>
        
        <div class="row name">
			<div class="label">Email:</div>
			<div class="input full"><input type="text" name="emailint" id="emailint" placeholder="Enter Email address" onblur="validateEmailAddress()"
				value=<% String email=(String)session.getAttribute("emailid"); if(email!=null){out.println(email);} else{out.println(" ");}%>/>
			<span id="eidint_error" style="color: red" ></span>
			</div>
		</div>

	<div class="row name">
        <div class="label">Mobile Number:</div>
             <div class="input size50"><input type="text" name="mobileno" id="mobileNo" onblur="validateMobileNumberInt()" maxlength="10"/>
             <span id="mnoint_error" style="color: red" ></span>
       		 </div>
	</div>
	<div class="row name">
	<div class="label">Bank:</div>
	<div class="input size50">                           
 	<select name="BankId" class="styled" onblur="validateBank()">
		<option value="select">Select Bank</option>
		<option value="HDFC"> HDFC </option>
		<option value="ICICI"> ICICI </option>
		<option value="IDBI"> IDBI </option>
		<option value="SBI"> STATE BANK OF INDIA </option>
	</select> 
	<span id="bint_error" style="color: red" ></span>                              
	</div>
		<div class="valid"></div>
	</div>
		<div class="row name">
			<div class="label">Amount:</div>
				<div class="input size50"><input type="text" name="amount" id="amount" disabled="disabled"
				value=<% Integer price = Integer.parseInt(request.getParameter("source8")); if(price!=null){out.println(price);} else{out.println(0.00);} %>/>
				</div>
			</div>
		</div>
		<%--		<a href="<%=request.getContextPath()%>/ViewController?action=ConfirmTicket">  --%>
				<input type="submit" style="float:right" name="proceed" value="Pay Now" onclick="ConfirmBookTicket('ConfirmTicket')"/>
				
				
	<%--			</a>   --%>
			</form>
</div>   
		</section>                  
	</div>
  </div>
</div>
</body>
</html>