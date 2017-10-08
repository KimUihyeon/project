package com.spring.tryAngle.DTO;

public class MemberDTO {
	
	public String id;
	public String pw;
	public String name;
	public String tel;
	public String telc;
	
	
	public MemberDTO() {
	}
	
	public MemberDTO(String id, String pw, String name, String tel, String telc) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.telc = telc;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTelc() {
		return telc;
	}

	public void setTelc(String telc) {
		this.telc = telc;
	}

	
	
	
	
}
