package com.ex.common;

public interface ViewPath { // 경로를 좀 더 간편하게 만들어주는 인터페이스 ViewPath를 만든다.

	public static final String MAIN = "WEB-INF/views/";
	// public static final은 어차피 인터페이스에서 선언하는 변수는 다 public static final이니까 생략
	// 이거를 적어주는게 나을까?

	// "WEB-INF/views/" 경로 설정이기 때문에 끝에 /까지 끝까지 적어준다.

	public static final String MEMBER = "/WEB-INF/views/member/";

	String PRODUCT = "/WEB-INF/views/product/";

	String BOOK = "/WEB-INF/views/book/";

	String ADMIN = "/WEB-INF/views/admin/";
	
	String ADMINMEMBER = "/WEB-INF/views/admin/member/";
	
	String ADMINBOOK = "/WEB-INF/views/admin/book/";

	String COMMON = "/WEB-INF/views/common/";
	
	String CENTER = "/WEB-INF/views/center/";

	String FILEROOT = "C:\\Users\\cheongha\\Dropbox\\TIKatLINK 이청하\\WS\\ex\\src\\main\\webapp\\resources\\images\\poster";

}
