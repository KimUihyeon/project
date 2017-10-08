package com.spring.tryAngle.Controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.tryAngle.DAO.FaqDAO;
import com.spring.tryAngle.DAO.MemberDAO;
import com.spring.tryAngle.DTO.FaqDTO;
import com.spring.tryAngle.DTO.MemberDTO;
import com.spring.tryAngle.Service.FaqSelectService;
import com.spring.tryAngle.Service.FindIdService;
import com.spring.tryAngle.Service.FindMailService;
import com.spring.tryAngle.Service.FindPwService;
import com.spring.tryAngle.Service.JoinComfirmService;
import com.spring.tryAngle.Service.LoginOkService;
import com.spring.tryAngle.Service.MyService;
import com.spring.tryAngle.Util.Construct;

/**
 * @author 김의현
 * @category Controller.Class
 * @since 2017.09.22 ~ 10.01
 * @version 1.0 TryAngle
 * 
 */
@Controller
public class AjaxController {
	
	private String viewPage;
	
	MyService myService;
	
	@RequestMapping( value ="index2.do")
	public String Ajax(Model model) {
		
		myService = new FaqSelectService();
		
		myService.excute(model);
		
		return viewPage;
	}
	
	/* 로그인 Ajax */
	@RequestMapping( value="loginAjax.Ajax" /*,method = {RequestMethod.POST}*/)
	public String AjaxLogin(@RequestParam("id") String id,
			@RequestParam("pw") String pw, Model model,
			HttpServletRequest request,	HttpServletResponse response) {

		id = id.trim();

		viewPage = "redirect:login.do";
		
		myService = new LoginOkService();
		
		model.addAttribute("request", request);
		
		String bool = "false";
		
		if(myService.isExcute(model)) {
			// 로그인 성공
			bool = "true";
			
		}else {
			// 로그인 실패 
			bool = "false";
			
		}
		
		try {
			/*Json 객체 생성*/
			JSONArray jCase = new JSONArray();  // 큰배열
			
			JSONObject jObj = new JSONObject(); // 내부 오브젝트
			jObj.put("bool", bool);
			jCase.add(jObj);
			
			response.getWriter().print(jCase);;
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return null;
	}
	

	/* 회원가입 중복확인 검사 Ajax */
	@RequestMapping( value = "joinComfirmAjax.Ajax")
	public String AjaxJoinComfirm(@ModelAttribute("member") MemberDTO member, 
			HttpServletRequest request , HttpServletResponse response, ModelAndView model) {
		
		String bool = "false";

		model.addObject("member",member);
		
		myService = new JoinComfirmService();
		
		if(myService.isExcute(model)) {
			
			bool = "true";
			
		}
		
		else {
			
			bool = "false";
		}
		
		
		try {
			
			JSONObject JObj = new JSONObject();
			
			JObj.put("bool", bool);
			
			response.getWriter().print(JObj);
			
		}catch(Exception e) {
			
			bool = "false";
					
		}
		
		return null;
	}
	
	/* 아이디 찾기 */
	@RequestMapping( value = "findIdAjax.Ajax")
	public String AjaxFindId(@ModelAttribute("dto") MemberDTO dto ,Model model,
			HttpServletResponse response, HttpServletRequest request) throws Exception{
		
		String bool = "false";

		model.addAttribute("dto", dto);

		model.addAttribute("request", request);
		
		FindIdService FindService = new FindIdService();
		
		if(FindService.isExcute(model)) {

			bool = "true";
		}
		
		try {
			JSONObject jObj = new JSONObject();
			
			jObj.put("bool", bool);
			
			response.getWriter().print(jObj);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		return null;
	}
	
	/* 비밀번호 찾기 */
	@RequestMapping( value = "findPwAjax.Ajax")
	public String AjaxFindpw(@ModelAttribute("dto") MemberDTO dto ,Model model,
			HttpServletResponse response, HttpServletRequest request) throws Exception{
		
		String bool = "false";

		model.addAttribute("dto", dto);

		model.addAttribute("request", request);
		
		FindPwService FindService = new FindPwService();
		
		if(FindService.isExcute(model)) {
			
			bool = "true";
			
		}
		
		try {
			JSONObject jObj = new JSONObject();
			
			jObj.put("bool", bool);
			
			response.getWriter().print(jObj);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return null;
	}
	
	/* 비번찾고 메일 보내기*/
	@RequestMapping( value = "mailGoAjax.Ajax" )
	public String AjaxMail(@ModelAttribute("dto") MemberDTO dto ,Model model,
			HttpServletResponse response, HttpServletRequest request) throws Exception{
		String url  = String.valueOf(request.getRequestURL());
		
		dto.setTelc(url);
		
		model.addAttribute("dto", dto);
		
		myService = new FindMailService();
		
		myService.excute(model);
		
		return null;
	}
	
	

}
