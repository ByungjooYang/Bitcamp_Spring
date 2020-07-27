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
			$('form[name=writeForm]').submit();
		}
	});
	
});

$('#id').focusout(function(){
	$('#idDiv').empty();
	
	let id = $('#id').val();
	if(id == ''){
		$('#idDiv').text('먼저 아이디를 입력하세요')
        $('#idDiv').css('color', 'magenta')
        $('#idDiv').css('font-size', '8pt')
        $('#idDiv').css('font-weight', 'bold')
        $('#id').focus();		
	} else{
	 	$.ajax({
	 		type: 'post',
	 		url: '/springProject/member/checkId',
	 		data: 'id='+id,
	 		dataType: 'text',
	 		success : function(data){
	 			if(data == 'exist'){
					$('#idDiv').text('사용 불가능')
					$('#idDiv').css('color','magenta')
					$('#idDiv').css('font-size','8pt')
					$('#idDiv').css('font-weight','bold')
					
				}else if(data=='non_exist'){
					$('#check').val($('#id').val());
					
					$('#idDiv').text('사용 가능')
					$('#idDiv').css('color','blue')
					$('#idDiv').css('font-size','8pt')
					$('#idDiv').css('font-weight','bold')
				}
	 		},
	 		error: function(e){
	 			console.log(e);
	 		}
	 	});
	}	
});

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
	
	$('input').focusout(function(){
		$('#writeCheck').empty();
	});
});

$('#id').focusout(function(){
	let id = $('#id').val();
	if(id==''){
		alert("먼저 아이디를 입력해주세여.");
		
	}else{
		$.ajax({
	 		type: 'post',
	 		url: '/springProject/member/checkId',
	 		data: 'id='+id,
	 		dataType: 'text',
	 		success : function(data){
	 			if(data == 'exist'){
					$('#writeCheck').text('사용 불가능')
					
				}else if(data=='non_exist'){
					$('#check').val($('#id').val());
					$('#writeCheck').text('사용 가능');
					$('#dup').val(id);
				}
	 		},
	 		error: function(e){
	 			console.log(e);
	 		}
	 	});
	}
});

$('#checkPostBtn').click(function(){
	window.open("/springProject/member/checkPost","","width=500 height=500 scrollbars=yes");
});

$('#postSearchBtn').click(function(){
	$('#sidoDiv').empty();
	$('#sigunguDiv').empty();
	$('#roadnameDiv').empty();
	
	if($('#sido').val()==''){
		$('#sidoDiv').text('시도 선택');
		$('#sidoDiv').css('color','red');
		$('#sidoDiv').css('font-size','8pt');
		$('#sidoDiv').css('font-weight','bold');
		
	}else if($('#sido').val()!='세종' && $('#sigungu').val()==''){
		$('#sigunguDiv').text('시군구 입력');
		$('#sigunguDiv').css('color','red');
		$('#sigunguDiv').css('font-size','8pt');
		$('#sigunguDiv').css('font-weight','bold');
		
	}else if($('#roadname').val()==''){
		$('#roadnameDiv').text('도로명 입력');
		$('#roadnameDiv').css('color','red');
		$('#roadnameDiv').css('font-size','8pt');
		$('#roadnameDiv').css('font-weight','bold');
		
	}else{
		$.ajax({
			type: 'post',
			url: '/springProject/member/postSearch',
			data: $('#checkPostForm').serialize(),
			dataType: 'json',
			success : function(data){
				//console.log(JSON.stringify(data));
				
				$('#postTable tr:gt(2)').remove();
				
				$.each(data.list, function(index, items){
					let address = items.sido+' '
								+ items.sigungu+' '
								+ items.yubmyundong+' '
								+ items.ri+' '
								+ items.roadname+' '
								+ items.buildingname;
								
					address	= address.replace(/null/g, '');							
								
					$('<tr/>').append($('<td/>',{
						align: 'center',
						text: items.zipcode
					})).append($('<td/>',{
						colspan: '3'
						}).append($('<a/>',{
							href: '#',
							id: 'addressA',
							text: address
						}))
					).appendTo($('#postTable'));    
				});//each
				
				//a태그를 클릭했을 때
				$('a').click(function(){
					$('#zipcode', opener.document).val($(this).parent().prev().text());
					$('#addr1', opener.document).val($(this).text());
					$('#addr2', opener.document).focus();
					window.close();
				});
				
			},
			error: function(e){
				console.log(e);
			}
		});
	}
});


//회원정보수정
$('#modifyBtn').click(function(){
	$('#checkDiv').empty();
	
    if($('#name').val() == '') {
        $('#checkDiv').text('이름을 입력하세요')
        $('#name').focus();
        
    } else if($('#pwd').val() == '') {
    	$('#checkDiv').text('비밀번호를 입력하세요')
        $('#pwd').focus();
        
    } else if($('#pwd').val() != $('#repwd').val()){
    	$('#checkDiv').text('비밀번호가 일치하지 않습니다')
        $('#repwd').focus();
        
    }else{
    	$.ajax({
    		type: 'post',
    		url: '/springProject/member/modify',
    		data: $('#modifyForm').serialize(),
    		success: function(){
    			alert('회원 정보 수정 완료');
    			location.href='/springProject/main/index';
    		},
    		error: function(err){
    			console.log(err);
    		}
    	});
    } 
 });

function onEnterSubmit(){
	if(event.keyCode==13){
		checkLoginForm();
	}	
}






