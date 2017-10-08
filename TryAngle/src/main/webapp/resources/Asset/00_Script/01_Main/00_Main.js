// JavaScript Document
$(function(){
	
	
	//파티클 시스템
	var $particleBox = $('.particle-box');
	var $particleItem = "<div class=\"particle-item\"></div>";
	var particleStop = true,
		particleNumber = 0;
	while(particleStop){
		$particleBox.append($particleItem);
		particleNumber++
		if(particleNumber==14){
			particleStop=false;
		}
	}
	
	function RoopAnimate(target){
		
		var random_X = Math.random()*100;
		var random_Y = Math.random()*100;
		var random_StopX = Math.random()*100;
		var random_StopY = Math.random()*100;
		var random_Rotate = 50+Math.random()*311;
		var random_Arrow = parseInt(1+Math.random()*2) ;
		var speed = 7000;
		
		var $target = target;
		$target.animate({left:random_X+"%",top:random_Y+"%"},speed).animate({left:random_StopX+"%",top:random_StopY+"%"},speed,function(){RoopAnimate($target)});
		if(random_Arrow==1){
			Arrow = -720;
		}
		else if(random_Arrow==2){
			Arrow = 720;
		}
	}
	
	var particleStock=  $('.particle-item').length;
	$('.particle-item').each(function(index, element) {
        var particle_index = index;
		var random_X = Math.random()*100;
		var random_Y = Math.random()*100;
		var random_StopX = Math.random()*100;
		var random_StopY = Math.random()*100;
		var random_Rotate = 50+Math.random()*311;
		$(this).css({
			left:random_X+"%",
			top:random_Y+"%"});
		$(this).rotate(random_Rotate);	
		RoopAnimate($(this));
		
    });
	
	//임시 슬라이드
	
	var kkk= 0 ;
	$('.header-Logo-pc').on('click',function(){
		Silde_Timer();
	});
	
		Silde_Timer();
	function Silde_Timer(){
		var $Silde_item = $('.silde-item');
		var Silde_Length = $Silde_item.length;
		var Silde_speed = 4000;
		var $Script_Target = $Silde_item.find('> .silde-item-inner-1, .silde-item-inner-2');
		var Index_Number = Silde_Length -1 
		
		Start_Timer = setInterval(function(){
				$Silde_item.eq(Index_Number).find('> .silde-item-inner-1, .silde-item-inner-2').addClass('rotateSilde');
			
				$('.silde-Text').eq(3).addClass('hide-Text');
				$('.silde-Text').eq(Index_Number).addClass('hide-Text');
				$('.silde-Text').eq(Index_Number-1).addClass('active-Text');
			if(Index_Number==0){
				$Script_Target.removeClass('rotateSilde');
				$('.silde-Text').removeClass('hide-Text');
				$('.silde-Text').removeClass('active-Text');
				Index_Number=Silde_Length;
			}
			
			Index_Number--;
		},Silde_speed);
	}
	
	
	
	
	$('.about-item-Box').on('mouseenter',function(){
		$(this).find('> .about-item').addClass('scaleAbout');
	});
	
	$('.about-item-Box').on('mouseleave',function(){
		$(this).find('> .about-item').removeClass('scaleAbout');
	});
	
	
	// 마우스휠 어바웃
	
	
	
	function countDown(targetObject  , num ,speed,speed2,seleect){
		var $target = $(targetObject);
		var numbering = 0 ;
		
		$target.find('> .countDown-Line .countDown-current').animate({width:100+"%"},speed2);
		
		countNum = setInterval(function(){
		switch(seleect){
			case 1:
				str = "누적 회원수 ";
				lastStr= "명";
			break;
			case 2:
				str = "의뢰 건수 ";
				lastStr= "건";
			break;
			case 3:
				str = "라이브러리 ";
				lastStr= "개";
			break;
		}
		
			if(numbering==num){
				clearInterval(countNum);
			}
			else{
				$target.find('> .countDown-Text').html(str+numbering+" "+lastStr);
				numbering++;
			}
		},speed);
	}
	
	var SwitchButton = true;
	var SwitchProgress = true;
	$('body,html').on('mousewheel',function(e){
		var $crrentHTML = $(this).scrollTop();
		$('.about-item-Box').each(function(index, element) {
            if($crrentHTML + 1000 > $(this).offset().top){
				var speed = 300;
				var numbering = index ;
				$(this).find('> .about-item').delay(numbering*200).animate({top:0 , opacity:1},speed);
				$(this).find('> .about-text').delay(numbering*300 + speed).animate({opacity:1},speed);
				
			}
			
			
        });
		$('.countDown-item').each(function(index, element) {
            if($crrentHTML +500 > $(this).offset().top){
				if(SwitchButton){
					countDown(".countDown-item:nth-child(1)" , 817 , 5 ,4085,1);
					countDown(".countDown-item:nth-child(2)" , 348 , 12 ,4176,2);
					countDown(".countDown-item:nth-child(3)" , 128 , 30 ,3840,3);
					SwitchButton=false;
				}
			}
            
        });
		
		if($crrentHTML > 1300){
			$('.section5-item').removeClass('section-removeClass1');
			$('.section5-item').removeClass('section-removeClass2');
			$('.section5-item').removeClass('section-removeClass3');
		}
		
		if($crrentHTML > 2500){
			if(SwitchProgress)
			{
				progressStart();
				$('.progressbarText').animate({opacity:1},2000);
				$('.progressbarBottom').animate({opacity:1},2000);
				SwitchProgress=false;
			}
		}
	});
	
	
	function progressStart(){
	  $('.pro1').circleProgress({
    	value: 0.90,
	    size: 100,
    	fill: {
	      gradient: ["#fa480b", "#c69871"]
    	}
	  });
	  $('.pro2').delay(300).circleProgress({
    	value: 0.85,
	    size: 100,
    	fill: {
	      gradient: ["#fa480b", "#c69871"]
    	}
	  });
	  $('.pro3').delay(6000).circleProgress({
	    value: 0.75,
    	size: 100,
	    fill: {
    	  gradient: ["#fa480b", "#c69871"]
	    }
	  });
	  $('.pro4').delay(900).circleProgress({
    	value: 0.66,
	    size: 100,
    	fill: {
	      gradient: ["#fa480b", "#c69871"]
    	}
	  });
	}
	
	///
	/// 프로그래스바
	///
	
	
	//
	//포폴 
	//
	$('.portfolio_line_li').each(function(index, element) {
        $(this).on('mouseenter',function(){
			$(this).addClass('active_pofol');		
			$(this).find(' > .portfolio_Inner').addClass('active_pofolInner');	
			$(this).find('  .portfolio_Inner_Logo').animate({top:15+"%"},200);
			$(this).find(' .portfolio_cook').animate({right:0+"%"},200);
		});
        $(this).on('mouseleave',function(){
			$(this).removeClass('active_pofol');			
			$(this).find(' > .portfolio_Inner').removeClass('active_pofolInner');
			$(this).find('  .portfolio_Inner_Logo').animate({top:"-"+35+"%"},200);
			$(this).find(' .portfolio_cook').animate({right:"-"+15+"%"},200);
		});
    });
	
	
	
	function initialize() {
		var mapProp = {
		    center:new google.maps.LatLng(37.497086, 127.027380),
	    	zoom:16,
			mapTypeId:google.maps.MapTypeId.ROADMAP,
			 scrollwheel: false,
			 
    zoomControl: true,
    zoomControlOptions: {
        position: google.maps.ControlPosition.RIGHT_TOP
    }
		};
	  	var map=new google.maps.Map(document.getElementById("DaumMap"),mapProp);
		
		var marker = new google.maps.Marker({
		    position: new google.maps.LatLng(37.497086, 127.027380),
	    	title:"Hello World!"
		});
		marker.setMap(map);
	}
	google.maps.event.addDomListener(window, 'load', initialize);
});
	