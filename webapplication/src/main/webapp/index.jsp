<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<body>
	<h2>Hello World!</h2>

	<c:if test="${userNotFound != null}">User not found, try again!<br>
	</c:if>

	<form action="/webapplication/login" method="GET">
		<div class="form-group row">

			<label for="login" class="col-sm-2 col-form-label">Login</label>
			<div class="col-sm-10">
				<input id="login" class="form-control" type="text" name="login">
			</div>
		</div>

		<div class="form-group row">
			<label for="password" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
				<input id="password" class="form-control" type="password"
					name="password" />
			</div>
		</div>



		<input class="btn btn-primary" type="submit" value="Submit" />
	</form>




</body>
</html>
