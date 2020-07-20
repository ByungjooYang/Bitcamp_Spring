$('#writeBtn').click(function(){
	$('#nameDiv').empty();
	$('#idDiv').empty();
	$('#pwdDiv').empty();
	
	if($('#name').val()==''){
		$('#nameDiv').text('이름 입력');
		$('#nameDiv').css('font-size', '8pt');
		$('#nameDiv').css('color', 'red');
		
	}else if($('#id').val()==''){
		$('#idDiv').text('아이디 입력');
		$('#idDiv').css('font-size', '8pt');
		$('#idDiv').css('color', 'red');
		
	}else if($('#pwd').val()==''){
		$('#pwdDiv').text('비밀번호 입력');
		$('#pwdDiv').css('font-size', '8pt');
		$('#pwdDiv').css('color', 'red');
		
	} else {
		$.ajax({
			type : 'post',
			url  : '/chapter06_SpringWebMaven/user/write',
			data : $('#writeForm').serialize(),
			success : function(){
				alert('회원가입을 축하합니당');
			},
			error: function(err){
				console.log(err);
			}
		});
	}
});

$('#id').focusout(function(){
	$('#idDiv').empty();
	
	if($('#id').val()==''){
		$('#idDiv').text('필수 정보 입니다');
		$('#idDiv').css('font-size', '8pt');
		$('#idDiv').css('color', 'magenta');
		
	}else{
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/checkId',
			data: 'id='+$('#id').val(),
			dataType: 'text',
			success: function(data){
				alert(data);
			},
			error: function(err){
				console.log(err);
			}
		});
	}
});

