<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<div class="wrapper ">
   <%@include file="../include/sidebar.jsp"%>
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
								<h4 class="card-title">지난주 판매량</h4>
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
								<h4 class="card-title">월별 판매량</h4>
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
                                 <tr class="reservation">
                                    <td class="member_id" id="${reservation.MEMBER_ID}">${reservation.MEMBER_ID}</td>
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
                              <th>상품명</th>
                              <th>판매량</th>
                              <th>만족도평균</th>
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

   </div>
</div>
<!--   Core JS Files   -->

<script src="resources/js/mypage/asset/perfect-scrollbar.jquery.min.js"></script>
<script src="/resources/js/mypage/mypageSeller.js"></script>
<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
<!--  Google Maps Plugin    -->
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