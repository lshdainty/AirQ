hourChart();
dayChart();
monthChart();

$.ajax({
	type : "GET",
	url : "inOldData",
	dataType : "json",
	success : function(data){
		inOldData(data);
	}
});

function hourChart() {
	am4core.ready(function() {

		// Themes begin
		am4core.useTheme(am4themes_animated);
		// Themes end

		// Create chart instance
		var chart = am4core.create("hourChart", am4charts.XYChart);

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

function dayChart() {
	am4core.ready(function() {

		// Themes begin
		am4core.useTheme(am4themes_animated);
		// Themes end

		// Create chart instance
		var chart = am4core.create("dayChart", am4charts.XYChart);

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
			return '#fff';
		});

		// Cursor
		chart.cursor = new am4charts.XYCursor();

	}); // end am4core.ready()
};

function monthChart() {
	am4core.ready(function() {

		// Themes begin
		am4core.useTheme(am4themes_animated);
		// Themes end

		// Create chart instance
		var chart = am4core.create("monthChart", am4charts.XYChart);

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
			"visits" : 984
		}, {
			"country" : "9",
			"visits" : 984
		}, {
			"country" : "10",
			"visits" : 984
		}, {
			"country" : "11",
			"visits" : 984
		}, {
			"country" : "12",
			"visits" : 984
		}, {
			"country" : "13",
			"visits" : 984
		}, {
			"country" : "14",
			"visits" : 984
		}, {
			"country" : "15",
			"visits" : 984
		}, {
			"country" : "16",
			"visits" : 984
		}, {
			"country" : "17",
			"visits" : 984
		}, {
			"country" : "18",
			"visits" : 984
		}, {
			"country" : "19",
			"visits" : 984
		}, {
			"country" : "20",
			"visits" : 984
		}, {
			"country" : "21",
			"visits" : 984
		}, {
			"country" : "22",
			"visits" : 984
		}, {
			"country" : "23",
			"visits" : 984
		}, {
			"country" : "24",
			"visits" : 984
		}, ];

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
			return '#34862E';
		});

		// Cursor
		chart.cursor = new am4charts.XYCursor();

	}); // end am4core.ready()
};

function inOldData(OldData) {
	am4core.ready(function() {

		// Themes begin
		am4core.useTheme(am4themes_spiritedaway);
		// Themes end

		var chart = am4core.create("chartdiv", am4charts.XYChart);
		chart.hiddenState.properties.opacity = 0;

		chart.padding(0, 0, 0, 0);

		chart.zoomOutButton.disabled = true;

		var data = [];
		var value;
		var i = 0;

		for (i = 0; i < OldData.length; i++) {
			value = OldData[i].VALUE;
			data.push({
				TIME : new Date(OldData[i].TIME),
				VALUE : value
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

		chart.events.on("datavalidated", function() {
			dateAxis.zoom({
				start : 1 / 15,
				end : 1.2
			}, false, true);
		});

		dateAxis.interpolationDuration = 500;
		dateAxis.rangeChangeDuration = 500;

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
			interval = setInterval(function() {
				$.ajax({
					type : "GET",
					url : "inNowData",
					dataType : "json",
					success : function(data) {
						chart.addData({
							TIME : new Date(data[0].TIME),
							VALUE : data[0].VALUE
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
		dateAxis.renderer.labels.template.adapter.add("fillOpacity", function(
				fillOpacity, target) {
			var dataItem = target.dataItem;
			return dataItem.position;
		})

		// need to set this, otherwise fillOpacity is not changed and not set
		dateAxis.events.on("validated", function() {
			am4core.iter.each(dateAxis.renderer.labels.iterator(), function(
					label) {
				label.fillOpacity = label.fillOpacity;
			})
		})

		// this makes date axis labels which are at equal minutes to be rotated
		dateAxis.renderer.labels.template.adapter.add("rotation", function(
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

		series.events.on("validated", function() {
			bullet.moveTo(series.dataItems.last.point);
			bullet.validatePosition();
		}); // end am4core.ready()
	});
}