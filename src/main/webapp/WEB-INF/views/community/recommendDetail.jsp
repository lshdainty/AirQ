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
			<button type="submit" class="article-vote__button button">
				<span class="article-vote__up-arrow">추천</span> <span
					class="article-vote__count">${detailPost.recommend_num}</span>
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
			<form method="POST" action="addReply?post_code=${detailPost.post_code}">
				<div class="comment-write-inner">
					<div class="comment-write__name">${user.member_id}</div>
					<div class="comment-write__content">
						<textarea name="reply_content"
							placeholder="주제와 무관한 댓글, 타인의 권리를 침해하거나 명예를 훼손하는 게시물은 별도의 통보 없이 제재를 받을 수 있습니다."
							style="overflow: hidden; overflow-wrap: break-word; height: 44px;">
                            </textarea>
					</div>
					<div class="comment-write-footer">
						<div class="comment-write-submit">
							<button class="button button--blue" id="reply-insert">작성</button>
						</div>

					</div>
				</div>
			</form>
		</div>

		<div>
			<div class="comment-sort">
				<ul class="comment-sort__list">
					<li class="comment-sort__item comment-sort__item--active"><button
							type="button">인기순</button></li>
					<li class="comment-sort__item"><button type="button">최신순</button></li>
				</ul>
			</div>


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


<input type="hidden" value="${detailPost.post_code}" id="test2"
	name="post_id">
<a href="recommendDelete?post_code=${detailPost.post_code}"
	class="btn btn-primary" id="test">삭제</a>
<a href="recommendModify?post_code=${detailPost.post_code}"
	class="btn btn-primary" id="test">수정</a>
<script>
/* 	$(document).ready(function() {
		$('#reply-insert').click(function(){
			$.ajax({
				url:
			});
		})
	}); */
</script>
<%@include file="../include/footer.jsp"%>
