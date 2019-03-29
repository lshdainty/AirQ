/**
 * 
 */
$(document).ready(function() {
	// join 버튼 클릭했을 때
	$("#btn-join").click(function() {
		alert(id = $("#id").val());	// id, pw 알림창
		alert(password = $("#password").val());
		var query = {
			id : $("#id").val(),
			password : $("#password").val(),
			name : $("#name").val(),
			email : $("#email").val(),
			tel : $("#tel").val(),
			address : $("#address").val()
		}
		$.ajax({
			type : "GET",
			data : query,
			url : "signup", // 회원 추가
			success : function(data) {
				alert("회원가입 성공");
				location.href = "loginTest" // 로그인 경로 로 이동
			}
		});// ajax

	});
	// 사업자 번호 insert
	$("#btn-join").click(function() {
		alert($("#bnumber").val())	// 사업자 번호 알림창
		var query = {
			bnumber : $("#bnumber").val()
		}
		$.ajax({
			type : "GET",
			data : query,
			url : "Bsignup", // 회원 추가
			success : function(data) {
				alert("사업자 등록 번호 성공");
			}
		});// ajax
	}); // ajax

	// 중복 확인 눌렀을 때
	$("#btn-check").click(function() {
		alert("중복 확인 체크");	// 중복확인 클릭 시 알림창
		alert($("#id").val());
		var query = {
			id : $("#id").val()
		}
		$.ajax({
			asybc : false,
			type : "GET",
			data : query,
			url : "idCheck", // 회원 추가
			success : function(data) {
				if (data == 1) {	// 아이디 중복 될 경우 join버튼 비활성화
					alert("아이디가 중복됩니다.");
					$(".result .msg").text("사용불가");
					$(".result .msg").attr("style", "color:#f00");

					$("#btn-join").attr("disabled", "disabled");
				} else {		// 아이디 중복 되지 않을 경우 join버튼 활성화
					alert("사용가능한 아이디 입니다.");
					$(".result .msg").text("사용가능");
					$(".result .msg").attr("style", "color:#00f");

					$("#btn-join").removeAttr("disabled");
				}
			}
		});// ajax
	}); // 중복 확인
}); // document
