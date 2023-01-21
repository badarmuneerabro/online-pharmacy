<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Pharmacy| User List</title>
</head>
<body>
	<h1 align="center">View All Users</h1>
	<c:out value="${list.size() }"></c:out>
	<c:choose>
		<c:when test="${list.size() == 0 }">
			<h2 class="text-center mt-2">No Users Are Available</h2>
		</c:when>
		<c:otherwise>
			<div class="container">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Email</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Address</th>
							<th scope="col">Password</th>
						</tr>
					</thead>
					<tbody class="table-hover">
						<c:forEach items="${list }" var="u">
							<tr>
								<td><a href="<c:url value="/edit-user/${u.email }" />">${u.email }</a></td>
								<td>${u.firstName }</td>
								<td>${u.lastName }</td>
								<td>${u.address }</td>
								<td>${u.password }</td>
								<td><a href="delete-user/${u.email }"
									class="btn btn-outline-danger">Delete</a></td>
							</tr>
						</c:forEach>

					</tbody>

				</table>
			</div>

		</c:otherwise>
	</c:choose>
</body>
</html>