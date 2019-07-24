
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
	$('#fcmTest').click(function(){
		alert("aa");
		$.ajax({
			type:'POST',
			url:'appPush',
			success:function(result){	
				alert(result);
			}
		}); 
	});
	$('#post-write').click(function(){
		window.location.href="postWrite";
	});
	$('#reply-insert').click(function(){
		var reply_content = $('#reply_content').val();
		var member_id = $('#member_id').text();
		var post_code = $('#post_code').val();
		var replyVO = new Object();
		
		replyVO.member_id = member_id;
		replyVO.post_code = post_code;
		replyVO.reply_content = reply_content;
		$.ajax({
			type:'POST',
			url:'addReply',
			data:replyVO,
			success:function(result){	
				var content ='<div class="comment-list"><div class="comment-l"><div class="comment"><div class="comment-meta">'+
				'<span class="comment__name"><a href="#">'+member_id+'</a></span><span class="comment__date"> 방금 전'+
				'</span></div><div class="comment-content"><div><p><br>'+reply_content+'</p></div></div><div class="comment-button">'+
				'<button class="comment__button comment__button--red reply-delete">삭제</button><input type="hidden"'+
				'class="reply_code" value="'+result.reply_code+'"></div></div></div></div>';
 				var reply_count =parseInt($('#reply_count').text());
				$('#replys').prepend(content);
				$('#reply_content').val("");
				reply_count = reply_count+1;
				$('#reply_count').text(reply_count);
				$('#post_ReplyCount').html('댓글&nbsp'+reply_count);
			}
		}); 
	});
		
	$('#post-vote').click(function(){
		var post_code = $('#post_code').val();
		$.ajax({
			type:'post',
			data:{'post_code':post_code},
			url:'postVote',
			success:function(result){
				var recommend_num = parseInt($('.recommend_num').last().text());
				recommend_num=recommend_num+1;
				$('.recommend_num').text(recommend_num);
				$('.recommend_num').first().html('추천&nbsp'+recommend_num);
			}
		});
	});
	$(document).on("click",".reply-delete",function(){
			var post_code = $('#post_code').val();
			var reply_code = $(this).next().val();
			var data = {'reply_code':reply_code,'post_code':post_code};
			$(this).parent().parent().parent().parent().remove();
    			$.ajax({
				type:'post',
				data:data,
				url:'replyDelete',
				success:function(result){
					var reply_count =parseInt($('#reply_count').text());
					reply_count = reply_count-1;
					$('#reply_count').text(reply_count);
					$('#post_ReplyCount').html('댓글&nbsp'+reply_count);
			}
		});    
	});
	
	$('.post-detail').click(function(){
		var post_code = $(this).children('input').val();
		window.location.href="postDetail?post_code="+post_code;
	});
	
	$("#post-report").click(function(){
    	var post_code = $("#post_code").val();
    	//기존에 신고한 내용이 있는지 확인
    	$.ajax({
    		type: "get",
    		url: "/checkReport",
    		data : {original_code : post_code},
    		async: false,
    		success: function(data) {
    			if(data=="success"){
    				windowObj = window.open("/report?original_code="+post_code,"report","width=570px, height=600px");
    			}else{
    				alert("신고는 한번만 가능합니다.");
    			}
    		},
    		error: function(xhr, stat, err) {}
    	});
    });
});