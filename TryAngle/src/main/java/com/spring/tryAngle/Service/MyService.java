package com.spring.tryAngle.Service;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author 김의현
 * @category Service Interface
 * @since 2017.09.22
 * @version 1.0 TryAngle
 * 
 */
public interface MyService {

	public void excute(ModelAndView model);
	public void excute(Model model);
	
	public boolean isExcute(ModelAndView model);
	public boolean isExcute(Model model);
	
}
