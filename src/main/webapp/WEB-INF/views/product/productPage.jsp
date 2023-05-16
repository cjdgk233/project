<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<script>
	function changeDate() {//날짜값을 보내는 메서드

		var productSeq = '<c:out value="${pvo.productSeq}"/>';

		console.log(productSeq);

		var roundDate = document.getElementById("roundDate");

		console.log(roundDate.value);

		var week = new Array('일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일');
		//배열을 만든다.

		var today = new Date(roundDate.value).getDay();

	
		var todayLabel = week[today];
		//숫자로 반환받은 getDay의 값을 배열에 넣어 문자로 반환받는다.

		console.log(todayLabel);

		var method = "POST";
		var param = "roundDate=" + encodeURIComponent(roundDate.value) + "&"
				+ "todayLabel=" + encodeURIComponent(todayLabel) + "&"
				+ "productSeq=" + encodeURIComponent(productSeq);

		var url = "${easyPath}/book/changedate";

		sendRequest(url, param, resultChangeDate, method);
	}

	function resultChangeDate() { //changeDated의콜백 메서드로 쓸 resultChangeDate를 만든다.

		if (xhr.readyState == 4 && xhr.status == 200) {

			var data = xhr.responseText;//결과 값으로 받은 데이터를 이쪽으로 받겠다는 것
		

			var selectRound = document.getElementById("selectRound");

			if (JSON.parse(data) == null) {
				selectRound.innerText = "해당 날짜에 회차가 없습니다."
			}
			for (let i = 0; i < JSON.parse(data).length; i++) {

				//div 추가 생성하기

				let roundSelect = "roundSelect" + i;

				let roundSeq = JSON.parse(data)[i].roundSeq

				console.log(roundSeq);

				let hElement = document.createElement("button"); 

				hElement.setAttribute("class", "product_time");
				hElement.setAttribute("id", roundSeq);
				
				hElement.setAttribute("name", "roundSeq")
				hElement.setAttribute("value", roundSeq)

				hElement.setAttribute("type", "button")

				hElement.setAttribute("onclick", "clickRound(this.id)")
			

				document.querySelector("#roundBox").append(hElement);

				hElement.innerText = JSON.parse(data)[i].roundTime;

			}

		}

	}

	function clickRound(clicked_id) {

		var productSeq = '<c:out value="${pvo.productSeq}"/>';

		console.log(productSeq);

		id = clicked_id;

		console.log("id : " + id)

		var roundSeq = id

		var roundDate = document.getElementById("roundDate");

		var selectRound = document.getElementById(id).innerText;

		var method = "POST";
		var param = "roundDate=" + encodeURIComponent(roundDate.value) + "&"
				+ "selectRound=" + encodeURIComponent(selectRound) + "&"
				+ "productSeq=" + encodeURIComponent(productSeq) + "&"
				+ "roundSeq=" + encodeURIComponent(roundSeq);
		var url = "${easyPath}/book/selectRound";

		console.log(url);

		sendRequest(url, param, resultSeat, method);

	}

	function resultSeat() {//clickRound의 콜백메서드 

		if (xhr.readyState == 4 && xhr.status == 200) {

			var lastCnt = '<c:out value="${lastCnt}"/>';

			console.log(lastCnt)

			var data2 = xhr.responseText;

			console.log(JSON.parse(data2));
			var map = JSON.parse(data2);
			
			var table = document.getElementById('table1');

	
			var row = "";
			for (var i = 0; i < 3; i++) {
				row += "<tr>";
				row += "<td>" + map.name[i] + "</td>";
				row += "<td>" + map.cnt[i] + "</td>";
				row += "</tr>";

			}
			table.innerHTML += row
		}

	}

	function book2() {

		var login = '<c:out value="${login}"/>'; 

		console.log("login : " + login);

		if (login == '') {
			alert("로그인이 필요합니다.")

		}

		if (login != '') {

			var productSeq = '<c:out value="${pvo.productSeq}"/>';

			let option = "width=650px, height=450px, top=300px";

			let url = "${easyPath}/book/bookstep2Form/${pvo.productSeq}";

			window.open(url, 'book2', option);
		}

	}
</script>

<section class="section profile">
	<div class="container-md">
		<div class="row">


			<div class="col-xl-6-2">

				<div>
					<div class="d-flex flex-column">
						<!-- 포스터 -->
						<img
							src="${ easyPath }/resources/images/poster/${ pvo.productImage }"
							alt="Profile">
					</div>
				</div>

			</div>

			<div class="col-xl-6">

				<div>
					<div class="card-body pt-3">
						<!-- Bordered Tabs -->
						<ul class="nav nav-tabs nav-tabs-bordered">

							<li class="nav-item ">
								<h3 class="product_sub_title">${ pvo.productName }</h3>
							</li>



						</ul>
						<div class="tab-content pt-2">


							<div class="tab-pane fade show active profile-overview"
								id="profile-overview">
								<div class="row">


									<span class="col-lg-3 col-md-4 label ">장소</span>
									<div class="col-lg-9 col-md-8">${ pvo.hallName }</div>
								</div>

								<div class="row">
									<span class="col-lg-3 col-md-4 label">기간</span>
									<div class="col-lg-9 col-md-8">${ pvo.productPeriodBegin }
										~ ${ pvo.productPeriodEnd }</div>
								</div>

								<div class="row">
									<span class="col-lg-3 col-md-4 label">관람시간</span>
									<div class="col-lg-9 col-md-8">${ pvo.productRuntime }</div>
								</div>

								<div class="row">
									<span class="col-lg-3 col-md-4 label">관람등급</span>
									<div class="col-lg-9 col-md-8">${ pvo.productRate }</div>
								</div>

								<!-- 가격 forEach문 -->
								<div class="row">
									<div class="col-lg-3 col-md-4 label">가격</div>
									<div class="col-lg-9 col-md-8">

										<tr>
											<td>${ map.name1}석${ map.price1 }원</td>
											<br>
										</tr>
										<tr>
											<td>${  map.name2}석${map.price2 }원</td>
											<br>
										</tr>
										<tr>
											<td>${  map.name3 }석${ map.price3 }원</td>
											<br>
										</tr>

									</div>
								</div>



								<!-- 할인 forEach문 -->
								<div class="row">
									<div class="col-lg-3 col-md-4 label">할인</div>
									<div class="col-lg-9 col-md-8">

										<c:forEach var="discnt" items="${ discntList }">
											<c:choose>
												<c:when test="${discnt.discntName == '없음' }">
													<tr>
														<td></td>

													</tr>
												</c:when>
												<c:otherwise>
													<tr>
														<td>${ discnt.discntName }</td>
														<br>
													</tr>

												</c:otherwise>
											</c:choose>
										</c:forEach>
									</div>
								</div>

							</div>
						</div>
						<!-- End Bordered Tabs -->

					</div>
				</div>
			</div>
		</div>
	</div>
</section>


<%--예매 부분 --%>
<section class="section profile">
	<form method="post"
		action="${easyPath}/book/bookstep2Form/{productSeq}" name="bookStep1">
		<div class="row">
			<div class="col-lg-3">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">STEP1. 날짜선택</h5>

						<input type="date" id="roundDate" value="${resultDate}"
							class="form-control" name="roundDate"
							min="${pvo.productPeriodBegin}" max="${pvo.productPeriodEnd}"
							onchange="changeDate()">
					</div>
				</div>
			</div>

			<div class="col-lg-5">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">STEP2. 회차선택</h5>


						<div class="col-lg-10">
							<div class="card">
								<div class="card-body2" id="roundBox"></div>

							</div>
						</div>
						<br>


					</div>
				</div>
			</div>

			<div class="col-lg-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">예매가능좌석</h5>
						<table class="table table-borderless" id="table1">

						</table>
					</div>
				</div>
			</div>
		</div>


		<div class="row profile">
			<div class="col-lg-12" align="center">
				<button type="button" onclick="book2()" class="btn btn-primary">예매하기</button>

			</div>
		</div>
		</div>



	</form>

</section>



<%-- --%>
<section class="section">
	<div class="container-md">
		<div class="row">
			<div class="col-lg-12">

				<div class="card">
					<div class="card-body">

						<!-- 타이틀 시작 -->
						<ul class="nav nav-tabs d-flex" id="myTabjustified" role="tablist">
						
							
							<li class="nav-item flex-fill" role="presentation">
								<button class="nav-link w-100" id="placeinfo-tab" data-bs-toggle="tab" data-bs-target="#placeinfo-justified"
									type="button" role="tab" aria-controls="placeinfo" aria-selected="false">장소정보</button>
							</li>
							
						</ul>
						<!-- 타이틀 끝 -->

						<div class="tab-content pt-2" id="myTabjustifiedContent">

							<!-- 상세정보 -->
							

							<!-- 관람후기 -->
							

							<!-- 기대평 -->
							

							<!-- 장소정보 -->
							<div class="active fade show tab-pane" id="placeinfo-justified" role="tabpanel" aria-labelledby="placeinfo-tab">
								
								<!-- 타이틀 -->
								<h5 class="card-title">공연장 정보</h5>
								
								<!-- 텍스트 -->
								<div class="row">
									<pre>장소 : ${ pvo.hallName }</pre>
									<pre>주소 : ${ tvo.theaterAddress }</pre>
									<pre>대표번호 : ${ hvo.hallTel }</pre>
									<br>
								</div>
								
								<!-- 네이버 지도 -->
								<div class="col-sm-12">
									<div id="map" style="width:100%; height:50vh; margin: 0 auto;"></div>
								</div>
							</div>
							
							<!-- 예매/취소안내 -->
						
						
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<script type="text/javascript">
	$(function(){
		initMap();
	});
	
	function initMap() {
		
		var map = new naver.maps.Map('map', {
			
	
			center: new naver.maps.LatLng(	${tvo.theaterLatitude}, ${tvo.theaterLongitude}),
			zoom: 15
		});
		
		var marker = new naver.maps.Marker({
	        map: map,
	        title: "",
	        position: new naver.maps.LatLng(${tvo.theaterLatitude}, ${tvo.theaterLongitude}),
	        icon: {
	            content: '<img src="${ easyPath }/resources/images/marker.png" alt="" style="margin: 0px; padding: 0px; border: 0px solid transparent; display: block; max-width: none; max-height: none; -webkit-user-select: none; position: absolute; width: 32px; height: 32px; left: 0px; top: 0px;">',
	            size: new naver.maps.Size(32, 32),
	            anchor: new naver.maps.Point(16, 32)
	        }
	    });
		
		
	}
</script>
		
	


