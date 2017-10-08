package com.spring.tryAngle.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tryAngle.DTO.ContactDTO;
import com.spring.tryAngle.Service.ContactCompleteService;
import com.spring.tryAngle.Service.ContactConfirmService;
import com.spring.tryAngle.Service.ContactInsertService;
import com.spring.tryAngle.Service.MyService;
import com.spring.tryAngle.Validation.ContactValidation;



/**
 * @author 김의현
 * @category Controller.Class
 * @since 2017.09.22 ~ 10.01
 * @version 1.0 TryAngle
 * 
 */

@Controller
public class ContactController {

	String viewPage;
	
	ModelAndView mv;
	
	MyService myService;

	
	@RequestMapping(value = "/contact.do",method={RequestMethod.GET,RequestMethod.POST})
	public String contact() {
		
		viewPage = "04_Contact_Form";
		
		return viewPage;
	}

	
	@RequestMapping(value = "/contactConfirm.do",method={RequestMethod.GET,RequestMethod.POST})
	public String contactComfirm(@ModelAttribute("contact") ContactDTO contact, BindingResult result, Model model) {
		
		
		ContactValidation val = new ContactValidation();
		
		val.validate(contact, result);
		
		if(result.hasErrors()) {
			//벨리데이션 애러있음
			
			viewPage = "redirect:error404.do";
			
		}else {
			//벨리테이션 통과
			model.addAttribute("model", contact);
			
			myService = new ContactConfirmService();
			
			myService.excute(model);
			
			viewPage = "04_Contact_Confirm";
		}
			
		
		
		return viewPage;
	}
	

	@RequestMapping(value = "/contactInsert.do",method={RequestMethod.GET,RequestMethod.POST})
	public String contactInsert(@ModelAttribute("dto") ContactDTO dto, Model model, HttpServletRequest request) {
		
		viewPage = "redirect:err/404.do";
		
		model.addAttribute("model", dto);
		model.addAttribute("request", request);
		
		myService = new ContactInsertService();
		
		if(myService.isExcute(model)) {
			
			viewPage = "redirect:contactOk.do";
			
		}
		
		return viewPage;
	}
	

	@RequestMapping(value = "/contactOk.do",method={RequestMethod.GET,RequestMethod.POST})
	public String contactOk(HttpServletRequest request, Model model) {
		
		viewPage = "08_Complete";
		
		model.addAttribute("request", request);
		
		myService = new ContactCompleteService();
		
		myService.excute(model);
		
		return viewPage;
	}

}
