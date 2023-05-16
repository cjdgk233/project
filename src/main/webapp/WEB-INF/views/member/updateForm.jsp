<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<script>
	let update = document.updateForm;

	function changePassword() {

		let option = "width=650px, height=550px, top=300px";

		let url = "${easyPath}/member/updatePasswordForm";

		window.open(url, "parent", option)
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
								<h5 class="card-title text-center pb-0 fs-4">회원정보 수정하기</h5>
							</div>
							<br>



							<div class="col-12">

								아이디 : <input type="text" value="${ mvo.memberId }"
									class="form-control" disabled>
							</div>
							<br>

							<div class="col-12">

								이름 : <input type="text" value="${ mvo.memberName }"
									class="form-control" disabled>
							</div>
							<br>

							<div class="col-12">
								비밀번호
								<button onclick="changePassword()">비밀번호 변경</button>
							</div>

							<br>

							<form action="${easyPath}/member/updateMember" name="updateForm"method="post">

								<div class="col-12">
									전화번호<input name="memberTel" type="text" value="${mvo.memberTel}"class="form-control">
								</div>

								<br> 주소<input name="memberAddress" type="text" value="${mvo.memberAddress}"
									class="form-control">
						</div>
						<br>

						<button class="btn btn-primary w-100" type="submit">회원 정보
							변경</button>

						</form>
					</div>

				</div>
			</div>
		</div>
</div>
</section>

</div>






