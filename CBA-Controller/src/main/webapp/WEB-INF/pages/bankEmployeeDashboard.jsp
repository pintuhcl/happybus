<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@ include file="header.jsp"%>
<html ng-app="bank-module1">
<%@page isELIgnored="false" %>
<head>
<script type="text/javascript" src="js/angular.js"></script>

<link href="css/angular-datepicker.css" rel="stylesheet" type="text/css" />
<script src="js/angular-datepicker.js"></script>
<!-- <script type="text/javascript"
src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>
 -->
<script type="text/javascript">
	var app = angular.module("bank-module1", [ '720kb.datepicker' ]);
	app
			.controller(
					"bank-controller",
					function($scope, $window, $http) {
						$scope.balanceWindowFlag = false;
						$scope.accNumDivFlag = false;
						$scope.accountStatusButtonFlag = false;
						$scope.messageFlag = false;
						$scope.accountStatusFlag = false;
						$scope.depositAmtFlag = false;
						$scope.depositButtonFlag = false;
						$scope.withdrawButtonFlag = false;
						$scope.chequeDetailsFlag = false;
						$scope.ddDetailsFlag = false;
						$scope.depositStatusFlag = false;
						$scope.withdrawStatusFlag = false;
						$scope.showDepositWindow = function() {
							$scope.fundsTransferWindowFlag = false;
							$scope.balanceWindowFlag = false;
							$scope.depositStatusFlag = false;
							$http({
								method : "get",
								url : "/CBA/deposit"
							}).then(function(result) {
								$scope.accNumDivFlag = true;
								$scope.withdrawDivFlag =false;
								$scope.accountStatusButtonFlag = true;
								$scope.messageFlag = false;
								$scope.accountStatusFlag = false;
								$scope.depositAmtFlag = false;
								$scope.depositButtonFlag = false;
								$scope.accountNumber = "";
							}, function(result) {
								//show error msg
								$window.alert("failure");
							});
						}
						
						//withdraw
						$scope.showWithdrawWindow = function() {
							$scope.fundsTransferWindowFlag = false;
							$scope.balanceWindowFlag = false;
							$scope.accNumDivFlag = false;
							$scope.withdrawStatusFlag = false;
							$scope.accountStatusFlag=false;
							$scope.withdrawButtonFlag=false;
							
							$http({
								method : "get",
								url : "/CBA/withdraw"
							}).then(function(result) {
								$scope.withdrawDivFlag =true;
								$scope.accountStatusButtonFlag = true;
								$scope.accNumDivFlag = false;
								$scope.withdrawAmtFlag = false;
								accountStatusButtonFlag=true;
								$scope.accountNumber = "";
							}, function(result) {
								//show error msg
								$window.alert("failure");
							});
						}
						
						//withdraw acount status
						$scope.withdrawAccountStatus = function() {
							$scope.withdrawAmount="";
							$scope.transDesc="";
							$scope.paymentMode="";
							$scope.msg="";
							
							$scope.accountStatusFlag=false;
							console.log("checkAccountStatus : "
									+ $scope.accountNumber);

							$http({
								method : "post",
								url : "/CBA/checkAccountStatus",
								params : {
									"accountNumber" : $scope.accountNumber
								}
							})
									.then(
											function(result) {
												console.log("success : "
														+ result);
												$scope.response = result.data;
												$window.alert("success")
												console
														.log($scope.response.status
																+ " "
																+ $scope.response.message);
												if ($scope.response.status == "SUCCESS") {
													$scope.data = $scope.response.data;
													$scope.accountStatus = angular
															.fromJson($scope.data);
													$scope.accStatus = "Account is "
															+ $scope.accountStatus.accountStatus;
													if ($scope.accountStatus.accountStatus == "ACTIVE") {
														$scope.withdrawAmtFlag = true;
														$scope.accountStatusFlag = true;
														$scope.accountStatusButtonFlag = false;
														$scope.withdrawButtonFlag = true;
														$scope.msgFlag = false;
														$scope.branchName = $scope.accountStatus.branchName;
														$scope.accHolderName = $scope.accountStatus.accountHolderName;
														$scope.accountId = $scope.accountStatus.accountId;
														$scope.totalBalance = $scope.accountStatus.totalBalance;
													} else {
														$scope.accountStatusFlag = true;

													}

												} else {
													$scope.msg = $scope.response.message
													$scope.msgFlag = true;
													$scope.accountStatusFlag = false;
												}

											},
											function(result) {
												$window.alert("failure");
												console.log("failure : "
														+ result);

											});
						}
						
						$scope.chequeDetails = function() {
							$scope.chequeDetailsFlag = true;
							
						}
						
						$scope.cashDetails = function() {
							$scope.chequeDetailsFlag = false;
							
						}

						$scope.withdraw = function() {
							$scope.number = "";
							$scope.issuedBy = "";
							$scope.issuedDate = "";
							$scope.issuedBranch = "";
							if ($scope.chequeDetailsFlag == true) {
								$scope.transactionMode = "Self cheque";
								$scope.number = $scope.chequeNumber;
								$scope.issuedBy = $scope.chequeIssuedBy;
								$scope.issuedDate = $scope.chequeIssuedDate;
								$scope.issuedBranch = $scope.chequeIssuedBranch;
							}  else {
								$scope.transactionMode = "Payslip";
							}

							$http({
								method : "post",
								url : "/CBA/withdraw",
								params : {
									"accountNumber" : $scope.accountNumber,
									"accountId" : $scope.accountId,
									"withdrawAmount" : $scope.withdrawAmount,
									"transDesc" : $scope.transDesc,
									"transactionMode" : $scope.transactionMode,
									"number" : $scope.number,
									"issuedBy" : $scope.issuedBy,
									"issuedDate" : $scope.issuedDate,
									"issuedBranch" : $scope.issuedBranch
									
								}
							})
									.then(
											function(result) {
												console
														.log("withdraw Operation success");
												$scope.response = result.data;
												$scope.withdrawStatus = $scope.response.message;
												$scope.msgFlag = false;
												$scope.withdrawStatusFlag = true;
												if ($scope.response.status = "SUCCESS") {
													$scope.transactionId = "Transaction Id : "
															+ $scope.response.data;
													$scope.accountStatusFlag = false;
													$scope.withdrawAmtFlag = false;
													$scope.withdrawButtonFlag = false;
												} else {

												}
											},
											function(result) {
												console
														.log("withdraw operation Failure");
											});
						}
						

						//balance enquiry section
						$scope.balanceWindowFlag = false;
						$scope.balanceResultsFlag = false;
						$scope.messageFlag = false;
						

						$scope.accHloderNameForBalEnquiry = "";
						$scope.accStatusForBalEnquiry = "";
						$scope.accBalanceForBalEnquiry = "";
						$scope.accNumForBalEnquiry = "";
						$scope.showBalanceWindow = function() {
							$scope.fundsTransferWindowFlag = false;
							$scope.accNumDivFlag = false;
							$scope.withdrawDivFlag =false;
							$scope.balanceWindowFlag = true;
							$scope.messageFlag = false;
							
							$scope.checkBalance = function() {
								$http({
									//ajax call
									method : "get",
									url : "/CBA/balanceEnquiry",
									params : {
										"accountNumber" : $scope.accNumForBal

									}
								}).then(function(result) {
													//success function
													//result holds status,message,data
													//console.log(result);
													

													//$window.alert("account found");
													$scope.response = result.data;
													$scope.data = angular
															.fromJson($scope.response.data);
													console.log($scope.response.status);
													if ($scope.response.status == "SUCCESS") {
														//$scope.balanceWindowFlag=false;
														$scope.messageFlag = false;
														$scope.balanceResultsFlag = true;
														//console.log($scope.data);
														$scope.accNumForBalEnquiry = $scope.data.accountNumber;
														$scope.accHloderNameForBalEnquiry = $scope.data.accountHoldername;
														$scope.accStatusForBalEnquiry = $scope.data.accountStatus;
														$scope.accBalanceForBalEnquiry = $scope.data.totalBalance;
													} else {
														$scope.balanceResultsFlag = true;
														$scope.messageFlag = true;
														$scope.messageBE = $scope.response.message;
														
													}

												},
												function(result) {
													//error message function
													$window
															.alert('Failure while getting balance');
												});
							}

						}

						//funds transfer operations
						$scope.fundsTransferWindowFlag = false;
						$scope.ftwAccStatusFlag = false;
						$scope.fromTableFlag = false;
						$scope.toTableFlag = false;
						$scope.showFundsTransferWindow = function() {
							$scope.accNumDivFlag = false;
							$scope.withdrawDivFlag =false;
							$scope.balanceWindowFlag = false;
							$scope.fundsTransferWindowFlag = true;
							$scope.messageFTFlag=false;
							$scope.checkAccount = function() {
								//check whether account valid or not if valid display details and 
								$http({
									method : "post",
									url : "/CBA/checkAccountStatus",
									params : {
										"accountNumber" : $scope.fromAccNum
									}
								})
										.then(
												function(result) {
													//success function
													$scope.ftwAccStatusFlag = true;

													if (result.data.status == "SUCCESS") {
														$scope.failueMessage ="";
														$scope.fromTableFlag = true;
														$scope.fromAccData = angular
																.fromJson(result.data.data);
														//console.log($scope.fromAccData.accountHolderName);
														$scope.fromAccHolderName = $scope.fromAccData.accountHolderName;
														$scope.fromAccStatus = $scope.fromAccData.accountStatus;
														$scope.fromBal = $scope.fromAccData.totalBalance;
														$scope.fromAccType = $scope.fromAccData.accountType;
														$scope.fromBrName = $scope.fromAccData.branchName;
														$scope.fromBrId = $scope.fromAccData.branchId;

														if (($scope.fromAccStatus != "ACTIVE")
																|| ($scope.fromBal <= 0)) {
															$scope.failueMessage = "THIS ACCOUNT IS NOT ACTIVE. FUNDSTRANSFER ACTION CAN'T BE PERFORMED ON THIS ACCOUNT.";
														} else {
															$scope.toTableFlag = true;
														}

													} else if (result.data.status == "FAILURE") {
														$scope.messageFTFlag=true;
														$scope.failueMessage = result.data.message;
														//console.log(result.data.message);
													} else {
														$scope.failueMessage = "Network Error.Please Try Again."
													}

												},
												function(result) {
													//failur functon
													$window
															.alert("Failure Occured");
													console.log("FAILURE"
															+ result);
												}

										);
							}
							$scope.checkToAccount = function() {
								$http({
									method : "post",
									url : "/CBA/checkAccountStatus",
									params : {
										"accountNumber" : $scope.toAccNum
									}
								})
										.then(
												function(result) {
													//success function
													if (result.data.status == "SUCCESS") {
														$scope.resultData = angular
																.fromJson(result.data.data);
														$scope.toAccHolName = $scope.resultData.accountHolderName;
														$scope.toAccType = $scope.resultData.accountType;
														$scope.messageFTFlag=false;
														if (($scope.fromAccStatus != "ACTIVE")
																|| ($scope.fromBal <= 0)) {
															$scope.failueMessage = "THIS ACCOUNT IS NOT ACTIVE. FUNDSTRANSFER ACTION CAN'T BE PERFORMED ON THIS ACCOUNT.";
														} else {
															$scope.toTableFlag = true;
														}

													} else if (result.data.status == "FAILURE") {
														$scope.messageFTFlag=true;
														$scope.failueMessage = result.data.message;
													} else {
														$scope.messageFTFlag=true;
														$scope.failueMessage = "Network Error.Please Try Again."
													}
												}, function(result) {
													//failure function
													$window.alert("Failure");
												});

							}

							$scope.transferFunds = function() {

								/* if ((($scope.fromAccnum == "") || ($scope.toAccnum == ""))
										|| ($scope.transferingAmount == "") || ($scope.fromAccnum == $scope.toAccnum)) {
									$window
											.alert("account numbers should not be same");
								} else { */
									$http(
											{
												method : "post",
												url : "/CBA/transferFunds",
												params : {
													"fromAccountNumber" : $scope.fromAccNum,
													"toAccountNumber" : $scope.toAccNum,
													"transferingAmount" : $scope.transferingAmount
												}
											}).then(function(result){
												//success function
												if(result.status=="SUCCESS"){
													$window.alert(result.message);
												}
											},function(result){
												//failure function
											});

								}
							//}

						}

						//check account status
						$scope.checkAccountStatus = function() {
							console.log("checkAccountStatus : "
									+ $scope.accountNumber);

							$http({
								method : "post",
								url : "/CBA/checkAccountStatus",
								params : {
									"accountNumber" : $scope.accountNumber
								}
							})
									.then(
											function(result) {
												console.log("success : "
														+ result);
												$scope.response = result.data;
												console
														.log($scope.response.status
																+ " "
																+ $scope.response.message);
												if ($scope.response.status == "SUCCESS") {
													$scope.data = $scope.response.data;
													$scope.accountStatus = angular
															.fromJson($scope.data);
													$scope.accStatus = "Account is "
															+ $scope.accountStatus.accountStatus;
													if ($scope.accountStatus.accountStatus == "ACTIVE") {
														$scope.depositAmtFlag = true;
														$scope.accountStatusFlag = true;
														$scope.accountStatusButtonFlag = false;
														$scope.depositButtonFlag = true;
														$scope.messageFlag = false;
														$scope.branchName = $scope.accountStatus.branchName;
														$scope.accHolderName = $scope.accountStatus.accountHolderName;
														$scope.accountId = $scope.accountStatus.accountId;
														$scope.totalBalance = $scope.accountStatus.totalBalance;
													} else {
														$scope.accountStatusFlag = true;

													}

												} else {
													$scope.message = $scope.response.message
													$scope.messageFlag = true;
													$scope.accountStatusFlag = false;
												}

											},
											function(result) {
												console.log("failure : "
														+ result);

											});
						}

						$scope.chequeDetails = function() {
							$scope.chequeDetailsFlag = true;
							$scope.ddDetailsFlag = false;
						}
						$scope.ddDetails = function() {
							$scope.ddDetailsFlag = true;
							$scope.chequeDetailsFlag = false;
						}
						$scope.cashDetails = function() {
							$scope.chequeDetailsFlag = false;
							$scope.ddDetailsFlag = false;
						}
						$scope.deposit = function() {
							$scope.number = "";
							$scope.issuedBy = "";
							$scope.issuedDate = "";
							$scope.issuedBranch = "";
							if ($scope.chequeDetailsFlag == true) {
								$scope.transactionMode = "cheque";
								$scope.number = $scope.chequeNumber;
								$scope.issuedBy = $scope.chequeIssuedBy;
								$scope.issuedDate = $scope.chequeIssuedDate;
								$scope.issuedBranch = $scope.chequeIssuedBranch;
							} else if ($scope.ddDetailsFlag == true) {
								$scope.transactionMode = "dd";
								$scope.number = $scope.ddNumber;
								$scope.issuedBy = $scope.ddIssuedBy;
								$scope.issuedDate = $scope.ddIssuedDate;
								$scope.issuedBranch = $scope.ddIssuedBranch;
							} else {
								$scope.transactionMode = "cash";
							}

							$http({
								method : "post",
								url : "/CBA/deposit",
								params : {
									"accountNumber" : $scope.accountNumber,
									"accountId" : $scope.accountId,
									"depositAmount" : $scope.depositAmount,
									"txDesc" : $scope.txDesc,
									"transactionMode" : $scope.transactionMode,
									"number" : $scope.number,
									"issuedBy" : $scope.issuedBy,
									"issuedDate" : $scope.issuedDate,
									"issuedBranch" : $scope.issuedBranch
								}
							})
									.then(
											function(result) {
												console
														.log("Deposit Operation success");
												$scope.response = result.data;
												$scope.depositStatus = $scope.response.message;
												$scope.messageFlag = false;
												$scope.depositStatusFlag = true;
												if ($scope.response.status = "SUCCESS") {
													$scope.transactionId = "Transaction Id : "
															+ $scope.response.data;
													$scope.accountStatusFlag = false;
													$scope.depositAmtFlag = false;
													$scope.depositButtonFlag = false;
												} else {

												}
											},
											function(result) {
												console
														.log("Deposit operation Failure");
											});
						}
					});
</script>
<style>
	*{
		padding:3px;
	}
	table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: center;
    padding: 8px;
    border-bottom: 1px solid #ddd;
}
	
</style>
</head>
<body ng-controller="bank-controller">


Welcome , ${userName}
           ${userRole}
	<div>
		<div align="left">
			<div style="font: bold; font-size: medium;">
				<input type="button" value="Deposit" ng-click="showDepositWindow()" />

				<!-- Balance Enquiry -->
				<br> <input type="button" value="Balance Enquiry"
					ng-click="showBalanceWindow()" />

				<!-- Funds Trnsfer -->
				<br> <input type="button" value="Funds Transfer"
					ng-click="showFundsTransferWindow()">
					
					<!-- Withdraw -->
				<br> <input type="button" value="Withdraw"
					ng-click="showWithdrawWindow()">

			</div>
		</div>

		<!-- Funds Transfer Division -->
		<div ng-show="fundsTransferWindowFlag" align="center">

			<h3>Entered into Funds Transfer Section</h3>
			<h1 style="color: red;">&#9888;This module is under construction</h1>
			<table style="width: 100%; border: 1px solid black;">
				<thead>
					<tr>
						<th style="width: 50%" colspan="2">From</th>
						<th style="width: 50%" colspan="2">To</th>
					</tr>

					
					<tr>
						<td>Enter Account Number</td>
						<td><input type="text" ng-model="fromAccNum">
							<button ng-click="checkAccount()">Check Account</button></td>

						<!-- <td>Enter Account Number</td>
						<td><input type="text" ng-model="toAccNum"></td>-->
						<td align="right"><p>Select Branch Type:</p></td>
						<td>
							<form>
								<input type="radio" ng-model="toBranch" value="sameBranch"><label>Same
									Branch</label><br> <input type="radio" ng-model="toBranch"
									value="otherBranch"><label>Other Branch</label>
							</form>
						</td>
					</tr>
					<tr ng-show="messageFTFlag" ><td colspan="4">{{failueMessage}}</td></tr>
				</thead>

			

				<tbody ng-show="ftwAccStatusFlag" ng-switch="toBranch">
					<!-- ng-hide="fromAccNum==toAccNum" -->

					<tr>
						<td colspan="2">
							<table ng-show="fromTableFlag"
								style="width: 100%; border: 1px solid black;">
								<tr>
									<td><p>Account Holder's Name</p></td>
									<td><p>{{fromAccHolderName}}</p></td>
								</tr>
								<tr>
									<td><p>Account Status</p></td>
									<td><p>{{fromAccStatus}}</p></td>
								</tr>
								<tr>
									<td><p>Account Type</p></td>
									<td><p>{{fromAccType}}</p></td>
								</tr>
								<tr>
									<td><p>Total Balance</p></td>
									<td><p>{{fromBal}}</p></td>
								</tr>
								<tr>
									<td><p>Branch Name</p></td>
									<td><p>{{fromBrName}}</p></td>
								</tr>
								<tr>
									<td><p>Branch ID</p></td>
									<td><p>{{fromBrId}}</p></td>
								</tr>
								<tr>
									<td><p>Enter Amount to Transfer:</p></td>
									<td><input type="text" ng-model="transferingAmount">
									<button ng-click="transferFunds()">TRANSFER</button></td>
								</tr>
							</table>
						</td>
						<td colspan="2">
							<table ng-show="toTableFlag">
								<tr>
									<td><p>Enter Account Number</p></td>
									<td><input type="text" ng-model="toAccNum">
									<button ng-click="checkToAccount()">Check Account</button></td>
								</tr>
								<tr>
									<td><p>Account Holder's Name</p></td>
									<td>{{toAccHolName}}</td>
								</tr>
								<tr>
									<td><p>account Type</p></td>
									<td>{{toAccType}}</td>
								</tr>
							</table>
						</td>
					</tr>

				</tbody>
				<tfoot></tfoot>
			</table>

		</div>




		<!-- Balance Enquiry Division -->
		<div ng-show="balanceWindowFlag" align="center">
			<table id="checkBalance">
				<tr>
					<th colspan="4">Balance Enquiry</th>
				</tr>
				<tr>
					<td colspan="2">Enter Account Number</td>
					<td colspan="2"><input type="text" ng-model="accNumForBal">
						<button ng-click="checkBalance()">click</button></td>
				</tr>
			</table>
			<table id="balanceResults" ng-show="balanceResultsFlag">
				<tr>
					<th>Account Number</th>
					<th>Account Holder's Name</th>
					<th>Account Status</th>
					<th>Account Balance</th>
				</tr>
				<tr ng-show="messageFlag">
					<td colspan="4" ng-bind="messageBE" style="color:red" ></td>
				</tr>
				<tr ng-hide="messageFlag">
					<td>{{accNumForBalEnquiry}}</td>
					<td>{{accHloderNameForBalEnquiry}}</td>
					<td>{{accStatusForBalEnquiry}}</td>
					<td>{{accBalanceForBalEnquiry}}</td>
				</tr>
			</table>
		</div>


		<div align="center" id="accountNumberDiv" ng-show="accNumDivFlag"
			style="margin-top: 4cm">
			<table border="1">

				<tr>
					<th colspan="2">Deposit Window</th>
				</tr>
				<tr id="message" ng-show="messageFlag">
					<td colspan="2" align="center" style="color: red;">
						{{message}}</td>
				</tr>
				<tr ng-show="depositStatusFlag">
					<td colspan="2" align="center">{{depositStatus}}<br />
						{{transactionId}}
					</td>
				</tr>


				<tr ng-show="accountStatusFlag">
					<td colspan="2" align="center">{{accStatus}}</td>
				</tr>
				<tr>
					<td>Enter AccountNumber : <input type="text"
						ng-model="accountNumber" />
					</td>

					<td ng-show="accountStatusButtonFlag"><input type="button"
						value="Click" ng-click="checkAccountStatus()" /></td>
				</tr>

				<tr ng-show="depositAmtFlag">
					<td colspan="2" align="center"><label>Account Holder
							Name : </label> {{accHolderName}}<br /> <label>TotalBalance : </label>
						{{totalBalance}}<br /> <label>Branch Name : </label>
						{{branchName}}</td>
				</tr>
				<tr ng-show="depositAmtFlag">
					<td align="center"><input type="radio" ng-model="paymentMode"
						value="CASH" ng-click="cashDetails()" />CASH <input type="radio"
						ng-model="paymentMode" value="CHEQUE" ng-click="chequeDetails()" />CHEQUE

						<input type="radio" ng-model="paymentMode" value="DD"
						ng-click="ddDetails()" />DD</td>
				</tr>
				<tr ng-show="chequeDetailsFlag">
					<td>Enter Cheque Number : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="text" ng-model="chequeNumber" /> <br /> Enter Cheque
						Issued By : &nbsp;&nbsp;&nbsp;&nbsp;<input type="text"
						ng-model="chequeIssuedBy" /> <br /> <datepicker
							date-format="dd-MM-yyyy"> Enter Cheque Issued Date
						:&nbsp;&nbsp; <input ng-model="chequeIssuedDate" type="text" /> </datepicker>
						<br /> Enter Bank and Branch Name :<input type="text"
						ng-model="chequeIssuedBranch" />
					</td>
				</tr>
				<tr ng-show="ddDetailsFlag">
					<td>Enter DD Number : <input type="text" ng-model="ddNumber" />
						<br /> Enter DD Issued By : <input type="text"
						ng-model="ddIssuedBy" /> <br /> <datepicker
							date-format="dd-MM-yyyy"> Enter DD Issued Date :
						&nbsp;&nbsp; <input ng-model="ddIssuedDate" type="text" /> </datepicker> <br />
						Enter Bank and Branch Name : <input type="text"
						ng-model="ddIssuedBranch" />
					</td>
					<td>
				</tr>
				<tr ng-show="depositAmtFlag">

					<td>Enter Deposit Amount : <input type="text"
						ng-model="depositAmount" />
					</td>

					<td>Enter Transaction Desc : <input type="text"
						ng-model="txDesc" />

					</td>
					<td ng-show="depositButtonFlag"><input type="button"
						value="Click" ng-click="deposit()" /></td>
				</tr>

			</table>

		</div>
		
		<!--withdtraw div-->
		<div align="center" id="accountNumberDiv" ng-show="withdrawDivFlag"
			style="margin-top: 2cm">
			<h2 align="center">Withdraw Window</h2>
			<table border="3">

								
				<tr id="message" ng-show="msgFlag">
					<td colspan="2" align="center" style="color: red;">
						{{msg}}</td>
				</tr>
				
				<tr ng-show="withdrawStatusFlag">
					<td colspan="2" align="center">{{withdrawStatus}}<br />
						{{transactionId}}
					</td>
				</tr>
				<tr ng-show="accountStatusFlag">
					<td colspan="2" align="center">{{accStatus}}</td>
				</tr>


				
				<tr>
					<td colspan="2" >Enter AccountNumber : <input type="text"
						ng-model="accountNumber" />
					</td>

					<td ng-show="accountStatusButtonFlag"><input type="button"
						value="Click" ng-click="withdrawAccountStatus()" /></td>
				</tr>
				
				<tr ng-show="withdrawAmtFlag">
					<td colspan="2" align="center"><label>Account Holder
							Name : </label> {{accHolderName}}<br /> 
					<label>Branch Name : </label> {{branchName}}<br/> <label>TotalBalance : </label>
						{{totalBalance}}</td>
				</tr>
				
				<tr ng-show="withdrawAmtFlag">
					<td align="center"><input type="radio" ng-model="paymentMode"
						value="PAYSLIP" ng-click="cashDetails()" />PAYSLIP<input type="radio"
						ng-model="paymentMode" value="CHEQUE" ng-click="chequeDetails()" />SELF CHEQUE

						</td>
				</tr>
				
				<tr ng-show="chequeDetailsFlag">
					<td>Enter Cheque Number : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="text" ng-model="chequeNumber" /> <br /> Enter Cheque Issued
						By : &nbsp;&nbsp;&nbsp;&nbsp;<input type="text"
						ng-model="chequeIssuedBy" /> <br /> <datepicker
							date-format="dd-MM-yyyy"> Enter Cheque Issued Date
						:&nbsp;&nbsp; <input ng-model="chequeIssuedDate" type="text" /> </datepicker> <br />
						Enter Bank and Branch Name :<input type="text"
						ng-model="chequeIssuedBranch" />
					</td>
				</tr>
			
				
				<tr ng-show="withdrawAmtFlag">

					<td>Enter Withdraw Amount : <input type="text"
						ng-model="withdrawAmount" />
					</td>

					<td>Enter Transaction Desc : <input type="text"
						ng-model="transDesc" />

					</td>
				</tr>
				<tr>
				<td align="center" colspan="2" ng-show="withdrawButtonFlag"><input type="button"
						value="Click" ng-click="withdraw()" /></td>
				</tr>
				
				

			</table>

		</div>
	</div>
</body>
</html>