$(document).ready(function() {
	//로그인 버튼 클릭
	$("#logintest").click(function() {
		alert($("#id").val());
		alert($("#pw").val());

		
		var query = {
			id : $("#id").val(),
			password : $("#pw").val()
		}
		// 로그인 버튼 클릭 ajax 
		$.ajax({
			type : "POST",
			data : query,
			url : "login", // 로그인 페이지 경로
			success : function(data) {
				alert("여기까지 왔음");
				if (data == "success") { //로그인 성공
					alert("성공했냐?");
					location.href = "/";
				} else if(data == "failpw"){ //pw 틀렸을 경우
					alert("failpw");
					$("#nopw").css("display", "block");
					$("#nopw").show();
					$("#noid").hide();
				}else if(data == "failid"){ //id 틀렸을 경우
					alert("failid");
					$("#noid").css("display", "blokc");
					$("#noid").show();
					$("#nopw").hide();
				}
			}
		}) // ajax 로그인 버튼 끝
	});
	
});
