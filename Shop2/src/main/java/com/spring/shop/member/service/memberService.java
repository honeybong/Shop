package com.spring.shop.member.service;

import java.util.List;

import com.spring.shop.member.vo.memberVO;

public interface memberService {
	
	//회원가입
	int insertJoin(memberVO memberVO);
	
	//로그인
	memberVO login(memberVO memberVO);
	
	//id 체크
	boolean isJoined(String id);
	
	//회원 목록 조회
	List<memberVO> memberList();
}
