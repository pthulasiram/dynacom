//************************* Champ remplir ******************//
function validate_field(field,alerttxt){
if(field.value == ""){
alert(alerttxt); 
   return false; 
	 }
else { return true;}
}

//****************** validation email ***********************//
function validate_email(field,alerttxt)
{
with (field)
{
apos=value.indexOf("@");
dotpos=value.lastIndexOf(".");
if (apos<1||dotpos-apos<2) 
  {alert(alerttxt); 
   return false;}
else {return true;}
}
}
//******************* validate contact *******************************//
function validate_contact(thisform)
{
with (thisform)
{ 
if (validate_field(nom,"Veuillez saisir votre nom !!!")==false)
  {nom.focus();return false;}
if (validate_field(tel,"Veuillez saisir votre telephone !!!")==false)
  {tel.focus();return false;}
if (validate_field(email,"Veuillez saisir votre email !!!")==false)
  {email.focus();return false;}
if (validate_email(email,"Veuillez verifier votre email !!!")==false)
  {email.focus();return false;}
if (validate_field(ville,"Veuillez saisir votre ville !!!")==false)
  {ville.focus();return false;}
if (validate_field(sujet,"Veuillez saisir le sujet de votre message !!!")==false)
  {sujet.focus();return false;}
if (validate_field(message,"Veuillez saisir votre message !!!")==false)
  {message.focus();return false;}
}
}
//******************* vider le text *******************************//
function vider_contact(thisform)
{
with (thisform)
{ 
  nom.value='';
  tel.value='';
  email.value=''
  sujet.value='';
  ville.value='';
  message.value='';
}
}
//******************** validate user*************************//

