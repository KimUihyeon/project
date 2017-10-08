package com.spring.tryAngle.Service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public class FindCompleteService implements MyService{

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
		
		String URI = (String) model.asMap().get("URI");
		
		String ment1 ="";
		String ment2 ="";
		if(URI.contains("findId.do")) {
			String findId = (String) session.getAttribute("findId");
			
			String findName = (String) session.getAttribute("findName");
			
			findId = findId.substring(0, findId.length()-4) + "****";
			
			ment1 = findName+"님. 찾으시는 아이디는 "+findId+"입니다";
		}
		else if(URI.contains("findPw.do")) {

			String findName = (String) session.getAttribute("findName");
			
			//String findPw = (String) session.getAttribute("findPw");
			
			String mailAddress = request.getParameter("tel");
						
			ment1 = findName+"님. 찾으시는 비밀번호는 "+mailAddress+"으로 전송되었습니다.";
			
		}
				
		String[] text = {
				"FIND UP",
				"Find your great experience",
				ment1,
				ment2
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

		// TODO Auto-generated method stub
		return false;
	}

}
