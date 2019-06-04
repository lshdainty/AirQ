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

                var defaultMarker = new naver.maps.Marker({
                    position: latlng,
                    map: map,
                    icon: {
                        content: ['<span class="pin_point">',
                                    '<span class="station_a">',
                                        '<span class="station_name"></span>', 
                                        '<span class="figure level2"></span>',
                                    '</span>', 
                                '</span>'].join("")
                    }
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
                        $(".matter_info").empty();
                        for(var i=0; i<data.result.length; i++){
                            var forecastColor;
                            var changeNum;
                            var condition;
				            if (data.result[i].grade >= 8) {
                                forecastColor = "#BDBDBD";
                                changeNum = "changed1";
                                condition = "최악";
				            }else if(data.result[i].grade >= 7){
                                forecastColor = "#FFA7A7";
                                changeNum="changed2";
                                condition = "매우 나쁨";
				            }else if(data.result[i].grade >= 6){
                                forecastColor = "#FFC19E";
                                changeNum="changed3";
                                condition = "상당히 나쁨";
				            }else if(data.result[i].grade >= 5){
                                forecastColor = "#FAED7D";
                                changeNum="changed4";
                                condition = "나쁨";
				            }else if(data.result[i].grade >= 4){
                                forecastColor = "#CEF279";
                                changeNum="changed5";
                                condition = "보통";
				            }else if(data.result[i].grade >= 3){
                                forecastColor = "#B2EBF4";
                                changeNum="changed6";
                                condition = "양호";
				            }else if(data.result[i].grade >= 2){
                                forecastColor = "#B2CCFF";
                                changeNum="changed7";
                                condition = "좋음";
				            }else {
                                forecastColor = "#B5B2FF";
                                changeNum="changed8";
                                condition = "최고";
				            }
                            var result = '<div class="matter_container" style="background:'+forecastColor+'";>'+
                                            '<div class="matter_title">'+data.result[i].name+'</div>'+
                                            '<div class="matter_value">'+
                                                '<span class="mesure_value">'+data.result[i].data+'</span>'+
                                                '<span class="mesure_numerical">'+data.result[i].unit+'</span>'+
                                                '<span class="changeNum" style="display:none;">'+changeNum+'</span>'+
                                                '<span class="condition" style="display:none;">'+condition+'</span>'+
                                            '</div>'+
                                        '</div>';
                            $(".matter_info").append(result);
                            if(data.result[i].name=="미세먼지"){
                                $(".station_a").css("background",forecastColor);
                                $(".station_a").toggleClass(changeNum);
                                $(".figure").text(condition);
                            }
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

$(document).on("click",".matter_container",function(){
    var background = $(this).css("backgroundColor");
    var changeNum = $(this).find(".changeNum").text();
    var condition = $(this).find(".condition").text();
    $(".station_a").css("background",background);
    $(".station_a").removeClass("changed1");
    $(".station_a").removeClass("changed2");
    $(".station_a").removeClass("changed3");
    $(".station_a").removeClass("changed4");
    $(".station_a").removeClass("changed5");
    $(".station_a").removeClass("changed6");
    $(".station_a").removeClass("changed7");
    $(".station_a").removeClass("changed8");
    $(".station_a").addClass(changeNum);
    $(".figure").text(condition);
});