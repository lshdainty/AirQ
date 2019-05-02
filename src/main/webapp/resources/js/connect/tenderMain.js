$(document).ready(function(){
	//리스트 클릭 시 세부 내용으로 이동
	$(document).on('click','.tenderLiContent',function(){
		var tindex=$(".tenderLiContent").index(this);
		var tcode=$(".tenderLiContent:eq("+tindex+")").attr('id');
		var query={
				tcode:tcode
		};
		
		$.ajax({
			type:"POST",
			url:"tMemberCheck",
			data:query,
			success:function(data){
				if(data=='s'){
					window.location.href="tenderContent/" + tcode;
				}else{
					alert("열람할 권한이 없습니다.");
				}
			}
		});
	});
});