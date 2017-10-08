package com.spring.tryAngle.Util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author 김의현
 * @since 2017.09.27
 * @category Util Class 
 * @version 1.0 Try Angle
 *
 */
public class CurrentSession {
	
	/**
	 * 현재 세션이 존재 하는지 안하느지 감사한다.
	 */
	private HttpSession session;
	private String sessionAttribureName;
	private String str;
	
	public CurrentSession(String sessionAttribureName) {
		this.sessionAttribureName=sessionAttribureName;
	}
	
	public boolean acess(HttpSession session) {
		this.session = session;
		this.str = (String) this.session.getAttribute(sessionAttribureName);
		return (str==null || str.equals("") ) ? false : true;
	}
	
	public String getInner() {
		return this.str; 
	}
	

}
