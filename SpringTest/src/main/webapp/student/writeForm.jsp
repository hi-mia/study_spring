<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h3>성적입력</h3>
<form id="writeForm">
<table border="1" cellpadding="5" cellspacing="0">
	<tr>
	 <td align="center">학번</td>
	 <td>
	 	<input type="text" name="studentId" id="studentId" placeholder="학번 입력">
	 	<div id="studentIdDiv"></div>
	 </td>
	</tr>

	<tr>
	 <td align="center">이름</td>
	 <td>
	 	<input type="text" name="name" id="name" placeholder="이름 입력">
	 	<div id="nameDiv"></div>
	 </td>
	</tr>
	
	<tr>
	 <td align="center">국어</td>
	 <td>
	 	<input type="text" name="kor" id="kor">
	 	<div id="korDiv"></div>
	 </td>
	</tr>
	
	<tr>
	 <td align="center">영어</td>
	 <td>
	 	<input type="text" name="eng" id="eng">
	 	<div id="engDiv"></div>
	 </td>
	</tr>
	
	<tr>
	 <td align="center">수학</td>
	 <td>
	 	<input type="text" name="math" id="math">
	 	<div id="mathDiv"></div>
	 </td>
	</tr>
	
	<tr>
			<td colspan="2">
			<input type="file" name="img[]" multiple size="50"> <!-- 한 번에 여러개 들어올 수 있도록 -->
		</tr>
	
	<tr>
	 <td colspan="2" align="center">
	  <input type="button" value="성적입력" id="writeBtn">
	  <input type="reset" value="다시작성">
	 </td>
	</tr>
</table>
<br><br>
<div id="writeResult"></div>
</form>
</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
//성적입력
$('#writeBtn').click(function(){
	$('#studentIdDiv').empty();
	$('#nameDiv').empty();
	$('#korDiv').empty();
	$('#engDiv').empty();
	$('#mathDiv').empty();
	
	if($('#studentId').val() == ''){
		$('#studentIdDiv').text('학번 입력');
		$('#studentIdDiv').css('color', 'red');
		$('#studentIdDiv').css('font-size', '8pt');
		$('#studentIdDiv').css('font-weight', 'bold');
		
	}else if($('#name').val() == ''){
		$('#nameDiv').text('이름 입력');
		$('#nameDiv').css('color', 'red');
		$('#nameDiv').css('font-size', '8pt');
		$('#nameDiv').css('font-weight', 'bold');
		
	}else if($('#kor').val() == ''){
		$('#korDiv').text('국어점수 입력');
		$('#korDiv').css('color', 'red');
		$('#korDiv').css('font-size', '8pt');
		$('#korDiv').css('font-weight', 'bold');
		
	}else if($('#eng').val() == ''){
		$('#engDiv').text('영어점수 입력');
		$('#engDiv').css('color', 'red');
		$('#engDiv').css('font-size', '8pt');
		$('#engDiv').css('font-weight', 'bold');
		
	}else if($('#math').val() == ''){
		$('#mathDiv').text('수학점수 입력');
		$('#mathDiv').css('color', 'red');
		$('#mathDiv').css('font-size', '8pt');
		$('#mathDiv').css('font-weight', 'bold');
		
	}else{
		var formData = new FormData($('#writeForm')[0]); //form 안에 있는 모든 것 다 넘김

		$.ajax({
			type: 'post',
			url: '/spring/student/write',
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			data: formData,
			success: function(data) {
				alert("성적 등록 완료");
				location.href='/spring/student/ListForm';
			},
			error: function(err){
				console.log(err);
			}
		});
	}
});

</script> 

</body>
</html>

<!-- 
중복확인
writeForm.jsp(View)수정 - 스크립트로 function 넣어주기 - UserService 인터페이스 수정, UserServiceImpl 수정
- 매퍼 수정 - 컨트롤러 수정

 -->