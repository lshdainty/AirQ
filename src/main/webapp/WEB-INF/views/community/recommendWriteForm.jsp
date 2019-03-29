<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<div class="container" style="margin-top:112px">
    <div class="row">
        <div class="col-md-12 order-md-1">
            <h4 class="mb-5">Board</h4>
            <form class="needs-validation" novalidate>
                <div class="row">
                    <div style="width:100%">
                        <label for="firstName">board name</label> <input type="text" class="form-control" id="recommend-name"
                            placeholder="Board name" value="" required>
                        <div class="invalid-feedback">Valid first name is required.
                        </div>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="username">board content</label>
                    <div class="input-group">
                        <textarea rows="20" cols="100" class="form-control" id="recommend-content" placeholder="Board content"
                            required></textarea>
                        <div class="invalid-feedback" style="width: 100%;">Your
                            username is required.</div>
                    </div>
                </div>


                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit" id="recommend-write-done">Write</button>
            </form>
        </div>
    </div>
</div>
<div class="container">
<form action="/board/write" method="post" name="w_form">
  <div class="form-group">
    <input type="text" name="bTitle" class="form-control" placeholder="Enter Title">
  </div>
  <div class="form-group">
    <textarea name="bContent" id="textAreaContent" style="width: 100%" rows="15" cols="80"></textarea>
  </div>
  <button type="button" class="btn btn-primary" onClick="submitContents(this)">글쓰기</button>
</form>
</div>

<!-- Naver Smart Editor 2 -->
<script>
  var form = document.w_form;
  var oEditors = [];
  nhn.husky.EZCreator.createInIFrame({
      oAppRef: oEditors,
      elPlaceHolder: "textAreaContent",
      sSkinURI: "/resources/smartEditor/SmartEditor2Skin.html",
      fCreator: "createSEditor2"
  });
   
  // submit
  function submitContents(elClickedObj) {
      // 에디터의 내용이 textarea에 적용된다.
      oEditors.getById["textAreaContent"].exec("UPDATE_CONTENTS_FIELD", [ ]);
      var con = document.w_form.bContent;
      con.value = document.getElementById("textAreaContent").value;
      try {
          elClickedObj.form.submit(this);
      } catch(e) {
       
      }
  }
   
  // textArea에 이미지 첨부
  function pasteHTML(filepath){
      var sHTML = '<img src="/resources/smartEditor/upload/'+ filepath + '">';
	  oEditors.getById["textAreaContent"].exec("PASTE_HTML", [ sHTML ]);
  }
</script>
<!-- Naver Smart Editor 2 END-->
<%-- 스크립트 링크 시작 --%>

<script src="resources/js/community/community.js"></script>

<%-- 스크립트 링크 끝 --%>

<%@include file="../include/footer.jsp"%>