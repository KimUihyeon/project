// JavaScript Document
// 
//0. 객체
//1. Login
//2. Join 중복확인
/* 1. Login Ajax */
/* 1. 아이디 중복확인  */
/* 2. 아이디 찾기 */
/* 3. 비밀번호 찾기 */
var AjaxContain = function ( Url , Data) {

	this.url = Url+"Ajax.Ajax";
	this.data = Data;

	this.getUrl = function (){
		return this.url;
	}

	this.getData= function (){
		return this.data;
	}

}


/* 0. Login Ajax */
/* 0. Login Ajax */
function LoginAjax(path,data){

	var ajaxObj = new AjaxContain(path,data);

	var Data = ajaxObj.getData();

	var Url = ajaxObj.getUrl();

	$.ajax({

		type : 'post',
		url : Url ,
		data : {
			id : Data[0],
			pw : Data[1]
		},
		dataType : 'json',

		success : function (data){

		//	console.log("Text 중 입니다.");
		//	console.log(data);
			
			var list = data;
			var bool= false;
			for (var i=0; i<list.length ; i++){
				bool = list[i].bool
			}
			
			if( bool == "true" ){
				
				alert("로그인 되었습니다.");
				
				location.href="index.do";
				
			}
			else{
				
				alert("비벌번호를 확인해 주세요.")
				
			}
			
		},
		error : function (xht,status,error) {
			
			//console.log(xht+"\r\n"+status+"\r\n"+error);
			
			alert("잘못된 접근 입니다.");
			
			location.href="err/404.do";
			
		}


	})

}


/* 1. 아이디 중복 확인 */
/* 1. 아이디 중복 확인 */
function Joincomfirm(path,data) {
	
	var ajaxObj = new AjaxContain(path,data);
	
	var Data = ajaxObj.getData();
	
	var Url = ajaxObj.getUrl();
	
	$.ajax({
		
		type : "post",
		
		url : Url,
		
		data : {
			"id" : data
		},
		
		dataType : "json",
		
		success : function (data) {
			
			var bool = data.bool;
			
			if( bool == "true" ){
				
				document.join.submit();
				
			}
			else{
				
				alert("중복된 아이디 입니다");
				
			}
			
		//	console.log(data);
			
		},
		
		error : function (error) {
			
			console.log(error);
			
		}
		
	})
	
}

/* 2. 아이디 찾기  */
/* 2. 아이디 찾기  */

function findId(path,data){
	
	var ajaxObj = new AjaxContain(path,data);
	
	var Data = ajaxObj.getData();
	
	var Url = ajaxObj.getUrl();
	
	$.ajax({
		
		type : 'post',
		
		url : Url,
		
		data : {
			'name' : Data[0],
			'tel' : Data[1]
		},
		
		dataType : 'json',
		
		success : function ( data ){
			
			var bool = data.bool;
			
			if( bool == "true" ){

				document.findId.submit();
				
		//		alert("찾음");
				
			}
			else {
				
				alert("동록되지 않은 사용자 입니다");
				
			}
			
		},
		
		error : function ( error ) {
			
			console.log(error);
			
		}
		
	})
}

/* 3. 비밀번호 찾기  */
/* 3. 비밀번호 찾기  */
function findPw(path,data){
	
	var ajaxObj = new AjaxContain(path,data);
	
	var Data = ajaxObj.getData();
	
	var Url = ajaxObj.getUrl();
	
	$.ajax({
		
		type : 'post',
		
		url : Url,
		
		data : {
			'name' : Data[0],
			'id' : Data[1],
			'tel' : Data[2],
		},
		
		dataType : 'json',
		
		success : function ( data ){
			
			var bool = data.bool;
			
			if( bool == "true" ){

				//locaion.href= "";
				
			//	alert("찾음");
				
				var MailUrl = "mailGo";
				
				var MailData = Data;
				
				mailGo(MailUrl,MailData);
				
				document.findPw.submit();
				
			}
			else {
				
				alert("동록되지 않은 사용자 입니다");
				
			}
			
		},
		
		error : function ( error ) {
			
			console.log(error);
			
		}
		
	})
}

/* 4.메일보내기 */
/* 4.메일보내기 */
function mailGo(path,data){
	
	var ajaxObj = new AjaxContain(path,data);
	
	var Data = ajaxObj.getData();
	
	var Url = ajaxObj.getUrl();
	
	$.ajax({
		
		type : 'post',
		
		url : Url,
		
		data : {
			'name' : Data[0],
			'id' : Data[1],
			'tel' : Data[2],
		},
		
		dataType : 'json',
		
		success : function ( data ){
			
			var bool = data.bool;
			
			if( bool == "true" ){

				//locaion.href= "";
				
			//	console.log("메일보냈어");
				
				//document.findPw.submit();
				
			}
			else {
				
				alert("동록되지 않은 사용자 입니다");
				
			}
			
		},
		
		error : function ( error ) {
			
			console.log(error);
			
		}
		
	})
}

/* 5.Naver Login */
/* 5.Naver Login */

function naverLoginAjax(path,data){

	var ajaxObj = new AjaxContain(path,data);
	
	var Data = ajaxObj.getData();
	
	var Url = ajaxObj.getUrl();
	//console.log(Data[0]);
//	console.log(Data[1]);
	$.ajax({
		
		type:'post',
			
		url : Url,

		dataType : 'json',
		
		data : {
			'id' : Data[0],
			'name' : Data[1],
			'type' : 'naver'
		},
		
		success : function (data){

			var bool = data.bool;
			
			if(bool == "true"){
				opener.parent.location='/tryAngle/index.do';
			}
			else{

				
				alert("다시 시도해 주세요");
				
			}
			window.close();
	//		console.log(data);
			
		},
		
		error : function (error) {

			window.close();
			alert("다시 시도해 주세요");
			
//			console.log(error);
			
		}
		
	});
	
}