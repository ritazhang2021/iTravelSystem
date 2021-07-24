$(document).ready(function () {
    //onLoadInitData();
    onLoadNotify();

    setTimeout(function (){
        getPostList();
    },1000)

    $('#add').click(onAdd);
    $('#btnNotifyList').mouseover(onShowNotifyList);
    uploadImage();
    uploadImage1();
    //getCurrPostList();

    $('#upd').click(onUpdate);
    $('#del').click(onDelete);

    $('.btnUpdate').click(openEdit);

    //show and hide edit form

    showHideForm();
    getLocation();

});



// function getCurrPostList(){
//     let $cmdType = "getPostList";
//     //checkValidate();
//     $.post("UserPostServLet", {cmdType : $cmdType}, dispPostList);
// }
function getPostList(){
    let $cmdType = "getPosts";
    let $userID = $('#userId').text();
    console.log("get post list");

    console.log($cmdType);
    $.post("UserPostServlet",
        {
            cmdType: $cmdType, userID: $userID
        }, displayPostListOnHomePage);
}

// function onLoadInitData(){
//
//     let $cmdType = "init";
//     //checkValidate();
//     $.post("UserPostMn", {cmdType : $cmdType}, displayPostListOnHomePage);
// }

var time = new Date();
function onAdd(){
    let $cmdType = "add";
    // let $id = $('#id').html();
    // console.log($id);
    let $userId = $('#userId').html();
    let $title = $('#title').html();
    let $content = $('#content').text();
    console.log($content);
    let $category = $('#category').val();
    console.log($category);
    let $tags = $('#tags').val();
    console.log($tags);
    let $image = $('#image').val();
    console.log($tags);
    let $location = $('#location').is(":checked");
    let $notification = $('#notification').is(':checked');

    var fullPath = $('#image').val();
    if (fullPath) {
        var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
        var filename = fullPath.substring(startIndex);
        if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
            filename = filename.substring(1);
        }
    }
    let urlImage = "resources/images/" + filename;

    console.log($image);
    //var time = new Date();
    let $time= time.getMonth()+"-"+time.getDate()+"-"+time.getFullYear();

    $.post("UserPostServlet",
        {
            cmdType: $cmdType, userId: $userId,  title:$title, content:$content, category:$category, tags:$tags, image:urlImage, time:$time, location:$location, notification:$notification
        }, displayPostListOnHomePage);
    // }, disPostList);
    $('#formAdd').submit();
    uploadImage();

}

function onUpdate(){
    $('.updateImageEdit').hide();
    //alert("on update");
    //alert("hello");
    let $cmdType = "upd";
    let $id = $('#u-id').val();
    console.log($id);
    let $userId = $('#userId').html();
    console.log($userId);
    let $title = $('#u-title').html();
    console.log($title);
    let $content = $('#u-content').text();
    console.log($content);
    let $category = $('#u-category').val();
    console.log($category);
    let $tags = $('#u-tags').val();
    console.log($tags);
    let $image = $('#u-image').val();
    console.log($image);
    var fullPath = $('#u-image').val();
    console.log(fullPath);
    if (fullPath) {
        var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
        var filename = fullPath.substring(startIndex);
        if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
            filename = filename.substring(1);
        }
    }
    let urlImage = "resources/images/" + filename;
    console.log(urlImage +"-----------");
    // var $location = $('#aadddd').coords.latitude + "," + $('#add').coords.longitude;

    var $time= time.getMonth()+","+time.getDate()+","+time.getFullYear();

    $.post("UserPostServlet",
        {
            cmdType: $cmdType, id:$id, userId: $userId, image:urlImage, title:$title, content:$content, category:$category, tags:$tags, time:$time
        }, displayPostListOnHomePage);
    // }, disPostList);
    $('#formUpdate').submit();
    uploadImage();


}

function onDelete(postId){
    let $cmdType = "del";
    let $id = postId;
    $.post("UserPostServlet",
        {
            cmdType:$cmdType, id:$id
            // }, disPostList())
        }).done(function(posts){
        displayPostListOnHomePage(posts);
    }).fail(function(error){

        }

    )


}
function onDeleteCurrPost(){
    let $cmdType = "del";
    let $id = $('#id').val();
    $.post("UserPostServlet",
        {
            cmdType:$cmdType, id:$id
            // }, disPostList())
        }, displayPostListOnHomePage())
    //$('#formAdd').submit();

}

function disPostList(respJson){
    //alert("dis play post");

    let $table = $('#table');
    $table.find(($('.w3-container'))).append();
    $.each(respJson, function (i, item){
        console.log(item.userId);
        console.log(item.image);
        console.log(item.time);
        console.log(item.content);
        console.log(item.category);
        // console.log($('#userId').html());
        if(item.userId == $('#userId').html()){

            $("#uimage").html(item.image);
            $("#uid").html(item.id);
            $('#utitle').html(item.title);
            $('#ucontent').html(item.content);
            $('#ucategory').html(item.category);
            $('#utag').html(item.tags);
            $('#utime').html(item.time);

            console.log(item.time);
            //console.log(('#utime'));
        }else {
            console.log("display col");

            let $col = "<td class=\"w3-container w3-card w3-white w3-round w3-margin\">"
                + "<td>" + $('.w3-border w3-padding').html(item.id) + "</td>"
                + "<td>" + $('.w3-border w3-padding').html(item.image) + "</td>"
                + "<td>" + $('.w3-border w3-padding').html(item.title) + "</td>"
                + "<td>" + $('.w3-border w3-padding').html(item.content) + "</td>"
                + "<td>" + $('.w3-border w3-padding').html(item.category) + "</td>"
                + "<td>" + $('.w3-border w3-padding').html(item.tags) + "</td>"
                + "<td>" + $('.w3-border w3-padding').html(item.time) + "</td>"
                + "<td>" + $('.w3-border w3-padding').html(item.location) + "</td>";

            $table.append($col);
        }

        if ($('#u-title').html()!=item.title)
            $('#u-title').html(item.title);
        if ($('#u-content').html()!=item.content)
            $('#u-content').html(item.content);

    })
}
function checkValidate() {
    // Prepare parameters
    let $id = $("#id").val();
    let $useId = $("#userId").html();
    // Check validate
    if ($useId == 0) {
        alert("Session expired. Please login again");
        return;
    }
    // if ($id==0){
    //     alert("Post Id is required");
    // }
}
//     $('#isValid').val("true");
// }
function uploadImage(){
    $('#formAdd').submit(function(event) {
        console.log("form submit 1");
        event.preventDefault();
        console.log("form submit 2");

        $.ajax({
            url : $(this).attr('action'),
            type : $(this).attr('method'),
            data : new FormData(this),
            contentType : false,
            cache : false,
            processData : false,
            success : function(response) {
                console.log(response);
                $('#image_frame').html(response);
                // $('.center').hide();
                // $('#show').show();
                console.log("i'm here to test");
            },
            beforeSend : function() {
                console.log("before send");
            }
        });

        return false;
    });

}
function uploadImage1(){
    $('#formUpdate').submit(function(event) {
        console.log("form submit 1");
        event.preventDefault();
        console.log("form submit 2");
        // let $imageName = $('#u-image').val();
        // $.post("ImageUploadServlet", {
        //     imageName: $imageName, data: new FormData(this)
        // }, function (response) {
        //     console.log(response);
        //     $('#image_frame').html(response);
        //     $('#center').hide();
        // })

        // Calling AJAX
        $.ajax({
            url : $(this).attr('action'),
            type : $(this).attr('method'),
            data : new FormData(this),
            contentType : false,
            cache : false,
            processData : false,
            success : function(response) {
                console.log(response);
                $('#image_frame').html(response);
                $('#center').hide();
            },
            beforeSend : function() {
                console.log("before send");
            }
        });

        return false;
    });

}

//show location
function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position){
            var lat = position.coords.latitude;
            var long = position.coords.longitude;
            $.each(window.postList, function (i, item){
                if(item.location=='true' || item.location== 'on'){

                    initMap(item.id, lat, long);
                }
                //initMap(item.id, lat, long);
            })
        });
    } else {
        console.log( "Geolocation is not supported by this browser.");
    }
}



function setupMap(){
    getLocation();

}

let map, infoWindow;

function initMap(postId, lat, long) {
    if(postId == null){
        return false;
    }
    $('#map'+postId).css({
        width: '100%',
        height: '250px'
    })
    map = new google.maps.Map(document.getElementById("map"+postId), {
        center: { lat: lat, lng: long },
        zoom: 6,
    });
    infoWindow = new google.maps.InfoWindow();
    const locationButton = document.createElement("button");
    locationButton.textContent = "Pan to Current Location";
    locationButton.classList.add("custom-map-control-button");
    map.controls[google.maps.ControlPosition.TOP_CENTER].push(locationButton);
    locationButton.addEventListener("click", () => {
        // Try HTML5 geolocation.
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(
                (position) => {
                    const pos = {
                        lat: position.coords.latitude,
                        lng: position.coords.longitude,
                    };
                    infoWindow.setPosition(pos);
                    infoWindow.setContent("Location found.");
                    infoWindow.open(map);
                    map.setCenter(pos);
                },
                () => {
                    handleLocationError(true, infoWindow, map.getCenter());
                }
            );
        } else {
            // Browser doesn't support Geolocation
            handleLocationError(false, infoWindow, map.getCenter());
        }
    });
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(
        browserHasGeolocation
            ? "Error: The Geolocation service failed."
            : "Error: Your browser doesn't support geolocation."
    );
    infoWindow.open(map);
}

function displayPostListOnHomePage(respJson){
    console.log("render list");
    window.postList = respJson;
    let $table = $('#posts');
    //   $table.find($('._post')).remove();

    var allPostHTML = "";
    // Update new data
    $.each(respJson, function(i, item) {
        allPostHTML +=displaySinglePost(item);

    });
    $('#all-post').html(allPostHTML);
    //console.log(item.time);
    // for(var i =0; i<10; i++){
    //
    // }
    setupMap();
}
function displaySinglePost(post){

    var postHTML = '<div class="w3-container w3-card w3-white w3-round w3-margin" id="post-@id1@"><br>' +
        '<img src="resources/images/avatar.jpeg" alt="Avatar" class="w3-left w3-circle w3-margin-right" style="width:60px">'+

        '<span class="w3-right w3-opacity">@date@</span>'+
        '<label for="uid-@id1@">Post ID: </label>'+
        '<span id="uid-@id1@">@id@</span><br>'+
        '<label for="utitle-@title1@">Title: </label>'+
        '<span id="utitle-@title1@">@title@</span><br>'+
        '<div ><img src="@image@" style="width:100%"></div>'+
        '<hr class="w3-clear">'+

        '<span >@content@</span>'+
        '<img src="" style="width:100%" class="image" id="image">'+
        '<div class="w3-row-padding" style="margin:0 -16px">'+
        '<div id="map@id@"></div>'+
        '<label for="ucategory-@category1@">@category@</label>'+
        '<div class="w3-half" id="ucategory-@category1@">General</div>'+
        '<label for="utag-@tag1@">In Mode: </label>'+
        '<div class="w3-half" id="utag-@tag1@">@tag@</div>'+
        '</div>'+

        // '<button type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-thumbs-up"></i> &nbsp;Like</button>'+
        // '<button type="button" class="w3-button w3-theme-d2 w3-margin-bottom"><i class="fa fa-comment"></i> &nbsp;Comment</button>'+
        '<br>'+
        '<button @cssUpdate@ id="@show@" type="button" class="btnUpdate w3-button w3-theme-d1 w3-margin-bottom" style="" onclick="openFormUpdate(@show@);"><i class="fa fa-delete"></i>  Update</button>'+
        '<button @cssDelete@ type="button" class="w3-button w3-theme-d1 w3-margin-bottom" onclick="onDelete(@id@);"><i class="fa fa-delete"></i>  Delete</button>'+
        '<br>' +
        '<button type="button" id="like-@id@" class="w3-button w3-theme-d1 w3-margin-bottom" onclick="likePost(@id@);">' +
        '<i class="fa fa-thumbs-up"></i> &nbsp</button>'+
        '<button type="button" class="w3-button w3-theme-d2 w3-margin-bottom">' +
        '<i class="fa fa-comment"></i> &nbsp;Comment</button>'+
        // '<br>'+
        //     '<button @cssUpdate@ id="@show@" type="button" class="btnUpdate w3-button w3-theme-d1 w3-margin-bottom" style="" onclick="openFormUpdate(@show@);"><i class="fa fa-delete"></i>  Update</button>'+
        //     '<button @cssDelete@ type="button" class="w3-button w3-theme-d1 w3-margin-bottom" onclick="onDelete(@id@);"><i class="fa fa-delete"></i>  Delete</button>'+

        '</div>'
    '<div id="box">'+
    '<p>Comment：</p>'+
    '<textarea class="txt"   rows="10" cols="10"></textarea ><br>'+
    '<button class="submitComment">Submit</button><span id="len">0</span>'+
    '<p class="pl">Comment Area:</p>'+
    '</div>'+


    '</div>'
    if(post.userId!==$('#userId').text()){
        postHTML = postHTML.replaceAll('@cssDelete@', ' style="display:none" ');
        postHTML = postHTML.replaceAll('@cssUpdate@', ' style="display:none" ');

        //postHTML = postHTML.replace('id-@id@', post.id);
    }
    else {
        postHTML = postHTML.replaceAll('@id@', post.id);
        postHTML = postHTML.replaceAll('@id@', post.id);
    }
    //console.log(post.userId);
    // postHTML = postHTML.replaceAll('@show@', post.id);
    // postHTML = postHTML.replaceAll('@id@', post.id);

    postHTML = postHTML.replaceAll('@id@', post.id);
    postHTML = postHTML.replaceAll('@date@', post.time);
    postHTML = postHTML.replaceAll('@image@', post.image);
    postHTML = postHTML.replaceAll('@title@', post.title);
    postHTML = postHTML.replaceAll('@content@', post.content);
    postHTML = postHTML.replaceAll('@category@', post.category);
    postHTML = postHTML.replaceAll('@tag@', post.tags);


    return postHTML;
}
function openEdit(){
   //
    //
    //
    // alert("hello")
}

function openFormUpdate(postId){
    console.log(window.postList);
    // $.each(window.postList, function (i, item){
    //
    // })
    var foundPosts = window.postList.filter(function (post){
        return post.id == postId;
    });
    console.log(foundPosts);
    if(foundPosts.length==0){
        alert("post not found");
    }
    var post = foundPosts[0];

    var modal=$('#modalUpdateUser');

    modal.data("postId", postId);



    $('#modalUpdateUser').show();


    $('#u-title').html(post.title);


    $('#u-content').text(post.content);

    $('#u-category').val(post.category);

    $('#u-tags').val(post.tags);
    $('#u-id').val(post.id);

    // $('#u-image').val(post.image);

    //let btn = document.getElementById(show);
    //
    // $('btn').click(abc);
    // function abc(){
    //     $('.center').show();
    // ///     $('.center').show();
    //  }
    // $('#').on('click', function () {
    // console.log("test")
    //     $('.center').show();
    //    z  $(this).hide();
    // })

    $('#close').on('click', function () {
        $('.center').hide();
        $('#show').show();
    })
}

function dispNotification(posts, followers){
    //if(followers.userId==posts.userId){
    console.log("display notification");

    $.each(posts, function(i, item) {
        // New Row
        console.log(this.userId);
        let count = 0;
        if (item.userId != followers.userId) {
            //console.log(item.userId);
            //count = count +1;
            return;
        } else {
            count = count +1;
            console.log(item.title + ", "+ item.textContent + ", "+ item.category + ", "+ item.tags + item.category + item.time)
        }
    });

}

function likePost(postId) {
    let likeId = "#like-"+postId;
    $.get('UserPostServlet', {
        'should_like': true,
        'postId': postId
    }).done(function (data) {
        $(likeId).text(data + " Like");
        //$('#like-024').text(data + " Like");
    }).fail(function () {
        console.log("Failed");
    })
    console.log("js, likePost, excuted");
}


function showComment() {
    var txt = document.getElementsByClassName('txt')[0];
    var btn = document.getElementsByClassName('submitComment')[0];
    var pl = document.getElementsByClassName('pl')[0];
    var Olen = document.getElementById('len');

    if (txt.value == '') {
        confirm("you don't want to input something")
        return false;
    } else {
        var ul = document.createElement('ul');
        pl.appendChild(ul);
        var li = document.createElement('li');
        ul.appendChild(li);
        li.innerHTML = txt.value;
        txt.value = ''
        var li = document.createElement('li');
        ul.appendChild(li);
        var date = new Date();
        li.innerHTML = date.toLocaleDateString();

        var oa = document.createElement('a');
        li.appendChild(oa);
        oa.innerHTML = 'delete';
        oa.style.float = 'right';
        oa.style.href = '#'
    }
    oa.onclick = function() {
        oa.parentNode.parentNode.remove()
        oa.style.cursor = 'pointer'
    }


}

function onLoadNotify() {
    // Prepare parameters
    let $cmdType = "loadNotify";
    $.post("UserPostServlet",
        {cmdType: $cmdType},
        dispNotifyInfo);
}

function dispNotifyInfo(respJson) {
    // Remove old Data
    $('#countNotify').remove();
    // Update new data
    let count = 0;
    $.each(respJson, function(i, book){
        // New Row
        count++;
    });
    // let item = '<span class="w3-badge w3-right w3-small w3-green" id="countNotify">' + count > 0 ? count : "" + '</span>'
    let item = '<span class="w3-badge w3-right w3-small w3-green" id="countNotify">' + count + '</span>'
    $('#beforecountNotify').append(item);
}

function onShowNotifyList() {
    // Prepare parameters
    let $cmdType = "loadNotifyDetail";
    $.post("UserPostServlet",
        {cmdType: $cmdType},
        dispNotifyDetailList);
}

function dispNotifyDetailList(respJson) {
    // Remove old Data
    let $table = $('#containerNotify');
    $table.find($('.notifyDetail')).remove();
    // Update new data
    $.each(respJson, function(i, item){
        // New Row
        let $row = '<a href="#" class="w3-bar-item w3-button notifyDetail">'+ item.userId + ": " + item.title + '</a>';
        $table.append($row);
    });
}