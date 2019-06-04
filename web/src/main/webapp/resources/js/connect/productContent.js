$(document).ready(function() {
	var windowObj;
    $("#paymentButton").click(function(){
    	var product_code = $("#product_code").text();
    	windowObj = window.open("/cPayment?product_code="+product_code.trim(),"payment","width=570, height=350");
    });
    
    $("#reportButton").click(function(){
    	var product_code = $("#product_code").text();
    	//기존에 신고한 내용이 있는지 확인
    	$.ajax({
    		type: "get",
    		url: "/checkReport",
    		data : {original_code : product_code.trim()},
    		async: false,
    		success: function(data) {
    			if(data=="success"){
    				windowObj = window.open("/report?original_code="+product_code.trim(),"report","width=570px, height=600px");
    			}else{
    				alert("신고는 한번만 가능합니다.");
    			}
    		},
    		error: function(xhr, stat, err) {}
    	});
    });
    
    $("#productModify").click(function(){
    	var product_code = $("#product_code").text();
    	$.ajax({
    		type: "get",
    		url: "/permissionCheck",
    		data : {product_code : product_code.trim()},
    		async: false,
    		success: function(data) {
    			if(data=="success"){
    				window.location.href="/productModify?product_code="+product_code.trim();
    			}else{
    				alert("권한이 없습니다.");
    			}
    		},
    		error: function(xhr, stat, err) {}
    	});
    });
    
    $("#productDelete").click(function(){
    	var product_code = $("#product_code").text();
    	$.ajax({
    		type: "get",
    		url: "/permissionCheck",
    		data : {product_code : product_code.trim()},
    		async: false,
    		success: function(data) {
    			if(data=="success"){
    				window.location.href="/productDelete?product_code="+product_code.trim();
    			}else{
    				alert("권한이 없습니다.");
    			}
    		},
    		error: function(xhr, stat, err) {}
    	});
    });
    
    $(document).on("click",".reply-delete",function(){
    	var product_code = $("#product_code").text();
    	var reply_code = $(this).next().val();
    	var query = {
    			product_code : product_code.trim(),
    			reply_code : reply_code
    	}
    	$.ajax({
    		type: "get",
    		url: "/productReplyDelete",
    		data : query,
    		async: false,
    		dataType: "json",
    		success: function(data) {
    			$("#reply_count").text(data.reply_count);
    			var html = "";
    			for(var i=0; i<data.productReply.length; i++){
    				var r_creation_date = getTimeStamp(data.productReply[i].r_creation_date.time);
    				html = html + '<div class="comment-list">'+
									'<div class="comment-l">'+
										'<div class="comment">'+
											'<div class="comment-meta">'+
												'<span class="comment__name"><a href="#">'+data.productReply[i].member_id+'</a></span>'+
												'<span class="comment__date"> '+r_creation_date+'</span>'+
											'</div>'+
											'<div class="comment-content">'+
												'<div><p><br>'+data.productReply[i].reply_content+'</p></div>'+
											'</div>';
    										if(data.member_id==data.productReply[i].member_id){
    											html = html + '<div class="comment-button">'+
																'<button class="comment__button comment__button--red reply-delete">삭제</button>'+
																'<input type="hidden" class="reply_code" value="'+data.productReply[i].reply_code+'">'+
															   '</div>';
    										}
    					html = html + '</div>'+
									'</div>'+
								'</div>';
    			}
    			$("#replys").empty();
    			$("#replys").append(html);
    		},
    		error: function(xhr, stat, err) {}
    	});
    });
});

// object인 timestamp 타입변환하는 함수 시작
function getTimeStamp(time) {
	  var d = new Date(time);

	  var s =
	    leadingZeros(d.getFullYear(), 4) + '-' +
	    leadingZeros(d.getMonth() + 1, 2) + '-' +
	    leadingZeros(d.getDate(), 2) + ' ' +

	    leadingZeros(d.getHours(), 2) + ':' +
	    leadingZeros(d.getMinutes(), 2) + ':' +
	    leadingZeros(d.getSeconds(), 2) + '.0';

	  return s;
}

function leadingZeros(n, digits) {
	 var zero = '';
	 n = n.toString();

	 if (n.length < digits) {
	    for (i = 0; i < digits - n.length; i++)
	      zero += '0';
	 }
	 return zero + n;
}
//object인 timestamp 타입변환하는 함수 끝