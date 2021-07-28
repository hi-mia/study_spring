//회원가입
$('#writeBtn').click(function(){
	$('#nameDiv').empty();
	$('#idDiv').empty();
	$('#pwdDiv').empty();
	
	if($('#name').val() == ''){ // name의 값을 가져와라
		$('#nameDiv').text("이름 입력");
		$('#nameDiv').css('color', 'red');
		$('#nameDiv').css('font-size', '8pt');
		$('#nameDiv').css('font-weight', 'bold');
	}else if($('#id').val() == ''){
		$('#idDiv').text("아이디 입력");
		$('#idDiv').css('color', 'red');
		$('#idDiv').css('font-size', '8pt');
		$('#idDiv').css('font-weight', 'bold');
	}else if($('#pwd').val() == ''){
		$('#pwdDiv').text("비밀번호 입력");
		$('#pwdDiv').css('color', 'red');
		$('#pwdDiv').css('font-size', '8pt');
		$('#pwdDiv').css('font-weight', 'bold');
	}else {
		//action을 타고 페이지 이동
		//$('#writeForm').submit();
		//document.writeForm.submit();//자바스크립트 문법
		
		//ajax 연동 - 페이지 이동X
		$.ajax({
			url:'/chapter06_SpringWebMaven/user/write',
			type: 'post',
			data: {'name': $('#name').val(),  //'번수': 값
					'id': $('#id').val(),
					'pwd': $('#pwd').val()},
			//dataType은 필요 없다		
			success: function() {
				alert('회원 가입 등록');
			},
			error: function(err) {
				console.log(err);
				alert('회원 가입 실패');
			}
		}); //디스패처로 가면 안 된다
	}
});

//아이디 유효성 검사
$('#checkIdBtn').click(function(){
	$('#idDiv').empty();
	
	if($('#id').val() == ''){
	$('#idDiv').text("먼저 아이디 입력하세요");
	$('#idDiv').css('color', 'red');
	$('#idDiv').css('font-size', '8pt');
	$('#idDiv').css('font-weight', 'bold');
	}else {$.ajax({
		url:'/chapter06_SpringWebMaven/user/checkId',
		type: 'post',
		data:  'id=' + $('#id').val(),
		dataType: "text",
		success: function(data) {
			if(data == 'exist'){
				$('#idDiv').text("존재하는 아이디입니다");
				$('#idDiv').css('color', 'red');
				$('#idDiv').css('font-size', '8pt');
				$('#idDiv').css('font-weight', 'bold');
			}else if(data == 'non_exist'){
				$('#idDiv').text("사용가능한 아이디입니다");
				$('#idDiv').css('color', 'blue');
				$('#idDiv').css('font-size', '8pt');
				$('#idDiv').css('font-weight', 'bold');
			}
			
		},
		error: function(err) {
			console.log(err);
			alert('회원 가입 실패');
		}
	
	}); //디스패처로 가면 안 된다
		} //if
});