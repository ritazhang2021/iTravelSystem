
$(document).ready(function () {
    $('#btnRegister').click(onClick);
});
function onClick() {
    // Prepare parameters
    let $cmdType = "register";
    let $gender = $("#gender").val();
    let $state = $("#state").val();
    let $city = $("#city").val();
    let $street = $("#street").val();
    let $zip = $("#zip").val();
    let $fname = $("#fname").val();
    let $email = $("#email").val();
    let $pwd = $("#pwd").val();
    let $day = $("#day").val();
    let $month = $("#month").val();
    let $year = $("#year").val();
    if(checkForm()) {
        //alert("pass validate")
        $.post("RegisterServlet",
            {
                cmdType: $cmdType, gender: $gender, state: $state, city: $city, street: $street,
                zip: $zip, fname: $fname, email: $email, pwd: $pwd, year: $year
            })
            .done(checkPass)
            .fail(checkFail);
    }else {
        alert("Register failed");
    }
}
function checkPass(response) {
    console.log(response);
    if(response.status == 'false'){
        alert(response.message);
    } else {
        // alert("Register sucessfull");
        location.href = "userTravelInfo.jsp";
    }
}
function checkFail(response){
    var json = JSON.parse(response.responseText);
    console.log(json);
    alert(json.message);
}

function updateStep(step){
    if(step == 'step3'){
        var ha = validateStep2();
        if(ha == false){
            return false;
        }
    }else if(step == 'submit'){
        var va = checkForm();
        console.log(va)
        if(va==false){

            return false;
        }
    }

    $('.step_panel').hide();

    $('.'+step).show();


}

function validateStep2(){
    var state = $('#state');
    var city = $('#city');
    var zipCode = $('#zip');
    var street = $('#street');

    if(state.val()==''||city.val()==''||zipCode.val()==''||street.val() == ''){
        alert('Please input all your information');
        return false;
    }
    return true;
}


function checkPassword(str) {
    var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
    return re.test(str);
}


function checkForm() {
    const name = $('#fname');
    const email = $('#email');
    const email1 = $('#email1');
    let pwd = $('#pwd');
    const x=email.val();
    const y=email1.val();
    const atposition=x.indexOf("@");
    const dotposition=x.lastIndexOf(".");

    if(name.val() == "") {
        alert("Error: Username cannot be blank!");
        name.focus();
        return false;
    }

    if (x!=y||x==""||y==""||atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){

        alert("Please enter a valid e-mail address \n atpostion:"+atposition+"\n dotposition:"+dotposition);
        email.focus();
        return false;
    }
    if(pwd.val() != "") {
        if(!checkPassword(pwd.val())) {
            alert("The password you have entered is not valid! password must include 6 characters, at least 1 number, 1 uper/lower character");
            pwd.focus();
            return false;
        }
    } else {
        alert("Error: Please check that you've entered your password!");
        pwd.focus();
        return false;
    }
    return true;
}
function chooseFile() {
    $("#fileInput").click();
}

	
	

	
