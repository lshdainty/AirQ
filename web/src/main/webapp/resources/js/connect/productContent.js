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
    	var removeTarget = $(this).parent().parent();
    	var reply_code = $(this).next().val();
    	var query = {
    			reply_code : reply_code
    	}
    	$.ajax({
    		type: "get",
    		url: "/productReplyDelete",
    		data : query,
    		success: function(data) {	
    			removeTarget.remove();
    		},
    		error: function(xhr, stat, err) {}
    	});
    });
    
    $('.detail_tab').click(function() {
		var offset = $('.cont_product').offset();
		console.log(offset);
		$('html, body').animate({
			scrollTop : offset.top - 66
		});
	});
    
	$('.review_tab').click(function() {
		var offset = $('.cont_review').offset();
		console.log(offset);
		$('html, body').animate({
			scrollTop : offset.top - 66
		});
	});
});

function fnMove(seq) {
	var offset = $("#div" + seq).offset();
	$('html, body').animate({
		scrollTop : offset.top
	}, 400);
}

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