package com.ex.hall;

import java.util.HashMap;
import java.util.List;

public class HallService {

private HallDAO hallDao; //ProductDAO클래스 타입의 변수 productDao를 만든다.


	
	public HallService(HallDAO hallDao) {
		//MemberService객체 생성시 매개변수로 MemberDAO클래스 타입의 객체를 받아 변수 memberDao를 초기
		//설정하는 MemberService클래스의 생성성자를 만든다.

		//메서드에 인터페이스 타입의 매개변수를 받는다면 발 매개변수에 익명 구현 객체를 넣을 수도 잇고 익명 구현
		//객체의 내용대로 다형성 구현이 가능하다.
	
		
		this.hallDao =hallDao;
	}
	
	public List<HallVO> allHall() {
		return hallDao.allHall(); 
	}
	
	public int getHallSeq() {
		return hallDao.getHallSeq();
	}

	public int insertHall(HallVO vo) {
		return hallDao.insertHall(vo);
	}
	
	public List<HallVO> findHall(int theaterSeq) {
		return hallDao.findHall(theaterSeq);
	}
	
	public HallVO findHallWithHallSeq(int productHall) {
		
		return hallDao.findHallWithHallSeq(productHall);
	}
	
	public HallVO findOneHall(int hallTheater) {
		return hallDao.findOneHall(hallTheater);
	}


}