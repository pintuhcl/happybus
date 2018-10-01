<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="searchBusModule" ng-controller="searchBusController">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="js/angular.js" type="text/javascript"></script>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>

<link type="text/css" href="css/bootstrap.css" rel="stylesheet" />
<link type="text/css" href="css/styles.css" rel="stylesheet" />

<script type="text/javascript">
	var app = angular.module("searchBusModule", []);
	app.controller("searchBusController", function($scope, $http, $window) {
		getTravelList();
		function getTravelList() {
			$http({
				method : "get",
				url : "getAllTravel"
			}).then(function(response) {
		$scope.message=$scope.response.message;
				/* console.log(response); */
				$scope.travelList = JSON.parse(response.data.data);
				// 				console.log($scope.travelList.travelId);

			}, function(response) {
			$scope.message=$scope.response.message;
				/* console.log(response); */
				// 				$window.alert("failed");
			});
		}
	});
</script>


<script>
        var app=angular.module("app",[]);
        app.controller("search_booking_controller",search_booking_controller);
    	function search_booking_controller($scope,$window,$http) {    	
        	        	$scope.getBooking=function(){
        			$http({
        			method : "post",
       				url : "/Bus24/searchBookings",
       				params : {
       					"BookingId":$scope.bookingId,
       					"BookingDate":$scope.bookingDate,
       					"TravelId":$scope.Travel.travelId,
       					"TravelName":$scope.Travel.travelName,
       					"NoOfPassengers":$scope.noOfPassengers,
       					"Source":$scope.source,
       					"Destination":$scope.destination,
       					"Distance":$scope.distance,
       					"ArrivalTime":$scope.arrivalTime,
       					"DepartureTime":$scope.depatureTime,
       					"TravelDuration":$scope.travelDuration,
       					"DateOfJourney":$scope.dateOfJourney,
       					"FinalFare":$scope.finalFare,
       					"Route":$scope.route.routeId      				
       				}
        		}).then(function(result){
                   $scope.response=result.data;
        			if( $scope.response.status=="SUCCESS"){
        				$scope.message=$scope.response.message;
        			}
        			else {
        			       $scope.message = $scope.response.message;
        			       
        			      }
        		},function(result){
        			$window.alert("fail");
        		});
        	}
        	
        	 $scope.searchTravel=function(fromDate,toDate){
        	     $http({
   				method : "post",
   				url : "/Bus24/searchBookingsByDate",
   				params : {
   					"FromDate":fromDate,
   					"ToDate":toDate,
   					"BookingId":$scope.bookingId,
       					"BookingDate":$scope.bookingDate,
       					"TravelId":$scope.Travel.travelId,
       					"TravelName":$scope.Travel.travelName,
       					"NoOfPassengers":$scope.noOfPassengers,
       					"Source":$scope.source,
       					"Destination":$scope.destination,
       					"Distance":$scope.distance,
       					"ArrivalTime":$scope.arrivalTime,
       					"DepartureTime":$scope.depatureTime,
       					"TravelDuration":$scope.travelDuration,
       					"DateOfJourney":$scope.dateOfJourney,
       					"FinalFare":$scope.finalFare,
       					"Route":$scope.route.routeId      				
   			    }
   			}).then(function(result) {
   					$scope.jsonBookingList = result.data;
   					if($scope.jsonBookingList.length>0){
   						 $scope.searchbBoking = angular.fromJson($scope.jsonBookingList);
   					}else{
   						$scope.message=" Data Not Found";
   					}
   			}, function(result) {
   				$window.alert("fail");
   				$window.alert(result.data);
   			});
           }
           $scope.clearMessage = function() {
        	   $scope.message = "";
        	  }
        }

</script>
</head>
<body ng-app="searchBusBooking" ng-controller="searchBusController">
	<div class="container">
		<h1 class="text-primary" align="center">Search Booking By Super	Admin</h1>
		<hr />
		<div class="form-inline">
			<div class="form-group">
				<label class="control-label">Travel</label> <select
					class="form-control" ng-model="travelId"
					ng-change="getBusesList(travelId)">
					<option value="">--All Travels--</option>
					<option ng-repeat="travel in travelList"
						value="{{travel.travelId}}">{{travel.travelName}}</option>
				</select>
			</div>
			<div class="form-group">
				<label class="control-label">From</label> <input type="date"
					class="form-control" ng-model="from">
			</div>
			<div class="form-group">
				<label class="control-label">To:</label> <input type="date"
					class="form-control" ng-model="to" />
			</div>
			<div class="form-group">
				<button type="button" class="btn btn-danger" ng-click="getBooking()" >Search</button>
			</div>
		</div>
	</div>
	
	<br>
	<br>
	
	
	<div>
	<table class="table table-bordered" >
    <thead>
         <th class="active">BookingId</th>
         <th class="success">BookingDate</th>
         <th class="warning">TravelId</th>
         <th class="danger">TravelName</th>
         <th class="info">NoOfPassengers</th>
         <th class="success">Source</th>
         <th class="danger">Destination</th>
         <th class="info">Distance</th>
         <th class="success">ArrivalTime</th> 
         <th class="warning">DepatureTime</th>
         <th class="danger">TravelDuration</th>
         <th class="info">DateOfJourney</th>
         <th class="active">FinalFare</th>
         <th class="warning">Route</th>
         
         </thead>
        	
     <tbody>
      <tr ng-repeat="Bookings" >
      <td >{{SearchedBooking.bookingId}}</td>
      <td >{{SearchedBooking.bookingDate}}</td>
      <td >{{SearchedBooking.travel.travelId}}</td>
      <td >{{SearchedBooking.travel.travelName}}</td>
     <td >{{SearchedBooking.noOfPassengers}}</td>  
      <td >{{SearchedBooking.source}}</td> 
      <td >{{SearchedBooking.destination}}</td> 
      <td >{{SearchedBooking.distance}}</td> 
      <td >{{SearchedBooking.arrivalTime}}</td> 
      <td >{{SearchedBooking.depatureTime}}</td> 
      <td >{{SearchedBooking.travelDuration}}</td> 
      <td >{{SearchedBooking.dateOfJourney}}</td> 
      <td >{{SearchedBooking.finalFare}}</td> 
      <td >{{SearchedBooking.route.routeId}}</td> 
      
         
     </tr>
     </tbody>
</table>
</div>

</body>
</html>