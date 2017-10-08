package com.spring.tryAngle.Service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.tryAngle.DAO.FaqDAO;
import com.spring.tryAngle.DTO.FaqDTO;
import com.spring.tryAngle.Util.Construct;

public class FaqSelectService implements MyService {

	@Override
	public void excute(ModelAndView model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub

		
		
		try {
			FaqDAO dao = Construct.getIntence().getSql().getMapper(FaqDAO.class);
			ArrayList<FaqDTO> dto = dao.selectFaQ();
			
			model.addAttribute("qna", dto);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
