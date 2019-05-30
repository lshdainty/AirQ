measure("PM10");
measureDetail("seoul","PM10");

$("#currentArea").text("seoul");
$(".mattername").text("미세먼지");
$(".areaname").text("서울");

$(document).on("click",".matter",function(){
	$(".mattername").text($(this).text());
	var area = $("#currentArea").text();
	var matter = $(this).attr("value");
	measure(matter);
	measureDetail(area,matter);
});

$(document).on("click",".city-forecast",function(){
	$("#currentArea").text($(this).attr("id"));
	$(".areaname").text($(this).find(".kname").text());
	var area = $("#currentArea").text();
	var matter = $(this).find(".matter_code").text();
	measureDetail(area,matter);
});

function measure(matter){
	$.ajax({
		type: "get",
		url: "/homematterdata?matter="+matter,
		dataType:"json",
		async: false,
		success: function(data) {
			console.log(data);
			var unit = "";
			var result = "";
			switch (data.itemCode) {
				case '10007': unit="µg/m³ | <span class='matter_code'>PM10</span>";break;
				case '10008': unit="µg/m³ | <span class='matter_code'>PM2.5</span>";break;
				case '10006': unit="ppm | <span class='matter_code'>NO2</span>";break;
				case '10003': unit="ppm | <span class='matter_code'>O3</span>";break;
				case '10002': unit="ppm | <span class='matter_code'>CO</span>";break;
				case '10001': unit="ppm | <span class='matter_code'>SO2</span>";break;
			}
			$(".measure-container").empty();
			for(var i=0; i<data.result.length; i++){
				result += '<div class="city-forecast" id="'+data.result[i].ename+'">' +
							'<div class="ng-star-inserted">' +
								'<a class="city-forecast-link">' +
									'<div class="city-forecast-header">' +
										'<div style="flex: 1 1 0%; box-sizing: border-box;">' +
											'<span class="kname">'+data.result[i].kname+'</span>' +
										'</div>' +
									'</div>' +
									'<div class="city-forecast-body aqi-bg-light-yellow aqi-yellow" style="place-content: stretch space-between; align-items: stretch; flex-direction: row; box-sizing: border-box; display: flex; flex: 1 1 auto;">' +
										'<div style="place-content: stretch space-between; align-items: stretch; flex-direction: row; box-sizing: border-box; display: flex; flex: 1 1 0%;">' +
											'<div class="aqi-container">' +
												'<span class="aqi">'+data.result[i].data+'</span><span class="pollutant" fxlayoutalign="center center">'+unit+'</span>' +
											'</div>' +
											'<div style="flex-direction: column; box-sizing: border-box; display: flex; place-content: stretch space-between; align-items: stretch; flex: 1 1 124px; max-width: 124px; min-width: 124px; margin: auto">' +
												'<span class="status"></span>' +
											'</div>' +
										'</div>' +
									'</div>' +
								'</a>' +
							'</div>' +
						'</div>';
				$(".measure-container").append(result);
				if (data.result[i].data >= data.dataGubun[0]) {
					$(".status").text("최악");
				}else if(data.result[i].data >= data.dataGubun[1]){
					$(".status").text("매우 나쁨");
				}else if(data.result[i].data >= data.dataGubun[2]){
					$(".status").text("상당히 나쁨");
				}else if(data.result[i].data >= data.dataGubun[3]){
					$(".status").text("나쁨");
				}else if(data.result[i].data >= data.dataGubun[4]){
					$(".status").text("보통");
				}else if(data.result[i].data >= data.dataGubun[5]){
					$(".status").text("양호");
				}else if(data.result[i].data >= data.dataGubun[6]){
					$(".status").text("좋음");
				}else {
					$(".status").text("최고");
				}
				result = "";
			}	
		}
	});
};

function measureDetail(area,matter){
	$.ajax({
		type: "get",
		url: "/homematterdatadetail?area="+area+"&matter="+matter,
		dataType:"json",
		async: false,
		success: function(data) {
			console.log(data);
			am4core.ready(function() {
				// Themes begin
				am4core.useTheme(am4themes_animated);
				// Themes end

				// Create chart instance
				var chart = am4core.create("chartdiv", am4charts.XYChart);

				// Add data
				chart.data = data.result;

				// Create axes
				var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
				categoryAxis.dataFields.category = "time";
				categoryAxis.renderer.grid.template.location = 0;
				categoryAxis.renderer.minGridDistance = 30;

				categoryAxis.renderer.labels.template.adapter.add("dy", function(dy, target) {
				  if (target.dataItem && target.dataItem.index & 2 == 2) {
				    return dy + 25;
				  }
				  return dy;
				});

				var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

				// Create series
				var series = chart.series.push(new am4charts.ColumnSeries());
				series.dataFields.valueY = "data";
				series.dataFields.categoryX = "time";
				series.name = "data";
				series.columns.template.tooltipText = data.matter_code+" : [bold]{valueY}[/]" + data.unit;
				series.columns.template.fillOpacity = 1;	//투명도
				series.columns.template.fill = am4core.color("#0000FF");	//기본 색상
				series.columns.template.adapter.add("fill", function(fill, target) {
					if (target.dataItem.valueY >= data.dataGubun[0]) {
						return am4core.color("#000000");
					}else if(target.dataItem.valueY >= data.dataGubun[1]){
						return am4core.color("#FF0000");
					}else if(target.dataItem.valueY >= data.dataGubun[2]){
						return am4core.color("#FF4000");
					}else if(target.dataItem.valueY >= data.dataGubun[3]){
						return am4core.color("#FFBF00");
					}else if(target.dataItem.valueY >= data.dataGubun[4]){
						return am4core.color("#00FF00");
					}else if(target.dataItem.valueY >= data.dataGubun[5]){
						return am4core.color("#00FFFF");
					}else if(target.dataItem.valueY >= data.dataGubun[6]){
						return am4core.color("#00BFFF");
					}else {
						return fill;
					}
				});

				var columnTemplate = series.columns.template;
				columnTemplate.strokeWidth = 0;
				columnTemplate.strokeOpacity = 1;

			}); // end am4core.ready()
		}
	});
};