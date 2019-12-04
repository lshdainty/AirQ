$(document).ready(function(){
	$("#findpwtest").click(function(){
		
		var query = {
				name : $("#name").val(),
				id : $("#id").val(),
				tel : $("#tel").val(),
				email : $("#email").val()
				
		}
		$.ajax({
			type : "POST",
			data : query,
			url : "findpwajax",
			success : function(data){
				if(data != "fail" ){
					alert("당신의 비밀번호는 :"+ data);
					location.href = "loginMain";
				}else if(data == "fail"){
					alert("비밀번호 찾기 실패");
					
				}
			}
		})
	});
	$("#root").click(function(){
		if($("#root").prop("checked")){
		$("#tel").css("display","inline-block");
		}else{
			$("#tel").css("display","none");
		}
	});
	
	$("#root2").click(function(){
		if($("#root2").prop("checked")){
		$("#email").css("display","inline-block");
		}else{
			$("#email").css("display","none");
		}
	});
	
	   //이름에 커서를 두고 엔터키를 누르면 로그인 함
	   $("#name").keydown(function(key) {
	      if (key.keyCode == 13) {
	         $("#findpwtest").click();
	      }
	   });
	   
	   //아이디에 커서를 두고 엔터키를 누르면 로그인 함
	   $("#id").keydown(function(key) {
	      if (key.keyCode == 13) {
		     $("#findpwtest").click();
	      }
	   });
	   //전화번호에 커서를 두고 엔터키를 누르면 로그인 함
	   $("#tel").keydown(function(key) {
	      if (key.keyCode == 13) {
		     $("#findpwtest").click();
	      }
	   });
	   //이메일에 커서를 두고 엔터키를 누르면 로그인 함
	   $("#email").keydown(function(key) {
	      if (key.keyCode == 13) {
		     $("#findpwtest").click();
	      }
	   });
});