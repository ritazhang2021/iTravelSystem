<%--
  Created by IntelliJ IDEA.
  User: J&C
  Date: 11/12/2020
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="resources/css/page-user.css" rel="stylesheet" type="text/css">
    <link href="resources/css/main.css" rel="stylesheet" type="text/css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="resources/js/ShowUserListAjax.js"></script>
    <script type="text/javascript" src="resources/js/common.js"></script>
    <script type="text/javascript" src="resources/js/lib.js"></script>

    <title>iTravel</title>
</head>

<body id="home" class=" client-js" style="">
<%@include file="adminHeader.jsp"%>
<div id="test-body-mobile">
    <div id="contentHead">
        <h1>Admin Main Page</h1>
    </div>
    <div id="contentBody">
        <div>Search: <input type="text" id="myInput"/></div>
        <hr/>
        <div id="updMemberForm">
            <form>
                <table>
                    <tr><td><label for="id">User ID</label></td><td><input type="text" id="id" name="id"></td></tr>
                    <tr><td><label for="title">User Name</label></td><td><input type="text" id="title" name="title"></td></tr>
                    <tr><td><label for="author">User Eail</label></td><td><input type="text" id="author" name="author"></td></tr>
                    <tr><td><label for="subject">User Type</label></td><td><input type="text" id="subject" name="subject"></td></tr>
                    <tr><td><label for="isbn">ActiveType</label></td><td><input type="text" id="isbn" name="isbn"></td></tr>
                    <tr><td></td><td>
                        <input type="hidden" value="false" id="isValid">
                        <input type="button" value="Add" id="add">
                        <input type="button" value="Update" id="upd">
                        <input type="button" value="Delete" id="del">

                    </td></tr>

                </table>
            </form>
        </div>
        <div id="tabsHistory" class="tabs autohash ui-tabs ui-corner-all ui-widget ui-widget-content">

            <div id="humans" aria-labelledby="ui-id-1" role="tabpanel"
                 class="ui-tabs-panel ui-corner-bottom ui-widget-content" aria-hidden="false"
                 style="display: block;">

                <table class="changeHistory" id="users">
                    <thead>
                    <tr>
                        <th>User ID</th>
                        <th>User Name</th>
                        <th>User Eail</th>
                        <th>User Type</th>
                        <th>ActiveType</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody id="myTable">
                    </tbody>
                </table>
                <div>
                    <input id="prePage" size=" "  name="prePageButton" type="button" value="Previous Page"/>
                    <input id="nextPage"  size=" " name="nextPage" type="button" value="Next Page"/>
                </div>

                <div class="historyPager small sansserif gray">
                </div>
            </div>
        </div>
    </div>
</div>


<div class="clearfix"></div>


<footer>

    <div>
        <!--
        配置xml文件
        <servlet>
        <servlet-name>BookServlet</servlet-name>
        <servlet-class>com.atguigu.web.BookServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>BookServlet</servlet-name>
        <url-pattern>/manager/bookServlet</url-pattern>
    </servlet-mapping>
        -->

    </div>

    <div id="footer-content">
        <hr>
    </div>

</footer>
<!--
<div id="cboxOverlay" style="display: none;"></div>
<div id="colorbox" class="" role="dialog" tabindex="-1" style="display: none;">
    <div id="cboxWrapper">
        <div>
            <div id="cboxTopLeft" style="float: left;"></div>
            <div id="cboxTopCenter" style="float: left;"></div>
            <div id="cboxTopRight" style="float: left;"></div>
        </div>
        <div style="clear: left;">
            <div id="cboxMiddleLeft" style="float: left;"></div>
            <div id="cboxContent" style="float: left;">
                <div id="cboxTitle" style="float: left;"></div>
                <div id="cboxCurrent" style="float: left;"></div><button type="button"
                      id="cboxPrevious"></button><button type="button" id="cboxNext"></button><button
                    id="cboxSlideshow"></button>
                <div id="cboxLoadingOverlay" style="float: left;"></div>
                <div id="cboxLoadingGraphic" style="float: left;"></div>
            </div>
            <div id="cboxMiddleRight" style="float: left;"></div>
        </div>
        <div style="clear: left;">
            <div id="cboxBottomLeft" style="float: left;"></div>
            <div id="cboxBottomCenter" style="float: left;"></div>
            <div id="cboxBottomRight" style="float: left;"></div>
        </div>
    </div>
    <div style="position: absolute; width: 9999px; visibility: hidden; display: none; max-width: none;"></div>
</div>
-->
</body>

</html>