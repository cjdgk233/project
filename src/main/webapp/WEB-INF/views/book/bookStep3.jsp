<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>


<script>



var seatCnt = '<c:out value="${seatCnt}"/>'

console.log(seatCnt);

function check(target,price,discntSeq){
	

	console.log(target.value);
	totalPrice =  price*(target.value);
	console.log(totalPrice);

	
	$('#total').attr('value', totalPrice);
	$('#total2').attr('value', totalPrice);
	
	let totalprice = $('#total2').val()
	
	var  roundDate = '<c:out value="${roundVo.roundDate}"/>';
	
	var roundDeadLine = '<c:out value="${roundVo.roundDeadLine}"/>';

	
	console.log(roundDate.split(' ')[0])
	
	console.log(roundDeadLine.split( )[0])
	
	$('#roundDate').attr('value', roundDate.split(' ')[0])
	
	$('#deadline').attr('value',roundDeadLine.split(' ')[0])
	
	
		
		
}






</script>

<script type="text/javascript">





function requestPay() {
	
	var total = $('#total2').val();
	
	console.log(total);
	
	
  IMP.init('imp50668218'); //iamport 대신 자신의 "가맹점 식별코드"를 사용
  IMP.request_pay({
    pg: "inicis",
    pay_method: "card",
    merchant_uid : 'INIBillTst'+new Date().getTime(),
    name : '결제테스트',
    amount : total,
    buyer_email : 'iamport@siot.do',
    buyer_name : '구매자',
    buyer_tel : '010-1234-5678',
    buyer_addr : '서울특별시 강남구 삼성동',
    buyer_postcode : '123-456'
  }, function (rsp) { // callback
	  
		    console.log(rsp);
		    if (rsp.success) {
		    	
		    	document.payMent.submit();
		    	
		    	   self.close();

		      var msg = '결제가 완료되었습니다.';
		      alert(msg);
		      location.href = "${easyPath}/common/result";
		    } else {
		      var msg = '결제에 실패하였습니다.';
		      msg += '에러내용 : ' + rsp.error_msg;
		      alert(msg);
		    }
		  
  });
}




function book(){
	
	document.payMent.submit();
	
}






</script>

<main id="main" class="main">


	<section class="section">
		<div class="row">
			<div class="col-lg-8">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">티켓종류, 할인, 매수 선택</h5>
						<!-- Bordered Table -->
						<table class="table table-bordered">


							<thead>
								<tr>
									<th scope="col" colspan="3">${mapSeat.seatRateName}석을1매
										선택하셨습니다.</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">정가</th>
									<td>일반</td>
									<td>${mapSeat.price}원</td>
									<td>
										<div class="row mb-3">
											<div class="col-sm-10">

												<select class="form-select"
													aria-label="Default select example">

													<option>0</option>
													<option value="1">1</option>



												</select>

											</div>
										</div>
									</td>
								</tr>
								<tr>
									<c:set var="mapSeat" value="${mapSeat}"></c:set>
									<th scope="row" rowspan="4">할인</th>
									<c:forEach var="vo" items="${discntList}" begin="1" end="4"
										step="1" varStatus="status">

										<td>${vo.discntName}</td>
										<fmt:parseNumber var="price1"
											value="${(mapSeat.price)-(mapSeat.price)*((vo.discntDetail)/100)}"
											integerOnly="true" />
										<c:set var="discntSeq" value="${vo.discntSeq}"></c:set>
										<td>${price1}원</td>
										<td><select class="form-select"
											onchange="check(this,${price1},${discntSeq})"
											name="selectBox${status.count}"
											aria-label="Default select example">
												<option selected>0</option>
												<option value="1">1</option>

										</select>
											</div>
											</div></td>
								</tr>
								</c:forEach>
							</tbody>

						</table>

						<div class="col-lg-4">



							<div class="card">
								<div class="card-body">



									<div class="col-lg-4">

										<div class="divStyle">
											<span class="goods_img"> <img
												src="${ easyPath }/resources/images/poster/${ productvo.productImage }"
												width="41" height="50">
											</span>
											<!-- [D] 상품명 두 줄 말줄임 처리 -->
											<strong class="goods_tit product_title">
												${productvo.productName} </strong>
											<div class="tit_tooltip" style="display: none;">
												<h4>${productvo.productName}</h4>
											</div>
										</div>

										<h5 class="card-title3">예매정보</h5>



										<div class="row">
											<div class="card">

												<table class="table table-borderless">
													<tbody>

														<tr>
															<c:set var="svo" value="${mapSeat.svo}" />
															<td>${mapSeat.seatRateName}석</td>
															<td class="seat_price">${svo.seatFloor}층${svo.seatZone}구역${svo.seatCol}열
																${svo.seatNum}번 1매</td>
														</tr>


													</tbody>
												</table>
											</div>
										</div>
										<br>




										<form
											action="${easyPath}/book/payMent/${roundVo.roundSeq}/${productSeq}/${mapSeat.seatRateSeq}/
											${productvo.productName}"
											method="post" name="payMent">

											<table>
												<c:forEach var="vo" items="${seatList}">
													<tr>
														<td>일시</td>
														<td><input type="date" name="bookProductDate"
															id="roundDate" style="border: none" readonly="readonly">
															
															<input type="hidden" name="bookSeat" value="${vo.seatSeq}"></td>
															
													</tr>
													<tr>
														<td>시간과 요일</td>
														<td><input type="text" value="${roundVo.roundTime}"
															style="border: none" readonly="readonly" class="col-sm-2">

															<input type="text" value="${todayLabel}"
															style="border: none" readonly="readonly"></td>
													</tr>
													<tr>
														<td>티켓금액</td>
														<td><input type="text" id="total"
															style="border: none" readonly="readonly"></td>
													</tr>
													<tr>
														<td>예매수수료</td>
														<td><input type="number" name="bookFee" value="1000"
															style="border: none" readonly="readonly"></td>
													</tr>
													<tr>
														<td>수령방법</td>
														<td><input type="text" name="bookReceive"
															value="현장수령" style="border: none" readonly="readonly"></td>
													</tr>


													<tr>
														<td>총결제금액</td>
														<td><input type="number" name="bookTotalPayment"
															id="total2" style="border: none" readonly="readonly"></td>
													</tr>

													<tr>
														<td>취소 가능 기한</td>
														<td><input type="text"
															value="${roundVo.roundDeadLine}" id="deadline"
															style="border: none" readonly="readonly"></td>
														<td><input type="hidden"
															value="${productvo.productName}" name="bookProductName"
															style="border: none" readonly="readonly"></td>
													</tr>
											</table>

											<div class="col-sm-3">

												<button type="button" onclick="requestPay()"
													class="btn btn-primary w-100">결제하기</button>
												<!-- 버튼에 타입 안적으면 submit으로 움직인다. -->
													<button type="button" onclick="book()"
													class="btn btn-primary w-100">디비 테스트용</button>
												
											</div>

											</c:forEach>
										</form>

									</div>
								</div>

							</div>
	</section>

</main>