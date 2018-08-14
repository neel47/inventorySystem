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


<style>
.card-header {
	background-color: rgb(220, 53, 69);
}

.dropdown-menu {
	background-color: #ececec !important;;
	border: 1px solid #0067CC !important;
}

.btn-danger {
	margin-left: 50%;
}
</style>

<script type="text/javascript">

function optionsCount()
{
	
	var number='${counterQuestionList}';
	for(i=0 ;i<number;i++)
		{
		
	
			if($('input[name="trainingQuestionRecords['+i+'].answerOption"]:checked').length > 0)
			{
				
			}
			else
			{
				alert("Please Select atleast 1 option from Question number "+ (parseInt(i) + parseInt(1)));
				return false

			}
			
		
		}
	
	
	return true;
}


</script>


</head>
<body>

	<div class="content-wrapper">
		<div class="container-fluid">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="${pageContext.servletContext.contextPath}/TrainingMstList">Training
						List</a></li>
				<li class="breadcrumb-item active">Training Test</li>
			</ol>


			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-user"></i> Training Test
				</div>
				<div class="card-body">

					<form:form action="TrainingQuestionTestSave" method="post"
						modelAttribute="trainingMST" onsubmit="return optionsCount(); ">

						<div class="table-responsive">
							<table class="" width="100%" cellspacing="0">


								<tr>
									<td><label for="info">${trainingMST.trainingname}</label></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>


								<c:forEach varStatus="tqcount" var="trainingQuestion"
									items="${trainingMST.trainingQuestionRecords}">
									<tr>

										<td>${trainingQuestion.question}</td>
										<c:if test="${ not empty  trainingQuestion.option1}">
											<td><form:radiobutton
													path="trainingQuestionRecords[${tqcount.index}].answerOption"
													value="1" />${trainingQuestion.option1}</td>
										</c:if>
										<c:if test="${not empty  trainingQuestion.option2}">
											<td><form:radiobutton
													path="trainingQuestionRecords[${tqcount.index}].answerOption"
													value="2" />${trainingQuestion.option2}</td>
										</c:if>
										<c:if test="${  not empty trainingQuestion.option3 }">
											<td><form:radiobutton
													path="trainingQuestionRecords[${tqcount.index}].answerOption"
													value="3" />${trainingQuestion.option3}</td>
										</c:if>
										<c:if test="${  not empty trainingQuestion.option4 }">
											<td><form:radiobutton
													path="trainingQuestionRecords[${tqcount.index}].answerOption"
													value="4" />${trainingQuestion.option4}</td>
										</c:if>
										<c:if test="${ not empty  trainingQuestion.option5}">
											<td><form:radiobutton
													path="trainingQuestionRecords[${tqcount.index}].answerOption"
													value="5" />${trainingQuestion.option5}</td>
										</c:if>
										<c:if test="${not empty  trainingQuestion.option6}">
											<td><form:radiobutton
													path="trainingQuestionRecords[${tqcount.index}].answerOption"
													value="6" />${trainingQuestion.option6}</td>
										</c:if>
										<c:if test="${not empty  trainingQuestion.option7 }">
											<td><form:radiobutton
													path="trainingQuestionRecords[${tqcount.index}].answerOption"
													value="7" />${trainingQuestion.option7}</td>
										</c:if>
										<c:if test="${not empty trainingQuestion.option8}">
											<td><form:radiobutton
													path="trainingQuestionRecords[${tqcount.index}].answerOption"
													value="8" />${trainingQuestion.option8}</td>
										</c:if>
										<c:if test="${not empty trainingQuestion.option9 }">
											<td><form:radiobutton
													path="trainingQuestionRecords[${tqcount.index}].answerOption"
													value="9" />${trainingQuestion.option9}</td>
										</c:if>
										<c:if test="${not empty trainingQuestion.option10}">
											<td><form:radiobutton
													path="trainingQuestionRecords[${tqcount.index}].answerOption"
													value="10" />${trainingQuestion.option10}</td>
										</c:if>
										<form:input
											path="trainingQuestionRecords[${tqcount.index}].rightoption"
											id="rightoption" type="hidden" />
									</tr>
								</c:forEach>

							</table>
							<br>
							<br>
							<form:button class="btn btn-danger">Save</form:button>
						</div>
						<form:input path="id" id="id" type="hidden" />
						<form:input path="traninggoal" id="traninggoal" type="hidden" />
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


		<script type="text/javascript">
			$(document).ready(function() {
					
			})
		</script>

	</div>

</body>
</html>