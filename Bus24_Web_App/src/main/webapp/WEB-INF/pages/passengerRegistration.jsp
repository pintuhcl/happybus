<html ng-app="passenger_register">
<head>
<script src="js/angular.js"></script>
<link type="text/css" href="css/bootstrap.css" rel="stylesheet" />

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
</script>
</head>
<body ng-controller="passenger_reg_controller">
	<h1 align="center">Passenger Registration Form</h1>
	<hr />

	<div align="center">
		<span style="color: red; font-weight: bold;"> {{message}} </span>
		<table align="center" ng-show="flag">
			<tr>
				<td>Enter OTP :</td>
				<td><input type="text" ng-model="otp" /></td>
			</tr>
			<tr>
				<td colspan="1" align="center">
					<button value="Submit" ng-click="validateOTP()">Submit</button>
				</td>
				<td colspan="1" align="center">
					<button value="Submit" ng-click="resendOTP()">Resend</button>
				</td>
			</tr>
		</table>
<form name="regForm" novalidate>
  
		<table align="center" ng-hide="flag" >
			<div style="background:yellow">
			The Password Must be Minimum 8 Characters.<br/>
			The Password Must contain At Least One Digit .<br/>
			 Password Must contain At Least One Special Character.
			
			</div><br/>
			<tr>
				<td>Email :</td>
				<td>
				
  <input type="email" name="email" ng-model="email" required  ng-blur="checkUser()" ng-focus="clearMessage()">
  <span style="color:red" ng-if="regForm.email.$dirty && regForm.email.$invalid">
  <span ng-if="regForm.email.$error.required">Email is required.</span>
  <span ng-if="regForm.email.$error.email">Invalid Email.</span>
  </span>

</td>
			</tr>
			<tr>
				<td>Mobile:</td>
				<td>
				
				
  <input type="text" name="mobile" ng-model="mobile" required    
  ng-pattern="/^[0-9]{10,10}$/"
   ng-blur="checkUser()" ng-focus="clearMessage()">
  <span style="color:red" ng-if="regForm.mobile.$dirty && regForm.mobile.$invalid">
  <span ng-if="regForm.mobile.$error.required">Mobile is required.</span>
  <span ng-if="regForm.mobile.$error.pattern">Invalid Mobile Number</span>
  </span>

</td>
				
				
			</tr>
			<tr>
				<td>Password:</td>
				<td>
				
				<input type="password" name="password" ng-model="password" ng-pattern="/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/" required ng-blur="checkUser()" ng-focus="clearMessage()">
  <span style="color:red" ng-if="regForm.password.$dirty && regForm.password.$invalid">
  <span ng-if="regForm.password.$error.required">Password is required.</span>
  <span ng-if="regForm.password.$error.pattern">Invalid Password</span>
  </span>
				
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button value="Register" ng-disabled="checked"
						ng-click="registerPassenger()">Register</button>
				</td>
			</tr>
			
		</table></form>
	</div>
</body>
</html>