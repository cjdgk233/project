<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<script type="text/javascript">


function requestPay() {
  IMP.init('imp50668218'); //iamport 대신 자신의 "가맹점 식별코드"를 사용
  IMP.request_pay({
    pg: "inicis",
    pay_method: "card",
    merchant_uid : 'INIBillTst'+new Date().getTime(),
    name : '결제테스트',
    amount : 14000,
    buyer_email : 'iamport@siot.do',
    buyer_name : '구매자',
    buyer_tel : '010-1234-5678',
    buyer_addr : '서울특별시 강남구 삼성동',
    buyer_postcode : '123-456'
  }, function (rsp) { // callback
	  
		    console.log(rsp);
		    if (rsp.success) {
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



</script>

<body>

	<div class="row">
		<div class="col-lg-3 col-md-4 label">가격</div>
	</div>
	<div class="row">
		<div class="col-lg-3 col-md-4 label">가격</div>
	</div>
		<div class="row">
		<div class="col-lg-3 col-md-4 label">가격</div>
	</div>
	
		<div class="row">
		<div class="col-lg-3 col-md-4 label">가격</div>
	</div>
	

	<button onclick="requestPay()" class="btn btn-primary">결제하기</button>


</body>

