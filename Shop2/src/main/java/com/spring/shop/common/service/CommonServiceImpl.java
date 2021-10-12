package com.spring.shop.common.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.common.vo.MenuVO;
import com.spring.shop.common.vo.SideMenuVO;

@Service("CommonService")
public class CommonServiceImpl implements CommonService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//상단 메뉴 목록 조회
	public List<MenuVO> selectMenuList() {
		
		return sqlSession.selectList("commonMapper.selectMenuList");
	}
	//사이드 메뉴 목록 조회
	@Override
	public List<SideMenuVO> selectSideMenuList(String menuCode) {
		return sqlSession.selectList("commonMapper.selectSideMenuList", menuCode);
	}
}
