// alert("");
$(document).ready(function () {
    // console.log("Document is ready!!!");
    // onLoadInitData();
    $('#btnLogin').click(onLogin);
});

function onLoadInitData() {
    // Prepare parameters
    let $cmdType = "init";
    $.post("loginServlet",
        {cmdType: $cmdType},
        function () {alert("data loaded...!");});
}

function onLogin() {
    // Prepare parameters
    let $cmdType = "login";
    let $txtUserName = $("#txtUserName").val();
    let $txtPassword = $("#txtPassword").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive datas
    $.post("loginServlet",
        {cmdType: $cmdType, userName:$txtUserName, password:$txtPassword})
        .done(doLoginResult)
        .fail(doLoginFail);
    //
    // $.post("loginServlet",
    //     {cmdType: $cmdType, userName:$txtUserName, password:$txtPassword},
    //     doLoginResult);
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

function doLoginResult(respJson) {
alert(respJson);
    /*
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
*/
}

function doLoginFail(respJson) {
    alert("Fail")
    /*
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
    */
}
