<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험</title>
</head>
<body>
<table id="table" border="1" cellpadding="3" cellsapcing="0">
	<tr>
		<th width="100">학번</th>
		<th width="100">이름</th>
		<th width="100">국어 점수</th>
		<th width="100">영어 점수</th>
		<th width="100">수학 점수</th>
		<th width="100">총점</th>
		<th width="100">평균</th>
		<th width="100">이미지</th>
	</tr>
</table>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
//성적 출력
$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/spring/member/getMember',
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			var table;
			$.each(data.list, function(index, items){
				
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.studentId
				})).append($('<td/>',{
					align: 'center',
					text: items.name
				})).append($('<td/>',{
					align: 'center',
					text: items.kor
				})).append($('<td/>',{
					align: 'center',
					text: items.eng
				})).append($('<td/>',{
					align: 'center',
					text: items.math
				})).append($('<td/>',{
					align: 'center',
					text: items.tot
				})).append($('<td/>',{
					align: 'center',
					text: items.avg
				})).append($('<td/>',{
					align: 'center',
					text: items.image
				})).appendTo('#table');
			}); //each
			
			$('#table').append(table);
			
		},
		error: function(err) {
			console.log(err);
		}
	});
});

</script>
</body>
</html>