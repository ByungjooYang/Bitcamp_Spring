$('#boardWriteBtn').click(function(){
	$('#checkDiv').empty();
	
	if($('#subject').val() ==''){
		$('#checkDiv').text('제목을 입력하세요');
        
	}else if($('#content').val() ==''){
		$('#checkDiv').text('내용을 입력하세요');
        
	}else{
		$.ajax({
			type: 'post',
			url: '/springProject/board/boardWrite',
			data: {'subject': $('#subject').val(),
				   'content': $('#content').val()},
			success: function(){
				alert('글쓰기 완료!!');
				location='/springProject/main/index';
				
			},
			error: function(err){
				console.log(err);
			}
		});
	}
});


