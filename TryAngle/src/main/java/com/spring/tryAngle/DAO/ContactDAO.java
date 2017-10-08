package com.spring.tryAngle.DAO;

import java.util.ArrayList;

import com.spring.tryAngle.DTO.ContactDTO;

public interface ContactDAO {
	
	/* 의뢰 DB 등록 */
	public void contactInsert(String id,String name, String tel, String title, String context, String Date ,String type);
	
	/* myPage select */
	public ArrayList<ContactDTO> myPageContactSelect(String id,String type);
	
	public ContactDTO myPageContactDetail(String id, String primaryKey);
}
