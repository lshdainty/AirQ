<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageMainCategory.css" />
<h1>관리자-카테고리 관리 페이지 입니다.</h1>
<h2>삭제예정ㅍㅔ이지입니다.</h2>
    <style>
        
        .container{
            
        }
        *{
            box-sizing: border-box;
        }
        .container{
            border:5px solid black;
        }
        /*컨테이너 바로 밑에 있는 것들의 스타일    >=직계자손  *=모든것 */
        .container>*{
            border: 5px solid blue;
        }
        .container>.content>*{
            border:5px solid red;
        }
        .container .content{
            padding-left: 200px;
            padding-right: 150px;
            overflow:hidden;
        }
        .container .content>*{
            float:left;
            padding-bottom: 2000px;
            margin-bottom: -2000px;
        }
        .container .content main{
            width:100%;
        }
        .container .content nav{
            width: 200px;
            margin-left: -100%;
            left:-200px;
            position: relative;
        }
        .container .content aside{
            width: 150px;
            margin-right: -150px;
        }
        /*float 지정 해제 해줌*/
        .container footer{
            clear: both;
        }
        /*599px보다 웹페이지를 줄이면 일렬로 나타나게*/
                @media (max-width:599px){
             .container>.content>*{
            border:5px solid red;
        }
        .container .content{
            padding-left: 0px;
            padding-right: 0px;
            overflow:visible;
        }
        .container .content>*{
            float:none;
            padding-bottom: 0px;
            margin-bottom: 0px;
        }
        .container .content main{
            width:100%;
            margin: 0 auto;
            
        }
        .container .content nav{
            width: auto;
            margin-left: 0;
            left:0;
            position: relative;
        }
        .container .content aside{
            width: auto;
            margin-right: 0;
        }
        }
    </style>

    <div class="container">
    <div class="login-main-text">
        <h2>Application<br> Login Page</h2>
        <p>Login or register from here to access.</p>
    </div>

        <section class="content">
            <main>
    <div class="col-md-6 col-sm-12">
        <div class="login-form">
            <form>
                <div class="form-group">
                    <label>User Name</label>
                    <input type="text" class="form-control" placeholder="User Name">
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" placeholder="Password">
                </div>

            </form>
        </div>
    </div>
            </main>
            <nav>

            </nav>
            <aside>
            
            </aside>

        </section>

    </div>

<%@include file="../include/footer.jsp" %>