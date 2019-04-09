$(function(){
	$.ajax({
		type: "get",
		url: "http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admCodeList.json",
		data : {authkey : $('#sido_key').val()},
		async: false,
		dataType: 'json',
		success: function(data) {
			var html = "<option>선택</option>";
		
			for(var i=0;i<data.admVOList.admVOList.length;i++){ 
				html +="<option value='"+data.admVOList.admVOList[i].admCode+"'>"+data.admVOList.admVOList[i].lowestAdmCodeNm+"</option>"
				console.log(data.admVOList.admVOList[i].admCode);
			}
			$('#t_addr_do_').html(html);
		},
		error: function(xhr, stat, err) {}
	});

	$(document).on("change","#t_addr_do_",function(){
		var thisVal = $(this).val();
	
		$.ajax({
			type: "get",
			url: "http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admSiList.json",
			data : {admCode : thisVal, authkey : $('#sigoon_key').val()},
			async: false,
			dataType: 'json',
			success: function(data) {
				var html = "<option>선택</option>";
			
				for(var i=0;i<data.admVOList.admVOList.length;i++){ 
					html +="<option value='"+data.admVOList.admVOList[i].admCode+"'>"+data.admVOList.admVOList[i].lowestAdmCodeNm+"</option>"
					console.log(data.admVOList.admVOList[i].admCode);
				}
				$('#t_addr_si_').html(html);	
			},
			error: function(xhr, stat, err) {}
		});
	});

	 $(document).on("change","#t_addr_si_",function(){ 
    	 var thisVal = $(this).val();

    	 $.ajax({
    		 type: "get",
    		 url: "http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admDongList.json",
    		 data : {admCode : thisVal, authkey : $('#dong_key').val()},
    		 async: false,
    		 dataType: 'json',
    		 success: function(data) {
        		 var html = "<option>선택</option>";
			
        		 for(var i=0;i<data.admVOList.admVOList.length;i++){ 
            		 html +="<option value='"+data.admVOList.admVOList[i].admCode+"'>"+data.admVOList.admVOList[i].lowestAdmCodeNm+"</option>"
            		 console.log(data.admVOList.admVOList[i].admCode);
        		 }
        		 $('#t_addr_dong_').html(html);
    		 },
    		 error: function(xhr, stat, err) {}
    	 });
     });
	 
	 $(document).on('click','#tenderWriteBtn',function(){
		 var t_addr_do=$("#t_addr_do_ option:selected").text();
		 var t_addr_si=$("#t_addr_si_ option:selected").text();
		 var t_addr_dong=$("#t_addr_dong_ option:selected").text();
		 var t_addr_detail=$("#t_addr_detail").val();
		 
		 
		 $("#t_addr_do").val(t_addr_do);
		 $("#t_addr_si").val(t_addr_si);
		 $("#t_addr_dong").val(t_addr_dong);
		 
		 /* var query={
				 t_addr_do:t_addr_do,t_addr_si:t_addr_si,
				 t_addr_dong:t_addr_dong,t_addr_detail:t_addr_detail
		 };
		 
		 $.ajax({
			 type:"post",
			 url:"tenderWriteComplete",
			 data:query,
			 success:function(data){
				 
			 }
		 });*/
	 });
});