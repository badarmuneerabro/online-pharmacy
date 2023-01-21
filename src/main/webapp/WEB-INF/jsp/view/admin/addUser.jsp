<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Pharmacy|Add User</title>
</head>
<body>

<h1 align="center">Add User</h1>
	<div class="container text-center">
		<form:form cssClass="form-group" modelAttribute="user"
			action="save-user" method="POST">
			<form:label path="email">Email: </form:label>
			<br>
			<form:input cssClass="" path="email" />
			<br>
			<form:label path="firstName">First Name: </form:label>
			<br>
			<form:input path="firstName" />
			<br>
			<form:label path="lastName">Last Name: </form:label>
			<br>
			<form:input path="lastName" />
			<br>
			<form:label path="password">Password: </form:label>
			<br>
			<form:input path="password" />
			<br>
			<form:label path="address">Address: </form:label>
			<br>
			<form:textarea path="address"/>
			<br>

			<input type="submit" value="Add User"
				class="mt-3 btn btn-outline-dark">
		</form:form>
	</div>
</body>
</html>