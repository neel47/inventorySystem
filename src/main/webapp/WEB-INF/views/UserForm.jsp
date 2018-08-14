<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap core CSS-->
<link href="resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="resources/vendor/bootstrap/css/datepicker.css"
	rel="stylesheet" />
<!-- Page level plugin CSS-->
<link href="resources/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="resources/css/sb-admin.css" rel="stylesheet">


<style>
.card-header {
	background-color: rgb(0, 123, 255);
}

.dropdown-menu {
	background-color: #ececec !important;;
	border: 1px solid #0067CC !important;
}
</style>


</head>
<body>

	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- <ol class="breadcrumb">
				<li class="breadcrumb-item">User Form</li>
			</ol> -->

			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-user"></i> User Form
				</div>
				<div class="card-body">

					<form:form action="UserCreationSave" method="post"
						modelAttribute="user">

						<div class="table-responsive">
							<table class="" width="100%" cellspacing="0">


								<tr>
									<td><label for="userid">User Name</label><font color="red"> *</font></td>
									<td><form:input path="userid" id="userid" type="text" required="required" maxlength="12" placeholder=" Enter Username" /></td>
								</tr>
								<tr>
									<td><label for="epassword">Password</label><font color="red"> *</font></td>
									<td><form:input path="epassword" id="epassword" placeholder=" Enter Password" required="required"
											type="password" /></td>
								</tr>
								<tr>
									<td><label for="epassword">Re-Type Password</label><font color="red"> *</font></td>
									<td><input type="password" id="cepassword" required="required" placeholder=" Re-Enter Password" /></td>
								</tr>
								<tr>
									<td><label for="firstname">First Name</label><font color="red"> *</font></td>
									<td><form:input path="firstname" id="firstname"
											type="text" pattern="[A-Za-z ]{1,32}" required="required" placeholder=" Enter FirstName"/></td>
								</tr>
								<tr>
									<td><label for="lastname">Last Name</label><font color="red"> *</font></td>
									<td><form:input path="lastname" id="lastname"
											type="text" pattern="[A-Za-z ]{1,32}" required="required" placeholder=" Enter LastName"/></td>
								</tr>
								<tr>
									<td><label for="dob">Date of Birth</label><font color="red"> *</font></td>
									<td><form:input path="dob" id="dob" name="dob" type="text" required="required"
											placeholder="DD/MM/YYYY" /></td>
								</tr>
								<tr>
									<td><label for="gender">Gender</label><font color="red"> *</font></td>
									<td><form:select path="gender" required="required">
											<form:option value="MALE" label="Male" />
											<form:option value="FEMALE" label="Female" />
										</form:select></td>
								</tr>
								<tr>
									<td><label for="email">Email</label><font color="red"> *</font></td>
									<td><form:input path="email" id="email" type="email" required="required" placeholder=" Enter Email" /></td>
								</tr>
								<tr>
									<td><label for="tel">Telephone</label><font color="red"> *</font></td>
									<td><form:input path="tel" id="tel" type="text" pattern="[0-9]{10}" required="required" placeholder=" Enter Telephone"/></td>
								</tr>
								<tr>
									<td><label for="gender">Address</label>
									<td><form:input path="address" id="address" type="text" required="required" placeholder=" Enter Address"/></td>
								</tr>
								<tr>
									<td><label for="city">City</label><font color="red"> *</font></td>
									<td><form:input path="city" id="city" type="text" required="required" placeholder=" Enter City"/></td>
								</tr>
								<tr>
									<td><label for="province">Province</label><font color="red"> *</font></td>
									<td><form:input path="province" id="province" type="text"  required="required" placeholder=" Enter Province"/></td>
								</tr>
								<tr>
									<td><label for="country">Country</label><font color="red"> *</font></td>
									<td><form:input path="country" id="country" type="text"  required="required" placeholder=" Enter Country"/></td>
								</tr>
								<tr>
									<td><label for="pincode">Pincode</label><font color="red"> *</font></td>
									<td><form:input path="pincode" id="pincode" type="text" pattern="[A-Z0-9]{3} [A-Z0-9]{3}" placeholder=" Enter PinCode" required="required"/></td>
								</tr>
								<tr>
									<td><label for="ecategory">Category</label><font color="red"> *</font></td>
									<td><form:select path="ecategory">
											<form:option value="NONE" label="--- Select ---" />
											<form:option value="ADMIN" label="Admin" />
											<form:option value="REGIONALMANAGER" label="Regional Manager" />
											<form:option value="PROJECTMANAGER" label="Project Manager" />
											<form:option value="SUPERVISOR" label="Supervisor" />
											<form:option value="EMPLOYEE" label="Employee" />
										</form:select></td>
								</tr>
								<tr>
									<td colspan="2" align="center"><form:button
											class="btn btn-primary">Save</form:button></td>
								</tr>





							</table>
						</div>
						<form:input path="id" id="id" type="hidden" />
						<form:input path="version" id="version" type="hidden" />
					</form:form>
				</div>
			</div>



		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fa fa-angle-up"></i>
		</a>

		<!-- Bootstrap core JavaScript-->
		<script src="resources/vendor/jquery/jquery.min.js"></script>
		<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<script src="resources/vendor/bootstrap/js/bootstrap-datepicker.js">
		<!-- Core plugin JavaScript-->
			<script src="resources/vendor/jquery-easing/jquery.easing.min.js">
		</script>
		<!-- Page level plugin JavaScript-->
		<script src="resources/vendor/chart.js/Chart.min.js"></script>
		<script src="resources/vendor/datatables/jquery.dataTables.js"></script>
		<script src="resources/vendor/datatables/dataTables.bootstrap4.js"></script>
		<!-- Custom scripts for all pages-->
		<script src="resources/js/sb-admin.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('#dob').datepicker({
					format : 'dd/mm/yyyy',
				});
			})
			
			
			var password = document.getElementById("epassword"), confirm_password = document.getElementById("cepassword");
			function validatePassword(){
  			if(password.value != confirm_password.value) {
    			confirm_password.setCustomValidity("Passwords Don't Match");
  			} else {
    		confirm_password.setCustomValidity('');
  			}
		}

		password.onchange = validatePassword;
		confirm_password.onkeyup = validatePassword;
			
			
		</script>

	</div>

</body>
</html>