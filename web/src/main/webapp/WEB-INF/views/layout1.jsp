<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>
<link rel="stylesheet" href="/resources/css/include/swiper.css">
<link rel="stylesheet" href="/resources/css/service/main.css">

<style>
.quality_cards {
	display: flex;
}

#content {
	max-width: 100% !important;
}

.matter-box {
	display: flex;
	flex-wrap: wrap;
}

.matter-box ul {
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	text-align: center;
	margin:0;
}

.matter-box ul li {
	cursor: pointer;
	padding: 1rem;
	background: #ddd;
	font-weight: bold;
	border-radius: 1rem;
	border: 1px solid #000;
}

#chartdiv {
	width: 88%;
	height: 500px;
}

.areaBox {
	text-align: center !important;
	font-size: 1.5rem;
	padding-top: 1.5rem !important;
}
  .insideQBox {
    display: flex;
    border: 1px solid;
    margin-top: 5rem;
    flex-direction: column;
    border-radius: 1rem;
    overflow:hidden;
  }
.insideTitle{
	background: #2b7cf7;
	padding: 1rem;
	color: white;
	font-size: 18px;
}
.outsideTitle{
	background: #7345e4;
	padding: 1rem;
	color: white;
	font-size: 18px;
}
.insideContent{
	margin-top: 2rem;
    width: 100%;
    height: 100%;
    display: flex;
    }
  .insideSWrap {
    display: flex;
    flex-direction: column;
    width: 30%;

  }

  .matSBox {
    display: flex;
    padding: .5rem 2rem;
  }

  .matSBox select {
    margin: 0 .5rem;
  }

  .matFBox {
    background: #79daeb;
    border-radius: 1rem;
    padding: .5rem 2rem;
    display: flex;
    height: 100%;
    margin: 1rem;
  }

  .matFBox img {
    width: 80%;
    margin: auto;
  }

  #insideMatChart{
    width:100%;
  }
</style>
<!--  body content start  -->

<section class="hero-home">
	<div
		class="swiper-container hero-slider swiper-container-fade swiper-container-horizontal">
		<div class="swiper-wrapper dark-overlay"
			style="transition-duration: 0ms;">
			<div
				style="background-image: url(&quot;https://d19m59y37dris4.cloudfront.net/directory/1-2/img/photo/photo-1519974719765-e6559eac2575.jpg&quot;); width: 1903px; opacity: 1; transform: translate3d(-1903px, 0px, 0px); transition-duration: 0ms;"
				class="swiper-slide swiper-slide-active"></div>
			<div
				style="background-image: url(&quot;https://d19m59y37dris4.cloudfront.net/directory/1-2/img/photo/photo-1490578474895-699cd4e2cf59.jpg&quot;); width: 1903px; opacity: 0; transform: translate3d(-3806px, 0px, 0px); transition-duration: 0ms;"
				class="swiper-slide swiper-slide-next"></div>
			<div
				style="background-image: url(&quot;https://d19m59y37dris4.cloudfront.net/directory/1-2/img/photo/photo-1534850336045-c6c6d287f89e.jpg&quot;); width: 1903px; opacity: 0; transform: translate3d(-5709px, 0px, 0px); transition-duration: 0ms;"
				class="swiper-slide"></div>
		</div>
		<span class="swiper-notification" aria-live="assertive"
			aria-atomic="true"></span>
	</div>
	<div class="container py-6 py-md-7 text-white z-index-20">
		<div class="row">
			<div class="col-xl-10">
				<div class="text-center text-lg-left">
					<p
						class="subtitle letter-spacing-4 mb-2 text-secondary text-shadow">DEVELOPE-YOUR-AIR-QUALITY</p>
					<h1 class="display-3 font-weight-bold text-shadow">전문가의 맞춤 공기질
						개선</h1>
				</div>
			</div>
		</div>
	</div>
</section>
<div style="width: 100%; margin: auto; max-width: 1000px">


<!-- Material measure Content \ Inside \  -->
<div class="insideQBox">
	<div class="outsideTitle">실외 공기질 측정 현황</div>
	<div class="insideContent">
  <div class="insideSWrap">
    <!-- Material Select Box Start \ Inside \ -->
    <div class="matSBox">

      <select name="" id="">
        <option value="">기기종류</option>
      </select>


      <select name="" id="">
        <option value="">물질종류</option>
      </select>

    </div>
    <!-- Material Select Box End \ Inside \ -->


    <div class="matFBox">
      <img src="/resources/images/face_1.svg">
    </div>
  </div>

  <!-- Chart Start - Material \ Inside \ -->
  <div id="outsideMatChart" style="width:100%;">

  </div>
  <!-- Chart End - Material \ Inside \ -->
  </div>
</div>
<!-- ------------------------------------ -->



<!-- Material measure Content \ Outside \  -->
<div class="insideQBox">
	<div class="insideTitle">실내 공기질 측정 현황</div>
	<div class="insideContent">
  <div class="insideSWrap">
    <!-- Material Select Box Start \ Inside \ -->
    <div class="matSBox">

      <select name="" id="">
        <option value="">기기종류</option>
      </select>


      <select name="" id="">
        <option value="">물질종류</option>
      </select>

    </div>
    <!-- Material Select Box End \ Inside \ -->


    <div class="matFBox">
      <img src="/resources/images/face_1.svg">
    </div>
  </div>

  <!-- Chart Start - Material \ Inside \ -->
  <div id="insideMatChart">

  </div>
  <!-- Chart End - Material \ Inside \ -->
  </div>
</div>
<!-- ------------------------------------ -->
</div>
<span id="currentArea" style="display: none"></span>


<button class="layout1">Layout1</button>
<button class="layout2">Layout2</button>
<button class="layout3">Layout3</button>
<script>
	$(function(){
		$(".layout1").click(function(){
			window.location.href="layout?layoutNum=1";
		});
		
		$(".layout2").click(function(){
			window.location.href="layout?layoutNum=2";
		});
		
		$(".layout3").click(function(){
			window.location.href="layout?layoutNum=3";
		});
	});
</script>



<!--  body content end  -->
<!-- Global site tag (gtag.js) - Google Analytics -->
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/material.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
<script async
	src="https://www.googletagmanager.com/gtag/js?id=UA-140827148-1"></script>
<script src="/resources/js/home.js"></script>


<!-- chart test script -->

<script>
am4core.ready(function () {

    // Themes begin
    am4core.useTheme(am4themes_material);
    am4core.useTheme(am4themes_animated);
    // Themes end

    var chart = am4core.create("insideMatChart", am4charts.XYChart);
    chart.hiddenState.properties.opacity = 0; // this creates initial fade-in

    chart.data = [
      {
        country: "USA",
        visits: 23725
      },
      {
        country: "China",
        visits: 1882
      },
      {
        country: "Japan",
        visits: 1809
      },
      {
        country: "Germany",
        visits: 1322
      },
      {
        country: "UK",
        visits: 1122
      },
      {
        country: "France",
        visits: 1114
      },
      {
        country: "India",
        visits: 984
      },
      {
        country: "Spain",
        visits: 711
      },
      {
        country: "Netherlands",
        visits: 665
      },
      {
        country: "Russia",
        visits: 580
      },
      {
        country: "South Korea",
        visits: 443
      },
      {
        country: "Canada",
        visits: 441
      }
    ];

    var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
    categoryAxis.renderer.grid.template.location = 0;
    categoryAxis.dataFields.category = "country";
    categoryAxis.renderer.minGridDistance = 40;
    categoryAxis.fontSize = 11;

    var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
    valueAxis.min = 0;
    valueAxis.max = 24000;
    valueAxis.strictMinMax = true;
    valueAxis.renderer.minGridDistance = 30;
    // axis break
    var axisBreak = valueAxis.axisBreaks.create();
    axisBreak.startValue = 2100;
    axisBreak.endValue = 22900;
    axisBreak.breakSize = 0.005;

    // make break expand on hover
    var hoverState = axisBreak.states.create("hover");
    hoverState.properties.breakSize = 1;
    hoverState.properties.opacity = 0.1;
    hoverState.transitionDuration = 1500;

    axisBreak.defaultState.transitionDuration = 1000;
    /*
    // this is exactly the same, but with events
    axisBreak.events.on("over", function() {
      axisBreak.animate(
        [{ property: "breakSize", to: 1 }, { property: "opacity", to: 0.1 }],
        1500,
        am4core.ease.sinOut
      );
    });
    axisBreak.events.on("out", function() {
      axisBreak.animate(
        [{ property: "breakSize", to: 0.005 }, { property: "opacity", to: 1 }],
        1000,
        am4core.ease.quadOut
      );
    });*/

    var series = chart.series.push(new am4charts.ColumnSeries());
    series.dataFields.categoryX = "country";
    series.dataFields.valueY = "visits";
    series.columns.template.tooltipText = "{valueY.value}";
    series.columns.template.tooltipY = 0;
    series.columns.template.strokeOpacity = 0;

    // as by default columns of the same series are of the same color, we add adapter which takes colors from chart.colors color set
    series.columns.template.adapter.add("fill", function (fill, target) {
      return chart.colors.getIndex(target.dataItem.index);
    });

  }); // end am4core.ready()
  am4core.ready(function () {

	    // Themes begin
	    am4core.useTheme(am4themes_material);
	    am4core.useTheme(am4themes_animated);
	    // Themes end

	    var chart = am4core.create("outsideMatChart", am4charts.XYChart);
	    chart.hiddenState.properties.opacity = 0; // this creates initial fade-in

	    chart.data = [
	      {
	        country: "USA",
	        visits: 23725
	      },
	      {
	        country: "China",
	        visits: 1882
	      },
	      {
	        country: "Japan",
	        visits: 1809
	      },
	      {
	        country: "Germany",
	        visits: 1322
	      },
	      {
	        country: "UK",
	        visits: 1122
	      },
	      {
	        country: "France",
	        visits: 1114
	      },
	      {
	        country: "India",
	        visits: 984
	      },
	      {
	        country: "Spain",
	        visits: 711
	      },
	      {
	        country: "Netherlands",
	        visits: 665
	      },
	      {
	        country: "Russia",
	        visits: 580
	      },
	      {
	        country: "South Korea",
	        visits: 443
	      },
	      {
	        country: "Canada",
	        visits: 441
	      }
	    ];

	    var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
	    categoryAxis.renderer.grid.template.location = 0;
	    categoryAxis.dataFields.category = "country";
	    categoryAxis.renderer.minGridDistance = 40;
	    categoryAxis.fontSize = 11;

	    var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
	    valueAxis.min = 0;
	    valueAxis.max = 24000;
	    valueAxis.strictMinMax = true;
	    valueAxis.renderer.minGridDistance = 30;
	    // axis break
	    var axisBreak = valueAxis.axisBreaks.create();
	    axisBreak.startValue = 2100;
	    axisBreak.endValue = 22900;
	    axisBreak.breakSize = 0.005;

	    // make break expand on hover
	    var hoverState = axisBreak.states.create("hover");
	    hoverState.properties.breakSize = 1;
	    hoverState.properties.opacity = 0.1;
	    hoverState.transitionDuration = 1500;

	    axisBreak.defaultState.transitionDuration = 1000;
	    /*
	    // this is exactly the same, but with events
	    axisBreak.events.on("over", function() {
	      axisBreak.animate(
	        [{ property: "breakSize", to: 1 }, { property: "opacity", to: 0.1 }],
	        1500,
	        am4core.ease.sinOut
	      );
	    });
	    axisBreak.events.on("out", function() {
	      axisBreak.animate(
	        [{ property: "breakSize", to: 0.005 }, { property: "opacity", to: 1 }],
	        1000,
	        am4core.ease.quadOut
	      );
	    });*/

	    var series = chart.series.push(new am4charts.ColumnSeries());
	    series.dataFields.categoryX = "country";
	    series.dataFields.valueY = "visits";
	    series.columns.template.tooltipText = "{valueY.value}";
	    series.columns.template.tooltipY = 0;
	    series.columns.template.strokeOpacity = 0;

	    // as by default columns of the same series are of the same color, we add adapter which takes colors from chart.colors color set
	    series.columns.template.adapter.add("fill", function (fill, target) {
	      return chart.colors.getIndex(target.dataItem.index);
	    });

	  }); // end am4core.ready()
</script>

<!----------------------->


<script>
	window.dataLayer = window.dataLayer || [];
	function gtag() {
		dataLayer.push(arguments);
	}
	gtag('js', new Date());

	gtag('config', 'UA-140827148-1');
</script>
<%@include file="include/footer.jsp"%>