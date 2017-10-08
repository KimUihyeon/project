package com.spring.tryAngle.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tryAngle.DAO.FaqDAO;
import com.spring.tryAngle.DTO.ContactDTO;
import com.spring.tryAngle.Util.Construct;
import com.spring.tryAngle.Util.GmailSMTP;

public class FaqInsertService implements MyService{

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

		
		try {
			

			/* 디비 등록 */
			ContactDTO dto = (ContactDTO) map.get("model");
			
			FaqDAO dao= Construct.getIntence().getSql().getMapper(FaqDAO.class);

			String id = (dto.getId()==null || dto.getId().equals("")) ? "비회원" : dto.getId().trim();
			
			String crrentDate = Construct.getIntence().getDate(2);
			
			dao.insertFaq(id, dto.getName(), dto.getTel(), dto.getTitle(), dto.getContext(), crrentDate);
			

			/* 세션에 이름 저장 */
			HttpServletRequest request = (HttpServletRequest) map.get("request");
			
			HttpSession session = request.getSession();
			
			session.setAttribute("faqContactName", dto.getName());
			
			
			/* 메일전송 */
			String currentDate = Construct.getIntence().getDate(4);
			String context = dto.getName()+"님 안녕하세요. TryAngle 입니다.\r\n"+
						"------------------------------------------------\r\n"+
						currentDate+"에 요청하신 1:1 의뢰 ' "+dto.getTitle()+" ' 이 정상 접수 되었습니다. \r\n \r\n "+
						"* 상담 내역 * \r\n" +dto.getContext() +"\r\n\r\n"+
						"답변까지 최대 3일이 소요 될 수 있습니다.";
			String Title = "TryAngle Contact || "+dto.getName()+"님의 상담 내역입니다.";
			

			GmailSMTP mail = new GmailSMTP(Title,context,dto.getTel());
			mail.sendGmail();
			
			GmailSMTP MyMail = new GmailSMTP(Title,context,"dkrnl1318@naver.com");
			MyMail.sendGmail();
			
			
			sw = true;
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			sw = false;
		}
		
		return sw;
	}

}
