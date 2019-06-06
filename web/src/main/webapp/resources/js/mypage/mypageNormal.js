(function(){
	$.ajax({
		type:"POST",
		url:"/mypageNormalPage",
		dataType:"json",
		async:true,
		success:function(data){
			var memberInfo="";
			var newPost="";
			var newReply="";
			var newPayment="";
			var reviewList="";
			console.log(data);
			
			memberInfo='<tr><td class="memberIdTd">아이디</td>'
				+'<td class="memberIdTd">'+data.memberInfo.member_id+'</td></tr>'
				+'<tr><td>이름</td>'
				+'<td>'+data.memberInfo.member_name+'</td></tr>'
				+'<tr><td>전화번호</td>'
				+'<td>'+data.memberInfo.member_tel+'</td></tr>'
				+'<tr><td>주소</td>'
				+'<td>'+data.memberInfo.m_road_addr+' '+data.memberInfo.m_addr_detail+'</td></tr>'
				+'<tr><td>이메일</td>'
				+'<td>'+data.memberInfo.member_email+'</td></tr>'
				+'<tr><td>회원 구분</td>'
				+'<td>일반 사용자</td></tr>';
			
			for(var i=0; i<data.newPostList.length;i++){
				newPost+='<tr>'
					+'<td>'+data.newPostList[i].DIVISION+'</td>'
					+'<td>'+data.newPostList[i].TITLE+'</td>'
					+'<td>'+data.newPostList[i].NAL+'</td>'
					+'</tr>';
			}
			
			for(var i=0; i<data.newReplyList.length;i++){
				newReply+='<tr>'
					+'<td>'+data.newReplyList[i].BOARD_NAME+'</td>'
				    +'<td>'+data.newReplyList[i].POST_TITLE+'</td>'
					+'<td>'+data.newReplyList[i].REPLY_CONTENT+'</td>'
					+'<td>'+data.newReplyList[i].R_CREATION_DATE+'</td>'
					+'</tr>';
			}
			
			for(var i=0; i<data.newPaymentList.length;i++){
				newPayment+='<tr>'
					+'<td>'+data.newPaymentList[i].DEVISION+'</td>'
				    +'<td>'+data.newPaymentList[i].TITLE+'</td>'
					+'<td>'+data.newPaymentList[i].P_DATE+'</td>'
					+'<td>'+data.newPaymentList[i].PRICE+'</td>'
					+'</tr>';
			}
			
			$("#memberInfoTbl").append(memberInfo);
			$("#newPostTbl").append(newPost);
			$("#newReplyTbl").append(newReply);
			$("#newPaymentTbl").append(newPayment);
			
			for(var i=0;i<data.reviewCompareList.length;i++){
				reviewList+='<div class="reviewPost" id="'+data.reviewCompareList[i].payment_code+'">'
						+'<div class="compareThumb">'
							+'<img src="resources/images/800490.png" alt="이미지">'
						+'</div>'
						+'<div class="reviewInfo">'
							+'<div class="reviewTitle">'
								+'<span>'+data.reviewCompareList[i].product_name+'</span>'
							+'</div>'
							+'<div class="reviewContent">'
								+'서비스 받은 날짜 : <span>'+data.reviewCompareList[i].d_service_date+'</span>'
							+'</div>'
						+'</div>'
						+'<div class="reviewPrice">'
							+'<span>'+data.reviewCompareList[i].product_price+'</span>'
						+'</div>'
					+'</div>';
			}
			$("#reviewList").append(reviewList);
		}
	});
}());

$(document).ready(function(){
	
	$(document).on('click','.reviewPost',function(){
		var code=$(this).attr('id');
		window.open('/reviewWrite?code='+code,'review',"width=570px, height=300px");
	});
	
	$(document).on('click','.rCategoryOption',function(){
		$(".rOptionActive").removeClass("rOptionActive");
		$("#reviewCategory").find(this).addClass("rOptionActive");
		var id=$(".rOptionActive").attr('id');
		
		$.ajax({
			type:"POST",
			url:"/reviewList",
			dataType:"json",
			async:true,
			success:function(data){
				var html="";
				if(id=='tender'){
				for(var i=0;i<data.reviewTenderList.length;i++){
					html+='<div class="reviewPost" id="'+data.reviewTenderList[i].payment_code+'">'
							+'<div class="reviewInfo">'
								+'<div class="reviewTitle">'
									+'<span>'+data.reviewTenderList[i].tender_title+'</span>'
								+'</div>'
								+'<div class="reviewContent">'
									+'서비스 받은 날짜 : <span>'+data.reviewTenderList[i].service_date+'</span>'
								+'</div>'
							+'</div>'
							+'<div class="reviewPrice">'
								+'<span>'+data.reviewTenderList[i].payment_price+'</span>'
							+'</div>'
						+'</div>';
				}
				}else {
					for(var i=0;i<data.reviewCompareList.length;i++){
						html+='<div class="reviewPost" id="'+data.reviewCompareList[i].payment_code+'">'
								+'<div class="compareThumb">'
									+'<img src="resources/images/800490.png" alt="이미지">'
								+'</div>'
								+'<div class="reviewInfo">'
									+'<div class="reviewTitle">'
										+'<span>'+data.reviewCompareList[i].product_name+'</span>'
									+'</div>'
									+'<div class="reviewContent">'
										+'서비스 받은 날짜 : <span>'+data.reviewCompareList[i].d_service_date+'</span>'
									+'</div>'
								+'</div>'
								+'<div class="reviewPrice">'
									+'<span>'+data.reviewCompareList[i].product_price+'</span>'
								+'</div>'
							+'</div>';
					}
				}
				$(".reviewPost").remove();
				$("#reviewList").append(html);
			}
		});
	});
});