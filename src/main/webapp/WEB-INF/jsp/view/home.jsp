<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Pharmacy</title>

<style type="text/css">
.path {
	clip-path: polygon(25% 0%, 100% 0, 100% 76%, 63% 95%, 0 87%, 0 0);
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/jsp/nav.jspf" %>
	<div class="fluid-container bg-dark h-75 path">
		<div class="container mx-2">
			<h1 class="display-4 text-white">
				Welcome to <br>
				<span class="display2 ml-4">Online Pharmacy</span>
			</h1>
			
			<span class="text-white display-2">We provide quality medicines!</span>
		</div>

		<div class="container mt-4">
			<div class="container text-center mt-4">
				<a class="btn-lg btn-primary" href="<c:url value="/signup" />"><i class="fa fa-user" aria-hidden="true"></i>Start Now!</a>
			</div>
		</div>
	</div>
	
	
	
</body>
</html>