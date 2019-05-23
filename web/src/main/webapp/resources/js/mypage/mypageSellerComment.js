$(".form3").children().hide();
$(".form3").hide();
$(".form4").children().hide();
$(".form4").hide();
// 셀렉트 옵션에 따른 데이터 값 불러오기
$(document).ready(function(){
	$("#change") .click(function(){
		var query = {
				selected : $("select option:selected").val(),
		}
		$.ajax({
			type : "POST",
			data : query,
			url : "mypageMainCommentAjax",
			success : function(data){
				if(data == "1"){
					$(".form2").children().show();
					$(".form2").show();
					$(".form3").children().hide();
					$(".form3").hide();
					$(".form4").children().hide();
					$(".form4").hide();
				}else if(data == "2"){
					$(".form2").children().hide();
					$(".form2").hide();
					$(".form3").children().show();
					$(".form3").show();
					$(".form4").children().hide();
					$(".form4").hide();
				}else if(data =="3"){
					$(".form2").children().hide();
					$(".form2").hide();
					$(".form3").children().hide();
					$(".form3").hide();
					$(".form4").children().show();
					$(".form4").show();
				}
			}
		})
	});
});