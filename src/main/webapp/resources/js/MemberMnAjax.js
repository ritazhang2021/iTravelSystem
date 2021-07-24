$(document).ready(function () {
    console.log("Document is ready!!!");
    onLoadInitData();
    $('#add').click(onAdd);
    $('#upd').click(onUpd);
    $('#del').click(onDel);
    $('#toexcel').click(ExportToExcel);
    // Search local
    $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#memberBody tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});

function onLoadInitData() {
    // Prepare parameters
    let $cmdType = "init";
    $.post("MemberMnServlet",
        {cmdType: $cmdType},
        dispMemberList);
}

function onAdd() {
    // Prepare parameters
    let $cmdType = "add";
    let $id = $("#id").val();
    let $name = $("#name").val();
    let $address = $("#address").val();
    let $phone = $("#phone").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("MemberMnServlet",
        {cmdType: $cmdType, id:$id, name:$name, address:$address, phone:$phone},
        dispMemberList);
}

function onUpd() {
    // Prepare parameters
    let $cmdType = "upd";
    let $id = $("#id").val();
    let $name = $("#name").val();
    let $address = $("#address").val();
    let $phone = $("#phone").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("MemberMnServlet",
        {cmdType: $cmdType, id:$id, name:$name, address:$address, phone:$phone},
        dispMemberList);
}

function onDel() {
    // Prepare parameters
    let $cmdType = "del";
    let $id = $("#id").val();
    // post and receive data
    $.post("MemberMnServlet",
        {cmdType: $cmdType, id:$id},
        dispMemberList);
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

function dispMemberList(respJson) {
    // Remove old Data
    let $table = $('#members');
    $table.find($('.member')).remove();
    // Update new data
    $.each(respJson, function(i, member){
        // New Row
        let $member = "<tr class=\"member\"><td>" + member.id + "</td><td>" + member.name + "</td><td>" + member.address + "</td><td>" + member.phone + "</td></tr>";
        $("#members").append($member);
    });
}

function ExportToExcel(mytblId){
    var htmltable= document.getElementById('members');
    var html = htmltable.outerHTML;
    window.open('data:application/vnd.ms-excel,' + encodeURIComponent(html));
}