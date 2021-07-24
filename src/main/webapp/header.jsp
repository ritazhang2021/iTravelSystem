<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="topNotice">
    <div class="page-banner page-banner-black page-banner-center">
        <div class="iaBar">
            <div class="iaBarLogo">
                <img alt="Additional Features" src="resources/images/Additional Features.svg"
                     width="160">
            </div>
<!--            <div class="iaBarMessage">
                <a class="ghost-btn" href="ReportServlet" target="_blank">Overdue Reports</a>
            </div>
-->
        </div>
    </div>
</div>


<header id="header-bar" class="header-bar">
    <div class="hamburger-component">
        <button type="button" class="hamburger-button"><img src="resources/images/menu.png"
                                                            alt="additional options menu"></button>
        <div class="hamburger-dropdown-component navigation-dropdown-component">
            <ul class="dropdown-menu hamburger-dropdown-menu">
                <li class="more-menu"><a href="bookList.jsp">Books</a></li>
                <li class="more-menu"><a href="bookList.jsp">Members</a></li>
                <li class="more-menu"><a href="BorrowServlet">Borrows</a></li>
                <li class="more-menu"><a href="searchFunction.jsp">Search</a></li>

            </ul>
        </div>
    </div>

    <div class="logo-component">
        <a href="index.jsp" title="iTravel 2020">
            <div class="logo-txt">
                <img class="logo-icon" src="resources/images/Library Management System.svg" width="194" height="47"
                     alt="Open Library logo">
            </div>
        </a>
    </div>


    <ul class="navigation-component">
        <li class="more-menu"><a href="bookList.jsp">Books</a></li>
        <li class="more-menu"><a href="memberList.jsp">Members</a></li>
        <li class="more-menu"><a href="BorrowServlet">Borrows</a></li>
        <li class="more-menu"><a href="searchFunction.jsp">Search</a></li>
    </ul>


</header>

