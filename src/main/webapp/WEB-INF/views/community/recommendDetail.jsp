<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" href="resources/css/comunity/comunity.css">
<div class="article">
	<div class="article-header">
		<div class="article__title">${detailPost.post_title}</div>
		<div class="article-meta">
			<div class="article-meta-list">
				<div class="article-meta__item article-meta__item--name">
					<a href="#"> ${detailPost.member_id} </a>
				</div>
				<div class="article-meta__item">
					<span data-tooltip="" data-date="2019-04-08T20:43:22+00:00"
						title="2019년 4월 9일 화요일 오전 5:43">6 시간 전</span>
				</div>
			</div>
			<div class="article-meta-list article-meta-list--right">
				<div class="article-meta__item">
					<span>조회 ${detailPost.view_num}</span>
				</div>
				<div class="article-meta__item">
					<span>댓글  ${detailPost.reply_count}</span>
				</div>
				<div class="article-meta__item">
					<span>추천 ${detailPost.recommend_num}</span>
				</div>
			</div>
		</div>
	</div>
	<div class="article-content-wrap">
		<div class="article-content">${detailPost.post_content}</div>
	</div>
	<div id="postVote">
		<div data-v-55f6a8c1="" class="article-vote">
			<button type="submit" class="article-vote__button button" id="post-vote">
				<span class="article-vote__up-arrow">추천</span> <span
					class="article-vote__count" id="recommend_num">${detailPost.recommend_num}</span>
			</button>
		</div>
	</div>
</div>

<div id="comment">
	<div class="comment-wrap">


		<div class="comment-header">
			<h2 class="comment__title">댓글</h2>
			<span class="comment__count">총 <em>${detailPost.reply_count}</em>개
			</span>
		</div>

		<div class="comment-write">
			<div class="comment-write-inner">
				<div class="comment-write__name" id="member_id">${user.member_id}</div>
				<div class="comment-write__content">
					<textarea name="reply_content" placeholder="주제와 무관한 댓글, 타인의 권리를 침해하거나 명예를 훼손하는 게시물은 별도의 통보 없이 제재를 받을 수 있습니다."
					style="overflow: hidden; overflow-wrap: break-word; height: 44px;" id="reply_content"></textarea>
				</div>
				<div class="comment-write-footer">
					<div class="comment-write-submit">
						<button class="button button--blue" id="reply-insert">작성</button>
					</div>
				</div>
			</div>
		</div>

		<div>
			<div class="comment-sort">
				<ul class="comment-sort__list">
					<li class="comment-sort__item comment-sort__item--active"><button
							type="button">인기순</button></li>
					<li class="comment-sort__item"><button type="button">최신순</button></li>
				</ul>
			</div>

			<div id="replys">
			<c:forEach var="reply" items="${postReply}">
				<div class="comment-list">
					<div class="comment-l">
						<!---->
						<div class="comment">
							<div class="comment-meta">
								<span class="comment__name"><a href="#">${reply.member_id}</a></span>
								<span class="comment__date">1분전</span>
							</div>
							<div class="comment-content">
								<div>
									<p>
										<br> ${reply.reply_content}
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
		</c:forEach>
		</div>
	</div>
</div>
</div>


<input type="hidden" value="${detailPost.post_code}" id="post_code"
	name="post_id">
<a href="recommendDelete?post_code=${detailPost.post_code}"
	class="btn btn-primary" id="test">삭제</a>
<a href="recommendModify?post_code=${detailPost.post_code}"
	class="btn btn-primary" id="test">수정</a>
<script>
	$(document).ready(function() {
		$('#reply-insert').click(function(){
			
			var reply_content = $('#reply_content').val();
			var member_id = $('#member_id').text();
			var post_code = $('#post_code').val();
			var replyVO = new Object();
			
			replyVO.member_id = member_id;
			replyVO.post_code = post_code;
			replyVO.reply_content = reply_content;
			
			var content ='<div class="comment-list"><div class="comment-l"><div class="comment"><div class="comment-meta">'+
			'<span class="comment__name"><a href="#">'+member_id+'</a></span><span class="comment__date">1분전</span>'+
			'</div><div class="comment-content"><div><p><br>'+reply_content+'</p></div></div></div></div></div>';
			$.ajax({
				type:'POST',
				url:'addReply',
				data:replyVO,
				success:function(result){	
					$('#replys').prepend(content);
					$('#reply_content').val("");
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
					var recommend_num = parseInt($('#recommend_num').text());
					recommend_num=recommend_num+1;
					$('#recommend_num').text(recommend_num);
				}
			});
		});
	});
</script>
<%@include file="../include/footer.jsp"%>
