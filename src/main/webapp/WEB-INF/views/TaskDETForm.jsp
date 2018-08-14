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


</head>
<body>

	<div class="content-wrapper">
		<div class="container-fluid">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="${pageContext.servletContext.contextPath}/TaskMstAssigneeList">Task
						Assignee List</a></li>
				<li class="breadcrumb-item active">Task Assignee List</li>
			</ol>


			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-user"></i> Task Status Form
				</div>
				<div class="card-body">

					<form:form action="TaskDETCreationSave" method="post"
						modelAttribute="taskdet">

						<div class="table-responsive">
							<table class="" width="100%" cellspacing="0">
								<tr>
									<td><label for="taskdate">Task Date<font color="red"> *</font></label></td>
									<td><form:input path="taskdate" id="taskdate"
											name="taskdate" type="text" placeholder="DD/MM/YYYY" required="required" /></td>
								</tr>

								<tr>
									<td><label for="tasknataskeoddescriptionme">Task
											EOD Description<font color="red"> *</font></label></td>
									<td><form:input path="taskeoddescription"
											id="taskeoddescription" type="text" required="required" placeholder="Enter Task Description"/></td>
								</tr>
								<tr>
									<td><label for="taskgoaldescription">Task Goal
											Description<font color="red"> *</font></label></td>
									<td><form:input path="taskgoaldescription"
											id="taskgoaldescription" type="text" required="required" placeholder="Enter Task Goal" onchange="calculateTaskPercentage();"/></td>
								</tr>

								<tr>
									<td><label for="taskgoalcompletion">Task
											Completion in % <font color="red"> *</font></label></td>
									<td><form:input path="taskgoalcompletion"
											id="taskgoalcompletion" type="text" required="required" /></td>
								</tr>






								<tr>
									<td colspan="2" align="center"><form:button
											class="btn btn-danger">Save</form:button></td>
								</tr>





							</table>
						</div>
						<form:input path="id" id="id" type="hidden" />
						<form:input path="version" id="version" type="hidden" />
						<form:input path="taskmstid" id="taskmstid" type="hidden" />
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
				$('#taskdate').datepicker({
					format : 'dd/mm/yyyy',
				});
				

				var taskMSTCategory = '${taskMST.taskcategory}';
					if("DEADLINE"!=taskMSTCategory)
					{
						document.getElementById("taskgoalcompletion").readOnly = true;
					}


			})
			
			function calculateTaskPercentage()
			{
				var taskMSTCategory = '${taskMST.taskcategory}';
				if("DEADLINE"!=taskMSTCategory)
				{
				var taskGoalMst=getNumberFromString('${taskMST.taskgoal}');
				var taskGoalDescriptionDet=	getNumberFromString(document.getElementById("taskgoaldescription").value);
					if(taskGoalMst<0 || taskGoalDescriptionDet<0)
					{
					 alert("Please input Amount in Goal Description.");
					 return false;
					}
				
					/* alert("Goal "+taskGoalDescriptionDet);
					var middle=(taskGoalDescriptionDet/taskGoalMst);
					alert(middle); */
				var percentage= (( parseFloat(taskGoalDescriptionDet)/parseFloat(taskGoalMst))*100).toFixed(2);
				
				if(percentage>100)
					{
					alert("Amount enter exceeds the Goal amount.");
					return false;
					}
				
				document.getElementById("taskgoalcompletion").value=parseFloat(percentage);
				}
			
				return true;
			}
			
			function getNumberFromString(alphanumeric)
			{
				try{
					var number=alphanumeric.match(/\d+(.\d+)?/);
					///alert(number);
				}catch(e){console.log(e);alert("Please input Amount in Goal Descriptionssssssss."); return -1;}
				
				return number[0];
			}
			
		</script>

	</div>

</body>
</html>