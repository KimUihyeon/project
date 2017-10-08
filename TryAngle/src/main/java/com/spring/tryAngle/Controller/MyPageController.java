package com.spring.tryAngle.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tryAngle.DTO.ContactDTO;
import com.spring.tryAngle.DTO.MemberDTO;
import com.spring.tryAngle.Service.ContactCompleteService;
import com.spring.tryAngle.Service.ErrorAlertService;
import com.spring.tryAngle.Service.MyContactDetailService;
import com.spring.tryAngle.Service.MyContactSelsectService;
import com.spring.tryAngle.Service.MyInfoCompleteService;
import com.spring.tryAngle.Service.MyInfoSelectService;
import com.spring.tryAngle.Service.MyInfoUpdateService;
import com.spring.tryAngle.Service.MyService;
import com.spring.tryAngle.Util.CurrentSession;
import com.spring.tryAngle.Validation.MemberValidation;

/**
 * @author 김의현
 * @category Controller.Class
 * @since 2017.09.26 ~ 
 * @version 1.0 TryAngle
 * 
 */

@Controller
public class MyPageController {
	
	String viewPage;
	
	ModelAndView mv;
	
	MyService myService;
	
	CurrentSession acess = new CurrentSession("LoginId");	
	
	
	
	
	@RequestMapping( value = "myPage.do" , method= {RequestMethod.POST , RequestMethod.GET})
	public String profile(HttpServletRequest request) {
		
		viewPage="redirect:err/404.do";
		
		if(acess.acess(request.getSession())) {
			
			viewPage="09_Mypage";
			
		}
		
		return viewPage;
		
	}
	

	@RequestMapping( value = "myModifyAcess.do" , method= {RequestMethod.POST, RequestMethod.GET})
	public String myModifyAcess(HttpServletRequest request, Model model){

		viewPage="redirect:err/404.do";
		if(acess.acess(request.getSession())) {
			viewPage= "09_Mypage_aecces";
			
		}
		HttpSession session = request.getSession();
		String type = (String) session.getAttribute("LoginType");
		if(type.equals("nomal")) {
			viewPage= "09_Mypage_aecces";
		}else {
			viewPage="redirect:err/404.do";
		}
		
		
		return viewPage;
	}
	
	@RequestMapping( value = "myModify.do" , method= {RequestMethod.POST, RequestMethod.GET})
	public String myModify(HttpServletRequest request, Model model){

		viewPage="redirect:err/404.do";
		HttpSession session = request.getSession();
		String type = (String) session.getAttribute("LoginType");
		if(type.equals("nomal")) {

			if(acess.acess(request.getSession())) {

				viewPage= "09_Mypage_update";
				
				myService = new MyInfoSelectService ();

				model.addAttribute("str", acess.getInner());
				
				myService.excute(model);
				
			}
			
		}else {
			viewPage="redirect:err/404.do";
		}
		
		
		
		return viewPage;
	}


	@RequestMapping( value = "myModifyUpdate.do" , method= {RequestMethod.POST, RequestMethod.GET})
	public String myModifyUpdate(@ModelAttribute("dto") MemberDTO dto, BindingResult error,
			HttpServletRequest request, Model model){

		viewPage="redirect:err/404.do";
		
		MemberValidation val = new MemberValidation();
		
		if(acess.acess(request.getSession())) {
			//세션 있음
			
			val.validate(dto, error);
			
			if(!error.hasErrors()) {
				// Validation 통과
				
				myService = new MyInfoUpdateService();
				
				model.addAttribute("request",request);

				model.addAttribute("str", acess);
				
				model.addAttribute("dto", dto);
				
				if(myService.isExcute(model)) {
					// 현재 세션과  parameter 아이디 비교하고 디비에 등록 성공
					
					viewPage = "redirect:myModifyComplete.do";
					
				}
				
				
			}
			
		}
		
		
		return viewPage;
	}


	@RequestMapping( value = "myModifyComplete.do" , method= {RequestMethod.POST, RequestMethod.GET})
	public String myModifyComplete(HttpServletRequest request, Model model){

		viewPage="redirect:err/404.do";


		if(acess.acess(request.getSession())) {
			
			viewPage = "08_Complete";
			
			model.addAttribute("request", request);
			
			myService = new MyInfoCompleteService();
			
			myService.excute(model);
			
		}
		
		return viewPage;
	}
	
	
	

	@RequestMapping( value = "myContact.do" , method= {RequestMethod.POST, RequestMethod.GET})
	public String myContact(HttpServletRequest request,Model model){

		viewPage="redirect:err/404.do";
		
		if(acess.acess(request.getSession())) {

			viewPage= "09_Mypage_contact";
			
			myService = new MyContactSelsectService();
			
			HttpSession session = request.getSession();
			
			String type = (String) session.getAttribute("LoginType");

			model.addAttribute("str", acess.getInner());

			model.addAttribute("type", type);
			
			myService.excute(model);
			
		}
		
		
		return viewPage;
	}

	
	@RequestMapping( value = "myContactDetail.do" , method= {RequestMethod.POST, RequestMethod.GET})
	public String myContactDetail(HttpServletRequest request,Model model){

		viewPage="redirect:err/404.do";
		
		if(acess.acess(request.getSession())) {

			myService = new MyContactDetailService();

			model.addAttribute("str", acess.getInner());
			model.addAttribute("request", request.getParameter("t"));
			
			if( myService.isExcute(model) ) {
				
				viewPage= "09_Mypage_contact_2";
				
			}
			
		}
		
		
		return viewPage;
	}
	
	
	

}
