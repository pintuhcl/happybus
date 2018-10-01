<!DOCTYPE html>
<html lang="en" ng-app="app" ng-controller="search_travel_controller">
<head>
    <script src="js/angular.js"></script> 
    <!-- Bootstrap core CSS -->
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<!-- <link href="webjars/bootstrap/3.3.5/css/bootstrap.theme.min.css"
	rel="stylesheet"> -->
	
	</head>
<body>
    <div class="container" >
    <header class="page-header" >
		<ul class="nav nav-pills  pull-right">
			<li class="active"><a href="/Bus24/">Home</a></li>
			<li class="active"><a href="/Bus24/about/">About</a></li>
			<li class="active"><a href="contact.htm">ContactUs</a></li>
			<li class="active"><a href="searchTravel">SearchTravel</a></li>
		</ul>
	</header>
 <form  class="form-horizontal" ng-hide="flag"> 
 <h2>Search Travel Page</h2>
  <div class="form-group">
    <label for="exampleInputTravelName" class="col-sm-2 control-label">Enter Travel Name</label>
    <div class="col-sm-5">
      <input type="text" ng-model="travelName" class="form-control" id="exampleInputTravelName" placeholder="TravelName" ng-focus="clearMessage()">
    </div>
  </div>
  
  <div class="form-group">
    <label for="exampleInputCity" class="col-sm-2 control-label">Enter City</label>
    <div class="col-sm-5">
      <input type="text" ng-model="city" class="form-control" id="exampleInputCity" placeholder="City Name" ng-focus="clearMessage()">
    </div>
  </div>
 <div class="row">
  <div class="col-sm-offset-4 com-sm-10">
    <button type="button" class="btn btn-success btn-lg" ng-click="searchTravel(travelName,city)" type="submit" >Search</button>
  </div>
  </div>
 </form>
 <div style="color:red;text-align:center">
 <h1>{{message}}</h1>
 </div>
 <br>
 <div   ng-hide="flag1" >
 <table class="table table-bordered" ng-show="travel.length>0">
    <thead>
         <th class="active">TravelId</th>
         <th class="success">TravelRegNumber</th>
         <th class="warning">TravelName</th>
         <th class="danger">PhoneNumber1</th>
         <th class="info">PhoneNumber2</th>
         <th class="success">Website</th>
         <th class="danger">AddressLine1</th>
         <th class="info">AddressLine2</th>
         <th class="success">City</th> 
         <th class="warning">State</th>
         <th class="danger">Zipcode</th>
         <th class="info">Status</th>
         <th class="active">BankId</th>
         <th class="warning">AccountNumber</th>
         
         <th class="success">BankName</th>
         <th class="info">IfscCode</th>
         <th class="danger">BankBranch</th>
         <th class="success">AccHolderName</th>
         <th class="warning">OPERATION</th>
     </thead>
     <tbody>
      <tr ng-repeat="travels in travel" >
        <td class="active">{{travels.travelId}}</td>
        <td class="success">{{travels.travelRegNumber}}</td>
        <td class="warning">{{travels.travelName}}</td>
        <td class="danger">{{travels.phoneNumber1}}</td>
        <td class="info">{{travels.phoneNumber2}}</td>
        <td class="success">{{travels.website}}</td>
        <td class="danger">{{travels.addressLine1}}</td>
        <td class="info">{{travels.addressLine2}}</td>
        <td class="success">{{travels.city}}</td>
        <td  class="warning">{{travels.state}}</td>
        <td class="danger">{{travels.zipcode}}</td>
        <td class="info">{{travels.status}}</td>
        <td class="active">{{travels.bankDetails.bankId}}</td>
        <td  class="warning">{{travels.bankDetails.accountNumber}}</td>
        <td  class="success">{{travels.bankDetails.bankName}}</td>
        <td class="info">{{travels.bankDetails.ifscCode}}</td>
        <td class="danger">{{travels.bankDetails.bankBranch}}</td>
        <td class="success">{{travels.bankDetails.accHolderName}}</td>
        <td class="warning"><button ng-click="editTravel(travels)" class="btn btn-success btn-md">Edit</button></td>
  
     </tr>
     </tbody>
</table>
</div>

<div class="col-sm-offset-3 com-sm-10" ng-hide="flag3">
<form ng-show="flag1" >
<header class="page-header">
		<h2>Update Travel Page</h2>
	</header>
	  <div class="row">
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>TravelId</label>
                  <input type="text" ng-model=selected.travelId  maxlength="100" id="travelId" class="form-control" ng-disabled="true"></input>
               </div>
         </div>
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>TravelRegNumber</label>
                  <input type="text"   ng-model=selected.travelRegNumber  maxlength="100" id="agencyName" class="form-control" >
               </div>
         </div>
    </div><!-- one Row -->
	<div class="row">
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>TravelName</label>
                  <input type="text" ng-model=selected.travelName maxlength="100" id="travelName" class="form-control">
               </div>
         </div>
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>PhoneNumber1</label>
                  <input type="text" ng-model=selected.phoneNumber1 maxlength="15" id="ph1" class="form-control" >
               </div>
         </div>
    </div><!--2nd Row -->
	<div class="row">
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>PhoneNumber2</label>
                  <input type="number" ng-model=selected.phoneNumber2 maxlength="100" id="ph2" class="form-control">
               </div>
         </div>
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>Website</label>
                  <input type="text" ng-model=selected.website maxlength="100" id="website" class="form-control" >
               </div>
         </div>
    </div><!--3rd Row -->
   <div class="row">
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>AddressLine1</label>
                  <input type="text"ng-model=selected.addressLine1 maxlength="100" id="addrs1" class="form-control" >
               </div>
         </div>
         <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>AddressLine2</label>
                  <input type="text" ng-model=selected.addressLine2 maxlength="100" id="addrs2" class="form-control">
               </div>
         </div>
    </div><!--4th Row -->
    <div class="row">
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                   <label>City</label>
                   <input type="text" ng-model=selected.city maxlength="100" id="city" class="form-control" >
              </div>
         </div>
         <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>State</label>
                  <input type="text" ng-model=selected.state maxlength="100" id="state" class="form-control">
               </div>
         </div>
    </div><!--5th Row -->
    <div class="row">   
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>zipcode</label>
                  <input type="text" ng-model=selected.zipcode maxlength="100" id="zipCode" class="form-control" >
               </div>
         </div>
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>Status</label>
                  <input type="text" ng-model=selected.status maxlength="100" id="status" class="form-control">
               </div>
    </div>
    </div><!--6th Row -->
         <!--7th Row --> 
	<div class="row">
	     <p style="color:red">Bank Details</p>
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>BankId</label>
                  <input type="text" ng-model=selected.bankDetails.bankId maxlength="100" id="bankId" class="form-control" disabled="true">
               </div>
         </div>
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>AccountNumber</label>
                  <input type="text" ng-model=selected.bankDetails.accountNumber maxlength="100" id="accNo" class="form-control" >
               </div>
         </div>
    </div><!--8th Row --> 
	<div class="row">
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>BankName</label>
                  <input type="text" ng-model=selected.bankDetails.bankName maxlength="100" id="bankName" class="form-control" >
               </div>
         </div>
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>ifscCode</label>
                  <input type="text" ng-model=selected.bankDetails.ifscCode maxlength="100" id="ifscCode" class="form-control" >
               </div>
         </div>
    </div><!--9th Row --> 
	<div class="row">
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>BankBranch</label>
                  <input type="text" ng-model=selected.bankDetails.bankBranch maxlength="100" id="BankBranch" class="form-control">
               </div>
         </div>
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>accHolderName</label>
                  <input type="text"ng-model=selected.bankDetails.accHolderName maxlength="100" id="accHolName" class="form-control" >
               </div>
         </div>
    </div><!--10th Row --> 
	<div class="col-sm-offset-3 com-sm-10">
        <button type="button"  class="btn btn-primary ,btn btn-lg" ng-click="updateTravel()">Update</button>
   </div>
</form>
</div>
 
    <script>
        var app=angular.module("app",[]);
        app.controller("search_travel_controller",search_travel_controller);
    	$scope.selected = {};
        function search_travel_controller($scope,$window,$http) {    	
        	$scope.editTravel=function(travels){
        		$scope.flag1=true;
        		 $scope.selected = angular.copy(travels);
        	}
        	$scope.updateTravel=function(){
        		$scope.flag2=true;
        		$http({
        			method : "post",
       				url : "/Bus24/updateTravel",
       				params : {
       					"travelId":$scope.selected.travelId,
       					"travelRegNumber": $scope.selected.travelRegNumber  ,
       					"travelName":$scope.selected.travelName,
       					"phoneNumber1":$scope.selected.phoneNumber1,
       					"phoneNumber2":$scope.selected.phoneNumber2,
       					"website":$scope.selected.website,
       					"addressLine1":$scope.selected.addressLine1,
       					"addressLine2":$scope.selected.addressLine2,
       					"city":$scope.selected.city,
       					"state":$scope.selected.state,
       					"zipcode":$scope.selected.zipcode,
       					"status":$scope.selected.status,
       					"bankId":$scope.selected.bankDetails.bankId,
       					"accountNumber":$scope.selected.bankDetails.accountNumber,
       					"bankName":$scope.selected.bankDetails.bankName,
       					"ifscCode":$scope.selected.bankDetails.ifscCode,
       					"bankBranch":$scope.selected.bankDetails.bankBranch,
       					"accHolderName":$scope.selected.bankDetails.accHolderName
       				}
        		}).then(function(result){
                   $scope.response=result.data;
        			if( $scope.response.status=="SUCCESS"){
        				$scope.flag3=true;
        				$scope.message="Record Updated Successfully";
        			}
        			else {
        			       $scope.message = $scope.response.message;
        			       
        			      }
        		},function(result){
        			$window.alert("fail");
        		});
        	}
           $scope.searchTravel=function(travelName,cityName){
        	   $scope.flag=false; 
        	   $http({
   				method : "post",
   				url : "/Bus24/searchTravel",
   				params : {
   					"travelName": travelName,
   					"city" : cityName
   			    }
   			}).then(function(result) {
   					$scope.jsonTravelList = result.data;
   					if($scope.jsonTravelList.length>0){
   						$scope.flag="true";
   	   	   			 $scope.travel = angular.fromJson($scope.jsonTravelList);
   					}else{
   						$scope.message="Record Not Found";
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
    <hr>
		<footer>
		<p style="color:blue;text-align:center">&copy:2017 Search Travel Page Design by: ESHWAR</p>
		</footer>
		</div><!--  end container-->
    </body>	
</html>