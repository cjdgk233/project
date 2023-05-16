<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.1.js"
	integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
	crossorigin="anonymous"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<script type="text/javascript">
	
	window.onload = function() {//날짜값을 보내는 메서드

		var roundSeq = ${roundSeq};

		var method = "POST";
		var param = "roundSeq=" + encodeURIComponent(roundSeq);

		var url = "${easyPath}/book/seat";

		sendRequest(url, param, resultSeat, method);

	}

	function resultSeat() { //changeDated의콜백 메서드

		if (xhr.readyState == 4 && xhr.status == 200) {

			var data = xhr.responseText;
			console.log("에이작스 도착");

			var l = $("input[name=seatSeq]");
			var arr = new Array(l.length);
			
			

			for (let i = 0; i < JSON.parse(data).length; i++) {

				let roundSeq = JSON.parse(data)[i]

				console.log(roundSeq);
				for (let j = 0; j < l.length; j++) {

					arr[j] = $("input[name=seatSeq]").eq(j).val();

					if (arr[j] == roundSeq) {

						$("input[name=seatSeq]").eq(j).attr('disabled', true);

					}//if end

				}//for2 end

			}//for1 end

		}

	}

	
	function book3() {

		alert('${productSeq}');

		var form = document.bookstep2form;

		form.action = "${easyPath}/book/bookstep3Form/${productSeq}";

		let option = "width=650px, height=550px, top=300px";

		form.target = book2

		form.submit();

		window.open("", book2, option);
		window.close();

	}

	function chkBox(bool) {
		var obj = document.getElementsByName("seatSeq");
		for (var i = 0; i < obj.length; i++) {
			obj[i].checked = bool;

			if (obj[i].checked) {
				obj[i].style.backgroundColor = '#ff0000'
			} else {
				obj[i].style.backgroundColor = "";
			}
		}
	}
</script>

<section class="section profile">
	<div class="row">

		<div class="col-lg-12">
			<div class="card">
				<div class="card-body wrap" align="center">



					<h5 class="card-title">STAGE</h5>
					<form name="bookstep2form"
						action="${easyPath}/book/bookstep3Form/${productSeq}"
						method="post">
						<table style="float: left; margin: 10px;">
							<tbody>
								<td>
									<p>A</p> <c:forEach var="j" begin="0" end="4" step="1">

										<tr>
											<td class="check"><c:forEach var="i" begin="1" end="5"
													step="1">
													<c:set var="name" value="${i+j*5}" />
													<input id="${i+j*5}" type="checkbox" name="seatSeq"
														class="btn btn-secondary" value="${name}">
													<label for="${i+j*5}"></label>
												</c:forEach></td>

										</tr>

									</c:forEach>
								</td>
							</tbody>
						</table>

						<table style="float: left; margin: 10px;">
							<tbody>
								<td>
									<p>B</p> <c:forEach var="j" begin="0" end="4" step="1">

										<tr>
											<td class="check"><c:forEach var="i" begin="26" end="30"
													step="1">
													<c:set var="name" value="${i+j*5}" />
													<input id="${i+j*5}" type="checkbox"
														class="btn btn-secondary" name="seatSeq" value="${name}">
													<label for="${i+j*5}"></label>
												</c:forEach></td>

										</tr>

									</c:forEach>
								</td>
							</tbody>
						</table>


						<table style="float: left; margin: 10px;">
							<tbody>
								<td>
									<p>C</p> <c:forEach var="j" begin="0" end="4" step="1">

										<tr>
											<td class="check"><c:forEach var="i" begin="51" end="55"
													step="1">
													<c:set var="name" value="${i+j*5}" />
													<input id="${i+j*5}" type="checkbox"
														class="btn btn-secondary" name="seatSeq" value="${name}">
													<label for="${i+j*5}"></label>
												</c:forEach></td>

										</tr>

									</c:forEach>
								</td>
							</tbody>
						</table>



						<table style="float: left; margin: 10px;">
							<tbody>
								<td>
									<p>E</p> <c:forEach var="j" begin="0" end="4" step="1">

										<tr>
											<td class="check"><c:forEach var="i" begin="76" end="80"
													step="1">
													<c:set var="name" value="${i+j*5}" />
													<input id="${i+j*5}" type="checkbox"
														class="btn btn-secondary" name="seatSeq" value="${name}">
													<label for="${i+j*5}"></label>
												</c:forEach></td>

										</tr>

									</c:forEach>
								</td>
							</tbody>
						</table>



						<table style="float: left; margin: 10px;">
							<tbody>
								<td>
									<p>E</p> <c:forEach var="j" begin="0" end="4" step="1">

										<tr>
											<td class="check"><c:forEach var="i" begin="101"
													end="105" step="1">
													<c:set var="name" value="${i+j*5}" />
													<input id="${i+j*5}" type="checkbox"
														class="btn btn-secondary" name="seatSeq" value="${name}">
													<label for="${i+j*5}"></label>
												</c:forEach></td>

										</tr>

									</c:forEach>
								</td>
							</tbody>
						</table>



						</tbody>

						</table>
				</div>
			</div>
		</div>


		<div class="row profile">
			<div class="col-sm-2">
				<button type="button"
					onclick="location.href='${easyPath}/book/bookstep1Form' "
					class="btn btn-primary">이전단계</button>
			</div>
			<div class="col-sm-2">
				<button type="submit" class="btn btn-primary">다음단계</button>

			</div>



		</div>
		</form>
</section>




