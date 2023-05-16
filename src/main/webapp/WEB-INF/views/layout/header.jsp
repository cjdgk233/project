<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="easyPath" value="${ pageContext.request.contextPath }" />


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">


<meta content="" name="description">
<meta content="" name="keywords">

<!-- 네이버 지도 -->
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=3nbhfj13az"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.7.js"></script>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.1.js"
	integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
	crossorigin="anonymous"></script>
	
	<!-- 네이버 로그인 -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"charset="utf-8"></script>





<!-- ajax -->
<script src="${ easyPath }/resources/js/httpRequest.js"></script>


<!-- Favicons -->
<link href="${ easyPath }/resources/onepage/img/favicon.png" rel="icon">


<!-- Google Fonts -->
<!-- Medilab -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">



<!-- Template Main CSS File -->
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">




<link href="${ easyPath }/resources/anyar/css/style.css"
	rel="stylesheet">
<link href="${ easyPath }/resources/niceadmin/css/style.css"
	rel="stylesheet">
<link href="${ easyPath }/resources/ZenBlog/css/style.css"
	rel="stylesheet">

<link href="${easyPaht}/resources/medilab/css/style/css"
	rel="stylesheet">

<script>
	
</script>

</head>

<div id="topbar" class=" d-flex align-items-center topbar-inner-pages">
	<div
		class="container d-flex align-items-center justify-content-center justify-content-md-between">
		<div class="contact-info d-flex align-items-center">
			<c:choose>
				<c:when test="${ !empty login}">
					<%--empty -> 없으면인데 앞에 !로 반전을 줬으므로 있다면이라는 뜻이 된다. --%>
					<i class="bi bi-envelope"></i>
					<a href="${ easyPath }/member/logout">로그아웃</a>
					<i class="bi bi-envelope"></i>
					<a href="${ easyPath }/member/myPage">마이페이지</a>
					<i class="bi bi-envelope"></i>
					<a href="${ easyPath }/member/deleteForm">회원탈퇴</a>
					<i class="bi bi-envelope"></i>
					<a href="${ easyPath }/book/cart">장바구니</a>
					<i class="bi bi-envelope"></i>
					<a href="${ easyPath }/admin/result">고객센터</a>
					<c:choose>
						<c:when test="${admin == 4}">
							<i class="bi bi-envelope"></i>
							<a href="${ easyPath }/admin/productList">관리자페이지</a>
						</c:when>
					</c:choose>

				</c:when>
				<c:otherwise>
					<a href="${ easyPath }/member/loginForm">로그인</a>
					<i class="bi bi-envelope"></i>
					<a href="${ easyPath }/member/joinForm">회원가입</a>
					<i class="bi bi-envelope"></i>
					<a href="${ easyPath }/admin/result">고객센터</a>

				</c:otherwise>
			</c:choose>

			<!-- 관리자 회원이 로그인 했을 경우 보여준다 -->
		</div>

	</div>
</div>







<!-- ======= Header ======= -->


<header id="header"
	class="fixed-top d-flex align-items-center header-inner-pages">
	<div
		class="container d-flex align-items-center justify-content-between">

		<h1 class="logo">
			<a href="/ex/">EasyTicket</a>
		</h1>

		<!-- Uncomment below if you prefer to use an image logo -->
		<!-- <a href=index.html" class="logo"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

		<nav id="navbar" class="navbar">

			<li class="dropdown"><a href="#"><span>공연</span> <i
					class="bi bi-chevron-down"></i></a>
				<ul>
					<li class="nav-link scrollto"><a href="#">뮤지컬</a></li>
					<li><a href="#">연극</a></li>
					<li><a href="#">콘서트</a></li>
					<li><a href="#">클래식/무용</a></li>

				</ul></li>
			<li class="dropdown"><a href="#"><span>지역</span> <i
					class="bi bi-chevron-down"></i></a>
				<ul>
					<li><a href="#">서울</a></li>
					<li><a href="#">경기/인천</a></li>
					<li><a href="#">충청/강원</a></li>
					<li><a href="#">대구/경북</a></li>
					<li><a href="#">부산/경남</a></li>
					<li><a href="#">광주/전라</a></li>
					<li><a href="#">제주</a></li>
				</ul></li>
			<li class="dropdown"><a href="#"><span>공연장</span> <i
					class="bi bi-chevron-down"></i></a>
				<ul>
					<li><a href="#">롯데콘서트홀</a></li>
					<li><a href="#">세종문화회관</a></li>
					<li><a href="#">LG아트센터 서울</a></li>
					<li><a href="#">대구수성아트피아</a></li>
					<li><a href="#">금호아트홀</a></li>
					<li><a href="#">안동문화예술의전당</a></li>
					<li><a href="#">대구콘서트하우스</a></li>
					<li><a href="#">대구문화예술회관</a></li>
					<li><a href="#">경주예술의전당</a></li>
					<li><a href="#">대덕문화전당/음악창작소</a></li>
					<li><a href="#">달서아트센터</a></li>
					<li><a href="#">어울아트센터</a></li>
					<li><a href="#">아양아트센터</a></li>
					<li><a href="#">광주문화예술회관</a></li>
					<li><a href="#">봉산문화회관</a></li>
					<li><a href="#">국립극장</a></li>
				</ul></li>

			<form action="${ easyPath }/index/searchProduct" method="get"
				name="searchProduct">
				<div class="input-group">
					<button class="input-group-text" type="submit">
						<img src="${ easyPath }/resources/niceadmin/img/search.png">
					</button>
					<input type="text" name="searchWord" class="form-control"
						autocomplete="off" placeholder="공연명 검색">
				</div>
			</form>
			</li>
			</ul>
			<i class="bi bi-list mobile-nav-toggle"></i>
		</nav>

	</div>
</header>
<!-- End Header -->






<!-- .navbar -->

</div>
</header>
<!-- End Header -->

<main id="main">