//amchart start
am4core.ready(function() {
	// Themes begin
	am4core.useTheme(am4themes_animated);
	// Themes end

	// Create chart instance
	var chart = am4core.create("chartdiv", am4charts.XYChart);
	chart.scrollbarX = new am4core.Scrollbar();
	
	// Create axes
	var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
	categoryAxis.dataFields.category = "country";
	categoryAxis.renderer.grid.template.location = 1;
	categoryAxis.renderer.minGridDistance = 30;
	categoryAxis.renderer.labels.template.horizontalCenter = "middle";
	categoryAxis.renderer.labels.template.verticalCenter = "middle";
	categoryAxis.renderer.labels.template.rotation = 0;
	categoryAxis.tooltip.disabled = true;
	categoryAxis.renderer.minHeight = 110;

	var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
	valueAxis.renderer.minWidth = 50;

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
	
	
	$.ajax({
		url:"mypageSeller",
		type:"POST",
		dataType: "json",
		success:function(data){
//			alert("ajax들어왔다6");
//			console.log(data);
//			alert(data.list[0].sum);
			var sum0 = data.list[0].sum
			var sum1 = data.list[1].sum
			var sum2 = data.list[2].sum
			var sum3 = data.list[3].sum
			var sum4 = data.list[4].sum
			var sum5 = data.list[5].sum
			var sum6 = data.list[6].sum
			var sum7 = data.list[7].sum
			var sum8 = data.list[8].sum
			var sum9 = data.list[9].sum
			var sum10 = data.list[10].sum
			var sum11 = data.list[11].sum
			
		// Add data
		chart.data = [ {
			"country" : "1월",
			"visits" : sum0
		}, {
			"country" : "2월",
			"visits" : sum1
		}, {
			"country" : "3월",
			"visits" : sum2
		}, {
			"country" : "4월",
			"visits" : sum3
		}, {
			"country" : "5월",
			"visits" : sum4
		}, {
			"country" : "6월",
			"visits" : sum5
		}, {
			"country" : "7월",
			"visits" : sum6
		}, {
			"country" : "8월",
			"visits" : sum7
		}, {
			"country" : "9월",
			"visits" : sum8
		}, {
			"country" : "10월",
			"visits" : sum9
		}, {
			"country" : "11월",
			"visits" : sum10
		}, {
			"country" : "12월",
			"visits" : sum11
		} ];
		},
		error:function(){
			alert("연결실패");

		}
		});
	


}); // end am4core.ready()
