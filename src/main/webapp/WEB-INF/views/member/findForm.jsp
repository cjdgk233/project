<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<script>
	
	function findIdPw(){
		
		let find = document.find;
		
		if(find.memberName.value == ""){
			
			alert("이름을 입력해 주세요")
			find.memberName.focus();
		}else if(find.memberTel.value == ""){
			
			alert("전화번호를 입력해 주세요")
			find.memberTel.focus();
		}else{
			
			document.find.submit();
		}
		
		
	}
	
	
	
</script>

<div class="container">

	<section
		class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
		<div class="container">

			<div class="row justify-content-center">
				<div
					class="col-lg-5 col-md-6 d-flex flex-column align-items-center justify-content-center">
					<div class="card mb-3">
						<div class="card-body">

							<div class="pt-4 pb-2">
								<h5 class="card-title text-center pb-0 fs-4">아이디/비밀번호 찾기</h5>
							</div>
							<br>
							
							<form action="${easyPath}/member/find" method="post" name=find>
								<c:choose>
								<c:when test="${param.mode == 'pw'}">

									<div class="col-12">
											<input type="text" name="memberId" placeholder="아이디(이메일 주소)" class="form-control">
										</div>
									</c:when>
									</c:choose>
									
									<br>
			


								<div class="col-12">
									<input type="text" name="memberName" placeholder="이름"
										class="form-control">
								</div>
								<br>

								<div class="col-12">
									<input type="text" name="memberTel" placeholder="전화번호"
										class="form-control">
								</div>
								<br>
								
							
								<c:choose>
								
								<c:when test="${param.mode == 'id'}">
								<input type="hidden" name="mode" value="id">
								
								
								<div class="col-12">
											<button class="btn btn-primary w-100" type="button" onclick="findIdPw()" >아이디 찾기</button>
										</div>
										</c:when>
										<c:otherwise>
										<input type ="hidden" name="mode" value="pw">
										<div class="col-12">
										<button class="btn btn-primary w-100" type="button" onclick="findIdPw()">비밀번호 찾기</button>
								</div>
								</c:otherwise>
								</c:choose>
	
							</form>

						</div>

					</div>
				</div>
			</div>

		</div>
	</section>

</div>






