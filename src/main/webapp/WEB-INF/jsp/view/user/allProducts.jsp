<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Pharmacy|All Products</title>
</head>
<body>
	<c:choose>
		<c:when test="${list.size() == 0 }">
			<h1>No Products are available.</h1>
		</c:when>

		<c:otherwise>
			<c:forEach items="${list }" var="p">
				<section class="py-5">
					<div class="container px-4 px-lg-5 mt-5">
						<div
							class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
							<div class="col mb-5">

								<div class="col mb-5">
									<div class="card h-100">
										<!-- Product image-->
										<img class="card-img-top" src="<c:url value="resources/images//medicine.jpg" />"
											alt="Medicine Image" />
										<!-- Product details-->
										<div class="card-body p-4">
											<div class="text-center">
												<!-- Product name-->
												<h5 class="fw-bolder">${p.name }</h5>
												<!-- Product price-->
												$120.00 - $280.00
											</div>
										</div>
										<!-- Product actions-->
										<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
											<div class="text-center">
												<a class="btn btn-outline-dark mt-auto" href="#">Add To
													Cart</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>