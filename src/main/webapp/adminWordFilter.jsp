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
    <script type="text/javascript" src="resources/js/WordFilterAjax.js"></script>

</head>
<body>
<%@include file="adminMenuBar.jsp"%>

<div class="container-fluid text-center">
    <div class="row content">
        <%@include file="adminLContent.jsp"%>
        <!-- Main content -->
        <div class="col-md-8 text-left">
            <h1>DEFINE WORD FILTER</h1>
            <hr/>
            <div>
                <div>Search: <input type="text" id="myInput"/></div>
                <hr/>
                <div id="updMemberForm">
                    <form>
                        <table class="table">
                            <tr>
                                <td>
                                    <label for="id">ID</label><br>
                                    <input type="text" id="id" name="id">
                                </td>
                                <td>
                                    <label for="value">VALUE</label><br>
                                    <input type="text" id="value" name="value">
                                </td>
                                <td>
                                    <br>
                                    <input type="hidden" value="false" id="isValid">
                                    <input type="button" value="  Add " id="add">
                                    <input type="button" value="Update" id="upd">
                                    <input type="button" value="Delete" id="del">
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>

                <!-- List Display -->
                <hr/>
                <div>
                    <table id="wordfilters" class="table">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>VALUE</th>
                        </tr>
                        </thead>
                        <tbody>
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
