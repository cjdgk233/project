<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<script>
	function checkLogin() {

		let loginForm = document.loginForm;

		if (loginForm.memberId.value == "") {

			alert("아이디를 입력해 주세요")

			loginForm.memberId.focus();

		} else if (loginForm.memberPassword.value == "") {

			alert("비밀번호를 입력해 주세요")

			loginForm.memberPassword.focus();
		} else {

			loginForm.action = "${easyPath}/member/login"

			loginForm.submit();

			
		}

	}
</script>


<script>

var naver_id_login = new naver_id_login(7OdRuNzN3ghf9HB_iZgw,"http://localhost:7434");
// 접근 토큰 값 출력
alert(naver_id_login.oauthParams.access_token);
// 네이버 사용자 프로필 조회
naver_id_login.get_naver_userprofile("naverSignInCallback()");
// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
function naverSignInCallback() {
  alert(naver_id_login.getProfileData('email'));
  alert(naver_id_login.getProfileData('nickname'));

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
								<h5 class="card-title text-center pb-0 fs-4">로그인</h5>
							</div>



							<form action="" method="get" name="loginForm">


								<div class="col-12">
									<input type="text" name="memberId" placeholder="아이디(이메일 주소)"
										class="form-control">
								</div>
								<br>

								<div class="col-12">
									<input type="password" name="memberPassword" placeholder="비밀번호"
										class="form-control">
								</div>

								<div class="col-12">
									<c:choose>
										<c:when test="${check}">
											<input type="checkbox" name="ckid" checked="checked"
												value="true">
										</c:when>

										<c:otherwise>
											<input type="checkbox" name="ckid" value="true">

										</c:otherwise>

									</c:choose>
									<label class="form-check-label">아이디 저장</label>



									<div class="col-12">
										<button class="btn btn-primary w-100" type="button"
											onclick="checkLogin()">로그인하기</button>
									</div>
							</form>



							<br>

							<div id="naver_id_login" class="col-12"></div>
							<br>
							<!-- //네이버 로그인 버튼 노출 영역 -->
							<script type="text/javascript">
								var naver_id_login = new naver_id_login(
										"7OdRuNzN3ghf9HB_iZgw", "http://localhost:7434/ex");
								
								//이부분에서 내 아이디와 주소를 안적어서 1시간을 헤맸다. api를 쓸 때는 잘 보자 
								var state = naver_id_login.getUniqState();
								naver_id_login.setButton("white", 12, 40);
								naver_id_login.setDomain("http://localhost:7434");
								naver_id_login.setState(state);
								naver_id_login.setPopup();
								naver_id_login.init_naver_id_login();
							</script>


							<div class="col-12">

								<p>
									아이디를 잊으셨다면? <a href="${easyPath}/member/findForm?mode=id">아이디
										찾기</a>
								</p>


								<p>
									비밀번호를 잊으셨다면? <a href="${easyPath}/member/findForm?mode=pw">비밀번호
										찾기</a>
								</p>
							</div>



						</div>

					</div>
				</div>
			</div>
		</div>
	</section>

</div>






