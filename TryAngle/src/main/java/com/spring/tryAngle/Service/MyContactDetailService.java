package com.spring.tryAngle.Service;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tryAngle.DAO.ContactDAO;
import com.spring.tryAngle.DTO.ContactDTO;
import com.spring.tryAngle.Util.Construct;

public class MyContactDetailService implements MyService{

	@Override
	public void excute(ModelAndView model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExcute(ModelAndView model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExcute(Model model) {
		// TODO Auto-generated method stub

		boolean sw = false;
		
		try {
			

			Map<String, Object> map = model.asMap();
			
			String sessionId = (String) map.get("str");
			
			String key = (String) map.get("request");
			
			ContactDTO dto = Construct.getIntence().getSql()
					.getMapper(ContactDAO.class).myPageContactDetail(sessionId,key);
			
			model.addAttribute("detail", dto);
			
			sw = true;
			
		}catch(Exception e) {
			e.printStackTrace();
			
			sw = false;
		}
		
		return sw;
	}

}
