<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Pharmacy|All Orders</title>
</head>
<body>
	<h1 align="center">All Orders</h1>
	<c:choose>
		<c:when test="${list.size() == 0 }">
			<h2 class="text-center mt-2">No Orders Are Available</h2>
		</c:when>
		<c:otherwise>
			<div class="container">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Ordered by</th>
							<th scope="col">Order date</th>
							<th scope="col">Order status</th>
							<th scope="col">Items</th>
							<th scope="col">Total Price</th>
						</tr>
					</thead>
					<tbody class="table-hover">
						<c:forEach items="${list }" var="o">
							<tr>
								<td><a href="<c:url value="/update-order/${o. orderId}" />">${o.orderId }</a></td>
								<td>${o.userEmail }</td>
								<td>${o.orderDate }</td>
								<td>${o.orderStatus }</td>
								<td>${o.items }</td>
								<td>${o.totalPrice }</td>
								
								<c:choose>
									<c:when test="${o.orderStatus == 0 }">
										<td><a href="update-order-status/${o.orderId }"
											class="btn btn-outline-warning">Ship Order</a>
										</td>
										<td><a href="reject-order/${o.orderId }"
											class="btn btn-outline-danger">Reject Order</a>
										</td>
									</c:when>
									
									<c:when test="${o.orderStatus == 1 }">
										<td>
											<button class="btn btn-success">Order Completed</button>
										</td>
									</c:when>
									
									<c:when test="${o.orderStatus == 2 }">
										<td>
											<button class="btn btn-danger">Order Rejected</button>
										</td>
									</c:when>
									
									<c:when test="${o.orderStatus == 3 }">
										<td>
											<button class="btn btn-danger">Order Cancelled</button>
										</td>
									</c:when>
								</c:choose>
							</tr>
						</c:forEach>

					</tbody>

				</table>
			</div>

		</c:otherwise>
	</c:choose>
</body>
</html>