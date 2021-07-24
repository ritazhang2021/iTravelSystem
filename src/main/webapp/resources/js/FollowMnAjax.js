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
    $.post("FollowMnServlet",
        {cmdType: $cmdType},
        dispFollowList);
}

function onAdd() {
    // Prepare parameters
    let $cmdType = "add";
    let $id = $("#id").val();
    let $travellerId = $("#travellerId").val();
    let $userId = $("#userId").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("FollowMnServlet",
        {cmdType: $cmdType, id:$id, travellerId:$travellerId, userId:$userId},
        dispFollowList);
}

function onUpd() {
    // Prepare parameters
    let $cmdType = "upd";
    let $id = $("#id").val();
    let $travellerId = $("#travellerId").val();
    let $userId = $("#userId").val();
    let $content = $("#content").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("FollowMnServlet",
        {cmdType: $cmdType, id:$id, travellerId:$travellerId, userId:$userId},
        dispFollowList);
}

function onDel() {
    // Prepare parameters
    let $cmdType = "del";
    let $id = $("#id").val();
    let $travellerId = $("#travellerId").val();
    let $userId = $("#userId").val();
    // post and receive data
    $.post("FollowMnServlet",
        {cmdType: $cmdType, id:$id},
        dispFolllowList);
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

function dispFollowList(respJson) {
    // Remove old Data
    let $table = $('#follows');
    $table.find($('.follow')).remove();
    // Update new data
    $.each(respJson, function(i, item){
        // New Row
        let $row = "<tr class=\"follow\">"
            + "<td>" + item.id + "</td>"
            + "<td>" + item.postId + "</td>"
            + "<td>" + item.userId + "</td>"
            + "<td>" + item.content + "</td>"
            + "</tr>";
        $("#follows").append($row);
    });
}
