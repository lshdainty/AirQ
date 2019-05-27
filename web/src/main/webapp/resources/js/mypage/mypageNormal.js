$(document).ready(function(){
	
	$.ajax({
		type:"POST",
		url:"/reviewList",
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		async:true,
		success:function(data){
			
			
			var html="";
			console.log(data);
			/*for(var i=0;i<data.length;i++){
				html+='<div class="reviewPost">'
						+'<div class="compareThumb">'
							+'<img src="resources/images/800490.png" alt="이미지">'
						+'</div>'
						+'<div class="reviewInfo">'
							+'<div class="compareTitle">'
								+'<span>'+data[i].product_name+'</span>'
							+'</div>'
							+'<div class="compareContent">'
								+'측정 평수 : <span>'+data[i].p_space+'</span><br/>'
								+'측정 지점 : <span>'+data[i].measure_point+'</span><br/>'
								+'측정 물질 : <span>포름알데하이드, 미세먼지, 일산화탄소</span><br/>'
								+'서비스 받은 날짜 : <span>'+data[i].d_service_date+'</span>'
							+'</div>'
							+'<div class="comparePrice">'
								+'<span>'+data[i].product_price+'</span>'
							+'</div>'
						+'</div>'
					+'</div>';
			}
			$("#h1").append(html);*/
		}
	});
	
	$(document).on('click','#btn',function(){
		window.open('/reviewWrite','review',"width=570px, height=300px");
	});
});