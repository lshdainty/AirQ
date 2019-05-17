﻿//지도 관련 js 시작
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
		url: "/areasido",
		data : {area_do : ev.target.dataItem.dataContext.name},
		async: false,
		dataType: "json",
		success: function(data) {
			var html = "<option value='선택'>선택</option>";
			
			for(var i=0;i<data.aList.length;i++){
				html +="<option value='"+data.aList[i].area_si+"'>"+data.aList[i].area_si+"</option>"
    		}
            $('#sigoon_code').html(html);
		},
		error: function(xhr, stat, err) {}
	});
    //alert(ev.target.dataItem.dataContext.name);  //클릭시 광역시,도 이름 나오도록 하는 코드
    //alert(ev.target.dataItem.dataContext.id);	//클릭시 광역시,도에 맞는 코드값 나오는 코드
  	$("#sido_code").val(ev.target.dataItem.dataContext.name);
  }
  ajax(1,sortdata());
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

//정렬값 확인 함수 시작
function sortdata(){
	var sort = $(".compareSelect option:selected").val()
	return sort;
}
//정렬값 확인 함수 끝

//정렬check박스 선택 시작
$(".compareSelect").change(function(){
	ajax(1,sortdata());
});
//정렬check박스 선택 끝

//시/구 선택 시작
$("#sigoon_code").change(function(){
	ajax(1,sortdata());
});
//시/구 선택 선택 끝

//평수 선택 시작
$("#space").change(function(){
	ajax(1,sortdata());
});
//평수 선택 끝

//paging 시작
function page(idx){
	ajax(idx,sortdata());
}
//paging 끝

//ajax 함수 시작
function ajax(idx,sort){
	var data = {
		sido : $("#sido_code").val(),
		sigoon : $("#sigoon_code option:selected").val(),
		space : $("#space option:selected").val(),
		sort : sort
	}
	$.ajax({
		type: "get",
		url: "/selectCompare?pagenum="+idx,
		data : data,
		async: false,
		dataType: "json",
		success: function(data) {
			var result="";
			var space="";
			var area="";
			var page="";
			if(data.pList.length==0){
				alert("검색결과가 없습니다.");
//				$("#sido_code").val("광역시/도");
//				$("#sigoon_code").val("선택").prop("selected", true);
//				$("#space").val("0").prop("selected", true);
			}else{
				for(var i=0; i<data.pList.length; i++){
					result += '<li class="tableListContent" id="'+data.pList[i].product_code+'">'
					result += '<div class="tableColumn tableCol-15" data-label="상품이름">'+data.pList[i].product_name+'</div>'
					result += '<div class="tableColumn tableCol-10-1" data-label="가격">'+data.pList[i].product_price+'</div>'
					switch(data.pList[i].p_space){
						case 1: space="1~10평"; break;
						case 2: space="11~20평"; break;
						case 3: space="21~30평"; break;
						case 4: space="31~40평"; break;
						case 5: space="41~50평"; break;
						case 6: space="51~60평"; break;
						case 7: space="61~70평"; break;
						case 8: space="71~80평"; break;
						case 9: space="81~90평"; break;
						case 10: space="91~100평"; break;
						case 11: space="101평~"; break;
						}
					result += '<div class="tableColumn tableCol-15" data-label="측정 적절 평수">'+space+'</div>'
					result += '<div class="tableColumn tableCol-10-1" data-label="측정 지점">'+data.pList[i].measure_point+'</div>'
					for(var j=0; j<data.pList[i].areaVO.length; j++){
						area += data.pList[i].areaVO[j].area_si+" "
					}
					result += '<div class="tableColumn tableCol-15" data-label="서비스 가능지역">'+area+'</div>'
					result += '<div class="tableColumn tableCol-10-1" data-label="만족도 평균">'+data.pList[i].staravg+'</div>'
					result += '<div class="tableColumn tableCol-10-1" data-label="판매 건수">'+data.pList[i].sellnum+'</div>'
					space="";area="";
				}
				$("#tableListHeader").nextAll().remove();
				$("#tableListHeader").after(result);
				if(data.criteria.prev){
					page += '<li class="page-item"><a class="page-link" href="javascript:page('+(data.criteria.startPage-1)+');" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>'
				}
				for(var i=data.criteria.startPage; i<=data.criteria.endPage; i++){
					page += '<li class="page-item"><a class="page-link" href="javascript:page('+i+');">'+i+'</a></li>'
				}
				if(data.criteria.next){
					page += '<li class="page-item"><a class="page-link" href="javascript:page('+(data.criteria.endPage+1)+');" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>'
				}
				$(".pagination").empty();
				$(".pagination").prepend(page);
				$("html, body").animate({ scrollTop: 0 }, 1);
			}	//else
		}	//success
	});	//ajax
}	//function
//ajax 함수 끝

//상품 상세페이지 시작
$(document).on('click','.tableListContent',function(){
	var product_code = $(this).attr("id");
	console.log(product_code);
	window.location.href="/product?product_code="+product_code;
});
//상품 상세페이지 끝

//상품 등록페이지 시작
$("#productWrite").click(function(){
	window.location.href="/productWrite";
});
//상품 등록페이지 끝