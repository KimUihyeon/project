package com.spring.tryAngle.Service;

import java.util.Map;
import java.util.Random;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tryAngle.DAO.MemberDAO;
import com.spring.tryAngle.DTO.MemberDTO;
import com.spring.tryAngle.Util.Construct;
import com.spring.tryAngle.Util.GmailSMTP;

public class FindMailService implements MyService{

	@Override
	public void excute(ModelAndView model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = (Map) model.asMap();
		MemberDTO dto = (MemberDTO) map.get("dto");
		
		/*패스워드 생성하기 */
		String newPassword = "";
		Random rnd = new Random();
		
		for (int i = 0; i < 8 ; i++) {
			int temp = rnd.nextInt(2);
			switch (temp) {
				case 0:{
					newPassword +=String.valueOf((char) ((int) (rnd.nextInt(26)) + 65));
					break;
				}
				case 1:{
					newPassword +=String.valueOf(rnd.nextInt(10));
					break;
				}
				default:{
					newPassword +=String.valueOf(rnd.nextInt(10));
					break;
				}
			}
		}
		
		String SHAPwssword = Construct.getIntence().getPassword(newPassword);
		
		String ID = dto.getId();
		String Email = dto.getTel();
		String Name = dto.getName();
		String[] UrlTemp = dto.getTelc().split("/tryAngle/");
		String Url = UrlTemp[0]+"/tryAngle/"+"login.do";
		
		Construct.getIntence().getSql().getMapper(MemberDAO.class).reversePw(SHAPwssword, ID);;
		

		/* 메일전송 */
		String currentDate = Construct.getIntence().getDate(4);
		String context = dto.getName()+"님 안녕하세요. TryAngle 입니다.\r\n"+
					"------------------------------------------------\r\n"+
					currentDate+"에 요청하신 계정 '"+dto.getId()+"' 의 임시 비밀번호 합니다.\r\n"+
					"     임시 비밀번호 : '  "+newPassword+"   ' \r\n \r\n"+
					Url+" 로 접속해서 비밀번호를 꼭 바꿔 주세요!";
		String Title = "TryAngle Find || "+dto.getName()+"님의 상담 내역입니다.";
		
		

		GmailSMTP mail = new GmailSMTP(Title,context,Email);
		try {
			mail.sendGmail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
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
