<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!doctype html>
<html><head>
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Sub.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/QnA.css">
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/00_Sub.js"></script>

</head>

<body>
		<div id="silde-Key-container">
        	<div class="silde_text">
    	    	<div class="silde_text1">Q&A
	            </div>
    	    	<div class="silde_text2">How to know your experience
	            </div>
    	    	<div class="silde_Line">
	            </div>
            </div>
	    </div>
    
    	<section id="section1-container" style="height: auto;">
        	<div class="section-Box" style="height: auto; padding-bottom:100px;">
            
	        	<div class="section-Label">
                    <div class="login_text2">어디에도 없는 트라이앵글과 당신의 특별한 관계
                    </div>   
                    
                </div><!-- 추가한거임 -->                 

		<!-- While 문 시작 -->
				<c:forEach var="item" items="${qna}">
                    <div class="QnA-Box">
                    	<div class="QnA-Title"><font color="#CC6633">Q :</font> ${item.title} 
    	                    <div class="QnA-Arrow">
	                        </div>
    	                    <div class="QnA-Arrow2">
	                        </div>
                        </div>
                        <div class="QnA-Text acvite_QnA_Text"> ${item.text}
                        </div>
                    </div>
				</c:forEach>
				
				<!-- 
                    <div class="QnA-Box">
                    	<div class="QnA-Title"><font color="#CC6633">Q : </font>제목
    	                    <div class="QnA-Arrow">
	                        </div>
    	                    <div class="QnA-Arrow2">
	                        </div>
                        </div>
                        <div class="QnA-Text acvite_QnA_Text">내용
                        </div>
                    </div> -->
		<!-- While 문 끝 -->
            
                    <div class="btn2 btn_consulting"><!-- 
                    	<a class="a_box" href="Qna_from.do">1:1문의
                        </a> -->
                    	<a class="a_box" onclick="javascript:notDev()">1:1문의
                        </a>
                    </div>
                    <script>
                    	function notDev(){
                    		alert("준비중 입니다");
                    	}
                    </script>
                   
               
                
                
            </div>
	    </section>
</body>
</html>