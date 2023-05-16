package com.ex.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class ViewResult { //common 패키지에 있는 ViewMethod 클래스

	public static void setData(Model model, String url, String msg) {
		model.addAttribute("url", url);
		//Model객체를 호출하여 첫번재 매개변수에는 저장할 내용의 이름을 지정하고 두번째 매개변수에는 저장할 내용을 넣는다.
		
		model.addAttribute("msg", msg);
		return;
	}
	
	
	public static void method1(Model m, String url, String msg) {
		
		m.addAttribute("url", url);
		//Model인터페이스의 메서드 addAttribute를 호출하여 첫번째 매개변수에는 저장할 내용의 이름을 지정하고 두번째
		//매개변수에는 저장할 내용을 넣는다.


		m.addAttribute("msg", msg);
		//Model인터페이스의 메서드 addAttribute를 호출하여 첫번째 매개변수에는 저장할 내용의 이름을 지정하고 두번째
		//매개변수에는 저장할 내용을 넣는다.

	
	}
	
	
	
	public static void setData(HttpServletRequest request, String url, String msg) {
		request.setAttribute("url", url); //HttpServletRequest인터페이스의 메서드 setAttribute를 호출하여
		//첫번째 매개변수에는 바꿀 내용을 불러올 이름을, 두번째 매개변수에는 바꿀 내용을 넣는다.

		request.setAttribute("msg", msg);
		return;
	}
	
	public static void setData2(HttpServletRequest request, String url) {
		request.setAttribute("url", url); //HttpServletRequest인터페이스의 메서드 setAttribute를 호출하여
		//첫번째 매개변수에는 바꿀 내용을 불러올 이름을, 두번째 매개변수에는 바꿀 내용을 넣는다.

	
		return;
	}
	
}
