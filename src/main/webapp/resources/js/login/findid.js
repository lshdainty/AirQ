$(document).ready(function(){
	$("#findidtest").click(function(){
		alert($("#name").val());
		alert($("#tel").val());
		alert($("#email").val());
		
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
				alert("여까지옴");
				console.log(data);
				if(data != "fail" ){
					alert("성공?");
					alert("당신의 아이디는 :"+ data);
					location.href = "loginMain";
				}else if(data == "fail"){
					alert("아이디 찾기 실패");
					
				}
			}
		})
	});
});