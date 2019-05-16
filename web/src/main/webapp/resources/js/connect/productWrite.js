var editorConfig = {
		filebrowserUploadUrl : "imageUpload", //이미지 업로드
};

//Thumbnail preview보기
function readURL(input){
	if(input.files&&input.files[0]){
		var reader = new FileReader();
		reader.onload = function(e){
			$('#div_inner_img').prop('src',e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}

//Thumbnail을 업로드하면 함수실행
$("#fileImage").change(function(){
	readURL(this);
	$("#divImage").show();
});

$(function() {
	CKEDITOR.replace(
					'product_detail',
					{//해당 이름으로 된 textarea에 에디터를 적용
						width : '100%',
						height : '50vh',
						filebrowserImageUploadUrl : "imageUpload" //여기 경로로 파일을 전달하여 업로드 시킨다.
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
					html +="<option value='"+data.aList[i].area_code+"'>"+data.aList[i].area_si+"</option>"
				}
				$('#sigoon_code').html(html);	
			},
			error: function(xhr, stat, err) {}
		});
	});
});

$("#areaAdd").click(function(){
	if($("#sido_code option:selected").val()=="광역시/도"){
		alert("광역시/도를 선택해주세요");
		return false;
	}else if($("#sigoon_code option:selected").text()=="시/구"){
		alert("시/구를 선택해주세요");
		return false;
	}else{
		var sido = $("#sido_code option:selected").val();
		var sigoon = $("#sigoon_code option:selected").text();
		var area_code = $("#sigoon_code option:selected").val();
		var html = [
			"<div class='possible'>",
				"<label for='area_code'>"+sido+":"+sigoon+"</label>",
				"<input type='hidden' id='area_code' name='area_code' value='"+area_code+"' />",
				"<input type='button' class='removeBtn' value='삭제하기' />",
			"</div>"
		].join("");
		$("#p_possible_area").append(html);
		$("#sido_code").val("광역시/도").prop("selected", true);
		$("#sigoon_code").val("시/구").prop("selected", true);
	}
});

$(document).on("click",".removeBtn",function(){
	$(this).parent().remove();
});