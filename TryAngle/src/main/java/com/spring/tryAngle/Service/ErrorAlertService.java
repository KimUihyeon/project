package com.spring.tryAngle.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public class ErrorAlertService implements MyService{
	
	private String code;
	
	public ErrorAlertService(String code) {
		this.code = code;
	}

	@Override
	public void excute(ModelAndView model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = (Map) model.asMap();
		
		HttpServletRequest requset = (HttpServletRequest) map.get("request");
		
		HttpSession session = requset.getSession();
		
		session.setAttribute("alertCode", code);
		
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
