function selectDivison(){
	var radios = document.getElementsByName("radios");
	var cardpayment =  document.getElementById("cardpayment");
	var internetpayment =  document.getElementById("internetpayment");
	cardpayment.style.display = 'block';   // show
	internetpayment.style.display = 'none';// hide
	for(var i = 0; i < radios.length; i++) {
	    radios[i].onclick = function() {
	        var val = this.value;
	        if(val == 'radio1' || val == 'radio2'){
	            cardpayment.style.display = 'block';
	            internetpayment.style.display = 'none';
	        }
	        else if(val == 'radio3'){
	             cardpayment.style.display = 'none';
	             internetpayment.style.display = 'block';
	        }    	            
	    }
	}
}
//---------------------------------------------------------------payment validation

function validateName(){
	var x=document.cardpayment.name.value;
	flag=true;
	if(x==""){
		flag=false;
		document.getElementById("n_error").innerHTML="Please enter First Name";
	}
	else{
		document.getElementById("n_error").innerHTML="";
	}
	return flag;
}

function validateCardNumber()
{
	var x= document.cardpayment.ccnumber.value;
	var v= /^\d{16}$/; 
	flag=true;
	if(x=="")
	{
		flag=false;

        document.getElementById("c_error").innerHTML="Please enter Card Number";
	}
	else if(!v.test(x))	
	{
	flag=false;
	document.getElementById("c_error").innerHTML="Card number should have numeric value of 16 character";	
	}
	else 
	{
		document.getElementById("c_error").innerHTML="";
	}
	return flag;	
}

function validateCardType(){
	var v= document.cardpayment.cardtype.value;
	var flag= true;
	if(v=="select")
	{
		flag= false;
		document.getElementById("ct_error").innerHTML="Please select card type";
	}
	else
	{
		flag= true;
		document.getElementById("ct_error").innerHTML="";
	}
	return flag;
}

function validateMonth(){
	var v= document.cardpayment.selectMonth.value;
	var flag= true;
	if(v=="select")
	{
		flag= false;
		document.getElementById("mv_error").innerHTML="Please select Month";
	}
	else
	{
		flag= true;
		document.getElementById("mv_error").innerHTML="";
	}
	return flag;
}

function validateYear(){
	var v= document.cardpayment.selectYear.value;
	var flag= true;
	if(v=="select")
	{
		flag= false;
		document.getElementById("yv_error").innerHTML="Please select Year";
	}
	else
	{
		flag= true;
		document.getElementById("yv_error").innerHTML="";
	}
	return flag;
}

function validateCCV()
{
	var x= document.cardpayment.cvv.value;
	var v= /^\d{3}$/; 
	flag=true;
	if(x=="")
	{
		flag=false;

        document.getElementById("cc_error").innerHTML="Please enter ccv number";
	}
	else if(!v.test(x))	
	{
	flag=false;
	document.getElementById("cc_error").innerHTML="Ccv number should have numeric value of 3 character";	
	}
	else 
	{
		document.getElementById("cc_error").innerHTML="";
	}
	return flag;	
}

function ConfirmBookTicket(a){
	if(!validateNameinternet() && !validateEmailAddress() && !validateMobileNumberInt() && !validateBank()){
		return false;
	}
	if(!validateNameinternet()){
		return false;
	}
	if(!validateMobileNumberInt()){
		return false;
	}
	if(!validateBank()){
		return false;
	}
	else{
		document.internetpayment.action.value=a;
		document.internetpayment.submit();
	}
}

function ConfirmBookTicketonCard(a){
	if(!validateCardNumber() && !validateCardType() && !validateName() && !validateMonth() && !validateYear() && !validateCCV()){
		return false;
	}
	if(!validateCardNumber()){
		return false;
	}
	if(!validateCardType()){
		return false;
	}
	if(!validateName()){
		return false;
	}
	if(!validateMonth()){
		return false;
	}
	if(!validateYear()){
		return false;
	}
	if(!validateCCV()){
		return false;
	}
	else{
		document.cardpayment.action.value=a;
		document.cardpayment.submit();
	}
}

function validateNameinternet(){
	var x=document.internetpayment.nameint.value;
	flag=true;
	if(x==""){
		flag=false;
		document.getElementById("nip_error").innerHTML="Please enter First Name";
	}
	else{
		document.getElementById("nip_error").innerHTML="";
	}
	return flag;
}

function validateEmailAddress() {
	  var x = document.internetpayment.emailint.value;
	  var y = x.indexOf("@");
	  var z = x.lastIndexOf(".");
	  var flag=true;
		if(x=="")
		{
			flag=false;
			document.getElementById("eidint_error").innerHTML="Please enter valid Id";
		}
		else if (y< 1 || z<y+2 || z+2>=x.length) {
	      document.getElementById("eidint_error").innerHTML="Please enter valid Id";
	      flag=false;
	  }else{
	  	document.getElementById("eidint_error").innerHTML="";
	flag=true;
	  }
	 return flag; 
}

function validateMobileNumberInt()
{
  var x = document.internetpayment.mobileno.value;
	var v= /^\d{10}$/; 

	flag=true;
	if(x=="")
	{
		flag=false;

      document.getElementById("mnoint_error").innerHTML="Please enter Mobile Number";
	}
	else if(!v.test(x))	
	{
	flag=false;
	document.getElementById("mnoint_error").innerHTML="Mobile number should have numeric value of 10 character";	
	}
	else 
	{
		document.getElementById("mnoint_error").innerHTML="";
	}
	return flag;
	
}

function validateBank(){
	var v= document.internetpayment.BankId.value;
	var flag= true;
	if(v=="select")
	{
		flag= false;
		document.getElementById("bint_error").innerHTML="Please select Bank";
	}
	else
	{
		flag= true;
		document.getElementById("bint_error").innerHTML="";
	}
	return flag;
}