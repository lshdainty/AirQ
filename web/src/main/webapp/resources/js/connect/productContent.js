$(document).ready(function() {
	var windowObj;
    $("#paymentButton").click(function(){
    	var product_code = $("#product_code").text().split(':');
    	windowObj = window.open("/cPayment?product_code="+product_code[1].trim(),"payment","width=570, height=350");
    });
    
    $("#reportButton").click(function(){
    	var product_code = $("#product_code").text().split(':');
    	//기존에 신고한 내용이 있는지 확인
    	$.ajax({
    		type: "get",
    		url: "/checkReport",
    		data : {original_code : product_code[1].trim()},
    		async: false,
    		success: function(data) {
    			if(data=="success"){
    				windowObj = window.open("/report?original_code="+product_code[1].trim(),"report","width=570px, height=600px");
    			}else{
    				alert("신고는 한번만 가능합니다.");
    			}
    		},
    		error: function(xhr, stat, err) {}
    	});
    });
    
    $("#productModify").click(function(){
    	var product_code = $("#product_code").text().split(':');
    	$.ajax({
    		type: "get",
    		url: "/permissionCheck",
    		data : {product_code : product_code[1].trim()},
    		async: false,
    		success: function(data) {
    			if(data=="success"){
    				window.location.href="/productModify?product_code="+product_code[1].trim();
    			}else{
    				alert("권한이 없습니다.");
    			}
    		},
    		error: function(xhr, stat, err) {}
    	});
    });
    
    $("#productDelete").click(function(){
    	var product_code = $("#product_code").text().split(':');
    	$.ajax({
    		type: "get",
    		url: "/permissionCheck",
    		data : {product_code : product_code[1].trim()},
    		async: false,
    		success: function(data) {
    			if(data=="success"){
    				window.location.href="/productDelete?product_code="+product_code[1].trim();
    			}else{
    				alert("권한이 없습니다.");
    			}
    		},
    		error: function(xhr, stat, err) {}
    	});
    });
    
    $("#reply-insert").click(function(){
    	var product_code = $("#product_code").text().split(':');
    	var query = {
    			member_id : $("#member_id").text(),
    			reply_content : $("#reply_content").val(),
    			product_code : product_code[1].trim()
    	}
    	$.ajax({
    		type: "get",
    		url: "/productReplyInsert",
    		data : query,
    		async: false,
    		success: function(data) {
    			alert("돌아왔다.");
    			if(data=="success"){
    				alert("성공");
    			}else{
    				alert("상품을 구매한 사람만 작성 가능합니다.");
    			}
    		},
    		error: function(xhr, stat, err) {}
    	});
    });
});