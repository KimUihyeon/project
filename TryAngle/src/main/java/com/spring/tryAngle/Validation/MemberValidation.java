package com.spring.tryAngle.Validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.tryAngle.DTO.MemberDTO;

public class MemberValidation implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return MemberDTO.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors error) {
		// TODO Auto-generated method stub
		
		MemberDTO dto =(MemberDTO) arg0;
		
		int id_leng = dto.getId().length();

		if(id_leng>11 && id_leng<5){
			error.reject("아이디는 6자 이상 10자 이하입니다");			
		}
		
		int pw_leng = dto.getPw().length();

		if(pw_leng>11 && pw_leng<5){
			error.reject("패스워드는 6자 이상 10자 이하입니다");			
		}
		
		int name_leng = dto.getName().length();

		if(name_leng>11 && name_leng<5){
			error.reject("이름은 6자 이상 10자 이하입니다");			
		}

		int tel_leng = dto.getTel().length();

		if(tel_leng>11 && tel_leng<5){
			error.reject("전화번호는 6자 이상 10자 이하입니다");			
		}

		
	}

}
