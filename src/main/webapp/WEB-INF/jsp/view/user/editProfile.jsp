<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Pharmacy|Edit Profile</title>
</head>
<body>
	<h2 align="center">Edit Profile Details</h2>
	
	<div class="container text-center">
		<form:form cssClass="form-group" modelAttribute="user"
			action="../edit-profile" method="POST">
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
			<input type="submit" value="Update"
				class="mt-3 btn btn-outline-dark">
		</form:form>
	</div>
</body>
</html>