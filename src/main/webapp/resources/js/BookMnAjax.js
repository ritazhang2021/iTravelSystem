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
        $("#myTable tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});

function onLoadInitData() {
    // Prepare parameters
    let $cmdType = "init";
    $.post("BookMnServlet",
        {cmdType: $cmdType},
        dispBookList);
}

function onAdd() {
    // Prepare parameters
    let $cmdType = "add";
    let $id = $("#id").val();
    let $title = $("#title").val();
    let $author = $("#author").val();
    let $subject = $("#subject").val();
    let $isbn = $("#isbn").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("BookMnServlet",
        {cmdType: $cmdType, id:$id, title:$title, author:$author, subject:$subject, isbn:$isbn},
        dispBookList);
}

function onUpd() {
    // Prepare parameters
    let $cmdType = "upd";
    let $id = $("#id").val();
    let $title = $("#title").val();
    let $author = $("#author").val();
    let $subject = $("#subject").val();
    let $isbn = $("#isbn").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("BookMnServlet",
        {cmdType: $cmdType, id:$id, title:$title, author:$author, subject:$subject, isbn:$isbn},
        dispBookList);
}

function onDel() {
    // Prepare parameters
    let $cmdType = "del";
    let $id = $("#id").val();
    // post and receive data
    $.post("BookMnServlet",
        {cmdType: $cmdType, id:$id},
        dispBookList);
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

function dispBookList(respJson) {
    // Remove old Data
    let $table = $('#books');
    $table.find($('.book')).remove();
    // Update new data
    $.each(respJson, function(i, book){
        // New Row
        let $aCheckOut = "<a href=bookCheckout.jsp?bookId=" + book.id + ">Checkout</a>";
        let $book = "<tr class=\"book\"><td>" + book.id + "</td><td>" + book.title + "</td><td>" + book.author + "</td><td>" + book.subject + "</td><td>" + book.isbn + "</td><td>" + $aCheckOut + "</td></tr>";
        $("#books").append($book);
    });
}

function ExportToExcel(mytblId){
    var htmltable= document.getElementById('books');
    var html = htmltable.outerHTML;
    window.open('data:application/vnd.ms-excel,' + encodeURIComponent(html));
}
