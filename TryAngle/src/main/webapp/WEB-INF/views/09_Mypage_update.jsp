<%@page contentType="text/html; charset=utf-8"%>
 <!doctype html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><head>
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Sub.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Join_1Add.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Join_1.css">
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/00_Sub.js"></script>

<script>
</script>
</head>

<body>
    
    	<div id="silde-Key-container">
        	<div class="silde_text">
    	    	<div class="silde_text1">Update info
	            </div>
    	    	<div class="silde_text2">Member Page
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
                </div>                   
                    
            	<div class="Contact-leftBox">
                    <div class="err-Box err-active">
                    </div>
                	<form method="post" action="myModifyUpdate.do">
                    <input type="text" class="login_ join1_id"   style="ime-mode: disabled; "  required  readonly value="${info.id}" name="id" >
                    <h5 class="join_text">아이디 (수정불가) </h5>
                    <input type="password" class="login_ join1_pw"   style="ime-mode: disabled; " required name="pw">
                    <h5 class="join_text">새 비밀번호</h5>
                    <input type="password" class="login_ join1_pw2"  style="ime-mode: disabled; " required name="update_pw2">
                    <h5 class="join_text">새 비밀번호 확인</h5>
                    <input type="text" class="login_ join1_name"  required   value="${info.name}" name="name">
                    <h5 class="join_text">이름</h5>
                    <input type="email" class="login_ join1_email"   style="ime-mode: disabled;" required  value="${info.tel}" name="tel">
                    <h5 class="join_text">이메일</h5>
                    
                    <div class="CKbox">
                    	<c:if test="${info.telc eq 'X'}">
	                    <input type="checkbox" value="O" name="telc"> Angle의 소식을 이메일로 받아보겠습니다.
	                    </c:if>

                    	<c:if test="${info.telc eq 'O'}">
	                    <input type="checkbox" value="O" name="telc" checked="checked"> Angle의 소식을 이메일로 받아보겠습니다.                    	
                    	</c:if>
                    </div>
                    
                    <input  type="submit" value="수정하기" class="Contatc_btn1 join_submit" >
                    <input  type="reset" value="돌아가기" class="Contatc_btn2" onClick="onPrev()">
                    
                    </form>
                    
                </div>
            </div>
	    </section>
</body>
</html>