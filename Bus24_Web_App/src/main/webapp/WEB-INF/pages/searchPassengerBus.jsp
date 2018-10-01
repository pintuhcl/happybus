
<div class="container bg-primary text-center jumbotron ">
	<!-- 		<h5 class="text-primary">APKE HAR SAFAR ME APKA DOST BUS24 APKE SATH</h5> -->
	<h2
		style="font-weight: bold; font-family: Cambria, Georgia, 'Times New Roman'">Search
		Bus For Ticket</h2>
	<table align="center"
		style="border-spacing: 10px; padding: 30px; min-width: 600px; vertical-align: center">
		<tr>
			<td><label>From</label></td>
			<td><input id="source" type="text" ng-model="from"
				class="form-control" placeholder="Source"></td>

			<td><label>To</label></td>
			<td><input id="destination" type="text" ng-model="to"
				class="form-control" placeholder="Desitination"></td>
			<td><label>Journey Date</label></td>
			<td><input id="journeyDate" ng-model="journeyDate"
				placeholder="Journey Date" class="form-control"></td>
			<td><input type="button" class="btn btn-danger" value="Search"
				ng-click="searchBus()"></td>
		</tr>
	</table>

</div>

<div class="container">
	<div class="row">
		<div class="col-md-12" ng-repeat="bus in busList">
			<div class="row  busRowCard">
				<div class="col-md-4 col-sm-4">

					<b>{{bus.travelName}}</b>
					<p>{{bus.busModel}} {{bus.busType}}( {{bus.layoutType}} )</p>
				</div>
				<div class="col-md-4 col-sm-4">
					<p>
						<b>{{bus.departureTime}} &rarr;{{bus.arrivalTime}}</b>
					</p>
					<p>{{bus.distance}}Km/{{bus.totalTime}}Hr</p>
				</div>
				<div class="col-md-2 col-sm-2">
					<p>
						<b>Seats Available</b>
					</p>
					<p>{{bus.noOfAvaibleSeats==0
						||bus.noOfAvaibleSeats==null?bus.noOfSeats:bus.noOfAvaibleSeats}}</p>

				</div>
				<div class="col-md-2 col-sm-2">
					<p>
						<b>INR </b>{{bus.price}}
					</p>
					<button class="btn btn-danger"
						ng-click="prepareSeatsLayouts(bus.noOfSeats,bus.layoutModel,bus.layoutType,bus.routeId)">Select
						Seats</button>
				</div>
				<div class="col-md-4 col-sm-4">
					<p class="otherInfo">
						<a href="#" class="text-danger">Amenities</a>
					</p>
				</div>
				<div class="col-md-4 col-sm-4">
					<button class="btn-link" ng-click="show()">
						<span class="text-danger">Boarding & Dropping Points</span>
					</button>

				</div>
				<div class="col-md-4 col-sm-4">
					<p class="otherInfo">
						<a href="#" class="text-danger">Cancellation Policy</a>
					</p>
				</div>
			</div>
			<div class="row"
				style="padding: 40px 0px; border: thin solid; background-color: #F3F3F2"
				ng-show="seats[bus.routeId][0].isVisible">
				<button type="button" class="close btn btn-danger"
					ng-click="closeSeatLayout(bus.routeId)">Close</button>
				<div class="col-md-8 col-sm-8">
					<div class="row seatLayoutCard">
						<div>
							<p>
								<b>{{bus.noOfAvaibleSeats==0
									||bus.noOfAvaibleSeats==null?bus.noOfSeats:bus.noOfAvaibleSeats}}
									Seats Available.Click on seat to select/deselect</b>
						</div>

						<!-- 						SeatLayout Start -->
						<table class="seatTable col-md-12">
							<caption ng-if="seats[bus.routeId].length==2">Upper</caption>
							<tr>
								<td rowspan="6"
									style="border-right: thin solid; vertical-align: top; padding-top: 20px;"><img
									src="images/seats/man-driving.png" /></td>
							</tr>
							<tr ng-repeat="row in seats[bus.routeId][0].upperDecRow">
								<td ng-repeat="r in row track by $index">
								
								<span
									ng-if="r.seatNo==''"> 
								</span> 
								<!-- Show button with black icon and event-->

									<img id="{{this.$id}}" ng-if="r.seatNo!='' && (!r.isBooked)"
									style="cursor: pointer; width: 30px; height: 30px;"
									ng-click="seatClick(bus.routeId,r.seatNo,bus.price,this.$id)"
									ng-src={{r.path}} ng-disabled="true" tooltip-placement="top"
									uib-tooltip="Seat No: {{r.seatNo}}" /> 
									
									<!-- Show button with  with red icon without event-->
									
									<img id="{{this.$id}}" ng-if="r.seatNo!='' && r.isBooked"
									ng-src={{r.path}} tooltip-placement="top" uib-tooltip="Booked"></td>
							</tr>
						</table>
						<table ng-if="seats[bus.routeId].length==2"
							class="seatTable col-md-12">
							<caption>Lower</caption>
							<tr>
								<td rowspan="6"
									style="border-right: thin solid; vertical-align: top; padding-top: 20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							</tr>
							<tr ng-repeat="row in seats[bus.routeId][1].lowerDecRow">
								<td ng-repeat="r in row track by $index"><span
									ng-if="r.seatNo==''"> </span> <!-- Show button with black icon and event-->

									<img id="{{this.$id}}" ng-if="r.seatNo!='' && (!r.isBooked)"
									style="cursor: pointer; width: 30px; height: 30px;"
									ng-click="seatClick(bus.routeId,r.seatNo,bus.price,this.$id)"
									ng-src={{r.path}} ng-disabled="true" tooltip-placement="top"
									uib-tooltip="Seat No: {{r.seatNo}}" /> <!-- Show button with  with red icon without event-->

									<img ng-if="r.seatNo!='' && r.isBooked" ng-src={{r.path}}
									tooltip-placement="top" uib-tooltip="Booked"></td>
							</tr>
						</table>
						<!-- 						Seat Layout End -->
					</div>

				</div>
				<div class="col-md-4 col-sm-4">
					<p>
						Onward Journey From <b>{{from}}</b> To <b>{{to}}</b> <b>{{journeyDate}}</b>
					</p>
					<hr />
					<table cellpadding="20px">
						<tr>
							<td>Select Seats:</td>
							<th><span
								ng-repeat="s in bookingInfo[bus.routeId].seats  track by $index">
									{{s.seatNo}} </span></th>

						</tr>
						<tr>
							<td>Total Amount:</td>
							<th>{{bookingInfo[bus.routeId].amount}}</th>
						</tr>
						<tr>
							<td>Boarding Point</td>

							<td><select ng-model="boardingPoint" class="form-control"
								ng-options="b for b in bus.boradingPoints.split(',')">
							</select></td>
						</tr>

						<tr>
							<td>Dropping Point</td>
							<td><select ng-model="droppingPoint" class="form-control"
								ng-options="d  for d in  bus.dropingPoints.split(',')">
							</select></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2" align="center"><Button
									class="btn btn-sm btn-danger"
									ng-click="showModal(bus.routeId,boardingPoint,droppingPoint)">Continue</Button></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Passenger Details Modal -->
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" ng-click="hideModal()">&times;</button>
				<h4 class="modal-title">Passenger Details</h4>
				Selected Seats:<span
					ng-repeat="s in bookingInfo[currentRouteId].seats  track by $index">
					<b>{{s.seatNo}}&nbsp;&nbsp;&nbsp;&nbsp; </b>
				</span> &nbsp;&nbsp;&nbsp; Amount: <b>{{bookingInfo[currentRouteId].amount}}</b>

				<h5>
					Onward Journey From <b>{{from}}</b> To <b>{{to}}</b> <b>{{journeyDate}}</b>
				</h5>

			</div>

			<div class="modal-body" style="padding: 10px 40px;">
				<div class="row">

					<div class="col-md-12">
						<table class="table table-bordered">
							<tr>
								<th>Name</th>
								<th>Gender</th>
								<th>Age</th>
								<th>SeatNo</th>
							</tr>
							<tr ng-repeat="p in bookingInfo[currentRouteId].passengers">
								<td><input type="text" class="form-control"
									ng-model="p.name" placeholder="Enter Name"></td>
								<td><select class="form-control" ng-model="p.gender">
										<option>Male</option>
										<option>Female</option>
								</select></td>
								<td><input ng-model="p.age" type="text"
									class="form-control" placeholder="Enter Age"></td>
								<td><input ng-model="p.seatNo" type="text"
									class="form-control" ng-disabled="true"></td>
							</tr>
						</table>
						<hr />
						<h5>Contact Details</h5>
						<div class="form-horizontal">
							<div class="form-group">
								<label class="control-label col-sm-2">Email:</label>
								<div class="col-sm-6">
									<input type="email" class="form-control" ng-model="email"
										placeholder="Enter email">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">Mobile:</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" ng-model="mobile"
										placeholder="Enter Mobile">
								</div>
							</div>
						</div>
						<hr />
						<h5>Make Payment</h5>
						<div class="form-horizontal">
							<div class="form-group">
								<label class="control-label col-sm-2">Debit Card No:</label>
								<div class="col-sm-6">
									<input maxlength="16" type="cardNumber" ng-model="cardNumber"
										class="form-control" placeholder="Enter Card ">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">Expiry Date</label>
								<div class="col-sm-6">
									<select ng-model="ceMonth" ng-options="m for m in months">
										<option value="">--Month--</option>
									</select> <select ng-model="ceYear" ng-options="y for y in years">
										<option value="">--Year--</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">CVV</label>
								<div class="col-sm-4">
									<input type="password" maxlength="4" ng-model="cvv"
										class="form-control" placeholder="Enter CVV">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2">Name On Card</label>
								<div class="col-sm-6">
									<input type="cvv" ng-model="holderName" class="form-control"
										placeholder="Enter Name On Card">
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-6">
						<button class="btn btn-danger" ng-click="book()">Confirm
							Booking</button>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				</div>
			</div>
		</div>
	</div>
</div>
