// JavaScript Document

$(function(){
	
	$('.button').on('mouseenter', function(){
		$(this).addClass("button-active");
	});
	
	$('.button').on('mouseleave', function(){
		$(this).removeClass("button-active");
	});
	
});