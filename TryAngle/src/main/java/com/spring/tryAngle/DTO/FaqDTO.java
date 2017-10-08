package com.spring.tryAngle.DTO;

public class FaqDTO {
	
	public String num;
	public String title;
	public String text;
	
	public FaqDTO() {};
	
	public FaqDTO(String num, String title, String text) {
		this.num = num;
		this.title = title;
		this.text = text;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	

}
