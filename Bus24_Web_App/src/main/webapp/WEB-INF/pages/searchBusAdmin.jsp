<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script type="text/javascript">
	var app = angular.module("busModule", []);

	app.controller("travelController", function($scope, $http) {
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
	app.controller("busController", function($scope, $window, $http) {
		$scope.getBusesList = function(travelId) {
			if (travelId.length == 0) {
				console.log("returned");
				return;
			}
			$http({
				method : "get",
				url : "/Bus24/searchBusListAdmin/" + (travelId)
			}).then(function(response) {
				// 				$window.alert("success");

				$scope.busList = JSON.parse(response.data.data);
				if ($scope.busList != null)
					$scope.message = $scope.busList[0].travelId.travelName+" Buses List";
				else
					$scope.message = "Not Found";

			}, function(response) {
				console.log(response);
				$window.alert("failed");
			});
		}
	});
</script>

</head>
<body ng-app="busModule" ng-controller="busController">


	<div class="container" ng-controller="travelController">
		<h1 align="center">Search Bus For Admin Page</h1>
		<hr />
		<div class="row">
			<div class="form-group">
				<label class="control-label col-md-2">Travel</label>
				<div class="col-md-4">
					<select class="form-control" ng-model="travelId"
						ng-change="getBusesList(travelId)">
						<option value="">Please Select Travel</option>
						<option ng-repeat="travel in travelList"
							value="{{travel.travelId}}">{{travel.travelName}}</option>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h2>{{message}}</h2>
			</div>
		</div>
		<div class="row busRowCard" ng-repeat="b in busList">
			<div>
				<div class="col-md-6 col-md-6">
					<p>
						<b>{{b.regNo}}</b>
					</p>
					<p>{{b.busType.model+' '+b.busType.typeName}}</p>
				</div>
				<div class="col-md-2 col-md-2">
					<p>{{b.busType.layoutModel}}</p>
					<p>({{b.busType.layoutType}})</p>
				</div>
				<div class="col-md-2 col-md-2">
					<p>{{b.busType.noOfSeats}} Seats</p>
				</div>
				<div class="col-md-2 col-md-2">
					<a href="#">Edit</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>