package com.spring.tryAngle.Service;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tryAngle.DAO.MemberDAO;
import com.spring.tryAngle.DTO.MemberDTO;
import com.spring.tryAngle.Util.Construct;

public class SNSLoginService implements MyService{

	MemberDTO dto;
	
	@Override
	public void excute(ModelAndView model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = (Map) model.asMap();

		String id = (String) map.get("id");
		String name = (String) map.get("name");
		String type = (String) map.get("type");
		String email = id;

		MemberDAO dao = Construct.getIntence().getSql().getMapper(MemberDAO.class);
		
		if(type.equals("kakao")) {
			dto = dao.KaKaoSearchId(id);
			if(dto==null) {
				// 카카오 회원정보 존재 하지 않음
				dao.KakaoInsertDB(id, name, email);
				
			}
			else {
				// 카카오 회원정보 존재함
				
			}
			
		}
		else if (type.equals("naver")) {

			dto = dao.NaverSearchId(id);
			if(dto==null) {
				// 카카오 회원정보 존재 하지 않음
				dao.NaverInsertDB(id, name, email);
				
			}
			else {
				// 카카오 회원정보 존재함
				
			}
			// 네이버 
			
		}

		// 세션 등록
		HttpServletRequest request =  (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		session.setAttribute("LoginId", id);
		session.setAttribute("LoginName", name);
		session.setAttribute("LoginTel", email);
		session.setAttribute("LoginType", type);
	}

	@Override
	public boolean isExcute(ModelAndView model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExcute(Model model) {
		// TODO Auto-generated method stub
		return false;
	}

}
