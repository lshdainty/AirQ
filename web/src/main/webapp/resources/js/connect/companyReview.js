(function(){
	var company_code=$("#company_code").val();
	var query={
			company_code:company_code
	};
	
	$.ajax({
		type:"post",
		url:"/companyReview",
		data:query,
		dataType:"json",
		success:function(data){
			console.log(data);
			var html="";
			var info="";
			var star="";
			
			
			info='<div>'
					+'<p id="companyName">'+data.company_info.company_name+'</p>'
					+'<p id="reviewAndStar">총 리뷰 '+data.company_info.reviewNum+'개 | 별점 평균 '+data.company_info.star_score_avg+'점</p>'
				+'</div>';
			
			$("#cReviewDiv").prepend(info);
			for(var i=0;i<data.companyReview.length;i++){
				for(var j=0;j<data.companyReview[i].STAR_SCORE;j++){
					star+="★";
				}
				
				html+='<div class="companyReview">'
						+'<p class="reviewId">'
							+data.companyReview[i].MEMBER_ID
							+'<span class="reviewDate">  '+data.companyReview[i].R_CREATION_DATE+'</span>'
						+'</p>'
						+'<p class="memberStar">'
							+'별점'+ data.companyReview[i].STAR_SCORE +'<span class="star">'+star+'</span>'
						+'</p>'
						+'<div class="reviewText">'
							+'<p>'+data.companyReview[i].REPLY_CONTENT+'</p>'
						+'</div>'
					+'</div>';
				
				star="";
			}
			
			$("#cReviewDiv").append(html);
		}
	});
}());