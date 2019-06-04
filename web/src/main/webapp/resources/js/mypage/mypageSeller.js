am4core.ready(function() {

// Themes begin
am4core.useTheme(am4themes_animated);
// Themes end

// Create chart instance
var chart = am4core.create("chartdiv", am4charts.XYChart);

// Add data
chart.data = [{
  "year": "1930",
  "입/투찰 서비스": 0,
  "상품 서비스": 5,
  "total": 8
}, {
  "year": "1934",
  "입/투찰 서비스": 0,
  "상품 서비스": 2,
  "total": 10
}, {
  "year": "1938",
  "입/투찰 서비스": 0,
  "상품 서비스": 3,
  "total": 15
}, {
  "year": "1950",
  "입/투찰 서비스": 3,
  "상품 서비스": 4,
  "total": 9
}, {
  "year": "1954",
  "입/투찰 서비스": 5,
  "상품 서비스": 1,
  "total": 10
}, {
  "year": "1958",
  "입/투찰 서비스": 3,
  "상품 서비스": 2,
  "total": 15
}, {
  "year": "1962",
  "입/투찰 서비스": 1,
  "상품 서비스": 2,
  "total": 13
}, {
  "year": "1966",
  "입/투찰 서비스": 2,
  "상품 서비스": 1,
  "total": 8
}, {
  "year": "1970",
  "입/투찰 서비스": 3,
  "상품 서비스": 5,
  "total": 7
}, {
  "year": "1974",
  "입/투찰 서비스": 4,
  "상품 서비스": 3,
  "total": 9
}, {
  "year": "1978",
  "입/투찰 서비스": 1,
  "상품 서비스": 2,
  "total": 11
},{
	  "year": "1978",
	  "입/투찰 서비스": 1,
	  "상품 서비스": 2,
	  "total": 11
	},{
		  "year": "1978",
		  "입/투찰 서비스": 1,
		  "상품 서비스": 2,
		  "total": 11
		},{
			  "year": "1978",
			  "입/투찰 서비스": 1,
			  "상품 서비스": 2,
			  "total": 11
			},{
				  "year": "1978",
				  "입/투찰 서비스": 1,
				  "상품 서비스": 2,
				  "total": 11
				},{
					  "year": "1978",
					  "입/투찰 서비스": 1,
					  "상품 서비스": 2,
					  "total": 11
					},{
						  "year": "1978",
						  "입/투찰 서비스": 1,
						  "상품 서비스": 2,
						  "total": 11
						},{
							  "year": "1978",
							  "입/투찰 서비스": 1,
							  "상품 서비스": 2,
							  "total": 11
							},{
								  "year": "1978",
								  "입/투찰 서비스": 1,
								  "상품 서비스": 2,
								  "total": 11
								}];

// Create category axis
var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
categoryAxis.dataFields.category = "year";
categoryAxis.renderer.opposite = false;

// Create value axis
var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
valueAxis.renderer.inversed = false;
valueAxis.title.text = "Place taken";
valueAxis.renderer.minLabelPosition = 0.01;

// Create series
var series1 = chart.series.push(new am4charts.LineSeries());
series1.dataFields.valueY = "입/투찰 서비스";
series1.dataFields.categoryX = "year";
series1.name = "입/투찰 서비스";
series1.strokeWidth = 3;
series1.bullets.push(new am4charts.CircleBullet());
series1.tooltipText = "Place taken by {name} in {categoryX}: {valueY}";
series1.legendSettings.valueText = "{valueY}";
series1.visible  = false;

var series2 = chart.series.push(new am4charts.LineSeries());
series2.dataFields.valueY = "상품 서비스";
series2.dataFields.categoryX = "year";
series2.name = '상품 서비스';
series2.strokeWidth = 3;
series2.bullets.push(new am4charts.CircleBullet());
series2.tooltipText = "Place taken by {name} in {categoryX}: {valueY}";
series2.legendSettings.valueText = "{valueY}";

var series3 = chart.series.push(new am4charts.LineSeries());
series3.dataFields.valueY = "total";
series3.dataFields.categoryX = "year";
series3.name = 'total';
series3.strokeWidth = 3;
series3.bullets.push(new am4charts.CircleBullet());
series3.tooltipText = "Place taken by {name} in {categoryX}: {valueY}";
series3.legendSettings.valueText = "{valueY}";

// Add chart cursor
chart.cursor = new am4charts.XYCursor();
chart.cursor.behavior = "none";

// Add legend
chart.legend = new am4charts.Legend();

});