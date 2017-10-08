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
import com.spring.tryAngle.Service.FaqCompleteService;
import com.spring.tryAngle.Service.FaqInsertService;
import com.spring.tryAngle.Service.FaqSelectService;
import com.spring.tryAngle.Service.MyService;
import com.spring.tryAngle.Validation.ContactValidation;



/**
 * @author 김의현
 * @category Controller.Class
 * @since 2017.09.22 ~ 
 * @version 1.0 TryAngle
 * 
 */


@Controller
public class QnaController {
	
	
	String viewPage;
	
	ModelAndView mv;
	
	MyService myService;


	@RequestMapping(value = "QnA.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String qna(Model model) {
		
		viewPage = "05_QnAHome";
		
		myService = new FaqSelectService();
		
		myService.excute(model);
		
		return viewPage;
	}
	
	@RequestMapping(value ="Qna_from.do")
	public String qnaFrom() {

		viewPage = "05_QnA_1";
		
		return viewPage;
		
	}
	
	
	@RequestMapping(value="QnaInsert.do" ,method= {RequestMethod.POST, RequestMethod.GET})
	public String qnaInsert(@ModelAttribute("dto") ContactDTO dto, BindingResult result, Model model,HttpServletRequest request)  {
		
		ContactValidation val = new ContactValidation();
		
		val.validate(dto, result);
		myService = new FaqInsertService();
		model.addAttribute("request", request);
		model.addAttribute("model",dto);
		if(result.hasErrors()) {
			//애러가 있으면
			
			viewPage = "redirect:err/404.do";
			
		}
		else {
			
			
			if(myService.isExcute(model)) {
				//디비 등록 성공
				viewPage = "redirect:QnaComplete.do";	
				
			}else {
				//디비 등록 실패	
				viewPage= "05_QnA_1";		
			}
			
			
		}
		
		
		return viewPage;
	}
	

	
	@RequestMapping(value="QnaComplete.do" ,method= {RequestMethod.POST, RequestMethod.GET})
	public String qnaComplete(HttpServletRequest request, Model model)  {
		

		viewPage = "08_Complete";
		
		model.addAttribute("request", request);
		
		myService = new FaqCompleteService();
		
		myService.excute(model);
		
		
		return viewPage;
	}
		

}
