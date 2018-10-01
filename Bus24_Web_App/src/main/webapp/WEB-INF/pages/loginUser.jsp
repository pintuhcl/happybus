<!DOCTYPE html>
<html lang="en" ng-app="passenger_register" >
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bus24 Login &amp; Register Forms</title>

<script src="js/angular.js"></script>
        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="asset/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="asset/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="asset/css/form-elements.css">
        <link rel="stylesheet" href="asset/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">



<script> 
var app = angular.module("passenger_register", []);
app.controller("passenger_reg_controller",
 function($scope, $window, $http) {
  $scope.flag = false;

  $scope.clearMessage = function() {
   /* 	$window.alert('calling'); */
   $scope.message = "";
  }
  $scope.registerPassenger = function() {
	 	$window.alert('calling');
   $scope.message = "";
   $scope.checked = true;
   $http({
     method: "post",
     url: "/Bus24/register",
     params: {
      "email": $scope.email,
      "mobile": $scope.mobile,
      "password": $scope.password
     }
    }).then(function(result) {
      $scope.checked = false;
      $scope.response = result.data;
      
      if ($scope.response.status == "SUCCESS") {
       $scope.user = $scope.response.data;
       $window.alert($scope.user);

       $scope.mobile = angular.fromJson($scope.user).mobile;
       $scope.flag = true;
       $scope.message = "Please Enter OTP Sent To Registered Mobile " + $scope.mobile;
       $scope.userId = angular.fromJson($scope.user).userId;
       $window.alert($scope.userId);
      } else {

       $scope.flag = false;
       $scope.message = $scope.response.message;
       
      }
     },
     function(result) {
      $scope.checked = false;
      $scope.message = "Unable to Process your request!Please Try Again";
     });
  }

  $scope.validateOTP = function() {
   $window.alert($scope.userId + " " + $scope.otp);
   
   $http({
    method: "post",
    url: "/Bus24/validateOtp",
    data: {
     "userId": $scope.userId,
     "otp": $scope.otp
    }
   }).then(function(result) {
    
    $scope.response = result.data;
   if($scope.response.status=="SUCCESS"){
	$window.alert($scope.response.message);
	   //forward to home page
	 $window.location.href = '/Bus24/';
   }else{
	   $scope.flag=true;
	   //display message
	  $scope.message= $scope.response.message;
   }
   
   }, function() {
   $scope.message="Unable to process your request!Please try Again.";

   });}
  $scope.resendOTP=function(){
	  $http({
		  method:"POST",
		  url:"/Bus24/resendOtp",
		  data:{
			  "userId":$scope.userId
		  }
			  
	  }).then(function(response){
		  console.log(response);
		  $window.alert(response);
	  },function(response){
		  console.log(response);
		  $window.alert(response);
	  });
  }
  
  
  $scope.checkUser = function() {
	 
	  console.log("calling checkUser() ");
		$http({
		url:"/Bus24/checkUser",
		method:"post",
		params:{
		"email":$scope.email,
		"mobile":$scope.mobile
		}
		}).then(function(result){
			console.log(result.data.status);
			if(result.data.status=="SUCCESS"){
				 
				 console.log($scope.checked);
						 
			$scope.message=result.data.message;
			 
			}
		},function(result){
   
		});			 
	 
	   }
 });
</script>    </head>

    <body  ng-controller="passenger_reg_controller">

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
 <div  ng-hide="flag">               	
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>Bus24</strong> Login &amp; Register Forms</h1>
                            <div class="description">
                            	<p>
	                            	
                            	</p>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-sm-5">
                        	
                        	<div class="form-box">
	                        	<div class="form-top">
	                        		<div class="form-top-left">
	                        			<h3>Login to our site</h3>
	                            		<p>Enter username and password to log on:</p>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<i class="fa fa-lock"></i>
	                        		</div>
	                            </div>
	                            <div class="form-bottom">
				                    <form role="form" action="loginUser" method="post" class="login-form">
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-username">Username</label>
				                        	<input type="text" name="userName" placeholder="Username..." class="form-username form-control" id="userName">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-password">Password</label>
				                        	<input type="password" name="password" placeholder="Password..." class="form-password form-control" id="password">
				                        </div>
				                        <button type="submit" class="btn btn-active">Sign in!</button>
				                              <hr>
				                        <button type="submit" class="btn" ng-click="fotgetPassword()">ForgetPassword ?</button>
				                    </form>
			                    </div>
		                    </div>
		                
		                	<div class="social-login">
	                        	<h3>...or login with:</h3>
	                        	<div class="social-login-buttons">
		                        	<a class="btn btn-link-2" href="#">
		                        		<i class="fa fa-facebook"></i> Facebook
		                        	</a>
		                        	<a class="btn btn-link-2" href="#">
		                        		<i class="fa fa-twitter"></i> Twitter
		                        	</a>
		                        	<a class="btn btn-link-2" href="#">
		                        		<i class="fa fa-google-plus"></i> Google Plus
		                        	</a>
	                        	</div>
	                        </div>
	                        
                        </div>
                        
                        <div class="col-sm-1 middle-border"></div>
                        <div class="col-sm-1"></div>
                        	
                        <div class="col-sm-5">
                        	
                        	<div class="form-box"  >
                        	<div><!-- ng-jkhkjh-->
                        		<div class="form-top">
	                        		<div class="form-top-left">
	                        			<h3>Sign up now</h3>
	                            		<p>Fill in the form below to get instant access:</p>
	                            		<h3 style="color:red;">{{message}}</h3>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<i class="fa fa-pencil"></i>
	                        		</div>
	                            </div>
	                            <div class="form-bottom">
				                    <form  name="regForm" class="registration-form" novalidate >
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-first-name" >Email</label>
				                        	<input  style="height: 50px" type="email" name="email" ng-model="email"  ng-focus="clearMessage()" ng-blur="checkUser()" required placeholder="Email..." class="form-first-name form-control" id="email">
				                              <span style="color:red" ng-if="regForm.email.$dirty && regForm.email.$invalid">
                                             <span ng-if="regForm.email.$error.required">Email is required.</span>
                                            <span ng-if="regForm.email.$error.email">Invalid Email.</span>
                                             </span>
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-last-name">Mobile</label>
				                        	<input type="text" name="mobile" placeholder="Mobile..." ng-model="mobile"  ng-focus="clearMessage()"  class="form-last-name form-control" id="mobile"
				                        	   ng-pattern="/^[0-9]{10,10}$/" ng-blur="checkUser()" ng-focus="clearMessage()">
				                            <span style="color:red" ng-if="regForm.mobile.$dirty && regForm.mobile.$invalid">
                                          <span ng-if="regForm.mobile.$error.required">Mobile is required.</span>
                                       <span ng-if="regForm.mobile.$error.pattern">Invalid Mobile Number</span>
                                       </span>
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-email">Password</label>
				                        	<input type="password" name="password" ng-model="password"  ng-focus="clearMessage()"  placeholder="Password..." class="form-email form-control" id="password"
				                        	ng-pattern="/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/" required ng-blur="checkUser()" ng-focus="clearMessage()">
				                            <span style="color:red" ng-if="regForm.password.$dirty && regForm.password.$invalid">
                                              <span ng-if="regForm.password.$error.required">Password is required.</span>
                                               <span ng-if="regForm.password.$error.pattern">Invalid Password</span>
                                        </span> 
				                        </div>
				                        <button value="Register" class="btn" ng-disabled="checked" ng-click="registerPassenger()">Register</button>
				                    <!--     <button type="submit" class="btn" ng-click="registerPassenger()">Sign me up!</button> -->
				                    </form>
			                    </div>
			           </div>
		  </div>
		  </div>
		  </div>
		  </div>
	  
	<div style="text-align: center;background-color: silver;" ng-show="flag" >
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<br> <img
					src="https://cdn2.iconfinder.com/data/icons/luchesa-part-3/128/SMS-512.png"
					class="img-responsive"
					style="width: 200px; height: 200px; margin: 0 auto;"><br>

				<h1 class="text-center;" style="color: black;">Verify your mobile number</h1>
				<br>
				<p class="lead" style="align: center"></p>
				<h3 style="color: red;">{{message}}</h3>
				<p></p>
				<br>

				<form   >
							<span style="color: red;"></span> 
					    
					      	<div class="row">
  <div class="col-sm-offset-2 com-sm-10">
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <input type="text" ng-model="otp" maxlength="200" class="form-control" placeholder="Enter Otp" required="">
       </div>
    </div>
    </div>
    
   <!--  <div class="row"> -->
    <div class="col-sm-offset-2 com-sm-10">
   
       <div class="col-lg-3 col-md-3">
          <button type="submit" ng-click="validateOTP()" class="btn btn-primary ,btn btn-md" >Verify</button>
         </div>
         <div class="col-lg-3 col-md-2">
               <button type="submit" ng-click="resendOTP()" class="btn btn-primary ,btn btn-md" >Resend</button>
       </div>
       
 
    </div>
    
    </div>
				</form>
				<br>
				<br>
			</div>
	<!-- 	</div>
	</div> -->
	
</div>		              
			              
			              
			              
			                    
			                    
			                    
                        	</div>
                        	
                        </div>
                   <!--  </div> -->
                    
                <!-- </div> -->
            </div>
            
        </div>

        <!-- Footer -->
        <footer>
        	<div class="container">
        		<div class="row">
        			
        			<div class="col-sm-8 col-sm-offset-2">
        				<div class="footer-border"></div>
        				<p> <a href="http://javasathish.com/" target="_blank"><strong>SATHISH</strong></a> 
        					 <i class="fa fa-smile-o"></i></p>
        			</div>
        			
        		</div>
        	</div>
        </footer>

        <!-- Javascript -->
        <script src="asset/js/jquery-1.11.1.min.js"></script>
        <script src="asset/bootstrap/js/bootstrap.min.js"></script>
        <script src="asset/js/jquery.backstretch.min.js"></script>
        <script src="asset/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>