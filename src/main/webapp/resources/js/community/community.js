
(function() {
	'use strict'

	window.addEventListener('load', function() {
		// Fetch all the forms we want to apply custom Bootstrap validation
		// styles to
		var forms = document.getElementsByClassName('needs-validation')

		// Loop over them and prevent submission
		Array.prototype.filter.call(forms, function(form) {
			form.addEventListener('submit', function(event) {
				if (form.checkValidity() === false) {
					event.preventDefault()
					event.stopPropagation()
				}
				form.classList.add('was-validated')
			}, false)
		})
	}, false)
}())

$(document).ready(function() {

	// 상품추천 글쓰기 클릭시 실행
	$('#recommend-write').click(function() {
		window.location.href = "recommendWrite";
	});
	
	// 상품추천게시판 글쓰기폼에서 글쓰기 완료 클릭시 실행
	$('#recommend-write-done').click(function() {
		if($('#board_name').val()!=''&& $('#borad_name')!=null){

		}
			
	});
	
	
	// 자유게시판 글쓰기 클릭시 실행
	$('#liberty-write').click(function() {
		
	});

	
	// 자유게시판 글쓰기폼에서 글쓰기 완료 클릭시 실행
	$('#liberty-write-done').click(function() {
		window.location.href = "libertyMain";
	});
});