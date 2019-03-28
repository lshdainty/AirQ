//지도 관련 js 시작
// 지도 테마설정 시작
am4core.useTheme(am4themes_animated);
// 지도 테마설정 끝

/* map instance 생성 */
var chart = am4core.create("chartdiv", am4maps.MapChart);

/* map definition 설정 */
chart.geodata = am4geodata_southKoreaHigh;

/* projection 설정 */
chart.projection = new am4maps.projections.Miller();

/* map polygon series 생성*/
var polygonSeries = chart.series.push(new am4maps.MapPolygonSeries());

/* Make map load polygon (like country names) data from GeoJSON */
polygonSeries.useGeodata = true;

/* Configure series */
var polygonTemplate = polygonSeries.mapPolygons.template;
polygonTemplate.applyOnClones = true;
polygonTemplate.togglable = true;
polygonTemplate.tooltipText = "{name}";
polygonTemplate.nonScalingStroke = true;
polygonTemplate.strokeOpacity = 0.5;
polygonTemplate.fill = chart.colors.getIndex(0);
var lastSelected;
var lastCity;

polygonTemplate.events.on("hit", function(ev) {
  if (lastSelected) {
    // This line serves multiple purposes:
    // 1. Clicking a country twice actually de-activates, the line below
    //    de-activates it in advance, so the toggle then re-activates, making it
    //    appear as if it was never de-activated to begin with.
    // 2. Previously activated countries should be de-activated.
    lastSelected.isActive = false;
  }
  //ev.target.series.chart.zoomToMapObject(ev.target);	//클릭시 확대 코드
  if (lastSelected !== ev.target) {
    lastSelected = ev.target;
    //지도에서 광역시,도 클릭시 코드를 통하여 시,구 목록 생성하는 코드
    $.ajax({
		type: "get",
		url: "http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admSiList.json",
		data : {admCode : ev.target.dataItem.dataContext.id , authkey : $('#sigoon_key').val()},
		async: false,
		dataType: 'json',
		success: function(data) {
			var html = "<option>선택</option>";
			
			for(var i=0;i<data.admVOList.admVOList.length;i++){
				html +="<option value='"+data.admVOList.admVOList[i].lowestAdmCodeNm+"'>"+data.admVOList.admVOList[i].lowestAdmCodeNm+"</option>"
    		}

            $('#sigoon_code').html(html);
		},
		error: function(xhr, stat, err) {}
	});
    //alert(ev.target.dataItem.dataContext.name);  //클릭시 광역시,도 이름 나오도록 하는 코드
    //alert(ev.target.dataItem.dataContext.id);	//클릭시 광역시,도에 맞는 코드값 나오는 코드
   lastCity = ev.target.dataItem.dataContext.name;
  }
})


/* Create selected and hover states and set alternative fill color */
var ss = polygonTemplate.states.create("active");
ss.properties.fill = chart.colors.getIndex(2);

var hs = polygonTemplate.states.create("hover");
hs.properties.fill = chart.colors.getIndex(4);

// Hide Antarctica
polygonSeries.exclude = ["AQ"];

chart.zoomControl = new am4maps.ZoomControl();

var homeButton = new am4core.Button();
homeButton.events.on("hit", function(){
  chart.goHome();
});

homeButton.icon = new am4core.Sprite();
homeButton.padding(7, 5, 7, 5);
homeButton.width = 30;
homeButton.icon.path = "M16,8 L14,8 L14,16 L10,16 L10,10 L6,10 L6,16 L2,16 L2,8 L0,8 L8,0 L16,8 Z M16,8";
homeButton.marginBottom = 10;
homeButton.parent = chart.zoomControl;
homeButton.insertBefore(chart.zoomControl.plusButton);
//지도 관련 js 끝

//선택된 값 info페이지로 넘어가게 하는 코드 시작
$("#check").click(function(){
	var sido = lastCity;
	var sigoon = $("#sigoon_code option:selected").val();
	var datetest = $("#datetest").val();
	location.href="info/"+sido+"/"+sigoon+"/"+datetest;
});
//선택된 값 info페이지로 넘어가게 하는 코드 끝