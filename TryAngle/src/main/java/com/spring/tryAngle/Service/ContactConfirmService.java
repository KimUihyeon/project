package com.spring.tryAngle.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tryAngle.DTO.ContactDTO;

/**
 * 
 * @author 김의현
 * @since 2017.09.23 
 * @category Contact Confirm Service 받은값 뒤로 넘겨줌
 * @version 1.0 TryAngle
 *
 */
public class ContactConfirmService implements MyService{

	@Override
	public void excute(ModelAndView model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = (Map) model.asMap();

		ContactDTO dto = (ContactDTO) map.get("model");
		
		model.addAttribute("cv", dto);		
		
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
