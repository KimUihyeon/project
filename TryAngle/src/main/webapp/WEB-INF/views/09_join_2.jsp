<%@page contentType="text/html; charset=utf-8"%>
 <!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><head>
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Sub.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Join_1Add.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Join_1.css">
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
                
            	<div class="Contact-leftBox">회원가입 기본정보
                    <div class="err-Box err-active">
                    </div>
                	<form method="post" action="joinOk.do">
                    <input type="text" class="login_ join1_id"  style="ime-mode:inactive"  required readonly value="${join.id}" name="id">
                    <h5 class="join_text">아이디 (최대10자) </h5>
                    <input type="password" class="login_ join1_pw"  style="ime-mode:inactive" required readonly  value="${join.pw}" name="pw">
                    <h5 class="join_text">비밀번호</h5>
                    <input type="password" class="login_ join1_pw2" style="ime-mode:inactive"  required readonly  value="${join.pw}" name="pw2">
                    <h5 class="join_text">비밀번호 확인</h5>
                    <input type="text" class="login_ join1_name" value="${join.name}"required name="name" readonly>
                    <h5 class="join_text">이름</h5>
                    <input type="text" class="login_ join1_email" style="ime-mode:inactive" required readonly  value="${join.tel}" name="tel">
                    <h5 class="join_text"></h5>
                    <div class="CKbox"  style="color:#F00"> 회원정보 확인 페이지입니다 입력하신 정보가 위와 같습니까 ?
                    </div>
                    
                    
                    <c:if test="${not empty join.telc}">
                    <input type="checkbox" class="login_ join1_email" style="ime-mode:inactive" required readonly  value="${join.telc}" name="telc" hidden="true" checked="checked">
                    </c:if>
                    
                    <input  type="submit" value="확인" class="Contatc_btn1 join_submit" >
                    <input  type="reset" value="처음으로" class="Contatc_btn2" onClick="onPrev()">
                    
                    </form>
                    
                </div>
            </div>
	    </section>
    
</body>
</html>