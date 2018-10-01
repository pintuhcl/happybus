 <!DOCTYPE html>
<html ng-app="changepassword.controllers">
<%@page isELIgnored="false" %> 
<head>
    <script src="js/angular.js"></script> 
    <!-- Bootstrap core CSS -->
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<!-- <link href="webjars/bootstrap/3.3.5/css/bootstrap.theme.min.css"
	rel="stylesheet"> -->
	<link rel="stylesheet" href="/w3css/4/w3.css">
	

<script >
angular.module('changepassword.controllers', [])
.controller('changepassword_controller', ['$scope', '$window','$http',function($scope,$window,$http) {
$scope.changePassword = function() {
	if($scope.confirmpassword==null){
		$scope.message="Please Enter ConfirmPassword.";
	 	if($scope.newpassword==null){
			$scope.message="Please Enter NewPassword.";
		}if($scope.currentpassword==null){
			$scope.message="Please Enter CurrentPassword.";
		} 
			
		}
	else{
	$http({
	method:"post",	
	url:"/Bus24/changePassword",
	params:{
		'currentpassword':$scope.currentpassword,
		'newpassword':$scope.newpassword,
		'confirmpassword':$scope.confirmpassword
		
	}
	}).then(function(result) {
		
		$scope.response=result.data;
		if($scope.response.status=="EXCEPTION" || $scope.response.status=="FAILURE"){
			$scope.message=$scope.response.message;
		}else{
		$window.alert("Your Password Changed SuccessFully");
		$window.location.href="/Bus24/passengerDashboard";
		}
			
	}, function(response) {
		$window.alert("unable to process your request");
	}); 
	}
}
}]);
</script>
</head>
<div id="changepassword_frame_div" class="hbb-modal"
	ng-controller="changepassword_controller">
	<div class="hbb-modal-content hbb-card-4 hbb-animate-zoom"
		style="max-width: 600px">
				
		<div style="color:green; font-size: medium;" align="center">
		<br>
			</div>
		<div class="hb-section hbb-margin ">
		<input type="text" ng-model="${userId}"/><br>
			<label class="hb-label-marign"><b>Hello :</b></label><span class="hbb-border" ng-disabled="true">${userName}</span>
			
			<br><br>
			
		<input type="text" ng-value="userName=${userName}" ng-model="userName" value="${userName}"/><br>
		<label class="hb-label-marign"><b>CurrentPassword</b></label> <input
				class="hb-input hbb-border hbb-margin-bottom" type="password"
				ng-model="currentpassword" required/><br>
			<label class="hb-label-marign"><b>NewPassword</b></label> <input
				class="hb-input hbb-border hbb-margin-bottom" type="password"
				ng-model="newpassword" required/><br>
		<label class="hb-label-marign"><b>ConfirmPassword</b></label> <input
				class="hb-input hbb-border hbb-margin-bottom" type="password"
				ng-model="confirmpassword" required/><br>
			<button class=" hb-label-marign hbb-button hbb-large hbb-green hb-section"
				ng-click="changePassword()">Change</button>
		</div>
		</form>
	</div>
</div>
</html> 


