<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Pharmacy|Login</title>
</head>
<body>
	<div class="container text-center">
		<h1>Login Please!!</h1>
		
		<form:form modelAttribute="loginForm" action="UserLogin" method="POST">
			<form:label path="email">Email: </form:label><br>
			<form:input path="email"/><br>
			
			<form:label path="password">Password: </form:label><br>
			<form:password path="password"/><br>
			
			<div class="container text-center">
				<button type="submit" class="btn btn-outline-primary mt-2">Login</button>
			</div>
			
		</form:form>
	</div>
</body>
</html>