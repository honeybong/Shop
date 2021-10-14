package com.spring.shop.common.vo;

public class PageVO {
	private int nowPage;       //현재 선택된 페이지 번호
	private int totalCnt;      //전체 데이터 수
	private int beginPage;     //화면에 보이는 첫 페이지
	private int endPage;       //화면에 보이는 마지막 페이지
	private int displayCnt;    //한 화면에 보여지는 게시글 수
	private int displayPageCnt;//한번에 보여지는 페이지 수
	private boolean prev;      //이전 버튼의 유무
	private boolean next;      //다음 버튼의 유무
	private int startNum;
	private int endNum;
	
	public PageVO() {
		nowPage = 1;
		displayCnt = 10;
		displayPageCnt = 5;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayCnt() {
		return displayCnt;
	}

	public int getDisplayPageCnt() {
		return displayPageCnt;
	}

	public int getStartNum() {
		return startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public int getEndPage() {
		return endPage;
	}
	
	//이 메소드 호출 시 페이징 처리의 모든 정보가 세팅
	public void setPageInfo() {
		//화면에 보이는 마지막 페이지 번호를 설정
		endPage = (int)(Math.ceil(nowPage / (double)displayPageCnt)) * displayPageCnt; //ceil은 올림함수
		
		//화면에 보이는 첫 페이지 번호를 설정
		beginPage = endPage - displayPageCnt + 1;
		
		//전체 페이지 수
		int totalPage = (int)(Math.ceil(totalCnt / (double)displayCnt));
		
		//next버튼의 유무
		if(endPage < totalPage) {
			next = true;
		}
		else {
			next = false;
			endPage = totalPage;
		}
		
		//prev버턴의 유무
		prev = beginPage == 1 ? false : true;
	}
	
	
}
