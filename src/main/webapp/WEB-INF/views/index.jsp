<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<html>

<body>

	<main id="main">

		<!-- ZenBlog -->
		<!-- 히어로 이미지 시작 -->
		<section id="hero-slider" class="hero-slider">
			<div class="container-md2" data-aos="fade-in">
				<div class="row">
					<div class="col-12">
						<div>
							<div>

								<div class="swiper-slide">
									<a href="${ easyPath }/product/282"
										class="img-bg2 d-flex align-items-end"
										style="background-image: url('${ easyPath}/resources/images/hero/BigBanner_PC_볼빨간사춘기.jpg')">
										<img
										src="${ easyPath}/resources/images/hero/BigBanner_PC_볼빨간사춘기.jpg">
									</a>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</section>


		<!-- 히어로 이미지 끝 -->

		<!-- Gp -->
		<!-- 베스트 공연/전시 시작 -->
		<section id="team" class="team">
			<div class="container" data-aos="fade-up">
				<!-- 타이틀 시작 -->
				<div class="section-title">
					<h2>베스트 공연/전시</h2>
				</div>
				<!-- 타이틀 끝 -->

				<div class="row">
					<!-- 파티션 시작 -->
					<c:forEach var="best" items="${ productList }">
						<div
							class="col-lg-3 col-md-6 d-flex align-items-stretch style='font-size=3em;">
							<div class="member" data-aos="fade-up" data-aos-delay="100">
								<a href="${ easyPath }/product/${ best.productSeq }"> <!-- 이미지 -->
									<div class="member-img2">
										<img
											src="${ easyPath }/resources/images/poster/${ best.productImage }"
											class="img-fluid" alt="">
									</div> <!-- 텍스트 -->
									<div class="member-info2">
										<h4>${ best.productName }</h4>
										<span>${ best.hallName }</span> <span>${ best.productPeriodBegin }
											~ ${ best.productPeriodEnd }</span>
									</div>
								</a>
							</div>
						</div>
					</c:forEach>
					<!-- 파티션 끝 -->
				</div>

			</div>
		</section>

	</main>




	<!-- Template Main JS File -->

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

</body>

</html>
