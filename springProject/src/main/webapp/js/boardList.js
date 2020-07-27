$(document).ready(function(){
	$.ajax({
		type : 'post',
		url  : '/springProject/board/getBoardList',
		data : 'pg=' + $('#pg').val(),
		dataType : 'json',
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
			});
		},
		error : function(data){
			console.log(err);
		}
		
	});
});