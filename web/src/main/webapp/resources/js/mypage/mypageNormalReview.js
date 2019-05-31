$(document).on('click','#reviewButton',function(){
	var reviewContent=$("#reviewContent").val();
	var reviewStar=$("#reviewStar").val();
	var code=$("#code").val();
	var query={
			reviewContent:reviewContent,
			reviewStar:reviewStar,
			code:code
	};
		
	$.ajax({
		type:"post",
		url:"/reviewWriteComplete",
		data:query,
		success:function(data){
			alert("등록되었습니다.");
			window.opener.location.reload();
			window.close();
		}
	});
});