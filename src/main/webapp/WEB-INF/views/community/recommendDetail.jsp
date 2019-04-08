<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>

<input type="hidden" value="${detailPost.post_code}" id="test2" name="post_id">
<div>
	"${detailPost.post_title}"
	"${detailPost.post_content}";
	"${detailPost.member_id}";
</div>
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
