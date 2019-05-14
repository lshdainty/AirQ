/**
 * 
 */
$(document).ready(function() {
	/*// 사업자 번호 insert
	$("#btn-join").click(function() {
		var query = {
			company_code : $("#company_code").val(),
			company_name : $("#company_name").val(),
			company_tel : $("#company_tel").val(),
			member_id : $("#id").val()
		}
		$.ajax({
			type : "POST",
			data : query,
			url : "Bsignup", // 회원 추가
			success : function(data) {
				alert("회원가입 성공");
			}
		});// ajax
	}); // ajax
*/
	// 중복 확인 눌렀을 때
	$("#btn-check").click(function() {
		var query = {
			id : $("#id").val()
		}
		$.ajax({
			asybc : false,
			type : "GET",
			data : query,
			url : "idCheck", // 회원 추가
			success : function(data) {
				if (data == "No") {	// 아이디 중복 될 경우 join버튼 비활성화
					$(".result .msg").text("사용불가");
					$(".result .msg").attr("style", "color:#f00");

					$("#btn-join").attr("disabled", "disabled");
				} else if (data == "Yes") {		// 아이디 중복 되지 않을 경우 join버튼 활성화
					$(".result .msg").text("사용가능");
					$(".result .msg").attr("style", "color:#00f");

					$("#btn-join").removeAttr("disabled");
				}
			}
		});// ajax
	}); // 중복 확인
}); // document
