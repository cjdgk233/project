package com.ex.member;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.book.BookService;
import com.ex.book.BookVO;
import com.ex.common.ViewPath;
import com.ex.common.ViewResult;
import com.ex.product.ProductService;
import com.ex.product.ProductVO;



@Controller
public class MemberController {

	private MemberService memberservice;
	private BookService bookService;
	private ProductService productService;

	public MemberController(MemberService memberservice, BookService bookService, ProductService productService) {

		this.memberservice = memberservice;
		this.bookService = bookService;
		this.productService = productService;

	}
	

	@RequestMapping("/member/joinForm")
	public String joinForm() {

		return ViewPath.MEMBER + "joinForm.jsp";
	}

	// 회원 가입
	@RequestMapping("/member/join")
	public String joinMember(MemberVO mvo, HttpServletRequest request) {

		int nextMemberSeq = memberservice.getNextMemberSeq();// 회원 SEQ생성

		System.out.println("seq확인용 : " + nextMemberSeq);

		mvo.setMemberSeq(nextMemberSeq);// 새로 생성한 seq를 매개변수로 seqsetter메서드의 매개변수로 설정한다.

		int num = memberservice.joinMember(mvo);

		System.out.println(num);

		
		
		if (num != 0) {

			ViewResult.setData(request, "/ex/member/loginForm",
					"안녕하세요 " + mvo.getMemberName() + "님" + " EasyTicket회원이 되신 것을 축하드립니다");
		} else {

			ViewResult.setData(request, "/ex/member/loginForm", "회원 가입에 실패하였습니다.");
		}

		return ViewPath.COMMON + "result.jsp";
	}

	// 로그인폼으로 이동
	@RequestMapping("/member/loginForm")
	public String loginForm(HttpServletRequest request) {

		String memberId = request.getParameter("memberId");


		boolean check = false;
		
		if (memberId == null) {

			Cookie[] cks = request.getCookies();
		

			if (cks != null) {

				for (Cookie ck : cks) {
					if (ck.getName().equals("ckid")) {

						memberId = ck.getValue();
						
						check = true;
						break;
					}
				}
			}

			if (memberId == null) {
				memberId = "";
			}
		}

		request.setAttribute("memberId", memberId);

		request.setAttribute("check", check);

		return ViewPath.MEMBER + "loginForm.jsp";
	}

	// 로그인
	@RequestMapping("/member/login")
	public String login(MemberVO mvo, HttpServletRequest request, HttpServletResponse response) {

		boolean check = false; // 아이디 저장을 체크했는지 확인하기 위한 플래그

		
		System.out.println("id : " + mvo.getMemberId());
		System.out.println(" pw : " + mvo.getMemberPassword());
		
		int memberSeq = memberservice.checkLogin(mvo);
		

		System.out.println("memberSeq : " + memberSeq);

		mvo = memberservice.findMember(memberSeq);
	
		if (memberSeq == 0) {
			ViewResult.setData(request, "/ex/member/loginForm", "아이디 혹은 비밀번호가 잘못되었습니다.");

		} else if ((mvo.getMemberWithdrawal()).equals("y")) {
			
			ViewResult.setData(request, "/ex/", "탈퇴한 회원입니다.");

		} else if (memberSeq != 0) {

			request.getSession().setAttribute("login", memberSeq);
			

			int admin = memberservice.checkAdmin(memberSeq);

			if (admin == 4) {

				request.getSession().setAttribute("admin", admin);

				ViewResult.setData(request, "/ex/", "오늘도 EasyTicket을 찾아주셔서 감사합니다.");

			}

			System.out.println("로긴 : " + request.getSession().getAttribute("login"));
			

			boolean ckid = Boolean.parseBoolean(request.getParameter("ckid"));
			
			System.out.println("ckid " + ckid);

			Cookie[] cks = request.getCookies();
		

			Cookie c = null;

			if (cks != null) {// 쿠키타입의 배열에 값이 있다면

				for (Cookie ck : cks) {

					if (ck.getName().equals("ckid")) { // 이름이 ckid라고 저장된 쿠키가 있다면

						c = ck;// 해당 쿠키만 따로 Cookic타입의 변수 c에 저장한다.

						System.out.println("c 확인 : " + c);
						break;
					}
				}

			} // if end
			if (ckid != false) { // ckid가 체크되어 있다면

				check = true; // 아이디저장 flag를 다시 켠다.

				if (c == null) { // ckid라고 저장된 쿠키가 없다면

					c = new Cookie("ckid", mvo.getMemberId()); // 쿠키 객체를 새로 생성해 아이디값을 저장한다.

					c.setPath("/"); 

					c.setMaxAge(60 * 60 * 24);

					response.addCookie(c); 

				} else { 

					if (!c.getValue().equals(mvo.getMemberId())) {
						c.setValue(mvo.getMemberId()); 
						
						response.addCookie(c); 

					}
				}
			} else {
				if (c != null) {
					if (c.getValue().equals(mvo.getMemberId())) {
					}
					c.setMaxAge(60 * 60 * 24);
					c.setPath("/");
					response.addCookie(c);

				}

			}
			ViewResult.setData(request, "/ex/", "오늘도 EasyTicket을 찾아주셔서 감사합니다.");

		} else {

			ViewResult.setData(request, "/ex/member/loginForm", "아이디 혹은 비밀번호가 잘못되었습니다.");

		}

		return ViewPath.COMMON + "result.jsp";
	}

	//비밀번호 및 아이디를 찾는 폼으로 이동
	@RequestMapping("/member/findForm")
	public String findForm(HttpServletRequest reqeust, Model mo) {

		return ViewPath.MEMBER + "findForm.jsp";
	}

	@RequestMapping("/member/find")
	public String findIdAndPassword(MemberVO vo, Model mo, String mode) {

		System.out.println(mode);

		if (mode.equals("id")) {

			String id = memberservice.findId(vo);

			System.out.println(id);

			ViewResult.setData(mo, "/ex/member/loginForm", "아이디는 " + id + "입니다.");

			

		} else {

			String pw = memberservice.findPw(vo);

			String pwSecure = "";

			for (int i = 0; i < pw.length(); i++) {
				if (i % 2 == 0) {

					pwSecure += pw.charAt(i);
				} else {

					pwSecure += "*";
				}

			} // for문 끝

			System.out.println(pwSecure);

			ViewResult.setData(mo, "/ex/member/loginForm", "비밀번호는 " + pwSecure + "입니다.");

		}

		
		return ViewPath.COMMON + "result.jsp";
	}

	// 마이페이지
	@RequestMapping("/member/myPage")
	public String myPage(HttpServletRequest request, MemberVO mvo, Model mo) {

		int memberSeq = (int) request.getSession().getAttribute("login");


		mvo = memberservice.findMember(memberSeq);

		request.setAttribute("mvo", mvo);

		System.out.println("마이페이지 확인 : " + mvo.getMemberName());

		// 예매 내역

		List<BookVO> bookList = bookService.selectBook(memberSeq);// memberSeq로 book테이블의 레코드를 구한다.

		mo.addAttribute("bookList", bookList);

		return ViewPath.MEMBER + "myPage.jsp";
	}

	// 정보 수정 폼으로 이동
	@RequestMapping("/member/updateForm")
	public String updateForm(HttpServletRequest request, MemberVO mvo) {

		int memberSeq = (int) request.getSession().getAttribute("login");

		mvo = memberservice.findMember(memberSeq);

		request.setAttribute("mvo", mvo);

		return ViewPath.MEMBER + "updateForm.jsp"; 
	}

	// 비밀번호 변경 폼으로 이동
	@RequestMapping("/member/updatePasswordForm")
	public String updatePasswordForm() {

		return ViewPath.MEMBER + "updatePasswordForm.jsp";
	}

	// 비밀번호 변경
	@RequestMapping("/member/updatePassword")
	@ResponseBody 
	public String updatePw(String newPassword, String memberPassword, HttpServletRequest request, MemberVO mvo) {

		String result = "";
		System.out.println("현재 비번 : " + memberPassword + " 새 비번 : " + newPassword);

		int memberSeq = (int) request.getSession().getAttribute("login");
		

		mvo = memberservice.findMember(memberSeq);

		// 1.회원의 비밀번호가 맞는지 확인 - 비밀번호 변경 진행
		if (mvo.getMemberPassword().equals(memberPassword)) {

			int num = 0;

			memberPassword = newPassword;

			HashMap<String, Object> map = new HashMap<>(); 

			map.put("memberSeq", memberSeq);

			map.put("memberPassword", memberPassword);
			// HashMap클래스의 객체에 memberSeq와 변경한 비밀번호를 저장한다.

			num = memberservice.updatePw(map);

			result = "true";

			return result;

		} else if (mvo.getMemberPassword() != memberPassword) {
		
			result = "false";
		}
		return result;
	}

	// 회원정보 변경
	@RequestMapping("/member/updateMember")
	public String updateMember(HttpServletRequest request, MemberVO mvo) {

		int memberSeq = (int) request.getSession().getAttribute("login"); // 세션의 회원정보(memberSeq) 불러오기
		mvo.setMemberSeq(memberSeq);

		System.out.println("업데이트 확인용 :  " + mvo.getMemberAddress());

		MemberVO originalMvo = memberservice.findMember(memberSeq);


		if (mvo.getMemberAddress().equals(originalMvo.getMemberAddress())) {

			ViewResult.setData(request, "/ex/member/updateForm", "이미 등록된 주소입니다.");

		} else if (mvo.getMemberTel().equals(originalMvo.getMemberTel())) {

			ViewResult.setData(request, "/ex/member/updateForm", "이미 등록된 전화번호입니다.");
		} else {

			ViewResult.setData(request, "/ex/member/updateForm", "회원 정보가 변경되었습니다.");
		}

		int su = memberservice.updateMember(mvo);

		System.out.println(su);

		return ViewPath.COMMON + "result.jsp";
	}

	// 마이페이지 -비밀번호 확인
	@RequestMapping("/member/checkPasswordForm")
	public String checkPasswordForm() {

		return ViewPath.MEMBER + "checkPassword.jsp";
	}

	@RequestMapping("/member/checkPassword")
	public String checkPassword(HttpServletRequest request, MemberVO mvo) {

		String memberPw = request.getParameter("memberPw");

		int memberSeq = (int) request.getSession().getAttribute("login");

		mvo = memberservice.findMember(memberSeq);

		if (!mvo.getMemberPassword().equals(memberPw)) {

			ViewResult.setData(request, "/ex/member/checkPasswordForm", "비밀번호가 다릅니다");
		} else {

			ViewResult.setData2(request, "/ex/member/updateForm");
		}

		return ViewPath.COMMON + "result.jsp";
	}

	//회원탈퇴 폼으로 이동
	@RequestMapping("/member/deleteForm")
	public String delete(MemberVO mvo) {

		return ViewPath.MEMBER + "deleteForm.jsp";
	}

	// 회원 탈퇴
	@RequestMapping("/member/delete")
	public String deleteMember(HttpSession session, String memberPassword, HttpServletRequest request, MemberVO mvo,
			Model mo) {

		int memberSeq = (int) request.getSession().getAttribute("login");

		mvo = memberservice.findMember(memberSeq);

		if ((mvo.getMemberPassword()).equals(memberPassword)) {

			memberservice.deleteMember(memberSeq);

			ViewResult.setData(mo, "/ex/", "탈퇴 되었습니다.");
			session.invalidate();

		} else {

			ViewResult.setData(mo, "/ex/common/result", "비밀번호가 일치하지 않습니다.");
		}

		return ViewPath.COMMON + "result.jsp";
	}

	@RequestMapping("/member/logout")
	public String logout(Model mo, HttpSession session) {

		session.invalidate(); 
		ViewResult.setData(mo, "/ex/", "로그아웃 되었습니다.");

		return ViewPath.COMMON + "result.jsp";
	}
	


}
