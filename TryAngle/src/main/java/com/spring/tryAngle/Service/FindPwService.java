package com.spring.tryAngle.Service;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tryAngle.DAO.MemberDAO;
import com.spring.tryAngle.DTO.MemberDTO;
import com.spring.tryAngle.Util.Construct;
import com.spring.tryAngle.Util.GmailSMTP;

public class FindPwService implements MyService{

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
		
		Map<String, Object> map= (Map) model.asMap();
		
		MemberDTO dto = (MemberDTO) map.get("dto");
		
		MemberDAO dao = Construct.getIntence().getSql().getMapper(MemberDAO.class);
		
		if(dto.getName()==null || dto.getId()== null || dto.getTel()== null) {
			
			return false;
			
		}
		
		MemberDTO findDTO =  dao.findPw(dto.getId(),dto.getName(),dto.getTel());
		
		if(findDTO == null) {
			
			sw = false;
			
		}
		else{
			
			HttpServletRequest request = (HttpServletRequest) map.get("request");
			
			HttpSession session = (HttpSession) request.getSession();

			session.setAttribute("findName", dto.getName());
			
			//session.setAttribute("findPw", findDTO.getPw());
			
			
			sw = true;
			
		}
		return sw;
	}

}
