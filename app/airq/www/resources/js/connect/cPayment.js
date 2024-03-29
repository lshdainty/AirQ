﻿$(function() {
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
			}
			$('#sido_code').html(html);
		},
		error: function(xhr, stat, err) {}
	});

	$(document).on("change","#sido_code",function(){
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
				}
				$('#sigoon_code').html(html);	
			},
			error: function(xhr, stat, err) {}
		});
	});

	 $(document).on("change","#sigoon_code",function(){ 
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
        		 }
        		 $('#sidong_code').html(html);
    		 },
    		 error: function(xhr, stat, err) {}
    	 });
     });
	
	$(".select").change(function(){
		$("#d_addr_do").val($("#sido_code option:selected").text());
		$("#d_addr_si").val($("#sigoon_code option:selected").text());
		$("#d_addr_dong").val($("#sidong_code option:selected").text());
	});
	
	$("#cOrder").click(function(){
		var query = {
			product_code : $("#product_code").val(),
			payment_price : $("#payment_price").val(),
			d_addr_do : $("#sido_code option:selected").text(),
			d_addr_si : $("#sigoon_code option:selected").text(),
			d_addr_dong : $("#sidong_code option:selected").text(),
			d_addr_detail : $("#d_addr_detail").val(),
			d_service_date : $("#d_service_date").val().replace("T"," ")+':00.0',
		}
		$.ajax({
			type: "post",
			url: "/cOrder",
			data : query,
			success: function(data) {
				alert("주문을 완료하였습니다. 주문코드 : " + data);
				window.close();
			},
			error: function(xhr, stat, err) {
			}
		});
	});
});