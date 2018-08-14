<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<!-- Page level plugin CSS-->
<link href="resources/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="resources/css/sb-admin.css" rel="stylesheet">


<style>
.card-header {
	background-color:rgb(245, 55, 72);
}
</style>
</head>
<body>

	<div class="content-wrapper">
		<div class="container-fluid">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="${pageContext.servletContext.contextPath}/InventoryMstList">Category List</a></li>
				<li class="breadcrumb-item active">${titleMSG}</li>
			</ol>

			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> ${titleMSG}
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Inventory Sub-Category</th>
									<th>Brand</th>
									<th>Quantity</th>
									<th>Price</th>
									<th>Total Price</th>
									<th>Additional Info</th>
									<th>Link</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>Inventory Sub-Category</th>
									<th>Brand</th>
									<th>Quantity</th>
									<th>Price</th>
									<th>Total Price</th>
									<th>Additional Info</th>
									<th>Link</th>
								</tr>
							</tfoot>
							<tbody>


								<c:forEach var="Idet" items="${inventdets}">
									<tr>

										<td>${Idet.inventorysubcategory}</td>
										<td>${Idet.brand}</td>
										<td>${Idet.quantity}</td>
										<td>${Idet.price}</td>
										<td>${Idet.totalprice}</td>
										<td>${Idet.additionalinfo}</td>
										<td><c:choose>
												<c:when test="${loginUserInfo.ecategory=='SUPERVISOR'}">
													<a href="InventoryEditDet?id=${Idet.id}">Edit</a>
											&nbsp;&nbsp;<a href="InventoryDeleteDet?id=${Idet.id}">Delete</a>
												</c:when>
												<%-- <c:otherwise>
													<a href="InventoryEditMst?id=${Idet.id}">it</a>
											&nbsp;&nbsp;<a href="InventoryDeleteMst?id=${Idet.id}">Dete
													</a>
											&nbsp;&nbsp;
												</c:otherwise> --%>
											</c:choose></td>

									</tr>
								</c:forEach>



							</tbody>
						</table>
					</div>
				</div>
				<c:set var="now" value="<%=new java.util.Date()%>" />
				<div class="card-footer small text-muted">
					Updated at
					<fmt:formatDate type="time" value="${now}" />
				</div>
			</div>
		</div>


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
		<!-- <script src="resources/js/sb-admin-charts.min.js"></script> -->

	</div>

</body>
</html>