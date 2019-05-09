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
			url : "mypageNormalPayAjax",
			success : function(data){
				if(data == "1"){
					$(".form2").children().show();
					$(".form2").show();
					$(".aa").hide();
					$(".form3").children().hide();
					$(".form3").hide();
					$(".form4").children().hide();
					$(".form4").hide();
				}else if(data == "2"){
					$(".form2").children().hide();
					$(".form2").hide();
					$(".form3").children().show();
					$(".form3").show();
					$(".bb").hide();
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
				$(".form2").children().eq(0).hide();
				$(".form3").children().eq(0).hide();
			}
		})
	});
});

//별점 버튼 클릭 시 데이터 넘어가는것
$(document).ready(function(){
	$(".gavestar").click(function(){
		
//		var btn1 = $(this).parent().parent("div");
//		console.log(btn1.children().children().eq(0).val());
//		console.log($(this).parent().parent("div").children().children().eq(0).val());
//		var btn2 = $(this).parent("div");
//		console.log(btn2.children().eq(3).val());

//		var btn1 = {a:$(this).parent().parent("div").children().children().eq(0).val()}
//		var btn2 = {a:$(this).parent("div").children().eq(3).val()}
//		var objC = $.extend({},btn1,btn2);
//		console.log(objC);
//		alert(JSON.stringify(objC));
		
		var btn1 = $(this).parent().parent("div").children().children().eq(0).val();
		var btn2 = $(this).parent("div").children().eq(4).val();
		if(btn1 == undefined){
			btn1 = null;
		}else if(btn2 == undefined){
			btn2 = null;
		}

		var code1 =$(this).parent().parent().parent("div").children().eq(0).text();
		var code2 =$(this).parent("div").children().eq(0).text();
		if(code1 == ''){
			code1 = null;
		}else if(code2 == '별점 주기'){
			code2 = null;
		}
//		console.log(code1);
//		console.log(code2);
//		console.log(btn1);
//		console.log(btn2);
//		console.log(objC);
		
		var objC = {btn1:btn1,
				btn2:btn2,
				code1:code1,
				code2:code2
				};
			$.ajax({
				url : "mypageNormalPayStarAjax",
				type : "POST",
				data : objC,
				success : function(data){
					if(data == "1"){
						alert("별점 주기 성공");
						location.href = "mypageNormalPay"
					}else if(data == "2"){
						alert("1~10 점 사이의 점수를 입력해 주세요.")
					}

				},
				error : function(xhr, status, error){
					alert("1~10 사이의 점수를 입력해 주세요.")
				}
		})
	});
});