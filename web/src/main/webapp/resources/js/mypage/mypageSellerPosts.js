$(document).ready(function(){
	$("#change") .click(function(){
		var query = {
				selected : $("select option:selected").val(),
		}
		$.ajax({
			type : "POST",
			data : query,
			url : "mypageSellerPostsAjax",
			success : function(data){
				if(data == "0"){
					$(".form3").children().show();
					$(".form3").show();
					$(".form4").children().show();
					$(".form4").show();
				}else if(data == "2"){
					$(".form3").children().show();
					$(".form3").show();
					$(".form4").children().hide();
					$(".form4").hide();
				}else if(data =="3"){
					$(".form3").children().hide();
					$(".form3").hide();
					$(".form4").children().show();
					$(".form4").show();
				}
			}
		})
	});
});