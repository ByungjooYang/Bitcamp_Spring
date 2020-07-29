$(document).ready(function(){
	$.ajax({
		type : 'post',
		url : '/springProject/board/getBoardList',
		data: 'pg='+$('#pg').val(),
		dataType: 'json',
		success : function(data){
			//alert(JSON.stringify(data));
			
			$.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.seq
				})).append($('<td/>',{
					align: 'center',
					text: items.subject
				})).append($('<td/>',{
					align: 'center',
					text: items.id
				})).append($('<td/>',{
					align: 'center',
					text: items.logtime
				})).append($('<td/>',{
					align: 'center',
					text: items.hit
				})).appendTo($('#boardListTable'));         
			}); //each
			
			//페이징 처리
			$('#boardPagingDiv').html(data.boardPaging.pagingHTML);
		},
		error: function(err){
			console.log(err);
		}
	});
});

$('#boardSearchBtn').click(function(){
	if($('#keyword').val() == '' ){
		alert('검색어 입력 ㄲ');
	
	}else {
		$.ajax({
			type : 'post',
			url  : '/springProject/board/getBoardSearch',
			data : {'searchOption' : $('#searchOption').val(),
					'keyword' : $('#keyword').val(), 
					'pg' : '1'},
			dataType : 'json',
			success : function(data){
				//alert(JSON.stringify(data));
				$('#boardListTable tr:gt(0)').remove();
				
				$.each(data.list, function(index, items){
					$('<tr/>').append($('<td/>',{
						align: 'center',
						text: items.seq
					})).append($('<td/>',{
						align: 'center',
						text: items.subject
					})).append($('<td/>',{
						align: 'center',
						text: items.id
					})).append($('<td/>',{
						align: 'center',
						text: items.logtime
					})).append($('<td/>',{
						align: 'center',
						text: items.hit
					})).appendTo($('#boardListTable'));         
			}); //each
			
			//페이징 처리
			$('#boardPagingDiv').html(data.boardPaging.pagingHTML);
			
			},
			error : function(err){
				console.log(err);
			}
		});
		
	}
});
