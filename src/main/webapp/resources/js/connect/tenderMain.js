$(document).ready(function(){
	//리스트 클릭 시 세부 내용으로 이동
	$(document).on('click','.tenderLiContent',function(){
		var tindex=$(".tenderLiContent").index(this);
		var tcode=$(".tenderLiContent:eq("+tindex+")").attr('id');
		
		window.location.href="tenderContent/" + tcode;
		
	});
});