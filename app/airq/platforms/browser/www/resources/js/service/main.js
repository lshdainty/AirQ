var ip = sessionStorage.getItem('IP_ADDRESS');

$(document).ready(function () {
    $(document).on('deviceready', function () {
        //gps값 가져오기
        if (navigator.geolocation) {
            //위치 정보를 얻기
            alert("돌아가긴하냐22");
            navigator.geolocation.getCurrentPosition(function (position) {
                var x = position.coords.latitude;
                var y = position.coords.longitude;
                var mapOptions = {
                    center: new naver.maps.LatLng(x, y),
                    zoom: 10,
                    scaleControl: false,
                    logoControl: false,
                    mapDataControl: false,
                    zoomControl: true,
                    minZoom: 1
                };
                var map = new naver.maps.Map('map', mapOptions);
                var latlng = map.getCenter();
                var marker = new naver.maps.Marker({
                    position: new naver.maps.LatLng(x,y),
                    map: map
                });

                var utmk = naver.maps.TransCoord.fromLatLngToUTMK(latlng); // 위/경도 -> UTMKa
                var query = {
                    x: utmk.x,
                    y: utmk.y
                }
                $.ajax({
                    type: "get",
                    url: ip+"/m.dustData",
                    data: query,
                    dataType: "json",
                    async: false,
                    success: function (data) {
                        console.log(data);
                        $(".matter_info").empty(); 
                        for(var i=0; i<data.result.length; i++){
                            var result = '<div class="matter_container">'+
                                            '<div class="matter_title">'+data.result[i].name+'</div>'+
                                            '<div class="matter_value">'+
                                                '<span class="mesure_value">'+data.result[i].data+'</span>'+
                                                '<span class="mesure_numerical">'+data.result[i].unit+'</span>'+
                                            '</div>'+
                                        '</div>';
                            $(".matter_info").append(result);
                            result="";
                        }
                    }
                });
            });
        } else {
            alert("이 브라우저에서는 Geolocation이 지원되지 않습니다.");
        }
    });
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