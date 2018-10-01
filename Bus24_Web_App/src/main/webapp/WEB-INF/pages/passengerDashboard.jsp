<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>PassengerDashBoard </title>
	<meta name="description" content="Wiredwiki App">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>

	<style>
	body{
		padding-top: 40px;
	}
	</style>

<body data-spy="scroll" data-target="#my-navbar">

  <!-- Navbar -->
  	<nav class="navbar navbar-inverse navbar-fixed-top" id="my-navbar">
  		<div class="container">
  			<div class="navbar-header">
  				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
  					<span class="icon-bar"></span>
  					<span class="icon-bar"></span>
  					<span class="icon-bar"></span>
  					<span class="icon-bar"></span>
  				</button>

  				<a href="" class="navbar-brand">Home</a>
  			</div><!-- Navbar Header-->
  			<div class="collapse navbar-collapse" id="navbar-collapse">
  				
  			<a href="logoutUser" class="btn btn-warning navbar-btn navbar-right">Log out</a>
  				<ul class="nav navbar-nav">
  				    <li><a href="#">PrintTicket</a>
  				    <li><a href="#">CancelTicket</a>
  					<li><a href="#feedback">Feedback</a>
  					<li><a href="#">HelpDesk</a> 
  					<li><a href="#gallery">Gallery</a> 
  					<li><a href="#">MyTrips</a>
  					<li><a href="myProfile">MyProfile</a> 
  					<li><a href="changePassword">changepassword</a>
  					<li><a href="#features">Features</a> 
  					<li><a href="#faq">Faq</a> 
  					<li><a href="#contact">ContactUs</a> 
  				</ul>
  			</div>
  		</div><!-- End Container-->
  	</nav><!-- End navbar -->

  	<!-- jumbotron-->

  	<div class="jumbotron">
  		<div class="container text-center">
  			<h1>Bus24</h1>
  			<p>A JOURNEY IS BEST,MEASURED IN FRIENDS,RATHER THAN MILES  </p>

  			<div class="btn-group">
  				<a href="" class="btn btn-lg btn-warning">Search buses</a>
  				<a href="" class="btn btn-lg btn-default">Visit store</a>
  				<a href="" class="btn btn-lg btn-warning">Book ticket</a>
  			</div>
  		</div><!-- End container -->
  	</div><!-- End jumbotron-->

  	<!-- Feedback-->
  	<div class="container">
  		<section>
  			<div class="page-header" id="feedback">
  				<h2>Feedback.<small> Check out the Awesome Feedback</small></h2>
  			</div>

  			<div class="row">
  				<div class="col-md-4">
  					<blockquote>
  						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi gravida quam ac ante rutrum, in mollis ligula mattis. Integer nulla nisi, ullamcorper et posuere vel</p>
  						<footer>John doe</footer>
  					</blockquote>
  				</div>
  				<div class="col-md-4">
  					<blockquote>
  						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi gravida quam ac ante rutrum, in mollis ligula mattis. Integer nulla nisi, ullamcorper et posuere vel</p>
  						<footer>John doe</footer>
  					</blockquote>
  				</div>
  				<div class="col-md-4">
  					<blockquote>
  						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi gravida quam ac ante rutrum, in mollis ligula mattis. Integer nulla nisi, ullamcorper et posuere vel</p>
  						<footer>John doe</footer>
  					</blockquote>
  				</div>
  			</div><!-- End row -->
  		</section>
  	</div><!--End Container-->

<!-- call to action -->
	<section>
		<div class="well">
			<div class="container text-center">
				<h3>Subscribe for more free stuff</h3>
				<p>Enter your name and email</p>

				<form action="" class="form-inline">
					<div class="form-group">
						<label for="subscription">Subscribe</label>
						<input type="text" class="form-control" id="subscription" placeholder="Your name">
					</div>
					<div class="form-group">
						<label for="email">Email address</label>
						<input type="text" class="form-control" id="email" placeholder="Enter your Email">
					</div>
					<button type="submit" class="btn btn-default">Subscribe</button>
					<hr>
				</form>


			</div><!-- end Container-->

		</div><!-- end well-->
	</section><!-- Call to action -->

<!-- Gallery -->
	<div class="container">
		<section>
			<div class="page-header" id="gallery">
  				<h2>Gallery.<small> Check out the Awesome Gallery</small></h2>
  			</div>
  			<div class="carousel slide" id="screenshot-carousel" data-ride="carousel">
  				<ol class="carousel-indicators">
  					<li data-target="#screenshot-carousel" data-slide-to="0" class="active"></li>
  					<li data-target="#screenshot-carousel" data-slide-to="1"></li>
  					<li data-target="#screenshot-carousel" data-slide-to="2"></li>
  					<li data-target="#screenshot-carousel" data-slide-to="3"></li>
  				</ol>
  				<div class="carousel-inner">
  					<div class="item active">
  						<img src="images/highway.jpg" alt="Text of the image">
  						<div class="carousel-caption">
  							<h3>Highway heading</h3>
  							<p>This is the caption</p>
  						</div>
  					</div>
  					<div class="item">
  						<img src="images/river.jpg" alt="Text of the image">
  						<div class="carousel-caption">
  							<h3>River heading</h3>
  							<p>This is the caption</p>
  						</div>
  					</div>
  					<div class="item">
  						<img src="images/street.jpg" alt="Text of the image">
  						<div class="carousel-caption">
  							<h3>Street heading</h3>
  							<p>This is the caption</p>
  						</div>
  					</div>
  					<div class="item">
  						<img src="images/painting.jpg" alt="Text of the image">
  						<div class="carousel-caption">
  							<h3>Painting heading</h3>
  							<p>This is the caption</p>
  						</div>
  					</div>

  				</div><!-- End Carousel inner -->
  				<a href="#screenshot-carousel" class="left carousel-control" data-slide="prev">
  					<span class="glyphicon glyphicon-chevron-left"></span>
  				</a>
  				<a href="#screenshot-carousel" class="right carousel-control" data-slide="next">
  					<span class="glyphicon glyphicon-chevron-right"></span>
  				</a>
  			</div><!-- End Carousel -->

		</section>
	</div>

<!-- features -->
	<div class="container">
		<section>
			<div class="page-header" id="features">
  				<h2>Features.<small> Best Bus Features</small></h2>
  			</div><!-- End Page Header -->

  			<div class="row">
  				<div class="col-sm-8">
  					<p>1) Fast and Easy online bus booking.</p>
  					<p>2) Zero booking fees No extra Charge for online booking.</p>
  					<p>3) All Credit/Debit/Internet Backing Accepted. </p>
  					<p>4) Get Tickets to your Mobile.</p>
  					<p>5) Online cancellation and phone support available. </p>
  					<p>6) The fastest way to book bus ticket.</p>
  					<p>7) 100 % Secure to book your bus tickets througth Bus24.com</p>
  				</div>
  				
  			</div><!-- End row -->
  			<hr>
		</section>
	</div><!-- End Container -->

<!-- Faq -->

    <div class="container">
      <section>
        <div class="page-header" id="faq">
          <h2>FAQ.<small> Engaging with consumers.</small></h2>
        </div><!-- End Page Header -->

        <div class="panel-group" id="accordion">
          <div class="panel panel-default">
            <div class="panel-heading">
              <div class="panel-title">
                <a href="#collapse-1" data-toggle="collapse" data-parent="#accordion">
                  Question one?
                </a>
              </div><!-- End panel title -->
              <div id="collapse-1" class="panel-collapse collapse in">
                <div class="panel-body">
                 Do i need to register on Bus24.com to book a bus ticket ?
                </div>
              </div><!-- End Panel collapse -->
            </div>
          </div>

          <div class="panel panel-default">
            <div class="panel-heading">
              <div class="panel-title">
                <a href="#collapse-2" data-toggle="collapse" data-parent="#accordion">
                  Question Two?
                </a>
              </div><!-- End panel title -->
              <div id="collapse-2" class="panel-collapse collapse">
                <div class="panel-body">
                  What are the benifits of registering on Bus24.com?
                </div>
              </div><!-- End Panel collapse -->
            </div>
          </div>

          <div class="panel panel-default">
            <div class="panel-heading">
              <div class="panel-title">
                <a href="#collapse-3" data-toggle="collapse" data-parent="#accordion">
                  Question Three?
                </a>
              </div><!-- End panel title -->
              <div id="collapse-3" class="panel-collapse collapse">
                <div class="panel-body">
                  How can i book a bus ticket ?<br>
                  Can i book a return bus ticket ?
                </div>
              </div><!-- End Panel collapse -->
            </div>
          </div>
        </div><!-- End panel group -->

      </section>
    </div><!-- End container -->


<!-- Contact -->

  <div class="container">
    <section>
      <div class="page-header" id="contact">
          <h2>Contact Us.<small> Contact us for more.</small></h2>
        </div><!-- End Page Header -->

        <div class="row">
          <div class="col-lg-4">
            <p>Send us a message, or contact us from the address below</p>


            <address>
              <strong>www.Bus24.com</strong></br>
              111, Ameerpet </br>
              Plot no. 45</br>
              Hyderabad - 500016</br>
              P: +91 9999999999
            </address>
          </div>
          
          <div class="col-lg-8">
            <form action="" class="form-horizontal">
              <div class="form-group">
                <label for="user-name" class="col-lg-2 control-label">Name</label>
                <div class="col-lg-10">
                  <input type="text" class="form-control" id="user-name" placeholder="Enter you name">
                </div>
              </div><!-- End form group -->

              <div class="form-group">
                <label for="user-email" class="col-lg-2 control-label">Email</label>
                <div class="col-lg-10">
                  <input type="text" class="form-control" id="user-email" placeholder="Enter you Email Address">
                </div>
              </div><!-- End form group -->

              <div class="form-group">
                <label for="user-url" class="col-lg-2 control-label">Your Website</label>
                <div class="col-lg-10">
                  <input type="text" class="form-control" id="user-email" placeholder="If you have Any.">
                </div>
              </div><!-- End form group -->

              <div class="form-group">
                <label for="user-message" class="col-lg-2 control-label">Any Message</label>
                <div class="col-lg-10">
                  <textarea name="user-message" id="user-message" class="form-control" 
                  cols="20" rows="10" placeholder="Enter your Message"></textarea>
                </div>
              </div><!-- End form group -->

              <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                  <button type="submit" class="btn btn-primary">Submit</button>
                </div>
              </div>

             

            </form>
          </div>
        </div><!-- End the row -->

    </section>
  </div>

<!-- Footer -->

    <footer>
      <hr>
        <div class="container text-center">
        <h3>Subscribe for get more information </h3>
        <p>Enter your name and email</p>

        <form action="" class="form-inline">
          <div class="form-group">
            <label for="subscription">Subscribe</label>
            <input type="text" class="form-control" id="subscription" placeholder="Your name">
          </div>
          <div class="form-group">
            <label for="email">Email address</label>
            <input type="text" class="form-control" id="email" placeholder="Enter your Email">
          </div>
          <button type="submit" class="btn btn-default">Subscribe</button>
          
        </form>

        <hr>
        <ul class="list-inline">
          <li><a href="http://www.twitter.com/wiredwiki">Twitter</a></li>
          <li><a href="http://www.facebook.com/askorama">Facebook</a></li>
          <li><a href="http://www.youtube.com/wiredwiki">YouTube</a></li>
        </ul>

        <p>&copy; Copyright @ 2017</p>

      </div><!-- end Container-->
      

    </footer>

	<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="assets/js/bootstrap.min.js"></script>
</body>	
</html>