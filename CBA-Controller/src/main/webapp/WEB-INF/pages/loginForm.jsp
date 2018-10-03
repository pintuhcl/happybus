<html>
<%@page isELIgnored="false" %>
<body>

<form  action="login" method="POST">
<h1>${status}</h1>
		<table>
			<tr>
				<td>UserName:</td>
				<td><input type='text' name='username' id="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' id="password" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>