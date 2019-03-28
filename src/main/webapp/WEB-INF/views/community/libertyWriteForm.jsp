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
                        <label for="firstName">board name</label> <input type="text" class="form-control" id="firstName"
                            placeholder="Board name" value="" required>
                        <div class="invalid-feedback">Valid first name is required.
                        </div>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="username">board content</label>
                    <div class="input-group">
                        <textarea rows="20" cols="100" class="form-control" id="username" placeholder="Board content"
                            required></textarea>
                        <div class="invalid-feedback" style="width: 100%;">Your
                            username is required.</div>
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

<%-- 스크립트 링크 끝 --%>

<%@include file="../include/footer.jsp"%>