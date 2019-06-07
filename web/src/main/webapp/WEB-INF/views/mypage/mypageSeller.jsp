<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<!-- CSS Files -->
<link href="resources/css/mypage/asset/material-dashboard.css"
	rel="stylesheet" />
<div class="wrapper ">
	<div class="sidebar" data-color="purple" data-background-color="black"
		data-image="resources/images/sidebar-2.jpg">
		<!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
		<div class="logo">
			<a href="#" class="simple-text logo-normal"> mypage seller </a>
		</div>
		<div class="sidebar-wrapper">
			<ul class="nav">
				<li class="nav-item active  "><a class="nav-link"
					href="./dashboard.html"> <i class="material-icons">dashboard</i>
						<p>Dashboard</p>
				</a></li>
				<li class="nav-item "><a class="nav-link" href="./user.html">
						<i class="material-icons">person</i>
						<p>User Profile</p>
				</a></li>
				<li class="nav-item "><a class="nav-link" href="./tables.html">
						<i class="material-icons">content_paste</i>
						<p>Table List</p>
				</a></li>
				<li class="nav-item "><a class="nav-link"
					href="./typography.html"> <i class="material-icons">library_books</i>
						<p>Typography</p>
				</a></li>
				<li class="nav-item "><a class="nav-link" href="./icons.html">
						<i class="material-icons">bubble_chart</i>
						<p>Icons</p>
				</a></li>
				<li class="nav-item "><a class="nav-link" href="./map.html">
						<i class="material-icons">location_ons</i>
						<p>Maps</p>
				</a></li>
				<li class="nav-item "><a class="nav-link"
					href="./notifications.html"> <i class="material-icons">notifications</i>
						<p>Notifications</p>
				</a></li>
				<!-- <li class="nav-item active-pro ">
                <a class="nav-link" href="./upgrade.html">
                    <i class="material-icons">unarchive</i>
                    <p>Upgrade to PRO</p>
                </a>
            </li> -->
			</ul>
		</div>
	</div>
	<div class="main-panel">

		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-xl-4 col-lg-12">
						<div class="card card-chart">
							<div class="card-header card-header-success">
								<div class="ct-chart" id="dailySalesChart"></div>
							</div>
							<div class="card-body">
								<h4 class="card-title">이번주 판매량</h4>
								<p class="card-category">
									<span class="text-success"><i
										class="fa fa-long-arrow-up"></i> 55% </span> increase in today sales.
								</p>
							</div>
						</div>
					</div>
					<div class="col-xl-4 col-lg-12">
						<div class="card card-chart">
							<div class="card-header card-header-warning">
								<div class="ct-chart" id="websiteViewsChart"></div>
							</div>
							<div class="card-body">
								<h4 class="card-title">이번달 판매량</h4>
								<p class="card-category">Last Campaign Performance</p>
							</div>
						</div>
					</div>
					<div class="col-xl-4 col-lg-12">
						<div class="card card-chart">
							<div class="card-header card-header-danger">
								<div class="ct-chart" id="completedTasksChart"></div>
							</div>
							<div class="card-body">
								<h4 class="card-title">별점 변화 추이</h4>
								<p class="card-category">Last Campaign Performance</p>
							</div>
						</div>
					</div>
				</div>



				<div class="row">
					<div class="col-lg-12 col-md-12">
						<div class="card">
							<div class="card-header card-header-primary">
								<h4 class="card-title">예약 현황</h4>
								<p class="card-category">현재일로 부터 가까운 예약 현황</p>
							</div>
							<div class="card-body table-responsive">
								<table class="table table-hover">
									<thead class="text-warning">
										<th>구매자</th>
										<th>상품명</th>
										<th>서비스일자</th>
									</thead>
									<tbody>
										<c:forEach var="reservation" items="${reservation}">
											<tr>
												<td>${reservation.MEMBER_ID}</td>
												<td>${reservation.PRODUCT_NAME}</td>
												<td>${reservation.D_SERVICE_DATE}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>


				<div class="row">
					<div class="col-lg-12 col-md-12">
						<div class="card">
							<div class="card-header card-header-primary">
								<h4 class="card-title">인기 상품</h4>
								<p class="card-category">판매량이 가장 많은 상품</p>
							</div>
							<div class="card-body table-responsive">
								<table class="table table-hover">
									<thead class="text-warning">
										<th>구매자</th>
										<th>상품명</th>
										<th>서비스일자</th>
									</thead>
									<tbody>
										<c:forEach var="item" items="${hotItems}" begin="0" end="5">
											<tr>
												<td>${item.PRODUCT_NAME}</td>
												<td>${item.COUNT}</td>
												<td>${item.STAR}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>
		<script>
			const x = new Date().getFullYear();
			let date = document.getElementById('date');
			date.innerHTML = '&copy; ' + x + date.innerHTML;
		</script>
	</div>
</div>
<!--   Core JS Files   -->
<script src="resources/js/mypage/asset/popper.min.js"></script>
<script src="resources/js/mypage/asset/bootstrap-material-design.min.js"></script>
<script src="https://unpkg.com/default-passive-events"></script>
<script src="resources/js/mypage/asset/perfect-scrollbar.jquery.min.js"></script>
<script src="resources/js/mypage/mypageSeller.js"></script>
<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
<!--  Google Maps Plugin    -->
<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!-- Chartist JS -->
<script src="resources/js/mypage/asset/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<script src="resources/js/mypage/asset/bootstrap-notify.js"></script>
<!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
<script src="resources/js/mypage/asset/material-dashboard.js"></script>
<!-- Material Dashboard DEMO methods, don't include it in your project! -->
<script>
	$(document).ready(function() {
		// Javascript method's body can be found in assets/js/demos.js
		md.initDashboardPageCharts();

	});
</script>
