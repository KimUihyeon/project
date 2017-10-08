package com.spring.tryAngle.Controller;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.MultiValueMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.spring.tryAngle.Service.MyService;
import com.spring.tryAngle.Service.SNSLoginService;

/**
 * @author 김의현
 * @category Controller.Class
 * @since 2017.10.01 ~ 10.06
 * @version 1.0 TryAngle
 * 
 */
@Controller
public class SNSController {

	private String viewPage;
	private MyService myService;
	
	@RequestMapping( value="callbackNaver.do" )
	public String naverCallback() {
		
		viewPage ="callbackNaver";

		return viewPage;
	}
	

	@RequestMapping( value ="NaverAjax.Ajax")
	public String AjaxNaver(@RequestParam("id") String id, 
			@RequestParam("name") String name, @RequestParam("type") String type, 
			HttpServletRequest request,Model model,HttpServletResponse response) {

		String sw = "false";
		if(id==null || name ==null || type == null ) {
			viewPage = "redirect:err/404.do";
			
		}
		else {
			//정상적인 접근

			model.addAttribute("id", id);
			model.addAttribute("name", name);
			model.addAttribute("type", type);
			model.addAttribute("request", request);

			
			if(type.equals("naver")) {
				// 카카오 로그인

				myService = new SNSLoginService(); 
				
				myService.excute(model);


				sw = "true";
				
			}
			else {
				sw = "false";
				
			}
			
			
			try {
				JSONObject jObj = new JSONObject();
				jObj.put("bool", sw);
				response.getWriter().print(jObj);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return null;
	}
	
	
	@RequestMapping( value="SnsLogin.do" ,  method= {RequestMethod.POST} )
	public String snsLogin (@RequestParam("id") String id, 
			@RequestParam("name") String name, @RequestParam("type") String type, 
			HttpServletRequest request,Model model) {

		
		if(id==null || name ==null || type == null ) {
			viewPage = "redirect:err/404.do";
			
		}
		else {
			//정상적인 접근

			model.addAttribute("id", id);
			model.addAttribute("name", name);
			model.addAttribute("type", type);
			model.addAttribute("request", request);

			
			if(type.equals("kakao")) {
				// 카카오 로그인

				myService = new SNSLoginService(); 
				
				myService.excute(model);


				viewPage = "redirect:index.do";
				
			}
			else {
				viewPage = "redirect:err/404.do";
				// 잘못된 접근
			}
			
			
			
		}
		
		return viewPage;
	}
}
