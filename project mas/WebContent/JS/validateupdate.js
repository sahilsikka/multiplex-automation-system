function validateupdate()
{
	var flag = false;
	var var1 = checkstartdate();
	alert(var1);
	var var2 = checkenddate();
	alert(var2);
	var var3 = validatedate();
	var var4 = checkcategory();
	alert(var4);
	
	if(var1&&var2&&var3&&var4)
		{
		 flag = true;		
		}
	if(flag)
		{
		alert("you can proceed");
		}
	else
		{
		alert("you cannot proceed");
		}
	return flag;
}


function checkstartdate()
{
var startdate1 = document.formOne.sd.value;
if(startdate1=="")
	{
	document.getElementById("startdate").innerHTML="please select start date";
	return false;
	}

else
	{
	document.getElementById("startdate").innerHTML="";
	return true;

	}
}

function checkenddate()
{
var enddate1 = document.formOne.ed.value;
if(enddate1=="")
	{
	document.getElementById("enddate").innerHTML="please select end date";
	return false;
	}

else
	{
	document.getElementById("enddate").innerHTML="";
	return true;

	}
}


function validatedate()
{
var sd1 = document.formOne.sd.value;
var ed1 = document.formOne.ed.value;

var startdate1 = new Date(sd1);
var enddate1 = new Date(ed1);

var y = enddate1.getFullYear() - startdate1.getFullYear();
var m = enddate1.getMonth()  - startdate1.getMonth();

if(m<0 || (m== 0) && startdate1.getDate() > enddate1.getDate())
	{
		y--;
	
	}
if(y<0)
	{
	alert('please enter valid date');
	}
}

function checkcategory()
{
var chosen ="";
var len = document.formOne.category.length;
var i;
 for(i=0;i<len;i++)
	 {
	 if(document.formOne.category[i].selected)
		 {
		 chosen = document.formOne.category[i].value;
		 
		 }
	 }
 
 if(chosen=="select")
	 {
	 document.getElementById("category1").innerHTML="please enter an option";
	 return false;
	 }
 else
	 {
	 document.getElementById("category1").innerHTML="";
	 return true;
	 }
}