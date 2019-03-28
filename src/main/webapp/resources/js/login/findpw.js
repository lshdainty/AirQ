$(document).ready(function(){
	$("#findpwtest").click(function(){
		alert($("#name").val());
		alert($("#id").val());
		alert($("#tel").val());
		alert($("#email").val());
		
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
				alert("여까지옴");
				console.log(data);
				if(data != "fail" ){
					alert("성공?");
					alert("당신의 비밀번호는 :"+ data);
					location.href = "loginMain";
				}else if(data == "fail"){
					alert("비밀번호 찾기 실패");
					
				}
			}
		})
	});
});