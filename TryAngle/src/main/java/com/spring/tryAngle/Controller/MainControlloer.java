package com.spring.tryAngle.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.tryAngle.DTO.ContactDTO;
import com.spring.tryAngle.Service.ContactCompleteService;
import com.spring.tryAngle.Service.ContactConfirmService;
import com.spring.tryAngle.Service.ContactInsertService;
import com.spring.tryAngle.Service.FaqCompleteService;
import com.spring.tryAngle.Service.FaqInsertService;
import com.spring.tryAngle.Service.FaqSelectService;
import com.spring.tryAngle.Service.MyService;
import com.spring.tryAngle.Util.Construct;
import com.spring.tryAngle.Validation.ContactValidation;

/**
 * @author 김의현
 * @category Controller.Class
 * @since 2017.09.22 ~ 
 * @version 1.0 TryAngle
 * 
 */
@Controller
public class MainControlloer {
	
	/**
	 * MainController
	 * one Debs Menu
	 */
	
	MyService myService;
	
	@Autowired
	SqlSession sqlSession;

	@Autowired
	public void setsqlSession(SqlSession sqlSession) {
		Construct.getIntence().setSql(sqlSession);
	}
	String viewPage;
	
	@RequestMapping(value = "/index.do", method= {RequestMethod.GET,RequestMethod.POST})
	public String index(Locale locale, Model model) {
		
		viewPage= "00_index";
		
		return viewPage;
	}
	

	@RequestMapping(value = "/err/404.do")
	public String error404() {
		
		viewPage = "err/00_error404";
		
		
		return viewPage;
	}/*
	

	@RequestMapping(value = "/err/c.do")
	public String errorCode(HttpSession session,HttpServletRequest request,Model model) {
		
		viewPage = "err/ErrorCode";
		
		session = request.getSession();

		String code = (String) session.getAttribute("alertCode");
		
		String url = (String) session.getAttribute("alertUrl");
		
		model.addAttribute("alertCode", code);
		
		model.addAttribute("alertUrl", url);
		
		return viewPage;
	}*/
	
	
	@RequestMapping(value = "/about.do", method={RequestMethod.GET,RequestMethod.POST})
	public String about() {
		
		viewPage = "01_about";
		
		return viewPage;
	}
	
	
	@RequestMapping(value = "/portfolio.do", method={RequestMethod.GET,RequestMethod.POST})
	public String portfolio() {
		
		viewPage = "02_portfolio";
		
		return viewPage;
	}
	

	


	
}
