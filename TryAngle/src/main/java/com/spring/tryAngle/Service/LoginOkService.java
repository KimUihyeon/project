package com.spring.tryAngle.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tryAngle.DAO.MemberDAO;
import com.spring.tryAngle.DTO.MemberDTO;
import com.spring.tryAngle.Util.Construct;

public class LoginOkService implements MyService{

	@Override
	public void excute(ModelAndView model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExcute(ModelAndView model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExcute(Model model) {
		// TODO Auto-generated method stub
		
		boolean sw = false;
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String id = request.getParameter("id").trim();
		String pw = request.getParameter("pw").trim();
		
		try {

			if(pw!=null) {
				/* pw 암호화 */
				pw = Construct.getIntence().getPassword(pw);
				
			}
			
			MemberDTO dto = Construct.getIntence().getSql().getMapper(MemberDAO.class).LoginOk(id, pw);
			
			if(dto.getId()!=null) {
								
				HttpSession session = request.getSession();
				session.setAttribute("LoginId", dto.getId());
				session.setAttribute("LoginName", dto.getName());
				session.setAttribute("LoginTel", dto.getTel());
				session.setAttribute("LoginType", "nomal");

				sw = true;
			}
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
			sw = false;
			
		}
		
		return sw;
	}

}
