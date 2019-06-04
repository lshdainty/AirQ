var ip = sessionStorage.getItem('IP_ADDRESS');
//gps값 가져오기
if (navigator.geolocation) {
	//위치 정보를 얻기
	navigator.geolocation.getCurrentPosition(function (position) {
		var x = position.coords.latitude;
		var y = position.coords.longitude;
		console.log(x);
		console.log(y);
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
			type: "get",
			url: ip+"/m.test",
			//dataType: "json",
			async: false,
			success: function (data) {
				alert("확인");
			}
		});
	});
} else {
	alert("이 브라우저에서는 Geolocation이 지원되지 않습니다.");
}