$(document).ready(function(){
	$("#findidtest").click(function(){
		
		var query = {
				name : $("#name").val(),
				tel : $("#tel").val(),
				email : $("#email").val()
				
		}
		
		$.ajax({
			type : "POST",
			data : query,
			url : "findidajax",
			success : function(data){
				if(data != "fail" ){
					alert("당신의 아이디는 :"+ data);
					location.href = "loginMain";
				}else if(data == "fail"){
					alert("아이디 찾기 실패");
					
				}
			}
		})
	});
	
	$("#root").click(function(){
		if($("#root").prop("checked")){
		$("#tel").css("display","inline-block");
		$("#email").css("display","none");
		$("#root2").prop("checked",false);
		}else{
			$("#tel").css("display","none");
		}
	});
	
	$("#root2").click(function(){
		if($("#root2").prop("checked")){
		$("#email").css("display","inline-block");
		$("#tel").css("display","none");
		$("#root").prop("checked",false);
		}else{
			$("#email").css("display","none");
		}
	});
	
	   //이름에 커서를 두고 엔터키를 누르면 로그인 함
	   $("#name").keydown(function(key) {
	      if (key.keyCode == 13) {
	         $("#findidtest").click();
	      }
	   });
	   //전화번호에 커서를 두고 엔터키를 누르면 로그인 함
	   $("#tel").keydown(function(key) {
	      if (key.keyCode == 13) {
	    	  $("#findidtest").click();
	      }
	   });
	   //이메일에 커서를 두고 엔터키를 누르면 로그인 함
	   $("#email").keydown(function(key) {
	      if (key.keyCode == 13) {
		     $("#findidtest").click();
	      }
	   });
});