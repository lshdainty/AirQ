$(document).ready(function () {

	$('#memberInput2562').focus(function () {
		$('#memberInput2562').parent().addClass("member-input__state--focus");
	});
	$('#memberInput2562').focusout(function () {
		$('#memberInput2562').parent().removeClass("member-input__state--focus");
	});

	$('#memberInput2562').keyup(function () {
		var input = $('#memberInput2562');
		var value = input.val();
		if (value!=""){
			$('#memberInput2562').parent().addClass("member-input__state--value");
			if($('#memberInput797').val() != "")
				$('.login__btn').attr("disabled",false);
			else
				$('.login__btn').attr("disabled",true);
		}
		else{
			$('#memberInput2562').parent().removeClass("member-input__state--value");
			$('.login__btn').attr("disabled",true);
		}
	});

	$('#memberInput797').focus(function () {
		$('#memberInput797').parent().addClass("member-input__state--focus");
	});
	$('#memberInput797').focusout(function () {
		$('#memberInput797').parent().removeClass("member-input__state--focus");
	});

	$('#memberInput797').keydown(function () {
		if ($('#memberInput797').val() != ""){
			$('#memberInput797').parent().addClass("member-input__state--value");
			if($('#memberInput797').val() != "")
			$('.login__btn').attr("disabled",false);
		else
			$('.login__btn').attr("disabled",true);
		}
		else{
			$('#memberInput797').parent().removeClass("member-input__state--value");
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

	$('#memberInput2562').val() != null && $('#memberInput797').val() !={

	}

	//로그인 버튼 클릭
	$("#logintest").click(function () {

		var query = {
			id: $("#id").val(),
			password: $("#pw").val()
		}
		// 로그인 버튼 클릭 ajax 
		$.ajax({
			type: "POST",
			data: query,
			url: "login", // 로그인 페이지 경로
			success: function (data) {
				if (data == "success") { //로그인 성공
					location.href = "/";
				} else if (data == "failpw") { //pw 틀렸을 경우
					$("#nopw").css("display", "block");
					$("#nopw").show();
					$("#noid").hide();
				} else if (data == "failid") { //id 틀렸을 경우
					$("#noid").css("display", "blokc");
					$("#noid").show();
					$("#nopw").hide();
				}
			}
		}) // ajax 로그인 버튼 끝
	});
	//패스워드에 커서를 두고 엔터키를 누르면 로그인 함
	$("#pw").keydown(function (key) {
		if (key.keyCode == 13) {
			$("#logintest").click();
		}
	});

	//아이디에 커서를 두고 엔터키를 누르면 로그인 함
	$("#id").keydown(function (key) {
		if (key.keyCode == 13) {
			$("#logintest").click();
		}
	});

});
