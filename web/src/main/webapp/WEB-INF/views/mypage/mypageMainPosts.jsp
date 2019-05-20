<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageMainPosts.css" />
    <div class="container">
    <div class="Posts">
        <p></p>
    </div >
<div id="form1">
        <section class="content">
            <main>
           <%--상단 부분 시작 --%>
       <div class="form1">
       <div class="A">제목</div>
       <div class="AA">신고자</div>
       <div class="AAA">게시글 코드</div>
<!--        <div class="AAAA">신고횟수</div> -->
       <div class="AAAAA">신고 날짜</div>
       <div class="AAAAAA">삭제 여부</div>
            <select class="C"id="change">
            	<option value="0">모든 글 보기</option>
                <option value="1" id="selectA">입찰 서비스</option>
                <option value="2" id="selectB">업체 분석/비교</option>
                <option value="3" id="selectC">커뮤니티</option>
            </select>
            </div>
        <%--상단 부분 끝 --%>
        <br>
        
		<%-- 하단부분 시작  --%>
		    <c:forEach var="mypageMainR" items="${mypageMainR}">
      		<div class="form2" id="select1"> 
            <div class="report_title">${mypageMainR.report_title }</div> 
            <div class="member_id">${mypageMainR.member_id }</div> 
            <div class="original_code">${mypageMainR.original_code }</div>
<%--             <div class="report_count">${mypageMainR.report_count }</div> --%>
            <div class="report_date">${fn:substring(mypageMainR.report_date, 0 ,10) }</div>
            <div class="delete_whether">${mypageMainR.delete_whether }</div>
<%--             <a href="<c:url value='/tenderContentGo/${tenderList.tender_code }' />" class="btn btn-primary">상세정보</a> --%>
<%--             <a href="<c:url value='/mypageMainPosts/${mypageMainR.tender_code }' />" class="btn btn-danger">글삭제</a> --%>

        </div>
        </c:forEach>


<%--         TENDER --%>
<%--         <c:forEach var="tenderList" items="${tenderList}"> --%>
<!--         <div class="form2" id="select1"> -->
<!--         	<div class="">입찰 서비스</div> -->
<%--             <div class="tender_title">${tenderList.tender_title }</div>  --%>
<%--             <div class="requirement">${tenderList.requirement }</div>  --%>
<%--             <div class="tender_member_id">${tenderList.member_id }</div> --%>
<%--             <div class="t_creation_date">${tenderList.t_creation_date }</div> --%>
<%--             <a href="<c:url value='/tenderContentGo/${tenderList.tender_code }' />" class="btn btn-primary">상세정보</a> --%>
<%--              <a href="<c:url value='/mypageMainPosts/${tenderList.tender_code }' />" class="btn btn-danger">글삭제</a> --%> 
<!--         	<div class=""> -->
<%--         	참여업체수:${tenderList.company_count} --%>
<%--         	입찰마감일자:<c:out value="${fn:substring(tenderList.tender_deadline, 0, 10)}"></c:out> --%>
<!--         	</div> -->
<!--         </div> -->
<%--         </c:forEach> --%>
        
<%--         PRODUCT --%>
<%--         <c:forEach var="productMP" items="${productMP}"> --%>
<!--         <div class="form3" id="select2"> -->
<!-- 			<div class="">업체 분석/비교</div> -->
<%--             <div class="product_code">${productMP.product_name }</div>  --%>
<%--             <div class="product_detail">${productMP.product_detail }</div>  --%>
<%--             <div class="product_member_id">${productMP.companyVO.member_id}</div> --%>
<%--             <a href="<c:url value='/product?product_code=${productMP.product_code }' />" class="btn btn-primary">상세정보</a> --%>
<%--             <a href="<c:url value='/mypageMainPostsProduct/${productMP.product_code }' />" class="btn btn-danger">글삭제</a>         --%>
<%--         	<div class="">가격:${productMP.product_price},측정지점:${productMP.measure_point}</div> --%>
<!--         </div> -->
<%--         </c:forEach> --%>
        
<%--         POST --%>
<%--         <c:forEach var="postMP" items="${postMP}"> --%>
<!--         <div class="form4" id="select3"> -->
<%-- 			<div class="">${postMP.board_name }</div> --%>
<%--             <div class="post_title">${postMP.post_title }</div>  --%>
<%--             <div class="post_content">${postMP.post_content }</div>  --%>
<%--             <div class="member_id">${postMP.member_id }</div> --%>
<%--             <div class="p_creation_date">${postMP.p_creation_date }</div> --%>
<%--             <a href="<c:url value='/postDetail?post_code=${postMP.post_code }' />" class="btn btn-primary">상세정보</a> --%>
<%--             <a href="<c:url value='/mypageMainPostsPost/${postMP.post_code }' />" class="btn btn-danger">글삭제</a>                 --%>
<%--         	<div class="">조회수:${postMP.view_num },추천수:${postMP.recommend_num },댓글수:${postMP.reply_count }</div> --%>
<!--         </div> -->
<%--         </c:forEach> --%>
        
        <%--하단부분 끝 --%>
            </main>
        </section>
        </div>
        <footer>

        </footer>
        </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src='/resources/js/mypage/mypageMainPosts.js'></script>
<%@include file="../include/footer.jsp" %>