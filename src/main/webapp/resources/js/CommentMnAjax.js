$(document).ready(function () {
    // console.log("Document is ready!!!");
    onLoadInitData();
    $('#add').click(onAdd);
    $('#upd').click(onUpd);
    $('#del').click(onDel);
});

function onLoadInitData() {
    // Prepare parameters
    let $cmdType = "init";
    $.post("CommentMnServlet",
        {cmdType: $cmdType},
        dispCommentList);
}

function onAdd() {
    // Prepare parameters
    let $cmdType = "add";
    let $id = $("#id").val();
    let $postId = $("#postId").val();
    let $userId = $("#userId").val();
    let $content = $("#content").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("CommentMnServlet",
        {cmdType: $cmdType, id:$id, postId:$postId, userId:$userId, content:$content},
        dispCommentList);
}

function onUpd() {
    // Prepare parameters
    let $cmdType = "upd";
    let $id = $("#id").val();
    let $postId = $("#postId").val();
    let $userId = $("#userId").val();
    let $content = $("#content").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("CommentMnServlet",
        {cmdType: $cmdType, id:$id, postId:$postId, userId:$userId, content:$content},
        dispCommentList);
}

function onDel() {
    // Prepare parameters
    let $cmdType = "del";
    let $id = $("#id").val();
    let $postId = $("#postId").val();
    let $userId = $("#userId").val();
    // post and receive data
    $.post("CommentMnServlet",
        {cmdType: $cmdType, id:$id},
        dispCommentList);
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

function dispCommentList(respJson) {
    // Remove old Data
    let $table = $('#comments');
    $table.find($('.comment')).remove();
    // Update new data
    $.each(respJson, function(i, item){
        // New Row
        let $row = "<tr class=\"comment\">"
            + "<td>" + item.id + "</td>"
            + "<td>" + item.postId + "</td>"
            + "<td>" + item.userId + "</td>"
            + "<td>" + item.content + "</td>"
            + "</tr>";
        $("#comments").append($row);
    });
}
