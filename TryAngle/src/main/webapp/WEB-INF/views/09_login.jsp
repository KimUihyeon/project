<%@page contentType="text/html; charset=utf-8"%>
 <!doctype html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <html>
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Sub.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Login.css?ver=13">
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/Ajax.js"></script>
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/00_Sub.js?ver=19"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
</head>

<body>

        <div id="silde-Key-container">
        	<div class="silde_text">
    	    	<div class="silde_text1">LOGIN
	            </div>
    	    	<div class="silde_text2">Enjoy your great experience
	            </div>
    	    	<div class="silde_Line">
	            </div>
            </div>
	    </div>
    
    	<section id="section1-container">
        	<div class="section-Box">
            
	        	<div class="section-Label">
	                <form method="post" action="loginOk.do">
	                	<input type="text" name="id" class="login_ login_input_id" id="idBtn" placeholder="아이디" style="ime-mode: disabled; autocomplete=off;">
	                	
	               		<input type="password" name="pw" class="login_ login_input_pw" id="pwBtn" placeholder="비밀번호"  style="ime-mode: disabled; autocomplete=off">
	                    <input type="button" value="로그인" id="loginSubmit" class="login_btn login_btn_submit">
	                    <div type="Button" value="카카오"  class="login_btn login_kakao" id="kakao-login-btn" onclick="javascript:loginWithKakao()">
	                    	<div>
	                    	</div>
	                    </div>
	                    <div type="Button" value="네이버"  class="login_btn login_naver"  onClick="javascript:ClickTrigger()">
	                    	<div id="naver_id_login">
	                    	</div>
	                    </div>
	                </form>
	                
	                <div class="login_text_Box"><a href="find.do">아이디찾기</a> || <a href="find.do">비밀번호찾기</a> || <a href="join.do">회원가입</a>
	                </div>
    	        </div>
                
                
        	    <div class="section-Box">
				</div>        
                
               
                
                
            </div>
	    </section>
	    
	    
	    <!-- 
<script type='text/javascript'>
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('ec3a873f5f3aa96bb23f649df92c22c4');
    
    function loginWithKakao() {
      // 로그인 창을 띄웁니다.
      
      	///https://developers.kakao.com/docs/js-reference#kakao_api_request(settings)
      	//https://developers.kakao.com/docs/restapi/quick-reference
      	
      	
      Kakao.Auth.login({
        success: function(authObj) {
          alert(JSON.stringify(authObj));
          var token = JSON.stringify(authObj.access_token);
          loginInfo();
          console.log(token);
          //location.href="KakaoLogin.do?token="+token;
        },
        fail: function(err) {
          alert(JSON.stringify(err));
        }
      }); 
      	
      
    };
    
    function loginInfo(){
        Kakao.API.request({
            url: '/v1/user/me',
            success: function(res) {
              var sData = JSON.stringify(res);
              //alert(sData);
              
              sData = JSON.parse(sData);
              var route = "kakao"
              var id = sData.id+"@"+route;             
              var nickname = sData.properties.nickname;
              var thumbnail_image = sData.properties.thumbnail_image;
              var profile_image = sData.properties.profile_image;
              
              console.log(sData.kaccount_email);
              alert(nickname);
              
            },
            fail : function (err){
          	  console.log(err);
          	  
            }
            });
    }
</script> -->
<script src="resources/Asset/00_Script/00_Common/Kakao.js"></script>
<script src="resources/Asset/00_Script/00_Common/Naver.js"></script>
</body>
</html>