(function(){
	$("#dayMatterData").hide();
	var date = new Date();
	var date1 = date.setDate(date.getDate());
	var date2 = new Date(date1).toISOString().slice(0,10);
	var date3 = date;
	date3.setDate(date3.getDate()-30);
	var date4 = new Date(date3).toISOString().slice(0,10);
	
	$('#dayMatterData').val(date2);
	$('#dayMatterData').prop('max', date2);
	$('#dayMatterData').prop('min', date4);
	
	var member_id=$("#member_id").val();
	var query={
			member_id:member_id
	};                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
	
	$.ajax({
		async:true,
		type:"POST",
		url:"/mReservation",
		data:query,
		dataType:"json",
		success:function(data){
			if(data.result == "yes"){
				var iotList="";
				var matterList="";
				for(var i=0; i<data.iotInfo.length; i++){
					iotList += "<option value='"+data.iotInfo[i].ID+"'>"+data.iotInfo[i].ID+"</option>";
				}
				$("#iotSelect").append(iotList);
				for(var j=0; j<data.iotInfo[0].matterList.length; j++){
					matterList += "<option value='"+data.iotInfo[0].matterList[j].MATTER_CODE+"'>"+data.iotInfo[0].matterList[j].MATTER_NAME+"</option>";
				}
				$("#matterSelect").append(matterList);
				$("#iotSelect").val("나의 공기측정1").prop("selected", true);
				$("#matterSelect").val("PM10").prop("selected", true);
			}
			
			
			am4core.ready(function() {
			// Themes begin
			am4core.useTheme(am4themes_animated);
			// Themes end

			// Create chart instance
			var chart = am4core.create("chartdiv", am4charts.XYChart);

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
			var series = chart.series.push(new am4charts.LineSeries());
			series.dataFields.valueY = "MEASURE_VALUE";
			series.dataFields.dateX = "MEASURE_TIME";
			series.tensionX = 0.8;
			series.strokeWidth = 3;

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
			
			$("#measure_value_avg").append(data.measure_value_avg);
			$("#badNum").append(data.badNum);
			$("#measure_value").append(data.measure_value);
		}
	});
	
	var member_id=$("#member_id").val();
	setInterval(function(){
		var iOption=$("#iotSelect option:selected").val();
		var mOption=$("#matterSelect option:selected").val();
		var option=$("#graphSelect option:selected").val();
		
		var query={
				member_id:member_id,
				iOption:iOption,
				mOption:mOption,
				option:option
		};
		
		$.ajax({
			type:"post",
			data:query,
			url:"/realTimeReservation",
			dataType:"json",
			success:function(data){
				$(".font").text('');
				$("#measure_value_avg").append(data.measure_value_avg);
				$("#badNum").append(data.badNum);
				$("#measure_value").append(data.measure_value);
			}
		});
	},6000);
}());

$(document).on('change','.select',function(){
	var iOption=$("#iotSelect option:selected").val();
	var mOption=$("#matterSelect option:selected").val();
	var option=$("#graphSelect option:selected").val();
	var member_id=$("#member_id").val();
	var day=$("#dayMatterData").val();
	
	var query={
			member_id:member_id,
			iOption:iOption,
			mOption:mOption,
			option:option,
			day:day
	};
	switch(mOption){
	case "PM10":
		$(".matter").text("미세먼지");
		$(".measure").text("µg/m³");
		break;
	case "CO2":
		$(".matter").text("이산화탄소");
		$(".measure").text("ppm");
		break;
	}
	
	
	
	$.ajax({
		type:"post",
		data:query,
		url:"/selectGraph",
		dataType:"json",
		success:function(data){
			if(option=="time"){
				html='<div id="timeGraph"></div>';
				$("#graph div").remove();
				$("#graph").append(html);
				timeGraph(data,mOption);
			} else {
				html='<div id="chartdiv"></div>';
				$("#graph div").remove();
				$("#graph").append(html);
				dayGraph(data,mOption);
			}
			
			$(".font").text('');
			$("#measure_value_avg").append(data.measure_value_avg);
			$("#badNum").append(data.badNum);
			$("#measure_value").append(data.measure_value);
		}
	})
});


function dayGraph(data,mOption){
	am4core.ready(function() {
		// Themes begin
		am4core.useTheme(am4themes_animated);
		// Themes end

		// Create chart instance
		var chart = am4core.create("chartdiv", am4charts.XYChart);

		// Add data
		chart.data = data.dayGraph;

		// Create axes
		var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
		dateAxis.renderer.grid.template.location = 0;
		dateAxis.renderer.minGridDistance = 50;

		var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
		valueAxis.logarithmic = false;
		valueAxis.renderer.minGridDistance = 20;

		// Create series
		var series = chart.series.push(new am4charts.LineSeries());
		series.dataFields.valueY = "MEASURE_VALUE";
		series.dataFields.dateX = "MEASURE_TIME";
		series.tensionX = 0.8;
		series.strokeWidth = 3;

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

function timeGraph(data,mOption){
	am4core.ready(function() {
		// Themes begin
		am4core.useTheme(am4themes_animated);
		// Themes end

		/**
		 * Chart design taken from Samsung health app
		 */

		var chart = am4core.create("timeGraph", am4charts.XYChart);
		chart.hiddenState.properties.opacity = 0; // this creates initial fade-in
		
		chart.data = data.timeGraph;

		chart.dateFormatter.inputDateFormat = "HH:NN";
		chart.zoomOutButton.disabled = true;

		var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
		dateAxis.renderer.grid.template.strokeOpacity = 0;
		dateAxis.renderer.minGridDistance = 10;
		dateAxis.dateFormats.setKey("hour", "HH시");
		dateAxis.tooltip.hiddenState.properties.opacity = 1;
		dateAxis.tooltip.hiddenState.properties.visible = true;


		dateAxis.tooltip.adapter.add("x", function (x, target) {
		    return am4core.utils.spritePointToSvg({ x: chart.plotContainer.pixelX, y: 0 }, chart.plotContainer).x + chart.plotContainer.pixelWidth / 2;
		})

		var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
		valueAxis.renderer.inside = true;
		valueAxis.renderer.labels.template.fillOpacity = 0.3;
		valueAxis.renderer.grid.template.strokeOpacity = 0;
		valueAxis.min = 0;
		valueAxis.cursorTooltipEnabled = false;

		// 미세먼지 수치
		if(mOption=='PM10'){
			var axisRange = valueAxis.axisRanges.create();
			axisRange.value = 51;
			axisRange.grid.strokeOpacity = 0.1;
			axisRange.label.text = "나쁨";
			axisRange.label.align = "right";
			axisRange.label.verticalCenter = "bottom";
			axisRange.label.fillOpacity = 0.8;

			valueAxis.renderer.gridContainer.zIndex = 1;

			var axisRange2 = valueAxis.axisRanges.create();
			axisRange2.value = 101;
			axisRange2.grid.strokeOpacity = 0.1;
			axisRange2.label.text = "매우 나쁨";
			axisRange2.label.align = "right";
			axisRange2.label.verticalCenter = "bottom";
			axisRange2.label.fillOpacity = 0.8;
		} else { //이산화탄소 수치
			var axisRange = valueAxis.axisRanges.create();
			axisRange.value = 1000;
			axisRange.grid.strokeOpacity = 0.1;
			axisRange.label.text = "일반적인 경우의 허용 농도";
			axisRange.label.align = "right";
			axisRange.label.verticalCenter = "bottom";
			axisRange.label.fillOpacity = 0.8;

			valueAxis.renderer.gridContainer.zIndex = 1;

			var axisRange2 = valueAxis.axisRanges.create();
			axisRange2.value = 2000;
			axisRange2.grid.strokeOpacity = 0.1;
			axisRange2.label.text = "경미한 두통 유발";
			axisRange2.label.align = "right";
			axisRange2.label.verticalCenter = "bottom";
			axisRange2.label.fillOpacity = 0.8;
		}
		
		var series = chart.series.push(new am4charts.ColumnSeries);
		series.dataFields.valueY = "MEASURE_VALUE";
		series.dataFields.dateX = "MEASURE_TIME";
		series.tooltipText = "{valueY.value}";
		series.tooltip.pointerOrientation = "vertical";
		series.tooltip.hiddenState.properties.opacity = 1;
		series.tooltip.hiddenState.properties.visible = true;
		series.tooltip.adapter.add("x", function (x, target) {
		    return am4core.utils.spritePointToSvg({ x: chart.plotContainer.pixelX, y: 0 }, chart.plotContainer).x + chart.plotContainer.pixelWidth / 2;
		})

		var columnTemplate = series.columns.template;
		columnTemplate.width = 30;
		columnTemplate.column.cornerRadiusTopLeft = 20;
		columnTemplate.column.cornerRadiusTopRight = 20;
		columnTemplate.strokeOpacity = 0;

		columnTemplate.adapter.add("fill", function (fill, target) {
		    var dataItem = target.dataItem;
		    if(mOption=='PM10'){
		    	if (dataItem.valueY > 51) { //나쁨 기준
		    		return am4core.color("#F15F5F");
		    		//return chart.colors.getIndex(0);
		    	} else {
		    		return chart.colors.getIndex(0);
		    		//return am4core.color("#a8b3b7");
		    	}
		    } else {
		    	if (dataItem.valueY > 1000) { //나쁨 기준
			    	return am4core.color("#F15F5F");
			    	//return chart.colors.getIndex(0);
			    }
			    else {
			    	return chart.colors.getIndex(0);
			        //return am4core.color("#a8b3b7");
			    }
		    }
		})

		var cursor = new am4charts.XYCursor();
		cursor.behavior = "panX";
		chart.cursor = cursor;
		cursor.lineX.disabled = true;

		chart.events.on("datavalidated", function () {
			dateAxis.zoomToIndexes(1,14,false,true);
		});

		var middleLine = chart.plotContainer.createChild(am4core.Line);
		middleLine.strokeOpacity = 1;
		middleLine.stroke = am4core.color("#000000");
		middleLine.strokeDasharray = "2,2";
		middleLine.align = "center";
		middleLine.zIndex = 1;
		middleLine.adapter.add("y2", function (y2, target) {
		    return target.parent.pixelHeight;
		})

		cursor.events.on("cursorpositionchanged", updateTooltip);
		dateAxis.events.on("datarangechanged", updateTooltip);

		function updateTooltip() {
		    dateAxis.showTooltipAtPosition(0.5);
		    series.showTooltipAtPosition(0.5, 0);
		    series.tooltip.validate(); // otherwise will show other columns values for a second
		}


		}); // end am4core.ready()
}

$(document).on('change','#graphSelect',function(){
	var option=$("#graphSelect option:selected").val();
	
	if(option=="day"){
		$("#dayMatterData").hide();
	}else{
		$("#dayMatterData").show();
	}
});
