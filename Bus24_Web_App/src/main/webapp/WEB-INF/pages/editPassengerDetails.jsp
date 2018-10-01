 <!DOCTYPE html>
<html lang="en" ng-app="app" ng-controller="my_profile_controller">
<%@page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <script src="js/angular.js"></script> 
    <!-- Bootstrap core CSS -->
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<!-- <link href="webjars/bootstrap/3.3.5/css/bootstrap.theme.min.css"
	rel="stylesheet"> -->
	<link rel="stylesheet" href="/w3css/4/w3.css">
	
</head>
	<body>
    <div class="container">
    <header class="page-header" >
		<ul class="nav nav-pills  pull-right">
			<li class="active"><a href="/Bus24/">Home</a></li>
			<li class="active"><a href="/Bus24/about/">About</a></li>
			<li class="active"><a href="contact.htm">ContactUs</a></li>
		</ul>
	</header>
<h1>MY PROFILE</h1>
<div class="col-sm-offset-4 com-sm-10">
<div ng-hide="flag1">
<table class="table table-bordered"  ng-hide="user.length>0">
   <thead>
      
      <tr > <th class="active"> USERNAME </th>  <td class="active">${user.userName}</td> </tr><br>
      <tr> <th class="success">USERROLE</th> <td class="success">${user.userRole}</td></tr><br>
       <tr> <th class="warning">EMAIL</th> <td class="warning">${user.email}</td></tr><br>
       <tr> <th class="danger"> MOBILE</th> <td class="danger">${user.mobile}</td></tr><br>
       <tr>  <th class="info">FIRSTNAME</th><td class="info">${user.firstName}</td></tr><br>
       <tr><th class="success"> LASTNAME</th> <td class="success">${user.lastName}</td></tr><br>
       <tr><th class="danger"> ADDRESS</th><td class="warning">${user.address}</td></tr><br>
       <tr><th class="info"> ZIPCODE</th><td class="danger">${user.zipCode}</td></tr><br>
       <tr> <th class="success">STATUS</th><td class="info">${user.status}</td></tr><br>
    
     </thead>
     
</table>
<td  class="sucess"><button align="center" ng-click="editprofile(profile)" align="center" class="btn btn-success btn-md">Edit</button></td>
</div>


 </div>
 
 <div class="col-sm-offset-3 com-sm-10" ng-hide="flag2" >
<form  ng-show="flag1">
<header class="page-header">
		<h2>Update MY PROFILE</h2>
	</header>
	  <div class="row">
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>USERNAME</label>
                  <input type="text" data-ng-model="userName" value = ${user.userName} ng-init="userName=${user.userName}"maxlength="100" id="userName"   class="form-control" ng-disabled="true"></input>
               </div>
         </div>
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>USERROLE</label>
                  <input type="text"   ng-model=selected.userRole  maxlength="100" id="userRole" class="form-control" >
               </div>
         </div>
    </div><!-- one Row -->
	<div class="row">
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label> EMAIL</label>
                  <input type="text" ng-model=selected.email maxlength="100" id="eamil" class="form-control">
               </div>
         </div>
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>MOBILE</label>
                  <input type="text" ng-model=selected.mobile maxlength="10" id="mobile" class="form-control" >
               </div>
         </div>
    </div><!--2nd Row -->
	<div class="row">
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>FIRSTNAME</label>
                  <input type="text" ng-model=selected.firstName maxlength="100" id="firstName" class="form-control">
               </div>
         </div>
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>LASTNAME</label>
                  <input type="text" ng-model=selected.lastName maxlength="100" id="lastName" class="form-control" >
               </div>
         </div>
    </div><!--3rd Row -->
   <div class="row">
          <div class="col-lg-4 col-md-4">
               <div class="form-group">
                  <label>Address</label>
                  <input type="text"ng-model=selected.address maxlength="100" id="address" class="form-control" >
               </div>
         </div>
         
    </div><!--4th Row -->
  
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
    </div>
    <div class="col-sm-offset-3 com-sm-10">
        <button type="button"  class="btn btn-primary ,btn btn-lg" ng-click="updateprofile()">Update</button>
   </div>
    
       
</form>
</div>




 <script>
        var app=angular.module("app",[]);
        app.controller("my_profile_controller",my_profile_controller);
        $scope.selected={};
    	
        function my_profile_controller($scope,$window,$http) {    	
        	$scope.editprofile=function(profile){
        		 $scope.flag1=true;
        		 $scope.selected = angular.copy(profile);
        	}
        	$scope.updateprofile=function(){
        		
        		$http({
        			method : "post",
       				url : "/Bus24/updateProfile",
       				params : {
       					"USERNAME":$scope.selected.userName,
       					"USERROLE": $scope.selected.userRole  ,
       					"EMAIL":$scope.selected.email,
       					"MOBILE":$scope.selected.mobile,
       					"FIRSTNAME":$scope.selected.firstName,
       					"LASTNAME":$scope.selected.lastName,
       					"ADDRESS":$scope.selected.address,
       					"ZIPCODE":$scope.selected.zipcode,
       					"STATUS":$scope.selected.status
       					
       				}
        		}).then(function(result){
                   $scope.response=result.data;
        			if( $scope.response.status=="SUCCESS"){
        				$scope.flag2=true;
        				
        				$scope.message="Record Updated Successfully";
        			}
        			else {
        			       $scope.message = $scope.response.message;
        			       
        			      }
        		},function(result){
        			$window.alert("fail");
        		});
        	}
             
        }
        
    </script>
 
 
 </body>
 </html>
 
 
 
 
 
 
