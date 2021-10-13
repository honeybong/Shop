package com.spring.shop.item.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.shop.item.vo.CategoryVO;
import com.spring.shop.item.vo.itemVO;

@Service("itemService")
public class itemServiceImpl implements itemService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//카테고리 목록조회
	@Override
	public List<CategoryVO> selectCategoryList() {
		return sqlSession.selectList("itemMapper.selectCategoryList");
	}
	//카테고리 등록
	@Override
	public void insertCategory(String cateName) {
		sqlSession.insert("itemMapper.insertCategory", cateName);
	}
	//카테고리 삭제
	@Override
	@Transactional(rollbackFor = Exception.class) //트랜젝션처리하기위한 어노테이션, 오류를 롤백시키기위해 Exception.class씀
	public void deleteCategory(CategoryVO categoryVO) {
		//얘는 카테고리 삭제하려면 안에 item이 들어있으면 안돼서 카테고리 삭제용으로 만듬
		sqlSession.delete("itemMapper.deleteItemByCateCode", categoryVO);
		//얘가 진짜 카테고리 삭제
		sqlSession.delete("itemMapper.deleteCategory", categoryVO);
	}
	//아이템 등록
	@Override
	public void insetItem(itemVO itemVO) {
		sqlSession.insert("itemMapper.insertItem", itemVO);
		
	}
	//상품 이미지 정보
	@Override
	public void insertImgs(itemVO itemVO) {
		sqlSession.insert("itemMapper.insertImgs", itemVO);
		
	}
	//다음 img_code의 숫자를 확인
	@Override
	public int selectNextNumber() {
		return sqlSession.selectOne("itemMapper.SselectNextNumber");
	}

}
