<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>iTravel</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="resources/css/register.css" type="text/css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<%--    <script src="/resources/js/countries.js" type="text/javascript"></script>--%>
    <script src="${pageContext.request.contextPath}/resources/js/register.js" type="text/javascript"></script>


</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Itravel</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Activities</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#" data-toggle="modal" data-target="#login-modal"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
        <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
            <div class="modal-dialog">
                <div class="loginmodal-container">
                    <h1>Login to Your Account</h1><br>
                    <form>
                        <input type="text" name="user" placeholder="Username"/>
                        <input type="password" name="pass" placeholder="Password"/>
                        <input type="submit" name="login" class="login loginmodal-submit" value="Login"/>
                    </form>

                    <div class="login-help">
                        <a href="#">Register</a> - <a href="#">Forgot Password</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</nav>

<!--First container-->
<div class="container-fluid bg-1 text-center">
    <h1 class="margin">Welcome to Itravel</h1>
    <div class="circle" >
        <div class="center">
            <form id="formID" action="RegisterServlet" method="post" >
                <div class="step1 step_panel">
                    <h3>Itravel, the best place to connect with travellers</h3>
                    <!--h4>Find your partner here</h4-->
                    <label for="fname">I am</label>
                    <select name="gender" id ="gender">
                        <option value="woman">Woman</option>
                        <option value="man">Man</option>
                        <option value="Other">Other</option>
                    </select>
                    <div>
                        <input type="button" value="Join now" onclick="updateStep('step2')" />
                    </div>
                </div>
                <div class="step2 step_panel" style="display:none">
                    <p>I live in</p>
                    <div align="center">
                        <lable for="state">State</lable>
                        <input name="state" id="state" class="form-control" placeholder="Your state"/>
                        <lable for="city">City</lable>
                        <input name="city" id="city" class="form-control" placeholder="Your city"/>
                        <lable for="street">Street</lable>
                        <input name="street" id="street" class="form-control" placeholder="Your street"/>
                        <lable for="zip">Zip Code</lable>
                        <input name="zip" id="zip" class="form-control" placeholder="Your zipcode"/>
                    </div>
                    <div>
                        <input type="button" value="Next" onclick="updateStep('step3')" />
                    </div>
                </div>
                <div class="step3 step_panel" style="display: none;">
                    <h4>Informations</h4>
                    <label for="fname">User Name</label>
                    <input name="fname" type="text" id="fname" class="form-control" placeholder="Your name..">
                    <label for="email">Email</label>
                    <input name = "email" type="email" id="email" class="form-control" placeholder="Your email..">
                    <label for="email">Confirm your Email</label>
                    <input name="email1" type="email" id="email1" class="form-control" placeholder="Your email..">
                    <label for="pwd">Password</label>
                    <input name="pwd" type="password" class="form-control" id="pwd" placeholder="Your password..">
                    <label id="bday">Brith day</label>


                    <label class="select-inline">
                        <select name='day' id='day'>
                            <option value='1'>1</option>
                            <option value='2'>2</option>
                            <option value='3'>3</option>
                            <option value='4'>4</option>
                            <option value='5'>5</option>
                            <option value='6'>6</option>
                            <option value='7'>7</option>
                            <option value='8'>8</option>
                            <option value='9'>9</option>
                            <option value='10'>10</option>
                            <option value='11'>11</option>
                            <option value='12'>12</option>
                            <option value='13'>13</option>
                            <option value='14'>14</option>
                            <option value='15'>15</option>
                            <option value='16'>16</option>
                            <option value='17'>17</option>
                            <option value='18'>18</option>
                            <option value='19'>19</option>
                            <option value='20'>20</option>
                            <option value='21'>21</option>
                            <option value='22'>22</option>
                            <option value='23'>23</option>
                            <option value='24'>24</option>
                            <option value='25'>25</option>
                            <option value='26'>26</option>
                            <option value='27'>27</option>
                            <option value='28'>28</option>
                            <option value='29'>29</option>
                            <option value='30'>30</option>
                            <option value='31'>31</option>
                        </select>
                    </label>
                    <label class="select-inline">
                        <select name='month' id='month'>
                            <option value='1'>1</option>
                            <option value='2'>2</option>
                            <option value='3'>3</option>
                            <option value='4'>4</option>
                            <option value='5'>5</option>
                            <option value='6'>6</option>
                            <option value='7'>7</option>
                            <option value='8'>8</option>
                            <option value='9'>9</option>
                            <option value='10'>10</option>
                            <option value='11'>11</option>
                            <option value='12'>12</option>
                        </select>
                    </label>
                    <label class="select-inline">
                        <select name='year' id='year'>
                            <option value='1947'>1947</option>
                            <option value='1948'>1948</option>
                            <option value='1949'>1949</option>
                            <option value='1950'>1950</option>
                            <option value='1951'>1951</option>
                            <option value='1952'>1952</option>
                            <option value='1953'>1953</option>
                            <option value='1954'>1954</option>
                            <option value='1955'>1955</option>
                            <option value='1956'>1956</option>
                            <option value='1957'>1957</option>
                            <option value='1958'>1958</option>
                            <option value='1959'>1959</option>
                            <option value='1960'>1960</option>
                            <option value='1961'>1961</option>
                            <option value='1962'>1962</option>
                            <option value='1963'>1963</option>
                            <option value='1964'>1964</option>
                            <option value='1965'>1965</option>
                            <option value='1966'>1966</option>
                            <option value='1967'>1967</option>
                            <option value='1968'>1968</option>
                            <option value='1969'>1969</option>
                            <option value='1970'>1970</option>
                            <option value='1971'>1971</option>
                            <option value='1972'>1972</option>
                            <option value='1973'>1973</option>
                            <option value='1974'>1974</option>
                            <option value='1975'>1975</option>
                            <option value='1976'>1976</option>
                            <option value='1977'>1977</option>
                            <option value='1978'>1978</option>
                            <option value='1979'>1979</option>
                            <option value='1980'>1980</option>
                            <option value='1981'>1981</option>
                            <option value='1982'>1982</option>
                            <option value='1983'>1983</option>
                            <option value='1984'>1984</option>
                            <option value='1985'>1985</option>
                            <option value='1986'>1986</option>
                            <option value='1987'>1987</option>
                            <option value='1988'>1988</option>
                            <option value='1989'>1989</option>
                            <option value='1990'>1990</option>
                            <option value='1991'>1991</option>
                            <option value='1992'>1992</option>
                            <option value='1993'>1993</option>
                        </select>
                    </label>
                    <input id ="btnRegister" type="button" value="Next" />
<%--                    <input type="reset" value="Reset"/>--%>
                </div>
            </form>
        </div>
    </div>
</div>


<!--second container-->
<div class="container-fluid bg-2 text-center">
    <h3 class="margin">What are you looking for?</h3>
    <p>Are you looking for a partner or a friend to travel with? Let come with us and try</p>
    <a href="#" class="btn btn-default btn-lg">
        <span class="glyphicon glyphicon-search"></span>Search</a>
</div>
<!-- Footer -->
<footer class="container-fluid bg-4 text-center">
    <p>Website made By <a href="#">Hieu Le, Ha Le and Hailian</a></p>
</footer>
<!--<img src="dating-quotes-2.jpg" class="img-responsive" alt="Cinque Terre" width="1300" height="700">-->
</body>
</html>
