var ip = sessionStorage.getItem('IP_ADDRESS');

$(document).ready(function () {
    $(document).on('deviceready', function () {
        //gps값 가져오기
        if (navigator.geolocation) {
            //위치 정보를 얻기
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

                naver.maps.Service.reverseGeocode({
                    coords: latlng,
                    orders: [
                        naver.maps.Service.OrderType.ADDR,
                        naver.maps.Service.OrderType.ROAD_ADDR
                    ].join(',')
                }, function(status, response) {
                    var items = response.v2.results,
                    address = '',
                    htmlAddresses = [];
        
                    for (var i=0, ii=items.length, item, addrType; i<ii; i++) {
                        item = items[i];
                        $(".location_info").text(item.region.area1.name+" "+item.region.area2.name+" "+item.region.area3.name+" "+item.region.area4.name);
                    }
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
                            var forecastColor;
				            if (data.result[i].grade >= 8) {
					            forecastColor = "#BDBDBD";
				            }else if(data.result[i].grade >= 7){
					            forecastColor = "#FFA7A7";
				            }else if(data.result[i].grade >= 6){
					            forecastColor = "#FFC19E";
				            }else if(data.result[i].grade >= 5){
					            forecastColor = "#FAED7D";
				            }else if(data.result[i].grade >= 4){
					            forecastColor = "#CEF279";
				            }else if(data.result[i].grade >= 3){
					            forecastColor = "#B2EBF4";
				            }else if(data.result[i].grade >= 2){
					            forecastColor = "#B2CCFF";
				            }else {
					            forecastColor = "#B5B2FF";
				            }
                            var result = '<div class="matter_container" style="background:'+forecastColor+'";>'+
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