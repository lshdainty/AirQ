$(document).ready(function(){
	$("#change") .click(function(){
		var query = {
				selected : $("select option:selected").val(),
		}
		$.ajax({
			type : "POST",
			data : query,
			url : "mypageMainPostsAjax",
			success : function(data){
				if(data == "0"){
					$(".form2").children().show();
					$(".form2").show();
					$(".form3").children().show();
					$(".form3").show();
					$(".form4").children().show();
					$(".form4").show();
				}else if(data == "pd"){
					$(".form2").children().show();
					$(".form2").show();
					$(".form3").children().hide();
					$(".form3").hide();
					$(".form4").children().hide();
					$(".form4").hide();
				}else if(data == "ps"){
					$(".form2").children().hide();
					$(".form2").hide();
					$(".form3").children().show();
					$(".form3").show();
					$(".form4").children().hide();
					$(".form4").hide();
				}else if(data =="td"){
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

//관리자 글 관리 상세페이지 시작
$(document).on('click','.form2',function(){
	var report_code = $(this).attr("id");
	console.log(report_code);
	window.location.href="/mypageMainPostsIn?report_code="+report_code;
});

$(document).on('click','.form3',function(){
	var report_code = $(this).attr("id");
	console.log(report_code);
	window.location.href="/mypageMainPostsIn?report_code="+report_code;
});

$(document).on('click','.form4',function(){
	var report_code = $(this).attr("id");
	console.log(report_code);
	window.location.href="/mypageMainPostsIn?report_code="+report_code;
});