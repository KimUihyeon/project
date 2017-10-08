package com.spring.tryAngle.Util;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author 김의현
 * @category Util 파일
 * @since 2017.09.22 
 * @version 1.0 tryAngle
 *
 */

public class Construct {
	
	/**/
	SqlSession sqlSession;
	
	public void setSql(SqlSession sqlSession) {
		
		this.sqlSession =sqlSession;
		
	}
	
	public SqlSession getSql() {
		
		return sqlSession;
		
	}
	
	/* 싱글턴 패턴 */
	private static Construct intence = new Construct();
	
	public static Construct getIntence() {
		
		return intence;
		
	};
	
	
	/* @name 패스워드 암호화 (SHA-256) */
	public String getPassword(String pw) {
		
		String Pw="";
		
		try {
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(pw.getBytes());
			byte byteData[] = md.digest();

			StringBuffer sb = new StringBuffer(); // 스트링버퍼가 스프링보다 문자를 붙일때 더 빠름			
			
			for(int i=0; i<byteData.length; i++) {
				
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));		
				
			}
			
			pw=sb.toString();
			 
		}catch(Exception e) {
			
			pw="PwError";
			
		}
		
		return pw;
	}
	
	
	public String getDate(int yearCount) {
		
		/*Date 함수 호출*/
		Date date = new Date();	
		
		String yearFormat = ( yearCount==4 ) ? "yyyy.MM.dd HH:mm:ss" : "yy.MM.dd HH:mm:ss";
				
		SimpleDateFormat format = new SimpleDateFormat(yearFormat);
		
		return format.format(date);
	}
}
