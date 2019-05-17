$(document).ready(function() {
	//로그인 버튼 클릭
	$("#logintest").click(function() {
		
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
				if (data == "success") { //로그인 성공
					location.href = "/";
				} else if(data == "failpw"){ //pw 틀렸을 경우
					$("#nopw").css("display", "block");
					$("#nopw").show();
					$("#noid").hide();
				}else if(data == "failid"){ //id 틀렸을 경우
					$("#noid").css("display", "blokc");
					$("#noid").show();
					$("#nopw").hide();
				}
			}
		}) // ajax 로그인 버튼 끝
	});
	   //패스워드에 커서를 두고 엔터키를 누르면 로그인 함
	   $("#pw").keydown(function(key) {
	      if (key.keyCode == 13) {
	         $("#logintest").click();
	      }
	   });
	   
	   //아이디에 커서를 두고 엔터키를 누르면 로그인 함
	   $("#id").keydown(function(key) {
	      if (key.keyCode == 13) {
		     $("#logintest").click();
	      }
	   });
	
});