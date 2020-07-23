/*function checkWriteForm() {
	//if (document.writeForm.name.value == "") {	//여기서 네임은 name 속성
	if(document.getElementById("name").value == ""){ // 여기서 네임은 id
		alert("이름을 입력해주세여.");
		document.writeForm.name.focus();

	} else if (document.writeForm.id.value == "") {
		alert("아이디를 입력해주세요.");
		document.writeForm.id.focus();

	} else if (document.writeForm.pwd.value == "") {
		alert("비밀번호를 입력해주세여.");
		document.writeForm.pwd.focus();

	} else if (document.writeForm.repwd.value == "") {
		alert("재확인 비밀번호를 입력해주세요.");
		document.writeForm.repwd.focus();

	} else if (document.writeForm.pwd.value != document.writeForm.repwd.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.writeForm.repwd.focus();

	}else if(document.writeForm.dup.value == "unchecked"){ 
		alert("중복체크를 해주세요.");
		
	}else if(document.writeForm.id.value != document.writeForm.dup.value){
		alert("중복체크를 다시 해주세요.");
		
	}else{
		document.writeForm.submit();
		
	}
	
}*/

$(document).ready(function(){
	$('#write').click(function(){	
		if($('#name').val() == "") {
			$('#writeCheck').text("이름을 입력해주세요.");
			$('#name').focus();
			
		}else if($('#id').val() == ""){
			$('#writeCheck').text("아이디을 입력해주세요.");
			$('#id').focus();
			
		}else if($('#pwd').val() == ""){
			$('#writeCheck').text("비밀번호를 입력해주세요.");
			
		}else if($('#repwd').val() == ""){
			$('#writeCheck').text("재확인 비밀번호를 입력해주세요.");
			
		}else if($('#pwd').val() != $('#repwd').val()){
			$('#writeCheck').text("비밀번호가 일치하지 않습니다.");
		
		}else if($('#dup').val() != $('#id').val()){
			$('#writeCheck').text("중복체크를 해주세요.");
			
		}else {
			$('form').submit();
			//$('form[name=writeForm]').submit(); name 속성 이용시.
		}
	});
	
	$('input').on("property change keyup paste input", function(){ // change keyup paste => f12로 들어가서 변경하면 인식을 못한다.
		$('#writeCheck').empty();
	});
});

/*function checkLoginForm(){
	if(document.getElementById("id").value == ""){ // 여기서 네임은 id
		alert("아이디을 입력해주세여.");
		document.loginForm.name.focus();

	} else if (document.loginForm.pwd.value == "") {
		alert("비밀번호를를 입력해주세요.");
		document.loginForm.pwd.focus();
		
	} else{
		document.loginForm.submit();
		
	}
	
}*/

$(document).ready(function(){ //$('checkLoginForm')
	$('#login').click(function(){
		if($('#loginId').val() == "") {
			$('#check').text("아이디를 입력해주세요.");
			$('#loginId').focus();
			/*
			$('div[class=idDiv]').text("아이디를 입력해주세요");
			클래스를 쓰려면 이렇게
			*/
			
		}else if($('#loginPwd').val() == ""){
			$('#check').text("비밀번호를 입력해주세요.");
			$('#loginPwd').focus();
			
		}else {
			$.ajax({
				type : 'post',
				url  : '/springProject/member/login',
				data : {'id' : $('#loginId').val(),
						'pwd' : $('#loginPwd').val() },
				dataType : 'text',
				success : function(data){
					location='/springProject/main/index'				
				}
			});
		}
	});
	
	/*$('input').on("property change keyup paste input", function(){ // change keyup paste => f12로 들어가서 변경하면 인식을 못한다.
		$('#writeCheck').empty();
	});*/
	
	$('input').focusout(function(){
		$('#writeCheck').empty();
	});
});

/*function checkId(){
	let id = document.writeForm.id.value; //세미콜론은 찍어도 그만 안찍어도 그만.
	if(id == ""){
		alert("먼저 아이디를 입력해주세여.");
		
	}else{
		window.open("/miniProject/member/checkId.do?id="+id,"","width=300 height=200");
	}
}*/

$('#id').focusout(function(){
	let id = ('#id').val();
	if(id==''){
		alert("먼저 아이디를 입력해주세여.");
	}else{
		window.open("/miniProject/member/checkId.do?id="+id,"","width=300 height=200");
	}
});

function checkIdClose(id){
	opener.writeForm.id.value = id //opener는 열려있는 창들 중에서 wirteForm을 찾음.
	opener.writeForm.dup.value= id;
	window.close();
	opener.writeForm.pwd.focus();
}

function checkPost(){
	window.open("checkPost.do","","width=500 height=500 scrollbars=yes"); //ms는 스크롤바가 기본적으로 제공되지 않아 이렇게 설정해줘야함.
}

function checkPostClose(zipcode, address){
	opener.document.getElementById("zipcode").value = zipcode; //이걸 써도 되고 이게 더 많이 쓰인다.
	opener.document.getElementById("addr1").value = address;
	opener.document.getElementById("addr2").focus();
	//opener.document.forms[0].zipcode.value = zipcode;
	//opener.document.forms[0].addr1.value = address;
	//opener.document.forms[0].addr2.focus();
	window.close();
}


function checkModifyForm() {
	//if (document.writeForm.name.value == "") {	//여기서 네임은 name 속성
	if(document.getElementById("name").value == ""){ // 여기서 네임은 id
		alert("이름을 입력해주세여.");
		document.writeForm.name.focus();

	} else if (document.writeForm.pwd.value == "") {
		alert("비밀번호를 입력해주세여.");
		document.writeForm.pwd.focus();

	} else if (document.writeForm.repwd.value == "") {
		alert("재확인 비밀번호를 입력해주세요.");
		document.writeForm.repwd.focus();

	} else if (document.writeForm.pwd.value != document.writeForm.repwd.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.writeForm.repwd.focus();
		
	}else{
		document.writeForm.submit();
		
	}
	
}

function onEnterSubmit(){
	if(event.keyCode==13){
		checkLoginForm();
	}	
}






