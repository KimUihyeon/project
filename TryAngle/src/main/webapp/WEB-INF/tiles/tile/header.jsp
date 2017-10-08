<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
		<header id="header-container">
    		<div id="header-Box-Pc">
    	    	<div class="header-Logo-pc">
                	<a class="a_box" href="index.do"></a>
	            </div>
        		<div class="header-menu-pc">
                	<ul class="header-menu-pc-ul">
                	
						<c:if test="${empty sessionScope.LoginId}">
						<!-- 비 로그인시 -->
						
                    	<li class="header-menu-pc-li">
                        </li>
                    	<li class="header-menu-pc-li">
                        	<a class="a_box a_boxLogin" href="login.do">Login
                            </a>
                        </li>
                        
                        </c:if>
                        
                        <c:if test="${not empty sessionScope.LoginId}">
                                                
                    	<li class="header-menu-pc-li header-menu-pc-li-idBox">
                        	<a class="a_box" href="logout.do">로그아웃
                            </a>
                        </li>
                    	<li class="header-menu-pc-li logOut">
                        	<a class="a_box a_boxLogin" href="myPage.do">${sessionScope.LoginName}
                            </a>
                        </li>
                        
                         </c:if>
                        <!-- 엘스 문 끝 -->
                        

                    	<li class="header-menu-pc-li">
                        	<span class="header-menu-logo"> 
                            </span>
                        	<span class="header-text">메뉴
                            </span>
                        </li>
                    </ul>
        	    </div>
    	    </div>
	    	<div id="header-Box-Mobile">
	        	<div class="header-Logo-Mobile header-Logo-pc">
                	<a class="a_box" href="index.do"></a>
    	        </div>
        		<div class="header-menu-Mobile header-menu-pc">
                	<ul class="header-menu-pc-ul">

						<!-- 비 로그인시 -->
                    	<li class="header-menu-pc-li">
                        </li>
                    	<li class="header-menu-pc-li">
                        	<a class="a_box a_boxLogin" href="login.do">Login
                            </a>
                        </li>

                        <!-- 이프문 끝  엘스 시작  // 로그인시-->
                        <!-- 
                    	<li class="header-menu-pc-li header-menu-pc-li-idBox">
                        </li>
                    	<li class="header-menu-pc-li logOut" >
                        	<a class="a_box a_boxLogin" href="09_Mypage.jsp">My page
                            </a>
                        </li>
                         -->
                        <!-- 엘스 문 끝 -->
                        
                    	<li class="header-menu-pc-li">
                        	<span class="header-menu-logo"> 
                            </span>
                        	<span class="header-text" id="mobile-menu-btn">매뉴
                            </span>
                        </li>
                    </ul>
        	    </div>
    	    </div>
	    </header>

</body>
</html>