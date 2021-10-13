package com.spring.shop.item.vo;

import java.util.List;

public class itemVO {
	private String itemCode;
	private String itemName;
	private String itemPrice;
	private String regDate;
	private String cateCode;
	private List<imgVO> imgList;
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public List<imgVO> getImgList() {
		return imgList;
	}
	public void setImgList(List<imgVO> imgList) {
		this.imgList = imgList;
	}
	
	
}
