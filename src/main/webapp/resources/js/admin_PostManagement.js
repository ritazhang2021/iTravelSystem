$(document).ready(function () {//可以把$(document).ready写成$
    console.log("Document is ready!!!");
    onLoadInitData();
    $('.deactiveUser').click(onUpdStatus);
    // $('.deactiveUser').click(refreshCallbacks);
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

// $(document).on("click",".deactiveUser",function(){
//     onUpdStatus();
// });

function onLoadInitData() {
    alert("init");
    // Prepare parameters
    let $cmdType = "init";
    $.post("AdminPostServlet",
        {cmdType: $cmdType},
        onDisplyShowDeactiveUserOnPage
    );
    alert("init");
}

function onDisplyShowDeactiveUserOnPage() {
    alert("onDisplyShowDeactiveUserOnPage");
    let $cmdType = "ShowOnPage";
    // post and receive data
    $.post("AdminPostServlet",
        {cmdType: $cmdType},//json数据格式

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

        let $aStatus = '<button class="deactiveUser" value=' + user.id + '>Change Status</button>'
        // let $aStatus = '<button class="deactiveUser" value=' + user.id + '>' +user.id+ '</button>'

        let $user = "<tr class=\"user\">" +
            "<td>"+ user.id + "</td>" +
            "<td>"+ user.title + "</td>" +
            "<td>" + user.content + "</td>" +
            "<td>" + user.category + "</td>" +
            "<td>" + user.tags+ "</td>" +
            "<td>" + user.time+ "</td>" +
            "<td>" + user.status+ "</td>" +
            "<td>" + $aStatus + "</td>" +
            "</tr>";
        $("#users").append($user);
    });
}


function onUpdStatus(){//因为是动态的，要用anonymous function或 $(document).on
    // Prepare parameters
    let $cmdType = "updActType";
    // let $id = $(".deactiveUser").val();
    let $id = $(this).val();
    // post and receive data
    $.post("AdminPostServlet",
        {cmdType: $cmdType, id:$id},
        onDisplyShowDeactiveUserOnPage
    );
    alert("The post is changed!");
    // Refresh data
    onLoadInitData();
}

function onUpdStatus_1(){//因为是动态的，要用anonymous function或 $(document).on
    // Prepare parameters
    let $cmdType = "updActType";
    let $id = $("#myInput").val();
    // post and receive data
    $.post("AdminPostServlet",
        {cmdType: $cmdType, id:$id},
        onDisplyShowDeactiveUserOnPage
    );
    alert("The post is changed!");
    // Refresh data
    onLoadInitData();
}

function onNextPage(){
    // Prepare parameters
    let $cmdType = "nextPage";
    $.post("AdminPostServlet",
        {cmdType: $cmdType},
        onDisplyShowDeactiveUserOnPage
    );
    alert("nextpage");
}

function onPreviousPage(){
    alert("prepage");
    // Prepare parameters
    let $cmdType = "prePage";
    $.post("AdminPostServlet",
        {cmdType: $cmdType},
        onDisplyShowDeactiveUserOnPage
    );
    alert("prepage");
}
