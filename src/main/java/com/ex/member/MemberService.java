package com.ex.member;

import java.util.HashMap;
import java.util.List;

public class MemberService {

private MemberDAO memberDao; //MemberDAO클래스 타입의 변수 memberDao를 만든다.


	
	public MemberService(MemberDAO memberDao) {
		//MemberService객체 생성시 매개변수로 MemberDAO클래스 타입의 객체를 받아 변수 memberDao를 초기
		//설정하는 MemberService클래스의 생성성자를 만든다.

		//메서드에 인터페이스 타입의 매개변수를 받는다면 발 매개변수에 익명 구현 객체를 넣을 수도 잇고 익명 구현
		//객체의 내용대로 다형성 구현이 가능하다.
	
		
		this.memberDao =memberDao;
	}
	
	public int checkLogin(MemberVO vo) {
		
	System.out.println("확인용");
		
		return memberDao.checkLogin(vo);
	}
	
	
	
	public String findId(MemberVO vo) {
		
		return memberDao.findId(vo);
		
	}
	
	public String findPw(MemberVO vo) {
		
		return memberDao.findPw(vo);
	}
	
	public MemberVO findMember(int memberSeq) {
		
		return memberDao.findMember(memberSeq);
	}
	
	public int updatePw(HashMap<String, Object> map) {
		

		
		return memberDao.updatePw(map);
	}
	
	public int deleteMember(int memberSeq) {
	
		return memberDao.deleteMember(memberSeq);
	}
	
	public int updateMember(MemberVO mvo) {
		
		
		return memberDao.updateMember(mvo);
	}
	
	public int joinMember(MemberVO mvo) {
		return memberDao.joinMember(mvo);
	}
	
	public int getNextMemberSeq() {
		return memberDao.getNextMemberSeq();
	}
	
	public int checkAdmin(int memberSeq) {
		return memberDao.checkAdmin(memberSeq);
	}
	
	public List<MemberVO> allMember() {
	return memberDao.allMember();
	}
	
	
}
