package com.spring.shop.admin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.shop.common.service.CommonService;
import com.spring.shop.item.service.itemService;
import com.spring.shop.item.vo.CategoryVO;
import com.spring.shop.item.vo.itemVO;
import com.spring.shop.member.service.memberService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource(name="itemService")
	private itemService itemService;
	@Resource(name="CommonService")
	private CommonService commonService;
	@Resource(name="memberService")
	private memberService memberService;
	
	//카테고리 관리 페이지로 이동
	@GetMapping("/categoryManage")
	public String goCategoryManage(Model model) {
		//선택한 사이드 메뉴를 지정하기 위한 데이터
		model.addAttribute("sidePage", "categoryManage");
		//일반회원 메뉴목록 조회
		model.addAttribute("categoryList", itemService.selectCategoryList());
		//관리자 메뉴목록 조회
		model.addAttribute("menuList", commonService.selectMenuList());
		
		//사이드 메뉴 목록 조회
		model.addAttribute("sideMenuList", commonService.selectSideMenuList("MENU_001"));
		
		return "admin/category_manage";
	}
	//관지라의 회원 관리 페이지로
	@GetMapping("/selectMemberList")
	public String goMemberManage(Model model) {
		//선택한 사이드 메뉴를 지정하기 위한 데이터
		model.addAttribute("sidePage", "selectMemberList");
		//관리자 메뉴목록 조회
		model.addAttribute("menuList", commonService.selectMenuList());
		//회원 목록 조회
		model.addAttribute("memberList", memberService.memberList());
		
		//사이드 메뉴 목록 조회
		model.addAttribute("sideMenuList", commonService.selectSideMenuList("MENU_002"));
		
		
		return "admin/member_list";
	}
	//카테고리 등록
	@PostMapping("/insertCategory")
	public String insertCategory(String cateName) {
		itemService.insertCategory(cateName);
		
		return "redirect:/admin/categoryManage";
	}
	
	//카테고리 삭제
	@GetMapping("/deleteCategory")
	public String deleteCategory(CategoryVO categoryVO) {
		itemService.deleteCategory(categoryVO);
		return "redirect:/admin/categoryManage";
	}
	
	//상품 등록 페이지로 이동
	@GetMapping("/regItem")
	public String goRegItem(Model model) {
		model.addAttribute("sidePage", "regItem");
		
		model.addAttribute("categoryList", itemService.selectCategoryList());
		//메뉴 목록 조회를 위한거
		model.addAttribute("menuList", commonService.selectMenuList());
		
		//사이드 메뉴 목록 조회
		model.addAttribute("sideMenuList", commonService.selectSideMenuList("MENU_001"));
		return "admin/reg_item";
	}
	
	//상품 등록
	@PostMapping("/regItem")
	public String regItem(itemVO itemVo) {
		
		itemService.insetItem(itemVo);
		
		return "redirect:/admin/regItem";
		
		
	}

}
