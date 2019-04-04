<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageMainPosts.css" />
    <div class="container" style="border: 1px solid red">
    <div class="login-main-text">
        <p>mypageMainPosts page</p>
    </div >
<form id="form1">
        <section class="content">
            <main>
           <%--상단 부분 시작 --%>
       <div class="form1" style="border: 1px solid green">
          <input type="checkbox" id="all" name="all">
           <select class="A"id="변경" style=" width:15%;">
           	   <option value="1">선택</option>
               <option value="1">비공개</option>
               <option value="2">공개</option>
               <option value="3">삭제</option>
           </select>
           <div class="check" style="display:inline-block; width:10%;"><button type="submit" id="check1" class="btn btn-check">확인</button></div>
           
           <div class="B" style="display:inline-block; margin-left:28%;">글쓴이</div>
            <select class="C"id="변경2" style="float: right;">
                <option value="1">모든글보기</option>
                <option value="1">공개글보기</option>
                <option value="1">업체연결서비스</option>
                <option value="1">커뮤니티</option>
            </select>
            </div>
        <%--상단 부분 끝 --%>
        <br>
        <%-- 하단부분 시작 --%>
        <c:forEach var="tenderList" items="${tenderList}"
        varStatus="index" begin="0" end="4"> <%--인덱스를 주어 0번부터 4번까지 5개만 데이터를 뽑아낸다. --%>
        <div class="form2" style="border: 1px solid blue">

            <div class="ttitle"style="width:15%;  text-overflow:ellipsis; overflow:hidden; display:inline-block" ><input type="checkbox" id="cb" name="cb">${tenderList.ttitle }</div> 
            <div class="trequirement"style="width:40%; height:50px; text-overflow:ellipsis; overflow:hidden; display:inline-block">${tenderList.trequirement }</div> 
            <div class="tname" style="width:15%; height:50px; display:inline-block">${tenderList.tname }</div>
            <div class="tmeasurementdate"style="height:50px; display:inline-block">${tenderList.tmeasurementdate }</div>
			<div class="selection" style="display:inline-block;"><select class="selectionIn"id="open">
                <option value="1">선택</option>
                <option value="1">공개</option>
                <option value="1">비공개</option>
                <option value="1">삭제</option>
            </select></div>
            <div class="check" style="display:inline-block; width:10%;"><button type="submit" id="check2" class="btn btn-check">확인</button></div>
            
        </div>
        </c:forEach>
        
        <%--하단부분 끝 --%>
            </main>
        </section>
        </form>
        <footer>

        </footer>
        </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src='/resources/js/mypage/mypageMainPosts.js'></script>
<%@include file="../include/footer.jsp" %>