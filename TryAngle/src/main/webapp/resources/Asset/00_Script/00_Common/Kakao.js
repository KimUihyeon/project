// JavaScript Document
/**
 * 
 */

	function createForm(obj1,obj2,type){
		
		var cFrom = document.createElement('form');
		cFrom.setAttribute("method", "Post"); // Get 또는 Post 입력
		cFrom.setAttribute("action", "SnsLogin.do");
		

		var hiddenField = document.createElement("input");
		hiddenField.setAttribute("type", "hidden");
		hiddenField.setAttribute("name", "id");
		hiddenField.setAttribute("value", obj1);
		cFrom.appendChild(hiddenField);
		 
		hiddenField = document.createElement("input");
		hiddenField.setAttribute("type", "hidden");
		hiddenField.setAttribute("name", "name");
		hiddenField.setAttribute("value", obj2);
		cFrom.appendChild(hiddenField);
		 
		hiddenField = document.createElement("input");
		hiddenField.setAttribute("type", "hidden");
		hiddenField.setAttribute("name", "type");
		hiddenField.setAttribute("value", type);
		cFrom.appendChild(hiddenField);

		document.body.appendChild(cFrom);
		cFrom.submit();
	}

    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('ec3a873f5f3aa96bb23f649df92c22c4');
    
    function loginWithKakao() {
      // 로그인 창을 띄웁니다.
      
      	///https://developers.kakao.com/docs/js-reference#kakao_api_request(settings)
      	//https://developers.kakao.com/docs/restapi/quick-reference
      	
      	
      Kakao.Auth.login({
        success: function(authObj) {
     //     alert(JSON.stringify(authObj));
          var token = JSON.stringify(authObj.access_token);
          loginInfo();
    //      console.log(token);
        //    location.href="KakaoLogin.do?token="+token;
        },
        fail: function(err) {
       //   alert(JSON.stringify(err));
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
              
        //      console.log(sData.kaccount_email);
        //      alert(nickname);
              
              createForm(sData.kaccount_email,nickname,"kakao");
              
            },
            fail : function (err){
          	  console.log(err);
          	  
            }
        });
    }
	