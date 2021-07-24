<%--
  Created by IntelliJ IDEA.
  User: Le Hieu Le
  Date: 07-Nov-20
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
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
<!--            <ul class="dropdown-menu hamburger-dropdown-menu">
                  <li class="more-menu"><a href="bookList.jsp">11. Weather Service</a></li>
            </ul>
-->        </div>
    </div>

    <div class="logo-component">
        <a href="homePage.jsp" title="iTravel 2020">
            <div class="logo-txt">
                <img class="logo-icon" src="resources/images/itravel2020.svg" width="194" height="47"
                     alt="Open Library logo">
            </div>
        </a>
    </div>


    <ul class="navigation-component">
        <li class="more-menu"><a href="userTravelInfo.jsp">1. Search Post</a></li>
        <li class="more-menu"><a href="userTravelInfo.jsp">2. Travel Info</a></li>
        <li class="more-menu"><a href="userTravelInfo.jsp">3. Follow/Unfollow Other Traveller</a></li>
        <li class="more-menu"><a href="userTravelInfo.jsp">4. See latest 10 Post</a></li>
        <li class="more-menu"><a href="userTravelInfo.jsp">5. Pagination for each 10 post</a></li>
        <li class="more-menu"><a href="userPostManagement.jsp">6. Add a post</a></li>
        <li class="more-menu"><a href="userPostManagement.jsp">7. Delete a post</a></li>
        <li class="more-menu"><a href="userTravelInfo.jsp">8. Choose Notify to make a post</a></li>
        <li class="more-menu"><a href="userTravelInfo.jsp">9. Like/Dislike a post</a></li>
        <li class="more-menu"><a href="userTravelInfo.jsp">10. Comment</a></li>
        <li class="more-menu"><a href="userWeatherService.jsp">11. Weather Service</a></li>
    </ul>


</header>

