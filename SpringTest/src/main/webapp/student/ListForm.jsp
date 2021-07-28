<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form id="ListForm" name="ListForm">
<table id="ListFormTable" border="1" width="700" cellpadding="5" frame="hsides" rules="rows">
	<tr> <%-- 제목 --%>
		<th width="100">학번</th>
		<th width="200">이미지</th>
		<th width="100">이름</th>
		<th width="100">국어</th>
		<th width="100">영어</th>
		<th width="100">수학</th>
		<th width="100">총점</th>
		<th width="100">평균</th>
	</tr>
	<%-- 여기에 동적으로 다 붙게 한다 --%>
</table>
<br>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>


$(function(){
	$.ajax({
		type: 'post',
		url: '/spring/student/getStudent',
		dataType: 'json',
		success: function(data){
			
			 $.each(data.list, function(index,items){
		            $('<tr/>').append($('<td/>',{
		               align: 'center',
		               text: items.studentId
		            })).append($('<td/>',{
		            	
		            }).append($('<img/>',{
	            	  src: '../storage/'+items.image1,
					   align: 'center',
					   width: '80px',
					   height: '80px'
		            }))
		            ).append($('<td/>',{
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
		            })).appendTo($('#ListFormTable'));
		         });//each
			
		},
		error: function(err){
			console.log(err);
		}
	});
	
});
</script>

</html>