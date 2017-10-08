<%@page contentType="text/html; charset=utf-8"%>

 <!doctype html>
<html><head>

<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Sub.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Find.css">
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/Ajax.js?ver=16"></script>
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/00_Sub.js"></script>


</head>

<body>
        <div id="silde-Key-container">
        	<div class="silde_text">
    	    	<div class="silde_text1">FIND UP
	            </div>
    	    	<div class="silde_text2">Find your great experience
	            </div>
    	    	<div class="silde_Line">
	            </div>
            </div>
	    </div>
    
    	<section id="section1-container">
        	<div class="section-Box">
            
	        	<div class="section-Label">
                <form method="post" action="findId.do" name="findId">
                	<h5 class="Finde_text1">아이디 찾기</h5>
                	<input type="text" name="name" class="login_ find_id_name" placeholder="이름">
               		<input type="text" name="tel" class="login_ find_id_mail" placeholder="이메일">
                    <input type="button" value="아이디 찾기"  class="login_btn find_id_submit">
                </form>
                <div class="space">
                </div>
                
                <form method="post" action="findPw.do" name="findPw">
                	<h5 class="Finde_text1">비밀번호 찾기</h5>
                	<input type="text" name="mane" class="login_ find_pw_name" placeholder="이름">
               		<input type="text" name="id" class="login_ find_pw_id" placeholder="아이디">
               		<input type="email" name="tel" class="login_ find_pw_mail" placeholder="이메일">
                    <input type="button" value="비밀번호 찾기"  class="login_btn find_pw_submit">
                </form>
                
    	        </div>
                
                
        	    <div class="section-Box">
				</div>        
                
               
                
                
            </div>
	    </section>
    
</body>
</html>