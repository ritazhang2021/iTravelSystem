<!DOCTYPE html>
<html lang="en">
<head>
    <title>User Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <link href="resources/css/user.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript" src="resources/js/userTravelInfo.js"></script>
</head>
<body>
<%@include file="userMenuBar.jsp"%>

<div class="container-fluid text-center">
    <div class="row content">
        <%@include file="userLContent.jsp"%>
        <!-- Main content -->
        <div class="col-md-8 text-left">
            <h1>User</h1>
        </div>

        <!-- End Main content -->
        <%@include file="userRContent.jsp"%>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
