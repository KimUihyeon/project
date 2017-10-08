package com.spring.tryAngle.DAO;

import java.util.ArrayList;

import com.spring.tryAngle.DTO.FaqDTO;

public interface FaqDAO {
	
	/* FaQ select*/
	public ArrayList<FaqDTO> selectFaQ();
	
	public void insertFaq(String id, String name, String tel, String title, String context, String date);
}
