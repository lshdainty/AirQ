$(document).ready(function() {
	var windowObj;
    $("#paymentButton").click(function(){
    	var product_code = $("#product_code").text().split(':')
    	windowObj = window.open("/cPayment/"+product_code[1].trim(),"test","width=570, height=350");
    });
});