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
	background-color: rgb(23, 162, 184);
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
					<i class="fa fa-user"></i> Task Creation Form
				</div>
				<div class="card-body">

					<form:form action="TaskMSTCreationSave" method="post"
						modelAttribute="taskmst">

						<div class="table-responsive">
							<table class="" width="100%" cellspacing="0">


								<tr>
									<td><label for="taskname">Task Name</label><font color="red"> *</font></td>
									<td><form:input path="taskname" id="taskname" type="text" pattern="[A-Za-z0-9 ]{1,32}" required="required" placeholder=" Enter Task Name" /></td>
								</tr>
								<tr>
									<td><label for="taskdescription">Task Description</label><font color="red"> *</font></td>
									<td><form:input path="taskdescription"
											id="taskdescription" type="text" required="required" placeholder=" Enter Task Description"/></td>
								</tr>
								<tr>
									<td><label for="taskcategory">Task Category</label><font color="red"> *</font></td>
									<td><form:select path="taskcategory" required="required" >
											<form:option value="NONE" label="--- Select ---" />
											<form:option value="DEADLINE" label="Dead Line" />
											<form:option value="COST" label="Cost" />
											<form:option value="REVENUE" label="Revenue" />
										</form:select></td>
								</tr>
								<tr>
									<td><label for="taskgoal">Task Goal</label><font color="red"> *</font></td>
									<td><form:input path="taskgoal" id="taskgoal" type="text" required="required" placeholder=" Enter Task Goal" /></td>
								</tr>
								<tr>
									<td><label for="startdate">Start Date</label><font color="red"> *</font></td>
									<td><form:input path="startdate" id="startdate"
											name="startdate" type="text" placeholder="DD/MM/YYYY" required="required" /></td>
								</tr>
								<tr>
									<td><label for="enddate">End Date</label><font color="red"> *</font></td>
									<td><form:input path="enddate" id="enddate" name="enddate"
											type="text" placeholder="DD/MM/YYYY" required="required" /></td>
								</tr>
								<tr>
									<td><label for="taskassigneeid">Task Assignee</label><font color="red"> *</font></td>
									<td><form:select path="taskassigneeid" required="required" 
											id="taskassigneeid" size="5">
											<!--  <option value="None" selected>---Select---</option> -->
											<c:forEach items="${users}" var="rm">
												<c:choose>
													<c:when test="''== rm.id}">
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
											class="btn btn-info">Save</form:button></td>
								</tr>





							</table>
						</div>
						<form:input path="id" id="id" type="hidden" />
						<form:input path="version" id="version" type="hidden" />
						<form:input path="taskcreatorid" id="taskcreatorid" type="hidden" />
						<form:input path="taskcreatorcategory" id="taskcreatorcategory"
							type="hidden" />
						<form:input path="taskassigneecategory" id="taskassigneecategory"
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