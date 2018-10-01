 <html ng-app="app" ng-controller="addCoupon">
<head>
<title>Register Agent</title>
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
<header class="page-header" >
		<h2 align="center">Add Coupon Page</h2>
		</header>
		
		
	 <h3 style="color: red;"><u>Add Coupon </u></h3> 
		
  <div class="row">
    <div class="col-lg-4 col-md-4">
       <div class="form-group">details
          <label>Coupon Code</label>
          <span class="required"  style="color: red;">*</span>
          <input type="text" ng-model="couponCode" maxlength="200" id="couponCode" class="form-control" required="" >
       </div>
    </div>
</div>
<div class="col-sm-offset-5 com-sm-10">
<button type="button"  class="btn btn-primary ,btn btn-lg" ng-click="addCoupon()">addCoupon</button>
</div>
</div>

<!-- AngularJS -->
<script src="js/angular.js"></script>

<!-- Bootstrap core CSS -->
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="webjars/bootstrap/3.3.5/css/bootstrap.theme.min.css" rel="stylesheet">
<script>

var app=angular.module("app",[]);
app.controller("addCoupon",function($scope,$window,$http){
	
	$scope.addCoupon=function(){
		
		$window.alert('calling');
		
		$http({
			
			method:"post",
			url:"/Bus24/addCoupon",
			params:{     
					"couponCode":$scope.couponCode
				   
				    }
	
		}).then(function(result) {
			$window.alert('SUCCESS');
		},function(){
			$window.alert('FAILUER');
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