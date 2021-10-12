package com.spring.shop.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.member.vo.memberVO;

@Service("memberService")
public class memberServiceImpl implements memberService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//회원가입
	@Override
	public int insertJoin(memberVO memberVO) {
		return sqlSession.insert("memberMapper.insertJoin", memberVO);
	}

	//로그인
	@Override
	public memberVO login(memberVO memberVO) {
		return sqlSession.selectOne("memberMapper.login", memberVO);
	}
	//id중복체크
	@Override
	public boolean isJoined(String id) {
		//기가입 : true, 미가입 : false
		String result = sqlSession.selectOne("memberMapper.isJoined" , id);
		
		return result == null ? false : true;
	}
	//회원목록조회
	@Override
	public List<memberVO> memberList() {
		
		return sqlSession.selectList("memberMapper.memberList");
	}
	

}
