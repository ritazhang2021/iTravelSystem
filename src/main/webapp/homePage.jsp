<%--
  Created by IntelliJ IDEA.
  User: hale
  Date: 11/14/20
  Time: 1:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<title>Itravel</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="resources/css/userinfo.css" type="text/css" rel="stylesheet" />
<script src="resources/js/userTravelInfo.js" type="text/javascript"></script>
<script src="resources/js/UserPostMn.js" type="text/javascript"></script>
<script
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDxbIy6hOaXxLbk0EW_gRGWdJZkm6FhX38&callback=initMap&libraries=&v=weekly"
        defer
></script>
<style>
    html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
</style>

<div class="w3-top">
    <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
        <a href="#" class="w3-bar-item w3-button w3-padding-large w3-theme-d4"><i class="fa fa-home w3-margin-right"></i>Itravel</a>
        <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="News"><i class="fa fa-globe"></i></a>
        <a href="userTravelInfo.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="My Profile"><i class="fa fa-user"></i></a>
        <%--        <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Messages"><i class="fa fa-envelope"></i></a>--%>
        <div class="w3-dropdown-hover w3-hide-small">
            <button class="w3-button w3-padding-large" title="Notifications" id="btnNotifyList"><i class="fa fa-bell" id="beforecountNotify"></i><span class="w3-badge w3-right w3-small w3-green" id="countNotify">3</span></button>
            <div class="w3-dropdown-content w3-card-4 w3-bar-block" style="width:300px" id="containerNotify">
                <a href="#" class="w3-bar-item w3-button notifyDetail">One new friend request</a>
                <a href="#" class="w3-bar-item w3-button notifyDetail">John Doe posted on your wall</a>
                <a href="#" class="w3-bar-item w3-button notifyDetail">Jane likes your post</a>
            </div>
        </div>
        <a href="#" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="My Account">
            <img src="resources/images/bg/avatar.jpeg" class="w3-circle" style="height:23px;width:23px" alt="Avatar" width="200px">

        </a>
    </div>
</div>

<!-- Navbar on small screens -->
<div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 1</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
    <a href="userTravelInfo.jsp" class="w3-bar-item w3-button w3-padding-large">My Profile</a>
</div>

<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px">
    <!-- The Grid -->
    <div class="w3-row">
        <!-- Left Column -->
        <div class="w3-col m3">
            <!-- Profile -->
            <div class="w3-card w3-round w3-white">
                <div class="w3-container">
                    <h4 class="w3-center">My Profile</h4>
                    <p class="w3-center"><img src="resources/images/bg/avatar.jpeg" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></p>
                    <hr>
                    <p><i id="userId" class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i></p>
                    <p><i id="name" class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i></p>
                    <p ><i  id="address" class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i></p>
                    <p ><i id="byear" class="fa fa-birthday-cake fa-fw w3-margin-right w3-text-theme"></i></p>
                </div>
            </div>
            <br>

            <!-- Accordion -->
            <div class="w3-card w3-round">
                <div class="w3-white">
                    <button onclick="myFunction('Demo1')" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-circle-o-notch fa-fw w3-margin-right"></i> My Groups</button>
                    <div id="Demo1" class="w3-hide w3-container">
                        <p>Some text..</p>
                    </div>
                    <button onclick="myFunction('Demo2')" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-calendar-check-o fa-fw w3-margin-right"></i> My Events</button>
                    <div id="Demo2" class="w3-hide w3-container">
                        <p>Some other text..</p>
                    </div>
                    <button onclick="myFunction('Demo3')" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-users fa-fw w3-margin-right"></i> My Photos</button>
                    <div id="Demo3" class="w3-hide w3-container">
                        <div class="w3-row-padding">
                            <br>
                            <div class="w3-half">
                                <img src="" style="width:100%" class="w3-margin-bottom">
                            </div>
                            <div class="w3-half">
                                <img src="" style="width:100%" class="w3-margin-bottom">
                            </div>
                            <div class="w3-half">
                                <img src="" style="width:100%" class="w3-margin-bottom">
                            </div>
                            <div class="w3-half">
                                <img src="" style="width:100%" class="w3-margin-bottom">
                            </div>
                            <div class="w3-half">
                                <img src="" style="width:100%" class="w3-margin-bottom">
                            </div>
                            <div class="w3-half">
                                <img src="" style="width:100%" class="w3-margin-bottom">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>

            <!-- Interests -->
            <div class="w3-card w3-round w3-white w3-hide-small">
                <div class="w3-container">
                    <p>Interests</p>
                    <p>
                        <span class="w3-tag w3-small w3-theme-d5">News</span>
                        <span class="w3-tag w3-small w3-theme-d4">W3Schools</span>
                        <span class="w3-tag w3-small w3-theme-d3">Labels</span>
                        <span class="w3-tag w3-small w3-theme-d2">Games</span>
                        <span class="w3-tag w3-small w3-theme-d1">Friends</span>
                        <span class="w3-tag w3-small w3-theme">Games</span>
                        <span class="w3-tag w3-small w3-theme-l1">Friends</span>
                        <span class="w3-tag w3-small w3-theme-l2">Food</span>
                        <span class="w3-tag w3-small w3-theme-l3">Design</span>
                        <span class="w3-tag w3-small w3-theme-l4">Art</span>
                        <span class="w3-tag w3-small w3-theme-l5">Photos</span>
                    </p>
                </div>
            </div>
            <br>

            <!-- Alert Box -->
            <div class="w3-container w3-display-container w3-round w3-theme-l4 w3-border w3-theme-border w3-margin-bottom w3-hide-small">
        <span onclick="this.parentElement.style.display='none'" class="w3-button w3-theme-l3 w3-display-topright">
          <i class="fa fa-remove"></i>
        </span>
                <p><strong>Hey!</strong></p>
                <p>People are looking at your profile. Find out who.</p>
            </div>

            <!-- End Left Column -->
        </div>

        <!-- Middle Column -->
        <div class="w3-col m7">

            <div class="w3-row-padding">
                <div class="w3-col m12">
                    <div class="w3-card w3-round w3-white">
                        <div class="w3-container w3-padding">
                            <h6 class="w3-opacity">How would you feel today?</h6>
                            <form  id="formAdd" action="ImageUploadServlet"
                                   method="post"
                                   enctype="multipart/form-data">
                                <%--                                <label for="id">Post Id</label>--%>
                                <%--                                <input id="id" type="number"/>--%>
                                <%--                                <label for="title">Title</label>--%>
                                <p id="title" contenteditable="true" class="w3-border w3-padding">Title: </p>
                                <p id="content" contenteditable="true" class="w3-border w3-padding">Status: Freedom</p>
                                <label for="category">Category</label>

                                <select id="category" class="inline">
                                    <option selected>General</option>
                                    <option>Traveling</option>
                                    <option>Discussion</option>
                                    <option>Question</option>
                                </select>
                                <label for="tags">Feeling</label>
                                <select id="tags">
                                    <option selected>Happy</option>
                                    <option>Sad</option>
                                    <option>Confuse</option>
                                    <option>Nothing</option>
                                </select>
                                <br/>
                                <label for="image" class="btn">Upload Photo</label>
                                <input type="file" name="imageUpload" src="" id="image" accept="image/*" />

                                <div id="floating-panel">
                                    <input type="checkbox" id="location" name="location">
                                    <label for="location">Post With Location</label><br>
                                    <%--                                    <input id="latlng" type="text" value="40.714224,-73.961452" />--%>
                                    <%--                                    <input id="location" type="button" value="Reverse Geocode" />--%>
                                </div>
                                <div id="map"></div>
                                <div id="floating-panel">
                                    <input type="checkbox" id="notification" name="notification">
                                    <label for="notification">Post With Notification</label><br>
                                    <%--                                    <input id="latlng" type="text" value="40.714224,-73.961452" />--%>
                                    <%--                                    <input id="location" type="button" value="Reverse Geocode" />--%>
                                </div>
                                <br/>

                                <%--                            <button id="add" type="button" class="w3-button w3-theme"><i class="fa fa-pencil"></i>  Post</button>--%>
                                <span id="add" class="w3-button w3-theme"><i class="fa fa-pencil"></i> Post</span>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
            <dt></dt>
            <%--            <div id="image_frame"></div>--%>

            <!--
            <div class="w3-container w3-card w3-white w3-round w3-margin" id="post"><br>
                <img src="/w3images/avatar2.png" alt="Avatar" class="w3-left w3-circle w3-margin-right" style="width:60px">

                <span id="utime" class="w3-right w3-opacity">1 min</span>
                <label for="uid">Post ID: </label>
                <span id="uid">Post id</span><br>
                <label for="utitle">Title: </label>
                <span id="utitle"></span><br>
                <div id="image_frame"></div>
                <hr class="w3-clear">
                <%--                <label for="ucontent"></label>>--%>
                <span id="ucontent"> </span>
                <img src="" style="width:100%" class="image" id="image">
                <div class="w3-row-padding" style="margin:0 -16px">
                    <label for="ucategory">Category: </label>
                    <div class="w3-half" id="ucategory">
                        <img src="/w3images/lights.jpg" style="width:100%" alt="Northern Lights" class="w3-margin-bottom">
                    </div>
                    <label for="utag">In Mode: </label>
                    <div class="w3-half" id="utag">
                        <img src="/w3images/nature.jpg" style="width:100%" alt="Nature" class="w3-margin-bottom">
                    </div>
                </div>

                <button type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-thumbs-up"></i>  Like</button>
                <button type="button" class="w3-button w3-theme-d2 w3-margin-bottom"><i class="fa fa-comment"></i>  Comment</button>
                <br/>
                <button id="show" type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-delete"></i>  Update</button>
                <button id="del" type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-delete"></i>  Delete</button>
                <div class="center hideform updateImageEdit">
                    <button id="close" style="float: right;">X</button>
                    <form id="formUpdate" action="ImageUploadServlet"
                          method="post"
                          enctype="multipart/form-data">

                        <p id="u-title" contenteditable="true" class="w3-border w3-padding"/>
                        <p id="u-content" contenteditable="true" class="w3-border w3-padding">Status: Freedom</p>
                        <label for="u-category">Category</label>

                        <select id="u-category" class="inline">
                            <option selected>General</option>
                            <option>Traveling</option>
                            <option>Discussion</option>
                            <option>Question</option>
                        </select>
                        <label for="u-tags">Feeling</label>
                        <select id="u-tags">
                            <option selected>Happy</option>
                            <option>Sad</option>
                            <option>Confuse</option>
                            <option>Nothing</option>
                        </select>
                        <br/>
                        <label for="u-image" class="btn">Upload Photo</label>
                        <input type="file" name="imageUpload" src="" id="u-image" accept="image/*" />
                        <input id="upd" type="button" value="Update"></form>
                    <%--                    <input type="hidden" value="false" id="isValid">--%>
                    <%--                    <input class="open-form" type="button" value="Submit" id="upd">--%>

                    </form>
                </div>

            </div>
            -->
            <div id="all-post"></div>

            <div class="center hideform updateImageEdit update-userinfo-modal" id="modalUpdateUser">
                <button id="close" style="float: right;">X</button>
                <form id="formUpdate" action="ImageUploadServlet"
                      method="post"
                      enctype="multipart/form-data">
                    <input id="u-id" type="text" style="display: none" />
                    <p id="u-title" contenteditable="true" class="w3-border w3-padding"/>
                    <p id="u-content" contenteditable="true" class="w3-border w3-padding">Status: Freedom</p>
                    <label for="u-category">Category</label>

                    <select id="u-category" class="inline">
                        <option selected>General</option>
                        <option>Traveling</option>
                        <option>Discussion</option>
                        <option>Question</option>
                    </select>
                    <label for="u-tags">Feeling</label>
                    <select id="u-tags">
                        <option selected>Happy</option>
                        <option>Sad</option>
                        <option>Confuse</option>
                        <option>Nothing</option>
                    </select>
                    <br/>
                    <label for="u-image" class="btn">Upload Photo</label>
                    <input type="file" name="imageUpload" src="" id="u-image" accept="image/*" />
                    <input onclick="onUpdate()" type="button" value="Update"></form>
                <%--                    <input type="hidden" value="false" id="isValid">--%>
                <%--                    <input class="open-form" type="button" value="Submit" id="upd">--%>

                </form>
            </div>




            <!-- End Middle Column -->
        </div>

        <!-- Right Column -->
        <div class="w3-col m2">
            <div class="w3-card w3-round w3-white w3-center">
                <div class="w3-container">
                    <p>Upcoming Events:</p>
                    <img src="" alt="Forest" style="width:100%;">
                    <p><strong>Holiday</strong></p>
                    <p>Friday 15:00</p>
                    <p><button class="w3-button w3-block w3-theme-l4">Info</button></p>
                </div>
            </div>
            <br>

            <div class="w3-card w3-round w3-white w3-center">
                <div class="w3-container">
                    <p>Friend Request</p>
                    <img src="resources/images/avatar.jpeg" alt="Avatar" style="width:50%"><br>
                    <span>Jane Doe</span>
                    <div class="w3-row w3-opacity">
                        <div class="w3-half">
                            <button class="w3-button w3-block w3-green w3-section" title="Accept"><i class="fa fa-check"></i></button>
                        </div>
                        <div class="w3-half">
                            <button class="w3-button w3-block w3-red w3-section" title="Decline"><i class="fa fa-remove"></i></button>
                        </div>
                    </div>
                </div>
            </div>
            <br>

            <div class="w3-card w3-round w3-white w3-padding-16 w3-center">
                <p>ADS</p>
            </div>
            <br>

            <div class="w3-card w3-round w3-white w3-padding-32 w3-center">
                <p><i class="fa fa-bug w3-xxlarge"></i></p>
            </div>

            <!-- End Right Column -->
        </div>

        <!-- End Grid -->
    </div>

    <!-- End Page Container -->
</div>
<br>

<!-- Footer -->
<%@include file="footer.jsp"%>


<script>
    // Accordion
    function myFunction(id) {
        var x = document.getElementById(id);
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
            x.previousElementSibling.className += " w3-theme-d1";
        } else {
            x.className = x.className.replace("w3-show", "");
            x.previousElementSibling.className =
                x.previousElementSibling.className.replace(" w3-theme-d1", "");
        }
    }

    // Used to toggle the menu on smaller screens when clicking on the menu button
    function openNav() {
        var x = document.getElementById("navDemo");
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
        } else {
            x.className = x.className.replace(" w3-show", "");
        }
    }
</script>

</body>
</html>

