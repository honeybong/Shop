package com.spring.shop.item.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.shop.item.service.itemService;

@Controller
@RequestMapping("/item")
public class itemController {
	@Resource(name = "itemService")
	private itemService itemService;
	
	//상품 목록조회
	@GetMapping("/itemList")
	public String selectItemList(Model model) {
		model.addAttribute("categoryList", itemService.selectCategoryList());
		model.addAttribute("itemList", itemService.selectItemList());
		
		return "item/item_list";
	}
	//게시판 목록조회
	@GetMapping("/boardList")
	public String selectBoardList(Model model) {
		model.addAttribute("categoryList", itemService.selectCategoryList());
		model.addAttribute("boardList", itemService.selectBoardList());
		return "item/community_list";
		
	}
}
