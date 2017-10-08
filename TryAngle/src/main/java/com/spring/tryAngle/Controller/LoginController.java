package com.spring.tryAngle.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.tryAngle.DTO.MemberDTO;
import com.spring.tryAngle.Service.ErrorAlertService;
import com.spring.tryAngle.Service.JoinComfirmService;
import com.spring.tryAngle.Service.JoinCompleteService;
import com.spring.tryAngle.Service.JoinOkService;
import com.spring.tryAngle.Service.LoginOkService;
import com.spring.tryAngle.Service.MyService;
import com.spring.tryAngle.Util.CurrentSession;
import com.spring.tryAngle.Validation.MemberValidation;

/**
 * 
 * @author 김의현
 * @category memberController.class
 * @since 2017.09.22~
 * @version 1.0 tryAngle
 *
 */

@Controller
public class LoginController {
	
	String viewPage;
	ModelAndView mv;
	
	MyService myService;

	@RequestMapping(value = "login.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(HttpServletRequest request) {
		
		viewPage = "redirect:err/404.do";
		
		CurrentSession session = new CurrentSession("LoginId");
		if(!session.acess(request.getSession())) {
			//세션 존재하지 않음 
			viewPage = "09_login";		
		}
		
		return viewPage;
	}


	@RequestMapping(value = "logout.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(Model model, HttpServletRequest request) {
		
		viewPage = "redirect:index.do";
		
		HttpSession session = request.getSession();
		session.invalidate();
		//session.removeAttribute("LoginId");
		//session.removeAttribute("LoginName");
		
		return viewPage;
	}


	
	@Deprecated /*Ajax 로 대체 되었습니다.*/
	@RequestMapping(value = "loginOk.do", method= {RequestMethod.POST})
	public String loginOk(HttpServletRequest request, Model model) {
		
		viewPage = "redirect:login.do";
		
		myService = new LoginOkService();
		
		model.addAttribute("request", request);
		
		if(myService.isExcute(model)) {
			
			viewPage="redirect:index.do";
			
			
		}else {
			/* Ajax로 대체 되었습니다 .*/
			
		}
		
		return viewPage;
	}
	



	

}
