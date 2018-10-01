/**
 * This file provide functionality to search buses,seat layout and Ticket
 * Booking *
 * 
 * @author mulayam
 */

var searchBusModule = angular.module("searchBusModule", [ 'ui.bootstrap' ]);

searchBusModule.controller("searchBusController", function($scope, $http,
	$window, $log) {

	$scope.seats = [];
	imgPath = {
		"b" : "images/seats/b_seat.png",
		"s" : "images/seats/s_seat.png",
		"a" : "images/seats/a_seat.png",
		"sb" : "images/seats/b_sleeper.png",
		"ss" : "images/seats/b_sleeper.png",
		"sa" : "images/seats/s_sleeper.png"
	};

	$scope.searchBus = function() {
		var from = $scope.from;
		var to = $scope.to;
		var journeyDate = $scope.journeyDate;
		if (angular.isUndefined(from)) {

			$("#source").focus();

			return;
		} else if (angular.isUndefined(to)) {
			$("#destination").focus();

			return;
		} else if (angular.isUndefined(journeyDate)) {
			$("#journeyDate").focus();

			return;
		}
		$http({
			method : "get",
			url : "/Bus24/searchBus/" + from + "/" + to + "/" + journeyDate
		}).then(function(result) {
			// $log.info( result );
			$scope.busList = angular.fromJson(result.data.data);
			$log.info($scope.busList);

		}, function(result) {
			$window.alert("failed");
		});
	}
	$(document).ready(function() {
		var date = new Date();
		var max = new Date(new Date().setMonth(date.getMonth() + 3));
		$("#journeyDate").datepicker({
			minDate : date,
			maxDate : max,
			dateFormat : 'dd-mm-yy',
			onSelect : function(dateText) {
				$("#journeyDate").val(dateText);
				$scope.journeyDate = dateText;
			}
		});
	});
	$scope.getSource = function() {
		$http({
			method : "get",
			url : "/Bus24/sourceList"
		}).then(function(result) {
			// $log.info( result );
			$scope.sourceList = angular.fromJson(result.data.data);
			// $log.info( $scope.sourceList );
			$('#source').autocomplete({
				source : $scope.sourceList
			});

		}, function(result) {
			$window.alert("failed");
		});

	}


	$scope.getDestination = function() {
		$http({
			method : "get",
			url : "/Bus24/destinationList"
		}).then(function(result) {
			$log.info(result);
			$scope.destinationList = angular.fromJson(result.data.data);
			$log.info($scope.destinationList);

			$('#destination').autocomplete({
				source : $scope.destinationList
			});

		}, function(result) {
			$window.alert("failed");
		});

	}
	$scope.getSource();
	$scope.getDestination();





	$scope.bookingInfo = {};
	$scope.currentRouteId = 0;

	$scope.prepareSeatsLayouts = function(noOfSeats, layputModel, layoutType,
		routeId) {

		$http({
			method : "GET",
			url : "/Bus24/getAllPassengers/" + routeId
		}).then(function(result) {

			// console.log( result );
			$scope.bookingInfo[routeId] = {
				"seats" : {},
				"passengers" : {},
				"amount" : 0
			};
			// Prepare 2+2 seat layout


			var layout = [];
			var upperDecRow = [];

			if (layputModel == "seater" && layoutType == "2+2") {
				cols = parseInt(noOfSeats / 4);
				var count = 1;
				for (var r = 1; r <= 5; r++) {
					var colSeat = [];
					var cc = count;
					if (count > 3)
						cc = count - 1;
					for (var c = 1; c <= cols; c++) {
						if (count != 3) {
							colSeat.push({
								"path" : imgPath["a"],
								"seatNo" : cc,
								"isBooked" : false
							});

							if (count > 3 && c == cols - 1) {

								cc = cc + 5;
							} else {
								cc = cc + 4;
							}
						} else if (count == 3) {
							if (cols == c)
								colSeat.push({
									"path" : imgPath["a"],
									"seatNo" : cc,
									"isBooked" : false
								});else {
								colSeat.push({
									"path" : imgPath["a"],
									"seatNo" : ""
								});
							}
							cc = cc + 4
						}
					}
					upperDecRow.push(colSeat);

					count++;
				}
				layout.push({
					'upperDecRow' : upperDecRow,
					'isVisible' : true
				});
			} else if (layputModel == "sleeper" && layoutType == "2+1") {
				var upper = parseInt(noOfSeats / 2);
				var lower = upper;
				cols = upper / 3;
				var upperDecRow = [];

				var count = 1;
				for (var r = 1; r <= 4; r++) {
					var colSeat = [];
					var currentSeat = count;
					if (r == 3) {
						colSeat.push({
							"path" : imgPath["sa"],
							"seatNo" : ""
						});

						upperDecRow.push(colSeat);
						continue;
					}
					for (var c = 1; c <= cols; c++) {
						colSeat.push({
							"path" : imgPath["sa"],
							"seatNo" : "U" + currentSeat
						});
						currentSeat = currentSeat + 3;
					}
					upperDecRow.push(colSeat);
					count++;
				}

				layout.push({
					'upperDecRow' : upperDecRow,
					'isVisible' : true
				});

				// -------------------------------Lower Dec---------------
				var lowerDecRow = [];
				var count = 1;
				for (var r = 1; r <= 4; r++) {
					var colSeat = [];
					var currentSeat = count;
					if (r == 3) {
						colSeat.push({
							"path" : imgPath["sa"],
							"seatNo" : ""
						});

						lowerDecRow.push(colSeat);
						continue;
					}
					for (var c = 1; c <= cols; c++) {
						colSeat.push({
							"path" : imgPath["sa"],
							"seatNo" : "L" + currentSeat
						});
						currentSeat = currentSeat + 3;
					}
					lowerDecRow.push(colSeat);
					count++;
				}

				layout.push({
					'lowerDecRow' : lowerDecRow,
					'isVisible' : true
				});

			} else if (layputModel == "seater" && layoutType == "3+1") {
				cols = parseInt(noOfSeats / 4);
				var count = 1;
				for (var r = 1; r <= 5; r++) {
					var colSeat = [];
					var cc = count;
					if (count > 3)
						cc = count - 1;
					for (var c = 1; c <= cols; c++) {
						if (count != 4) {

							colSeat.push({
								"path" : imgPath["a"],
								"seatNo" : cc
							});

							if (count > 4 && c == cols - 1) {

								cc = cc + 5;
							} else {
								cc = cc + 4;
							}
						} else if (count == 4) {
							if (cols == c)
								colSeat.push({
									"path" : imgPath["a"],
									"seatNo" : cc
								});else {
								colSeat.push({
									"path" : imgPath["a"],
									"seatNo" : ""
								});
							}
							cc = cc + 4
						}
					}
					upperDecRow.push(colSeat);

					count++;

				}

				layout.push({
					'upperDecRow' : upperDecRow,
					'isVisible' : true
				});

			}
			// Check seat is already booked then disable click event and set red
			// seat icon

			//			$log.info(layout);
			// store Passenger list of this routeId
			var list = angular.fromJson(result.data.data);
			//
			//			$log.info(!angular.isUndefined(layout[0]));
			//			$log.info(!angular.isUndefined(layout[1]));


			angular.forEach(list, function(value, key) {

				// console.log("Seat:"+value.seatNo);
				if (!angular.isUndefined(layout[0])) {
					//					$log.info(layout[0]);

					// iterate seat row
					angular.forEach(layout[0].upperDecRow, function(vr, key) {
						// $log.info( key );
						// iterate seat column
						angular.forEach(layout[0].upperDecRow[key], function(vc, kc) {

							if (value.seatNo == vc.seatNo) {
								//								$log.info("matched:" + value.seatNo);
								if (layputModel == "sleeper" && layoutType == "2+1") {

									//booked sleeper icon
									layout[0].upperDecRow[key][kc].path = imgPath["sb"];
								} else {
									//booked chair icon
									layout[0].upperDecRow[key][kc].path = imgPath["b"];
								}
								layout[0].upperDecRow[key][kc].isBooked = true;
							}
						});

					});
				}
				if (!angular.isUndefined(layout[1])) {
					//					$log.info(layout[1]);
					//					$log.info("ELSE");
					// iterate seat row
					angular.forEach(layout[1].lowerDecRow, function(vr, key) {
						// $log.info( key );
						// iterate seat column
						angular.forEach(layout[1].lowerDecRow[key], function(vc, kc) {

							if (value.seatNo == vc.seatNo) {
								$log.info("matched:" + value.seatNo);
								layout[1].lowerDecRow[key][kc].path = imgPath["sb"];
								layout[1].lowerDecRow[key][kc].isBooked = true;
							}
						});

					});
				}

			});


			// $log.info( layout );
			$scope.seats[routeId] = layout;
			// $log.info($scope.seats[routeId]);



		}, function(result) {
			$window.alert("failed");
			$log.info(result);

		});
	}
	$scope.show = function() {
		if ($scope.isbdVisible) {
			$scope.isbdVisible = false;
		} else {
			$scope.isbdVisible = true;
		}
	}

	$scope.closeSeatLayout = function(routeId) {

		$scope.seats.splice(routeId);
	}
	$scope.seatClick = function(routeId, seatNo, price, i) {

		// ----------------Change Icon start------

		var img = $window.document.getElementById(i);

		$log.info($window.document.getElementById(i).src);


		var src = img.src;
		var index = src.lastIndexOf('/');

		var imgName = src.substring(index + 1);
		var path = src.substring(0, index);

		console.log(imgName);

		if (imgName == "a_seat.png") {
			imgName = "s_seat.png";
		} else if (imgName == "a_sleeper.png") {
			imgName = "s_sleeper.png"
		} else if (imgName == "s_seat.png") {
			imgName = "a_seat.png";
		} else if (imgName == "s_sleeper.png") {
			imgName = "a_sleeper.png";
		}



		$window.document.getElementById(i).src = path + "/" + imgName;

		// ----------------Change Icon End------


		seat = {
			"seatNo" : seatNo,
			"isSelected" : false,
			"color" : "#fff"
		};

		if (angular.isUndefined($scope.bookingInfo[routeId].seats[seatNo])) {
			seat.color = "#0f0";
			$scope.bookingInfo[routeId].amount = $scope.bookingInfo[routeId].amount + price;
			$scope.bookingInfo[routeId].seats[seatNo.toString()] = seat;
			$scope.bookingInfo[routeId].passengers[seatNo.toString()] = {
				"name" : "",
				"age" : "",
				"gender" : "",
				"seatNo" : seatNo
			};

			$log.info($scope.seats[routeId]);


		} else {

			delete $scope.bookingInfo[routeId].seats[seatNo.toString()];

			delete $scope.bookingInfo[routeId].passengers[seatNo.toString()];
			$scope.bookingInfo[routeId].amount = $scope.bookingInfo[routeId].amount - price;

		}


		// $log.info( $scope.bookingInfo[routeId].passengers );

	}
	$scope.showModal = function(routeId, boarding, dropping) {


		$scope.boardingPoint = boarding;
		$scope.droppingPoint = dropping;
		$scope.currentRouteId = routeId;
		$("#myModal").modal('show');
	}
	$scope.hideModal = function() {
		$("#myModal").modal('hide');
	}

	$scope.months = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 ];
	$scope.years = [ 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025 ];


	$scope.book = function() {
		$log.info($scope.boardingPoint);
		$log.info($scope.droppingPoint);
		$log.info($scope.currentRouteId);

		$log.info($scope.bookingInfo[$scope.currentRouteId].amount);
		$log.info($scope.cardNumber);
		$log.info($scope.ceMonth);
		$log.info($scope.ceYear);
		$log.info($scope.cvv);
		$log.info($scope.holderName);


		arr = $scope.bookingInfo[$scope.currentRouteId].passengers;

		var passengers = [];
		angular.forEach(arr, function(key, value) {
			$log.info(key);
			passengers.push(key);

		});
		$http({
			method : "POST",
			url : "/Bus24/bookTicket",
			data : {
				"boardingPoint" : $scope.boardingPoint,
				"droppingPoint" : $scope.droppingPoint,
				"routeId" : $scope.currentRouteId,
				"finalFare" : $scope.bookingInfo[$scope.currentRouteId].amount,
				"user" : {
					"email" : $scope.email,
					"mobile" : $scope.mobile
				},
				"passengers" : passengers
			}
		}).then(function(result) {
			console.log(result.data.data);
			console.log(result.data.message);
			console.log(result.data.dataList);
			alert(result.data.message);

		}, function(result) {
			alert("failed");
		});
	}
});