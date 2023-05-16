<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	alert('${msg}');
	location.href = "${url}";

	
	//location.href= "${url}" 

	//자바스크립트 부분에 location.href="이동할 페이지 주소"방식으로 작성하면 페이지를 이동시킬 수 있다.
	
	//RequestMapping어노테이션에 의해 보내진 Model객체또는 Request객체를 받아서 jsp파일에서 사용한다.

	
</script>