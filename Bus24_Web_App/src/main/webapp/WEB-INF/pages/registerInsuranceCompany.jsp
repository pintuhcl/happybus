<html>
<head>
<title>Register Insurance</title>

<script type="text/javascript" src="js/angular.js"></script>
<link type="text/css"
	href="css/bootstrap.css"
	rel="stylesheet" />
	
<script>
	var app = angular.module("insurance", []);
	app.controller("travelController", function($scope, $http) {

		$scope.abc = "First";
		getTravelList();
		function getTravelList() {

			$http({
				method : "get",
				url : "getAllTravel"
			}).then(function(response) {
				console.log(response);
				$scope.travelList = JSON.parse(response.data.data);
				// 				console.log($scope.travelList.travelId);

			}, function(response) {
				console.log(response);
				$window.alert("failed");
			});
		}
	});

	app.controller("insuranceController", function($scope, $http, $window) {
		$scope.register = function() {

			if (!$window.confirm("Are u sure?")) {
				return;
			}

			$scope.message = "";

			$http({
				method : "POST",
				url : "/Bus24/registerInsurance",
				data : {
					"travel" : {
						"travelId" : $scope.travel.travelId
					},
					"companyName" : $scope.companyName,
					"amount" : $scope.amount
				}

			}).then(function(result) {

				var data = angular.fromJson(result.data);
				var message = data.message;

				$scope.companyName="";
				$scope.amount="";
				$scope.message = message;
				console.log(result);

				if (data.status == "FAILURE") {

					$scope.messageColor = [ 'text-center', 'text-danger' ];
				} else {
					$scope.messageColor = [ 'text-center', 'text-success' ];


				}

			}, function(result) {
				$scope.message = message;
				$scope.messageColor = [ 'text-center', 'text-danger' ];

			});
		}
	});
</script>
</head>
<body ng-app="insurance" ng-controller="travelController">
	<h1 align="center">Register Insurance Company By Super Admin</h1>
	<hr />
	<div align="center" >
	</div>
	<table align="center"  ng-controller="insuranceController">

		<tr>

			<td>Travel</td>
			<td><select class="form-control" ng-model="travel"
				ng-options="travel.travelName for travel in travelList track by travel.travelId">
			</select></td>
		</tr>

		<tr>
			<td>Company Name :</td>
			<td><input type="text" ng-model="companyName" class="form-control"></td>
		</tr>
		<tr>
			<td>Amount:</td>
			<td><input type="text" ng-model="amount"  class="form-control" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button value="Register" ng-click="register()" class="btn btn-danger">Register</button>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><b ng-class="messageColor">{{message}}</b></td>

		</tr>
	</table>
</body>
</html>