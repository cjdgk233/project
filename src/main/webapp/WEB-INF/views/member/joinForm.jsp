<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<script>

function checkJoin(){
	
	let patternId = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	let patternPw = /^[A-Za-z0-9]{4,12}$/;
	let patternTel = /^\d{3}-\d{3,4}-\d{4}$/;
	
	let joinForm = document.join;
	
	let repw = document.getElementById("repw").value;
	
	alert(repw);
	
		if(joinForm.memberId.value == ""){
			
		alert("아이디를 입력해 주세요");  
		document.join.memberId.focus();
		
		}else if(joinForm.memberId.value.match(patternId) == null){
			
			alert("아이디를 이메일 형식에 맞게 입력해주세요.")
			
			joinForm.memberId.focus();
			
		}else if(joinForm.memberPassword.value ==""){
			
			alert("비밀번호를 입력해 주세요")
			joinForm.memberPassword.focus();
		}else if(joinForm.memberPassword.value.match(patternPw) == null){
			alert("비밀번호를 형식에 맞게 입력해주세요.")
			joinForm.memberPassword.focus();
			
		}else if(joinForm.repw.vlaue == "" ){
			
			alert("비밀번호를 확인해 주세요")
			joinForm.repw.focus();
		} else if( joinForm.repw.value != joinForm.memberPassword.value ){
		
			
			alert("비밀번호가 일치하지 않습니다.")
			joinForm.repw.focus();
		} else if( joinForm.memberTel.value == ""){
			
			alert("전화번호를 입력해 주세요.")
			
			joinForm.memberTel.focus();
		} else if( joinForm.memberTel.value.match(patternTel) == null){
			
			alert("전화번호를 형식에 맞게 입력해주세요.")
			joinForm.memberTel.focus();
			
		} else if(joinForm.memberAddress.value == ""){
			
			alert("주소를 입력해 주세요")
			joinForm.memberAddress.focus();
		}else {
			
			document.join.submit();
		}

}
	
</script>

<div class="container">

	<section class="section">
		<div class="row">
			<div class="col-lg-6">

				<div class="card">
					<div class="card-body">
						<h5 class="card-title">EasyTicket 가입을 환영합니다.</h5>

						<br>



						<!-- General Form Elements -->
						<form action="${easyPath}/member/join" method="post" name="join">
							<div class="row mb-3">
								<label for="inputText" class="col-sm-2 col-form-label">아이디</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="memberId">
								</div>
							</div>
							
							<div class="row mb-3">
								<label for="inputText" class="col-sm-2 col-form-label">이름</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="memberName">
								</div>
							</div>
					
							<div class="row mb-3">
								<label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
								<div class="col-sm-10">
									<input type="password" class="form-control"name="memberPassword">
								</div>
							</div>


							<div class="row mb-3">
								<label for="inputPassword" class="col-sm-2 col-form-label">비밀번호 재입력</label>
								<div class="col-sm-10">
									<input type="password" id="repw" class="form-control">
								</div>
							</div>


							<div class="row mb-3">
								<label for="inputNumber" class="col-sm-2 col-form-label">전화번호</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="memberTel">
								</div>
							</div>


							<div class="row mb-3">
								<label for="inputNumber" class="col-sm-2 col-form-label">주소</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="memberAddress" >
								</div>
							</div>

							<div class="col-12">
								<button class="btn btn-primary w-100" type="button" onclick="checkJoin()">회원가입하기</button>
							</div>

							<br>

							<div class="col-12">
								<p>
									이미 가입하셨나요? <a href="${easyPath}/member/loginForm">로그인</a>

								</p>
							</div>


						</form>

					</div>

				</div>
			</div>
		</div>
</div>
</section>

</div>






