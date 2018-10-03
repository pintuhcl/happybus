<html>
<head>
<link rel="stylesheet" href="bootStrap/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" 
type="text/css" media="screen" />
</head>
<fieldset>
<nav class="navbar navbar-default " role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
	  	<div class="horizontal-menu">
        <ul>
            <li><a href="#" >HOME</a></li>
            <li><a href="#">ChangePassword</a></li>
            <li><a href="#">MyProfile</a></li>
            <li><form id="logout" action="logout" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<a href="javascript:document.getElementById('logout').submit()">Logout</a>
</form></li>
        </ul>
    </div>
    </div>
  </div>
</nav>
<h3 style="color:Green" align="center">Welcome To Cash Deposit</h3>
</fieldset>
</html>