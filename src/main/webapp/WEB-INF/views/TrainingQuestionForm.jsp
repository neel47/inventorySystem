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
	background-color: rgb(220, 53, 69);
}

.dropdown-menu {
	background-color: #ececec !important;;
	border: 1px solid #0067CC !important;
}
</style>

<script type="text/javascript">

function optionsCount()
{
	var number=document.getElementById("totaloption").value;
	for(i=1 ;i<=10;i++)
		{
		if(i<=number)
		document.getElementById(i).style.display="table-row";
		else
		document.getElementById(i).style.display="none";
		
		}
	
}


</script>


</head>
<body>

	<div class="content-wrapper">
		<div class="container-fluid">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="${pageContext.servletContext.contextPath}/TrainingMstList">Training List</a></li>
				<li class="breadcrumb-item active">Training Question Form </li>
			</ol>


			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-user"></i> Training Question Form
				</div>
				<div class="card-body">

					<form:form action="TrainingQuestionCreationSave" method="post"
						modelAttribute="trainingQuestion">

						<div class="table-responsive">
							<table class="" width="100%" cellspacing="0">
								<tr>
									<td><label for="question">Question<font color="red"> *</font></label></td>
									<td><form:input path="question"
											id="question" type="text" required="required" placeholder="Enter Question" /></td>
								</tr>
								<tr>
									<td><label for="totaloption">Total Options <font color="red"> *</font></label></td>
									<td><form:input path="totaloption"
											id="totaloption" type="text" onchange="optionsCount()" required="required" placeholder="Enter total options" /></td>
								</tr>
								<tr id="1" style="display:none;">
									<td><label for="option1">Option 1 <font color="red"> *</font></label></td>
									<td><form:input path="option1"
											id="option1" type="text" required="required" placeholder="option-1"/></td>
								</tr>

								<tr id="2" style="display:none;">
									<td><label for="option2">Option 2 <font color="red"> *</font></label></td>
									<td><form:input path="option2"
											id="option2" type="text"  placeholder="option-2"/></td>
								</tr>
								<tr id="3" style="display:none;">
									<td><label for="option3">Option 3<font color="red"> *</font></label></td>
									<td><form:input path="option3"
											id="option3" type="text"  placeholder="option-3" /></td>
								</tr>
								<tr id="4" style="display:none;">
									<td><label for="option4">option 4 <font color="red"> *</font> </label></td>
									<td><form:input path="option4"
											id="option4" type="text"  placeholder="option-4"/></td>
								</tr>
								<tr id="5" style="display:none;">
									<td><label for="option5">Option 5 <font color="red"> *</font> </label></td>
									<td><form:input path="option5"
											id="option5" type="text"  placeholder="option-5"/></td>
								</tr>
								<tr id="6" style="display:none;">
									<td><label for="option6">Option 6  <font color="red"> *</font></label></td>
									<td><form:input path="option6"
											id="option6" type="text"  placeholder="option-6"/></td>
								</tr>
								<tr id="7" style="display:none;">
									<td><label for="option7">Option 7 <font color="red"> *</font></label></td>
									<td><form:input path="option7"
											id="option7" type="text" placeholder="option-7"/></td>
								</tr>
								<tr id="8" style="display:none;">
									<td><label for="option8">Option 8 <font color="red"> *</font></label></td>
									<td><form:input path="option8"
											id="option8" type="text"  placeholder="option-8"/></td>
								</tr>
								<tr id="9" style="display:none;">
									<td><label for="option9">Option 9 <font color="red"> *</font> </label></td>
									<td><form:input path="option9"
											id="option9" type="text"  placeholder="option-9"/></td>
								</tr>
								<tr id="10" style="display:none;">
									<td><label for="option10">Option 10 <font color="red"> *</font></label></td>
									<td><form:input path="option10"
											id="option10" type="text"  placeholder="option-10"/></td>
								</tr>
								<tr>
									<td><label for="rightoption">Right Option No.<font color="red"> *</font></label></td>
									<td><form:input path="rightoption"
											id="rightoption" type="text" required="required" placeholder="Correct Answer" /></td>
								</tr>






								<tr>
									<td colspan="2" align="center"><form:button
											class="btn btn-danger">Save</form:button></td>
								</tr>





							</table>
						</div>
						<form:input path="id" id="id" type="hidden" />
						<form:input path="version" id="version" type="hidden" />
						<form:input path="trainingmstid" id="trainingmstid" type="hidden" />
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
					if("EDIT"=='${mode}')
					{
						optionsCount();
					}
			})
		</script>

	</div>

</body>
</html>