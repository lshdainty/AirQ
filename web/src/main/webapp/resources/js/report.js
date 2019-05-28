$(document).ready(function(){
	$("#reportSubmit").click(function(){
		if($("#report_title").val()==""||$("#report_title").val()==null){
			alert("제목을 입력해주세요");
			return false;
		}else if($("#report_content").val()==""||$("#report_content").val()==null){
			alert("내용을 입력해주세요");
			return false;
		}else{
			var query = {
					original_code : $("#original_code").val(),
					report_title : $("#report_title").val(),
					report_content : $("#report_content").val()
			}
			$.ajax({
				type: "post",
				url: "/insertReport",
				data : query,
				success: function(data) {
					if(data=="success"){
						alert("신고가 완료되었습니다.");
						window.close();
					}							
				},
				error: function(xhr, stat, err) {
				}
			});
		}
	});
			
	$("#reportCancel").click(function(){
		window.close();
	});
});