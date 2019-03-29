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
});