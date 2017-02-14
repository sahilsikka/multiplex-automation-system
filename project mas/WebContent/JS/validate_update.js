function validate() {

var flag=false;

if(checkFirstName()& checkLastName()& checkRadio()& checkDob()& checkPhone()& checkCity()& checkLocation()&validateDob())
{		
 flag=true;
}
	
if(flag)
{
alert("you can proceed");
}
return flag;
}
function reloadval()
{
	//location.reload();
	var reqfld1 = document.getElementById("fname1");
	reqfld1.innerHTML = "";
    document.frmOne.firstname.value="";
	var reqfld1 = document.getElementById("lname1");
	reqfld1.innerHTML = "";
	document.frmOne.lastname.value="";
	var reqfld1 = document.getElementById("radio1");
	reqfld1.innerHTML = "";
	var uncheckradio=uncheckRadio();
	document.frmOne.gender.value="";
	
	var reqfld1 = document.getElementById("date1");
	reqfld1.innerHTML = "";
	document.frmOne.dob.value="";

	var reqfld1 = document.getElementById("PNo1");
	reqfld1.innerHTML = "";
	document.frmOne.phone.value="";
	var reqfld1 = document.getElementById("city1");
	reqfld1.innerHTML = "";
	document.frmOne.city.value="";
	var reqfld1 = document.getElementById("location1");
	reqfld1.innerHTML = "";
	document.frmOne.loc.value="";
	
	 
	}
function checkFirstName()
{
var firstname =document.frmOne.firstname.value;
var pattern=/^[a-zA-Z]+$/
var len=document.frmOne.firstname.value.length;
  if(firstname=="")
    {
	document.getElementById("fname1").innerHTML="Please enter firstname";
	return false;
    }
   if(len>30)
	{
		document.getElementById("fname1").innerHTML="maximum length allowed is 30 characters";
		return false;
	}
   
	if(!pattern.test( firstname))
	{document.getElementById("fname1").innerHTML="only alphabets allowed";
	return false;}
	   
	else{	   
	document.getElementById("fname1").innerHTML=" ";
	return true;
   }
}


function checkLastName()
{
var lastname =document.frmOne.lastname.value;
var pattern=/^[a-zA-Z]+$/;
var len=document.frmOne.lastname.value.length;
  if(lastname=="")
    {
	document.getElementById("lname1").innerHTML="Please enter lastname";
	return false;
    }
  if(len>20)
	{
		document.getElementById("lname1").innerHTML="maximum length allowed is 20 characters";
		return false;
	}
  if(!pattern.test( lastname))
		{document.getElementById("lname1").innerHTML="no special character allowed";
		return false;}
   else
   {
	   
	document.getElementById("lname1").innerHTML=" ";
	return true;
   }
}

function checkRadio()
{
     var gender=" ";
     var len=document.frmOne.gender.length;
     var i;
     for(i=0;i<len;i++)
     {
	if(document.frmOne.gender[i].checked)
	{
		gender=document.frmOne.gender[i].value;
		break;
	}
	}
     if(gender==" ")
	{
		document.getElementById("radio1").innerHTML="Please select option";
		return false;
	}
	else
	{
		document.getElementById("radio1").innerHTML=" ";
		return true;		
	}
}
function uncheckRadio()
{
	 var len=document.frmOne.gender.length;
  
for( var i=0; i<len; i++ ){
   if(document.frmOne.gender[i].checked){
	   document.frmOne.gender[i].checked = false;
   }
}
}
function checkDob()
{
var dob =document.frmOne.dob.value;
  if(dob=="")
    {
	document.getElementById("date1").innerHTML="Please enter dob";
	return false;
    }
   else
   {
	document.getElementById("date1").innerHTML=" ";
	return true;
   }

}
function validateDob() {
	var dob =document.frmOne.dob.value;
    var today = new Date();
   var birthDate = new Date(dob);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }    
    if(age<18)
    	{
    	alert("age is less than 18");
    	}
   
}

function checkPhone()
{
var phone =document.frmOne.phone.value;
var pattern=/^[0-9]+$/;
var len=document.frmOne.phone.value.length;
  if(phone=="")
    {
	document.getElementById("PNo1").innerHTML="Please enter phone no";
	return false;
    }
  if(!pattern.test(phone ))
	{document.getElementById("PNo1").innerHTML="please enter a valid phone no";
	return false;}
  if(len!=10)
	{
		document.getElementById("PNo1").innerHTML="Phone number should be of 10 digits";
		return false;
	}
  
   
	document.getElementById("PNo1").innerHTML=" ";
	return true;
   }

function checkCity()
{
/*var city =document.frmOne.city.value;
var pattern=/^[a-z A-Z 0-9]+$/;
var len=document.frmOne.city.value.length;
  if(city=="")
    {
	document.getElementById("city1").innerHTML="Please enter cityname";
	return false;
    }
   else
   {
	   if(!pattern.test( city))
		{document.getElementById("city1").innerHTML="please enter a valid name";
		return false;}
	document.getElementById("city1").innerHTML=" ";
	return true;
   }*/
	 var chosen=" ";
	    var len=document.frmOne.city.length;
	    var i;
	    for(i=0;i<len;i++)
	    {
		if(document.frmOne.city[i].selected)
		{
			chosen=document.frmOne.city[i].value;
		}
	   }
	   if(chosen=="select")
	   {
		document.getElementById("city1").innerHTML="Please select an option";
		return false;
	   }
	  else
	  {
		document.getElementById("city1").innerHTML=" ";
		return true;
	  }
}


function checkLocation()
{
var loc =document.frmOne.loc.value;
var pattern=/^[a-z A-Z 0-9]+$/;
var len=document.frmOne.loc.value.length;
  if(loc=="")
    {
	document.getElementById("location1").innerHTML="Please enter location";
	return false;
    }
   else
   {
	   if(!pattern.test(loc))
		{document.getElementById("location1").innerHTML="please enter a valid name";
		return false;}
	document.getElementById("location1").innerHTML=" ";
	return true;
   }
}



