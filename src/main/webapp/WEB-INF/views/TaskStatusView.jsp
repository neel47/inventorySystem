<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<script type="text/javascript">
	console.log('${labels}');
	console.log('${data}');
	console.log('${goalCompletion}');
	console.log('${dataForBarChart}');
	console.log('${barChartMoney}');
	console.log('${mstTaskGoal}');
	console.log('${remainingMoney}');
	console.log('${isBarchat}');

	try {

		var labels = '${labels}';
		var data = '${data}';
		var dataForBarChart = '${dataForBarChart}';

		var goalComplete = '${goalCompletion}';
		var goalPending = 100 - goalComplete;

		var barChartMoney = '${barChartMoney}';
		var mstTaskGoal = '${mstTaskGoal}';
		var remainingMoney = '${remainingMoney}';

	} catch (e) {
		console.log(e)
	}
</script>
</head>
<body>



	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="${pageContext.servletContext.contextPath}/TaskMstList">Task
						Creator List</a></li>
				<li class="breadcrumb-item active">Task view</li>
			</ol>
			<!-- Icon Cards-->

			<!-- Area Chart Example-->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-area-chart"></i> Task Time Line
				</div>
				<div class="card-body">
					<canvas id="myAreaChart" width="100%" height="30"></canvas>
				</div>
				<c:set var="now" value="<%=new java.util.Date()%>" />
				<div class="card-footer small text-muted">
					Updated at
					<fmt:formatDate type="time" value="${now}" />
				</div>
			</div>



			<div class="row">
				<div class="col-lg-8" id="opt">
					<!-- Example Bar Chart Card-->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fa fa-bar-chart"></i> Revenue / Cost
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-sm-8 my-auto">
									<canvas id="myBarChart" width="100" height="50"></canvas>
								</div>
								<div class="col-sm-4 text-center my-auto">
									<div class="h4 mb-0 text-primary">$${mstTaskGoal}</div>
									<div class="small text-muted">Task Goal</div>
									<hr>
									<div class="h4 mb-0 text-warning">$${remainingMoney}</div>
									<div class="small text-muted">Task pending</div>
									<hr>
									<div class="h4 mb-0 text-success">$${barChartMoney}</div>
									<div class="small text-muted">Task completed</div>
								</div>
							</div>
						</div>
						<c:set var="now" value="<%=new java.util.Date()%>" />
						<div class="card-footer small text-muted">
							Updated at
							<fmt:formatDate type="time" value="${now}" />
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<!-- Example Pie Chart Card-->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fa fa-pie-chart"></i> Task Progress
						</div>
						<div class="card-body">
							<canvas id="myPieChart" width="100%" height="100"></canvas>
						</div>
						<c:set var="now" value="<%=new java.util.Date()%>" />
						<div class="card-footer small text-muted">
							Updated at
							<fmt:formatDate type="time" value="${now}" />
						</div>
					</div>

				</div>

				<!-- Example DataTables Card-->

			</div>
			<!-- /.container-fluid-->
			<!-- /.content-wrapper-->

			<!-- Scroll to Top Button-->
			<a class="scroll-to-top rounded" href="#page-top"> <i
				class="fa fa-angle-up"></i>
			</a>


		</div>
	</div>
	<script type="text/javascript">
		if ("N" == '${isBarchat}')
			document.getElementById("opt").remove();

				Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif',
				Chart.defaults.global.defaultFontColor = "#292b2c";
		var ctx = document.getElementById("myAreaChart"), myLineChart = new Chart(
				ctx, {
					type : "line",
					data : {
						labels : labels.split(','),
						datasets : [ {
							label : "Completed",
							lineTension : .3,
							backgroundColor : "rgba(2,117,216,0.2)",
							borderColor : "rgba(2,117,216,1)",
							pointRadius : 5,
							pointBackgroundColor : "rgba(2,117,216,1)",
							pointBorderColor : "rgba(255,255,255,0.8)",
							pointHoverRadius : 5,
							pointHoverBackgroundColor : "rgba(2,117,216,1)",
							pointHitRadius : 20,
							pointBorderWidth : 2,
							data : data.split(',')
						} ]
					},
					options : {
						scales : {
							xAxes : [ {
								time : {
									unit : "date"
								},
								gridLines : {
									display : !1
								},
								ticks : {
									maxTicksLimit : 7
								}
							} ],
							yAxes : [ {
								ticks : {
									min : 0,
									max : 100,
									maxTicksLimit : 5
								},
								gridLines : {
									color : "rgba(0, 0, 0, .125)"
								}
							} ]
						},
						legend : {
							display : !1
						}
					}
				}), ctx = document.getElementById("myPieChart"), myPieChart = new Chart(
				ctx, {
					type : "pie",
					data : {
						labels : [ "Task Pending", "Task Completed" ],
						datasets : [ {
							data : [ goalPending, goalComplete ],
							backgroundColor : [ "#dc3545", "#28a745" ]
						} ]
					}
				}), ctx = document.getElementById("myBarChart"), myLineChart = new Chart(
				ctx, {
					type : "bar",
					data : {
						labels : labels.split(','),
						datasets : [ {
							label : "Revenue",
							backgroundColor : "rgba(2,117,216,1)",
							borderColor : "rgba(2,117,216,1)",
							data : dataForBarChart.split(',')
						} ]
					},
					options : {
						scales : {
							xAxes : [ {
								time : {
									unit : "date"
								},
								gridLines : {
									display : !1
								},
								ticks : {
									maxTicksLimit : 6
								}
							} ],
							yAxes : [ {
								ticks : {
									min : 0,
									max : parseInt(mstTaskGoal),
									maxTicksLimit : 5
								},
								gridLines : {
									display : !0
								}
							} ]
						},
						legend : {
							display : !1
						}
					}
				});
	</script>
</html>