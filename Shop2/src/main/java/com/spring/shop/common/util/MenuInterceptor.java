package com.spring.shop.common.util;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.shop.common.service.CommonService;
import com.spring.shop.common.vo.MenuVO;

//인터셉터 기능의 클래스를 구현하는 방법
//1.일단 클래스를 만든다.
//2.인터셉터 기능이 구현된 인터페이스를 구현하거나, 클래스를 상속 받는다.
//인터페이스 - HandlerInterceptor
//클래스 - HandlerInterceptorAdapter
//공통 메소드 : preHandle() 실행전 걸어줘서 검문, postHandle() 실행이 되고 jsp가기전에 걸어줘서 검문, afterComplate()
//원하는 시점에 동작하는 메소드를 재정의 한다.

//상단메뉴와 사이드메뉴를 조회하는 인터셉터
public class MenuInterceptor extends HandlerInterceptorAdapter{
	@Resource(name="CommonService")
	private CommonService commonService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		//jsp에서 컨트롤러로 넘긴 데이터를 이런식으로 가져올수 있음
		//근데 얘는 가져오는 타입이 오브젝트임. 그걸 필요한 타입으로 변형시켜야됨
		String menuCode = (String)(modelAndView.getModel().get("menuCode"));
		

		//상단메뉴 조회
		modelAndView.addObject("menuList", commonService.selectMenuList());
		//사이드메뉴 조회
		modelAndView.addObject("sideMenuList", commonService.selectSideMenuList(menuCode));
	}
	
	
}
