<%@page contentType="text/html; charset=utf-8"%>
 <!doctype html>
<html><head>

<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Sub.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Join_1Add.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Join_1.css">
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/Ajax.js"></script>
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/00_Sub.js"></script>

</head>

<body>
        <div id="silde-Key-container">
        	<div class="silde_text">
    	    	<div class="silde_text1">Join
	            </div>
    	    	<div class="silde_text2">Welcome to great experience
	            </div>
    	    	<div class="silde_Line">
	            </div>
            </div>
	    </div>
    
    	<section id="section1-container">
        	<div class="section-Box">
            
	        	<div class="section-Label">
                    <div class="login_text2">어디에도 없는 트라이앵글과 당신의 특별한 관계
                    </div>      
                    
                </div><!-- 추가한거임 -->              
                    
            	<div class="Contact-leftBox">
                    <div class="err-Box err-active">
                    </div>
                	<form method="post" action="joinConfirm.do" name="join">
                    <input type="text" class="login_ join1_id"  style="ime-mode: disabled; " name="id"  required >
                    <h5 class="join_text">아이디 (최대11자) </h5>
                    <input type="password" class="login_ join1_pw" style="ime-mode: disabled;"  name="pw" required>
                    <h5 class="join_text">비밀번호</h5>
                    <input type="password" class="login_ join1_pw2" style="ime-mode: disabled;" name="pw2"  required >
                    <h5 class="join_text">비밀번호 확인</h5>
                    <input type="text" class="login_ join1_name"  name="name" required  >
                    <h5 class="join_text">이름</h5>
                    <input type="email" class="login_ join1_email" style="ime-mode: disabled; " name="tel" required  >
                    <h5 class="join_text">이메일</h5>
                    <div class="CKbox">
	                    <input type="checkbox" value="O"  name="telc" > Angle의 소식을 이메일로 받아보겠습니다.
                    </div>
                    
                    <input  type="button" value="회원가입" class="Contatc_btn1 join_submit"  id="join1_sumbit">
                    <input  type="reset" value="초기화" class="Contatc_btn2" >
                    
                    </form>
                    
                </div>
            </div>
	    </section>
    
</body>
</html>