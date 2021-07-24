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

    <link href="resources/css/admin.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript" src="resources/js/UserFollowMnAjax.js"></script>

</head>
<body>
<%@include file="userMenuBar.jsp"%>

<div class="container-fluid text-center">
    <div class="row content">
        <%@include file="userLContent.jsp"%>
        <!-- Main content -->
        <div class="col-md-8 text-left">
            <h1>FOLLOW MANAGEMENT</h1>
            <hr/>
            <div>
                <div>Search: <input type="text" id="myInput"/></div>
                <hr/>
                <div id="updFollowForm">
                    <form>
                        <table>
                            <tr>
                                <td><label for="id">ID</label><br>
                                    <input type="text" id="id" name="id">
                                </td>
                                <td><label for="travellerId">Traveller ID</label><br>
                                    <input type="text" id="travellerId" name="travellerId">
                                </td>
                                <td><label for="userId">User ID</label><br>
                                    <input type="text" id="userId" name="userId">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="hidden" value="false" id="isValid">
                                    <input type="button" value="Add" id="add">
                                </td>
                                <td><input type="button" value="Update" id="upd">
                                </td>
                                <td><input type="button" value="Delete" id="del">
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
                <!-- List Display -->
                <hr/>
                <div>
                    <table id="follows" class="table">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>TRAVELLER ID</th>
                            <th>USER ID</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody id="myTable">
                        </tbody>
                    </table>
                </div>

            </div>

        </div>
        <!-- End Main content -->
        <%@include file="userRContent.jsp"%>
    </div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>
