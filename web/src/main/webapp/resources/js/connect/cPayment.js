var date = new Date();

function formatDateToString(date){
	// 01, 02, 03, ... 29, 30, 31
	var dd = (date.getDay() < 10 ? '0' : '') + (date.getDay() + 3);
	// 01, 02, 03, ... 10, 11, 12
	var MM = ((date.getMonth() + 1) < 10 ? '0' : '') + (date.getMonth() + 1);
	// 1970, 1971, ... 2015, 2016, ...
	var yyyy = date.getFullYear();
	// create the format you want
	return (yyyy + "/" + MM + "/" + dd);
}

$('#datepicker').val(formatDateToString(date));

$.datepicker.setDefaults({
	dateFormat : 'yymmdd',
	prevText : '이전 달',
	nextText : '다음 달',
	monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
			'9월', '10월', '11월', '12월' ],
	monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
			'9월', '10월', '11월', '12월' ],
	dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
	dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
	dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
	showMonthAfterYear : true,
	yearSuffix : '년'
});

$("#datepicker").datepicker({dateFormat : "yy/mm/dd",});
$("#timepicker").wickedpicker({
	title : '시간 선택',
	now:"09:00",
	twentyFour: true, 
	timeSeparator: ':'
});

$(function() {
	$("#cOrder").click(function(){
		if($("#d_zipcode").val()==""||$("#d_zipcode").val()==null){
			alert("우편번호를 검색해주세요");
			return false;
		}else if($("#d_road_addr").val()==""||$("#d_road_addr").val()==null){
			alert("도로명 주소를 검색해주세요");
			return false;
		}else if($("#d_addr").val()==""||$("#d_addr").val()==null){
			alert("지번 주소를 검색해주세요");
			return false;
		}else if($("#d_addr_detail").val()==""||$("#d_addr_detail").val()==null){
			alert("상세 주소를 검색해주세요");
			return false;
		}else if($("#datepicker").val()<date){
			alert("예약은 오늘 기준 다음날부터 가능합니다.");
			return false;
		}else{
			var query = {
					product_code : $("#product_code").val(),
					payment_price : $("#payment_price").text(),
					d_zipcode : $("#d_zipcode").val(),
					d_road_addr : $("#d_road_addr").val(),
					d_addr : $("#d_addr").val(),
					d_addr_detail : $("#d_addr_detail").val(),
					dateValue : $("#datepicker").val(),
					timeValue : $("#timepicker").val()
			}
			$.ajax({
				type: "post",
				url: "/cOrder",
				data : query,
				success: function(data) {
					console.log(data);
					alert("주문을 완료하였습니다. 주문코드 : " + data);
					window.close();
				},
				error: function(xhr, stat, err) {
				}
			});
		}
	});
	
	$("#d_service_date").prop('min', function(){
		var date = new Date();
		var date1 = date.setDate(date.getDate()+1);
		var date2 = new Date(date1).toISOString().slice(0,11) + "00:00:00.000";
		return date2
	});
	
	$("#d_service_date").prop('value', function(){
		var date = new Date();
		var date1 = date.setDate(date.getDate()+1);
		var date2 = new Date(date1).toISOString().slice(0,11) + "09:00";
		console.log(date2);
		return date2
	});
});

//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('d_zipcode').value = data.zonecode;
            document.getElementById("d_road_addr").value = roadAddr;
            document.getElementById("d_addr").value = data.jibunAddress;
            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
        }
    }).open();
}