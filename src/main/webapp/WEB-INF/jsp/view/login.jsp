<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Pharmacy|Login</title>
</head>
<body>
	<div class="container">
		<h1 align="center">Login Please!!</h1>

		<div class="container">
			<form:form cssClass="form-group" modelAttribute="loginForm"
				action="process-login" method="POST">
				<c:if test="${error != null }">
					<p class="text-danger text-center">${error }</p>
				</c:if>
				<form:label path="email">Email Address: </form:label>
				<br>
				<form:input cssClass="form-control" path="email" />
				<br>
				<form:errors cssClass="text-danger" path="email"/><br>
				<form:label path="password">Password: </form:label>
				<br>
				<form:password cssClass="form-control" path="password" />
				<br>
				<form:errors cssClass="text-danger" path="password"/><br>
				<div class="container text-center">
					<p>
						Don't have an Account? <a href="<c:url value="/signup" />">Register</a>
					</p>
				</div>
				<div class="container text-center">
					<button type="submit" class="btn btn-outline-primary mt-2">Submit</button>
				</div>

			</form:form>

		</div>
	</div>
</body>
</html>