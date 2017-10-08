package com.spring.tryAngle.Service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public class ContactCompleteService implements MyService{

	@Override
	public void excute(ModelAndView model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		
		ArrayList<String> list = new ArrayList();
		
		
		Map<String, Object> map =  model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		/* 세션 생성*/
		HttpSession session = request.getSession();
		String cName = (String) session.getAttribute("ContactName");
				
		String[] text = {
				"Contact Us",
				"Great experiences build great brands",
				cName+"님. 감사합니다. 접수 되었습니다.",
				"답변까진 최대 3일까지 소요됩니다."
		};
		
		for(int i=0; i<text.length; i++) {
			list.add(text[i]);
		}

		model.addAttribute("list",list);
		
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
