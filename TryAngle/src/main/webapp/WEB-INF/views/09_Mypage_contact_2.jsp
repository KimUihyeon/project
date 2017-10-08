<%@page contentType="text/html; charset=utf-8"%>
 <!doctype html>
<html><head>
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Sub.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Contact_1.css">
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/00_Sub.js"></script>
</head>

<body>
    	<div id="silde-Key-container">
        	<div class="silde_text">
    	    	<div class="silde_text1">Request History
	            </div>
    	    	<div class="silde_text2">Show your great experience.
	            </div>
    	    	<div class="silde_Line">
	            </div>
            </div>
	    </div>
    
    	<section id="section1-container">
        	<div class="section-Box">
            	<div class="Contact-leftBox">의뢰 내역 확인
            	
                	<form method="post" action="04_Contact_1_2.html">
                    <input type="text" class="login_ contact_input_name" placeholder="Your Name *"  readonly value="접수자 : ${detail.name}">
                    <input type="text" class="login_ contact_input_mail" placeholder="Your Email *"  readonly value="이메일 : ${detail.tel}">
                    <input type="text" class="login_ contact_input_title" placeholder="Date *" readonly value="접수일 : ${detail.date}">
                    <input type="text" class="login_ contact_input_title" placeholder="Subject *" readonly value="${detail.title}">
                    <h4 class="Contact-YourMessage">Your Message</h4>
                    <textarea class="textarea-Contact contact_input_text" readonly>${detail.context}</textarea>
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