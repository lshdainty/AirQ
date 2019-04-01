<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<form>
	<textarea name="ckeditor" id="editor" rows="10" cols="80">
            This is my textarea to be replaced with CKEditor.
        </textarea>
</form>

<script>
	var editorConfig = {
		filebrowserUploadUrl : "imageUpload", //이미지 업로드
	};
	$(function() {

		CKEDITOR.replace('ckeditor', {//해당 이름으로 된 textarea에 에디터를 적용
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

<%@include file="../include/footer.jsp"%>