<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>



<section class="section profile">
	<div class="row">
		<div align="center">
			<div class="col-lg-8">



				<div class="row">
					<div class="col-lg-12">

						<div class="card">
							<div class="card-body">
								<h5 class="card-title">극장 설정</h5>

						
								<form action="${easyPath}/admin/registTheater" method="get"
									name="registTheater">


							<div class="row mb-3">
								<label for="inputText" class="col-sm-2 col-form-label">극장명</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="theaterName">
								</div>
							</div>
							
							<div class="row mb-3">
								<label for="inputText" class="col-sm-2 col-form-label">대표번호</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="theaterTel">
								</div>
							</div>
					
							<div class="row mb-3">
								<label for="inputPassword" class="col-sm-2 col-form-label"> 주소</label>
								<div class="col-sm-10">
									<input type="text" class="form-control"name="theaterAddress">
								</div>
							</div>



							<div class="row mb-3">
								<label for="inputNumber" class="col-sm-2 col-form-label">위도</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="theaterLatitude">
								</div>
							</div>


							<div class="row mb-3">
								<label for="inputNumber" class="col-sm-2 col-form-label">경도</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="theaterLongitude" >
								</div>
							</div>
							
	
									<div class="row mb-3">
										<label class="col-sm-2 col-form-label"></label>

										<div class="col-sm-3">
											<button class="btn btn-primary w-100" type="reset">초기화</button>
										</div>


										<div class="col-sm-3">
											<button class="btn btn-primary w-100" type="submit">극장
												등록</button>
										</div>
								</form>



								<!-- End General Form Elements -->

							</div>
						</div>

					</div>
</section>












