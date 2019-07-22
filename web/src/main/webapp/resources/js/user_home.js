measureDetail("seoul", "PM10");
getIotList();

//iot 기기를 선택했을때 실행
$(document).on("change","#iot_id",function(){
	var id = $("#iot_id option:selected").val();
	$.ajax({
		type : "GET",
		url : "changeMatter",
		data : {id:id},
		dataType : "json",
		success : function(data){
			$("#matter_list").empty();
			var matterList="";
			for(var i=0; i<data.iotMatterList.length; i++){
				matterList += "<option value='"+data.iotMatterList[i].MATTER_CODE+"'>"+data.iotMatterList[i].MATTER_NAME+"</option>";
			}
			$("#matter_list").append(matterList);
			$("#matter_list").val("PM10").prop("selected", true);
			startChart($("#iot_id option:selected").val(),"PM10");
		}
	});
});

//물질 선택을 했을 때 실행
$(document).on("change","#matter_list",function(){
	var id = $("#iot_id option:selected").val();
	var matter = $("#matter_list option:selected").val();
	
	startChart(id,matter);
});



$(document).on("change", "#matterSelectBox", function() {

	var area = $("#areaSelectBox option:selected").val();
	var matter = $("#matterSelectBox option:selected").val();
	measureDetail(area, matter);
});

$(document).on("change", "#areaSelectBox", function() {

	var area = $("#areaSelectBox option:selected").val();
	var matter = $("#matterSelectBox option:selected").val();
	measureDetail(area, matter);
});

$(document).on("click", ".matter", function() {
	$(".mattername").text($(this).text());
	var area = $("#currentArea").text();
	var matter = $(this).attr("value");
	measure(matter);
	measureDetail(area, matter);
});

$(document).on("click", ".city-forecast", function() {
	$("#currentArea").text($(this).attr("id"));
	$(".areaname").text($(this).find(".kname").text());
	var area = $("#currentArea").text();
	var matter = $(this).find(".matter_code").text();
	measureDetail(area, matter);
});

function measure(matter) {
	$.ajax({
				type : "get",
				url : "/homematterdata?matter=" + matter,
				dataType : "json",
				async : false,
				success : function(data) {
					var unit = "";
					var result = "";
					switch (data.itemCode) {
					case '10007':
						unit = "µg/m³ | <span class='matter_code'>PM10</span>";
						break;
					case '10008':
						unit = "µg/m³ | <span class='matter_code'>PM2.5</span>";
						break;
					case '10006':
						unit = "ppm | <span class='matter_code'>NO2</span>";
						break;
					case '10003':
						unit = "ppm | <span class='matter_code'>O3</span>";
						break;
					case '10002':
						unit = "ppm | <span class='matter_code'>CO</span>";
						break;
					case '10001':
						unit = "ppm | <span class='matter_code'>SO2</span>";
						break;
					}
					$(".measure-container").empty();
					for (var i = 0; i < data.result.length; i++) {
						var forecastColor, forecastStauts;
						if (data.result[i].data >= data.dataGubun[0]) {
							forecastStatus = "최악";
							forecastColor = "#BDBDBD";
						} else if (data.result[i].data >= data.dataGubun[1]) {
							forecastStatus = "매우 나쁨";
							forecastColor = "#FFA7A7";
						} else if (data.result[i].data >= data.dataGubun[2]) {
							forecastStatus = "상당히 나쁨";
							forecastColor = "#FFC19E";
						} else if (data.result[i].data >= data.dataGubun[3]) {
							forecastStatus = "나쁨";
							forecastColor = "#FAED7D";
						} else if (data.result[i].data >= data.dataGubun[4]) {
							forecastStatus = "보통";
							forecastColor = "#CEF279";
						} else if (data.result[i].data >= data.dataGubun[5]) {
							forecastStatus = "양호";
							forecastColor = "#B2EBF4";
						} else if (data.result[i].data >= data.dataGubun[6]) {
							forecastStatus = "좋음";
							forecastColor = "#B2CCFF";
						} else {
							forecastStatus = "최고";
							forecastColor = "#B5B2FF";
						}
						result += '<div class="city-forecast" id="'
								+ data.result[i].ename
								+ '">'
								+ '<div class="ng-star-inserted">'
								+ '<a class="city-forecast-link">'
								+ '<div class="city-forecast-header">'
								+ '<div style="flex: 1 1 0%; box-sizing: border-box;">'
								+ '<span class="kname">'
								+ data.result[i].kname
								+ '</span>'
								+ '</div>'
								+ '</div>'
								+ '<div class="city-forecast-body" style="background:'
								+ forecastColor
								+ '; place-content: stretch space-between; align-items: stretch; flex-direction: row; box-sizing: border-box; display: flex; flex: 1 1 auto;">'
								+ '<div style="place-content: stretch space-between; align-items: stretch; flex-direction: row; box-sizing: border-box; display: flex; flex: 1 1 0%;">'
								+ '<div class="aqi-container">'
								+ '<span class="aqi">'
								+ data.result[i].data
								+ '</span><span class="pollutant" fxlayoutalign="center center">'
								+ unit
								+ '</span>'
								+ '</div>'
								+ '<div style="flex-direction: column; box-sizing: border-box; display: flex; place-content: stretch space-between; align-items: stretch; flex: 1 1 124px; max-width: 124px; min-width: 124px; margin: auto">'
								+ '<span class="status">' + forecastStatus
								+ '</span>' + '</div>' + '</div>' + '</div>'
								+ '</a>' + '</div>' + '</div>';
						$(".measure-container").append(result);
						result = "";
					}
				}
			});
};

function outSideChart(chartName, data) {
	am4core.ready(function() {
		// Themes begin
		am4core.useTheme(am4themes_animated);
		// Themes end

		// Create chart instance
		var chart = am4core.create(chartName, am4charts.XYChart);
		// Add data
		chart.data = data.result;

		// Create axes
		var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
		categoryAxis.dataFields.category = "time";
		categoryAxis.renderer.grid.template.location = 0;
		categoryAxis.renderer.minGridDistance = 30;

		categoryAxis.renderer.labels.template.adapter.add("dy", function(dy,
				target) {
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
		series.columns.template.tooltipText = data.matter_code
				+ " : [bold]{valueY}[/]" + data.unit;
		series.columns.template.fillOpacity = 1; // 투명도
		series.columns.template.fill = am4core.color("#B5B2FF"); // 기본 색상
		series.columns.template.adapter.add("fill", function(fill, target) {
			if (target.dataItem.valueY >= data.dataGubun[0]) {
				return am4core.color("#BDBDBD");
			} else if (target.dataItem.valueY >= data.dataGubun[1]) {
				return am4core.color("#FFA7A7");
			} else if (target.dataItem.valueY >= data.dataGubun[2]) {
				return am4core.color("#FFC19E");
			} else if (target.dataItem.valueY >= data.dataGubun[3]) {
				return am4core.color("#FAED7D");
			} else if (target.dataItem.valueY >= data.dataGubun[4]) {
				return am4core.color("#CEF279");
			} else if (target.dataItem.valueY >= data.dataGubun[5]) {
				return am4core.color("#B2EBF4");
			} else if (target.dataItem.valueY >= data.dataGubun[6]) {
				return am4core.color("#B2CCFF");
			} else {
				return fill;
			}
		});

		var columnTemplate = series.columns.template;
		columnTemplate.strokeWidth = 0;
		columnTemplate.strokeOpacity = 1;

	}); // end am4core.ready()
}

function measureDetail(area, matter) {
	$.ajax({
		type : "get",
		url : "/homematterdatadetail?area=" + area + "&matter=" + matter,
		dataType : "json",
		async : false,
		success : function(data) {
			console.log("--------------------------------");
			console.log(data);
			console.log("--------------------------------");
			outSideChart("outsideMatChart", data);
			
			for (var i = 0; i < data.result.length; i++) {
				if (data.result[i].ename == area) {
					var forecastColor, forecastStauts=1, grade,faceGrade,currentData;
					if (data.result[i].data >= data.dataGubun[0]) {
						forecastStatus = "최악";
						forecastColor = "#BDBDBD";
						grade = "6";
						faceGrade="8";
					} else if (data.result[i].data >= data.dataGubun[1]) {
						forecastStatus = "매우 나쁨";
						forecastColor = "#FFA7A7";
						grade = "5";
						faceGrade="7";
					} else if (data.result[i].data >= data.dataGubun[2]) {
						forecastStatus = "상당히 나쁨";
						forecastColor = "#FFC19E";
						grade = "4";
						faceGrade="6";
					} else if (data.result[i].data >= data.dataGubun[3]) {
						forecastStatus = "나쁨";
						forecastColor = "#FAED7D";
						grade = "3";
						faceGrade="5";
					} else if (data.result[i].data >= data.dataGubun[4]) {
						forecastStatus = "보통";
						forecastColor = "#CEF279";
						grade = "2";
						faceGrade="4";
					} else if (data.result[i].data >= data.dataGubun[5]) {
						forecastStatus = "양호";
						forecastColor = "#B2EBF4";
						grade = "2";
						faceGrade="3";
					} else if (data.result[i].data >= data.dataGubun[6]) {
						forecastStatus = "좋음";
						forecastColor = "#B2CCFF";
						grade = "1";
						faceGrade="2";
					} else {
						forecastStatus = "최고";
						forecastColor = "#B5B2FF";
						faceGrade="1";
						grade = "1";
					}
					currentData = data.result[i].data;
				}

				for(var x=1; x<9; x++){
					$(".matFBox").removeClass("grade_"+x);
				}
				$("#outsideBox").find("#face").attr('src',"/resources/images/face_"+grade+".svg");
				$("#outsideBox").find(".matFBox").addClass("grade_"+(faceGrade));
				$("#outsideBox").find('.matGrade').text(forecastStatus);
				$("#outsideBox").find('.matValue').text(currentData);
			}

		}
	});
};




function getIotList(){
	$.ajax({
		type : "GET",
		url : "checkIot",
		dataType : "json",
		success : function(data){
			if(data.result == "yes"){
				var iotList="";
				var matterList="";
				for(var i=0; i<data.iotInfo.length; i++){
					iotList += "<option value='"+data.iotInfo[i].ID+"'>"+data.iotInfo[i].ID+"</option>";
				}
				$("#iot_id").append(iotList);
				for(var j=0; j<data.iotInfo[0].matterList.length; j++){
					matterList += "<option value='"+data.iotInfo[0].matterList[j].MATTER_CODE+"'>"+data.iotInfo[0].matterList[j].MATTER_NAME+"</option>";
				}
				$("#matter_list").append(matterList);
				$("#iot_id").val("나의 공기측정1").prop("selected", true);
				$("#matter_list").val("PM10").prop("selected", true);
				startChart("나의 공기측정1","PM10");
			}else{
				var html="<h1>등록된 기기가 없습니다.</h1>";
				$(".matSBox").empty();
				$(".matSBox").append(html);
			}
		}
	});
}



function startChart(id,matter) {
	$.ajax({
		type : "GET",
		url : "dailyHourData",
		data : {id:id,matter:matter},
		dataType : "json",
		success : function(data){
			$("#matterValue").text(data.matterValue);
			$("#todayAvg").text(data.todayAvg);
			$("#overValue").text(data.overValue);
			var gradeText = "";
			var gradeImage = "";
			switch (data.grade) {
				case 1 :
					gradeText = "최고";
					gradeImage = "1";
					break;
				case 2 :
					gradeText = "좋음";
					gradeImage = "1";
					break;
				case 3 :
					gradeText = "양호";
					gradeImage = "2";
					break;
				case 4 :
					gradeText = "보통";
					gradeImage = "2";
					break;
				case 5 :
					gradeText = "나쁨";
					gradeImage = "3";
					break;
				case 6 :
					gradeText = "상당히 나쁨";
					gradeImage = "4";
					break;
				case 7 :
					gradeText = "매우 나쁨";
					gradeImage = "5";
					break;
				case 8 :
					gradeText = "최악";
					gradeImage = "6";
					break;
			}
			
			for(var x=1; x<9; x++){
				$(".matViewBox").removeClass("grade_"+x);
			}
			
			$("#insideBox").find("#face").attr('src',"/resources/images/face_"+gradeImage+".svg");
			$("#insideBox").find(".matViewBox").addClass("grade_"+(data.grade));
			$("#insideBox").find('.matGrade').text(gradeText);
			$("#insideBox").find('.matValue').text(data.matterValue+data.unit);
			hourChart(data.oldData,data.dataGubun,data.unit);	//하루 - 시간별
		}
	})
};


function hourChart(timeData,dataGubun,unit) {
	console.log(timeData);
	am4core.ready(function() {

		// Themes begin
		am4core.useTheme(am4themes_animated);
		// Themes end

		// Create chart instance
		var chart = am4core.create("insideMatChart", am4charts.XYChart);

		// Add data
		chart.data =  timeData;
		chart.fontSize=10;

		// Create axes
		var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
		categoryAxis.dataFields.category = "TIME";
		categoryAxis.renderer.grid.template.location = 0;
		categoryAxis.renderer.minGridDistance = 30;

		var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

		// Create series
		var series = chart.series.push(new am4charts.ColumnSeries());
		series.dataFields.valueY = "VALUE";
		series.dataFields.categoryX = "TIME";
		series.name = "VALUE";
		series.columns.template.tooltipText = "[bold]{valueY}[/]"+unit;
		series.columns.template.fillOpacity = 1;	//투명도
		series.columns.template.fill = am4core.color("#B5B2FF");	//기본 색상
		series.columns.template.adapter.add("fill", function(fill, target) {
			if (target.dataItem.valueY >= dataGubun[0]) {
				return am4core.color("#BDBDBD");
			}else if(target.dataItem.valueY >= dataGubun[1]){
				return am4core.color("#FFA7A7");
			}else if(target.dataItem.valueY >= dataGubun[2]){
				return am4core.color("#FFC19E");
			}else if(target.dataItem.valueY >= dataGubun[3]){
				return am4core.color("#FAED7D");
			}else if(target.dataItem.valueY >= dataGubun[4]){
				return am4core.color("#CEF279");
			}else if(target.dataItem.valueY >= dataGubun[5]){
				return am4core.color("#B2EBF4");
			}else if(target.dataItem.valueY >= dataGubun[6]){
				return am4core.color("#B2CCFF");
			}else {
				return fill;
			}
		});

		var columnTemplate = series.columns.template;
		columnTemplate.strokeWidth = 0;
		columnTemplate.strokeOpacity = 1;

	}); // end am4core.ready()
};


