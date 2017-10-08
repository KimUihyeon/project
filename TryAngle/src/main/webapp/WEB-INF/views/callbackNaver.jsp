<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<!-- <script src="resources/Asset/00_Script/00_Common/Naver.js"></script> -->
<script src="resources/Asset/00_Script/00_Common/Ajax.js"></script>


<script>

//로컬용
var naver_id_login = new naver_id_login("Oz2vwz1yBHQizoCWJP7F", "http://localhost:8181/tryAngle/callbackNaver.do");
	
//cafe24 용
//var naver_id_login = new naver_id_login("Oz2vwz1yBHQizoCWJP7F", "http://tryangle1318.cafe24.com/callbackNaver.do");

// 접근 토큰 값 출력
//alert(naver_id_login.oauthParams.access_token);
// 네이버 사용자 프로필 조회


naver_id_login.get_naver_userprofile("naverSignInCallback()");
// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function




function naverSignInCallback() {
	

	var data = new Array(
			naver_id_login.getProfileData('email'),
			naver_id_login.getProfileData('name')
			);
			
	var path = "Naver";
	naverLoginAjax(path,data);
 }
 
/* 
 alert(naver_id_login.getProfileData('email'));
 alert(naver_id_login.getProfileData('nickname'));
 alert(naver_id_login.getProfileData('age')); */

</script>
</head>
<body>
	<form method="post" action="NaverLogin.do" name="formNaver">
		<input type="text" id="id" name="id" hidden="true" value="">
		<input type="text" id="name" name="name" name="name" hidden="true" value="">
		<input type="text" id="type" name="type" hidden="true" value="Naver">
		<div id="naver_id_login">
		</div>
	</form>
</body>
</html>