<%--
Created by: Hieu Le, Ha Le, Hailian Zhang
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="about.jsp">Itravel</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="homePage.jsp">Home</a></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="userPostManagement.jsp">"Post Management"</a></li>
                <li><a href="userCommentManagement.jsp">"Comment Management"</a></li>
                <li><a href="userFollowManagement.jsp">"Follower List"</a></li>
                <li><a href="userWeatherService.jsp">Weather</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul>
        </div>
    </div>
</nav>
