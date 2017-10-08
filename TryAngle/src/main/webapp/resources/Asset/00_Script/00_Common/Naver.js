/**
 * 
 */
function ClickTrigger (){
	$('.login_naver a').trigger('click');
}
// 로컬용
var naver_id_login = new naver_id_login("Oz2vwz1yBHQizoCWJP7F", "http://localhost:8181/tryAngle/callbackNaver.do");
	
// cafe24 용
//var naver_id_login = new naver_id_login("Oz2vwz1yBHQizoCWJP7F", "http://tryangle1318.cafe24.com/callbackNaver.do");

var state = naver_id_login.getUniqState();
naver_id_login.setButton("white", 2,40);
naver_id_login.setDomain('http://localhost:8181/tryAngle/login.do');
naver_id_login.setState(state);
naver_id_login.setPopup();
naver_id_login.init_naver_id_login();


function callbackNaver (){
	var naver_id_login = new naver_id_login("Oz2vwz1yBHQizoCWJP7F", "http://localhost:8181/tryAngle/callbackNaver.do");
	// 접근 토큰 값 출력
//	alert(naver_id_login.oauthParams.access_token);
	// 네이버 사용자 프로필 조회
	naver_id_login.get_naver_userprofile("naverSignInCallback()");
	// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
	function naverSignInCallback() {
//	  alert(naver_id_login.getProfileData('email'));
//	  alert(naver_id_login.getProfileData('nickname'));
//	  alert(naver_id_login.getProfileData('age'));
	}
	
/*
	var naverForm = document.formNaver ;

	$('#id').val()==naver_id_login.getProfileData('email');
	$('#name').val()==naver_id_login.getProfileData('nickname');
	*/
}


function create(){
}
