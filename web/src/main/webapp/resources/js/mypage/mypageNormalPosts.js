// 셀렉트 옵션에 따른 데이터 값 불러오기
$(document).ready(function(){
	$("#change") .click(function(){
		var query = {
				selected : $("select option:selected").val(),
		}
		$.ajax({
			type : "POST",
			data : query,
			url : "mypageNormalPostsAjax",
			success : function(data){
				if(data == "0"){
					$(".form2").children().show();
					$(".form2").show();
					$(".form4").children().show();
					$(".form4").show();
				}else if(data == "1"){
					$(".form2").children().show();
					$(".form2").show();
					$(".form4").children().hide();
					$(".form4").hide();
					
				}else if(data =="3"){
					$(".form2").children().hide();
					$(".form2").hide();
					$(".form4").children().show();
					$(".form4").show();
				}
			}
		})
	});
});