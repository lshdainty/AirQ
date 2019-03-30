$(document).ready(function(){
	
	$("#tenderWriteBtn").click(function(){
		
		var ttitle=$("#ttitle").val();
		var tname=$("#tname").val();
		var taddress=$("#taddress").val();
		var tmeasurementdate=$("#tmeasurementdate").val();
		var tdeadline=$("#tdeadline").val();
		var tfloorspace=$("#tfloorspace").val();
		var tlayers=$("#tlayers").val();
		var trequirement=$("#trequirement").val();
		
		var query={
				ttitle:ttitle,tname:tname,taddress:taddress,
				tmeasurementdate:tmeasurementdate,
				tdeadline:tdeadline,tfloorspace:tfloorspace,
				tlayers:tlayers,trequirement:trequirement
		};
		
		$.ajax({
			type:"POST",
			url:"/tenderWriteComplete",
			data:query,
			success:function(data){
				if(data == "f"){
					alert("insert 실패");
					return false;
				}else{
					window.location.href="/tenderMain";
				}
			}
		});
	});
});