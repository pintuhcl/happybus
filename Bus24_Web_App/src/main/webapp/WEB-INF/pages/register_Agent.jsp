<html ng-app="register_agent" ng-controller="agent_reg_controller">
<head>
<title>Register Agent</title>
<!-- Bootstrap core CSS -->
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="webjars/bootstrap/3.3.5/css/bootstrap.theme.min.css" rel="stylesheet">

<!-- <link rel="stylesheet" type="text/css" href="css/styles.css"/> -->
 <style>
.footer {
    width: 100%;
    height: 200px;
    background-image:url("images/AgenFfooter.jpg");
    background-size: 100% 100%;
}
a.ty-link.ty-link-white {
     color: #000000; 
}
</style> 
</head>
<body style="background-color: silver;">
<div class="container">
<header class="page-header" style="background-color: red; height: 43px">
		<ul class="nav nav-pills  pull-right">
			<li class="active"><a href="/Bus24/">Home</a></li>
			<li class="active"><a href="/Bus24/about/">About</a></li>
			<li class="active"><a href="contact.htm">ContactUs</a></li>
		</ul>
		<h2 align="center">Register Agent Page</h2>
		</header>
		<div style="color: red; text-align: center;"><h1>{{message}}</h1></div>
<div ng-hide="flag">
<form name="regForm" novalidate>	
  <div class="row">
   <div class="col-sm-offset-2 com-sm-10">
  	<h3 style="color: red;"><u>Agency Details</u></h3>
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Agency Name</label>
          <span class="required"  style="color: red;">*</span>
          <input type="text" ng-model="agencyName" maxlength="200"  class="form-control" required="" >
       </div>
    </div>
  
<div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>RegNo</label>
          <span class="required" >*</span>
          <input type="text" ng-model="regNo" maxlength="200"  class="form-control" required="">
       </div>
    </div>
</div>
</div>

  <div class="row">
  <div class="col-sm-offset-2 com-sm-10">
   <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Email</label>
          <span class="required" >*</span>
          <input type="email" name="email" ng-model="email" maxlength="200" class="form-control" required  ng-blur="checkUser()" ng-focus="clearMessage()">
       	  <span style="color:red" ng-if="regForm.email.$dirty && regForm.email.$invalid">
          <span ng-if="regForm.email.$error.required">Email is required.</span>
          <span ng-if="regForm.email.$error.email">Invalid Email.</span>
  </span>
       </div>
    </div>
    
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Website</label>
          <span class="required" >*</span>
          <input type="text" ng-model="website" maxlength="200" class="form-control" required="">
       </div>
    </div>
</div>
</div>
  <div class="row">
  <div class="col-sm-offset-2 com-sm-10">
  <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Phone Number1</label>
          <span class="required" >*</span>
          <input type="text" ng-model="phNoOne" maxlength="200"  class="form-control" required="">
       </div>
    </div>
    
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Phone Number2</label>
          <input type="text" ng-model="phNoTwo" maxlength="200"  class="form-control" >
       </div>
    </div>
  </div>
  </div>
<div class="row">
   <div class="col-sm-offset-2 com-sm-10">
   <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Mobile</label>
          <span class="required" >*</span>
          <input type="text" name="mobile" ng-model="mobile" maxlength="200" class="form-control" required ng-pattern="/^[0-9]{10,10}$/"
   ng-blur="checkUser()" ng-focus="clearMessage()">
        <span style="color:red" ng-if="regForm.mobile.$dirty && regForm.mobile.$invalid">
  <span ng-if="regForm.mobile.$error.required">Mobile is required.</span>
  <span ng-if="regForm.mobile.$error.pattern">Invalid Mobile Number</span>
  </span>
       
       </div>
    </div>
 
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>AddressLine1</label>
          <span class="required" >*</span>
          <input type="text" ng-model="addressOne" maxlength="200" class="form-control" required="">
       </div>
    </div>
  </div>
  </div>
  <div class="row">
  <div class="col-sm-offset-2 com-sm-10">
<div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>AddressLine2</label>
          <span class="required" >*</span>
          <input type="text" ng-model="addressTwo" maxlength="200"  class="form-control" required="">
       </div>
    </div>

    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>City</label>
          <span class="required" >*</span>
          <input type="text" ng-model="city" maxlength="200"  class="form-control" required="">
       </div>
    </div>
    </div>
    </div>
    <div class="row">
    <div class="col-sm-offset-2 com-sm-10">
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>State</label>
          <span class="required" >*</span>
          <input type="text" ng-model="state" maxlength="200"  class="form-control" required="">
       </div>
    </div>
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Zipcode</label>
          <span class="required" >*</span>
          <input type="text" ng-model="zipcode" maxlength="200"  class="form-control" required="">
       </div>
    </div>
</div>
</div>
   
<div class="row">
	<div class="col-sm-offset-2 com-sm-10">
	<h3 style="color: red;"><u>Bank Details</u></h3> 
	 <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>BankAccount Number</label>
          <span class="required" >*</span>
          <input type="text" ng-model="accNo" maxlength="200"  class="form-control" required="">
       </div>
    </div>
  
<div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Ifsc code</label>
          <span class="required" >*</span>
          <input type="text" ng-model="ifscCode" maxlength="200"  class="form-control" required="">
       </div>
    </div>
  </div>  
  </div>
  <div class="row">
  <div class="col-sm-offset-2 com-sm-10">
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Acc Holder Name</label>
          <span class="required" >*</span>
          <input type="text" ng-model="holderName" maxlength="200" class="form-control" required="">
       </div>
    </div>
   <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Bank Name</label>
          <span class="required" >*</span>
          <input type="text" ng-model="bankName" maxlength="200"  class="form-control" required="">
       </div>
    </div>
    </div>
    </div>
    <div class="row">
    <div class="col-sm-offset-2 com-sm-10">
    <div class="col-lg-4 col-md-4">
       <div class="form-group">
          <label>Branch Name</label>
          <span class="required" >*</span>
          <input type="text" ng-model="branchName" maxlength="200"  class="form-control" required="">
       </div>
    </div>
</div>
</div>
<div class="col-sm-offset-5 com-sm-10">
<button type="button"  class="btn btn-primary ,btn btn-lg" ng-click="registerAgent()">Register</button>
<button type="reset"  class="btn btn-primary ,btn btn-lg" ng-click="reset()">Reset</button>
</div>
</form>
</div>
</div>


<!-- AngularJS -->
<script src="js/angular.js"></script>



<link href="css/styles.css" rel="stylesheet">
<script>

var app=angular.module("register_agent",[]);
app.controller("agent_reg_controller",function($scope,$window,$http){
	
	$scope.registerAgent=function(){
		
		$window.alert('calling');
		
		$http({
			
			method:"post",
			url:"/Bus24/registerAgent",
			params:{     
					"regNo":$scope.regNo,
				    "state":$scope.state,
				     "city":$scope.city,
				     "agencyName":$scope.agencyName,
					 "email":$scope.email,
					 "website":$scope.website,
					 "phoneNumber1":$scope.phNoOne,
					 "phoneNumber2":$scope.phNoTwo,
					 "addressLine1":$scope.addressOne,
					 "addressLine2":$scope.addressTwo,
					 "mobile":$scope.mobile,
					  "zipCode":$scope.zipcode,
					  "accountNumber":$scope.accNo,
				      "bankName":$scope.bankName,
					  "ifscCode":$scope.ifscCode,
					  "bankBranch":$scope.branchName,
					  "accHolderName":$scope.holderName
				    }
	
		}).then(function(result) {
			$window.alert('SUCCESS');
			$scope.response=result.data;
			if( $scope.response.status=="SUCCESS"){
				$scope.flag=true;
				$scope.message="Agent Register Successfully";
			}
			else {
			       $scope.message = $scope.response.message;
			       
			      }
		},function(){
			$window.alert('FAILUER');
		})/* end of then */
	}
	$scope.reset = function () {
		  window.location.reload(); 
		};
		
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
	
	
});/* end of controller */
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