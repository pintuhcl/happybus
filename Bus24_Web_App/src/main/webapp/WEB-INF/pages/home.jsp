<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html ng-app="searchBusModule" ng-controller="searchBusController">
<head>
<meta charset="utf-8" />
<title>home page</title>
<!--  Bootstrap core CSS -->
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<!-- <link href="webjars/bootstrap/3.3.5/css/bootstrap.theme.min.css" /> -->

<link href="css/styles.css" rel="stylesheet">


<!-- <script type="text/javascript" src="js/jquery.slider.min.js"></script> -->
<!-- <script type="text/javascript" src="js/cycle.js"></script> -->

<script src="js/angular.js" type="text/javascript"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/jquery-ui.js" type="text/javascript"></script>
<script src="js/ui-bootstrap-tpls.min.js"></script>


<script src="js/search_bus.js" type="text/javascript"></script>
`
<link type="text/css" href="css/bootstrap.css" rel="stylesheet" />
<link type="text/css" href="css/styles.css" rel="stylesheet" />
<link type="text/css" href="css/jquery-ui.css" rel="stylesheet" />



<script type="text/javascript">
// 	$(document).ready(function() {
// 		$('.pics').cycle({
// 			fx : 'fade',
// 			width : 500,
// 			height : 300,
// 			timeout : 4000
// 		});
// 	});
</script>

<style>
.otherInfo {
	/* 	margin-top: 20px; */
	display: inline;
}

.jumbotron {
	color: #fff;
	background-color: #428bca;
	min-width: 700px;
	/* 	background-color: #d9edf7; */
	/* 	background-color: #dff0d8; */
}
</style>

<style type="text/css">
.pics {
	height: 100px;
	width: 100px;
}

.pics img {
	height: 330px;
	width: 500px;
}
</style>

</head>
<body>
	<!--Navigation bar -->
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container">
			<div class="row">
				<div class="page-header">
					<img class="hb-ddown" style="float: left;" src="images/bus6.jpg"
						width="600px" height="190px"> <img class="hb-ddown"
						style="float: left;" src="images/bus6.jpg" width="570px"
						height="190px">
				</div>
			</div>
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-container">
					<span class="sr-only">Bus24 </span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"> <marquee behavior="scroll"
						direction="right" scrollamount="12">
						<span style="margin: 30%;"> <img src="images/bus_logo.png"
							alt="Bus24" width="100"/ >
						</span>
					</marquee> <!-- <font face="Roboto Condensed" size="6" color="green"> </font> -->
				</a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-container">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="/Bus24/" class="list-group-item">Home</a></li>
					<li><a href="loginUser" class="list-group-item">Register</a></li>
					<li><a href="loginUser" class="list-group-item">login</a></li>
					<li><a href="#" class="list-group-item">cancelTicket</a></li>
					<li><a href="#" class="list-group-item">PrintTicket</a></li>
					<li><a href="#" class="list-group-item">ContactUs</a></li>
					<li><a href="#" class="list-group-item">AboutUs</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<%@include file="searchPassengerBus.jsp"%>

	<div class="container">
		<!--Container -->
		<div class="row">
			<div class="jumbotron " style="background-color: #1bed3e;">
				<div class="col-md-4">
					<div class="nav nav-pills ">
						<div class="row">
							<div class="col-xs-6">
								<div class="pics">
									<img src="images/800px_COLOURBOX1510671.jpg" width="970"
										height="300" /> <img src="images/busSlide8.jpg" width="100"
										height="100" /> <img src="images/busSlide2.jpg" width="100"
										height="100" /> <img src="images/busSlide3.jpg" width="100"
										height="100" /> <img src="images/busSlide4.jpg" width="100"
										height="100" /> <img src="images/busSlide5.jpg" width="100"
										height="100" />

								</div>
							</div>

						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- Footer -->
	<footer class="mojFooter">
		<font face="Roboto Condensed" size="4">
			<div class="container">
				<div class="row" style="margin-top: 7px;">
					<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &copy;2017 Bus24
						App Design by: SATHISH BANDI</p>
				</div>
				<div class="bottom-footer">
					<div class="col-md-12">
						<ul class="footer-nav">
							<li><a href="#/"><img src="images/faqLogo.jpg"
									width="50" height="50"> </a></li>
							<li><a href="https://www.facebook.com/"><img
									src="images/fbLogo.png" width="50" height="50"> </a></li>
							<li><a href="https://twitter.com/"><img
									src="images/twlogo.png" width="50" height="50"> </a></li>
							<li><a href="https://plus.google.com/"> <img
									src="images/glLogo.png" width="50" height="50">
							</a></li>
						</ul>
					</div>
				</div>
			</div>
			</center>

		</font>

	</footer>
</body>
</html>