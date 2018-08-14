<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Inventory system</title>
<!-- Bootstrap core CSS-->
<link href="resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="resources/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="resources/css/sb-admin.css" rel="stylesheet">
</head>
<body>



	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
				<li class="breadcrumb-item active">My Dashboard</li>
			</ol>
			<!-- Icon Cards-->
			<div class="row">


				<c:if
					test="${loginUserInfo.ecategory=='PROJECTMANAGER' || loginUserInfo.ecategory=='SUPERVISOR' }">
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-primary o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fa fa-fw fa-comments"></i>
								</div>
								<div class="mr-5">Adding ${downLevelCategory}</div>
							</div>
							<a class="card-footer text-white clearfix small z-1"
								href="${pageContext.servletContext.contextPath}/UserProjectsCreation?from=add">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fa fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-warning o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fa fa-fw fa-list"></i>
								</div>
								<div class="mr-5">Tasks List</div>
							</div>
							<a class="card-footer text-white clearfix small z-1"
								href="${pageContext.servletContext.contextPath}/TaskMstAssigneeList">
								<span class="float-left">View Details </span> <span
								class="float-right"> <i class="fa fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-success o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fa fa-fw fa-shopping-cart"></i>
								</div>
								<div class="mr-5">Category List</div>
							</div>
							<a class="card-footer text-white clearfix small z-1"
								href="${pageContext.servletContext.contextPath}/InventoryMstList">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fa fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					
					<c:if test="${loginUserInfo.ecategory=='PROJECTMANAGER'}">
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-danger o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fa fa-fw fa-support"></i>
								</div>
								<div class="mr-5">Deleting ${downLevelCategory}</div>
							</div>
							<a class="card-footer text-white clearfix small z-1"
								href="${pageContext.servletContext.contextPath}/UserProjectsCreation?from=delete">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fa fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					</c:if>
					
					<c:if test="${loginUserInfo.ecategory=='SUPERVISOR' }">
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-danger o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fa fa-fw fa-support"></i>
								</div>
								<div class="mr-5">Training List</div>
							</div>
							<a class="card-footer text-white clearfix small z-1"
								href="${pageContext.servletContext.contextPath}/TrainingMstList">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fa fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					</c:if>
					
					
				</c:if>

				<c:if test="${loginUserInfo.ecategory=='ADMIN'}">
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-warning o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fa fa-fw fa-list"></i>
								</div>
								<div class="mr-5">Project List</div>
							</div>
							<a class="card-footer text-white clearfix small z-1"
								href="${pageContext.servletContext.contextPath}/ProjectList">
								<span class="float-left">View Details </span> <span
								class="float-right"> <i class="fa fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-primary o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fa fa-fw fa-comments"></i>
								</div>
								<div class="mr-5">User List</div>
							</div>
							<a class="card-footer text-white clearfix small z-1"
								href="${pageContext.servletContext.contextPath}/UserList"> <span
								class="float-left">View Details</span> <span class="float-right">
									<i class="fa fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>

				</c:if>
				<c:if test="${loginUserInfo.ecategory=='EMPLOYEE'}">
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-warning o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fa fa-fw fa-list"></i>
								</div>
								<div class="mr-5">Tasks List</div>
							</div>
							<a class="card-footer text-white clearfix small z-1"
								href="${pageContext.servletContext.contextPath}/TaskMstAssigneeList">
								<span class="float-left">View Details </span> <span
								class="float-right"> <i class="fa fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-success o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fa fa-fw fa-shopping-cart"></i>
								</div>
								<div class="mr-5">Category List</div>
							</div>
							<a class="card-footer text-white clearfix small z-1"
								href="${pageContext.servletContext.contextPath}/InventoryMstList">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fa fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-danger o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fa fa-fw fa-support"></i>
								</div>
								<div class="mr-5">Training List</div>
							</div>
							<a class="card-footer text-white clearfix small z-1"
								href="${pageContext.servletContext.contextPath}/TrainingMstList">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fa fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
				</c:if>
				
				<c:if test="${loginUserInfo.ecategory=='REGIONALMANAGER'}">
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-warning o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fa fa-fw fa-list"></i>
								</div>
								<div class="mr-5">Tasks List</div>
							</div>
							<a class="card-footer text-white clearfix small z-1"
								href="${pageContext.servletContext.contextPath}/TaskMstList">
								<span class="float-left">View Details </span> <span
								class="float-right"> <i class="fa fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
				</c:if>

			</div>

			Hi, ${loginUserInfo.firstname} ${loginUserInfo.lastname}<br>
			Designation : ${loginUserInfo.ecategory}<br> Gender :
			${loginUserInfo.gender}<br> Email : ${loginUserInfo.email}<br>
			Tel : ${loginUserInfo.tel}<br> City : ${loginUserInfo.city}<br>
			Province : ${loginUserInfo.province}<br> Country :
			${loginUserInfo.country}<br>

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
		<script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>
		<!-- Page level plugin JavaScript-->
		<script src="resources/vendor/chart.js/Chart.min.js"></script>
		<script src="resources/vendor/datatables/jquery.dataTables.js"></script>
		<script src="resources/vendor/datatables/dataTables.bootstrap4.js"></script>
		<!-- Custom scripts for all pages-->
		<script src="resources/js/sb-admin.min.js"></script>
		<!-- Custom scripts for this page-->
		<script src="resources/js/sb-admin-datatables.min.js"></script>
		<script src="resources/js/sb-admin-charts.min.js"></script>
	</div>
</html>