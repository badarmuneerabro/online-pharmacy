<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Pharmacy|User Registration</title>

<style type="text/css">
.banner-background {
	clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 99%, 60% 95%, 25% 100%, 0 92%, 0 0);
}
.primary-background{
	background: #212121;
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/jsp/nav.jspf" %>
	<main class="primary-background p-5 banner-background">
		<div class="container">
			<div col="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header text-center primary-background text-white">
						<i class="fa-solid fa-user-plus fa-3x"></i>
						<p>Register here</p>
					</div>

					<div class="card-body"></div>

					<form:form modelAttribute="user" method="POST" action="register">
						<div class="form-group">
							<form:label path="email">Email</form:label>
							<form:input cssClass="form-control col-xs-4" path="email" />
						</div>

						<div class="form-group">
							<form:label path="firstName">First Name</form:label>
							<form:input cssClass="form-control" path="firstName" />
						</div>

						<div>
							<form:label path="lastName">Last Name</form:label>
							<form:input path="lastName" cssClass="form-control" />
						</div>

						<div>
							<form:label path="password">Password: </form:label>
							<form:password path="password" cssClass="form-control" />
						</div>

						<div>
							<form:label path="address">Address</form:label><br>
							<form:textarea path="address" />
						</div>
						
						<div class="text-center container">
							<button type="submit" class="btn btn-outline-dark">Submit</button>
						</div>
					</form:form>

					
				</div>
			</div>
		</div>
	</main>
</body>
</html>