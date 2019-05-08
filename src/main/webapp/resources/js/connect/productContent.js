$(document).ready(function() {
	var windowObj;
    $("#paymentButton").click(function(){
    	var product_code = $("#product_code").text().split(':')
    	windowObj = window.open("/cPayment/"+product_code[1].trim(),"test","width=570, height=350");
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
});