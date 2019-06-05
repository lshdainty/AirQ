//모바일 지도부분 코드 시작
//var htmlMarkers = [];
//
//var htmlMarker1 = {
//		content: '<div id="htmlMarker1"></div>',
//	    size: N.Size(40, 40),
//	    anchor: N.Point(20, 20)
//	},
//	htmlMarker2 = {
//	    content: '<div id="htmlMarker2"></div>',
//	    size: N.Size(40, 40),
//	    anchor: N.Point(20, 20)
//	},
//	htmlMarker3 = {
//	    content: '<div id="htmlMarker3"></div>',
//	    size: N.Size(40, 40),
//	    anchor: N.Point(20, 20)
//	},
//	htmlMarker4 = {
//	    content: '<div id="htmlMarker4"></div>',
//	    size: N.Size(40, 40),
//	    anchor: N.Point(20, 20)
//	},
//	htmlMarker5 = {
//	    content: '<div id="htmlMarker5"></div>',
//	    size: N.Size(40, 40),
//	    anchor: N.Point(20, 20)
//	};
//
//if (navigator.geolocation) {
//	//위치 정보를 얻기
//	navigator.geolocation.getCurrentPosition (function(pos) {
//		var x = pos.coords.latitude;
//		var y = pos.coords.longitude;
//		var mapOptions = {
// 		    center: new naver.maps.LatLng(x, y),
// 		    zoom: 10,
// 		    scaleControl: false,
// 		    logoControl: false,
// 		    mapDataControl: false,
// 		    zoomControl: true,
// 		    minZoom: 1
// 		};
// 		var map = new naver.maps.Map('map', mapOptions);
// 		var latlng = map.getCenter();
// 		var utmk = naver.maps.TransCoord.fromLatLngToUTMK(latlng); // 위/경도 -> UTMKa
// 		var query = {
// 				x : utmk.x,
// 				y : utmk.y
// 		}
// 		$.ajax({
// 			type:"get",
// 			url:"/dustData",
// 			data:query,
// 			dataType:"json",
// 			async: false,
// 			success: function(data) {
// 				var marker_position = data;
// 				//마커찍는 부분
// 				for(var i=0; i<marker_position.result.length; i++){
// 						
// 					//html기반 마커찍기
// 					var markerContent = [
// 					    '<div style="position:absolute;">',
// 					        '<div class="infowindow">',
// 					            '<div>미세먼지(pm10) : '+marker_position.result[i].pm10Value+'</div>',
// 					            '<div class="info_tri1"></div>',
// 					            '<div class="info_tri2"></div>',
// 					        '</div>',
// 					        '<div class="pin_s">',
// 					            '<img class="pin_s_img" src="https://ssl.pstatic.net/static/maps/mantle/1x/marker-default.png" alt="">',
// 					            '<div class="pins_s_tooltip">'+marker_position.result[i].addr+'</div>',
// 					        '</div>',
// 					    '</div>'
// 					].join('');
// 						
// 					//json에 저장된 위치정보 하나씩 가져오기
// 					var position = new naver.maps.LatLng(
// 							marker_position.result[i].x,
// 							marker_position.result[i].y);
// 						
// 					//html마커 naver map에 생성
// 					var htmlMarker = new naver.maps.Marker({
// 					    position: position,
// 					    map: map,
// 					    icon: {
// 					        content: markerContent,
// 					        size: new naver.maps.Size(22, 30),
// 					        anchor: new naver.maps.Point(11, 30)
// 					    }
// 					});
// 					htmlMarkers.push(htmlMarker);
// 				}
// 				
// 				//마커 클러스터 생성
// 				var markerClustering = new MarkerClustering({
// 					minClusterSize: 2,
// 					maxZoom: 8,
// 					map: map,
// 					markers: htmlMarkers,
// 					disableClickZoom: false,
// 					gridSize: 120,
// 					icons: [htmlMarker1, htmlMarker2, htmlMarker3, htmlMarker4, htmlMarker5],
// 					indexGenerator: [10, 20, 30, 40, 50],
// 					stylingFunction: function(clusterMarker, count) {
// 						$(clusterMarker.getElement()).find('div:first-child').text(count);
// 					}
// 				});
// 			}
// 		});
//	});
//} else {
//	alert("이 브라우저에서는 Geolocation이 지원되지 않습니다.")
//}
//
////infowindow 생성/삭제
//$('.pin_s_img').on('click',function(e) {
//	alert("test");
//	var infowindow = $(this).parent().parent().find('.infowindow');
//	if(infowindow.css('display')=="block"){
//		infowindow.hide();
//	}else{
//		infowindow.show();
//	}
//});
//
////마우스 올라가면 툴팁 보이게 하기
//$('.pin_s_img').on('mouseenter',function(e) {
//	$(this).parent().parent().find('.pins_s_tooltip').show();
//});
//
////마우스 내려가면 툴팁 안보이게 하기
//$('.pin_s_img').on('mouseout',function(e) {
//	$(this).parent().parent().find('.pins_s_tooltip').hide();
//});
//모바일 지도부분 코드 끝

//웹 지도 코드 시작
//지도에 마커값 가져오기

var test;

$.ajax({
	type: "get",
	url: "/dustData",
	dataType:"json",
	async: false,
	success: function(data) {
		test = data;
	}
});

// 네이버 지도 자바 스크립트 시작
var mapOptions = {
    center: new naver.maps.LatLng(35.8967746, 128.6209546),
    zoom: 10,
    scaleControl: false,
    logoControl: false,
    mapDataControl: false,
    zoomControl: true,
    minZoom: 1
};

var map = new naver.maps.Map('map', mapOptions);

//2. HTML 마커
//JSON 데이터부분
var marker_position = test;
console.log(marker_position.result.length);

var htmlMarkers = [];

var htmlMarker1 = {
		content: '<div id="htmlMarker1"></div>',
	    size: N.Size(40, 40),
	    anchor: N.Point(20, 20)
	},
	htmlMarker2 = {
	    content: '<div id="htmlMarker2"></div>',
	    size: N.Size(40, 40),
	    anchor: N.Point(20, 20)
	},
	htmlMarker3 = {
	    content: '<div id="htmlMarker3"></div>',
	    size: N.Size(40, 40),
	    anchor: N.Point(20, 20)
	},
	htmlMarker4 = {
	    content: '<div id="htmlMarker4"></div>',
	    size: N.Size(40, 40),
	    anchor: N.Point(20, 20)
	},
	htmlMarker5 = {
	    content: '<div id="htmlMarker5"></div>',
	    size: N.Size(40, 40),
	    anchor: N.Point(20, 20)
	};

//마커찍는 부분
for(var i=0; i<marker_position.result.length; i++){
		
	//html기반 마커찍기
	var markerContent = [
	    '<div style="position:absolute;">',
	        '<div class="infowindow">',
	            '<div>미세먼지(pm10) : '+marker_position.result[i].pm10Value+'</div>',
	            '<div class="info_tri1"></div>',
	            '<div class="info_tri2"></div>',
	        '</div>',
	        '<div class="pin_s">',
	            '<img class="pin_s_img" src="https://ssl.pstatic.net/static/maps/mantle/1x/marker-default.png" alt="">',
	            '<div class="pins_s_tooltip">'+marker_position.result[i].addr+'</div>',
	        '</div>',
	    '</div>'
	].join('');
		
	//json에 저장된 위치정보 하나씩 가져오기
	var position = new naver.maps.LatLng(
			marker_position.result[i].x,
			marker_position.result[i].y);
		
	//html마커 naver map에 생성
	var htmlMarker = new naver.maps.Marker({
	    position: position,
	    map: map,
	    icon: {
	        content: markerContent,
	        size: new naver.maps.Size(22, 30),
	        anchor: new naver.maps.Point(11, 30)
	    }
	});
	htmlMarkers.push(htmlMarker);
}

//마커 클러스터 생성
var markerClustering = new MarkerClustering({
	minClusterSize: 2,
	maxZoom: 8,
	map: map,
	markers: htmlMarkers,
	disableClickZoom: false,
	gridSize: 120,
	icons: [htmlMarker1, htmlMarker2, htmlMarker3, htmlMarker4, htmlMarker5],
	indexGenerator: [10, 20, 30, 40, 50],
	stylingFunction: function(clusterMarker, count) {
		$(clusterMarker.getElement()).find('div:first-child').text(count);
	}
});

//infowindow 생성/삭제
$('.pin_s_img').on('click',function(e) {
	var infowindow = $(this).parent().parent().find('.infowindow');
	if(infowindow.css('display')=="block"){
		infowindow.hide();
	}else{
		infowindow.show();
	}
});

//마우스 올라가면 툴팁 보이게 하기
$('.pin_s_img').on('mouseenter',function(e) {
	$(this).parent().parent().find('.pins_s_tooltip').show();
});

//마우스 내려가면 툴팁 안보이게 하기
$('.pin_s_img').on('mouseout',function(e) {
	$(this).parent().parent().find('.pins_s_tooltip').hide();
});