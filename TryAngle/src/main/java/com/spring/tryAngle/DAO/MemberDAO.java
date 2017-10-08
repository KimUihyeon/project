package com.spring.tryAngle.DAO;

import com.spring.tryAngle.DTO.MemberDTO;

public interface MemberDAO {
	

	/* 일반 로그인 */
	/* 일반 로그인 */

	/* Join */
	public MemberDTO JoinConfirm(String id); // 중복검사
	public void JoinInsert(String id, String pw, String name, String tel, String telc); // 회원가입
	

	/* Login */
	public MemberDTO LoginOk(String id, String pw);
	
	
	/*MyPage Select Info*/
	public MemberDTO selectMyInfo(String id);
	
	/*password Select */
	public MemberDTO selectPw(String id);
	
	/*Member Modify Update*/
	public void MemberUpdate(String name,String pw, String tel, String telc, String id); 

	/* Find  ID */
	public MemberDTO findID(String name, String tel);
	/* Find  PW */
	public MemberDTO findPw(String id ,String name, String tel);
	/* 임시 비밀번호 */
	public void reversePw(String pw,String id);
	

	/* 카카오 로그인 */
	/* 카카오 로그인 */

	/* 아이디 중복 유무 */
	public MemberDTO KaKaoSearchId(String id);
	/* 아이디 저장 */
	public void KakaoInsertDB(String id,String name, String email);
	
	
	/* 네이버 로그인 로그인 */
	/* 네이버 로그인 로그인 */
	
	/* 아이디 중복 유무 */
	public MemberDTO NaverSearchId(String id);
	/* 아이디 저장 */
	public void NaverInsertDB(String id,String name, String email);
}
