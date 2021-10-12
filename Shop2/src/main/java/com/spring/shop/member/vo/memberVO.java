package com.spring.shop.member.vo;

public class memberVO {
	private String id;
	private String pw;
	private String name;
	private String tell;
	private String addr;
	private String gender;
	private String isAdmin;
	private String joinDate;
	private String[] tells;
	private String[] addres;
	
	
	public String[] getAddres() {
		return addres;
	}
	public void setAddres(String[] addres) {
		
		String addr = addres[0] + " " + addres[1];
		setAddr(addr);
	}
	public String[] getTells() {
		return tells;
	}
	public void setTells(String[] tells) {
		//this.tells = tells;
		String tell = tells[0] + "-" + tells[1] + "-" +tells[2];
		setTell(tell);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
