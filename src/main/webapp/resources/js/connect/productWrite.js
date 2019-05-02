var editorConfig = {
		filebrowserUploadUrl : "imageUpload", //이미지 업로드
};
$(function() {
	CKEDITOR.replace(
					'product_content',
					{//해당 이름으로 된 textarea에 에디터를 적용
						width : '100%',
						height : '50vh',
						filebrowserImageUploadUrl : "${pageContext.request.contextPath}/imageUpload" //여기 경로로 파일을 전달하여 업로드 시킨다.
					});
	CKEDITOR.on('dialogDefinition', function(ev) {
		var dialogName = ev.data.name;
		var dialogDefinition = ev.data.definition;

		switch (dialogName) {
		case 'image': //Image Properties dialog
			//dialogDefinition.removeContents('info');
			dialogDefinition.removeContents('Link');
			dialogDefinition.removeContents('advanced');
			break;
		}
	});
	
	$.ajax({
		type: "get",
		url: "http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admCodeList.json",
		data : {authkey : $('#sido_key').val()},
		async: false,
		dataType: 'json',
		success: function(data) {
			var html = "<option>광역시/도</option>";
		
			for(var i=0;i<data.admVOList.admVOList.length;i++){ 
				html +="<option value='"+data.admVOList.admVOList[i].lowestAdmCodeNm+"'>"+data.admVOList.admVOList[i].lowestAdmCodeNm+"</option>"
			}
			$('#sido_code').html(html);
		},
		error: function(xhr, stat, err) {}
	});

	$(document).on("change","#sido_code",function(){
		var thisVal = $(this).val();
	
		$.ajax({
			type: "get",
			url: "/areasido",
			data : {area_do : thisVal},
			async: false,
			dataType: 'json',
			success: function(data) {
				var html = "<option>시/구</option>";
			
				for(var i=0;i<data.aList.length;i++){ 
					html +="<option value='"+data.aList[i].area_si+"'>"+data.aList[i].area_si+"</option>"
				}
				$('#sigoon_code').html(html);	
			},
			error: function(xhr, stat, err) {}
		});
	});
});

$("#areaAdd").click(function(){
	var sido = $("#sido_code option:selected").val();
	var sigoon = $("#sigoon_code option:selected").val();
	var html = "<p>"+sido+":"+sigoon+"</p>";
	$("#possibleArea").append(html);
	$("#sido_code").val("선택").prop("selected", true);
	$("#sigoon_code").val("선택").prop("selected", true);
});