<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<div class="container" style="margin-top:112px">
    <div class="row">
        <div class="col-md-12 order-md-1">
            <h4 class="mb-5">Modify</h4>
            <form class="needs-validation" action="recommendUpdate" method="get" novalidate>
            <input type="hidden" name="post_code" value="${modifyPost.post_code}">
                <div class="row">
                    <div style="width:100%">
                        <label for="firstName">post name</label> <input type="text" class="form-control" name="post_title" id="firstName"
                            placeholder="post name" value="${modifyPost.post_title}" required>
                        <div class="invalid-feedback">Valid first name is required.
                        </div>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="username">post content</label>
                    <div class="input-group">
                        <textarea rows="20" cols="100" class="form-control" id="username" placeholder="post content" name="post_content"
                            required>${modifyPost.post_content}</textarea>
                    </div>
                </div>


                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit" id="liberty-write-done">Write</button>
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

		CKEDITOR.replace('post_content', {//해당 이름으로 된 textarea에 에디터를 적용
			width : '100%',
			height : '400px',
			filebrowserImageUploadUrl : 'imageUpload' //여기 경로로 파일을 전달하여 업로드 시킨다.
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

	function getUrlParam(paramName) {
		var reParam = new RegExp('(?:[\?&]|&)' + paramName + '=([^&]+)', 'i');
		var match = window.location.search.match(reParam);
		return (match && match.length > 1) ? match[1] : null;
	}

	var funcNum = getUrlParam('CKEditorFuncNum');

	var par = window.parent, op = window.opener, o = (par && par.CKEDITOR) ? par
			: ((op && op.CKEDITOR) ? op : false);

	if (op)
		window.close();
	if (o !== false)
		o.CKEDITOR.tools.callFunction(funcNum, '$file');
</script>
<%-- 스크립트 링크 끝 --%>

<%@include file="../include/footer.jsp"%>