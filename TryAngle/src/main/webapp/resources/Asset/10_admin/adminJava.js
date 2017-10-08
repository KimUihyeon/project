// JavaScript Document
$(function(){
	var nav = $('.nav');
	var section = $('.section').height()+100;
	
	if(section<1000){
		nav.css({height:1000+"px"});
		$('.section').css({height:900+"px"});
	}
	else{
		nav.css({height:section+"px"});
	}
		var LineSpeed =0
	$('table').each(function(index, element) {
        $('tr').each(function(index2, element) {
			var Linenumber = index2;
			LineSpeed = index2*100;
			$(this).delay(LineSpeed).animate({opacity:1},500);
        });
    });
	$('li > .a_box').on('mouseenter',function(){
		$(this).css({color:"#e54506"});
	});
	$('li > .a_box').on('mouseleave',function(){
		$(this).css({color:"#000"});
	});
	$('.hd > td').on('mouseenter',function(){
		$(this).css({color:"#e54506"});
	});
	$('.hd > td').on('mouseleave',function(){
		$(this).css({color:"#000"});
	});
/*	
	$('li').each(function(index, element) {
        $('li').eq(index).hover(
			function(){
				$(this).animate({color:"#e54506"},500);
			},
			function(){
				$(this).animate({color:'#fff'},300);
			}
		);
    });*/
	
});