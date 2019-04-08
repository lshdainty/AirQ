<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>


<% application.getRealPath(""); %>
<div class="container" style="margin-top: 112px">
	<div class="row">
		<div class="col-md-12 order-md-4">		
			
			<form class="needs-validation" enctype="multipart/form-data" action="recommendInsert" method="get" novalidate >
			
			
				<%-- 게시글 이름 시작 --%>
				<div class="row">
					<div style="width: 100%">
						<label for="firstName">board name</label> 
						
						<input type="text" class="form-control" id="post_title" placeholder="Board name" required name="post_title">
						<div class="invalid-feedback">BoardName is empty.</div>
					</div>
				</div>
				<%-- 게시글 이름 끝 --%>
		
			
				
				<%-- 게시글 내용 시작 --%>
				<div class="mb-3">
					<label for="username">board content</label>
					<div class="input-group">
						<textarea rows="20" cols="100" class="form-control" id="recommend-cotent"
							placeholder="Board content" name="post_content" required></textarea>
						<div class="invalid-feedback" style="width: 100%;">BoardName is empty.</div>
					</div>
				</div>
				<%-- 게시글 내용 끝 --%>

				<hr class="mb-4">
				<button class="btn btn-primary btn-lg btn-block" type="submit">Write</button>
			</form>
		</div>
	</div>
</div>

<%-- 스크립트 링크 시작 --%>

<script src="resources/js/community/community.js"></script>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<script>
	var editorConfig = {
		filebrowserUploadUrl : "imageUpload", //이미지 업로드
	};
	$(function() {

		CKEDITOR
				.replace(
						'post_content',
						{//해당 이름으로 된 textarea에 에디터를 적용
							width : '100%',
							height : '400px',
							filebrowserImageUploadUrl : "${pageContext.request.contextPath}/imageUpload" //여기 경로로 파일을 전달하여 업로드 시킨다.
						});
		CKEDITOR.on('dialogDefinition', function(ev) {
			var dialogName = ev.data.name;
			var dialogDefinition = ev.data.definition;

			switch (dialogName) {
			case 'image': //Image Properties dialog
				//dialogDefinition.removeContents('info');
				dialogDefinition.removeContents('Link');
				dialogDefinition.removeContents('advanced');
				break;
			}
		});

	});

</script>
<%-- 스크립트 링크 끝 --%>

<%@include file="../include/footer.jsp"%>