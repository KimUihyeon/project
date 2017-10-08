<%@page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <!doctype html>
<html><head>
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Sub.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Contact_1.css">
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
            	<div class="Contact-leftBox">의뢰 필수 사항
            	
                	<form method="post" action="contactConfirm.do">
                	
                    <input type="text" class="login_ contact_input_name" placeholder="Your Name *" name="name" value="${sessionScope.LoginName}">
                    <input type="email" class="login_ contact_input_mail" placeholder="Your Email *"  name="tel" value="${sessionScope.LoginTel}">
                    
                    <input type="text" class="login_ contact_input_title" placeholder="Subject *" name="title">
                    <h4 class="Contact-YourMessage">Your Message</h4>
                    <textarea class="textarea-Contact contact_input_text" name="context"></textarea>
                    
                	
                    <input  type="submit" value="보내기" class="Contatc_btn1  contact_submit" >
                    <input  type="reset" value="초기화" class="Contatc_btn2" >
					</form>
										                    
                    
                </div>
            	<div class="Contact-rightBox">
                	<div class="Contact-textBox">
                    	<div class="contact-textBg">
                        </div>
                    </div>
                </div>
            </div>
	    </section>
    
</body>
</html>