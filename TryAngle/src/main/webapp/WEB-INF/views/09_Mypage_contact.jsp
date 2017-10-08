<%@page contentType="text/html; charset=utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!doctype html>
<html><head>
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Sub.css">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/QnA.css">
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/00_Sub.js"></script>

<title>TryAngle::</title>
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
    
    	<section id="section1-container" style="height:auto !important">
        	<div class="section-Box"  style="height:auto !important">
            
	        	<div class="section-Label">
                    <div class="login_text2">의뢰내역 보기
                    </div>                    
                    
                    <div class="QnA-Box">
                    	<!-- 의뢰 없음 -->
                        <c:if test="${empty list}">
                        
                    	<div class="QnA-Title">
                        	<a class="a_box">등록된 의뢰내역이 없습니다.
                            </a>
                        </div>
                        
                        </c:if>
                        <!--의뢰있음-->
                        <c:if test="${not empty list}">
                        	<c:forEach var="item" items="${list}">
                        	
                    	<div class="QnA-Title">
                        	<a class="a_box" href="myContactDetail.do?t=${item.no}">
                        		<span class="span">의뢰 명 : ${item.title}<span>
                                <span  class="span2">접수일 : ${item.date}</span>
                            </a>
                        </div>
                        
                        	</c:forEach>
                        </c:if>
                        
                    </div>
                    <div class="area_space">
                    </div>
    	        </div>
                
               
                
                
            </div>
	    </section>
        
</body>
</html>