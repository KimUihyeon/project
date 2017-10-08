package com.spring.tryAngle.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tryAngle.DAO.MemberDAO;
import com.spring.tryAngle.DTO.MemberDTO;
import com.spring.tryAngle.Util.Construct;

/**
 * 
 * @author 김의현
 * @since 2017.09.23
 * @category Join Service
 * @version 1.0 TryAngle
 * Join1, Join2 사이에 아이디 중복검사 Service
 */
public class JoinComfirmService implements MyService{

	@Override
	public void excute(ModelAndView model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExcute(ModelAndView model) {
		// TODO Auto-generated method stub
		boolean sw = false;
		
		Map<String , Object> map = (Map) model.getModel();

		MemberDTO dto = (MemberDTO)map.get("member");
		String id = dto.getId().trim();
		
		MemberDAO dao = Construct.getIntence().getSql().getMapper(MemberDAO.class);
		try {
			

			if(dao.JoinConfirm(id)==null) {
				// 중복검사 통과
				model.addObject("join", dto);
				sw = true;
				
			}			
			else {
				// 아이디 중복
				sw = false;
				
			}
			
			
		}catch(Exception e) {
			//DB 연동 실패
			System.out.println(e.getMessage());
			
		}
		
		return sw;
	}

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExcute(Model model) {
		// TODO Auto-generated method stub
		return false;
	}

}
