$(document).ready(function(){
	$(document).on('click','#reportButton',function(){
		var report_title=$("#report_title").val();
		var report_content=$("#report_content").val();
		var tender_code=$("#tender_code").val();
		var query={
				report_title:report_title,
				report_content:report_content,
				tender_code:tender_code.split("=")[1]
		};
		
		$.ajax({
			type:"post",
			data:query,
			url:"/addReport",
			success:function(){
				alert("신고가 접수되었습니다.");
				window.close();
			}
		});
	});
});