package com.spring.tryAngle.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tryAngle.DAO.MemberDAO;
import com.spring.tryAngle.DTO.MemberDTO;
import com.spring.tryAngle.Util.Construct;
import com.spring.tryAngle.Util.CurrentSession;

/**
 * 
 * @author 김의현
 * @since 2017.09.27
 * @category Service Class
 * @version 1.0 TryAngle
 *
 */

public class MyInfoUpdateService implements MyService{

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
		
		Map<String, Object> map = (Map) model.asMap();
		
		MemberDTO dto = (MemberDTO) map.get("dto");
		
		CurrentSession cs = (CurrentSession) map.get("str");
		
		String sessionId = cs.getInner();
		
		String inputId = dto.getId().trim();
		
		if( sessionId!=null && inputId!=null ) {
			// sessionId , iunputId 검사
			
			if( sessionId.equals(inputId) ) {
				// sessionId , iunputId 검사
				
				/* 패스워드 가져옴 */
				String inputPw = Construct.getIntence().getPassword(dto.getPw());
				
				// 패스워드가 서로 같다면
					
				/* Telc 값 검증 */
				String Telc = (dto.getTelc()==null) ? "X" : dto.getTelc();
				
				/* Database Update */
				
				MemberDAO dao = Construct.getIntence().getSql().getMapper(MemberDAO.class);
				dao.MemberUpdate(dto.getName(),inputPw,dto.getTel(),Telc,inputId);;
				
				/* 세션 등록 */
				HttpServletRequest request = (HttpServletRequest) map.get("request");
				
				HttpSession session = request.getSession();
				
				session.setAttribute("modifyComplete", dto.getName());

				sw = true;
				
				
			}
			
		}
		
		return sw;
		
	}

}
