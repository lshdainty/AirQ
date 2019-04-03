<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageMainPosts.css" />
    <div class="container">
    <div class="login-main-text">
        <p>mypageMainPosts page</p>
    </div>

        <section class="content">
            <main>
           <div class="A">
       <div class="form1" style="border: 1px solid red">
          <input type="checkbox">
           <select class="A"id="변경" style="border: 1px solid red; margin-right:40%;">
               <option value="1">비공개</option>
               <option value="2">공개</option>
               <option value="3">삭제</option>
           </select>
           
           <div class="B" style="display:inline-block">글쓴이</div>
            <select class="C"id="변경2" style="float: right;">
                <option value="1">모든글보기</option>
                <option value="1">공개글보기</option>
                <option value="1">업체연결서비스</option>
                <option value="1">커뮤니티</option>
            </select>
            </div>
        </div>
        <br>
        <c:forEach var="tenderList" items="${tenderList}">
        <div class="form2" style="border: 1px solid red">

            <div class="A"style="width:15%;  text-overflow:ellipsis; overflow:hidden; display:inline-block" ><input type="checkbox">${tenderList.ttitle }</div> 
            <div class="C"style="width:40%; height:50px; text-overflow:ellipsis; overflow:hidden; display:inline-block">${tenderList.trequirement }</div> 
            <div class="B" style="width:15%; height:50px; display:inline-block">${tenderList.tname }</div>
            <div class="C"style="height:50px; display:inline-block">${tenderList.tmeasurementdate }</div>

        </div>
        </c:forEach>
            </main>
        </section>
        <footer>

        </footer>
        </div>
<%@include file="../include/footer.jsp" %>