<%--
  Created by IntelliJ IDEA.
  User: J&C
  Date: 11/12/2020
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <script type="text/javascript" src="resources/js/admin_PostManagement.js"></script>
    <link href="resources/css/admin.css" type="text/css" rel="stylesheet" />

</head>
<body>
<%@include file="adminMenuBar.jsp"%>

<div class="container-fluid text-center">
    <div class="row content">
        <%@include file="adminLContent.jsp"%>
        <!-- Main content -->
        <div class="col-md-8 text-left">
            <h1>USER MANAGEMENT</h1>
            <hr/>
            <div>
                <div>Search: <input type="text" id="myInput"/></div>
                <!-- List Display -->
                <hr/>
                <div>
                    <table id="users" class="table">
                        <thead>
                        <tr>
                            <th>User ID</th>
                            <th>User Title</th>
                            <th>Contant</th>
                            <th>Category</th>
                            <th>Tags</th>
                            <th>Date</th>
                            <th>IsHeath</th>
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
                </div>

            </div>

        </div>
        <!-- End Main content -->
        <%@include file="adminRContent.jsp"%>
    </div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>
