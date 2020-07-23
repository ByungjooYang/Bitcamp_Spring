<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table id="table" border="1">
<thead>
	<tr>
		<th>이름</th>
		<th>아이디</th>
		<th>비밀번호</th>
	</tr>
</thead>

</table>
<div class="search">
<select name="searchOption" id="searchOption">
	<option value="">선택
	<option value="name">이름
	<option value="id">아이디
</select>
<input type="text" id="searchText" name="searchText">
<button id="searchBtn">검색</button>
</div>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/chapter06_SpringWebMaven/user/getUserList',
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			$.each(data.list, function(index, items){
				$('<tbody/>').append($('<tr/>')).append($('<td/>',{
					align: 'center',
					text: items.name
				})).append($('<td/>',{
					align: 'center',
					text: items.id
				})).append($('<td/>',{
					align: 'center',
					text: items.pwd
				})).appendTo($('#table'));            
			});
		}
	});
	
	$('#searchBtn').click(function(){
		alert($('#searchOption').val() + ', ' + $('#searchText').val());
		if( $('#searchOption').val() == '' || $('#searchText').val() == '') {
			alert('옵션을 선택하시거나 검색어를 입력해주세요.');
			return;
		}
		//$('#table > tbody').empty();
		//$('#table tr:not(:first)').remove(); => tr의 첫번째 항목만 빼고 제거한다는 것.
		//$('#table tr:gt(0)').remove();
		$('#table tbody').remove();
		$.ajax({
			type : 'post',
			url  : '/chapter06_SpringWebMaven/user/getSearchList',
			data : 'searchOption=' + $('#searchOption').val() + '&searchText=' + $('#searchText').val(), //JSON.stringify({ #{searchOption}, #{searchText} }), // 이렇게 하면 controller에 @RequestParam이 아니라 @RequestBody를 써주어야 한다.
			//contentType : 'application/json;charset=UTF-8', 위에 제이슨으로 보내면 이걸 해줘야 한다.
			dataType : 'json',
			success : function(data){
				$.each(data.list, function(index, items){
					$('<tbody/>').append($('<tr/>')).append($('<td/>',{
						align: 'center',
						text: items.name
					})).append($('<td/>',{
						align: 'center',
						text: items.id
					})).append($('<td/>',{
						align: 'center',
						text: items.pwd
					})).appendTo($('#table'));            
				});
			}
		});
	});
});
</script>
</html>