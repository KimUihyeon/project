package com.spring.tryAngle.DTO;

public class ContactDTO {
	
	private String name;
	private String tel;
	private String title;
	private String context;
	private String id;
	private String date;
	private String no;
	private String type;
	
	public ContactDTO() {}
	

	public ContactDTO(String name, String tel, String title, String context, String id,String date,String no) {
		super();
		this.name = name;
		this.tel = tel;
		this.title = title;
		this.context = context;
		this.id = id;
		this.date = date;
		this.no = no;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	};	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	};	
	

}
