$(document).ready(function () {//可以把$(document).ready写成$
    console.log("Document is ready!!!");
    onLoadInitData();

    $('#showDeactiveUser').click(onDisplyShowDeactiveUserOnPage);
    $('#prePage').click(onPreviousPage);
    $('#nextPage').click(onNextPage);
    // Search local
    $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
    $('#btnSetActive').click(onUpdStatus_1);
});

$(document).on("click",".deactiveUser",function(){
    onUpdStatus();
});

function onLoadInitData() {
    // Prepare parameters
    let $cmdType = "init";
    $.post("AdminServlet",
        {cmdType: $cmdType},//没有action的名字，就直接到post方法，通过验证，再选择执行哪个
        //onDisplyShowDeactiveUser

        onDisplyShowDeactiveUserOnPage
    );
    alert("init");
}

function onDisplyShowDeactiveUserOnPage() {
     alert("onDisplyShowDeactiveUserOnPage");
    let $cmdType = "ShowOnPage";
    // post and receive data
    $.post("AdminServlet",
        {cmdType: $cmdType, },//json数据格式

        displayDeactiveUserOnPage);
    alert("onDisplyShowDeactiveUserOnPage2");
}

function displayDeactiveUserOnPage(data){
    alert("displayDeactiveUserOnPage");
    //Remove old Data
    let $table = $('#users');
    $table.find($('.user')).remove();//remove all .user from users table
    //Update new data
    $.each(data, function(i, user){

        let $aStatus = '<button class="deactiveUser" value=' + user.id + '>ChangeActiveStatus</button>'
        let $user = "<tr class=\"user\">" +
            "<td>"+ user.id + "</td>" +
            "<td>"+ user.fullName + "</td>" +
            "<td>" + user.email + "</td>" +
            "<td>" + user.userType + "</td>" +
            "<td>" + user.activType+ "</td>" +
            "<td>" + $aStatus + "</td>" +
            "</tr>";
        $("#users").append($user);

    });
}



function onUpdStatus(){//因为是动态的，要用anonymous function或 $(document).on
    // Prepare parameters
    let $cmdType = "updActType";
    let $id = $(".deactiveUser").val();

    // post and receive data
    $.post("AdminServlet",
        {cmdType: $cmdType, id:$id},
        //displayDeactiveUser
        onDisplyShowDeactiveUserOnPage
    );
    alert("The user is actived!");
}

function onUpdStatus_1(){//因为是动态的，要用anonymous function或 $(document).on
     // Prepare parameters
    let $cmdType = "updActType";
    let $id = $("#myInput").val();

    // post and receive data
    $.post("AdminServlet",
        {cmdType: $cmdType, id:$id},
        //displayDeactiveUser
        onDisplyShowDeactiveUserOnPage
    );
    alert("The user is actived!");
}

function onNextPage(){
    // Prepare parameters
    let $cmdType = "nextPage";
    $.post("AdminServlet",
        {cmdType: $cmdType},
        onDisplyShowDeactiveUserOnPage
    );
    alert("nextpage");
}

function onPreviousPage(){
    alert("prepage");
    // Prepare parameters
    let $cmdType = "prePage";
    $.post("AdminServlet",
        {cmdType: $cmdType},
        onDisplyShowDeactiveUserOnPage
    );
    alert("prepage");
}
