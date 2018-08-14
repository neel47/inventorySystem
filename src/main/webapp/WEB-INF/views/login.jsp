
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Inventory</title>
<!-- Bootstrap core CSS-->
<link href="resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="resources/css/sb-admin.css" rel="stylesheet">

<!-- Bootstrap core JavaScript-->
<script src="resources/vendor/jquery/jquery.min.js"></script>
<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<style>
.bg-dark {
	background: url("resources/images/photo_bg.jpg") no-repeat center center
		fixed;
	background-size: cover;
	font-size: 16px;
	font-family: 'Lato', sans-serif;
	font-weight: 300;
	margin: 0;
	color: white;
	
}

h1#title {
	font-family: 'Roboto Slab', serif;
	font-weight: 300;
	font-size: 3.2em;
	color: white;
	text-shadow: 0 0 10px rgba(0, 0, 0, 0.8);
	margin: 0 auto;
	padding-top: 20px;
	max-width: 400px;
	text-align: center;
	position: relative;
	top: 0px;
}

.card-header {
	background-color: #665851;
}

.btn-primary:hover {
	color: #fff;
	background-color: #847973;
	border-color: #847973;
}

.btn-primary {
	color: #fff;
	background-color: #665851;
	border-color: #665851;
}
</style>


<script>
	function submitForm() {
		if ("" == document.getElementById("emailid")
				|| null == document.getElementById("emailid")) {
			callError("emailidError")
			return false;
		}
		if ("" == document.getElementById("password")) {
			callError("passwordError")
			return false;
		}
		return true;
	}

	function callError(id) {
		document.getElementById(id).innerHTML = "Hello JavaScript!";
	}
</script>

</head>

<body class="bg-dark" onsubmit="return submitForm();">
	<h1 id="title" class="hidden">
		<span id="logo">Inventory Management System<span>
	</h1>
	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Login</div>
			<div class="card-body" >
			<div style="color:red"><c:out value="${error}"></c:out></div>
				<form:form action="login" method="post"
					modelAttribute="login" >
					<div class="form-group">
						<div id="emailidError"></div>
						<label for="emailid">Email address</label>
						<form:input path="username" class="form-control" id="emailid"
							type="text" placeholder="User Name" /><font color="red"> *</font>
					</div>
					<div class="form-group">
						<div id="passwordError"></div>
						<label for="password">Password</label>
						<form:input path="password" class="form-control" id="password"
							type="password" placeholder="Password" /><font color="red"> *</font>

					</div>
					<div class="form-group">
						<div class="form-check"></div>
					</div>
					<button class="btn btn-primary btn-block">Login</button>
				</form:form>
				<div class="text-center">
					<a class="d-block small  mt-3" href="forgot-password.html">Forgot
						Password?</a>
				</div>
			</div>
		</div>
	</div>

</body>

</html>
