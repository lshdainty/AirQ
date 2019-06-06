var ip = sessionStorage.getItem('IP_ADDRESS');

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

//gps값 가져오기
if (navigator.geolocation) {
	//위치 정보를 얻기
	navigator.geolocation.getCurrentPosition(function (position) {
		var x = position.coords.latitude;
		var y = position.coords.longitude;

		var mapOptions = {
			center: new naver.maps.LatLng(x, y),
			zoom: 12,
			scaleControl: false,
			logoControl: false,
			mapDataControl: false,
			zoomControl: true,
			minZoom: 1
		};

		var map = new naver.maps.Map('map', mapOptions);
		var latlng = map.getCenter();

		$.ajax({
			type:"get",
			url:ip+"/m.outsideData",
			dataType:"json",
			async: false,
			success: function(data) {
				var marker_position = data;
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
			}
		});
	});
} else {
	alert("이 브라우저에서는 Geolocation이 지원되지 않습니다.");
}