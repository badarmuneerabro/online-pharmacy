<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Pharmacy|Add Medicine</title>
</head>
<body>
	<h1 align="center">Add Medicine</h1>
	
	<div class="container text-center">
		<form:form cssClass="form-group" modelAttribute="medicine" action="save-medicine" method="POST">
			<form:label path="name">Medicine Name: </form:label><br>
			<form:input cssClass="" path="name"/><br>
			<form:label path="description">Description: </form:label><br>
			<form:textarea path="description"/><br>
			<form:label path="company">Company Name: </form:label><br>
			<form:input path="company"/><br>
			<form:label path="cost">Price(MYR)</form:label><br>
			<form:input path="cost"/><br>
			<form:label path="catgory">Select Category: </form:label><br>
			<form:select path="catgory">
				<option value="" selected="selected" disabled>----Select Category----</option>
				<form:option value="tablet">Tablet</form:option>
				<form:option value="injection">Injction</form:option>
				<form:option value="capsule">Capsule</form:option>
				<form:option value="syrup">Syrup</form:option>
			</form:select><br>
			
			<input type="submit" value="Add Medicine" class="mt-3 btn btn-outline-dark">
		</form:form>
	</div>
</body>
</html>