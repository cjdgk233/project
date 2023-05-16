package com.ex.pdType;

import java.util.HashMap;
import java.util.List;

public class PdTypeService {

private PdTypeDAO pdTypeDao; //ProductDAO클래스 타입의 변수 productDao를 만든다.


	
	public PdTypeService(PdTypeDAO pdTypeDao) {
		//MemberService객체 생성시 매개변수로 MemberDAO클래스 타입의 객체를 받아 변수 memberDao를 초기
		//설정하는 MemberService클래스의 생성성자를 만든다.

		//메서드에 인터페이스 타입의 매개변수를 받는다면 발 매개변수에 익명 구현 객체를 넣을 수도 잇고 익명 구현
		//객체의 내용대로 다형성 구현이 가능하다.
	
		
		this.pdTypeDao =pdTypeDao;
	}
	
	public List<PdTypeVO> allPdtype() {
		return pdTypeDao.allPdtype(); 
	}
	


}