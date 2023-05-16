<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<c:set var="cpath" value="${ pageContext.request.contextPath }" />

<script>
	
</script>





<section class="section profile">
	<div class="row">
		<div align="center">
			<div class="col-lg-10">

				<div class="card">
					<div class="card-body">


						<h5 class="card-title">회원리스트</h5>


						<!-- Uncomment below if you prefer to use an image logo -->
						<!-- <a href=index.html" class="logo"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->






						<i class="bi bi-list mobile-nav-toggle"></i>
						</nav>

					</div>
					</header>
				</div>


				<div align="right">








					<!-- 리스트 -->


					<div class="datatable-container">

						<table class="table datatable datatable-table">

							<thead>
								<tr>
									<th data-sortable="true" style="width: 7.9155672823219%;">
										<a href="#" class="datatable-sorter">회원 번호</a>
									</th>
									<th data-sortable="true" style="width: 15.912928759894463%;">
										<a href="#" class="datatable-sorter">회원 아이디</a>
									</th>
									<th data-sortable="true" style="width: 7.71767810026385%;">
										<a href="#" class="datatable-sorter">이름</a>
									</th>

									<th data-sortable="true" style="width: 11.192612137203167%;">
										<a href="#" class="datatable-sorter">전화번호</a>
									</th>
									<th data-sortable="true" style="width: 22.261213720316622%;">
										<a href="#" class="datatable-sorter">주소</a>
									</th>
									<th data-sortable="true" style="width: 7.261213720316622%;">
										<a href="#" class="datatable-sorter">탈퇴 여부 </a>
									</th>
									<th data-sortable="true" style="width: 10.261213720316622%;">
										<a href="#" class="datatable-sorter">멤버쉽</a>
									</th>
								</tr>

							</thead>

							<c:choose>


								<c:when test="${empty memberList }">

									<tr>
										<td>회원이 없습니다.</td>
									</tr>
								</c:when>
								<c:otherwise>


									<c:forEach var="memberList" items="${memberList}">
										<!-- 테이블의 td 태그에 링크를 걸 필요가 있을 때, 자바스크립트 onClick 을 이용하여 링크를 걸어 줄 수 있다.
이 방법을 이용하면, td 태그 뿐만 아니라, tr   table  태그에도 링크를 걸 수 있다. 
177: onclick="location.href='${easyPath}/book/bookstep1Form' "  /product/{p}
콘솔 맽 끝으로 이동 - end키 누르기 (1번)  -->
										<tr class="rowColor">

											<td>${memberList.memberSeq}</td>
											<td>${memberList.memberId}</td>

											<td>${memberList.memberName}</td>
											<td>${memberList.memberTel}</td>
											<td>${memberList.memberAddress}</td>
											<td>${memberList.memberWithdrawal}</td>
											<td><c:choose>
													<c:when test="${memberList.memberMembership == 1}">일반회원 </c:when>
													<c:when test="${memberList.memberMembership == 4}">관리자</c:when>

												</c:choose></td>
											<!-- 자바스크립트 메서드로 매개변수를 넘길때 가로안에 '' 안에 매개변수를 넣어주어야 한다.
												매개변수가 두개면 각각 홑따옴표를 적어줘야 한다 -->
										</tr>

									</c:forEach>


								</c:otherwise>
							</c:choose>


						</table>
</section>


<%-- <div class="row">
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
</section> --%>