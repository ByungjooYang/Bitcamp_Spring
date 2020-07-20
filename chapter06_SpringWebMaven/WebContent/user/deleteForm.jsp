<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
let searchId = null;
let deleteConf = false;
$(document).ready(function(){
	$('#deleteSearch').click(function(){
		if($('#deleteId').val() == ''){
			$('#deleteDiv').text('아이디를 입력해주세요.');
			$('#deleteDiv').css('display', 'block');
			alert('아이디가 없는디..?');
			
		} else {
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/checkId',
				data: 'id='+$('#deleteId').val(),
				dataType: 'text',
				success: function(data){
					searchId = data;
					
				},
				error: function(err){
					console.log(err);
				}
			});
			
			
		}
		if(searchId == '사용 가능'){
			$('#deleteDiv').text('찾으시는 아이디가 없습니다.');
			$('#deleteDiv').css('display', 'block');
			
				
		} else {
			deleteConf = confirm("삭제 하시겠습니까?");
			
			if(deleteConf == true) {
				$.ajax({
					type: 'post',
					url: '/chapter06_SpringWebMaven/user/delete',
					data: 'id='+$('#deleteId').val(),
					success: function(data){
						alert("회원정보를 삭제했습니닷.")
							
					},
					error: function(err){
						console.log(err);
					}
				});
			}		
		}
	});	
});
</script>
<style type="text/css">
#deleteDiv{
	display:none;
	text-align:center;
}
</style>
</head>
<body>
<table align="center" border="1" cellspacing="0" cellpadding="10">
<tr>
	<td>삭제할 아이디 입력 :&emsp;<input type="text" id="deleteId">&emsp;<input type="button" value="검색" id="deleteSearch"></td>
<tr>

</table>
<div id="deleteDiv" style="font-size:8pt;color:red;"></div>
</body>
</html>