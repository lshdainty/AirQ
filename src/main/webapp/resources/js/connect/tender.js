/*$(document).ready(function(){
	$(document).on('click','#tenderDeleteBtn',function(){
		var result=confirm("삭제하시겠습니까?");
		if(result){
			var tcode=$("#tenderTbl tr:eq(0)").attr('id');
			window.location.href="/tenderDelete?tcode="+tcode;
		}else{
			return;
		}
	});
	
	$(document).on('click','#tenderModifyBtn',function(){
		var result=confirm("수정하시겠습니까?");
		if(result){
			var tcode=$("#tenderTbl tr:eq(0)").attr('id');
			window.location.href="/tenderModify?tcode="+tcode;
		}else{
			return;
		}
	});
});*/