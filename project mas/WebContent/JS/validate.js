function validate() {

var flag=false;

if(checkFirstName()& checkLastName()& checkRadio()& checkDob()& checkEmailId()& checkPhone()& checkCity()& checkPassword()& checkLocation())
{		
 flag=true;
}
	
if(flag)
{

}
return flag;
}
function reloadval()
{
	location.reload();
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
function checkEmailId()
{
var emailid =document.frmOne.eid.value;
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  if(emailid=="")
    {
	document.getElementById("eID1").innerHTML="Please enter emailid";
	return false;
    }
   else
   {
	   if(!mailformat .test(emailid ))
		{document.getElementById("eID1").innerHTML="please enter a valid emailid";
		return false;}
	document.getElementById("eID1").innerHTML=" ";
	return true;
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
var city =document.frmOne.city.value;
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
function checkPassword()
{
var password =document.frmOne.password.value;
var len=document.frmOne.password.value.length;
  if(password=="")
    {
	document.getElementById("password1").innerHTML="Please enter password";
	return false;
    }
  if(len<8)
	  {
	  document.getElementById("password1").innerHTML="password length must be greater than 8 characters";
		return false;
	  }
   else
   {
	document.getElementById("password1").innerHTML=" ";
	return true;
   }
}


