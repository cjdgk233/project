package com.ex.member;

import java.sql.Date;

public class MemberVO {
	
	private int memberSeq;  //회원 정보 SEQ
	
	private String memberId; //이메일ID
	
	private String memberTel;//휴대폰 번호
	
	private String memberName; //이름
	
	private String memberPassword; //비밀번호
	
	private String memberAddress;//주소
	
	private String memberProfileImage;//프로필 이미지
	
	private String memberWithdrawal; //회원탈퇴여부
	
	private int memberMembership;//회원 등급
	
	
	//생성자
	
	public MemberVO(){}
	
	
	
	

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberProfileImage() {
		return memberProfileImage;
	}

	public void setMemberProfileImage(String memberProfileImage) {
		this.memberProfileImage = memberProfileImage;
	}

	public String getMemberWithdrawal() {
		return memberWithdrawal;
	}

	public void setMemberWithdrawal(String memberWithdrawal) {
		this.memberWithdrawal = memberWithdrawal;
	}

	public int getMemberMembership() {
		return memberMembership;
	}

	public void setMemberMembership(int memberMembership) {
		this.memberMembership = memberMembership;
	}
	
	
	
	
	
}