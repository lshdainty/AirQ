<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
   href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<!-- CSS Files -->
<link href="/resources/css/mypage/asset/material-dashboard.css"
   rel="stylesheet" />
 <div class="sidebar" data-color="purple" data-background-color="black"
      data-image="resources/images/sidebar-2.jpg">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo">
         <a href="#" class="simple-text logo-normal"> mypage seller </a>
      </div>
      <div class="sidebar-wrapper">
	<ul class="nav">
		<li class="nav-item active  "><a class="nav-link"
			href="/mypageSeller"> <i class="material-icons">account_box</i>
				<p>MyPage</p>
		</a></li>

		<li class="nav-item  "><a class="nav-link"
			href="/mypageSellerPosts"> <i class="material-icons">library_books</i>
				<p>글관리</p>
		</a></li>
		<li class="nav-item "><a class="nav-link" href="/mypageSellerComment">
				<i class="material-icons">content_paste</i>
				<p>댓글 관리</p>
		</a></li>
		<li class="nav-item "><a class="nav-link"
			href="/mypageSellerSales"> <i class="material-icons">assessment_black</i>
				<p>매출 관리</p>
		</a></li>
	</ul>
</div>
   </div>