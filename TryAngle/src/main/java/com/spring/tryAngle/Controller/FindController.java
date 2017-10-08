package com.spring.tryAngle.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.tryAngle.Service.FaqCompleteService;
import com.spring.tryAngle.Service.FindCompleteService;
import com.spring.tryAngle.Service.MyService;
import com.spring.tryAngle.Util.CurrentSession;

/**
 * @author 김의현
 * @category Controller.Class
 * @since 2017.09.22 ~ 10.01
 * @version 1.0 TryAngle
 * 
 */
@Controller
public class FindController {

	String viewPage;
	
	MyService myService;
	
	CurrentSession acess;

	@RequestMapping( value = "find.do")
	public String findForm(HttpServletRequest request) {
		
		acess = new CurrentSession("LoginId");
		
		viewPage = "09_find";
				
		if(acess.acess(request.getSession())) {
			
			viewPage = "redirect:err/404.do";
			
		}
		
		
		return viewPage;
	}
	
	
	@RequestMapping( value = {"findId.do","findPw.do"} )
	public String findComplete (Model model,HttpServletRequest request) {

		viewPage = "08_Complete";
		

		acess = new CurrentSession("LoginId");
						
		if(acess.acess(request.getSession())) {
			
			viewPage = "redirect:err/404.do";
			
		}
		
		else {
			
			String URI = request.getRequestURI();
			
			model.addAttribute("URI", URI);
			
			model.addAttribute("request", request);
			
			myService = new FindCompleteService();
			
			myService.excute(model);
			
		}
		
		
		return viewPage ;
	}
}
