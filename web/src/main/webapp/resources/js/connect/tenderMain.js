function sortdata(){
	var sort=$(".tenderSelect option:selected").val();
	return sort;
}

$("#tenderSelectDiv").change(function(){
	ajax(1,sortdata());
});

function page(idx){
	ajax(idx,sortdata());
}

function ajax(idx,sort){
	var data={
			sort:sort
	};
	
	$.ajax({
		type:"post",
		url:"/selectTender?pagenum="+idx,
		data:data,
		async:false,
		dataType:"json",
		success:function(data){
			var tenderList="";
			var page="";
			var result="";
			
			for(var i=0;i<data.tenderList.length;i++){
				
				tenderList+='<li class="tableListContent tenderLiContent post-item" id="'+data.tenderList[i].tender_code+'">'
					+'<div class="tableColumn tableCol-10-1" data-label="번호">'+data.tenderList[i].rownum+'</div>'
					+'<div class="tableColumn tableCol-30" data-label="제목">'+data.tenderList[i].tender_title+'</div>'
					+'<div class="tableColumn tableCol-15" data-label="글쓴이">'+data.tenderList[i].member_id+'</div>'
					+'<div class="tableColumn tableCol-15" data-label="등록일">'+data.tenderList[i].t_creation_date+'</div>'
					+'<div class="tableColumn tableCol-15" data-label="참여업체수">'+data.tenderList[i].company_count+'</div>'
					+'<div class="tableColumn tableCol-15" data-label="마감기한">'+data.tenderList[i].d_day+'</div>'
					+'</li>';
			}
			$(".tableListHeader").nextAll().remove();
			$(".tableList").append(tenderList);
			
			if(data.criteria.prev){
				page += '<li class="page-item"><a class="page-link" href="javascript:page('+(data.criteria.startPage-1)+');" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>'
			}
			for(var i=data.criteria.startPage; i<=data.criteria.endPage; i++){
				page += '<li class="page-item"><a class="page-link" href="javascript:page('+i+');">'+i+'</a></li>'
			}
			if(data.criteria.next){
				page += '<li class="page-item"><a class="page-link" href="javascript:page('+(data.criteria.endPage+1)+');" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>'
			}
			$(".pagination").empty();
			$(".pagination").prepend(page);
			$("html, body").animate({ scrollTop: 0 }, 1);
		}
	});
}

(function(){
	$.ajax({
		type:"post",
		url:"/tCheck",
		async:false,
		dataType:"json",
		success:function(data){
			if(data.member_devision == 'no'){
				var selectHtml='<select class="tenderSelect">'
								+'<option value="tTender">전체 글 보기</option>'
								+'<option value="mTender">내가 쓴 글 보기</option>'
								+'</select>';
				$("#tenderSelectDiv").append(selectHtml);
				
				var tenderWrite='<input type="submit" id="tenderWrite" class="tenderWriteBtn" name="tenderWrite" value="작성하기">';
				$("#tenderWriteDiv").append(tenderWrite);
			}
		}
	})
}());

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
					window.location.href="/tenderContentGo/" + tcode;
				}else{
					alert("열람할 권한이 없습니다.");
				}
			}
		});
	});
});