$(document).ready(function () {
    // console.log("Document is ready!!!");
    onLoadInitData();
    $('#add').click(onAdd);
    $('#upd').click(onUpd);
    $('#del').click(onDel);
    // Search local
    $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#myTable").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});

function onLoadInitData() {
    // Prepare parameters
    let $cmdType = "init";
    $.post("UserPostMnServlet",
        {cmdType: $cmdType},
        dispPostList);
}

function onAdd() {
    alert("Addddddd");
    // Prepare parameters
    let $cmdType = "add";
    let $id = $("#id").val();
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
    $.post("UserPostMnServlet",
        {cmdType: $cmdType, id: $id, image:$image, title:$title, content:$content, category:$category, tags:$tags, time:$time, location:$location},
        dispPostList);
}

function onUpd() {
    // Prepare parameters
    let $cmdType = "upd";
    let $id = $("#id").val();
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
    $.post("UserPostMnServlet",
        {cmdType: $cmdType, id: $id, image:$image, title:$title, content:$content, category:$category, tags:$tags, time: $time, location: $location},
        disp_PostList);
}

function onDel() {
    // Prepare parameters
    let $cmdType = "del";
    let $id = $("#id").val();
    // post and receive data
    $.post("UserPostMnServlet",
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

function dispPostList(respJson) {
    // Remove old Data
    let $table = $('#posts');
    $table.find($('.post')).remove();
    // Update new data
    $.each(respJson, function(i, item){
        // New Row
            let $row = "<tr class=\"post\">"
                + "<td>" + item.id + "</td>"
                + "<td>" + item.image + "</td>"
                + "<td>" + item.title + "</td>"
                + "<td>" + item.content + "</td>"
                + "<td>" + item.category + "</td>"
                + "<td>" + item.tags + "</td>"
                + "<td>" + item.time + "</td>"
                + "<td>" + item.location + "</td>";
        $table.append($row);
    });
}
