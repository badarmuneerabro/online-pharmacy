<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Pharmacy|All Medicines</title>
</head>
<body>
	<h1 align="center">View All Medicines</h1>

	<c:choose>
		<c:when test="${list.size() == 0 }">
			<h2 class="text-center mt-2">No Medicines Are Available</h2>
		</c:when>
		<c:otherwise>
			<div class="container">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">#</th>
							<th scope="col">Name</th>
							<th scope="col">Description</th>
							<th scope="col">Company</th>
							<th scope="col">Category</th>
							<th scope="col">Price(MYR)</th>
						</tr>
					</thead>
					<tbody class="table-hover">
						<c:forEach items="${list }" var="m">
							<tr>
								<td><a href="<c:url value="/update/${m.id }" />">${m.id }</a></td>
								<td>${m.name }</td>
								<td>${m.description }</td>
								<td>${m.company }</td>
								<td>${m.catgory }</td>
								<td>${m.cost }</td>
								<td><a href="delete-medicine/${m.id }" class="btn btn-outline-danger">Delete</a></td>
							</tr>
						</c:forEach>

					</tbody>

				</table>
			</div>

		</c:otherwise>
	</c:choose>
</body>
</html>