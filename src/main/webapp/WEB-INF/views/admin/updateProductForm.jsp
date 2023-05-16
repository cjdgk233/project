<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script>
	function changeProductHall() {

		var productHall = document.getElementById("productHall");

		console.log(productHall.value);

		var method = "POST";
		var param = "productHall=" + encodeURIComponent(productHall.value);
		var url = "${easyPath}/admin/changeProductHall";

		console.log(url);

		sendRequest(url, param, resultchangeHall, method);

	}

	var seatName = ""
	var inputText = [];

	function resultchangeHall() {

		if (xhr.readyState == 4 && xhr.status == 200) {

			var ajaxData = xhr.responseText;

			var seatRateList = JSON.parse(ajaxData);

			var selectOption = document.getElementById("selectOption");

			document.getElementById("seatRate-selector1").innerHTML = "";

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
								<h5 class="card-title">공연 수정</h5>

								<!-- General Form Elements -->

								<div class="row mb-3">
									<label for="inputText" class="col-sm-2 col-form-label">작품번호</label>
									<div class="col-sm-10">
										<input type="text" class="form-control"
											value="${pvo.productSeq}">
									</div>
								</div>

								<td><c:set var="seq" value="${pvo.productSeq}" />
									<form action="${ easyPath }/admin/updateProduct/${seq}"
										method="post" enctype="multipart/form-data">



										<div class="row mb-3">
											<label for="inputText" class="col-sm-2 col-form-label">작품명</label>
											<div class="col-sm-10">
												<input type="text" class="form-control"
													value="${pvo.productName}" name="productName">
											</div>
										</div>



										<div class="row mb-3">
											<label for="inputPassword" class="col-sm-2 col-form-label">공연시작일</label>
											<div class="col-sm-4">
												<input type="date" class="form-control"
													value="${pvo.productPeriodBegin}" name="productPeriodBegin">
											</div>

											<label for="inputNumber" class="col-sm-2 col-form-label">공연종료일</label>
											<div class="col-sm-4">
												<input type="date" class="form-control"
													name="productPeriodEnd" value="${pvo.productPeriodEnd}">
											</div>
										</div>




										<div class="row mb-3">
											<label for="inputDate" class="col-sm-2 col-form-label">관람(상영)시간</label>
											<div class="col-sm-10">
												<input type="text" class="form-control"
													value="${pvo.productRuntime}" name="productRuntime">
											</div>
										</div>
										<div class="row mb-3">
											<label for="inputTime" class="col-sm-2 col-form-label">관람등급</label>
											<div class="col-sm-10">
												<input type="text" class="form-control"
													value="${pvo.productRate}" name="productRate">
											</div>
										</div>


										<div class="col-sm-5">

											<button class="btn btn-primary w-100" type="submit">작품
												수정</button>
										</div>
									</form> <!-- End General Form Elements -->
							</div>
						</div>

					</div>
</section>


</section>









