var ip = sessionStorage.getItem('IP_ADDRESS');
var user = JSON.parse(sessionStorage.getItem("user"));
var member_id = user.member_id;

//입찰 페이지 메인화면 입찰 리스트 가져오기
(function(){
	$.ajax({
		type:"post",
		data:{member_id:member_id},
		url:ip+"/m.tenderMain",
		async:false,
		dataType:"json",
		success:function(data){
			console.log(data);
			var page="";
			if(data.member_devision == 'no'){
				var selectHtml='<select class="tenderSelect">'
				 	+'<option value="tTender">전체 글 보기</option>'
				 	+'<option value="mTender">내가 쓴 글 보기</option>'
				 	+'</select>';
				$("#tenderSelectDiv").append(selectHtml);
								
				var tenderWrite='<button id="tenderWrite" class="connectWriteBtn" name="tenderWrite">작성하기</button>';
				 $("#tenderSelectDiv").append(tenderWrite);

				 var tenderList='';
				 for(var i=0;i<data.tenderList.length;i++){
					 tenderList+='<div class="post-info">'
					 +'<div class="connect-post">'
						 +'<div class="post-explain">'
							 +'<div class="post-subPost">'
							 +'<div class="post-subTitle">요청일</div>'
							+'<div class="post-subContent">'+data.tenderList[i].service_date+'</div>'
							+'</div>'
							 +'<div class="post-subPost">'
							 +'<div class="post-subTitle">입찰명</div>'
								 +'<div class="post-subContent">'+data.tenderList[i].tender_title+'</div>'
								 +'</div>'
							+'</div>'
						+'<button class="post-detailBtn"></button>'
						+'</div>'
					+'<div class="post-detail" style="display: none">'
					+'<div class="detail-info">'
						+'<div class="detail-subPost">'
							+'<div class="detail-subTitle">입찰번호</div>'
								+'<div class="detail-subContent">'+data.tenderList[i].tender_code+'</div>'
								 +'</div>'
							 +'<div class="detail-subPost">'
							 +'<div class="detail-subTitle">입찰자</div>'
								 +'<div class="detail-subContent">'+data.tenderList[i].tender_name+'</div>'
								 +'</div>'
							 +'</div>'
						 +'</div>'
				 +'</div>';
				 
				 }
				 $("#tenderListDiv").append(tenderList);

				 if(data.criteria.prev){
					page += '<li class="page-item"><a class="page-link" href="javascript:tpage('+(data.criteria.startPage-1)+');" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>'
				}
				for(var i=data.criteria.startPage; i<=data.criteria.endPage; i++){
					page += '<li class="page-item"><a class="page-link" href="javascript:tpage('+i+');">'+i+'</a></li>'
				}
				if(data.criteria.next){
					page += '<li class="page-item"><a class="page-link" href="javascript:tpage('+(data.criteria.endPage+1)+');" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>'
				}
				$(".tpagination").empty();
				$(".tpagination").prepend(page);
				$("html, body").animate({ scrollTop: 0 }, 1);
			}
		}
	})
}());

function tsortdata(){
	var sort=$(".tenderSelect option:selected").val();
	return sort;
}

$(".tenderSelect").change(function(){
	tajax(1,tsortdata());
});

function tpage(idx){
	tajax(idx,tsortdata());
}

function tajax(idx,sort){
	var data={
			sort:sort,
			member_id:member_id
	};
	
	$.ajax({
		type:"post",
		url:ip+"/m.selectTender?pagenum="+idx,
		data:data,
		async:false,
		dataType:"json",
		success:function(data){
			var tenderList="";
			var page="";
			var result="";

			for(var i=0;i<data.tenderList.length;i++){
				
				tenderList+='<div class="post-info">'
					 +'<div class="connect-post">'
						 +'<div class="post-explain">'
							 +'<div class="post-subPost">'
							 +'<div class="post-subTitle">요청일</div>'
							+'<div class="post-subContent">'+data.tenderList[i].service_date+'</div>'
							+'</div>'
							 +'<div class="post-subPost">'
							 +'<div class="post-subTitle">입찰명</div>'
								 +'<div class="post-subContent">'+data.tenderList[i].tender_title+'</div>'
								 +'</div>'
							+'</div>'
						+'<button class="post-detailBtn"></button>'
						+'</div>'
					+'<div class="post-detail" style="display: none">'
					+'<div class="detail-info">'
						+'<div class="detail-subPost">'
							+'<div class="detail-subTitle">입찰번호</div>'
								+'<div class="detail-subContent">'+data.tenderList[i].tender_code+'</div>'
								 +'</div>'
							 +'<div class="detail-subPost">'
							 +'<div class="detail-subTitle">입찰자</div>'
								 +'<div class="detail-subContent">'+data.tenderList[i].tender_name+'</div>'
								 +'</div>'
							 +'</div>'
						 +'</div>'
				 +'</div>';
			}
			$("#tenderListDiv").children().remove();
			$("#tenderListDiv").append(tenderList);
			
			if(data.criteria.prev){
				page += '<li class="page-item"><a class="page-link" href="javascript:tpage('+(data.criteria.startPage-1)+');" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>'
			}
			for(var i=data.criteria.startPage; i<=data.criteria.endPage; i++){
				page += '<li class="page-item"><a class="page-link" href="javascript:tpage('+i+');">'+i+'</a></li>'
			}
			if(data.criteria.next){
				page += '<li class="page-item"><a class="page-link" href="javascript:tpage('+(data.criteria.endPage+1)+');" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>'
			}
			$(".tpagination").empty();
			$(".tpagination").prepend(page);
			$("html, body").animate({ scrollTop: 0 }, 1);
			//pAnimation();
		}
	});
}

// (function(){
// 	$.ajax({
// 		type:"post",
// 		data:{member_id:member_id},
// 		url:ip+"/m.tCheck",
// 		async:false,
// 		dataType:"json",
// 		success:function(data){
// 			console.log(data);
// 			if(data.member_devision == 'no'){
// 				var selectHtml='<select class="tenderSelect">'
// 								+'<option value="tTender">전체 글 보기</option>'
// 								+'<option value="mTender">내가 쓴 글 보기</option>'
// 								+'</select>';
// 				$("#tenderSelectDiv").append(selectHtml);
				
// 				var tenderWrite='<button id="tenderWrite" class="connectWriteBtn" name="tenderWrite">작성하기</button>';
// 				$("#tenderSelectDiv").append(tenderWrite);
// 			}
// 		}
// 	})
// }());

	//리스트 클릭 시 세부 내용으로 이동
	$(document).on('click','.tenderLiContent',function(){
		var tindex=$(".tenderLiContent").index(this);
		var tcode=$(".tenderLiContent:eq("+tindex+")").attr('id');
		var query={
				tcode:tcode
		};
		
		$.ajax({
			type:"POST",
			url:"/tMemberCheck",
			data:query,
			success:function(data){
				if(data=='s'){
					window.location.href="/tenderContent/" + tcode;
				}else{
					alert("열람할 권한이 없습니다.");
				}
			}
		});
	});