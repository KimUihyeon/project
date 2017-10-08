package com.spring.tryAngle.Validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spring.tryAngle.DTO.ContactDTO;

/**
 * @author 김의현
 * @since 2017.09.23
 * @category  Contact Class   Validation
 * @version 1.0 TryAngle
 *
 */

public class ContactValidation implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ContactDTO.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors error) {
		// TODO Auto-generated method stub
		
		ContactDTO dto = (ContactDTO) obj;

		int name = dto.getName().length();

		if(name>11 && name<5){
			error.reject("이름은 6자 이상 10자 이하입니다");			
		}

		int tel = dto.getTel().length();

		if(tel>31 && tel<5){
			error.reject("전화번호는 6자 이상 30자 이하입니다");			
		}
		
		int title = dto.getTitle().length();

		if(title>41 && title<5){
			error.reject("타이틀은 5자 이상 40자 이하입니다");			
		}
		
		int context = dto.getContext().length();
		
		if(context>1601 && context<5){
			error.reject("내용은 6자 이상 1500자 이하입니다");			
		}
				
		
		
	}

}
