<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script>

//선택한 공연홀에 따라 작품을 불러오는 메서드
function changeHall(){
	
	
	var hallSeq= document.getElementById("roundHall");
	
	console.log(hallSeq.value);
	
	var method = "POST";
	var param="hallSeq=" +encodeURIComponent(hallSeq.value);
	var url= "${easyPath}/admin/changeHall";
	
	console.log(url);
	
	sendRequest(url,param,resultChangeHall,method);
	
}

function resultChangeHall(){
	
	if(xhr.readyState == 4 && xhr.status == 200){
		
		var ajaxData = xhr.responseText;
		

		var artList = JSON.parse(ajaxData);
		
		var selectOption=document.getElementById("selectOption");
		
		document.getElementById("art_selector").innerHTML = "";
		
		var bannerStr = '<option value="">작품을 선택하세요</option>';
		
		$(artList).each(function(index,dom){
			bannerStr += '<option id="selectOption" value="'+dom.productSeq+'">'+dom.productName+'</option>'
		});
		
		document.getElementById("art_selector").innerHTML = bannerStr;

	}
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
								<h5 class="card-title">작품회차 등록</h5>

								<!-- General Form Elements -->
								<form action="${easyPath}/admin/registRound" method="get"
									name="registHall">


									<div class="row mb-3">
										<label for="inputNumber" class="col-sm-2 col-form-label">공연홀</label>
										<div class="col-sm-10">
											<select name="roundHall" class="form-select" id="roundHall"
												aria-label="Default select example" onchange="changeHall()">
												<option >공연홀을 선택하세요</option>
												<c:forEach var="hallList" items="${hallList}">
													<option value="${hallList.hallSeq}">${hallList.hallName}</option>

												</c:forEach>
											</select>
										</div>
									</div>

									<div class="row mb-3">
										<label for="inputPassword" class="col-sm-2 col-form-label">공연일자</label>
										<div class="col-sm-4">
											<input type="date" class="form-control" name="roundDate">
										</div>

										<label for="inputPassword" class="col-sm-2 col-form-label">공연시간</label>
										<div class="col-sm-4">
											<input type="time" class="form-control" name="roundTime">
										</div>


									</div>

									<div class="row mb-3">
										<label for="inputNumber" class="col-sm-2 col-form-label">작품
											선택</label>
										<div class="col-sm-10">

											<select name="roundProduct" class="form-select"
												aria-label="Default select example" id="art_selector">
												<option value="">작품을 선택하세요</option>
												<c:forEach var="productList" items="${productList}">
													<option id="selectOption" value="${productList.productSeq}">${productList.productName}</option>

												</c:forEach>
											</select>
										</div>
									</div>


									<div class="row mb-3">
										<label class="col-sm-2 col-form-label"></label>

										<div class="col-sm-3">

											<button
												onclick="location.href = '/ex/admin/registProductForm';"
												class="btn btn-primary w-100" type="button">뒤로 가기</button>
										</div>



										<div class="col-sm-3">
											<button class="btn btn-primary w-100" type="reset">초기화</button>
										</div>


										<div class="col-sm-3">
											<button class="btn btn-primary w-100" type="submit">작품회차
												등록</button>
										</div>
								</form>



								<!-- End General Form Elements -->

							</div>
						</div>

					</div>
</section>












