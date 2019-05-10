// 다음 지도 자바 스크립트 시작
//var map = new daum.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
//        		center : new daum.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표 
//        		level : 14 // 지도의 확대 레벨 
//        	});
//    
//// 마커 클러스터러를 생성합니다 
//var clusterer = new daum.maps.MarkerClusterer({
//        			map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
//        			averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
//        			minLevel: 10 // 클러스터 할 최소 지도 레벨 
//    			});
//    
//// 데이터를 가져오기 위해 jQuery를 사용합니다
//// 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
//$.get("resources/chicken.json", function(data) {
//	// 데이터에서 좌표 값을 가지고 마커를 표시합니다
//	// 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
//	var markers = $(data.positions).map(function(i, position) {
//		return new daum.maps.Marker({
//			position : new daum.maps.LatLng(position.lat, position.lng),
//			title : position.title
//		});
//	});
//	
//	var infowindow = $(data.positions).map(function(i,position){
//		return new daum.maps.InfoWindow({
//			position : new daum.maps.LatLng(position.lat,position.lng),
//			content : '<div>'+position.title+'</div>',
//		});
//	});
//        
//	// 클러스터러에 마커들을 추가합니다
//	clusterer.addMarkers(markers);
//	for(var i = 0; i < data.positions.length; i ++){
//		daum.maps.event.addListener(markers[i], 'mouseover', makeOverListener(map, markers[i], infowindow[i]));
//		daum.maps.event.addListener(markers[i], 'mouseout', makeOutListener(infowindow[i]));
//	}
//});
//
//// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
//function makeOverListener(map, marker, infowindow) {
//	return function() {
//		infowindow.open(map, marker);
//	};
//}
//
//// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
//function makeOutListener(infowindow) {
//	return function() {
//		infowindow.close();
//	};
//}
// 다음 지도 자바 스크립트 끝

// 네이버 지도 자바 스크립트 시작
var mapOptions = {
    center: new naver.maps.LatLng(33.450705, 126.570677),
    zoom: 10,
    scaleControl: false,
    logoControl: false,
    mapDataControl: false,
    zoomControl: true,
    minZoom: 1
};

var map = new naver.maps.Map('map', mapOptions);

//2. HTML 마커
var marker_position = {
	"positions": [
		{
			"title":"카카오",
		    "lat": 33.450705,
		    "lng": 126.570677
		 },
		 {
		    "title":"생태연못",
		    "lat": 33.450936,
		    "lng": 126.569477
		 },
		 {
			 "title":"텃밭",
		     "lat": 33.450879,
		     "lng": 126.569940
		 },
		 {
		     "title":"근린공원",
		     "lat": 33.451393,
		     "lng": 126.570738
		 }
	]
}

var htmlMarker = new Array();

for(var i=0; i<marker_position.positions.length; i++){
	console.log(marker_position.positions[i].title);
	
	var markerContent = [
        '<div style="position:absolute;">',
            '<div class="infowindow" style="display:block;position:absolute;width:220px;height:20px;top:-46px;left:-100px;background-color:white;z-index:1;border:1px solid black;margin:0;padding:0;">',
                '<a href="#" class="spmc btn_clear">핀 삭제</a>',
                '<div>'+marker_position.positions[i].title+'</div>',
                '<div style="margin: 0px; padding: 0px; width: 0px; height: 0px; position: absolute; border-width: 24px 10px 0px; border-style: solid; border-color: rgb(51, 51, 51) transparent; border-image: initial; pointer-events: none; box-sizing: content-box !important; transform-origin: right bottom 0px; transform: skewX(0deg); bottom: -25px; left: 100px;"></div>',
                '<div style="margin: 0px; padding: 0px; width: 0px; height: 0px; position: absolute; border-width: 24px 10px 0px; border-style: solid; border-color: rgb(255, 255, 255) transparent; border-image: initial; pointer-events: none; box-sizing: content-box !important; transform-origin: right bottom 0px; transform: skewX(0deg); bottom: -22px; left: 100px;"></div>',
            '</div>',
            '<div class="pin_s" style="cursor: pointer; width: 22px; height: 30px;">',
                '<img src="https://ssl.pstatic.net/static/maps/img/icons/pin_s_3.png" alt="" style="margin: 0px; padding: 0px; border: 0px solid transparent; display: block; max-width: none; max-height: none; -webkit-user-select: none; position: absolute; width: 22px; height: 30px; left: 0px; top: 0px;">',
                '<div class="pins_s_tooltip" style="display:none;width:150px;height:20px;position:absolute;top:5px;left:25px;">HTML 마커 툴팁입니다.</div>',
            '</div>',
        '</div>'
    ].join('');
	
	console.log(marker_position.positions[i].lat);
	console.log(marker_position.positions[i].lng);
	
	var position = new naver.maps.LatLng(
			marker_position.positions[i].lat,
			marker_position.positions[i].lng);
	
	htmlMarker[i] = new naver.maps.Marker({
        position: position,
        map: map,
        icon: {
            content: markerContent,
            size: new naver.maps.Size(22, 30),
            anchor: new naver.maps.Point(11, 30)
        }
    });
//	htmlMarkers.push(htmlMarker);
}

var elHtmlMarker = htmlMarker.getElement();

$(elHtmlMarker).on('click', 'img', function(e) {
    $(elHtmlMarker).find('.infowindow').show();
});

$(elHtmlMarker).on('mouseenter', 'img', function(e) {
    $(elHtmlMarker).find('.pins_s_tooltip').show();
});

$(elHtmlMarker).on('mouseout', 'img', function(e) {
    $(elHtmlMarker).find('.pins_s_tooltip').hide();
});

$(elHtmlMarker).on('click', 'a.btn_clear', function(e) {
    $(elHtmlMarker).find('.infowindow').hide();
});
// 네이버 지도 자바 스크립트 끝