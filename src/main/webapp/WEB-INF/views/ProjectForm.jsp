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
rel="stylesheet" />
<!-- Page level plugin CSS-->
<link href="resources/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="resources/css/sb-admin.css" rel="stylesheet">


<style>
.card-header {
	background-color: #ffc107;
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
					<i class="fa fa-user"></i> Project Form
				</div>
				<div class="card-body">

					<form:form action="ProjectCreationSave" method="post"
						modelAttribute="project">

						<div class="table-responsive">
							<table class="" width="100%" cellspacing="0">


								<tr>
									<td><label for="name">Project Name</label><font color="red"> *</font></td>
									<td><form:input path="name" id="name" type="text" pattern="[A-Za-z0-9 ]{1,32}" required="required" placeholder=" Enter Project Name"/></td>
								</tr>
								<tr>
									<td><label for="type">Type</label><font color="red"> *</font></td>
									<td><form:input path="type" id="type" type="text" required="required" pattern="[A-Za-z0-9 ]{1,32}" placeholder=" Enter Project type" /></td>
								</tr>

								<tr>
									<td><label for="location">Location</label><font color="red"> *</font></td>
									<td><form:input path="location" id="location" type="text" required="required" pattern="[A-Za-z0-9 ]{1,32}" placeholder=" Enter Location" /></td>
								</tr>

								<tr>
									<td><label for="address">Address</label><font color="red"> *</font></td>
									<td><form:input path="address" id="address" type="text" required="required" placeholder=" Enter Address"/></td>
								</tr>
								<tr>
									<td><label for="country">Country</label><font color="red"> *</font></td>
									<td><form:input path="country" id="country" type="text" required="required" placeholder=" Enter Country"/></td>
								</tr>
								<tr>
									<td><label for="province">Province</label><font color="red"> *</font></td>
									<td><form:input path="province" id="province" type="text" required="required" placeholder=" Enter Province"/></td>
								</tr>
								<tr>
									<td><label for="city">City</label><font color="red"> *</font></td>
									<td><form:input path="city" id="city" type="text" required="required" placeholder=" Enter City"/></td>
								</tr>
								<tr>
									<td><label for="pincode">Pincode</label><font color="red"> *</font></td>
									<td><form:input path="pincode" id="pincode" pattern="[A-Z0-9]{3} [A-Z0-9]{3}" type="text" required="required" placeholder=" Enter Pincode"/></td>
								</tr>
								<tr>
									<td><label for="telephone">Telephone</label><font color="red"> *</font></td>
									<td><form:input path="telephone" id="telephone" pattern="[0-9]{10}" type="text" required="required" placeholder=" Enter Telephone"/></td>
								</tr>
								<tr>
									<td><label for="managerid">Project Manager</label><font color="red"> *</font></td>
									<td><form:select path="managerid" id="managerid" size="5" required="required">
											<!--  <option value="None" selected>---Select---</option> -->
											<c:forEach items="${projectmanager}" var="pm">
												<c:choose>
													<c:when test="${project.managerid == pm.id}">
														<option value="${pm.id}" selected="selected">${pm.userid}:
															${pm.firstname} : ${pm.email}</option>
													</c:when>
													<c:otherwise>
														<option value="${pm.id}">${pm.userid}:
															${pm.firstname} : ${pm.email}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>

										</form:select></td>
								</tr>
								<tr>
									<td><label for="regionalmangerid">Regional Manger</label><font color="red"> *</font></td>
									<td><form:select path="regionalmanagerid"
											id="regionalmangerid" size="5" required="required">
											<!--  <option value="None" selected>---Select---</option> -->
											<c:forEach items="${regionalprojectmanager}" var="rm">
												<c:choose>
													<c:when test="${project.regionalmanagerid == rm.id}">
														<option value="${rm.id}" selected="selected">${rm.userid}:
															${rm.firstname} : ${rm.email}</option>
													</c:when>
													<c:otherwise>
														<option value="${rm.id}">${rm.userid}:
															${rm.firstname} : ${rm.email}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>

										</form:select></td>
								</tr>
								<tr>
									<td colspan="2" align="center"><form:button
											class="btn btn-warning">Save</form:button></td>
								</tr>





							</table>
						</div>
						<form:input path="ID" id="id" type="hidden" />
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
		<!-- Core plugin JavaScript-->
		<script src="resources/vendor/jquery-easing/jquery.easing.min.js">
			
		</script>
		<!-- Page level plugin JavaScript-->
		<script src="resources/vendor/chart.js/Chart.min.js"></script>
		<script src="resources/vendor/datatables/jquery.dataTables.js"></script>
		<script src="resources/vendor/datatables/dataTables.bootstrap4.js"></script>
		<!-- Custom scripts for all pages-->
		<script src="resources/js/sb-admin.min.js"></script>

	</div>

</body>
</html>