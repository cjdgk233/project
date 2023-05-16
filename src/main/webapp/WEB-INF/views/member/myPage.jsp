<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<script>


function checkPw(){
	
	var _width = '650';
    var _height = '380';
    
	let url = "${easyPath}/member/checkPasswordForm";
 
    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
    var _left = Math.ceil(( window.screen.width - _width )/2);
    var _top = Math.ceil(( window.screen.height - _height )/2); 
 
    window.open(url, 'parent', 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top );
 

	
}



</script>

<body>

	<main id="main" class="main">



		</div>
		<!-- End Page Title -->

		<section class="section profile">
			<div class="row">

				<div class="col-xl-4">

					<div class="card">
						<div
							class="card-body profile-card pt-4 d-flex flex-column align-items-center">

							<img src="${easyPath}/resources/niceadmin/img/cat.jpg"
								alt="Profile" class="rounded-circle">
							<h2>${ mvo.memberName }</h2>
							<div class="social-links mt-2"></div>
						</div>
					</div>

					<br> <br>


					<div align="center">
					 <button class="d-none d-md-inline" class="btn btn-primary w-100"  onclick="checkPw()">회원정보 수정하기</button></a>
					</div>

				</div>

				<div class="col-xl-8">

					<div class="card">
						<div class="card-body pt-3">
							<!-- Bordered Tabs -->

							<div class="tab-content pt-2">

								<div class="tab-pane fade show active profile-overview"
									id="profile-overview" role="tabpanel">



									<div class="row">
										<div class="col-lg-3 col-md-4 label ">이름</div>
										<div class="col-lg-9 col-md-8">${ mvo.memberName }</div>
									</div>

									<div class="row">
										<div class="col-lg-3 col-md-4 label">주소</div>
										<div class="col-lg-9 col-md-8">${ mvo.memberAddress }</div>
									</div>

									<div class="row">
										<div class="col-lg-3 col-md-4 label">전화번호</div>
										<div class="col-lg-9 col-md-8">${ mvo.memberTel }</div>
									</div>
									
									

									<div class="row">
							
										<div class="col-lg-3 col-md-4 label">회원등급</div>
										    <c:choose>
										<c:when test="${mvo.memberMembership == 4 }">	
												<c:set var="membership" value="관리자"/>							
										<div class="col-lg-9 col-md-8">${membership}</div>
										
										</c:when>
										<c:otherwise>
										<c:set var="membership" value="일반 회원"/>		
										<div class="col-lg-9 col-md-8">${membership}</div>
										</c:otherwise>
										</c:choose>
									</div>

								</div>

								</form>
								<!-- End Profile Edit Form -->

							</div>



						</div>
					</div>

				</div>
			</div>
		<br>
		

	<div class="row">
		<div align="center">
			<div class="col-lg-10">

				<div class="card">
					<div class="card-body">
						<!-- 타이틀 -->
						<h5 class="card-title"></h5>
						<h5 class="card-title">예매내역</h5>
			
						<br>

						<div class="datatable-container">

							<table class="table datatable datatable-table">

					
								<thead>
									<tr>
										<th data-sortable="true" style="width: 17.9155672823219%;">
											<a href="#" class="datatable-sorter">예매번호</a>
										</th>
										<th data-sortable="true" style="width: 17.912928759894463%;">
											<a href="#" class="datatable-sorter">티켓명</a>
										</th>
										<th data-sortable="true" style="width: 17.71767810026385%;">
											<a href="#" class="datatable-sorter">관람일시</a>
										</th>

									
										<th data-sortable="true" style="width: 17.261213720316622%;">
											<a href="#" class="datatable-sorter">취소가능일</a>
										</th>
										<th data-sortable="true" style="width: 17.261213720316622%;">
											<a href="#" class="datatable-sorter">상태</a>
										</th>
									</tr>

								</thead>
								
								<c:choose>
								
				
								<c:when test="${empty bookList}">
								
								<tr>
								<td>예매내역이 없습니다.</td>
								</tr>
									</c:when>
								<c:otherwise>
								
								<c:forEach var = "bvo" items="${bookList}" >
								<tr a href="${ easyPath }/notice/notice">
								<td>${bvo.bookSeq}</td>
								<td>${bvo.bookProductName}</td>
								<td>${bvo.bookProductDate}</td>
						
								<td>${bvo.bookCxLastDate}</td>
								<td>예매완료</td>
								<td><button class="btn btn-primary w-100" onclick="cancle()">예매취소</button></td>
								
							</tr>
								</c:forEach>
								
							
								</c:otherwise>
								</c:choose>
							

							</table>
</section>

	</main>
</body>

