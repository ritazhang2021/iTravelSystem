$(document).ready(function () {
    $("#btnBook").click(function () {
        inquiry("book", 1, showBooks);
    });
    $("#btnMember").click(function () {
        inquiry("member", 1, showMembers);
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

function showBooks(data){
    var noRecord = "No record(s) found.";
    if(data.list.length > 0) {
        $("#id").html("ID");
        $("#f1").html("Title");
        $("#f2").html("Author");
        $("#f3").html("Isbn");
        $("#list tr").remove();
        $.each(data.list, function (index, value) {
            let book = "<tr><td>" + value.id + "</td><td>" + value.title + "</td><td>" + value.author + "</td><td>" + value.isbn + "</td></tr>";
            $("#list").append(book);
        });
        paging("book", data.total, "showBooks");
    }
    else {
        $("#list").html(noRecord);
    }
}

function showMembers(data){
    var noRecord = "No record(s) found.";
    if(data.list.length > 0) {
        $("#id").html("ID");
        $("#f1").html("Name");
        $("#f2").html("Address");
        $("#f3").html("Phone");
        $("#list tr").remove();
        $.each(data.list, function (index, value) {
            let member = "<tr><td>" + value.id + "</td><td>" + value.name + "</td><td>" + value.address + "</td><td>" + value.phone + "</td></tr>";
            $("#list").append(member);
        });
        paging("member", data.total, "showMembers");
    }
    else {
        $("#list").html(noRecord);
    }
}