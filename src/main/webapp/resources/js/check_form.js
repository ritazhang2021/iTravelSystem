var name = $('#name');
	var email = $('#email');
	var pwd1 = $('#pwd1');
	var pwd2 = $('#pwd2');
	function checkPassword(str)
  {
    var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
    return re.test(str);
  }

  function checkForm(form)
  {
    if(form.name.value == "") {
      alert("Error: Username cannot be blank!");
      form.name.focus();
      return false;
    }
    re = /^\w+$/;
    if(!re.test(form.name.value)) {
      alert("Error: Username must contain only letters, numbers and underscores!");
      form.name.focus();
      return false;
    }
    
 
   
    var x=form.email.value;  
    var atposition=x.indexOf("@");  
    var dotposition=x.lastIndexOf(".");  
    if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  

    alert("Please enter a valid e-mail address \n atpostion:"+atposition+"\n dotposition:"+dotposition);  
    form.email.focus();
    return false;  
    }  

    if(form.pwd1.value != "" && form.pwd1.value == form.pwd2.value) {
      if(!checkPassword(form.pwd1.value)) {
        alert("The password you have entered is not valid!");
        form.pwd1.focus();
        return false;
      }
    } else {
      alert("Error: Please check that you've entered and confirmed your password!");
      form.pwd1.focus();
      return false;
    }
    return true;
  }
  