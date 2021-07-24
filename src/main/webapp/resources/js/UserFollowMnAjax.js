$(document).ready(function () {
    // console.log("Document is ready!!!");
    onLoadInitData();
    $('#add').click(onAdd);
    $('#upd').click(onUpd);
    $('#del').click(onDel);
    // Search local
    $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});

function onLoadInitData() {
    // Prepare parameters
    let $cmdType = "init";
    $.post("UserFollowMnServlet",
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
    $.post("UserFollowMnServlet",
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
    $.post("UserFollowMnServlet",
        {cmdType: $cmdType, id:$id, travellerId:$travellerId, userId:$userId},
        dispFollowList);
}

function onDel() {
    // Prepare parameters
    let $cmdType = "del";
    let $id = $("#id").val();
    // post and receive data
    $.post("UserFollowMnServlet",
        {cmdType: $cmdType, id:$id},
        dispFollowList);
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
            + "<td>" + item.travellerId + "</td>"
            + "<td>" + item.userId + "</td>"
            + "</tr>";
        $table.append($row);
    });
}
