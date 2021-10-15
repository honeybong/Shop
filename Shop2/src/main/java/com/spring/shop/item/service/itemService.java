package com.spring.shop.item.service;

import java.util.List;

import com.spring.shop.common.vo.PageVO;
import com.spring.shop.item.vo.BoardVO;
import com.spring.shop.item.vo.CategoryVO;
import com.spring.shop.item.vo.itemVO;

public interface itemService {
	//상품 목록 조회
	List<itemVO> selectItemList();
	
	//상품 카테고리 목록 조회
	List<CategoryVO> selectCategoryList();
	
	//카테고리 등록
	void insertCategory(String cateName);
	
	//카테고리 삭제
	void deleteCategory(CategoryVO categoryVO);
	
	//상품 등록
	void insetItem(itemVO itemVO);
	
	//상품 이미지 정보
	void insertImgs(itemVO itemVO);

	//다음 img_code의 숫자를 확인
	int selectNextNumber();
	
	//다음 ITEM_CODE를 확인
	String selectNextItemCode();
	
	//게시판 목록 조회
	List<BoardVO> selectBoardList(BoardVO boardVO);
	
	//게시판 전체 개수 조회
	int selectBoardCnt();
}
