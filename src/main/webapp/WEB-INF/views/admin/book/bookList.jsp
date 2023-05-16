<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<c:set var="cpath" value="${ pageContext.request.contextPath }" />

<script>

function deleteBook(bookSeq){
	console.log(bookSeq);


	//alert("정말 예매를 취소하시겠습니까?")

	var method = "POST";
	var param = "bookSeq=" + encodeURIComponent(bookSeq);

	var url = "${easyPath}/book/deleteBook";

	sendRequest(url, param, resultUpdateDelete, method);//resultChangeDate - 에이작스가 실행된 후..자동으로 실행되는 메소드(콜백
	//메소드)
	//sendReqeust메서드는 첫번째 매개변수로 url, 두번째 매개변수는 파라미터, 세번째 매개변수는 콜백 메서드, 네번째
	//매개변수는 post또는 get의 전달 방식을 적는다.

	//콜백 메서드는 에이작스가 실행된 후..자동으로 실행되는 메서드이다.

}

function resultUpdateDelete() { //changeDated의콜백 메서드로 쓸 resultChangeDate를 만든다.

	if (xhr.readyState == 4 && xhr.status == 200) {

		var data = xhr.responseText;
		console.log("에이작스 도착");

			alert(data);
			

	}

}
	
</script>





<section class="section profile">
	<div class="row">
		<div align="center">
			<div class="col-lg-10">

				<div class="card">
					<div class="card-body">


						<h5 class="card-title">예약 내역</h5>


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
										<a href="#" class="datatable-sorter">예매 번호</a>
									</th>
									<th data-sortable="true" style="width: 15.912928759894463%;">
										<a href="#" class="datatable-sorter">공연 이름</a>
									</th>
									<th data-sortable="true" style="width: 7.71767810026385%;">
										<a href="#" class="datatable-sorter">회원 번호</a>
									</th>

									<th data-sortable="true" style="width: 11.192612137203167%;">
										<a href="#" class="datatable-sorter">결제 금액</a>
									</th>
									<th data-sortable="true" style="width: 11.261213720316622%;">
										<a href="#" class="datatable-sorter">공연 날짜</a>
									</th>
									<th data-sortable="true" style="width: 7.261213720316622%;">
										<a href="#" class="datatable-sorter">좌석 번호 </a>
									</th>
									
									<th data-sortable="true" style="width: 10.261213720316622%;">
										<a href="#" class="datatable-sorter">공연 회차</a>
									</th>
									
									<th data-sortable="true" style="width: 10.261213720316622%;">
										<a href="#" class="datatable-sorter">예매 상태</a>
									</th>
									<th data-sortable="true" style="width: 10.261213720316622%;">
										<a href="#" class="datatable-sorter"></a>
									</th>
								</tr>

							</thead>

							<c:choose>


								<c:when test="${empty bookList }">

									<tr>
										<td>회원이 없습니다.</td>
									</tr>
								</c:when>
								<c:otherwise>


									<c:forEach var="bookList" items="${bookList}">
										<!-- 테이블의 td 태그에 링크를 걸 필요가 있을 때, 자바스크립트 onClick 을 이용하여 링크를 걸어 줄 수 있다.
이 방법을 이용하면, td 태그 뿐만 아니라, tr   table  태그에도 링크를 걸 수 있다. 
177: onclick="location.href='${easyPath}/book/bookstep1Form' "  /product/{p}
콘솔 맽 끝으로 이동 - end키 누르기 (1번)  -->
										<tr class="rowColor">

											<td>${bookList.bookSeq}</td>
											<td>${bookList.bookProductName}</td>
											<td>${bookList.bookMember}</td>
											<td>${bookList.bookTotalPayment}</td>
											<td>${bookList.bookPayDate}</td>
											<td>${bookList.bookSeat}</td>
											
											<td>${bookList.bookRound}</td>
											
											<td>${bookList.bookPayStatus}</td>
						
													<td><button
													onclick="deleteBook('${bookList.bookSeq}')"
													class="btn btn-primary w-100">예매 취소</button></td>

											<!-- 자바스크립트 메서드로 매개변수를 넘길때 가로안에 '' 안에 매개변수를 넣어주어야 한다.
												매개변수가 두개면 각각 홑따옴표를 적어줘야 한다 
												-->
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