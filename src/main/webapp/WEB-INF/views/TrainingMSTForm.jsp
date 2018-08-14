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
	background-color: rgb(31, 188, 67);
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
					<i class="fa fa-user"></i> Training Creation Form
				</div>
				<div class="card-body">

					<form:form action="TrainingMSTCreationSave" method="post"
						modelAttribute="trainingmst">

						<div class="table-responsive">
							<table class="" width="100%" cellspacing="0">


								<tr>
									<td><label for="trainingname">Training Name<font color="red"> *</font></label></td>
									<td><form:input path="trainingname" id="trainingname" type="text" required="required" placeholder="Enter training Name"/></td>
								</tr>
								<tr>
									<td><label for="trainingdescription">Training Description<font color="red"> *</font></label></td>
									<td><form:input path="trainingdescription"
											id="trainingdescription" type="text" required="required" placeholder="Enter Training Description" /></td>
								</tr>
								<tr>
									<td><label for="trainingcategory">Training Category<font color="red"> *</font></label></td>
									<td><form:select path="trainingcategory">
											<form:option value="NONE" label="--- Select ---" />
											<form:option value="Single Answer" label="Single Answer" />
										</form:select></td>
								</tr>
								<tr>
									<td><label for="traninggoal">Training Goal<font color="red"> *</font></label></td>
									<td><form:input path="traninggoal" id="traninggoal" type="text" required="required" placeholder="Enter Training Goal" /></td>
								</tr>
								<tr>
									<td><label for="startdate">Start Date<font color="red"> *</font></label></td>
									<td><form:input path="startdate" id="startdate"
											name="startdate" type="text" required="required" placeholder="DD/MM/YYYY" /></td>
								</tr>
								<tr>
									<td><label for="enddate">Expiry Date<font color="red"> *</font></label></td>
									<td><form:input path="enddate" id="enddate" name="enddate"
											type="text" required="required" placeholder="DD/MM/YYYY" /></td>
								</tr>
								
								<tr>
									<td colspan="2" align="center"><form:button
											class="btn btn-success">Save</form:button></td>
								</tr>





							</table>
						</div>
						<form:input path="id" id="id" type="hidden" />
						<form:input path="version" id="version" type="hidden" />
						<form:input path="trainingcreatorid" id="trainingcreatorid" type="hidden" />
						<form:input path="trainingcreatorycategory" id="trainingcreatorycategory"
							type="hidden" />
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
				$('#startdate').datepicker({
					format : 'dd/mm/yyyy',
				});
				$('#enddate').datepicker({
					format : 'dd/mm/yyyy',
				});
			})
		</script>

	</div>

</body>
</html>