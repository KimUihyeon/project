// JavaScript Document
$(function(){
	//
	// 맵
	//	
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
	
	
	
	
	//
	// 어바웃
	//
	$('.about-level2-item').each(function(index, element) {
        $(this).on('mouseenter',function(){
			$(this).find(' .about-level2-itemSlide').addClass('about-level2-active');
			$(this).find('.about-level2-itemtext1, .about-level2-itemtext2').animate({color:"#fff"},300);
			$(this).find('.about-level3-nameBox').animate({backgroundColor:"#fff"},300);
		})
        $(this).on('mouseleave',function(){
			$(this).find(' .about-level2-itemSlide').removeClass('about-level2-active');
			$(this).find('.about-level2-itemtext1, .about-level2-itemtext2').animate({color:"#000"},300);
			$(this).find('.about-level3-nameBox').animate({backgroundColor:"#000"},300);
		})
    });
	$('.about-level3-icon').each(function(index, element) {        
        $(this).on('mouseenter',function(){
			$(this).find(' .about-level3-photoBox').addClass('about-level3-photoBo-active');
			$(this).find('.about-level3-photo').animate({opacity:1},500);
		})
        $(this).on('mouseleave',function(){
			$(this).find(' .about-level3-photoBox').removeClass('about-level3-photoBo-active');
			$(this).find('.about-level3-photo').animate({opacity:0},500);
		})
    });
	
	
	///
	/// 포폴
	///
	$('.select-all').on('click',function(){
		$('.portfolio-item').removeClass('port-active');
		$('#section1-container').removeClass('section1_sub');
	});
	$('.select-UH').on('click',function(){
		$('.port_UH').addClass('port-active');
		$('.port_YL').removeClass('port-active');
		$('#section1-container').addClass('section1_sub');
	});
	$('.select-YL').on('click',function(){
		$('.port_YL').addClass('port-active');
		$('.port_UH').removeClass('port-active');
		$('#section1-container').addClass('section1_sub');
	});
	
	
	$('.portfolio-item').hover(
	function(){
		$(this).addClass('port-active2');		
		$(this).find('.port_fillter').animate({left:0},500);
		},
	function(){
		$(this).removeClass('port-active2');
		$(this).find('.port_fillter').animate({left:100+"%"},500);
		}
	);
	
	//
	// 콘텍트
	//
	//
	$('.ContactSelect-Box').each(function(index, element) {
        $(this).hover(
		function(){
			$(this).find('.contact-transform').addClass('ContactSelect-active');				
		},
		function(){
			$(this).find('.contact-transform').removeClass('ContactSelect-active');
		}
		);
    });
	
	
	$('.contact_submit').on('click',function(){
		var $con_name = $('.contact_input_name');
		var $con_mail = $('.contact_input_mail');
		var $con_title = $('.contact_input_title');
		var $con_text = $('.contact_input_text');
		if($con_name.val()==""){
			alert("상담자분 성함을 입력해주세요");
			return false;
		}
		if($con_mail.val()==""){
			alert("연락받으실 연락처를 입력해주세요");
			return false;
		}
		if($con_title.val()==""){
			alert("제목을 입력해주세요");
			return false;
		}
		if($con_text.val()==""){
			alert("상세정보를 입력해주세요");
			return false;
		}
		
		if($con_name.val().length>16){
			alert("성함은16자 미안으로 입력해주세요");
			return false;
		}
		if($con_mail.val().length>25){
			alert("연락처는 25자 미만으로 입력해주세요");
			return false;
		}
		if($con_title.val().length>30){
			alert("제목은 30자 미만으로 입력해주세요");
			return false;
		}
		if($con_text.val().length>>1000){
			alert("상세정보는 최대 1000자 입니다.");
			return false;
		}
		
		
		if($con_name.val().indexOf(" ")!=-1){
			alert("성함에 공백을 사용할수 없습니다");
			return false;
		}
		
	});
	
	//
	//QnA
	//
	var QnA_Switch = true;
	$('.QnA-Box').each(function(index, element) {
		var $QnA_Text = $(this).find('.QnA-Text');
		var $QnA_Arrow = $(this).find('.QnA-Arrow');
		var $QnA_Arrow2 = $(this).find('.QnA-Arrow2');
        $(this).find('.QnA-Title').on('click',function(){
			if(QnA_Switch){
				$('.QnA-Text').addClass('acvite_QnA_Text');
				$('.QnA-Arrow').removeClass('QnA-Arrow-active');
				$QnA_Arrow.addClass('QnA-Arrow-active')
				$QnA_Text.removeClass('acvite_QnA_Text');
				$('.QnA-Arrow2').removeClass('QnA-Arrow-active2');
				$QnA_Arrow2.addClass('QnA-Arrow-active2')
				QnA_Switch = false;
			}
			else{
				$('.QnA-Text').addClass('acvite_QnA_Text');
				$('.QnA-Arrow').removeClass('QnA-Arrow-active');
				$('.QnA-Arrow2').removeClass('QnA-Arrow-active2');
				QnA_Switch = true;
			}
		});
    });
	
	$('.btn_consulting').hover(
	function(){
		$('.btn_consulting').animate({backgroundColor:'#c59972'},10);
	},
	function(){
		$('.btn_consulting').animate({backgroundColor:'#333535'},10);
	}
	);
	
	//
	//QnA 유효성체크
	//
	$('.QnA_input_submit').on('click',function(){
		var $QnA_name = $('.QnA_input_name');
		var $QnA_phone = $('.QnA_input_phone');
		var $QnA_title = $('.QnA_input_title');
		var $QnA_text = $('.QnA_input_text');
		
		
		if($QnA_name.val()==""){
			alert("질문자분 성함을 입력해주세요");
			$QnA_name.focus();
			return false;
		}
		if( $QnA_name.val().indexOf(" ")!=-1){
			alert("이름에는 공백을 사용할수 없습니다");
			$QnA_name.focus();
			return false;
		}
		if($QnA_name.val().length>12){
			alert("이름은 12자를 넘길수 없습니다");
			$QnA_name.focus();
			return false;
		}
		
		if($QnA_phone.val()==""){
			alert("질문자분 연락처를 입력해주세요");
			$QnA_phone.focus();
			return false;
		}
		
		if($QnA_phone.val().length>25){
			alert("연락처는 25자를 넘길수 없습니다");
			$QnA_phone.focus();
			return false;
		}
		
		
		if($QnA_title.val()==""){
			alert("질문의 제목을 입력해주세요");
			$QnA_title.focus();
			return false;
		}
		if($QnA_title.val().length>30){
			alert("질문 제목은 30자를 넘길수 없습니다");
			$QnA_title.focus();
			return false;
		}
		
		if($QnA_text.val()==""){
			alert("질문 내용을 입력해주세요");
			$QnA_text.focus();
			return false;
		}
		
		if($QnA_text.val().length>1500){
			alert("질문내용은 1500자가 최대입니다.");
			$QnA_text.focus();
			return false;
		}
	});
		
	//
	// 인풋박스 주황선
	//
	$('.login_').each(function(index, element) {
        $(this).focus(function(){
			$('.login_').css({borderBottom:'2px solid #858687'});
			$(this).css({borderBottom:'2px solid #ff4800'});
		})
	});
	
	//
	// 조인 0 유효성 검사
	//
	$('.join_0_submit').on('click',function(){
		if(!$('.ck1').is(":checked")){
			alert("약관에 동의해 주시기 바랍니다");
			return false;
		}
		if(!$('.ck2').is(":checked")){
			alert("약관에 동의해 주시기 바랍니다");
			return false;
		}
		if(!$('.ck3').is(":checked")){
			alert("약관에 동의해 주시기 바랍니다");
			return false;
		}
	});
	
	//
	// 조인 1 유효성검사
	//
	$('.err-Box').on('click',function(){
		$('.err-Box').addClass('err-active');
	});
	$('#join1_sumbit').on('click',function(){
		
		var $err_Box = $('.err-Box');
		if( $('.join1_id').val()=="" ){
			$err_Box.html("아이디를 입력해주세요");
			$err_Box.removeClass('err-active');
			$('.join1_id').focus();
			return false;
		}
		var id_text =$('.join1_id').val();
		if( id_text.indexOf(" ")!=-1){
			$err_Box.html("공백은 입력할수 없습니다");
			$err_Box.removeClass('err-active');
			$('.join1_id').val('');
			$('.join1_id').focus();
			return false;			
		}
		if($('.join1_id').val().length>12){
			$err_Box.html("아이디의 길이는 12자를 초과할수 없습니다.");
			$err_Box.removeClass('err-active');
			$('.join1_id').focus();
			return false;
		}
		if($('.join1_id').val().length<5){
			$err_Box.html("아이디의 길이는 6자를 이상 입니다.");
			$err_Box.removeClass('err-active');
			$('.join1_id').focus();
			return false;
		}
		if($('.join1_pw').val()==""){
			$err_Box.html("비밀번호를 입력해주세요.");
			$err_Box.removeClass('err-active');
			$('.join1_pw').focus();
			return false;
		}
		if($('.join1_pw').val().length>16){
			$err_Box.html("비밀번호의 길이는 16자를 초과할수 없습니다.");
			$err_Box.removeClass('err-active');
			$('.join1_pw').focus();
			return false;
		}
		if($('.join1_pw').val().length<5){
			$err_Box.html("비밀번호의 길이는 6자 이상입니다.");
			$err_Box.removeClass('err-active');
			$('.join1_pw').focus();
			return false;
		}
		
		var pw_text =$('.join1_pw').val();
		if( pw_text.indexOf(" ")!=-1){
			$err_Box.html("공백은 입력할수 없습니다");
			$err_Box.removeClass('err-active');
			$('.join1_pw').val('');
			$('.join1_pw').focus();
			return false;			
		}
		
		var pw2_text =$('.join1_pw').val();
		if( pw2_text.indexOf(" ")!=-1){
			$err_Box.html("공백은 입력할수 없습니다");
			$err_Box.removeClass('err-active');
			$('.join1_pw2').val('');
			$('.join1_pw2').focus();
			return false;			
		}
		if($('.join1_pw2').val()==""){
			$err_Box.html("비밀번호를 입력해주세요.");
			$err_Box.removeClass('err-active');
			$('.join1_pw2').focus();
			return false;
		}
		if($('.join1_pw').val()!=$('.join1_pw2').val()){
			$err_Box.html("비밀번호가 일치하지 않습니다.");
			$err_Box.removeClass('err-active');
			$('.join1_pw').focus();
			return false;
		}
		if($('.join1_name').val()==""){
			$err_Box.html("필수항목을 입력하지 않았습니다.");
			$err_Box.removeClass('err-active');
			$('.join1_name').focus();
			return false;
		}
		if($('.join1_name').val().length>10){
			$err_Box.html("이름의 길이는 12자를 초과할수 없습니다.");
			$err_Box.removeClass('err-active');
			$('.join1_name').focus();
			return false;
		}
		if($('.join1_name').val().length<2){
			$err_Box.html("이름의 길이는 3자 이상입니다.");
			$err_Box.removeClass('err-active');
			$('.join1_name').focus();
			return false;
		}
		if($('.join1_email').val()==""){
			$err_Box.html("연락처를 기제해 주세요");
			$err_Box.removeClass('err-active');
			$('.join1_email').focus();
			return false;
		}
		if($('.join1_email').val().length>25){
			$err_Box.html("연락처의 길이는 25자를 초과할수 없습니다.");
			$err_Box.removeClass('err-active');
			$('.join1_email').focus();
			return false;
		}
		if($('.join1_email').val().length<5){
			$err_Box.html("연락처의 길이는 6자 이상입니다.");
			$err_Box.removeClass('err-active');
			$('.join1_email').focus();
			return false;
		}

		var url = "joinComfirm";
		
		var data = $('.join1_id').val();

		Joincomfirm(url,data);
		
	});

	$('.join1_id, .join1_pw, .join1_pw2, .join1_name, .join1_email').on('keydown',function(e){
	   if(e.keyCode == 13) {
		   $('#join1_sumbit').trigger("click");
	   }
	})
	
	
	//
	// 조인 2 유효성검사
	//
	$('#join2_sumbit').on('click',function(){
		
		var $err_Box = $('.err-Box');
		if( $('.join1_id').val()=="" ){
			$err_Box.html("아이디를 입력해주세요");
			$err_Box.removeClass('err-active');
			$('.join1_id').focus();
			return false;
		}
		var id_text =$('.join1_id').val();
		if( id_text.indexOf(" ")!=-1){
			$err_Box.html("공백은 입력할수 없습니다");
			$err_Box.removeClass('err-active');
			$('.join1_id').val('');
			$('.join1_id').focus();
			return false;			
		}
		if($('.join1_id').val().length>12){
			$err_Box.html("아이디의 길이는 12자를 초과할수 없습니다.");
			$err_Box.removeClass('err-active');
			$('.join1_id').focus();
			return false;
		}
		if($('.join1_id').val().length<5){
			$err_Box.html("아이디의 길이는 6자를 이상 입니다.");
			$err_Box.removeClass('err-active');
			$('.join1_id').focus();
			return false;
		}
		if($('.join1_pw').val()==""){
			$err_Box.html("비밀번호를 입력해주세요.");
			$err_Box.removeClass('err-active');
			$('.join1_pw').focus();
			return false;
		}
		if($('.join1_pw').val().length>16){
			$err_Box.html("비밀번호의 길이는 16자를 초과할수 없습니다.");
			$err_Box.removeClass('err-active');
			$('.join1_pw').focus();
			return false;
		}
		if($('.join1_pw').val().length<5){
			$err_Box.html("비밀번호의 길이는 6자 이상입니다.");
			$err_Box.removeClass('err-active');
			$('.join1_pw').focus();
			return false;
		}
		
		var pw_text =$('.join1_pw').val();
		if( pw_text.indexOf(" ")!=-1){
			$err_Box.html("공백은 입력할수 없습니다");
			$err_Box.removeClass('err-active');
			$('.join1_pw').val('');
			$('.join1_pw').focus();
			return false;			
		}
		
		var pw2_text =$('.join1_pw').val();
		if( pw2_text.indexOf(" ")!=-1){
			$err_Box.html("공백은 입력할수 없습니다");
			$err_Box.removeClass('err-active');
			$('.join1_pw2').val('');
			$('.join1_pw2').focus();
			return false;			
		}
		if($('.join1_pw2').val()==""){
			$err_Box.html("비밀번호를 입력해주세요.");
			$err_Box.removeClass('err-active');
			$('.join1_pw2').focus();
			return false;
		}
		if($('.join1_pw').val()!=$('.join1_pw2').val()){
			$err_Box.html("비밀번호가 일치하지 않습니다.");
			$err_Box.removeClass('err-active');
			$('.join1_pw').focus();
			return false;
		}
		if($('.join1_name').val()==""){
			$err_Box.html("필수항목을 입력하지 않았습니다.");
			$err_Box.removeClass('err-active');
			$('.join1_name').focus();
			return false;
		}
		if($('.join1_name').val().length>10){
			$err_Box.html("이름의 길이는 12자를 초과할수 없습니다.");
			$err_Box.removeClass('err-active');
			$('.join1_name').focus();
			return false;
		}
		if($('.join1_name').val().length<2){
			$err_Box.html("이름의 길이는 3자 이상입니다.");
			$err_Box.removeClass('err-active');
			$('.join1_name').focus();
			return false;
		}
		if($('.join1_email').val()==""){
			$err_Box.html("연락처를 기제해 주세요");
			$err_Box.removeClass('err-active');
			$('.join1_email').focus();
			return false;
		}
		if($('.join1_email').val().length>25){
			$err_Box.html("연락처의 길이는 25자를 초과할수 없습니다.");
			$err_Box.removeClass('err-active');
			$('.join1_email').focus();
			return false;
		}
		if($('.join1_email').val().length<5){
			$err_Box.html("연락처의 길이는 6자 이상입니다.");
			$err_Box.removeClass('err-active');
			$('.join1_email').focus();
			return false;
		}
		
	});
	
	//
	// 로그인 유효성 검사
	//
	$('.login_btn_submit').on('click',function(){
		
		var bool_box = new Array(true,true);
		
		//console.log(bool_box[0]);
		
		if($('.login_input_id').val()==""){
			alert("아이디를 입력해주세요");
			$('.login_input_id').focus();
			bool_box[0] = false;
			return false;
		}
		if($('.login_input_pw').val()==""){
			alert("비밀번호를 입력해주세요");
			$('.login_input_pw').focus();
			bool_box[0] = false;
			return false;
		}
		
		if ( bool_box[0]==true && bool_box[1]==true  ) {
			
			var data = new Array(
				$('.login_input_id').val(),
				$('.login_input_pw').val()
			);
			
			var url = "login"
			
			LoginAjax(url,data);
			
		//	console.log("Ajax 실행");
			
		}
	});
	
	$('#pwBtn , #idBtn').on('keydown',function(e){
	   if(e.keyCode == 13) {
		   $('#loginSubmit').trigger("click");
	   }
	})
	
	//
	// 아디비번찾기
	//
	
	$('.find_id_submit').on('click',function(){
		
		if( $('.find_id_name').val()=="" ){
			alert("이름을 입력해주세요");
			$('.find_id_name').focus();
			return false;
		}
		
		if($('.find_id_name').val().length>12){
			alert("이름은 12자를 초과할수 없습니다.");
			$('.find_id_name').focus();
			return false;
		}
		
		
		if( $('.find_id_mail').val()=="" ){
			alert("이메일을 입력해주세요");
			$('.find_id_mail').focus();
			return false;
		}
		
		if($('.find_id_mail').val().length>26){
			alert("이메일은 길이는 25자를 초과할수 없습니다.");
			$('.find_id_mail').focus();
			return false;
		}
		
		
		var data = new Array(
				$('.find_id_name').val(),
				$('.find_id_mail').val()
		);
		
		var Url = "findId";
		
		findId(Url,data);
				
	});
	
	$('.find_pw_submit').on('click',function(){
		
		if( $('.find_pw_id').val()=="" ){
			alert("아이디을 입력해주세요");
			$('.find_pw_id').focus();
			return false;
		}
		
		if($('.find_pw_id').val().length>12){
			alert("아이디는 12자를 초과할수 없습니다.");
			$('.find_pw_id').focus();
			return false;
		}
		
		
		if( $('.find_pw_name').val()=="" ){
			alert("이름을 입력해주세요");
			$('.find_pw_name').focus();
			return false;
		}
		
		if($('.find_pw_name').val().length>12){
			alert("이름은 12자를 초과할수 없습니다.");
			$('.find_pw_name').focus();
			return false;
		}
		
		
		if( $('.find_pw_mail').val()=="" ){
			alert("이메일을 입력해주세요");
			$('.find_pw_mail').focus();
			return false;
		}
		
		if($('.find_pw_mail').val().length>25){
			alert("이메일은 26자를 초과할수 없습니다.");
			$('.find_pw_mail').focus();
			return false;
		}
		

		var data = new Array(
				$('.find_pw_name').val(),
				$('.find_pw_id').val(),
				$('.find_pw_mail').val()
		);
		
		var Url = "findPw";
		
		findPw(Url,data);
		
	});
	

	$('.find_pw_name, .find_pw_id, .find_pw_mail').on('keydown',function(e){
	   if(e.keyCode == 13) {
		   $('.find_pw_submit').trigger("click");
	   }
	})
	$('.find_id_name, .find_id_mail').on('keydown',function(e){
		   if(e.keyCode == 13) {
			   $('.find_id_submit').trigger("click");
	   }
	})
		

	function onPrev(){
		location.href = "login.do"; 
	}
	
});

	function Join1_submit(){
		if( $('.join1_id').val()=="" ){
			$('.join1_id').focus();
			return false;
		}
		
		if($('.join1_pw').val()!=$('.join1_pw2').val()){
		//	alert("같음");
			return false;
		}
	}
