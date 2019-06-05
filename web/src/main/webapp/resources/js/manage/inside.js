$.ajax({
	url : "/insideChart",
	type : "POST",
	dataType : "json",
	async : false,
	success : function(data){
		am4core.ready(function() {

			// Themes begin
			am4core.useTheme(am4themes_spiritedaway);
			// Themes end

			// Create chart instance
			var chart = am4core.create("chartdiv", am4charts.XYChart);

			// Add data
			chart.data = data;
			console.log(chart.data);

			// Set input format for the dates
			chart.dateFormatter.inputDateFormat = "yyyy MMMM dd hh:mm a";

			// Create axes
			var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
			var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
			valueAxis.tooltip.disabled = true;
			valueAxis.title.text = "미세먼지 측정 값(㎍/㎥)";

			dateAxis.baseInterval = {
				"timeUnit" : "minute",
				"count" : 1
			};
			dateAxis.tooltipDateFormat = "yyyy MMMM dd hh:mm a";

			
			// Create series
			var series = chart.series.push(new am4charts.LineSeries());
			series.dataFields.valueY = "measure";
			series.dataFields.dateX = "measuretime";
			series.tooltipText = "{measuretime}"
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

			// Create vertical scrollbar and place it before the value axis
			chart.scrollbarY = new am4core.Scrollbar();
			chart.scrollbarY.parent = chart.leftAxesContainer;
			chart.scrollbarY.toBack();

			// Create a horizontal scrollbar with previe and place it underneath the
			// date axis
			chart.scrollbarX = new am4charts.XYChartScrollbar();
			chart.scrollbarX.series.push(series);
			chart.scrollbarX.parent = chart.bottomAxesContainer;

			chart.events.on("ready", function() {
				// dateAxis.zoom({start:0.79, end:1});
			}); // end am4core.ready()
		}); // 차트 끝
		
	}, // SUCCESS
	error : function(){
		console.log("연결 실패");
	}
});
