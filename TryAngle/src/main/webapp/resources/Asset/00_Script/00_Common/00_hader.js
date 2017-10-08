// JavaScript Document

$(function(){
	menuResize();
	var Spin_bool = true;
	
	$('.header-menu-pc-li').eq(2).on('mouseenter',function(){
		$(this).animate({width:70+"px"},150);
		$(this).find(' .header-text').animate({left:30,opacity:1},150);
	});
	$('.header-menu-pc-li').eq(2).on('mouseleave',function(){
		$(this).animate({width:30+"px"},150);
		$(this).find(' .header-text').animate({left:0,opacity:0},150);
	});
	
	
	$('.header-menu-pc-li').eq(2).on('click',$.throttle(1500/1,function(event,delta){
			$('#spinWrap').addClass('spinActive');
			$('.menuEsing').addClass('menuEsingAcvite')
			$('.KingMenu').addClass('FexidActive');
	}));
	$('.menuEsing').on('click',function(){
			$('#spinWrap').removeClass('spinActive');
			$('.menuEsing').removeClass('menuEsingAcvite')
			$('.KingMenu').removeClass('FexidActive');
	});
	
	$('#mobile-menu-btn').on('click',function(){
		$('.mobileMenu').addClass('mobileMenuActive');
	});
	$('.mobile_Exit').on('click',function(){
		$('.mobileMenu').removeClass('mobileMenuActive');
	});
	
	$('#header-container').clone().appendTo('#header-container-clone');
	/*
	$('body').on('mousewheel',function(e){
		console.log($(this).scrollTop());
		if($(this).scrollTop() > 800)
		{
			$('#header-container-clone').stop(true).animate({top:0,width:100+"%",left:0+"%"},200);
		}
		
		else 
		{
			$('#header-container-clone').stop(true).animate({top:-100+"px",width:0+"%",left:50+"%"},200);
		}
	
	});*/
	
	$('.footer-SNS').each(function(index, element) {
        $(this).hover(
			function(){
				var speed = 300;
				$(this).find('> .footer-SNS-Icon').animate({top:-100+"%"},speed);
				$(this).find('> .footer-SNS-Text').animate({top:0+"%"},speed);
			},
			function(){
				var speed = 300;
				$(this).find('> .footer-SNS-Icon').animate({top:0+"%"},speed);
				$(this).find('> .footer-SNS-Text').animate({top:100+"%"},speed);
			}
		);
    });
	
	//
	// 윈도우 리사이즈
	//
	$(window).resize(function(){
		menuResize();
	});
	function menuResize(){
		var win_width= window.innerWidth;
		var win_height = window.innerHeight;
		$('.KingMenu-container').css({width:win_width,height:win_height});
	}
	
});