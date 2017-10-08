package com.spring.tryAngle.Service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @author 김의현
 * @since 2017.09.25
 * @category Join Service
 * @version 1.0 TryAngle
 * Join 완성 창 팝업
 */

public class JoinCompleteService implements MyService{

	@Override
	public void excute(ModelAndView model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExcute(ModelAndView model) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		
		ArrayList<String> list = new ArrayList();
		
		
		Map<String, Object> map =  model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		/* 세션 생성*/
		HttpSession session = request.getSession();
		String joinId = (String) session.getAttribute("TryAngleJoinid");
				
		String[] text = {
				"Welcome",
				"Welcome to great experience",
				joinId+"님. 가입을 환영합니다.",
				"우리는 당신의 영원한 친구 입니다."
		};
		
		for(int i=0; i<text.length; i++) {
			list.add(text[i]);
		}

		model.addAttribute("list",list);
	}

	@Override
	public boolean isExcute(Model model) {
		// TODO Auto-generated method stub
		return false;
	}


}
