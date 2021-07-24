var current = 1;
const pageSize = 9;
var numPage = 0;
var first = 1;
var last = 10;
function paging(kind, total, callback) {
    numPage = Math.round(total / pageSize) + 1;
    console.log("first: " + first);
    console.log("last: " + last);
    console.log("current: " + current);
    console.log("num of pages: " + numPage);
    $("#pagination li").remove();
    var li = "<li class=\"page-item" +
        (1 === current ? " disabled\">": "\">") +
        (1 < current ? "<a class=\"page-link\" href=\"#\" onclick=\"prevPage('" + kind + "'," + callback + ");\">Previous</a>": "<span class=\"page-link\">Previous</span>") +
        "</li>";
    $("#pagination").append(li);
    last =  Math.min(numPage, last);
    for(let i = first; i <= last; i++){
        let li = "<li class=\"page-item" +
            (i === current ? " active\" aria-current=\"page\">": "\">") +
            (i === current ? "<span class=\"page-link\">": "<a class=\"page-link\" href=\"#\" onclick=\"inquiry('" + kind + "'," + i + "," + callback + ");\">") +
            i +
            (i === current ? "<span class=\"sr-only\">(current)</span></span>": "</a></li>");
        $("#pagination").append(li);
    }

    li = "<li class=\"page-item" +
        (numPage === current ? " disabled\">": "\">") +
        (numPage > current ? "<a class=\"page-link\" href=\"#\" onclick=\"nextPage('" + kind + "'," + callback + ");\">Next</a>": "<span class=\"page-link\">Next</span>") +
        "</li>";
    $("#pagination").append(li);
}

function prevPage(kind, callback){
    if(current === first){
        last = first - 1;
        first = last - 9;
    }
    inquiry(kind, current - 1, callback);
}

function nextPage(kind, callback){
    if(current === last){
        first = last + 1;
        last = first + 9;
    }
    inquiry(kind, current + 1, callback);
}