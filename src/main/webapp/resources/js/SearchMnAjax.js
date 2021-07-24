$(document).ready(function () {
    $("#btnPost").click(function () {
        inquiry("post", 1, showPosts);
    });
    $("#btnUser").click(function () {
        inquiry("user", 1, showUsers);
    });
    $("#btnFollowedPost").click(function () {
        inquiry("followedPost", 1, showFollowedPosts);
    });
});

function inquiry(kind, pageno, callback){
    var url = "search";
    var name = "";
    current = pageno;
    name = $("#name").val();
    $.post(url, {
        "kind": kind,
        "name": name,
        "pageno": pageno
    }).done(callback);
}

function showPosts(data){
    var noRecord = "No record(s) found.";
    if(data.list.length > 0) {
        $("#id").html("ID");
        $("#f1").html("Title");
        $("#f2").html("Content");
        $("#f3").html("Category");
        $("#list tr").remove();
        $.each(data.list, function (index, value) {
            let item = "<tr><td>" + value.id + "</td><td>" + value.title + "</td><td>" + value.content + "</td><td>" + value.category + "</td></tr>";
            $("#list").append(item);
        });
        paging("post", data.total, "showPosts");
    }
    else {
        $("#list").html(noRecord);
    }
}

function showUsers(data){
    var noRecord = "No record(s) found.";
    if(data.list.length > 0) {
        $("#id").html("ID");
        $("#f1").html("Type");
        $("#f2").html("Full Name");
        $("#f3").html("Phone");
        $("#list tr").remove();
        $.each(data.list, function (index, value) {
            let item = "<tr><td>" + value.id + "</td><td>" + value.userType + "</td><td>" + value.fullName + "</td><td>" + value.email + "</td></tr>";
            $("#list").append(item);
        });
        paging("user", data.total, "showUsers");
    }
    else {
        $("#list").html(noRecord);
    }
}

function showFollowedPosts(data){
    var noRecord = "No record(s) found.";
    if(data.list.length > 0) {
        $("#id").html("ID");
        $("#f1").html("Traveller ID");
        $("#f2").html("Title");
        $("#f3").html("Content");
        $("#list tr").remove();
        $.each(data.list, function (index, value) {
            let item = "<tr><td>" + value.id + "</td><td>" + value.userId + "</td><td>" + value.title + "</td><td>" + value.content + "</td></tr>";
            $("#list").append(item);
        });
        paging("followedPost", data.total, "showFollowedPosts");
    }
    else {
        $("#list").html(noRecord);
    }
}