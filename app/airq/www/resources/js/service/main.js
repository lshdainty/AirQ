var ip = sessionStorage.getItem('IP_ADDRESS');

$(document).ready(function () {
    $('#header').load('../../../www/views/include/top-nav.html');
    $('#footer').load('../../../www/views/include/bottom-nav.html');

    if (document.readyState == 'complete') {
        $('.loat_gate').remove();
    }
    getIotList();

    $(document).on('deviceready', function () {
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
                }, function (status, response) {
                    var items = response.v2.results,
                        address = '',
                        htmlAddresses = [];

                    for (var i = 0, ii = items.length, item, addrType; i < ii; i++) {
                        item = items[i];
                        $(".location_info").text(item.region.area1.name + " " + item.region.area2.name + " " + item.region.area3.name + " " + item.region.area4.name);
                    }
                });

                var utmk = naver.maps.TransCoord.fromLatLngToUTMK(latlng); // 위/경도 -> UTMKa
                var query = {
                    x: utmk.x,
                    y: utmk.y
                }
                $.ajax({
                    type: "get",
                    url: ip + "/m.dustData",
                    data: query,
                    dataType: "json",
                    async: false,
                    success: function (data) {
                        console.log(data);
                        var value, thisSelector, condition, faceGrade;

                        for (var i = 0; i < data.result.length; i++) {
                            value = data.result[i].data;
                            thisSelector = $('#outside').find('.measure_value').get(i);
                            $(thisSelector).text(value);
                            $(thisSelector).parent().parent().addClass("grade_" + data.result[i].grade);

                            $(thisSelector).siblings(".changeNum").text(data.result[i].grade);
                            switch (data.result[i].grade) {
                                case 1:
                                    faceGrade = "1";
                                    condition = "최고";
                                    break;
                                case 2:
                                    faceGrade = "1";
                                    condition = "좋음";
                                    break;
                                case 3:
                                    faceGrade = "2";
                                    condition = "양호";
                                    break;
                                case 4:
                                    faceGrade = "2";
                                    condition = "보통";
                                    break;
                                case 5:
                                    faceGrade = "3";
                                    condition = "나쁨";
                                    break;
                                case 6:
                                    faceGrade = "4";
                                    condition = "상당히 나쁨";
                                    break;
                                case 7:
                                    faceGrade = "5";
                                    condition = "매우 나쁨";
                                    break;
                                case 8:
                                    faceGrade = "6";
                                    condition = "최악";
                                    break;
                                default:
                                    faceGrade = "2";
                                    condition = "데이터없음";
                                    break;
                            }
                            $(thisSelector).siblings(".condition").text(condition);
                            $(thisSelector).siblings(".faceGrade").text(faceGrade);

                        }
                        

                        var container = $('#'+place).find('.matter_container').get(0);

                        condition = $(container).find('.condition').text();
                        value =$(container).find('.measure_value').text();
                        changeNum = $(container).find('.changeNum').text();
                        faceGrade = $(container).find('.faceGrade').text();

                        mainInfoChange(condition,value,changeNum,faceGrade,"outside");


                    }
                }).always(function () {
                    $('.load-gate').remove();
                });
            });
        } else {
            alert("이 브라우저에서는 Geolocation이 지원되지 않습니다.");
        }
    }

    )



    $(document).on("click", "#outside .matter_container", function () {

        var value = $(this).find('.measure_value').text();
        var changeNum = $(this).find(".changeNum").text();
        var condition = $(this).find(".condition").text();
        var faceGrade = $(this).find(".faceGrade").text();

        mainInfoChange(condition,value,changeNum,faceGrade,"outside");
    });

    $(document).on("change", "#iotSelector", function () {
        getMatValue();
    });
    $(document).on("click", "#inside .matter_container", function () {

        var value = $(this).find('.measure_value').text();
        var changeNum = $(this).find(".changeNum").text();
        var condition = $(this).find(".condition").text();
        var faceGrade = $(this).find(".faceGrade").text();

        mainInfoChange(condition,value,changeNum,faceGrade,"inside");
    });

    function mainInfoChange(condition,value,changeNum,faceGrade,place){

        $('#'+place).find('.mat_face_container').removeClass("grade_0");
        $('#'+place).find('.mat_face_container').removeClass("grade_1");
        $('#'+place).find('.mat_face_container').removeClass("grade_2");
        $('#'+place).find('.mat_face_container').removeClass("grade_3");
        $('#'+place).find('.mat_face_container').removeClass("grade_4");
        $('#'+place).find('.mat_face_container').removeClass("grade_5");
        $('#'+place).find('.mat_face_container').removeClass("grade_6");
        $('#'+place).find('.mat_face_container').removeClass("grade_7");
        $('#'+place).find('.mat_face_container').removeClass("grade_8");
        $('#'+place).find('.mat_face_container').addClass(changeNum);

        $('#'+place).find('.mat_face_container').find('.mat_grade').text(condition);
        $('#'+place).find('.mat_face_container').find('.mat_value').text(value);
        $('#'+place).find('.mat_face_container').addClass("grade_" + changeNum);

        $('#'+place).find('.mat_face_container').find('#face').attr('src', '../../../www/resources/images/face_'+faceGrade+".svg");

    }

    //  Get Iot List
    function getIotList() {
        var user = JSON.parse(sessionStorage.getItem("user"));
        var member_id = user.member_id;
        $.ajax({
            type: "GET",
            url: sessionStorage.getItem("IP_ADDRESS")+"/m.checkIot",
            data:{member_id:member_id},
            dataType: "json",
            success: function (data) {
                $("#iotSelector").empty();
                
                console.log(data);
                if (data.result == "yes") {
                    var iotList = "";
                    var item = "";
                    for (var i = 0; i < data.iotInfo.length; i++) {
                        iotList += "<option value='" + data.iotInfo[i].ID + "'>"
                            + data.iotInfo[i].ID + "</option>";
                    }


                    $("#iotSelector").append(iotList);
    $("#iotSelector").val("나의 공기측정1").prop("selected", true);
                          
        var iot_id,matter_code,matter_name,matter_value,selected;


        selected = $("#iotSelector option:selected").val();



        for (var j = 0; j < data.iotInfo.length; j++) {
            console.log("SELECTED : " + selected);
            iot_id = data.iotInfo[j].ID;
            console.log("IOT_ID : " + iot_id);

            $($('#inside').find('.mat_info_row')).empty();


        if(iot_id == selected){


                for(var x= 0; x < data.iotInfo[j].matterList.length;x++){
                    matter_name = data.iotInfo[j].matterList[x].MATTER_NAME;
                    matter_code = data.iotInfo[j].matterList[x].MATTER_CODE;
                    matter_value = insideMatInfo(iot_id,matter_code);


                    var item="";
                    var faceGrade="";
                    var condition="";
                    switch (matter_value.grade) {
                        case 1:
                            faceGrade = "1";
                            condition = "최고";
                            break;
                        case 2:
                            faceGrade = "1";
                            condition = "좋음";
                            break;
                        case 3:
                            faceGrade = "2";
                            condition = "양호";
                            break;
                        case 4:
                            faceGrade = "2";
                            condition = "보통";
                            break;
                        case 5:
                            faceGrade = "3";
                            condition = "나쁨";
                            break;
                        case 6:
                            faceGrade = "4";
                            condition = "상당히 나쁨";
                            break;
                        case 7:
                            faceGrade = "5";
                            condition = "매우 나쁨";
                            break;
                        case 8:
                            faceGrade = "6";
                            condition = "최악";
                            break;
                        default:
                            faceGrade = "2";
                            condition = "데이터없음";
                            break;
                    }





                    item =
                    '<div class="matter_container grade_'+matter_value.grade+'">'+
                    '<div class="matter_title">'+matter_name+'</div>'+
                    '<div class="matter_value">'+
                    '<span class="measure_value">'+matter_value.value+'</span>'+
                    '<span class="measure_numerical">'+matter_value.unit+'</span>'+
                    '<span class="changeNum" style="display:none;">'+matter_value.grade+'</span>'+
                    '<span class="condition" style="display:none;">'+condition+'</span>'+
                    '<span class="faceGrade" style="display:none;">'+faceGrade+'</span> </div></div>';


                   $($('#inside').find('.mat_info_row')).append(item);
                }
            }

        }
                } else {
                    var html = "<h1>등록된 기기가 없습니다.</h1>";
                    $(".matSBox").empty();
                    $(".matSBox").append(html);
                }
            }
        });
    }




    function insideMatInfo(iot_id,matter_code){

        var result;


        $.ajax({
            async:false,
            type: "GET",
            url: sessionStorage.getItem("IP_ADDRESS")+"/m.getMeasureValue",
            data:{
                iot_id:iot_id,
                matter_code: matter_code
            },
            dataType: "json",
            success: function (data) {
                console.log(data);
                result = data;
                console.log(result);
            }
        });
        return result;

    }


    function getMatValue(){
        var user = JSON.parse(sessionStorage.getItem("user"));
        var member_id = user.member_id;
        $.ajax({
            type: "GET",
            url: sessionStorage.getItem("IP_ADDRESS")+"/m.checkIot",
            data:{member_id:member_id},
            dataType: "json",
            success: function (data) {


                      
        var iot_id,matter_code,matter_name,matter_value,selected;


        selected = $("#iotSelector option:selected").val();



        for (var j = 0; j < data.iotInfo.length; j++) {
            console.log("SELECTED : " + selected);
            iot_id = data.iotInfo[j].ID;
            console.log("IOT_ID : " + iot_id);

            $($('#inside').find('.mat_info_row')).empty();


        if(iot_id == selected){


                for(var x= 0; x < data.iotInfo[j].matterList.length;x++){
                    matter_name = data.iotInfo[j].matterList[x].MATTER_NAME;
                    matter_code = data.iotInfo[j].matterList[x].MATTER_CODE;
                    matter_value = insideMatInfo(iot_id,matter_code);


                    var item="";
                    var faceGrade="";
                    var condition="";
                    switch (matter_value.grade) {
                        case 1:
                            faceGrade = "1";
                            condition = "최고";
                            break;
                        case 2:
                            faceGrade = "1";
                            condition = "좋음";
                            break;
                        case 3:
                            faceGrade = "2";
                            condition = "양호";
                            break;
                        case 4:
                            faceGrade = "2";
                            condition = "보통";
                            break;
                        case 5:
                            faceGrade = "3";
                            condition = "나쁨";
                            break;
                        case 6:
                            faceGrade = "4";
                            condition = "상당히 나쁨";
                            break;
                        case 7:
                            faceGrade = "5";
                            condition = "매우 나쁨";
                            break;
                        case 8:
                            faceGrade = "6";
                            condition = "최악";
                            break;
                        default:
                            faceGrade = "2";
                            condition = "데이터없음";
                            break;
                    }





                    item =
                    '<div class="matter_container grade_'+matter_value.grade+'">'+
                    '<div class="matter_title">'+matter_name+'</div>'+
                    '<div class="matter_value">'+
                    '<span class="measure_value">'+matter_value.value+'</span>'+
                    '<span class="measure_numerical">'+matter_value.unit+'</span>'+
                    '<span class="changeNum" style="display:none;">'+matter_value.grade+'</span>'+
                    '<span class="condition" style="display:none;">'+condition+'</span>'+
                    '<span class="faceGrade" style="display:none;">'+faceGrade+'</span> </div></div>';


                   $($('#inside').find('.mat_info_row')).append(item);
                }
            }

        }


            }
        });
    }
});
