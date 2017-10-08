<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@  taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="resources/Asset/00_Css/00_Common/Common.css">
<link href="https://fonts.googleapis.com/css?family=Abel" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAJ4tAV_nvlTx6BdiEKAk9sBRAwwaWhTO4"></script>
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/jquery.mousewheel.js"></script>
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/jquery.ba-throttle-debounce.min.js"></script>
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/bitstorm_ColorAnimate.js"></script>
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/circle-progress.js"></script>
<script type="text/javascript" src="resources/Asset/00_Script/00_Common/00_hader.js"></script>



<title><tiles:getAsString name="title"/></title>
</head>
<body>


<div id="wrap">
	<div id="spinWrap">
		<!-- header 영역 -->
		<tiles:insertAttribute name="header"/>
		
	    <!-- 본문영역 -->
		<tiles:insertAttribute name="body"/>
	    
	    <!-- footer 영역 -->
		<tiles:insertAttribute name="footer"/>
    	
    </div>
</div>

<tiles:insertAttribute name="menu"/>
</body>
</html>