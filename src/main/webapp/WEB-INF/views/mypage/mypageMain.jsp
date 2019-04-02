<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageMain.css" />

<%-- use strict 시작 (.js 파일로 나누지 않은 이유는 검색 결과.. 한 파일 안에 있어야 됨) --%>
<script>
	'use strict';

	window.chartColors = {
		red : 'rgb(255, 99, 132)',
		orange : 'rgb(255, 159, 64)',
		yellow : 'rgb(255, 205, 86)',
		green : 'rgb(75, 192, 192)',
		blue : 'rgb(54, 162, 235)',
		purple : 'rgb(153, 102, 255)',
		grey : 'rgb(201, 203, 207)'
	};

	(function(global) {
		var MONTHS = [ 'January', 'February', 'March', 'April', 'May', 'June',
				'July', 'August', 'September', 'October', 'November',
				'December' ];

		var COLORS = [ '#4dc9f6', '#f67019', '#f53794', '#537bc4', '#acc236',
				'#166a8f', '#00a950', '#58595b', '#8549ba' ];

		var Samples = global.Samples || (global.Samples = {});
		var Color = global.Color;

		Samples.utils = {
			// Adapted from http://indiegamr.com/generate-repeatable-random-numbers-in-js/
			srand : function(seed) {
				this._seed = seed;
			},

			rand : function(min, max) {
				var seed = this._seed;
				min = min === undefined ? 0 : min;
				max = max === undefined ? 1 : max;
				this._seed = (seed * 9301 + 49297) % 233280;
				return min + (this._seed / 233280) * (max - min);
			},

			color : function(index) {
				return COLORS[index % COLORS.length];
			},

		};

		// DEPRECATED
		window.randomScalingFactor = function() {
			return Math.round(Samples.utils.rand(-100, 100));
		};
		Samples.utils.srand(Date.now());

	}(this));
</script>
<%-- use strict 끝 --%>

<%-- 방문자 수 그래프 시작 --%>
<div class="container">
	<div class="login-main-text">
		<h2>mypage</h2>
		<div style="width: 90%;">
			<canvas id="canvas"></canvas>
		</div>
		<br> <br>
		<script>
			var MONTHS = [ 'January', 'February', 'March', 'April', 'May',
					'June', 'July', 'August', 'September', 'October',
					'November', 'December' ];
			var config = {
				type : 'line',
				data : {
					// 밑에 표시되는 것(1~12월)
					labels : [ 'January', 'February', 'March', 'April', 'May',
							'June', 'July', 'August', 'September', 'October',
							'November', 'December' ],
					datasets : [
							{
								label : 'My First dataset',
								backgroundColor : window.chartColors.red,
								borderColor : window.chartColors.red,
								data : [
								// 그래프(데이터) 표시
								randomScalingFactor(), randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor() ],
								fill : false,
							},
							{
								label : 'My Second dataset',
								fill : false,
								backgroundColor : window.chartColors.blue,
								borderColor : window.chartColors.blue,
								data : [ randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor(),
										randomScalingFactor() ],
							} ]
				},
				options : {
					responsive : true,
					title : {
						display : true,
						text : 'Chart.js Line Chart'
					},
					tooltips : {
						mode : 'index',
						intersect : false,
					},
					hover : {
						mode : 'nearest',
						intersect : true
					},
					scales : {
						xAxes : [ {
							display : true,
							scaleLabel : {
								display : true,
								labelString : 'Month'
							}
						} ],
						yAxes : [ {
							display : true,
							scaleLabel : {
								display : true,
								labelString : 'Value'
							}
						} ]
					}
				}
			};

			// 그래프 표시
			window.onload = function() {
				var ctx = document.getElementById('canvas').getContext('2d');
				window.myLine = new Chart(ctx, config);
			};
		</script>
	</div>
<%-- 방문자 수 그래프 끝 --%>

	<section class="content">
		<main>
		<div class="col-md-6 col-sm-12">
			<div class="login-form">
				<form>
					<div class="form-group"></div>
				</form>
			</div>
		</div>
		</main>
		<nav>
			<ul>
			</ul>
		</nav>
		<aside></aside>

	</section>
</div>
<footer>
	<a href="C:\Users\bon300-18\Desktop/cat.jpg">최신글 목록</a>
	<div class="row">
		<div class="col-md-4">
			<div class="card mb-4">
				<img src="resources/images/test2.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="#" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
		</div>

		<div class="col-md-4">
			<div class="card mb-4">
				<img src="resources/images/test.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="#" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
		</div>


		<div class="col-md-4">
			<div class="card mb-4">
				<img src="resources/images/test.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="#" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
		</div>
	</div>
</footer>

<script src='resources/js/mypage/mypageMain.js'></script>
<%@include file="../include/footer.jsp"%>