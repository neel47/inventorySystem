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
	background-color: rgb(36, 202, 236);
}

.dropdown-menu {
	background-color: #ececec !important;;
	border: 1px solid #0067CC !important;
}
</style>


<script type="text/javascript">


function totalPrice()
{
	
	document.getElementById("totalprice").value= document.getElementById("quantity").value * document.getElementById("price").value;
}


</script>

</head>
<body>

	<div class="content-wrapper">
		<div class="container-fluid">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="${pageContext.servletContext.contextPath}/InventoryMstList">Category List</a></li>
				<li class="breadcrumb-item active">Inventory Sub-Category Form</li>
			</ol>

			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-user"></i> Inventory Sub-Category Form
				</div>
				<div class="card-body">

					<form:form action="InventoryDETCreationSave" method="post"
						modelAttribute="inventoryDet" >

						<div class="table-responsive">
							<table class="" width="100%" cellspacing="0">


								<tr>
									<td><label for="inventorysubcategory">Inventory Sub-Category<font color="red"> *</font></label></td>
									<td><form:input path="inventorysubcategory" id="inventorysubcategory" type="text" required="required" placeholder="Enter Inventory Sub-Category" /></td>
								</tr>
								<tr>
									<td><label for="brand">Brand<font color="red"> *</font></label></td>
									<td><form:input path="brand" id="brand" type="text" required="required" placeholder="Enter Brand"/></td>
								</tr>
								<tr>
									<td><label for="quantity">Quantity<font color="red"> *</font></label></td>
									<td><form:input path="quantity" id="quantity" type="text" onchange="totalPrice()" required="required" placeholder="Enter Quantity"/></td>
								</tr>
								<tr>
									<td><label for="price">Price<font color="red"> *</font></label></td>
									<td><form:input path="price" id="price" type="text" onchange="totalPrice()" required="required" placeholder="Enter Price"/></td>
								</tr>
								<tr>
									<td><label for="totalprice">Total Price<font color="red"> *</font></label></td>
									<td><form:input path="totalprice" id="totalprice" type="text" readonly="true" required="required" placeholder="Enter Total Price"/></td>
								</tr>
								<tr>
									<td><label for="additionalinfo">Additional Info<font color="red"> *</font></label></td>
									<td><form:input path="additionalinfo" id="additionalinfo" type="text" required="required" placeholder="Enter Additional Info"/></td>
								</tr>
								

								<tr>
									<td colspan="2" align="center"><form:button
											class="btn btn-info">Save</form:button></td>
								</tr>





							</table>
						</div>
						<form:input path="id" id="id" type="hidden" />
						<form:input path="version" id="version" type="hidden" />
						<form:input path="inventorymstid" id="inventorymstid" type="hidden" />
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

	</div>

</body>
</html>