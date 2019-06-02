/**
 * 
 */
$(document).ready(function(){
	$("#btn-reg").click(function(){
		location.href="remoteRegist";
	});
	
	// ON, OFF 클릭시
	$(".onOff").click(function(){
		alert($(this).is(":checked"));

		$.ajax({
			type : "POST",
			contentType: "application/json;charset=UTF-8",
			url : "/iotOnOff",
			data : JSON.stringify({
				switch : $(this).is(":checked")
			}),
			dataType : "json",
			success : function(data){
				console.log(data);
				if($(this).is(":checked") == true){
					alert("ON클릭");
					
				}else if($(this).is(":checked") == false){
					alert("OFF클릭");
				}
				location.href="/test"
			}
			
		});
		
	});
});	// document