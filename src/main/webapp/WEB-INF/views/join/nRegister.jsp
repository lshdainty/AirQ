<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/join/nRegister.css" />
	
<%--일반 사용자 회원가입 시작 --%>
    <div class="form">
      <div class="tab-content">
        <div id="signup">   
          
          
          <form action="signup" method="POST">
          <h1>Sign Up</h1>
          <legend>일반 사용자 회원가입</legend>
          <div class="top-row">
            <div class="field-wrap">
              <label>ID<span class="req">*</span></label>
              <input type="text" id="id" name="id" required autocomplete="off" />
              <a id="btn-check">ID중복 확인</a><br/>
		      <p class="result"><span class="msg">테스트 중..</span><br/>
            </div>
        
            <div class="field-wrap">
              <label>
                Password<span class="req">*</span>
              </label>
              <input type="password" id="password" name="password" required autocomplete="off"/>
            </div>
          </div>

          <div class="field-wrap">
            <label>
              Name<span class="req">*</span>
            </label>
            <input type="text" id="name" name="name" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              E-mail<span class="req">*</span>
            </label>
            <input type="email" id="email" name="email" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Tel<span class="req">*</span>
            </label>
            <input type="text" id="tel" name="tel" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Address<span class="req">*</span>
            </label>
            <input type="text" id="address" name="address" required autocomplete="off"/>
          </div>
          
          <button type="submit" id="btn-join" disabled="disabled">JOIN</button>
          
          </form>

        </div><!-- signup -->
        
       
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
<%--일반 사용자 회원가입 끝 --%>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src='resources/js/join/register2.js'></script>
<%@include file="../include/footer.jsp" %>