var ip = sessionStorage.getItem('IP_ADDRESS');
var user = JSON.parse(sessionStorage.getItem("user"));
var member_id = user.member_id;

(function(){
	$.ajax({
		type:"post",
		data:{member_id:member_id},
		url:ip+"/m.tCheck",
		async:false,
		dataType:"json",
		success:function(data){
			console.log(data);
			if(data.member_devision == 'no'){
				var selectHtml='<select class="tenderSelect">'
								+'<option value="tTender">전체 글 보기</option>'
								+'<option value="mTender">내가 쓴 글 보기</option>'
								+'</select>';
				$("#tenderSelectDiv").append(selectHtml);
				
				var tenderWrite='<button id="tenderWrite" class="connectWriteBtn" name="tenderWrite">작성하기</button>';
				$("#tenderSelectDiv").append(tenderWrite);
			}
		}
	})
}());

	//리스트 클릭 시 세부 내용으로 이동
	$(document).on('click','.tenderLiContent',function(){
		var tindex=$(".tenderLiContent").index(this);
		var tcode=$(".tenderLiContent:eq("+tindex+")").attr('id');
		window.location.href="tenderContent/" + tcode;
		
	});