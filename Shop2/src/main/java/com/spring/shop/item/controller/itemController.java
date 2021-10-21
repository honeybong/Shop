package com.spring.shop.item.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.shop.common.vo.PageVO;
import com.spring.shop.item.service.itemService;
import com.spring.shop.item.vo.BoardVO;

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
	@RequestMapping("/boardList") //얘로쓰면 get post 다 받을수 있음
	public String selectBoardList(Model model, BoardVO boardVO) {
		//PageVO안에 totalCnt 구하기. 전체 데이터 수
		//검색조건 값을 채워주기 위해 boardVO .넣음 상속땜에 써도됨
		int dataCnt = itemService.selectBoardCnt(boardVO);
		boardVO.setTotalCnt(dataCnt);
		
		//페이징처리
		boardVO.setPageInfo();
		
		//jsp에 뿌리기
		model.addAttribute("categoryList", itemService.selectCategoryList());
		model.addAttribute("boardList", itemService.selectBoardList(boardVO));
		return "item/community_list";
		
	}
}
