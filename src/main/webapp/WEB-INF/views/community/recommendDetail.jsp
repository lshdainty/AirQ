<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<style>
    a {
        text-decoration: none;
        color: inherit;
    }

    .article-header {
        padding: 24px 16px;
        border-bottom: 1px solid #ebeef1;
    }

    .article__title {
        line-height: 36px;
        font-size: 24px;
        color: #1e2022;
        word-wrap: break-word;
        word-break: break-all;
    }

    .article-meta {
        margin-top: 9px;
        line-height: 17px;
        font-size: 14px;
        color: #7b858e;
    }

    .article-meta__item:first-child {
        margin-left: 0;
        padding-left: 0;
    }

    .article-meta__item {
        display: inline-block;
        vertical-align: middle;
        position: relative;
        margin-left: 8px;
        padding-left: 9px;
    }



    .article-vote {
        border-top: 1px solid #ebeef1;
        padding: 12px 0;
        text-align: center;
        border-bottom: 1px solid #ebeef1;
    }

    .article-vote__button:first-child {
        margin-left: 0;
    }

    .article-vote__button {
        padding: 12px;
        min-width: 88px;
        line-height: 17px;
        font-size: 14px;
        color: #1e2022;
        margin-left: 8px;
        border-radius: 4px;
        background-color: #fff;
        border: 1px solid #dddfe4;
    }

    .comment-wrap {
        margin-top: 16px;
        margin-bottom: 8px;
        background-color: #fff;
        -webkit-box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .15);
        box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .15);
    }

    .comment-header {
        position: relative;
        padding: 16px;
    }

    .comment__title {
        display: inline;
        line-height: 21px;
        font-size: 18px;
        color: #1e2022;
    }

    .comment__count {
        line-height: 18px;
        font-size: 14px;
        color: #7b858e;
    }

    .comment-wrap>.comment-write {
        padding: 24px 16px;
    }
    .comment-write {
        /* background: #f8f9fa; */
    }
    .comment-write-inner {
        background-color: #fff;
        border: 1px solid #dddfe4;
    }
    .comment-write__name {
        padding: 16px 16px 0;
        line-height: 17px;
        font-size: 14px;
        color: #1e2022;
        font-weight: 700;
    }
    .comment-write__content {
        margin: 8px 16px 0;
        padding-bottom: 16px;
    }
    .comment-write__content textarea {
        display: block;
        width: 100%;
        min-height: 40px;
        line-height: 20px;
        font-size: 14px;
        -webkit-appearance: none;
        -moz-appearance: none;
        appearance: none;
        resize: none;
        border: none;
        outline: none;
        font-family: Helvetica,Arial,Malgun Gothic,sans-serif;
    }
    .comment-write-footer {
        position: relative;
        border-top: 1px solid #dddfe4;
        min-height: 42px;
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
        padding-right: 100px;
    }
    .comment-write-submit {
        position: absolute;
        right: 0;
        bottom: 0;
    }
    .comment-write-submit .button {
        width: 92px;
        padding: 10px 9px;
        line-height: 20px;
        font-size: 16px;
        border-radius: 0;
        border: 1px solid #dddfe4;
    }
    .button--green {
        border-color: #46cfa7;
        background-color: #46cfa7;
        color: #fff;
    }
    .article-content img{
    	max-width:100%;
    	height:auto !important;
    }
    @media only screen and (min-width: 1024px) {
        .article-header {
            padding-left: 24px;
            padding-right: 24px;
        }
        .article-content {
            padding-right: 24px;
            padding-left: 24px;
        }

        .article-content {
            width: 100%;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            padding: 24px 16px;
            line-height: 24px;
            font-size: 16px;
            color: #1e2022;
            word-wrap: break-word;
            word-break: break-all;
        }
    }

    @media only screen and (min-width: 768px) {
        .article-meta-list {
            float: left;
            margin-top: 0;
        }

        .article-meta-list--right {
            float: right;
        }
    }
</style>


 <div class="article">
            <div class="article-header">
                <div class="article__title">${detailPost.post_title}</div>
                <div class="article-meta">
                    <div class="article-meta-list">
                        <div class="article-meta__item article-meta__item--name">
                            <a href="#">
                                ${detailPost.member_id}
                            </a>
                        </div>
                        <div class="article-meta__item"><span data-tooltip="" data-date="2019-04-08T20:43:22+00:00"
                                title="2019년 4월 9일 화요일 오전 5:43">6 시간 전</span>
                        </div>
                    </div>
                    <div class="article-meta-list article-meta-list--right">
                        <div class="article-meta__item"><span>조회 ${detailPost.view_num}</span></div>
                        <div class="article-meta__item"><span>댓글 11</span></div>
                        <div class="article-meta__item"><span>추천 91</span></div>
                    </div>
                </div>
            </div>
            <div class="article-content-wrap">
                <div class="article-content">
                    ${detailPost.post_content}
                </div>
            </div>
            <div id="postVote">
                <div data-v-55f6a8c1="" class="article-vote">
	                <button type="submit" class="article-vote__button button">
		                <span class="article-vote__up-arrow">추천</span> 
		                <span class="article-vote__count">92</span>
	                </button> 
	                <button type="button" class="article-vote__button button">
		                <span class="article-vote__down-arrow">비추천</span>
		                <span class="article-vote__count">1</span>
	                </button>
                </div>
            </div>
        </div>

        <div id="comment">
            <div class="comment-wrap">


                <div data-v-f923dbf4="" class="comment-header">
                    <h2 data-v-f923dbf4="" class="comment__title">댓글</h2> <span data-v-f923dbf4="" class="comment__count">총
                        <em data-v-f923dbf4="">11</em>개</span>
                </div>
                <div data-v-f923dbf4="" class="comment-button">
                </div>


                <div data-v-f923dbf4="" class="comment-write">
                    <form data-v-f923dbf4="" method="POST"> 
                        <div data-v-f923dbf4="" class="comment-write-inner">
                            <div data-v-f923dbf4="" class="comment-write__name">${user.member_id}</div>
                            <div data-v-f923dbf4="" class="comment-write__content"><textarea data-v-f923dbf4=""
                                    name="content" id="writeComment"
                                    placeholder="주제와 무관한 댓글, 타인의 권리를 침해하거나 명예를 훼손하는 게시물은 별도의 통보 없이 제재를 받을 수 있습니다."
                                    style="overflow: hidden; overflow-wrap: break-word; height: 44px;"></textarea>
                            </div>
                            <div data-v-f923dbf4="" class="comment-write-footer">
                                <div class="comment-write-submit"><button class="button button--green">작성</button></div>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>


<input type="hidden" value="${detailPost.post_code}" id="test2" name="post_id">
<a href="recommendDelete?post_code=${detailPost.post_code}" class="btn btn-primary" id="test">삭제</a>
<a href="recommendModify?post_code=${detailPost.post_code}" class="btn btn-primary" id="test">수정</a>
<script>
$(document).ready(function(){
	$('#test').click(function(){
		alert($('#test2').val());
	});
});
</script>
<%@include file="../include/footer.jsp" %>
