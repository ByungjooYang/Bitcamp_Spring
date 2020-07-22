<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyForm</title>
<style type="text/css">
div{
	text-align:center;
}
#modifyFormDiv{
	display:none;
}
</style>
</head>
<body>
<div>수정할 아이디 입력 : <input type="text" id="searchId">&emsp;<input type="button" value="검색" id="search"></div>
<div id="resultDiv" style="color:red;font-size:8pt;"></div>
<br>
<form id="modifyForm">
<div id="modifyFormDiv" style="border:1px solid black;">
	<table align="center" border="1" cellspacing="0">
		<tr>
			<td>이름</td>
			<td><input type="text" id="modifyName" name="name"></td>
		</tr>
		
		<tr>
			<td>아이디</td>
			<td><input type="text" id="modifyId" name="id" readOnly></td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td><input type="text" id="modifyPwd" name="pwd"></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="button" value="수정" id="modifyBtn">
				<input type="reset" value="다시입력" id="resetBtn">
			</td>
		</tr>
	</table>
</div>
</form>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#search').click(function(){
		$('#resultDiv').empty();	
	
		if($('#searchId').val() == ''){
			$('#resultDiv').text('아이디를 입력해주세요.');
	
		}else {
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/getUser',
				data: 'id='+$('#searchId').val(),
				dataType: 'json',
				success: function(data){
					alert(JSON.stringify(data));
//					if(data.userDTO == null) { =>userDTO로 해도 되는 이유는 json으로 넘어온게 이거 밖에 없어서 그렇다.
	//				JSON.stringify(data) == JSON.stringify({})) 로 비교해도 된당
					if($.isEmptyObject(data)) {
						$('#resultDiv').text('찾는 아이디가 없습니다.');
						$('#modifyFormDiv').css('display', 'none');
						return;
					}
					$('#modifyFormDiv').css('display', 'block');
					$('#modifyName').attr('value', data.name);
					$('#modifyId').attr('value', data.id);
					
				},
				error: function(err){
					console.log(err);
				}
				
			});
		}
	});
	
	$('#modifyBtn').click(function(){
		$.ajax({
			type : 'post',
			url  : '/chapter06_SpringWebMaven/user/modify',
			data :  $('#modifyForm').serialize(), //'id='+$('#modifyId') + '&name='+$('#modifyName') + '&pwd='+$('#modifyPwd'),
			success : function(){
				alert('수정 성공');
				location = '/chapter06_SpringWebMaven/main/index';
			}
		});
		
	});
	
	$('#resetBtn').click(function(){
		$('#searchBtn').trigger('click'); //click 이벤트 발생시킨다.
	});
	
	
});
</script>
</html>