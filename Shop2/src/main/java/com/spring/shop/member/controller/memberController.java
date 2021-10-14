package com.spring.shop.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.shop.member.service.memberService;
import com.spring.shop.member.vo.memberVO;

@Controller
@RequestMapping("/member")
public class memberController {
	@Resource(name="memberService")
	private memberService memberServic;
	//회원가입 페이지로 이동
	@GetMapping("/join")
	public String goJoin() {
		return "member/join";
	}
	//회원가입
	@PostMapping("/join")
	public String insertJoin(memberVO memberVO) {
			
		memberServic.insertJoin(memberVO);
		return "redirect:/item/itemList";
	}
	
	//아이디 중복 확인
	@ResponseBody //에이작스 인식시키기 위해 사용
	@PostMapping("/checkId")
	public boolean checkId(String id) {
		
		return memberServic.isJoined(id);
	}
	
	//로그인

	
	@PostMapping("/login")
	public String login(memberVO memberVO, HttpSession session) {
		memberVO loginInfo = memberServic.login(memberVO);
		if(loginInfo != null) {
			session.setAttribute("loginInfo", loginInfo);
			if(loginInfo.getIsAdmin().equals("Y")) {
				return "redirect:/admin/categoryManage";
			}
		}
		return "redirect:/item/itemList";
	}
	//로그아웃
	@GetMapping("/Logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginInfo");
		return "redirect:/item/itemList";
	}
}
