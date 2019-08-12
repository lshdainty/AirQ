<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="/resources/css/login/loginMain.css" />
<div id="fullBg">
	<div class="app">
		<div class="member-card-layout">
			<div class="member-card-layout__container">
				<div class="member-card-layout__inner">
					<h1 class="member-card-layout__logo">
						<img class="member-card-layout__logo-image"
							src="/resources/images/airqWebLogo.png" alt="AirQ" style="height:50px; width:143px;">
					</h1>
					<div class="login">
						<form>
							<h2 class="login__email-title">Login</h2>
							<div class="member-input">
								<div class="member-input__state">
									<input id="ID" class="member-input__box" type="text"
										autocomplete="off" name="email" value=""> <label
										for="memberInput2562" class="member-input__label">ID</label> <span
										class="member-input__valid-wrapper"></span>
								</div>
							</div>
							<div class="member-input">
								<div class="member-input__state">
									<input id="PASS" class="member-input__box" type="password"
										autocomplete="off" name="password" value=""> <label
										for="memberInput797" class="member-input__label">
										PASSWORD </label> <span class="member-input__valid-wrapper"></span>
								</div>
							</div>
							<div class="member-input-wrong-message" style="display:none;"></div>
							<div class="login__l">
							<div class="login__l">
								<div class="login__checkbox">
									<div class="member-checkbox">
										<span class="member-checkbox__state"> <input
											id="memberCheckbox6277" type="checkbox"
											class="member-checkbox__input">
										</span> <label for="memberCheckbox6277"
											class="member-checkbox__label"> Remember Me </label>
									</div>
								</div>
								<span class="login__find-password-btn"><a
									class="member-link" href="/findId">Forgot ID?</a></span>
							</div>
									<span class="login__find-password-btn"><a
								class="member-link" href="/findPw">Forgot Password?</a></span>
							</div>
							<button type="button" class="member-button login__btn"
								disabled="">LOGIN</button>
							<div class="login__l-sign-up">
								Don’t have an account?<span class="login__sign-up-link"><a
									class="member-link" href="/joinMain">Sign
										Up</a></span>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src='/resources/js/login/loginMain.js'></script>
<%@include file="../include/footer.jsp"%>