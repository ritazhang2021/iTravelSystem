<!DOCTYPE html>
<html lang="en">
<head>
	<title>My profile</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/userTravelInfo.js"></script>
<%--	<script type="text/javascript" src="resources/js/userPostMn.js"></script>--%>
	<link href="resources/css/userinfo.css" type="text/css" rel="stylesheet" />

	<%--	 <script src="register.js" type="text/javascript"></script>--%>

</head>
<body>
<%@include file="userMenuBar.jsp"%>
<div class="container-fluid text-center">
	<div class="row content">
		<%@include file="userLContent.jsp"%>
		<div class="col-md-8 text-left">

			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">Upload your photo here</h3>
						</div>

						<div class="panel-body">
							<div class="row">
								<div class="col-md-5">

									<div class="file_input_wrap">
										<form  id="formAdd" action="ImageUploadServlet"
											   method="post"
											   enctype="multipart/form-data">
<%--											<label for="image" class="btn">Upload Photo</label>--%>
<%--											<input type="file" name="imageUpload" src="" id="image" accept="image/*" />--%>
										<input type="file" name="imageUpload" src="resources/images/bg/avatar.jpeg" id="imageUpload" class="hide" accept="image/*" />
										<label for="imageUpload" class="btn btn-large">Select file</label>
										<input type="button" value="Submit"/>
										</form>
									</div>
									<div class="img_preview_wrap">
										<img src="resources/images/bg/avatar.jpeg" id="imagePreview" alt="Preview Image" width="200px" />
									</div>

									<%--								<img id="photo" alt="User Pic" src="resources/images/bg/avatar.jpeg" class="img-circle img-responsive">--%>
									<%--                		--%>
									<%--                				<input id="myfile" type="file" value="Upload" onclick="chooseFile();" class = "hide">--%>
									<%--								<input id="upload" type="button" value="Upload" onclick="uploadPhoto();">--%>
								</div>


								<div class="col-md-7">
									<table class="userinfo table">
										<tr><td><label for="id">User ID</label></td><td><span id="id"></span></td></tr>
										<tr><td><label for="name">Name</label></td><td><span id="name"></span></td></tr>
										<tr><td><label for="gender">Gender</label></td><td><span id="gender" ></span></td></tr>
										<tr><td><label for="year">Year Of Birth</label></td><td><span id="year"></span></td></tr>
										<tr><td><label for="email">Email</label></td><td><span id="email" ></span></td></tr>
										<tr><td><label for="pwd">Password</label></td><td><input id="pwd" type="password" readonly></input></td></tr>
										<tr><td><label for="address">Address</label></td><td><span id="address"></span></td></tr>
										<tr><td></td><td>
											<input type="hidden" value="false" id="isValid">
											<input class="open-form" type="button" value="Edit" id="show">
											<%--										<button id="show">Show form</button>--%>
										</td></tr>
									</table>
								</div>
							</div>

							<div class="center hideform update-userinfo-modal">
								<button id="close" style="float: right;">X</button>
								<div class="clearfix">&nbsp;</div>
								<form action="">

									<label for="ename">Name</label>
									<input id="ename" type="text" required/>
									<label for="egender">Gender</label>
									<select name="egender" id ="egender">
										<option value="woman">Woman</option>
										<option value="man">Man</option>
										<option value="Other">Other</option>
									</select>
									<br/>
									<%--								<input id="egender" type="text">--%>
									<label for="ebirthyear">Year Of Birth</label>
									<%--								<input id="ebirthyear" type="text">--%>
									<label class="select-inline">
										<select name='year' id='ebirthyear'>
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
									<br/>
									<label for="eemail">Email</label>
									<input id="eemail" type="email" readonly/>
									<label for="epassword">Password</label>
									<input id="epassword" type="password"/>
									<label for="estate">State</label>
									<input id="estate" type="text" required/>
									<label for="ecity">City</label>
									<input id="ecity" type="text" required/>
									<label for="estreet">Street</label>
									<input id="estreet" type="text" required/>
									<label for="ezip">Zip code</label>
									<input id="ezip" type="text" required/>
									<input id="editinfo" type="button" value="Submit">
								</form>
							</div>
							<%--						<button id="show">Show form</button>--%>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<!--create 2 tabs for introduction and photo-->
					<div class="container">

						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" href="#home">Introduction</a></li>
							<li><a data-toggle="tab" href="#menu1">Photo</a></li>
						</ul>

						<div class="tab-content">
							<div id="home" class="tab-pane fade in active">

								<span id="intro">Introduce your self</span><br>
								<form>
									<textarea></textarea>
									<br>
									<input type="button" value="Submit">
								</form>

								<div id="menu1" class="tab-pane fade">
									<h3>Upload your photo</h3>
									<form action="">
										<input type="file" name="pic" accept="image/*">
										<br>
										<input type="submit">
									</form>
								</div>

							</div>
						</div>

					</div>
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
