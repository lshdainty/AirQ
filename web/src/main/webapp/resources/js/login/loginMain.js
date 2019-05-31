$(document).ready(function () {

	$('#ID').focus();
	$('#ID').focus(function () {
			$('#ID').parent().addClass("member-input__state--focus");
			$('#ID').keyup(function () {
				putValue($('#ID'));
				checkValue($('#ID'));
				checkWrite($('#ID'),$('#PASS'));
			});
	});
	$('#ID').focusout(function () {
		putValue($('#ID'));
		checkValue($('#ID'));
		$('#ID').parent().removeClass("member-input__state--focus");
		checkWrite($('#ID'),$('#PASS'));
	});
	$('#PASS').focus(function () {
			$('#PASS').parent().addClass("member-input__state--focus");
			$('#PASS').keyup(function () {
				putValue($('#PASS'));
				checkValue($('#PASS'));
				checkWrite($('#ID'),$('#PASS'));
			});
	});
	$('#PASS').focusout(function () {
		putValue($('#PASS'));
		checkValue($('#PASS'));
		$('#PASS').parent().removeClass("member-input__state--focus");
		checkWrite($('#ID'),$('#PASS'));
	});

	function putValue(selector){
		selector.attr("value",selector.val());
	}
	function checkValue(selector){
		var parent = selector.parent();
		if((selector.attr("value"))!=""){
			selector.parent().addClass("member-input__state--value");
		}
		else
			selector.parent().removeClass("member-input__state--value");
	}
	function checkWrite(selector1,selector2){
		if((selector1.attr("value"))!=""&& (selector2.attr("value"))!=""){
			$('.login__btn').attr("disabled",false);
		}
		else
			$('.login__btn').attr("disabled",true);
	}
	$('#PASS').focus(function () {
		$('#PASS').parent().addClass("member-input__state--focus");
	});
	$('#PASS').focusout(function () {
		$('#PASS').parent().removeClass("member-input__state--focus");
	});

	$('#PASS').keydown(function () {
		if ($('#PASS').val() != ""){
			$('#PASS').parent().addClass("member-input__state--value");
			if($('#PASS').val() != "")
			$('.login__btn').attr("disabled",false);
		else
			$('.login__btn').attr("disabled",true);
		}
		else{
			$('#PASS').parent().removeClass("member-input__state--value");
			$('.login__btn').attr("disabled",true);
		}
	});
	var isChecked = false;
	$(".member-checkbox__state").click(function () {
		if (isChecked==false){
			$(".member-checkbox__state").addClass("member-checkbox__state--checked");
			isChecked=true;
		}
		else{
			$(".member-checkbox__state").removeClass("member-checkbox__state--checked");
			isChecked=false;
		}
	});


	//로그인 버튼 클릭
	$(".login__btn").click(function () {
		var query = {
			id: $("#ID").val(),
			password: $("#PASS").val()
		};
		// 로그인 버튼 클릭 ajax 
		$.support.cors = true;
		$.ajax({
			type: "POST",
			data: query,
			url:"login", // 로그인 페이지 경로
			success : function(data) {
			if (data == "success") { //로그인 성공
				location.href = "/";
			} else { 
				$('.member-input__state').addClass('member-input__state--wrong');
				$('.member-input-wrong-message').css("display","inherit");
				$('.member-input-wrong-message').text('Account ID and Password do not match. Please try again.');
			}
		}
		}) // ajax 로그인 버튼 끝
	});
	//패스워드에 커서를 두고 엔터키를 누르면 로그인 함
	$("#PASS").keydown(function (key) {
		if (key.keyCode == 13) {
			$("#logintest").click();
		}
	});

	//아이디에 커서를 두고 엔터키를 누르면 로그인 함
	$("#ID").keydown(function (key) {
		if (key.keyCode == 13) {
			$("#logintest").click();
		}
	});

});


