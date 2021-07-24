window.onload = function(){
    getCurrentUser();
    $('#myfile').click(uploadPhoto);

    showHideForm();
    $('#imageUpload').change(function (){
        uploadImage();
    });
    // setTimeout(function (){
    //     getPostList();
    // },1000)



    $('#editinfo').click(editUserInfo);
}
function showHideForm(){
    //show and hide edit form
    $('#show').on('click', function () {
        $('.center').show();
        $(this).hide();
    })

    $('#close').on('click', function () {
        $('.center').hide();
        $('#show').show();
    })
}
function getCurrentUser() {
    console.log('call getCurrentUser');
    $.post("GetCurrentUserInfoServlet", {"cmdType" : "load"})
        .done(function (user){
            console.log(user);
            displayUserInfo(user);
            updateUserInfoInEditForm(user);
            UpdateUserInfoInHomePage(user);

        })
        .fail(function(error){
            console.error(error);
        });

}

function displayUserInfo(user){
    $('#name').html(user.fullName);
    $('#id').html(user.id);
    $('#gender').html(user.gender);
    $('#year').html(user.birthYear);
    $('#email').html(user.email);
    $('#pwd').val(user.password);
    $('#address').html(user.street +", " + user.city+ ","+user.state + ", "+ user.zipCode);
}
//post edit user info
function editUserInfo(){
    let $cmdType = "edit";
    let $id = $("#id").text();
    let $gender = $("#egender").val();
    let $state = $("#estate").val();
    let $city = $("#ecity").val();
    let $street = $("#estreet").val();
    let $zip = $("#ezip").val();
    let $fname = $("#ename").val();
    let $email = $("#eemail").val();
    let $pwd = $("#epassword").val();
    // let $day = $("#day").val();
    // let $month = $("#month").val();
    let $year = $("#ebirthyear").val();
    console.log($year);
    if(verifyEditInfo()) {
        console.log(verifyEditInfo());
        $('.center').hide();
        $('#show').show();
        //let $cmdType = "edit";
        console.log("run from here to test");
        $.post("UserInfoServlet",
            {
                cmdType : $cmdType, id: $id, gender: $gender, state: $state, city: $city, street: $street,
                zip: $zip, fname: $fname, email: $email, pwd: $pwd, year: $year
            })
            .done(function (user){
                console.log(user);
                if (user.status === 'false') {
                    alert(user.message);
                }else {
                    //alert(user.password);

                    displayUserInfo(user);

                    updateUserInfoInEditForm(user);
                }

            })

            .fail(function (error) {
                alert(error);
            });
    }
    else {
        console.log("failed to send data to servlet")
    }


}
function verifyEditInfo() {
    let estate = $('#estate').val();
    let ecity = $('#ecity').val();
    let ezipCode = $('#ezip').val();
    let estreet = $('#estreet').val();
    let ename = $('#ename').val();
    let egender = $('#egender').val();
    let ebirthYear = $('#ebirthyear').val();
    let eemail = $('#eemail').val();
    let epassword = $('#epassword').val();

    let state = $('#state').text();
    let city = $('#city').text();
    let zipCode = $('#zip').text();
    let street = $('#street').text();
    let name = $('#name').text();
    let gender = $('#gender').text();
    let birthYear = $('#year').text();
    let email = $('#email').text();
    let password = $('#pwd').text();
    console.log(password + "test paw value");
    //console.log(ename.val() +"test value");
    if(ename==""||egender==""||ebirthYear===""||eemail===""||eemail===""||epassword===""
        ||estreet===""||estate===""||ecity===""||ezipCode===""){
        alert("All field must be filed")
        return false;
    }

    if(name===ename && gender === egender && birthYear=== ebirthYear && email===eemail && password===epassword
        && street===estreet && state === estate && city === ecity && zipCode===ezipCode){
        $('.center').hide();
        $('#show').show();
        return false;
    }
    function checkPassword(str) {
        var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
        return re.test(str);
    }
    if(epassword !=password){
        if(!checkPassword(epassword)){
            alert("The password you have entered is not valid! password must include 6 characters, at least 1 number, 1 uper/lower character");
            return false;
        }
    }
    if(email!=eemail){
        const x=eemail;
        const atposition=x.indexOf("@");
        const dotposition=x.lastIndexOf(".");
        if (x==""||atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length) {
            alert("Please enter a valid e-mail address \n atpostion:" + atposition + "\n dotposition:" + dotposition);
            eemail.focus();
            return false;
        }
    }
    return true;

}
//upload avatar photo
function chooseFile() {
    $("#photo").click(function () {
        $("#myfile").click();
    });
}
function uploadPhoto() {
    $("#upload").click(function () {
        $("#myfile").show();
        uploadImage();
    });
}
//load data info for edit form after user click edit button
function updateUserInfoInEditForm(user) {
    $('#ename').val(user.fullName);
    //$('#eid').val(user.id);
    $('#egender').val(user.gender);
    $('#ebirthyear').val(user.birthYear);
    $('#eemail').val(user.email);
    $('#epassword').val(user.password);
    $('#estreet').val(user.street);
    $('#ecity').val(user.city);
    $('#estate').val(user.state);
    $('#ezip').val(user.zipCode);
}
//send avatar photo to servlet to update database
function upAvatar(){
    let $cmdType = "avatar";
    $.post("UserInfoServlet",
        {
            cmdType : $cmdType, id: $id, gender: $gender, state: $state, city: $city, street: $street,
            zip: $zip, fname: $fname, email: $email, pwd: $pwd, year: $year
        })
        .done(function (user){
            console.log(user);
            if (user.status === 'false') {
                alert(user.message);
            }else {
                displayUserInfo(user);
                updateUserInfoInEditForm(user);
            }

        })

        .fail(function (error) {
            alert(error);
        });
}
//update data for Hompage
function UpdateUserInfoInHomePage(user) {
    $('#userId').html(user.id);
    $('#name').html(user.fullName);
    //$('#eid').val(user.id);
    $('#address').html(user.city + ", "+ user.state);
    $('#byear').html(user.birthYear);

}
function uploadImage(){
    $('#formAdd').submit(function(event) {
        console.log("form submit 1");
        event.preventDefault();
        console.log("form submit 2");

        $.ajax({
            url : $(this).attr('action'),
            type : $(this).attr('method'),
            data : new FormData(this),
            contentType : false,
            cache : false,
            processData : false,
            success : function(response) {
                console.log(response);
                $('#imagePreview').removeClass('hide');
                $('#imageUpload').attr('src', response);
                // $('.center').hide();
                // $('#show').show();
                console.log("i'm here to test");
            },
            beforeSend : function() {
                console.log("before send");
            }
        });

        return false;
    });

}
