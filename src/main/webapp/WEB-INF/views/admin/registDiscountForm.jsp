<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script>
	function changeTheater() {

		var theaterSeq = document.getElementById("theaterSeq");

		console.log(theaterSeq.value);

		var method = "POST";
		var param = "theaterSeq=" + encodeURIComponent(theaterSeq.value);
		var url = "${easyPath}/admin/changeTheater";

		console.log(url);

		sendRequest(url, param, resultChangeTheater, method);

	}

	function resultChangeTheater() {

		if (xhr.readyState == 4 && xhr.status == 200) {

			var ajaxData = xhr.responseText;

			var hallList = JSON.parse(ajaxData);

			document.getElementById("hall_selector").innerHTML = "";

			var bannerStr = '<option value="">공연홀을 선택하세요</option>';

			$(hallList)
					.each(
							function(index, dom) {

								bannerStr += '<option id="selectOption'+index+'" value="'+dom.hallSeq+'">'
										+ dom.hallName + '</option>'
							})

			document.getElementById("hall_selector").innerHTML = bannerStr;

		}

	}

	function changeHall2() {

		hallSeq = document.getElementById("hall_selector");

		console.log("홀 seq :" + hallSeq.value);

		var method = "POST";

		var param = "hallSeq=" + encodeURIComponent(hallSeq.value);
		var url = "${easyPath}/admin/changeHall2";

		console.log(url);

		sendRequest(url, param, resultChangeHall2, method);

	}
	//콜백 메서드
	function resultChangeHall2() {

		if (xhr.readyState == 4 && xhr.status == 200) {

			var ajaxData2 = xhr.responseText;

			var productList = JSON.parse(ajaxData2);

			console.log("확인 :" + productList[0].productName);

			document.getElementById("product_selector").innerHTML = "";

			var bannerStr = '<opton value="">작품을 선택하세요</option>';

			$(productList)
					.each(
							function(index, dom) {

								bannerStr += '<option id="productOption'+index+'" value="'+dom.productSeq+'">'
										+ dom.productName + '</option>'

							})

			document.getElementById("product_selector").innerHTML = bannerStr;

		}
	}

	function registDiscnt() {
		discntName = document.getElementById("discntName");
		discntDetail = document.getElementById("discntDetail");

		console.log(discntName.value);
		console.log(discntDetail.value);

		var method = "POST";
		var param = "discntName=" + encodeURIComponent(discntName.value) + "&"
				+ "discntDetail=" + encodeURIComponent(discntDetail.value);
		var url = "${easyPath}/admin/registDiscnt2";
		console.log(url);

		sendRequest(url, param, resultRegistDiscnt, method);
	}

	function resultRegistDiscnt() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			var ajaxData3 = xhr.responseText;

			console.log(도착);

		}
	}
</script>

<section class="section profile">
	<div class="row">
		<div align="center">
			<div class="col-lg-8">

				<div class="card">
					<div class="card-body">
						<h5 class="card-title">할인 설정</h5>


						<form action="${easyPath}/admin/registDiscount" method="post"
							name="registHall">

							<div class="row mb-3">
								<label for="inputNumber" class="col-sm-2 col-form-label">극장
									선택</label>
								<div class="col-sm-10">
									<select name="" class="form-select" id="theaterSeq"
										aria-label="Default select example" onchange="changeTheater()">
										<option value="">극장을 선택하세요</option>
										<c:forEach var="theaterlist" items="${theaterlist}">
											<option value="${theaterlist.theaterSeq}">${theaterlist.theaterName}</option>



										</c:forEach>
									</select>
								</div>
							</div>

							<div class="row mb-3">
								<label for="inputNumber" class="col-sm-2 col-form-label">공연홀
									선택</label>
								<div class="col-sm-10">
									<select name="" class="form-select"
										aria-label="Default select example" id="hall_selector"
										onchange="changeHall2()">
										<option value="">공연홀을 선택하세요</option>

										<option id="selectOption" value=""></option>

									</select>
								</div>
							</div>



							<div class="row mb-3">
								<label for="inputNumber" class="col-sm-2 col-form-label">작품
									선택</label>
								<div class="col-sm-10">
									<select name="discntBoxProduct" class="form-select"
										aria-label="Default select example" id="product_selector">
										<option value="">작품을 선택하세요</option>

										<option id="selectOption2" value=""></option>

									</select>
								</div>
							</div>


							<!-- 할인 선택 -->
							<div class="col-mb-8">
								<div class="row mb-3">
									<label for="inputText" class="col-sm-2 col-form-label">할인명</label>
									<div class="col-sm-7">
										<input type="text" class="form-control" id="discntName">
									</div>
								</div>

								<div class="row mb-3">
									<label for="inputText" class="col-sm-2 col-form-label">할인율</label>
									<div class="col-sm-7">
										<input type="number" class="form-control" id="discntDetail">
									</div>
								</div>


								<div class="col-sm-3">
									<button class="btn btn-primary w-100" type="button"
										onclick="registDiscnt()">할인 등록</button>



								</div>

								<br>
								<div class="col-mb-8">
									<label for="inputText" class="col-mb-8 col-form-label">작품에
										할인 적용</label>
								</div>
								<c:forEach var="i" begin="1" end="5" step="1">
									<c:set var="name" value="discnt${i}" />
									<!-- 이름을 name으로 하고 값을 value로 
								정한다. -->

									<div class="row mb-3">
										<label for="inputNumber" class="col-sm-2 col-form-label">작품에
											할인 적용${i}</label>
										<div class="col-sm-10">
											<select name="${name}" class="form-select"
												aria-label="Default select example">
												<option value="">작품에 적용할 할인을 선택하세요</option>
												<c:forEach var="discntList" items="${discntList}">
													<option value="${discntList.discntSeq}">${discntList.discntName}</option>

												</c:forEach>
											</select>
										</div>
									</div>
								</c:forEach>




								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"></label>

									<div class="col-sm-3">
										<button class="btn btn-primary w-100" type="reset">초기화</button>
									</div>


									<div class="col-sm-3">
										<button class="btn btn-primary w-100" type="submit">작품별
											할인 등록 등록</button>
									</div>
						</form>

					</div>
				</div>

			</div>
</section>












