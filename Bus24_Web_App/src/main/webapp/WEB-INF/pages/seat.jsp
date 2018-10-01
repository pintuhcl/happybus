<html ng-app="bus" ng-cloak>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- Angular Material style sheet -->
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.0/angular-material.min.css">
		<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script> -->
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
<style type="text/css">
			html, body {
				height: 100%;
			}
			.passsenger-info{
				margin-left: 500px;

			}
			.upper-deck, .lower-deck{
				height: 150px;
				width: 340px;
				border: 1px solid black;
				margin: 20px;
			}
			.seat{
				 
				height: 20px;
				width: 50px;
				background: white;
				border: 1px solid black;
				margin: 8px;
				display: inline-block;
				cursor: pointer;
				text-align: center;
			}
			.booked{
				background: gray !important;
				color: white;
			}
			.info{
				height: 150px;
			    margin: 20px;
			    width: 250px;
			    border: 1px solid black;
			   

			}
				 .btn-success {
      background: #000;
      color: #fff;
   }
  .btn-default:hover {
      background: #fff;
      color: #000;
   }
		</style>
		<style type="text/css">
			.contentdemoBasicUsage div.demo-content {
			  height: 450px; 
			}

			.contentdemoBasicUsage div[ng-controller] {
			  height: 100%;
			  padding-bottom: 15px; 
			}

			.contentdemoBasicUsage md-content {
			  padding: 24px; 
			}
		</style>
		<!-- Angular Material requires Angular.js Libraries -->
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js"></script>

		<!-- Angular Material Library -->
		<script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.0/angular-material.min.js"></script>
		  
		<!-- Your application bootstrap  -->
		<script type="text/javascript">    
		    /**
		     * You must include the dependency on 'ngMaterial' 
		     */
		    angular.module('bus', ['ngMaterial']);
		</script>
		<script type="text/javascript">
		// angular.module("bus", []);

		angular.module("bus")
			.controller("bookingCtrl",['$scope', '$mdSidenav', '$mdDialog', '$log', '$http', function($scope, $mdSidenav, $mdDialog, $log, $http){

				$scope.isSidebarOpen = false;

				$scope.allPassengers = [];

				$scope.toogleSideNav = function(){
					$mdSidenav('left')
			          .toggle()
			          .then(function () {
			            $log.debug("toggle left is done");
			        });
				}

				$scope.totalSeats = $scope.availableSeats = 30;
				$scope.fairPerSeat = 500;
				$scope.totalFair = 0;
				
				$scope.upperDeckSeats = [];
				$scope.lowerDeckSeats = [];

				for(var i = 1; i <= $scope.totalSeats/2; i++){
					$scope.upperDeckSeats.push({
						seatNum : i,
						availability : 1
					});
					}
						for(var i = 16; i <= $scope.totalSeats; i++){
		
					$scope.lowerDeckSeats.push({
						seatNum : i,
						availability : 1
					});
				}
			
				

				$scope.toogleSeatBooking = function(upperOrLower, seatNum, availability){
					
					if(availability == 0){
						var idx = $scope.allPassengers.findIndex(function(o){
							return o.seat_num == seatNum;
						});

						if(idx!==-1){
							$scope.allPassengers.splice(idx, 1);
						}
						
					}else{
						$scope.allPassengers.push({
							seat_num : seatNum,
							name: '',
							age : '',
							gender : ''
						});
					}
					

					if(upperOrLower == 'upper'){
						var idx = $scope.upperDeckSeats.findIndex(function(obj){
							return obj.seatNum == seatNum;
						});

						if(idx!==-1){
							$scope.upperDeckSeats[idx].availability = $scope.upperDeckSeats[idx].availability == 0 ? 1 : 0;
						}
						
					}else if(upperOrLower == 'lower'){
						var idx = $scope.lowerDeckSeats.findIndex(function(obj){
							return obj.seatNum == seatNum;
						});

						if(idx!==-1){
							$scope.lowerDeckSeats[idx].availability = $scope.lowerDeckSeats[idx].availability == 0 ? 1 : 0;
						}
					}

					$scope.availableSeats = $scope.upperDeckSeats.filter(function(obj){
						return obj.availability == 1;
					}).length + $scope.lowerDeckSeats.filter(function(obj){
						return obj.availability == 1;
					}).length;

					$scope.totalFair = ($scope.totalSeats - $scope.availableSeats) * $scope.fairPerSeat;

				}

				$scope.submitBookingDetails = function(){
					$http.post('my-api', $scope.allPassengers).then(function(response){
						console.log("the response is :", response);
					}, function (error) {
						console.log("the error is :", error);
					});
					
				}

			}])
			.controller('leftCtrl', function ($scope, $timeout, $mdSidenav, $log) {
				

			    $scope.close = function () {
			      // Component lookup should always be available since we are not using `ng-if`
			      $mdSidenav('left').close()
			        .then(function () {
			          $log.debug("close LEFT is done");
			        });
			    };
			 });
	</script>
	</head>
	<body flex ng-controller="bookingCtrl">

		<md-toolbar class="md-hue-2">
	      <div class="md-toolbar-tools">
	        <md-button class="md-icon-button" aria-label="Menu" ng-click="toogleSideNav();">
	          <i class="material-icons" style="color: white;">menu</i>
	        </md-button>

	        <h2 flex md-truncate>Bus 24</h2>

	        <md-button class="md-icon-button" aria-label="Favorite">
	          <!-- <md-icon md-svg-icon="img/icons/favorite.svg" style="color: greenyellow;"></md-icon> -->
	        </md-button>

	        <md-button class="md-icon-button" aria-label="More">
	          <!-- <md-icon md-svg-icon="img/icons/more_vert.svg"></md-icon> -->
	        </md-button>
	      </div>
	    </md-toolbar>

	    <md-sidenav style="height: 100%;position: absolute;" class="md-sidenav-left md-whiteframe-4dp" flex md-component-id="left"  md-is-locked-open="isSidebarOpen">

	      <md-toolbar class="md-theme-light">
	        <h1 class="md-toolbar-tools">Navigtion</h1>
	      </md-toolbar>
	      <md-content>
	        <md-list ng-cloak>
			  <md-list-item>
			  	First
			    <md-checkbox class="md-secondary" style="display:none;"></md-checkbox>
			  </md-list-item>
			  <md-divider></md-divider>
			  <md-list-item>
			  	Second
			    <md-checkbox class="md-secondary" style="display:none;"></md-checkbox>
			  </md-list-item>
			  <md-divider></md-divider>
			  <md-list-item>
			  	Third
			    <md-checkbox class="md-secondary" style="display:none;"></md-checkbox>
			  </md-list-item>
			  <md-divider></md-divider>
			  
			 </md-list>
	      </md-content>

	    </md-sidenav>

	    <md-content flex layout-padding>
    		<div class="container">
				<div class="upper-deck">
					<div ng-repeat="seat in upperDeckSeats" class="seat" ng-class="seat.availability == 1 ? 'available' : 'booked'"  ng-click="toogleSeatBooking('upper', seat.seatNum, seat.availability);">
					  	{{ seat.seatNum }} U
					</div>

				</div>
				
				<div class="lower-deck" >
					<div  ng-repeat="seat in lowerDeckSeats" class="seat" ng-class="seat.availability == 1 ? 'available' : 'booked'"  ng-click="toogleSeatBooking('lower', seat.seatNum, seat.availability);">
					  	{{ seat.seatNum }} L
					</div>
				</div>
				<div class="passsenger-info">
					<table class="table table-bordered">
						  <tr class="success">
							<td>Name</td>
							<td>Gender</td>
							<td>Age</td>
							<td>Seat Number</td>
						</tr>
						<tr ng-repeat="passenger in allPassengers">
							<td> <input type="text" ng-model="passenger.name"> </td>
							<td> 
								<select ng-model="passenger.gender">
									<option>--Select--</option>
									<option value="male">Male</option>
									<option value="female">Female</option>
								</select>

							</td>
							<td> <input type="number" ng-model="passenger.age"> </td>
							<td> {{ passenger.seat_num }} </td>
						</tr>
					</table>
					<button class="btn btn-success btn-lg" ng-click="submitBookingDetails();">Booking</button>
				</div>
				<!-- ./lower-deck -->
				<div class="info">
					<h4>Total Seats : {{ totalSeats }}</h4>
					<h4>Available Seats : {{ availableSeats }}</h4>
					<h4>Total Fair : {{ totalFair }}</h4>
				</div>

				
			</div>
			<!-- ./containet -->
  		</md-content>
	</body>
</html>