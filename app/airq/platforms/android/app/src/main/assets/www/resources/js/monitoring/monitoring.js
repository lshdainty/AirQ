var ip = sessionStorage.getItem('IP_ADDRESS');
/* *************************** page init function ******************** */
ajaxChart("신암동","pm10");
ajaxArea("대구");
liveChart();
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


/* ******************** */
/* inside monitoring js */

function liveChart() {
	am4core.ready(function() {

		// Themes begin
		am4core.useTheme(am4themes_animated);
		// Themes end

		// Create chart instance
		var chart = am4core.create("liveChart", am4charts.XYChart);

		// Add data
		chart.data = [ {
			"country" : "1",
			"visits" : 3025
		}, {
			"country" : "2",
			"visits" : 1882
		}, {
			"country" : "3",
			"visits" : 1809
		}, {
			"country" : "4",
			"visits" : 1322
		}, {
			"country" : "5",
			"visits" : 1122
		}, {
			"country" : "6",
			"visits" : 1114
		}, {
			"country" : "7",
			"visits" : 984
		}, {
			"country" : "8",
			"visits" : 711
		}, {
			"country" : "9",
			"visits" : 665
		}, {
			"country" : "10",
			"visits" : 580
		}, {
			"country" : "11",
			"visits" : 443
		}, {
			"country" : "12",
			"visits" : 441
		} ];

		// Create axes
		var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
		categoryAxis.dataFields.category = "country";
		categoryAxis.renderer.grid.template.location = 0;
		categoryAxis.renderer.minGridDistance = 1;
		categoryAxis.renderer.labels.template.horizontalCenter = "middle";
		categoryAxis.renderer.labels.template.verticalCenter = "middle";
		categoryAxis.renderer.labels.template.rotation = 0;
		categoryAxis.tooltip.disabled = true;
		categoryAxis.renderer.minHeight = 0;

		var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
		valueAxis.renderer.minWidth = 0;

		// Create series
		var series = chart.series.push(new am4charts.ColumnSeries());
		series.sequencedInterpolation = true;
		series.dataFields.valueY = "visits";
		series.dataFields.categoryX = "country";
		series.tooltipText = "[{categoryX}: bold]{valueY}[/]";
		series.columns.template.strokeWidth = 0;

		series.tooltip.pointerOrientation = "vertical";

		series.columns.template.column.cornerRadiusTopLeft = 10;
		series.columns.template.column.cornerRadiusTopRight = 10;
		series.columns.template.column.fillOpacity = 0.8;

		// on hover, make corner radiuses bigger
		var hoverState = series.columns.template.column.states.create("hover");
		hoverState.properties.cornerRadiusTopLeft = 0;
		hoverState.properties.cornerRadiusTopRight = 0;
		hoverState.properties.fillOpacity = 1;

		series.columns.template.adapter.add("fill", function(fill, target) {
			return chart.colors.getIndex(target.dataItem.index);
		});

		// Cursor
		chart.cursor = new am4charts.XYCursor();

	}); // end am4core.ready()
};

/* ******************** */


$(document).ready(function(){
	$("#sido_code").change(function(){
		ajaxArea($("#sido_code option:selected").val());
	});//sido_code
	
	$("#sigoon_code").change(function(){
		var sigoon = $("#sigoon_code option:selected").val();
		var matter = $("#matter option:selected").val();
		ajaxChart(sigoon,matter);
		ajaxTable(sigoon);
		$("#areaName").val(sigoon);
	});//sigoon_code
	
	$("#matter").change(function(){
		var sigoon = $("#sigoon_code option:selected").val();
		var matter = $("#matter option:selected").val();
		$('.ajax-data').empty();
		ajaxChart(sigoon,matter);
	});//matter
});//document

//지역 변경 함수
function ajaxArea(area){
	$.ajax({
		type : "GET",
		url : ip+"/m.outAreaList?area="+area,
		dataType : "json",
		async : false,
		success : function(data) {
			console.log(data.result);
			var result="";
			for(var i=0; i<data.result.length; i++){
				result+="<option value='"+data.result[i]+"'>"+data.result[i]+"</option>";
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
			am4core.ready(function() {

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
					"timeUnit" : "second",
					"count" : 1
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
				var forecastColor="";
				var condition=0;
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
				table += '<div class="measure_box">'+
					'<div class="measure_grade">'+
						'<svg height="100" width="100">'+
							'<circle cx="0" cy="15" r="10" stroke="#000" stroke-width="1" fill="'+forecastColor+'" />'+
						'</svg>'+
					'</div>'+
					'<div class="box-content measure_time">'+(data.result[i].dataTime).replace(year+'-','')+'</div>'+
					'<div class="box-content measure_val">'+data.result[i].data+'</div>'+
					'<div class="box-content measure_condition">'+condition+'</div>'+
				'</div>';
				$('.ajax-data').prepend(table);
				table="";
			}
		}
	});
}







