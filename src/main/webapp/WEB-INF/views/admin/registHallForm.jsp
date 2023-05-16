<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script>

</script>

<section class="section profile">
	<div class="row">
		<div align="center">
			<div class="col-lg-8">



				<div class="row">
					<div class="col-lg-12">

						<div class="card">
							<div class="card-body">
								<h5 class="card-title">공연홀 설정</h5>


								<form action="${easyPath}/admin/registHall" method="get"
									name="registHall">

									<div class="row mb-3">
										<label for="inputNumber" class="col-sm-2 col-form-label">극장
											선택</label>
										<div class="col-sm-8">
											<select name="hallTheater" class="form-select"
												aria-label="Default select example">
												<option value="">극장을 선택하세요</option>
												<c:forEach var="theaterlist" items="${theaterlist}">
													<option value="${theaterlist.theaterSeq}">${theaterlist.theaterName}</option>



												</c:forEach>
											</select>
										</div>
									</div>
									
									
									<div class="row mb-3">
										<label for="inputText" class="col-sm-2 col-form-label">공연홀
											이름</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" name="hallName">
										</div>
									</div>
									
									

									<div class="row mb-3">
										<label for="inputText" class="col-sm-2 col-form-label">대표번호</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" name="hallTel">
										</div>
									</div>
									<div class="row mb-3">
										<label for="inputNumber" class="col-sm-2 col-form-label">좌석
											등급 선택</label>

										<div class="col-sm-3">
											<select name="hallSeatRate1" class="form-select"
												aria-label="Default select example">
												<option value="">좌석등급1</option>
												<c:forEach var="seatrateList" items="${seatrateList}">
													<option value="${seatrateList.seatRateSeq}">${seatrateList.seatRateName}</option>



												</c:forEach>
											</select>
										</div>

										<div class="col-sm-3">
											<select name="hallSeatRate2" class="form-select"
												aria-label="Default select example">
												<option value="">좌석등급2</option>
												<c:forEach var="seatrateList" items="${seatrateList}">
													<option value="${seatrateList.seatRateSeq}">${seatrateList.seatRateName}</option>



												</c:forEach>
											</select>
										</div>

										<div class="col-sm-3">
											<select name="hallSeatRate3" class="form-select"
												aria-label="Default select example">
												<option value="">좌석등급3</option>
												<c:forEach var="seatrateList" items="${seatrateList}">
													<option value="${seatrateList.seatRateSeq}">${seatrateList.seatRateName}</option>



												</c:forEach>
											</select>
										</div>
									</div>







									<div class="row mb-3">
										<label class="col-sm-2 col-form-label"></label>

										<div class="col-sm-3">
											<button class="btn btn-primary w-100" type="reset">초기화</button>
										</div>


										<div class="col-sm-3">
											<button class="btn btn-primary w-100" type="submit">공연홀
												등록</button>
										</div>
								</form>





								<!-- End General Form Elements -->

							</div>
						</div>

					
					</section>
