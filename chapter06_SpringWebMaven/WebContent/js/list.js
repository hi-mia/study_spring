$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/chapter06_SpringWebMaven/user/getUserList',
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			var table;
			$.each(data.list, function(index, items){
//				table += '<tr>';
//				table += '<td align=center>' + items.name+'</td>';
//				table += '<td align=center>' + items.id+ '</td>';
//				table += '<td align=center>' + items.pwd+ '</td>';
//				table += '</tr>';
				
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.name
				})).append($('<td/>',{
					align: 'center',
					text: items.id
				})).append($('<td/>',{
					align: 'center',
					text: items.pwd
				})).appendTo('#table');
			}); //each
			
			$('#table').append(table);
			
		},
		error: function(err) {
			console.log(err);
		}
	});
});

//컨트롤러에서 list를 한번 써서 여기선 getUserList로 이름 바꿈

//검색
$('#searchBtn').click(function(){
	$('#searchText').empty();
	
	if($('#searchText').val() == ''){ // name의 값을 가져와라
		alert('검색어를 입력해주세요');
	}else {
		$.ajax({
			url:'/chapter06_SpringWebMaven/user/search',
			type: 'post',
			
			//1.
			//data: 'searchOption='+$('#searchOption').val()+'&searchText'+$('#searchText').val(),
			
			//2.
			//data: {'searchOption': $('#searchOption').val(),
			//		'searchText': $('#searchText').val()
			//		}, 

					
			//3. JSON의 형식 그대로 문자열로 왔을 때
			contentType: 'application/json;charset=UTF-8',
			data: JSON.stringify({'searchOption': $('#searchOption').val(),
						'searchText': $('#searchText').val()
					}),
					
//			data: {"searchOption": $('#searchOption').val(),
//				"searchText": $('#searchText').val()},
			
			
			//JSON의 형식 그대로 문자열로 바꾸어서
			dataType: 'json',
			success: function(data) {
				//alert(JSON.stringify(data)); //데이터가 오는지 안오는지 확인
				//if(JSON.stringify(data) == '{"list":[]}') {alert('없지롱~')};

				var table;
				 $('td').hide(); //이거 안써서 계속 추가됨ㅋㅋ
				//$('#table tr:gt(0)').remove();
				 
				$.each(data.list, function(index, items){
					
					$('<tr/>').append($('<td/>',{
						align: 'center',
						text: items.name
					})).append($('<td/>',{
						align: 'center',
						text: items.id
					})).append($('<td/>',{
						align: 'center',
						text: items.pwd
					})).appendTo('#table');
				}); //each
				
				$('#table').append(table);
			},
			error: function(err) {
				console.log(err);
		      }  
			});
		}//if
		
	});
