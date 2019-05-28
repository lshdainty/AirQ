					$(".form3").children().hide();
					$(".form3").hide();
					$(".form4").children().hide();
					$(".form4").hide();
$(document).ready(function(){
	$("#change") .click(function(){
		var query = {
				selected : $("select option:selected").val(),
		}
		$.ajax({
			type : "POST",
			data : query,
			url : "mypageMainMemberAjax",
			success : function(data){
				if(data == "0"){
					$(".form2").children().show();
					$(".form2").show();
					$(".form3").children().hide();
					$(".form3").hide();
					$(".form4").children().hide();
					$(".form4").hide();
				}else if(data == "no"){
					$(".form2").children().hide();
					$(".form2").hide();
					$(".form3").children().show();
					$(".form3").show();
					$(".form4").children().hide();
					$(".form4").hide();
				}else if(data == "se"){
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
