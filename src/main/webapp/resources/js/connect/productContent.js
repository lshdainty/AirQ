$(document).ready(function() {
	var windowObj;
    $("#paymentButton").click(function(){
    	windowObj = window.open("/test","자식창");
    	windowObj.document.getElementById("childText").value = document.getElementById("product_name").value;
    });
});

