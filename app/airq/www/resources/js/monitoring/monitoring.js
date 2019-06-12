// var ip = sessionStorage.getItem('IP_ADDRESS');
var ip = "http://39.127.7.69"

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


//페이지 들어왔을때 초기화 하기
ajaxChart("신암동","pm10Value");
ajaxTable("신암동");
ajaxArea("대구");
$("#areaName").val("신암동");
$("#sido_code").val("대구").prop("selected", true);
$("#sigoon_code").val("신암동").prop("selected", true);
$("#matter").val("pm10Value").prop("selected", true);
//페이지 들어왔을때 초기화 하기

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
function ajaxChart(area,matter){
	$.ajax({
		type : "GET",
		url : ip+"/m.outsideChart?area="+area+"&matter="+matter,
		dataType : "json",
		async : false,
		success : function(data) {
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
		}
	});
}

//테이블 변경 함수
function ajaxTable(area){
	$.ajax({
		type : "GET",
		url : "/outsideTable?area="+area,
		dataType : "json",
		async : false,
		success : function(data) {
			var result="";
			$("#tbody").empty();
			for(var i=0; i<data.result.length; i++){
				result = "<tr>"+
							"<th>"+data.result[i].dataTime+"</th>" +
							"<td><img class='point' src='"+"/resources/images/point_"+data.result[i].pm10grade+".png"+"' alt='"+data.result[i].pm10grade+"'></td>" + 
							"<td>"+data.result[i].pm10data+"</td>" + 
							"<td><img class='point' src='"+"/resources/images/point_"+data.result[i].pm25grade+".png"+"' alt='"+data.result[i].pm25grade+"'></td>" + 
							"<td>"+data.result[i].pm25data+"</td>" + 
							"<td><img class='point' src='"+"/resources/images/point_"+data.result[i].o3grade+".png"+"' alt='"+data.result[i].o3grade+"'></td>" + 
							"<td>"+data.result[i].o3data+"</td>" + 
							"<td><img class='point' src='"+"/resources/images/point_"+data.result[i].no2grade+".png"+"' alt='"+data.result[i].no2grade+"'></td>" + 
							"<td>"+data.result[i].no2data+"</td>" + 
							"<td><img class='point' src='"+"/resources/images/point_"+data.result[i].cograde+".png"+"' alt='"+data.result[i].cograde+"'></td>" + 
							"<td>"+data.result[i].codata+"</td>" + 
							"<td><img class='point' src='"+"/resources/images/point_"+data.result[i].so2grade+".png"+"' alt='"+data.result[i].so2grade+"'></td>" + 
							"<td>"+data.result[i].so2data+"</td>" + 
						"</tr>"
				$("#tbody").append(result);
			}
		}
	});
};










(function () {
	var member_id = JSON.parse(sessionStorage.getItem("user")).member_id;
	var query = {
		member_id: member_id
	};
	$.ajax({
		type
	});
	$.ajax({
		async: true,
		type: "POST",
		url: "http://39.127.7.69/m.mReservation",
		data: query,
		dataType: "json",
		success: function (data) {
			console.log(data);

			am4core.ready(function () {


				// Themes begin
				// Themes end



				// Create chart instance
				var chart = am4core.create("outChart", am4charts.XYChart);

				// Add data
				chart.data = data.reservation;

				// Create axes
				var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
				dateAxis.renderer.grid.template.location = 0;
				dateAxis.renderer.minGridDistance = 50;

				var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
				valueAxis.logarithmic = false;
				valueAxis.renderer.minGridDistance = 20;

				// Create series

				var series = chart.series.push(new am4charts.ColumnSeries());
				series.dataFields.valueY = "MEASURE_VALUE";
				series.dataFields.dateX = "MEASURE_TIME";
				series.name = "";
				series.columns.template.tooltipText = "Series: {name}\nCategory: {categoryX}\nValue: {valueY}";
				series.columns.template.fill = am4core.color("#104547");

				
				var series2 = chart.series.push(new am4charts.LineSeries());
				series2.name = "Units";
				series2.stroke = am4core.color("#CDA2AB");
				series2.strokeWidth = 3;
				series2.dataFields.valueY = "MEASURE_VALUE";
				series2.dataFields.dateX = "MEASURE_TIME";

				var bullet = series.bullets.push(new am4charts.CircleBullet());
				bullet.circle.fill = am4core.color("#fff");
				bullet.circle.strokeWidth = 3;

				// Add cursor
				chart.cursor = new am4charts.XYCursor();
				chart.cursor.fullWidthLineX = true;
				chart.cursor.xAxis = dateAxis;
				chart.cursor.lineX.strokeWidth = 0;
				chart.cursor.lineX.fill = am4core.color("#000");
				chart.cursor.lineX.fillOpacity = 0.1;

				// Add scrollbar
				//chart.scrollbarX = new am4core.Scrollbar();
				chart.cursor = new am4charts.XYCursor();
				chart.cursor.behavior = "none";

				// Add a guide
				let range = valueAxis.axisRanges.create();
				range.value = 90.4;
				range.grid.stroke = am4core.color("#396478");
				range.grid.strokeWidth = 1;
				range.grid.strokeOpacity = 1;
				range.grid.strokeDasharray = "3,3";
				range.label.inside = true;
				range.label.text = "Average";
				range.label.fill = range.grid.stroke;
				range.label.verticalCenter = "bottom";// end am4core.ready()
			});
		}
	});
}());


