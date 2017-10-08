package com.spring.tryAngle.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tryAngle.DTO.MemberDTO;
import com.spring.tryAngle.Service.JoinComfirmService;
import com.spring.tryAngle.Service.JoinCompleteService;
import com.spring.tryAngle.Service.JoinOkService;
import com.spring.tryAngle.Service.MyService;
import com.spring.tryAngle.Validation.MemberValidation;


/**
 * @author 김의현
 * @category Controller.Class
 * @since 2017.09.22 ~ 
 * @version 1.0 TryAngle
 * 
 */


@Controller
public class JoinController {
	
	String viewPage;
	
	ModelAndView mv;
	
	MyService myService;
	
	
	@RequestMapping(value = "join.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String join() {
		
		viewPage = "09_join_0";
		
		return viewPage;
	}
	

	@RequestMapping(value = "joinForm.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		
		viewPage = "09_join_1";
		
		return viewPage;
	}


	
	@RequestMapping(value = "joinConfirm.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView joinConfirm(@ModelAttribute("memberDTO") MemberDTO memberDTO,
			BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		
		mv = new ModelAndView();
		mv.addObject("member", memberDTO);
		
		MemberValidation val = new MemberValidation();
		val.validate(memberDTO, result);
		
		if(result.hasErrors()) {
			//Error 발생  Validation 걸림 && 잘못된 접급

			mv.setViewName("redirect:error404.do");
			
		}else {
			// Validation 통과  && 정상접인 접근		
			
			myService = new JoinComfirmService();
			if(myService.isExcute(mv)) {
				// 중복확인 통과하면 
								
				viewPage = "09_join_2";
				mv.setViewName("09_join_2");
				
			}
			else {//중북된 아이디	
				
				viewPage = "redirect:joinForm.do";
				mv.setViewName("redirect:joinForm.do");
				
			}
			
		}
		
		
		return mv;
	}
	

	@RequestMapping(value = "joinOk.do", method= {RequestMethod.POST})
	public ModelAndView joinOk(@ModelAttribute("member") MemberDTO member, HttpServletRequest request) {

		mv = new ModelAndView();
		mv.addObject("member",member);
		
		myService = new JoinOkService();
		
		if(myService.isExcute(mv)) {
			
			/* Complete 에서 사용할 세션 생성 */
			HttpSession session= request.getSession();
			session.removeAttribute("TryAngleJoinid");
			session.setAttribute("TryAngleJoinid", member.getId());
			
			mv.setViewName("redirect:joinComplete.do");
			
		}else {			
			//예기치 못한 사고
			mv.setViewName("redirect:error404.do");
			
		}
		
		
		return mv;
	}
	

	@RequestMapping(value = "joinComplete.do")
	public String joinComplete(Model model, HttpServletRequest request) {
		
		viewPage = "08_Complete";
		
		model.addAttribute("request",request);
		
		myService = new JoinCompleteService();
		myService.excute(model);		
		
		return viewPage;
	}

}
