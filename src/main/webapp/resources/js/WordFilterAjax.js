$(document).ready(function () {
    // console.log("Document is ready!!!");
    onLoadInitData();
    $('#add').click(onAdd);
    $('#upd').click(onUpd);
    $('#del').click(onDel);
    $('#prePage').click(onPreviousPage);
    $('#nextPage').click(onNextPage);
});

function onLoadInitData() {
    alert("init")
    // Prepare parameters
    let $cmdType = "init";
    $.post("WordFilterServlet",
        {cmdType: $cmdType},
        ondispWordFilterList);
}

function onAdd() {
    // Prepare parameters
    let $cmdType = "add";
    let $id = $("#id").val();
    let $value = $("#value").val();
    // Check validate
    checkValidate();
    if ($('#value').val() === "false")
        return;
    // post and receive data
    $.post("WordFilterServlet",
        {cmdType: $cmdType, id:$id, value:$value},
        ondispWordFilterList);
}

function onUpd() {
    // Prepare parameters
    let $cmdType = "upd";
    let $id = $("#id").val();
    let $value = $("#value").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("WordFilterServlet",
        {cmdType: $cmdType, id:$id, value:$value},
        ondispWordFilterList);
}

function onDel() {
    // Prepare parameters
    let $cmdType = "del";
    let $id = $("#id").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("WordFilterServlet",
        {cmdType: $cmdType, id:$id},
        ondispWordFilterList);
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

function ondispWordFilterList() {
    alert("ondispWordFilterList");
    let $cmdType = "ShowOnPage";
    // post and receive data
    $.post("WordFilterServlet",
        {cmdType: $cmdType, },//json数据格式

        dispWordFilterList);
    alert("ondispWordFilterList");
}

function dispWordFilterList(respJson) {
    // Remove old Data
    let $table = $('#wordfilters');
    $table.find($('.wordfilter')).remove();
    // Update new data
    $.each(respJson, function(i, item){
        // New Row
        let $row = "<tr class=\"wordfilter\">"
            + "<td>" + item.id + "</td>"
            + "<td>" + item.value + "</td>"
            + "</tr>";
        $("#wordfilters").append($row);
    });
}
function onNextPage(){
    alert("nextpage");
    // Prepare parameters
    let $cmdType = "nextPage";
    $.post("WordFilterServlet",
        {cmdType: $cmdType},
        ondispWordFilterList
    );
    alert("nextpage");
}

function onPreviousPage(){
    alert("prepage");
    // Prepare parameters
    let $cmdType = "prePage";
    $.post("WordFilterServlet",
        {cmdType: $cmdType},
        ondispWordFilterList
    );
    alert("prepage");
}