<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script>


function checkPw(){//컨트롤러로 비밀번호 보내는 메서드
	
	let patternPw = /^[A-Za-z0-9]{4,12}$/;

	
	let update = document.updatePasswordForm;
	

	if (update.memberPassword.value == "") {

		alert("비밀번호를 입력해 주세요.")
		update.memberPassword.focus();
		
	}else if(update.memberPassword.value.match(patternPw) == null){
		
		alert("비밀번호를 형식에 맞게 입력해주세요.")
		update.memberPassword.focus();
		
	}else if(update.newPassword.value == ""){
		
		alert("신규 비밀번호를 입력해 주세요.")
		update.newPassword.focus();
		
	}else if(update.newPassword.value.match(patternPw) == null){
		
		
		alert("신규 비밀번호를 형식에 맞게 입력해주세요.")
		update.newPassword.focus();
		
	}else if(update.memberPassword.value == update.checkNewPassword.value ){
		
		alert("기존 비밀번호와 다르게 입력해주세요")
		update.newPassword.focus();
		
	}else if(update.checkNewPassword.value == ""){
	
		alert("신규 비밀번호를 다시 한번 입력해 주세요.")
		update.checkNewPassword.focus();

		
	}else if(update.newPassword.value != update.checkNewPassword.value ){
		
		alert("신규 비밀번호가 일치하지 않습니다.")
		update.checkNewPassword.focus();
	}else{

	var memberPassword = document.getElementById("currentPassword").value;
	

	   	
 	var newPassword= document.getElementById("newPass").value;


	var method = "POST";
	var param = "memberPassword=" + encodeURIComponent(memberPassword)+"&"+"newPassword="+ encodeURIComponent(newPassword);
	var url = "${easyPath}/member/updatePassword";
	console.log(url);
	
	sendRequest(url, param, resultCheckPassword, method);
	

}
}

function resultCheckPassword(){

	if(xhr.readyState == 4 && xhr.status == 200){
		
		//var selectP = document.getElementById("textPw");

		//selectP.innerText = "44";
		var data = xhr.responseText;//결과 값으로 받은 데이터를 이쪽으로 받겠다는 것
		//@ResponseBody를 컨트롤러에서 사용하면 받을 수 있다. 
		
		//에이작스를 사용할때 @ResponseBody를 컨트롤러에서 사용하면 결과값을 받을수 있다

		//웹에서 화면전환(새로고침)없이 이루어지는 동작들은 대부부 비동기 통신으로 이루어진다.

		console.log(data);
		
		if(data == "true"){
		alert("비밀번호가 변경되엇습니다");
	
		window.close();
		
		}else if(data == "false"){
			
		alert("기존 비밀번호와 일치하지 않습니다");

		}

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
								<h5 class="card-title text-center pb-0 fs-4">비밀번호 수정하기</h5>
							</div>
							<br>

							<form  name="updatePasswordForm" method="post">

								<div class="col-12">

									<p>비밀번호는 8~15자리의</p> 
									<p>영문, 숫자, 특수문자 조합으로 만들어 주세요.</p>
									<br>

									<div class="col-12">
										<input name="memberPassword" type="text" class="form-control"
											id="currentPassword" placeholder="사용 중인 비밀번호">
											
									</div>
									
									<div class="col-12">
									<p id="textPw"></p>
									</div>

									<br>

									<div class="col-12">
										<input name="newPassword" type="text" class="form-control"
											id="newPass" placeholder="신규 비밀 번호">
									</div>

									<div class="col-12">

										<br> <input name="checkNewPassword" type="text"
											class="form-control" id="currentPassword" 
											placeholder="신규 비밀 번호 재입력">
									</div>
									<br>
									
							<button class="btn btn-primary w-100" onclick="checkPw()">비밀번호 변경</button>									
						
							</form>
							
							
							</div>
						</div>

					</div>
				</div>
			</div>

		</div>
	</section>

</div>






