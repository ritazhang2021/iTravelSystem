<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Please Login Here</h2>

<form action="login" method="post">
    <label for="txtUserName">Username:</label><br>
    <input type="text" id="txtUserName" name="txtUserName" value="user"><br>
    <label for="txtPassword">Password:</label><br>
    <input type="password" id="txtPassword" name="txtPassword" value="user"><br><br>
    <input type="submit" id="btnLogin" name="btnLogin" value="Log in">
    <label>Not a member?</label><a href="signupForm.jsp">Signup Now</a>
</form>

<c:if test="${param.error}">
    Invalid Username/Password.
</c:if>

</body>
</html>
