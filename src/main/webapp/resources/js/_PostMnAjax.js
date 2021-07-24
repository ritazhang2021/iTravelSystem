$(document).ready(function () {
    // console.log("Document is ready!!!");
    onLoadInitData();
    getCurrentUser();
    $('#add').click(onAdd);
    $('#upd').click(onUpd);
    $('#del').click(onDel);
});

function onLoadInitData() {
    // Prepare parameters
    let $cmdType = "init";
    $.post("UserPostServlet",
        {cmdType: $cmdType},
        disp_PostList);
}
function getCurrentUser() {
    console.log('call getCurrentUser');
    $.post("GetCurrentUserInfoServlet")
        .done(function (user){
            console.log(user);
            displayUserInfo(user);
            //updateUserInfoInEditForm(user);
            //UpdateUserInfoInHomePage(user);

        })
        .fail(function(error){
            console.error(error);
        });
}
function displayUserInfo(user){
    $('#name').html(user.fullName);
    $('#userId').html(user.userId);
    getPostList();
    // $('#gender').html(user.gender);
    // $('#year').html(user.birthYear);
    // $('#email').html(user.email);
    // $('#pwd').val(user.password);
    // $('#address').html(user.street +", " + user.city+ ","+user.state + ", "+ user.zipCode);
}
function onAdd() {
    alert("ddddd");
    // Prepare parameters
    let $cmdType = "add";
    // let $id = $("#id").val();
    let $image = $("#image").val();
    let $title = $("#title").val();
    let $content = $("#content").val();
    let $category = $("#category").val();
    let $tags = $("#tags").val();
    let $time = $("#time").val();
    let $location = $("#location").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("UserPostServlet",
        {cmdType: $cmdType, image:$image, title:$title, content:$content, category:$category, tags:$tags, time:$time, location:$location},
        disp_PostList);
}

function onUpd() {
    // Prepare parameters
    let $cmdType = "upd";
    // let $id = $("#id").val();
    let $image = $("#image").val();
    let $title = $("#title").val();
    let $content = $("#content").val();
    let $category = $("#category").val();
    let $tags = $("#tags").val();
    let $time = $("#time").val();
    let $location = $("#location").val();

    // Check validate
    //checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("_PostMnServlet",
        {cmdType: $cmdType, image:$image, title:$title, content:$content, category:$category, tags:$tags, time: $time, location: $location},
        disp_PostList);
}

function onDel() {
    // Prepare parameters
    let $cmdType = "del";
    let $id = $("#id").val();
    // post and receive data
    $.post("_PostMnServlet",
        {cmdType: $cmdType, id:$id},
        disp_PostList);
}

function checkValidate() {
    // Prepare parameters
    let $id = $("#id").val();
    // Check validate
    if ($id.trim().length == 0) {
        alert("ID is required!");
        $("#id").focus();
        $('#isValid').val("false");
        return;
    }
    $('#isValid').val("true");
}

function disp_PostList(respJson) {
    // Remove old Data
    let $table = $('#_posts');
    $table.find($('._post')).remove();

    console.log(this.userId + "userid test");
    // Update new data
    $.each(respJson, function(i, item){
        // New Row
        //console.log(this.userId);
        if(item.userId != this.userId) {
            console.log(item.userId);
            return;
        }
        else {

            let $row = "<tr class=\"_post\">"
                + "<td>" + item.id + "</td>"
                + "<td>" + item.image + "</td>"
                + "<td>" + item.title + "</td>"
                + "<td>" + item.content + "</td>"
                + "<td>" + item.category + "</td>"
                + "<td>" + item.tags + "</td>"
                + "<td>" + item.time + "</td>"
                + "<td>" + item.location + "</td>";
            $("#_posts").append($row);
        }

    });
}

function deletePost(postId){

}

