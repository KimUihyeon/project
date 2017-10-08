<%@page contentType="text/html; charset=utf-8"%>
 <!doctype html>
<html><head>
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Sub.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Mypage.css">
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/00_Sub.js"></script>
</head>
<script>
	function goPage (){
		var type = '${sessionScope.LoginType}';
		
		console.log(type);
		
		if( type == 'nomal'){
			location.href="myModifyAcess.do";
		}else{
			var text = "";
			if(type == 'kakao'){
				text = "카카오 간변 로그인 정보수정은"
					+"카카오톡 홈페이지에서 이용해 주시기 바랍니다.";
			}
			else if ( type == 'naver' ) {
				text = "네이버 간변 로그인 정보수정은"
					+"네이버 홈페이지에서 이용해 주시기 바랍니다.";
			}else{
				text = "잘못된 접근 입니다.";
			}
			alert(text);
		}
		
	}
</script>

<body>
        <div id="silde-Key-container">
        	<div class="silde_text">
    	    	<div class="silde_text1">My Page
	            </div>
    	    	<div class="silde_text2">This is your great experience
	            </div>
    	    	<div class="silde_Line">
	            </div>
            </div>
	    </div>
    
    	<section id="section1-container">
        	<div class="section-Box">
            	<div class="ContactSelect-Box">
                	<div class="contact-item contact-select-bg1">
                    	<div class="contact-transform">
                        	<div class="ContactSelect-text">
								<a class="a_box" onclick="javascript:goPage()">변경하기
								</a>
                            </div>
                            <a class="a_box"  onclick="javascript:goPage()">
                            </a>
                        </div>
                    </div>
                </div>
            	<div class="ContactSelect-Box">
                	<div class="contact-item contact-select-bg2">
                    	<div class="contact-transform">
                        	<div class="ContactSelect-text">
								<a class="a_box" href="myContact.do">확인하기
								</a>
                            </div>
                            <a class="a_box" href="myContact.do">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
	    </section>
</body>
</html>