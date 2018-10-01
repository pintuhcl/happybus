<!DOCTYPE html>
<html lang="en" ng-app="app" ng-controller="search_agent_controller">
<head>
<style>
.footer {
    width: 100%;
    height: 200px;
    background-image:url("images/AgenFfooter.jpg");
    background-size: 100% 100%;
}
a.ty-link.ty-link-white {
     color: #000000; 
}

</style>
    <script src="js/angular.js"></script> 
    <!-- Bootstrap core CSS -->
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<link href="webjars/bootstrap/3.3.5/css/bootstrap.theme.min.css"
	rel="stylesheet">
	</head>
<body>
    <div class="container">
    <header class="page-header">
		<ul class="nav nav-pills  pull-right">
			<li class="active"><a href="/Bus24/">Home</a></li>
			<li class="active"><a href="/Bus24/about/">About</a></li>
			<li class="active"><a href="#">ContactUs</a></li>
		</ul>
		<h2>Search Agent Page</h2>
		</header>
 <form ng-controller="search_agent_controller" class="form-horizontal"> 
  <div class="form-group">
    <label for="exampleInputAgentName" class="col-sm-2 control-label">Enter Agency Name</label>
    <div class="col-sm-5">
      <input type="text"  ng-model="agencyName" class="form-control" id="exampleInputAgentName" placeholder="AgencyName">
    </div>
  </div>
  
 <div class="row">
  <div class="col-sm-offset-4 com-sm-10">
    <button type="button" class="btn btn-primary btn-lg" ng-click="searchAgent()" type="submit" >Search</button>
  </div>
  </div>
  </div>
 </form>
 <hr>
		<footer>
		<p align="center">&copy:2017 Search Agent Page Design by: Damu</p>
		</footer>
</div>
    
    <script>
        var app=angular.module("app",[]);
        app.controller("search_agent_controller",search_agent_controller);
        function search_agent_controller($scope,$window,$http) {
           $scope.searchAgent=function(){
        	   $window.alert('calling');
        	   $http({
   				method : "post",
   				url : "/Bus24/searchAgent",
   				params : {
   					"travelName" :$scope.agencyName
   			    }
   			}).then(function(result) {
   				$window.alert("success");
   				$window.alert(result.data);
       			
   			}, function(result) {
   				$window.alert("fail");
   				$window.alert(result.data);
   			});
           }
        }
    </script>
    <br><br>
    <hr style="width: 100%; color: blue; height: 1px; background-color:#0080ff;" />
    <div class="footer">
 <div class="container">
   <div class="col-sm-6 col-md-12"> 
        <img class="footer-ty-logo" src="images/bus_logo.png" width="30" height="30" alt="Bus24" title="Bus24"> India's largest real time ticket booking platform 
    </div> 
  </div>
 </div>
    </body>	
</html>