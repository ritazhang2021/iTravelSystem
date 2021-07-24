// alert("");
$(document).ready(function () {
    // console.log("Document is ready!!!");
    alert("data loading ....!")
    $('#btnStart').click(onLoadInitData);
});

function onLoadInitData() {
    // Prepare parameters
    alert("data loading ....!")
    let $cmdType = "init";
    $.post("initDataServlet",
        {cmdType: $cmdType},
        function () {alert("data loaded...!");});
}

