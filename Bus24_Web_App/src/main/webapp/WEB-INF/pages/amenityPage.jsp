<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script type="text/javascript">
	var amenityModule = angular.module("amenityModule", []);
	amenityModule.controller("amenityController", function($scope, $http,
			$window) {
		$scope.addNewAmenity = function() {

			if (!$window.confirm("Are u sure?")) {
				return;
			}

			$scope.message = "";

			$http({
				method : "POST",
				url : "/Bus24/amenity/addNewAmenity",
				data : {
					"amenityName" : $scope.amenityName
				}

			}).then(function(result) {

				var data = angular.fromJson(result.data);
				var message = data.message;

				$scope.message = message;

				if (data.status == "FAILURE") {

					$scope.messageColor = [ 'text-center', 'text-danger' ];
				} else {
					$scope.messageColor = [ 'text-center', 'text-success' ];
					$scope.amenityName = "";

				}
				$scope.getAllAmenity();

			}, function(result) {
				$scope.message = message;
				$scope.messageColor = [ 'text-center', 'text-danger' ];

			});
		}
		$scope.getAllAmenity = function() {
			$http({
				method : "GET",
				url : "/Bus24/amenity/getAllAmenities",
			}).then(function(result) {
				$scope.list = angular.fromJson(result.data.data);
				console.log($scope.list);

			}, function(result) {
				console.log(result);
			});
		}
		$scope.getAllAmenity();
	});
</script>


</head>
<body ng-app="amenityModule" ng-controller="amenityController">
	<h1 class="text-primary" align="center">Bus Amenities</h1>
	<hr />
	<div class="container">
		<div class="row">
			<div class="col-md-6">

				<form>
					<div class="form-group">
						<label>Amenity Name</label> <input type="text"
							class="form-control" ng-model="amenityName">
					</div>
					<div ng-class="messageColor">
						<b>{{message}}</b>
					</div>
					<button type="Button" class="btn btn-default"
						ng-click="addNewAmenity()">Save</button>
				</form>

			</div>

			<div class="col-md-6">
				<table class="table table-bordered">
					<tr>
						<th>ID</th>
						<th>AmenityName</th>
						<th>Action</th>
					</tr>
					<tr ng-repeat="a in list">
						<td>{{a.amenityId}}</td>
						<td>{{a.amenityName}}</td>
						<td><button class="btn btn-sm">Edit</button></td>

					</tr>
				</table>
			</div>
		</div>
		
		
	</div>
</body>
</html>