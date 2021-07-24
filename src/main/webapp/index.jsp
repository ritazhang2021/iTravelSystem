<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="resources/css/page-user.css" rel="stylesheet" type="text/css">
    <link href="resources/css/main.css" rel="stylesheet" type="text/css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="resources/js/common.js"></script>
    <script type="text/javascript" src="resources/js/lib.js"></script>
    <link href="resources/css/admin.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript" src="resources/js/loginAjax.js"></script>
<!--
    <script type="text/javascript" src="resources/js/initDataAjax.js"></script>
    -->
    <title>iTravel</title>
</head>

<body id="home" class=" client-js" style="">
  <%@include file="headerNone.jsp"%>

<div id="test-body-mobile">
    <div id="contentHead">
        <h1>Login Form</h1>
        <hr>
    </div>
    <div id="contentBody">
        <form name="loginForm" method="post" action="loginServlet">
            Using for log in:
            admin/admin or user/user
            <table class="table">
                <tr>
                    <td><label for="txtUserName">Email</label></td>
                    <td><input type="text" id="txtUserName" name="txtUserName" value="user"></td>
                </tr>
                <tr>
                    <td><label for="txtPassword">Password</label></td>
                    <td><input type="password" id="txtPassword" name="txtPassword" value="user"></td>
                </tr>
                <tr>
                    <td><input type="submit" id="btnLogin" name="btnLogin" value="LOGIN"></td>
                    <td><label>Not a member?</label><a href="signupForm.jsp">Signup Now</a></td>
                </tr>
            </table>

        </form>

    </div>

</div>
  <div align="center">
      <hr>
      <h2>iTRAVEL PROJECT - WAP COURSE 11/2020</h2>
      <h3>Our team name: Orange</h3>
      <hr>
      <h3>
          <ul>
              <li>Le Hieu Le</li>
              <li>Hailian Zhang</li>
              <li>Thu Ha Le Dang</li>
          </ul>
      </h3>
      <hr>
      <h2>Thank you professor: miss Tina Xing</h2>

  </div>
<%--  <%@include file="footer.jsp"%>--%>
</body>
</html>