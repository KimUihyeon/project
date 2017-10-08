package com.spring.tryAngle.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tryAngle.DAO.MemberDAO;
import com.spring.tryAngle.DTO.MemberDTO;
import com.spring.tryAngle.Util.Construct;

public class FindIdService implements MyService {
	
	String searchId;

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
		
		if(dto.getName()==null || dto.getTel()== null) {
			
			return false;
			
		}
		
		MemberDTO findDTO =  dao.findID(dto.getName(),dto.getTel());
		
		if(findDTO == null) {
			
			sw = false;
			
		}
		else{
			
			HttpServletRequest request = (HttpServletRequest) map.get("request");
			
			HttpSession session = (HttpSession) request.getSession();
			
			session.setAttribute("findId", findDTO.getId());
			
			session.setAttribute("findName", dto.getName());
			
			this.searchId = findDTO.getName();
			
			sw = true;
			
		}
		return sw;
	}
	
	public String getSearchId() {
		return searchId;
	}

}
