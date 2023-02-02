<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Pharmacy|Admin</title>
</head>
<body>
	<div align="center">
		<h1>Update Order</h1>
		<c:url var="updateUrl" value="/update-order" />
		<form:form modelAttribute="orderForm" action="${updateUrl }" method="POST">
			<form:label path="orderId">ID: </form:label><br>
			<form:input path="orderId"/><br>
			<form:label path="userEmail">Ordered By: </form:label><br>
			<form:input path="userEmail"/><br>
			<form:label path="orderDate">Order Date: </form:label><br>
			<form:input path="orderDate"/><br>
			<form:label path="orderStatus">Order Status: </form:label><br>
			<form:input path="orderStatus"/><br>
			<form:label path="totalPrice">Total Price(MYR): </form:label><br>
			<form:input path="totalPrice"/><br>
			<form:label path="items">Items: </form:label><br>
			<form:input path="items"/><br><br>
			<input type="submit" class="btn btn-outline-dark" value="Update">
		</form:form>
	</div>
</body>
</html>