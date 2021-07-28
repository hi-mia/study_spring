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
		$.ajax({
			type : 'post',
			url: '/spring/member/write',
			data: {
				'studentId': $('#studentId').val(),
				'name': $('#name').val(),
				'kor': $('#kor').val(),
				'eng': $('#eng').val(),
				'math': $('#math').val()
			},
			dataType: 'text',
			success: function(data){
				if(data == 'success'){
					location.href = '/spring/member/result.jsp';
				}else{
					alert('실패');
				}
			},
			error: function(err){
				console.log(err);
			}
		});
	}
});