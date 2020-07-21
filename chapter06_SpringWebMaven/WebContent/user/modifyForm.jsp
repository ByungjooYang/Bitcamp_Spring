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
<div id="modifyFormDiv" style="border:1px solid black;">
	<table align="center" border="1" cellspacing="0">
		<tr>
			<td>이름</td>
			<td><input type="text" id="modifyName" readOnly></td>
		</tr>
		
		<tr>
			<td>아이디</td>
			<td><input type="text" id="modifyId"></td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td><input type="text" id="modifyPwd"></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="button" value="수정" id="modifyBtn">
				<input type="reset" value="다시입력">
			</td>
		</tr>
	</table>
</div>
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
					if(data.name == null) {
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
			data :  'id='+$('#modifyId') + '&name='+$('#modifyName') + '&pwd='+$('#modifyPwd'),
			success : function(){
				alert('수정 성공');
			}
		});
		
	});
	
});
</script>
</html>