package com.spring.tryAngle.Service;

import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tryAngle.DAO.ContactDAO;
import com.spring.tryAngle.DTO.ContactDTO;
import com.spring.tryAngle.Util.Construct;

public class MyContactSelsectService implements MyService {

	@Override
	public void excute(ModelAndView model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		
		try {

			String str = (String) model.asMap().get("str");
			String type = (String) model.asMap().get("type");
			ArrayList<ContactDTO> dto = Construct.getIntence().getSql().
					getMapper(ContactDAO.class).myPageContactSelect(str,type);
			
			model.addAttribute("list", dto);	
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
	}

	@Override
	public boolean isExcute(ModelAndView model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExcute(Model model) {
		// TODO Auto-generated method stub
		return false;
	}

}
