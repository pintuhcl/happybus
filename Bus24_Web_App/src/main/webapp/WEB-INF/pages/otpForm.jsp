<%-- <%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<html ng-app="app"  ng-controller="Otp_Controller">
<head>
  <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Otp Verify form</title>  
        
<script src="js/angular.js"></script>
<!-- Bootstrap core CSS -->
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		rel="stylesheet">
	<!-- <link href="webjars/bootstrap/3.3.5/css/bootstrap.theme.min.css"
		rel="stylesheet">
 -->



<script> 
var app = angular.module("app", []);
app.controller("Otp_Controller",
 function($scope, $window, $http) {
  $scope.flag = false;
    
  $scope.clearMessage = function() {
   /* 	$window.alert('calling'); */
   $scope.mesg = "";
  }

  $scope.validateOTP = function() {
	  $window.alert("calling");
   $window.alert(${userId} + " " + $scope.otp);
   
   $http({
    method: "post",
    url: "/Bus24/validateOtp",
    data: {
     "userId": ${userId},
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
	  $scope.mesg= $scope.response.message;
   }
   
   }, function(result) {
	   $scope.flag=true;
   $scope.mesg="Unable to process your request!Please try Again.";

   });
   }
  
  $scope.resendOTP=function(){
	  $http({
		  method:"POST",
		  url:"/Bus24/resendOtp",
		  data:{
			  "userId":${userId}
		  }
			  
	  }).then(function(response){
		  console.log(response);
		  $window.alert(response);
	  },function(response){
		  console.log(response);
		  $window.alert(response);
	  });
  }
 });
</script> 
</head>
<body style="text-align: center;background-color: silver;height: 100%"" >
		<div   >
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
				<h3 style="color: red;" ng-show="flag">${{message1}}</h3>
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
	
	
</div>		              
			              
			              
			              
			                    
			                    
			                    
                        	</div>
                        	
                        </div>
	
</body>
</html>