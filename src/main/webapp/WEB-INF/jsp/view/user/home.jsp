<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Pharmacy|User Home</title>
</head>

<style>
.banner-background {
	/*clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 99%, 60% 95%, 25% 100%, 0 92%, 0 0);*/
	clip-path: polygon(30% 0%, 70% 0%, 100% 1%, 100% 85%, 72% 99%, 30% 95%, 0 100%, 0
		1%);
}

.primary-background {
	background: #212121;
}
</style>
<body>
	<div style="height: 40vh;"
		class="container banner-background primary-background text-light">
		<h1 class="display-2">Welcome: ${user.firstName }</h1>
		<br>
		<blockquote class="blockquote">
			<p class="mb-0">Medicines For Everyone!</p>
			<footer class="blockquote-footer display-3">
				Our mission<cite title="Source Title"></cite>
			</footer>
		</blockquote>
	</div>

	<div class="container mt-3">
		<h4 class="display-2">About Us</h4>
		<p class="lead">Pharmacy is the science and practice of discovering, producing,
			preparing, dispensing, reviewing and monitoring medications, aiming
			to ensure the safe, effective, and affordable use of medicines. It is
			a miscellaneous science as it links health sciences with
			pharmaceutical sciences and natural sciences.</p>
			
			<div class="container text-center">
				<a href="<c:url value="/all-products" />"><button class="btn btn-outline-danger">Our Products</button></a>
			</div>
	</div>

</body>
</html>