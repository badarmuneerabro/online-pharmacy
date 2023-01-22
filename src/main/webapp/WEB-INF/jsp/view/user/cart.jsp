<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Pharmacy|Cart Items</title>
</head>
<body>
	<h1 align="center">All Items In Cart</h1>

	<c:choose>
		<c:when test="${cart.size() == 0 }">
			<br>
			<br>
			<h2 align="center">No Items Are in Cart. Start Shopping!</h2>
		</c:when>

		<c:otherwise>
			<div class="container">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Description</th>
							<th scope="col">Company</th>
							<th scope="col">Category</th>
							<th scope="col">Price(MYR)</th>
							<th scope="col">Quantity</th>
						</tr>
					</thead>
					
					<tbody class="table-hover">
					<c:remove var="total"/>
						<c:forEach items="${cart }" var="i">
							<tr>
								<td>${i.name }</td>
								<td>${i.description }</td>
								<td>${i.company }</td>
								<td>${i.catgory }</td>
								<td>${i.cost }</td>
								<td>${i.quantity }</td>
								<c:set var="total" scope="session" >${ total + (i.cost * i.quantity) }</c:set>
								<td><a href="remove-from-cart/${i.id }"
									class="btn btn-outline-danger">Remove</a></td>
							</tr>
						</c:forEach>

					</tbody>

					<tfoot>
						<tr>
							<th colspan="4">Total(MYR)</th>
							<td>${total }</td>
						</tr>
					</tfoot>

				</table>
			</div>
			<div class="container text-center">
				<a href="<c:url value="/confirm-order" />"><button class="btn btn-outline-success">Confirm Order</button></a>
			</div>
		</c:otherwise>
	</c:choose>


</body>
</html>