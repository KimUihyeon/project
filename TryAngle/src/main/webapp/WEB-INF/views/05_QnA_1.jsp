<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <!doctype html>
<html><head>
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Sub.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/QnA_2Add.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/QnA_2.css">
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/00_Sub.js"></script>
</head>

<body>
		<div id="silde-Key-container">
        	<div class="silde_text">
    	    	<div class="silde_text1">1:1 Consulting
	            </div>
    	    	<div class="silde_text2">How to know your experience
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
                    
            	<div class="Contact-leftBox">의뢰 필수 사항
                	<form method="post" action="QnaInsert.do">

                    <input type="text" class="login_ QnA_input_name" placeholder="이름 (name)" name="name" value="${sessionScope.LoginName}" >
                    <input type="email" class="login_ QnA_input_phone" placeholder="연락처 (Email)" name="tel" value="${sessionScope.LoginTel}" >
                    <input type="text" class="login_ QnA_input_title" placeholder="제목 (title)" name="title" >
                    <h4 class="Contact-YourMessage">질문 내용</h4>
                    <textarea class="textarea-Contact QnA_input_text" name="context" ></textarea>
                    
                    <input type="text" hidden="true" name="id" value="${sessionScope.LoginId}" checked="checked">
                    <input  type="submit" value="질문전송" class="Contatc_btn1 QnA_input_submit" >
                    
                    </form>
                    
                </div>
            </div>
	    </section>
    
</body>
</html>