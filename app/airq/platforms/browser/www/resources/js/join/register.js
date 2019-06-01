/**
 * 
 */
$(document).ready(function(){
	// 회원가입 - 일반 사용자 버튼 클릭
	$("#nregister").click(function(){
		location.href="nRegister";	// 일반 사용자 회원가입 이동
	});
	
	// 회원가입 - 판매자 버튼 클릭
	$("#sregister").click(function(){
		location.href="sRegister";	// 판매자 회원가입 이동
	});
}); //document