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
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
            
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
$(document).ready(function(){

$(document).on('click','#tenderWriteBtn',function(){
	var tender_title=$("#tender_title").val();
	var tender_name=$("#tender_name").val();
	var group_name=$("#group_name").val();
	var t_zipcode=$("#sample4_postcode").val();
	var t_road_addr=$("#sample4_roadAddress").val();
	var t_addr=$("#sample4_jibunAddress").val();
	var t_addr_detail=$("#sample4_detailAddress").val();
	var service_date=$("#service_date").val();
	var tender_deadline=$("#tender_deadline").val();
	var bid_open_date=$("#bid_open_date").val();
	var budget=$("#budget").val();
	var t_space=$("#t_space").val();
	var floor_number=$("#floor_number").val();
	var calculate_period=$("#calculate_period").val();
	var winning_bid_way=$("#winning_bid_way").val();
	var requirement=$("#requirement").val();
	var tender_upload=$("#tender_upload").val();
	
	var query={
			tender_title:tender_title,tender_name:tender_name,
			group_name:group_name,t_zipcode:t_zipcode,
			t_road_addr:t_road_addr,t_addr:t_addr,
			t_addr_detail:t_addr_detail,service_date:service_date,
			tender_deadline:tender_deadline,bid_open_date:bid_open_date,
			budget:budget,t_space:t_space,floor_number:floor_number,
			calculate_period:calculate_period,winning_bid_way:winning_bid_way,
			requirement:requirement
	};
	
	if(tender_upload == ""){
		alert("입력 양식을 다 채워주세요");
		return false;
	}
	
	var formData = new FormData();
	var inputFile=$("input[name='tender_upload']");
	var files=inputFile[0].files;
	
	for(var i = 0; i < files.length; i++){
		if(!checkExtension(files[i].name, files[i].size) ){
			return false;
		}
		formData.append("uploadFile",files[i]);
	}
	formData.append("tender_title",tender_title);
	formData.append("tender_name",tender_name);
	formData.append("group_name",group_name);
	formData.append("t_zipcode",t_zipcode);
	formData.append("t_road_addr",t_road_addr);
	formData.append("t_addr",t_addr);
	formData.append("t_addr_detail",t_addr_detail);
	formData.append("service_date",service_date);
	formData.append("tender_deadline",tender_deadline);
	formData.append("bid_open_date",bid_open_date);
	formData.append("budget",budget);
	formData.append("t_space",t_space);
	formData.append("floor_number",floor_number);
	formData.append("calculate_period",calculate_period);
	formData.append("winning_bid_way",winning_bid_way);
	formData.append("requirement",requirement);
	
	$.ajax({
		type:"post",
		url:"/tenderWriteComplete",
		data:formData,
		processData:false,
		contentType:false,
		success:function(data){
			window.location.href="/tenderMain";
		}
	});
});



	/*파일 업로드 확장자 체크*/
	var regex = new RegExp("(.*?)\.(exe|sh|alz)$");
	var maxSize=10485760; //10MB
	
	function checkExtension(fileName, fileSize) {
		if(fileSize >= maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		if(regex.test(fileName)){
			alert("해당 종류의 파일은 업로드할 수 없습니다.");
			return false;
		}
		
		return true;
	}
});