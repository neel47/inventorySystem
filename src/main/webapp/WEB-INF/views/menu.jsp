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

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav"> <a class="navbar-brand"
		href="${pageContext.servletContext.contextPath}/startPage"">Inventory
		System: Hi <c:out value="${loginUserInfo.firstname}"></c:out>
	</a>
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarResponsive"
		aria-controls="navbarResponsive" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Dashboard"><a class="nav-link"
				href="${pageContext.servletContext.contextPath}/dashboard"> <i
					class="fa fa-fw fa-dashboard"></i> <span class="nav-link-text">Dashboard</span>
			</a></li>


			<c:if test="${loginUserInfo.ecategory=='ADMIN'}">
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="User"><a class="nav-link"
					href="${pageContext.servletContext.contextPath}/UserCreation">
						<i class="fa fa-fw fa-user-plus"></i> <span class="nav-link-text">User</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="User List"><a class="nav-link"
					href="${pageContext.servletContext.contextPath}/UserList"> <i
						class="fa fa-fw fa-table"></i> <span class="nav-link-text">User
							List</span>
				</a></li>

				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Project"><a class="nav-link"
					href="${pageContext.servletContext.contextPath}/ProjectCreation">
						<i class="fa fa-fw fa-map"></i> <span class="nav-link-text">Project</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Project List"><a class="nav-link"
					href="${pageContext.servletContext.contextPath}/ProjectList"> <i
						class="fa fa-fw fa-table"></i> <span class="nav-link-text">Project
							List</span>
				</a></li>

			</c:if>


			<c:if test="${loginUserInfo.ecategory!='ADMIN'}">


				<c:if test="${loginUserInfo.ecategory!='EMPLOYEE'}">

					<c:if test="${loginUserInfo.ecategory!='REGIONALMANAGER'}">
						<li class="nav-item" data-toggle="tooltip" data-placement="right"
							title="Adding <c:out value="${downLevelCategory}"></c:out>"><a
							class="nav-link"
							href="${pageContext.servletContext.contextPath}/UserProjectsCreation?from=add">
								<i class="fa fa-fw fa-child"></i> <span class="nav-link-text">Adding
									<c:out value="${downLevelCategory}"></c:out>
							</span>
						</a></li>
						<li class="nav-item" data-toggle="tooltip" data-placement="right"
							title="Deleting <c:out value="${downLevelCategory}"></c:out>">
							<a class="nav-link"
							href="${pageContext.servletContext.contextPath}/UserProjectsCreation?from=delete">
								<i class="fa fa-fw fa-minus-circle"></i> <span
								class="nav-link-text">Deleting <c:out
										value="${downLevelCategory}"></c:out></span>
						</a>
						</li>
					</c:if>

					<li class="nav-item" data-toggle="tooltip" data-placement="right"
						title="Task Creation"><a class="nav-link"
						href="${pageContext.servletContext.contextPath}/TaskMSTCreation">
							<i class="fa fa-fw fa-list-alt"></i> <span class="nav-link-text">Task
								Creation</span>
					</a></li>
					<li class="nav-item" data-toggle="tooltip" data-placement="right"
						title="Task Creator List"><a class="nav-link"
						href="${pageContext.servletContext.contextPath}/TaskMstList">
							<i class="fa fa-fw fa-sitemap"></i> <span class="nav-link-text">Task
								Creator List</span>
					</a></li>
				</c:if>

				<c:if test="${loginUserInfo.ecategory!='REGIONALMANAGER'}">
					<li class="nav-item" data-toggle="tooltip" data-placement="right"
						title="Task Assignee List"><a class="nav-link"
						href="${pageContext.servletContext.contextPath}/TaskMstAssigneeList">
							<i class="fa fa-fw fa-tasks"></i> <span class="nav-link-text">Task
								Assignee List</span>
					</a></li>
				</c:if>

				<c:if test="${loginUserInfo.ecategory=='PROJECTMANAGER'}">
					<li class="nav-item" data-toggle="tooltip" data-placement="right"
						title="Category Creation"><a class="nav-link"
						href="${pageContext.servletContext.contextPath}/InventoryMSTCreation">
							<i class="fa fa-fw fa-sort-amount-asc"></i> <span
							class="nav-link-text">Category Creation</span>
					</a></li>
				</c:if>

				<c:if test="${loginUserInfo.ecategory!='REGIONALMANAGER'}">
					<li class="nav-item" data-toggle="tooltip" data-placement="right"
						title="Category List"><a class="nav-link"
						href="${pageContext.servletContext.contextPath}/InventoryMstList">
							<i class="fa fa-fw fa-list-alt"></i> <span class="nav-link-text">Category
								List</span>
					</a></li>
				</c:if>


				<c:if test="${loginUserInfo.ecategory=='SUPERVISOR'}">
					<li class="nav-item" data-toggle="tooltip" data-placement="right"
						title="Training Creation"><a class="nav-link"
						href="${pageContext.servletContext.contextPath}/TrainingMSTCreation">
							<i class="fa fa-fw fa-graduation-cap"></i> <span
							class="nav-link-text">Training Creation</span>
					</a></li>
				</c:if>


				<c:if
					test="${loginUserInfo.ecategory=='SUPERVISOR' || loginUserInfo.ecategory=='EMPLOYEE'}">
					<li class="nav-item" data-toggle="tooltip" data-placement="right"
						title="Training List"><a class="nav-link"
						href="${pageContext.servletContext.contextPath}/TrainingMstList">
							<i class="fa fa-fw fa-files-o"></i> <span class="nav-link-text">Training
								List</span>
					</a></li>
				</c:if>






			</c:if>



		</ul>
		<ul class="navbar-nav sidenav-toggler">
			<li class="nav-item"><a class="nav-link text-center"
				id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
			</a></li>
		</ul>




		<ul class="navbar-nav ml-auto" style="padding-right: 15%">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown"
				href="#" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fa fa-fw fa-envelope"></i> <span
					class="d-lg-none">Messages <span
						class="badge badge-pill badge-primary">12 New</span>
				</span> <span class="indicator text-primary d-none d-lg-block"> <span
						class="badge badge-pill badge-primary">12 New</span>
				</span>
			</a>
				<div class="dropdown-menu" aria-labelledby="messagesDropdown">
					<h6 class="dropdown-header">New Messages:</h6>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#"> <strong>David
							Miller</strong> <span class="small float-right text-muted">11:21 AM</span>
						<div class="dropdown-message small">Hey there! This new
							version of SB Admin is pretty awesome! These messages clip off
							when they reach the end of the box so they don't overflow over to
							the sides!</div>
					</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#"> <strong>Jane Smith</strong>
						<span class="small float-right text-muted">11:21 AM</span>
						<div class="dropdown-message small">I was wondering if you
							could meet for an appointment at 3:00 instead of 4:00. Thanks!</div>
					</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#"> <strong>John Doe</strong> <span
						class="small float-right text-muted">11:21 AM</span>
						<div class="dropdown-message small">I've sent the final
							files over to you for review. When you're able to sign off of
							them let me know and we can discuss distribution.</div>
					</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item small" href="#">View all messages</a>
				</div></li>




			<!--    
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-bell"></i>
            <span class="d-lg-none">Alerts
              <span class="badge badge-pill badge-warning">6 New</span>
            </span>
            <span class="indicator text-warning d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
          <div class="dropdown-menu" aria-labelledby="alertsDropdown">
            <h6 class="dropdown-header">New Alerts:</h6>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-danger">
                <strong>
                  <i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item small" href="#">View all alerts</a>
          </div>
        </li>
         -->


			<%-- 	<li class="nav-item">
				<form class="form-inline my-2 my-lg-0 mr-lg-2">
					<div class="input-group">
						<input class="form-control" type="text"
							placeholder="Search for..."> <span
							class="input-group-append">
							<button class="btn btn-primary" type="button">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
			</li> --%>
			<li class="nav-item"><a class="nav-link" data-toggle="modal"
				data-target="#exampleModal"> <i class="fa fa-fw fa-sign-out"></i>Logout
			</a></li>
		</ul>




	</div>
	</nav>







	<!-- Logout Modal-->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">X</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary"
						href="${pageContext.servletContext.contextPath}">Logout</a>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
