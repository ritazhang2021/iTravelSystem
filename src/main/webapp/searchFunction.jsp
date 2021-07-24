<%@page import="itravel.model.DataFactory,itravel.model.Data" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="itravel.model._Post" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%
    List<_Post> sessBorrowList = DataFactory.getInstance().get_PostList();
//    if ( request.getSession().getAttribute("borrowList") != null) {
//        sessBorrowList = (List<Borrow>) request.getSession().getAttribute("borrowList");
//    }
%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="resources/css/page-user.css" rel="stylesheet" type="text/css">
<%--    <link href="resources/images/main.css" rel="stylesheet" type="text/css">--%>

    <meta name="description"
        content="iTravell 2020">


    <title>Welcome to iTravel 2020</title>


</head>




<body id="home" class=" client-js" style="background-color: azure">
<%@include file="header.jsp"%>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/common.js"></script>
<script type="text/javascript" src="resources/js/lib.js"></script>

<div id="test-body-mobile" class="table-responsive table-body">
    <div class="container">
        <h1>Search Form</h1>
        <p><label for="name">Enter some text: </label><input id='name' type='text' name='name'/>
            <button id='btnBook' type='button' value='book'>Search Book</button>
            <button id='btnMember' type='button' value='member'>Search Member</button>
            <a href="index.jsp">Back Home</a>
        </p>
        <p>
        <table class="table table-responsive">
            <thead>
            <tr>
                <th id="id" style="width:1px; white-space:nowrap;"></th>
                <th id="f1" style="width:1px; white-space:nowrap;"></th>
                <th id="f2" style="width:1px; white-space:nowrap;"</th>
                <th id="f3" style="width:1px; white-space:nowrap;"></th>
            </tr>
            </thead>
            <tbody id="list">
            </tbody>
        </table>
        <nav aria-label="Page navigation">
            <ul class="pagination pg-blue" id="pagination">
            </ul>
        </nav>
        </p>
    </div>
    </div>




    <div class="clearfix"></div>


    <footer>
        <div id="footer-content">

            <hr>

        </div>
    </footer>




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
</body>

</html>