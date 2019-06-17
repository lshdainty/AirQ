var ip = sessionStorage.getItem('IP_ADDRESS');
// var ip = "http://39.127.7.69";
var member_id = JSON.parse(sessionStorage.getItem("user")).member_id;
/* *************************** page init function ******************** */
$.ajax({
	type: "GET",
	url: ip + "/m.inOldData",
	data: { member_id: "kimminsu" },
	dataType: "json",
	success: function (data) {
		$("#matterValue").text(data.matterValue);
		$("#todayAvg").text(data.todayAvg);
		$("#overValue").text(data.overValue);
		var gradeText = "";
		var gradeImage = "";
		var gradeRecommend = "";
		switch (data.grade) {
			case 1:
				gradeText = "최고";
				gradeImage = "1";
				gradeRecommend = "최적의 공기 상태에요. 이 상태를 유지해주세요.";
				break;
			case 2:
				gradeText = "좋음";
				gradeImage = "1";
				gradeRecommend = "최적의 공기 상태에요. 이 상태를 유지해주세요.";
				break;
			case 3:
				gradeText = "양호";
				gradeImage = "2";
				gradeRecommend = "좋은 공기 상태에요. 30분간 환기를 시켜주면 더 좋아요.";
				break;
			case 4:
				gradeText = "보통";
				gradeImage = "2";
				gradeRecommend = "좋은 공기 상태에요. 30분간 환기를 시켜주면 더 좋아요.";
				break;
			case 5:
				gradeText = "나쁨";
				gradeImage = "3";
				gradeRecommend = "공기 상태가 좋지 않아요. 공기청정기를 가동하거나 환기를 시켜주세요.";
				break;
			case 6:
				gradeText = "상당히 나쁨";
				gradeImage = "4";
				gradeRecommend = "공기 상태가 좋지 않아요. 공기청정기를 가동하거나 환기를 시켜주세요.";
				break;
			case 7:
				gradeText = "매우 나쁨";
				gradeImage = "5";
				gradeRecommend = "공기 상태가 최악이에요. 이 상태가 지속될 시 공기 질 개선 서비스를 받으세요.";
				break;
			case 8:
				gradeText = "최악";
				gradeImage = "6";
				gradeRecommend = "공기 상태가 최악이에요. 이 상태가 지속될 시 공기 질 개선 서비스를 받으세요.";
				break;
		}
		$("#face").attr('src', "../../../www/resources/images/face_" + gradeImage + ".svg");
		$(".info_grade__value").text(gradeText);
		$(".info_grade__container").addClass("grade_" + data.grade);
		$(".info_behavior").text(gradeRecommend);
		inOldData(data.oldData);	//기본 30개값 가져오기
	}
});

ajaxChart("신암동", "pm10");
ajaxArea("대구");
$("#areaName").val("신암동");
$("#sido_code").val("대구").prop("selected", true);
$("#sigoon_code").val("신암동").prop("selected", true);
$("#matter").val("pm10").prop("selected", true);
/* ******************************************************************** */
// var ip = "http://192.168.2.8";

// var htmlMarkers = [];

// var htmlMarker1 = {
// 		content: '<div id="htmlMarker1"></div>',
// 	    size: N.Size(40, 40),
// 	    anchor: N.Point(20, 20)
// 	},
// 	htmlMarker2 = {
// 	    content: '<div id="htmlMarker2"></div>',
// 	    size: N.Size(40, 40),
// 	    anchor: N.Point(20, 20)
// 	},
// 	htmlMarker3 = {
// 	    content: '<div id="htmlMarker3"></div>',
// 	    size: N.Size(40, 40),
// 	    anchor: N.Point(20, 20)
// 	},
// 	htmlMarker4 = {
// 	    content: '<div id="htmlMarker4"></div>',
// 	    size: N.Size(40, 40),
// 	    anchor: N.Point(20, 20)
// 	},
// 	htmlMarker5 = {
// 	    content: '<div id="htmlMarker5"></div>',
// 	    size: N.Size(40, 40),
// 	    anchor: N.Point(20, 20)
// 	};

// //gps값 가져오기
// if (navigator.geolocation) {
// 	//위치 정보를 얻기
// 	navigator.geolocation.getCurrentPosition(function (position) {
// 		var x = position.coords.latitude;
// 		var y = position.coords.longitude;

// 		var mapOptions = {
// 			center: new naver.maps.LatLng(x, y),
// 			zoom: 12,
// 			scaleControl: false,
// 			logoControl: false,
// 			mapDataControl: false,
// 			zoomControl: true,
// 			minZoom: 1
// 		};

// 		var map = new naver.maps.Map('map', mapOptions);
// 		var latlng = map.getCenter();

// 		$.ajax({
// 			type:"get",
// 			url:ip+"/m.outsideData",
// 			dataType:"json",
// 			async: false,
// 			success: function(data) {
// 				var marker_position = data;
// 				console.log(marker_position);
// 				//마커찍는 부분
// 				for(var i=0; i<marker_position.result.length; i++){

// 					//html기반 마커찍기
// 					var markerContent = [
// 						'<div style="position:absolute;">',
// 							'<span class="pin_point">',
// 								'<span class="station_a">',
// 									'<div id="area">',
// 										'<span class="station_name">'+marker_position.result[i].stationName+'</span> ',
// 										'<span class="dataTime">'+marker_position.result[i].dataTime+'</span>',
// 									'</div>',
// 									'<div id="value">',
// 										'<div>',
// 											'<span class="matter_name">미세먼지 : </span>',
// 											'<span class="matter_value">'+marker_position.result[i].pm10Value+'µg/m³</span>',
// 										'</div>',
// 										'<div>',
// 											'<span class="matter_name">초미세먼지 : </span>',
// 											'<span class="matter_value">'+marker_position.result[i].pm25Value+'µg/m³</span>',
// 										'</div>',
// 										'<div>',
// 											'<span class="matter_name">이산화질소 : </span>',
// 											'<span class="matter_value">'+marker_position.result[i].no2Value+'ppm</span>',
// 										'</div>',
// 										'<div>',
// 											'<span class="matter_name">오존 : </span>',
// 											'<span class="matter_value">'+marker_position.result[i].o3Value+'ppm</span>',
// 										'</div>',
// 										'<div>',
// 											'<span class="matter_name">일산화탄소 : </span>',
// 											'<span class="matter_value">'+marker_position.result[i].coValue+'ppm</span>',
// 										'</div>',
// 										'<div>',
// 											'<span class="matter_name">아황산가스 : </span>',
// 											'<span class="matter_value">'+marker_position.result[i].so2Value+'ppm</span>',
// 										'</div>',
// 									'</div>',
//                                 '</span>', 
//                             '</span>',
// 							'<div class="pin_s">',
// 								'<img class="pin_s_img" src="https://ssl.pstatic.net/static/maps/mantle/1x/marker-default.png" alt="">',
// 							'</div>',
// 						'</div>'
// 					].join('');

// 					//json에 저장된 위치정보 하나씩 가져오기
// 					var position = new naver.maps.LatLng(
// 							marker_position.result[i].x,
// 							marker_position.result[i].y);

// 					//html마커 naver map에 생성
// 					var htmlMarker = new naver.maps.Marker({
// 							position: position,
// 							map: map,
// 							icon: {
// 								content: markerContent,
// 								size: new naver.maps.Size(22, 30),
// 								anchor: new naver.maps.Point(11, 30)
// 							}
// 						});
// 					htmlMarkers.push(htmlMarker);
// 				}

// 				//마커 클러스터 생성
// 				var markerClustering = new MarkerClustering({
// 					minClusterSize: 2,
// 					maxZoom: 8,
// 					map: map,
// 					markers: htmlMarkers,
// 					disableClickZoom: false,
// 					gridSize: 120,
// 					icons: [htmlMarker1, htmlMarker2, htmlMarker3, htmlMarker4, htmlMarker5],
// 					indexGenerator: [10, 20, 30, 40, 50],
// 					stylingFunction: function(clusterMarker, count) {
// 						$(clusterMarker.getElement()).find('div:first-child').text(count);
// 					}
// 				});
// 			}
// 		});
// 	});
// } else {
// 	alert("이 브라우저에서는 Geolocation이 지원되지 않습니다.");
// }

// //infowindow 생성/삭제
// $(document).on('click',".pin_s_img",function(e) {
// 	var infowindow = $(this).parent().parent().find('.pin_point');
// 	if(infowindow.css('display')=="block"){
// 	   infowindow.hide();
// 	}else{
// 	   infowindow.show();
// 	}
// });


/* ********** 실내 ********** */
/* inside monitoring js */
// live chart 시작


//live chart시작
function inOldData(OldData) {
	am4core.ready(function () {

		// Themes begin
		am4core.useTheme(am4themes_spiritedaway);
		// Themes end

		var chart = am4core.create("liveChart", am4charts.XYChart);
		chart.hiddenState.properties.opacity = 0;

		chart.padding(0, 0, 0, 0);

		chart.zoomOutButton.disabled = true;

		var data = [];
		var value;
		var i = 0;

		for (i = 0; i < OldData.length; i++) {
			value = OldData[i].VALUE;
			data.push({
				TIME: new Date(OldData[i].TIME),
				VALUE: value
			});
		}
		chart.data = data;

		var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
		dateAxis.renderer.grid.template.location = 0;
		dateAxis.renderer.minGridDistance = 30;
		dateAxis.dateFormats.setKey("second", "ss");
		dateAxis.periodChangeDateFormats.setKey("second", "[bold]h:mm a");
		dateAxis.periodChangeDateFormats.setKey("minute", "[bold]h:mm a");
		dateAxis.periodChangeDateFormats.setKey("hour", "[bold]h:mm a");
		dateAxis.renderer.inside = true;
		dateAxis.renderer.axisFills.template.disabled = true;
		dateAxis.renderer.ticks.template.disabled = true;

		var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
		valueAxis.tooltip.disabled = true;
		valueAxis.interpolationDuration = 500;
		valueAxis.rangeChangeDuration = 500;
		valueAxis.renderer.inside = true;
		valueAxis.renderer.minLabelPosition = 0.05;
		valueAxis.renderer.maxLabelPosition = 0.95;
		valueAxis.renderer.axisFills.template.disabled = true;
		valueAxis.renderer.ticks.template.disabled = true;

		var series = chart.series.push(new am4charts.LineSeries());
		series.dataFields.dateX = "TIME";
		series.dataFields.valueY = "VALUE";
		series.interpolationDuration = 500;
		series.defaultState.transitionDuration = 0;
		series.tensionX = 0.8;

		chart.events.on("datavalidated", function () {
			dateAxis.zoom({
				start: 1 / 15,
				end: 1.2
			}, false, true);
		});

		dateAxis.interpolationDuration = 500;
		dateAxis.rangeChangeDuration = 500;

		// 창이 내려갔을때 어떤 행동을 할것인가
		// document.addEventListener("visibilitychange", function() {
		// startInterval();
		// if (document.hidden) {
		// if (interval) {
		// clearInterval(interval);
		// }
		// }
		// else {
		// startInterval();
		// }
		// }, false);

		// add data
		var interval;
		function startInterval() {
			interval = setInterval(function () {
				$.ajax({
					type: "GET",
					data: { member_id: member_id },
					url: ip + "/m.inNowData",
					dataType: "json",
					success: function (data) {
						console.log(data);
						$("#matterValue").text(data.matterValue);
						$("#todayAvg").text(data.todayAvg);
						$("#overValue").text(data.overValue);
						var gradeText = "";
						var gradeImage = "";
						var gradeRecommend = "";
						switch (data.grade) {
							case 1:
								gradeText = "최고";
								gradeImage = "1";
								gradeRecommend = "최적의 공기 상태에요. 이 상태를 유지해주세요.";
								break;
							case 2:
								gradeText = "좋음";
								gradeImage = "1";
								gradeRecommend = "최적의 공기 상태에요. 이 상태를 유지해주세요.";
								break;
							case 3:
								gradeText = "양호";
								gradeImage = "2";
								gradeRecommend = "좋은 공기 상태에요. 30분간 환기를 시켜주면 더 좋아요.";
								break;
							case 4:
								gradeText = "보통";
								gradeImage = "2";
								gradeRecommend = "좋은 공기 상태에요. 30분간 환기를 시켜주면 더 좋아요.";
								break;
							case 5:
								gradeText = "나쁨";
								gradeImage = "3";
								gradeRecommend = "공기 상태가 좋지 않아요. 공기청정기를 가동하거나 환기를 시켜주세요.";
								break;
							case 6:
								gradeText = "상당히 나쁨";
								gradeImage = "4";
								gradeRecommend = "공기 상태가 좋지 않아요. 공기청정기를 가동하거나 환기를 시켜주세요.";
								break;
							case 7:
								gradeText = "매우 나쁨";
								gradeImage = "5";
								gradeRecommend = "공기 상태가 최악이에요. 이 상태가 지속될 시 공기 질 개선 서비스를 받으세요.";
								break;
							case 8:
								gradeText = "최악";
								gradeImage = "6";
								gradeRecommend = "공기 상태가 최악이에요. 이 상태가 지속될 시 공기 질 개선 서비스를 받으세요.";
								break;
						}
						$("#face").attr('src', "../../../www/resources/images/face_" + gradeImage + ".svg");
						$(".info_grade__value").text(gradeText);
						$(".info_grade__container").addClass("grade_" + data.grade);
						$(".info_behavior").text(gradeRecommend);
						chart.addData({
							TIME: new Date(data.nowData[0].TIME),
							VALUE: data.nowData[0].VALUE
						}, 1);
					}
				});
			}, 6000);
		}

		startInterval();

		// all the below is optional, makes some fancy effects
		// gradient fill of the series
		series.fillOpacity = 1;
		var gradient = new am4core.LinearGradient();
		gradient.addColor(chart.colors.getIndex(0), 0.2);
		gradient.addColor(chart.colors.getIndex(0), 0);
		series.fill = gradient;

		// this makes date axis labels to fade out
		dateAxis.renderer.labels.template.adapter.add("fillOpacity", function (
			fillOpacity, target) {
			var dataItem = target.dataItem;
			return dataItem.position;
		})

		// need to set this, otherwise fillOpacity is not changed and not set
		dateAxis.events.on("validated", function () {
			am4core.iter.each(dateAxis.renderer.labels.iterator(), function (
				label) {
				label.fillOpacity = label.fillOpacity;
			})
		})

		// this makes date axis labels which are at equal minutes to be rotated
		dateAxis.renderer.labels.template.adapter.add("rotation", function (
			rotation, target) {
			var dataItem = target.dataItem;
			if (dataItem.date
				&& dataItem.date.getTime() == am4core.time.round(
					new Date(dataItem.date.getTime()), "minute")
					.getTime()) {
				target.verticalCenter = "middle";
				target.horizontalCenter = "left";
				return -90;
			} else {
				target.verticalCenter = "bottom";
				target.horizontalCenter = "middle";
				return 0;
			}
		})

		// bullet at the front of the line
		var bullet = series.createChild(am4charts.CircleBullet);
		bullet.circle.radius = 5;
		bullet.fillOpacity = 1;
		bullet.fill = chart.colors.getIndex(0);
		bullet.isMeasured = false;

		series.events.on("validated", function () {
			bullet.moveTo(series.dataItems.last.point);
			bullet.validatePosition();
		}); // end am4core.ready()
	});
}

//live chart끝

/* ********** 실외 ********** */

$(document).ready(function () {
	$("#sido_code").change(function () {
		ajaxArea($("#sido_code option:selected").val());
	});//sido_code

	$("#sigoon_code").change(function () {
		var sigoon = $("#sigoon_code option:selected").val();
		var matter = $("#matter option:selected").val();
		ajaxChart(sigoon, matter);
		ajaxTable(sigoon);
		$("#areaName").val(sigoon);
	});//sigoon_code

	$("#matter").change(function () {
		var sigoon = $("#sigoon_code option:selected").val();
		var matter = $("#matter option:selected").val();
		$('.ajax-data').empty();
		ajaxChart(sigoon, matter);
	});//matter
});//document

//지역 변경 함수
function ajaxArea(area) {
	$.ajax({
		type: "GET",
		url: ip + "/m.outAreaList?area=" + area,
		dataType: "json",
		async: false,
		success: function (data) {
			console.log(data.result);
			var result = "";
			for (var i = 0; i < data.result.length; i++) {
				result += "<option value='" + data.result[i] + "'>" + data.result[i] + "</option>";
			}
			$("#sigoon_code").empty();
			$("#sigoon_code").append(result);
		}
	});//ajax
}

//차트 변경 함수
function ajaxChart(area, matter) {
	$.ajax({
		type: "GET",
		url: ip + "/m.outsideChart?area=" + area + "&matter=" + matter,
		dataType: "json",
		async: false,
		success: function (data) {
			console.log(data);
			$('.ajax-data').empty();
			am4core.ready(function () {

				// Themes begin
				am4core.useTheme(am4themes_animated);
				// Themes end

				// Create chart instance
				var chart = am4core.create("outchartdiv", am4charts.XYChart);

				// Add data
				chart.data = data.result;

				// Set input format for the dates
				chart.dateFormatter.inputDateFormat = "yyyy-MM-dd HH:mm";

				// Create axes
				var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
				var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
				valueAxis.tooltip.disabled = true;

				dateAxis.baseInterval = {
					"timeUnit": "second",
					"count": 1
				};
				dateAxis.tooltipDateFormat = "yyyy-MM-dd HH:mm";
				dateAxis.dateFormats.setKey("second", "HH:mm:ss");

				// Create series
				var series = chart.series.push(new am4charts.LineSeries());
				series.dataFields.valueY = "data";
				series.dataFields.dateX = "dataTime";
				series.tooltipText = "{data}"
				series.strokeWidth = 2;
				series.minBulletDistance = 15;

				// Drop-shaped tooltips
				series.tooltip.background.cornerRadius = 20;
				series.tooltip.background.strokeOpacity = 0;
				series.tooltip.pointerOrientation = "vertical";
				series.tooltip.label.minWidth = 40;
				series.tooltip.label.minHeight = 40;
				series.tooltip.label.textAlign = "middle";
				series.tooltip.label.textValign = "middle";

				// Make bullets grow on hover
				var bullet = series.bullets.push(new am4charts.CircleBullet());
				bullet.circle.strokeWidth = 2;
				bullet.circle.radius = 4;
				bullet.circle.fill = am4core.color("#fff");

				var bullethover = bullet.states.create("hover");
				bullethover.properties.scale = 1.3;

				// Make a panning cursor
				chart.cursor = new am4charts.XYCursor();
				chart.cursor.behavior = "none";
				chart.cursor.xAxis = dateAxis;
				chart.cursor.snapToSeries = series;
			}); // 차트 끝
			var measureTable = $('.measure_table');
			var matter = $("#matter option:selected").text();
			var currentDate = new Date();
			var year = currentDate.getFullYear().toString();
			var table = "";
			for (i = 0; i < data.result.length; i++) {
				var resultNum = data.result.length - i - 1;
				var forecastColor = "";
				var condition = 0;
				switch (data.result[i].grade) {
					case 0:
						forecastColor = "#c8c8c8"; // 데이터없음
						condition = "없음";
						break;

					case 1:
						forecastColor = "#B5B2FF";
						condition = "최고";
						break;

					case 2:
						forecastColor = "#B2CCFF";
						condition = "좋음";
						break;

					case 3:
						forecastColor = "#B2EBF4";
						condition = "양호";
						break;

					case 4:
						forecastColor = "#CEF279";
						condition = "보통";
						break;

					case 5:
						forecastColor = "#FAED7D";
						condition = "나쁨";
						break;

					case 6:
						forecastColor = "#FFC19E";
						condition = "상당히 나쁨";
						break;

					case 7:
						forecastColor = "#FFA7A7";
						condition = "매우 나쁨";
						break;

					case 7:
						forecastColor = "#BDBDBD";
						condition = "최악";
						break;
				}
				table += '<div class="measure_box">' +
					'<div class="measure_grade">' +
					'<svg height="100" width="100">' +
					'<circle cx="0" cy="15" r="10" stroke="#000" stroke-width="1" fill="' + forecastColor + '" />' +
					'</svg>' +
					'</div>' +
					'<div class="box-content measure_time">' + (data.result[i].dataTime).replace(year + '-', '') + '</div>' +
					'<div class="box-content measure_val">' + data.result[i].data + '</div>' +
					'<div class="box-content measure_condition">' + condition + '</div>' +
					'</div>';
				$('.ajax-data').prepend(table);
				table = "";
			}
		}
	});
}







