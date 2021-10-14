package com.spring.shop.common.service;

import java.util.List;

import com.spring.shop.common.vo.MenuVO;
import com.spring.shop.common.vo.SideMenuVO;

public interface CommonService {
	
	//상단 메뉴 목록조회
	List<MenuVO> selectMenuList();
	
	//사이드 메뉴 목록 조회
	List<SideMenuVO> selectSideMenuList(String menuCode);

}
