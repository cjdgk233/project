<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<c:set var="cpath" value="${ pageContext.request.contextPath }" />

<script>
	function checkDelete(productSeq, name) {

		console.log(productSeq)
		console.log(name)
		alert(name + "을 삭제하시겠습니까?")

		var url = "${easyPath}/admin/delete/" + productSeq;

		console.log(url);

		location.href = url;

	}
</script>





<section class="section profile">
	<div class="row">
		<div align="center">
			<div class="col-lg-10">

				<div class="card">
					<div class="card-body">


						<h5 class="card-title">작품리스트</h5>


						<!-- Uncomment below if you prefer to use an image logo -->
						<!-- <a href=index.html" class="logo"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->






						<i class="bi bi-list mobile-nav-toggle"></i>
						</nav>

					</div>
					</header>
				</div>






					<nav>

						<ul class="list-menu">
							<li>극장 관리

								<ul class="sub-menu">
									<li><a href="${ easyPath }/admin/registTheaterForm">극장
											관리</a></li>

									<li><a href="${ easyPath }/admin/registHallForm">공연홀
											설정</a></li>
									<li><a href="${ easyPath }/admin/registDiscountForm">할인
											관리</a></li>
									<li><a href="${ easyPath }/admin/registProduct">공연 등록
									</a></li>
									<li><a href="${ easyPath }/admin/updateProductForm">공연
											수정 </a></li>
									<li><a href="${ easyPath }/admin/registRoundForm">공연
											회차 등록 </a></li>

								</ul>
							</li>
							<li>회원 관리

								<ul class="sub-menu">

									<li><a href="${ easyPath }/admin/member/memberList">회원리스트</a></li>
								</ul>

							</li>
							<li>회원관리</a>
								<ul class="sub-menu">
									<li><a href="${ easyPath }/admin/book/bookList">예약 내역</a>
								</ul>

							</li>
						</ul>


					</nav>




					<!-- 리스트 -->
				<div align="right">

					<div class="datatable-container">

						<table class="table datatable datatable-table">

							<thead>
								<tr>
									<th data-sortable="true" style="width: 7.9155672823219%;">
										<a href="#" class="datatable-sorter">작품 번호</a>
									</th>
									<th data-sortable="true" style="width: 23.912928759894463%;">
										<a href="#" class="datatable-sorter">작품명</a>
									</th>
									<th data-sortable="true" style="width: 10.71767810026385%;">
										<a href="#" class="datatable-sorter">공연종류</a>
									</th>

									<th data-sortable="true" style="width: 17.192612137203167%;">
										<a href="#" class="datatable-sorter">공연홀</a>
									</th>
									<th data-sortable="true" style="width: 20.261213720316622%;">
										<a href="#" class="datatable-sorter">공연 기간</a>
									</th>
									<th data-sortable="true" style="width: 7.261213720316622%;">
										<a href="#" class="datatable-sorter">추가 </a>
									</th>
									<th data-sortable="true" style="width: 7.261213720316622%;">
										<a href="#" class="datatable-sorter">설정</a>
									</th>
								</tr>

							</thead>

							<c:choose>


								<c:when test="${empty pdList }">

									<tr>
										<td>작품이 없습니다.</td>
									</tr>
								</c:when>
								<c:otherwise>


									<c:forEach var="pdList" items="${pdList}">
									
										<tr class="rowColor">

											<td>${pdList.productSeq}</td>
											<td>${pdList.productName}</td>
											<td>${pdList.pdTypeName}</td>
											<td>${pdList.hallName}</td>
											<td>${pdList.productPeriodBegin}~
												${pdList.productPeriodEnd}</td>
											<td><c:set var="seq" value="${pdList.productSeq}" />
												<button class="btn btn-primary w-100"
													onclick='location.href="${easyPath}/admin/updateProductForm/${seq}"'>
													수정</button></td>
											<td><button
													onclick="checkDelete('${pdList.productSeq}','${pdList.productName}')"
													class="btn btn-primary w-100">삭제</button></td>
											
										</tr>

									</c:forEach>


								</c:otherwise>
							</c:choose>


						</table>
</section>


<div class="row">
	<div align="center">
		<div class="col-lg-8">


			<div class="btnBox">
				<form action="${easyPath}/admin/productList" method="get"
					onsubmit="return check(this)">
					<span style="float: left;"> <select name="type">
							<option value="PRODUCT_SEQ"
								${param.type == 'PRODUCT_SEQ' ? 'selected' : '' }>작품번호로
								검색</option>
							<option value="PRODUCT_NAME"
								${param.type == 'PRODUCT_NAME' or empty param.type ? 'selected' : '' }>작품이름으로
								검색</option>
							<option value="PRODUCT_PDTYPE"
								${param.type == 'PRODUCT_PDTYPE' or empty param.type ? 'selected' : '' }>작품종류로
								검색</option>
					</select> <input type="text" name="word" placeholder="검색어를 입력하세요"
						value="${param.word }" autocomplete="off"> <input
						class="btn btn-primary" type="submit" value="검색">
					</span>
				</form>

			</div>

			<c:if test="${paging.prev }">
				<a href="${easyPath }/admin/productList?page=${paging.begin - 1}">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${paging.begin }" end="${paging.end }"
				step="1">
				<c:choose>
					<c:when test="${i == paging.page }">
						<strong>[${i}]</strong>
					</c:when>
					<c:otherwise>
						<a href="${easyPath }/admin/productList?page=${i}">[${i }]</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.next}">
				<a href="${easyPath }/admin/productList?page=${paging.end + 1}">[다음]</a>
			</c:if>

		</div>
	</div>
</div>
</section>