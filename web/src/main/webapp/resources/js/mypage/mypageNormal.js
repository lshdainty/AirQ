$(document).ready(function(){
	
	$.ajax({
		type:"POST",
		url:"/reviewList",
		dataType:"json",
		async:true,
		success:function(data){
			var html="";
			console.log(data);
			for(var i=0;i<data.reviewCompareList.length;i++){
				html+='<div class="reviewPost">'
						+'<div class="compareThumb">'
							+'<img src="resources/images/800490.png" alt="이미지">'
						+'</div>'
						+'<div class="reviewInfo">'
							+'<div class="reviewTitle">'
								+'<span>'+data.reviewCompareList[i].product_name+'</span>'
							+'</div>'
							+'<div class="reviewContent">'
								+'측정 평수 : <span>'+data.reviewCompareList[i].p_space+'</span><br/>'
								+'측정 지점 : <span>'+data.reviewCompareList[i].measure_point+'</span><br/>'
								+'측정 물질 : <span>포름알데하이드, 미세먼지, 일산화탄소</span><br/>'
								+'서비스 받은 날짜 : <span>'+data.reviewCompareList[i].d_service_date+'</span>'
							+'</div>'
							+'<div class="reviewPrice">'
								+'<span>'+data.reviewCompareList[i].product_price+'</span>'
							+'</div>'
						+'</div>'
					+'</div>';
			}
			$("#reviewList").append(html);
		}
	});
	
	$(document).on('click','#btn',function(){
		window.open('/reviewWrite','review',"width=570px, height=300px");
	});
	
	$(document).on('click','.rCategoryOption',function(){
		$(".rOptionActive").removeClass("rOptionActive");
		$("#reviewCategory").find(this).addClass("rOptionActive");
	});
});