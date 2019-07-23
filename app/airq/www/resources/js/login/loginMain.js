$(document).ready(function () {

	$('#ID').focus();
	$('#ID').focus(function () {
		$('#ID').parent().addClass("member-input__state--focus");
		$('#ID').keyup(function () {
			putValue($('#ID'));
			checkValue($('#ID'));
			checkWrite($('#ID'), $('#PASS'));
		});
	});
	$('#ID').focusout(function () {
		putValue($('#ID'));
		checkValue($('#ID'));
		$('#ID').parent().removeClass("member-input__state--focus");
		checkWrite($('#ID'), $('#PASS'));
	});
	$('#PASS').focus(function () {
		$('#PASS').parent().addClass("member-input__state--focus");
		$('#PASS').keyup(function () {
			putValue($('#PASS'));
			checkValue($('#PASS'));
			checkWrite($('#ID'), $('#PASS'));
		});
	});
	$('#PASS').focusout(function () {
		putValue($('#PASS'));
		checkValue($('#PASS'));
		$('#PASS').parent().removeClass("member-input__state--focus");
		checkWrite($('#ID'), $('#PASS'));
	});

	//패스워드에 커서를 두고 엔터키를 누르면 로그인 함
	$("#PASS").keydown(function (key) {
		if (key.keyCode == 13) {
			$(".login__btn").click();
		}
	});

	//아이디에 커서를 두고 엔터키를 누르면 로그인 함
	$("#ID").keydown(function (key) {
		if (key.keyCode == 13) {
			$(".login__btn").click();
		}
	});

	function putValue(selector) {
		selector.attr("value", selector.val());
	}
	function checkValue(selector) {
		var parent = selector.parent();
		if ((selector.attr("value")) != "") {
			selector.parent().addClass("member-input__state--value");
		}
		else
			selector.parent().removeClass("member-input__state--value");
	}
	function checkWrite(selector1, selector2) {
		if ((selector1.attr("value")) != "" && (selector2.attr("value")) != "") {
			$('.login__btn').attr("disabled", false);
		}
		else
			$('.login__btn').attr("disabled", true);
	}
	$('#PASS').focus(function () {
		$('#PASS').parent().addClass("member-input__state--focus");
	});
	$('#PASS').focusout(function () {
		$('#PASS').parent().removeClass("member-input__state--focus");
	});

	$('#PASS').keydown(function () {
		if ($('#PASS').val() != "") {
			$('#PASS').parent().addClass("member-input__state--value");
			if ($('#PASS').val() != "")
				$('.login__btn').attr("disabled", false);
			else
				$('.login__btn').attr("disabled", true);
		}
		else {
			$('#PASS').parent().removeClass("member-input__state--value");
			$('.login__btn').attr("disabled", true);
		}
	});
	var isChecked = false;
	$(".member-checkbox__state").click(function () {
		if (isChecked == false) {
			$(".member-checkbox__state").addClass("member-checkbox__state--checked");
			isChecked = true;
		}
		else {
			$(".member-checkbox__state").removeClass("member-checkbox__state--checked");
			isChecked = false;
		}
	});



	// Token 생성
	function createToken(id) {
		FCMPlugin.getToken(function (token) {
			localStorage.setItem('token', token);
			tokenUpdate(token,id);
		});
	}


	// Checking for Token Exist in Database
	function isTokenExist(id){
		var result;
		$.ajax({
			async: false,
			type: "GET",
			data: {id:id},
			url: sessionStorage.getItem("IP_ADDRESS") + "/m.isTokenExist",
			success: function (data) {
				result=data;
			}
		});
		return result;
	}

	// compare with database
	function tokenCompare(id,token){
		var result;
		$.ajax({
			async: false,
			type: "GET",
			data: {id:id,
				token:token
			},
			url: sessionStorage.getItem("IP_ADDRESS") + "/m.tokenCompare",
			success: function (data) {
				if(data=="equal")
					result = true;
				else
					result = false;

			}
		});
		return result;
	}

	// token Update
	function tokenUpdate(token,id){

		var query = {
			id:id,
			token: token
		};

		$.ajax({
			type: "GET",
			data: query,
			dataType:'JSON',
			url: sessionStorage.getItem("IP_ADDRESS") + "/m.tokenUpdate", // 로그인 페이지 경로
			success: function (data) {

			}
		})
	}

	// Home 으로 이동
	function journeyHome(){
		window.location.href = "../../../www/views/service/main.html";
	}

	//로그인 버튼 클릭
	$(".login__btn").click(function () {
		var id =  $("#ID").val();
		var query = {
			id: id,
			password: $("#PASS").val()
		};
		// 로그인 버튼 클릭 ajax 
		$.support.cors = true;
		$.ajax({
			type: "GET",
			data: query,
			dataType: 'JSON',
			url: sessionStorage.getItem("IP_ADDRESS") + "/m.login", // 로그인 페이지 경로
			success: function (data) {
				var token = localStorage.getItem('token');
				if (data.result == "success") {

					// 1. Device에 Token 존재 확인
					if(isTokenExist(id)=="exist"){
						// 2. Device Token 과 Databse Token 비교
						if(tokenCompare(id,token)){
						}
						else{
							if(confirm("대표 디바이스로 지정하시겠습니까?")){
								tokenUpdate(token,id);
							}
						}
					}
					else{
						createToken(id);
					}
					if (isChecked) {
						localStorage.setItem("user", JSON.stringify(data.userInfo));
						sessionStorage.setItem("user", JSON.stringify(data.userInfo));
					}
					else {
						sessionStorage.setItem("user", JSON.stringify(data.userInfo));
					}
					journeyHome();
				}
				else {
					$('.member-input__state').addClass('member-input__state--wrong');
					$('.member-input-wrong-message').css("display", "inherit");
					$('.member-input-wrong-message').text('Account ID and Password do not match. Please try again.');
				}
			}
		}) // ajax 로그인 버튼 끝
	});
});






