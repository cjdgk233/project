<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script>
	function changeHall3() {

		var productHall = document.getElementById("productHall");

		console.log(productHall.value);

		var method = "POST";
		var param = "productHall=" + encodeURIComponent(productHall.value);
		var url = "${easyPath}/admin/changeHall3";

		console.log(url);

		sendRequest(url, param, resultchangeHall3, method);

	}

	var seatName = ""
	var inputText = [];

	function resultchangeHall3() {

		if (xhr.readyState == 4 && xhr.status == 200) {

			console.log("도착");

			var ajaxData = xhr.responseText;

			var seatRateList = JSON.parse(ajaxData);

			var selectOption = document.getElementById("selectOption");//옵션 요소를 가져온다.

			document.getElementById("seatRate-selector1").innerHTML = "";//select요소를 가져온다.

			document.getElementById("seatRate-selector2").innerHTML = "";

			document.getElementById("seatRate-selector3").innerHTML = "";

			var bannerStr = [];

			$(seatRateList)
					.each(
							function(index, dom) {

								var num = index + 1;

								bannerStr[index] += '<option id="selectOption" value="'+dom.seatRateSeq+'">'
										+ dom.seatRateName + '</option>'

								console.log(bannerStr[index]);

								inputText[index] = dom.seatRateName
										+ ' 등급좌석 가격 설정 <input type="number" name ="seatRatePrice'+num+'"/>';

								console.log(inputText[index]);

							}); 

			document.getElementById("seatRate-selector1").innerHTML = bannerStr[0]; 

			document.getElementById("seatRate-selector2").innerHTML = bannerStr[1];

			document.getElementById("seatRate-selector3").innerHTML = bannerStr[2];

			document.getElementById("insertInput1").innerHTML = inputText[0];
			document.getElementById("insertInput2").innerHTML = inputText[1];
			document.getElementById("insertInput3").innerHTML = inputText[2];

		}
	}

	function check() {

		document.registProduct.submit();

		seatRatePrice1 = document.getElementsByName("seatRatePrice1")[0];
		seatRatePrice1 = document.getElementsByName("seatRatePrice2")[0];
		seatRatePrice1 = document.getElementsByName("seatRatePrice3")[0];

		console.log(seatRatePrice1.value)
		console.log(seatRatePrice2.value)
		console.log(seatRatePrice3.value)

		var method = "POST";
		var param = "seatRatePrice1="
				+ encodeURIComponent(seatRatePrice1.value) + "&"
		"seatRatePrice2=" + encodeURIComponent(seatRatePrice2.value) + "&"
		"seatRatePrice3=" + encodeURIComponent(seatRatePrice3.value);

		var url = "${easyPath}/admin/registPrice";

		console.log(url);

		sendRequest(url, param, resultchangeHall3, method);
	}
</script>



<section class="section profile">
	<div class="row">
		<div align="center">
			<div class="col-lg-8">



				<div class="row">
					<div class="col-lg-12">

						<div class="card">
							<div class="card-body">
								<h5 class="card-title">작품 수정</h5>

								<!-- General Form Elements -->

								<form action="${ easyPath }/admin/registProduct" method="post"
									name="registProduct" enctype="multipart/form-data">


									<div class="row mb-3">
										<label for="inputText" class="col-sm-2 col-form-label">작품명</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="productName">
										</div>
									</div>

									<div class="row mb-3" align="right">
										<label class="col-sm-2 col-form-label">포스터 이미지</label>
										<div class="col-sm-10">
											<input type="file" name="file" class="form-control">
										</div>
									</div>

									<div class="row mb-3">
										<label for="inputNumber" class="col-sm-2 col-form-label">공연홀</label>
										<div class="col-sm-10">
											<select name="productHall" class="form-select"
												id="productHall" aria-label="Default select example"
												onchange="changeHall3()">
												<option value="">공연홀을 선택하세요</option>
												<c:forEach var="hallList" items="${hallList}">
													<option value="${hallList.hallSeq}">${hallList.hallName}</option>

												</c:forEach>
											</select>
										</div>
									</div>


									<div class="row mb-3">
										<label for="inputPassword" class="col-sm-2 col-form-label">공연시작일</label>
										<div class="col-sm-4">
											<input type="date" class="form-control"
												name="productPeriodBegin">
										</div>

										<label for="inputNumber" class="col-sm-2 col-form-label">공연종료일</label>
										<div class="col-sm-4">
											<input type="date" class="form-control"
												name="productPeriodEnd">
										</div>
									</div>

									<div class="row mb-3">
										<label for="inputNumber" class="col-sm-2 col-form-label">공연종류</label>
										<div class="col-sm-10">
											<select name="productPdType" class="form-select"
												aria-label="Default select example">
												<option value="">공연 종류를 선택하세요</option>
												<c:forEach var="pdTypeList" items="${pdTypeList}">
													<option value="${pdTypeList.pdTypeSeq}">${pdTypeList.pdTypeName}</option>

												</c:forEach>
											</select>
										</div>
									</div>



									<div class="row mb-3">
										<label for="inputDate" class="col-sm-2 col-form-label">관람(상영)시간</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="productRuntime">
										</div>
									</div>
									<div class="row mb-3">
										<label for="inputTime" class="col-sm-2 col-form-label">관람등급</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="productRate">
										</div>
									</div>
						

							<div class="row mb-3">
								<label for="inputNumber" class="col-sm-2 col-form-label">좌석
									등급 선택 </label>
								<div class="col-sm-10">
									<select name="priceBoxSeatRate1" class="form-select"
										id="seatRate-selector1" aria-label="Default select example"
										>

									</select>
								</div>
							</div>

				
					<div class="row mb-3">

						<div class="col-sm-10">
							<div class="col-sm-10" id="insertInput1"></div>
						</div>
					</div>



					<div class="row mb-3">
						<label for="inputNumber" class="col-sm-2 col-form-label">좌석
							등급 선택 </label>
						<div class="col-sm-10">
							<select name="priceBoxSeatRate2" class="form-select"
								id="seatRate-selector2" aria-label="Default select example"">

							</select>
						</div>
						<br>
						<div class="col-sm-10" id="insertInput2"></div>
					</div>

					<div class="row mb-3">
						<label for="inputNumber" class="col-sm-2 col-form-label">좌석
							등급 선택 </label>
						<div class="col-sm-10">
							<select name="priceBoxSeatRate3" class="form-select"
								id="seatRate-selector3" aria-label="Default select example"
								onchange="registPrice(this.value)">

							</select>
						</div>
						<br>
						<div class="col-sm-10" id="insertInput3"></div>




						<div class="row mb-3">
							<label for="inputPassword" class="col-sm-2 col-form-label">상세정보</label>
							<div class="col-sm-10">
								<textarea class="form-control" style="height: 100px"
									name="productDetail"></textarea>
							</div>
						</div>
						<div class="row mb-3">
							<label class="col-sm-2 col-form-label"></label>



							<div class="col-sm-3">
								<button class="btn btn-primary w-100" type="reset">초기화</button>
							</div>

							<div class="col-sm-3">

								<button class="btn btn-primary w-100" type="submit">작품
									등록</button>
</div>



							<div class="col-sm-3">

								<button type="button"
									onclick="location.href = '/ex/admin/registRoundForm'; "
									class="btn btn-primary w-100">작품 회차 등록</button>
							</div>
							</form>
							<!-- End General Form Elements -->

						</div>
					</div>

				</div>
</section>










