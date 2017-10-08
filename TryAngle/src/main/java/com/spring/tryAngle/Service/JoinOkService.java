package com.spring.tryAngle.Service;

import java.util.Map;

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
 * Join2 - Complete 사이에 디비 등록
 */

public class JoinOkService implements MyService{

	@Override
	public void excute(ModelAndView model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExcute(ModelAndView model) {
		// TODO Auto-generated method stub
		
		boolean sw = false;
		
		try {

			/* 맵퍼 생성 */
			Map<String, Object> map = (Map) model.getModel();
			MemberDTO dto = (MemberDTO) map.get("member");

			/* 데이터 가공 */
			String tel_CHK = dto.getTelc();
			String pw_security= Construct.getIntence().getPassword(dto.getPw().trim());
			
			if(tel_CHK==null) {
				
				tel_CHK="X";
				
			}			
			
			/* 맵퍼 생성 */
			MemberDAO dao = Construct.getIntence().getSql().getMapper(MemberDAO.class);			
			dao.JoinInsert(dto.getId(), pw_security, dto.getName(), dto.getTel(), tel_CHK);

			sw = true;
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			sw = false;
			
		}finally {
			
			
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
