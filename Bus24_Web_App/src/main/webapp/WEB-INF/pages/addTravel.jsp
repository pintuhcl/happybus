<html ng-app="register_travel" ng-controller="travel_reg_controller">
<head>
<title>Register Travel</title>
<style>
.footer {
    width: 100%;
    height: 200px;
    background-image:url("images/AgenFfooter.jpg");
    background-size: 100% 100%;
}
a.ty-link.ty-link-white {
     color: #000000; 
}​

</style>
</head>

<body style="background-color: silver;">
<div class="container">
<header class="page-header" style="background-color: red; height: 43px">
		<ul class="nav nav-pills  pull-right">
			<li class="active"><a href="/Bus24/adminDashboard">Home</a></li>
			<li class="active"><a href="/Bus24/about/">About</a></li>
			<li class="active"><a href="contact.htm">ContactUs</a></li>
		</ul>
		<h2 align="center">Register Travel Page</h2>
		</header>
		
		
		
  <div class="row">
    <div class="col-lg-2 col-md-2">
       <div class="form-group">
          <label>Travel Name</label>
          <span class="required" >*</span>
          <input type="text" ng-model="travelName" maxlength="20" id="travelName" class="form-control" required="" >
       </div>
    </div>
  
<div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Travel RegNo</label>
          <span class="required" >*</span>
          <input type="text" ng-model="travelRegNumber" maxlength="200" id="travelRegNumber" class="form-control" required="">
       </div>
    </div>
    
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Email</label>
          <span class="required" >*</span>
          <input type="text" ng-model="email" maxlength="200" id="email" class="form-control" required="">
       </div>
    </div>
</div>

  <div class="row">
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Website</label>
          <span class="required" >*</span>
          <input type="text" ng-model="website" maxlength="200" id="agencyName" class="form-control" required="">
       </div>
    </div>
  
<div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Phone Number1</label>
          <span class="required" >*</span>
          <input type="text" ng-model="phoneNumber1" maxlength="200" id="phoneNumber1" class="form-control" required="">
       </div>
    </div>
    
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Phone Number2</label>
          <input type="text" ng-model="phoneNumber2" maxlength="200" id="phoneNumber2" class="form-control" >
       </div>
    </div>
</div>

<div class="row">
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Mobile</label>
          <span class="required" >*</span>
          <input type="text" ng-model="mobile" maxlength="200" id="agencyName" class="form-control" required="">
       </div>
    </div>

  <div class="row">
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>AddressLine1</label>
          <span class="required" >*</span>
          <input type="text" ng-model="addressLine1" maxlength="200" id="addressLine1" class="form-control" required="">
       </div>
    </div>
  
<div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>AddressLine2</label>
          <span class="required" >*</span>
          <input type="text" ng-model="addressLine2" maxlength="200" id="addressLine2" class="form-control" required="">
       </div>
    </div>
    
<div class="row">
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>City</label>
          <span class="required" >*</span>
          <input type="text" ng-model="city" maxlength="200" id="agencyName" class="form-control" required="">
       </div>
    </div>
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>State</label>
          <span class="required" >*</span>
          <input type="text" ng-model="state" maxlength="200" id="agencyName" class="form-control" required="">
       </div>
    </div>
</div>

 
     <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Zipcode</label>
          <span class="required" >*</span>
          <input type="text" ng-model="zipcode" maxlength="200" id="agencyName" class="form-control" required="">
       </div>
    </div>
</div>
    
   
    


 
	 <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Bank Account Number</label>
          <span class="required" >*</span>
          <input type="text" ng-model="accountNumber" maxlength="200" id="accountNumber" class="form-control" required="">
       </div>
    </div>
  <div class="row">
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Acc Holder Name</label>
          <span class="required" >*</span>
          <input type="text" ng-model="accHolderName" maxlength="200" id="accHolderName" class="form-control" required="">
       </div>
    </div>
  <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Bank Name</label>
          <span class="required" >*</span>
          <input type="text" ng-model="bankName" maxlength="200" id="bankName" class="form-control" required="">
       </div>
    </div>
    
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Branch Name</label>
          <span class="required" >*</span>
          <input type="text" ng-model="bankBranch" maxlength="200" id="bankBranch" class="form-control" required="">
       </div>
    </div>
<div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Ifsc code</label>
          <span class="required" >*</span>
          <input type="text" ng-model="ifscCode" maxlength="200" id="ifscCode" class="form-control" required="">
       </div>
    </div>
  </div>  
  

</div>
<div class="col-sm-offset-5 com-sm-10">
<button type="button"  class="btn btn-primary ,btn btn-lg" ng-click="registerTravel()">Register Travel</button>
<button type="reset"  class="btn btn-primary ,btn btn-lg" ng-click="reset()">Reset</button>
</div>
</div>

<!-- AngularJS -->
<script src="js/angular.js"></script>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap.theme.min.css" rel="stylesheet">
<script>

var app=angular.module("register_travel",[]);
app.controller("travel_reg_controller",function($scope,$window,$http){
	
	$scope.registerTravel=function(){
		
		$window.alert('calling');
		
		$http({
			
			method:"post",
			url:"/Bus24/addTravel",
			params:{     
					"travelRegNumber":$scope.travelRegNumber,
				     "travelName":$scope.travelName,
					 "website":$scope.website,
					 "email":$scope.email,
					 "mobile":$scope.mobile,
					 "phoneNumber1":$scope.phoneNumber1,
					 "phoneNumber2":$scope.phoneNumber1,
					 "addressLine1":$scope.addressLine1,
					 "addressLine2":$scope.addressLine2,
					 "state":$scope.state,
				     "city":$scope.city,
					  "zipcode":$scope.zipcode,
					  "accountNumber":$scope.accountNumber,
				      "bankName":$scope.bankName,
					  "ifscCode":$scope.ifscCode,
					  "bankBranch":$scope.bankBranch,
					  "accHolderName":$scope.accHolderName
				    }
	
		}).then(function(result) {
			$window.alert('SUCCESS');
			$scope.response = result.data;
		      if ($scope.response.status == "SUCCESS") {
		    $scope.message=$scope.response.message;
		  
		      } else if($scope.response.status == "FAILURE"){

		    	  $scope.message=$scope.response.message;  
		       
		      }else if($scope.response.status == "SESSIONEXPIRED"){
     $window.alert("Your Session Expired!Please Login.");
     //forward to home page
	 $window.location.href = '/Bus24/loginUser'; 	  
		       
		      }
		},function(){
			$window.alert('FAILURE');
		})/* end of then */
	}
	$scope.reset = function () {
		  window.location.reload(); 
		};
	
	
})/* end of controller */
</script>
<!-- footer -->
<br><br>
<div class="footer">
 <div class="container">
   <div class="col-sm-6 col-md-12"> 
        <img class="footer-ty-logo" src="images/bus_logo.png" width="30" height="30" alt="Bus24" title="Bus24"> India's largest real time ticket booking platform 
    </div> 
  </div>
 </div>

     
</body>
</html>