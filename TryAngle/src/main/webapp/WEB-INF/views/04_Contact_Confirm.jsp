<%@page contentType="text/html; charset=utf-8"%>
 <!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><head>
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Sub.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Contact_1_2.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Contact_1_2Add.css">

<script type="text/javascript" src="resources/Asset/00_Script/00_Common/00_Sub.js"></script>
</head>

<body>
		<div id="silde-Key-container">
        	<div class="silde_text">
    	    	<div class="silde_text1">Contact Us
	            </div>
    	    	<div class="silde_text2">Great experiences build great brands
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
                    
            	<div class="Contact-leftBox">의뢰 필수 사항
            		
					<form method="post" action="contactInsert.do">
                    <input type="text" class="login_" placeholder="Your Name *" readonly name="name"  value="${cv.name}">
                    <input type="email" class="login_" placeholder="Your Email *" readonly  name="tel" value="${cv.tel}">
                    <input type="text" class="login_" placeholder="Subject *" readonly  name="title" value="${cv.title}">
                    <h4 class="Contact-YourMessage">Your Message</h4>
                    <textarea class="textarea-Contact" style="white-space:pre-wrap;" readonly  name="context">${cv.context}</textarea>
                	<c:if test="${not empty sessionScope.LoginName}">  
                	<input type="text" hidden="true" value="${sessionScope.LoginId}" name="id" checked="checked">
                	<input type="text" hidden="true" value="${sessionScope.LoginType}" name="type" checked="checked">
					</c:if>                
                    <input  type="submit" value="확인" class="Contatc_btn1" >
                    
                    </form>
                    
                </div>
            	<div class="Contact-rightBox">
                	<div class="Contact-textBox">            
    	            	<div class="Contact-text">트라이앵글은<br>
입력된 의뢰정보에 따라서 당신에게 연락합니다<br>
정확한 정보를 입력하셨는지 다시 한번<br>
확인해주세요<br>
정보가 맞지 않으시다면 이전 버튼을 클릭해 주시기 바랍니다.
	                    </div>
                    </div>
                </div>
                    <div class="area_space">
                    </div>
    	        </div>
            </div>
	    </section>
</body>
</html>