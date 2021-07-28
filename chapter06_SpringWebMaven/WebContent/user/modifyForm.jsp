<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>수정할 아이디 입력 : <input type="text" id="searchId">
<input type="button" id="searchBtn" value="검색">
<br><br>
<div id="resultDiv"></div>
<br><br>
<div id="modifyFormDiv">
<form id="modifyForm">
   <table border="1" cellpadding="3" cellspacing="0">
      <tr>
         <td width="100" align="center">이름</td>
            <td>
               <input type="text" name="name" id="name">
                  <div id="nameDiv"></div>
         </td>
      </tr>
      
      <tr>
         <td width="100" align="center">아이디</td>
            <td>
               <input type="text" name="id" id="id" readonly>
               <div id="idDiv"></div>
         </td>
      </tr>
      
      <tr>
         <td width="100" align="center">비밀번호</td>
            <td>
               <input type="password" name="pwd" id="pwd">
                  <div id="pwdDiv"></div>
         </td>
      </tr>
      <tr>
         <td colspan="2" align="center">
            <input type="button" value="회원정보수정" id="modifyBtn">
            <input type="reset" id="resetBtn" value="다시작성">
         </td>
      </tr>
   </table>
</form>
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
   $('#modifyFormDiv').hide();
   
   $('#resetBtn').click(function(){
	   $('#searchBtn').trigger('click');//강제로 이벤트 발생 / 트리거는 많이 쓴다!
   });
   
   $('#searchBtn').click(function(){
      $('#resultDiv').empty();
      
      $.ajax({
         type: 'post',
         url: '/chapter06_SpringWebMaven/user/getUser',
         data: {'id': $('#searchId').val()},
         dataType: 'json',
         success: function(data){
            //alert(JSON.stringify(data));
            
            //if($.isEmptyObject(data))
            if(JSON.stringify(data) == '{}'){
               $('#resultDiv').text('수정할 아이디가 없습니다');
               $('#resultDiv').css('color', 'red');
               $('#resultDiv').css('font-size', '10pt');
               $('#resultDiv').css('font-weight', 'bold');
               
            }else{
               $('#modifyFormDiv').show();
               
               $('#name').val(data.name);
               $('#id').val(data.id);
               $('#pwd').val(data.pwd);
            }
         },
         error: function(err){
            console.log(err);
         }
      });
   });
 //회원정보 수정
   $('#modifyBtn').click(function(){
	   	$('#nameDiv').empty();
	   	$('#pwdDiv').empty();
   	

   	if($('#name').val() == ''){ // name의 값을 가져와라
   		$('#nameDiv').text("이름 입력");
   		$('#nameDiv').css('color', 'red');
   		$('#nameDiv').css('font-size', '8pt');
   		$('#nameDiv').css('font-weight', 'bold');
   		
   	}else if($('#pwd').val() == ''){
   		$('#pwdDiv').text("비밀번호 입력");
   		$('#pwdDiv').css('color', 'red');
   		$('#pwdDiv').css('font-size', '8pt');
   		$('#pwdDiv').css('font-weight', 'bold');
   		}else{
   			//$('#modifyForm').submit(); //화면이동
   			$.ajax({
   				type: 'post',
   				url: '/chapter06_SpringWebMaven/user/modify',
   				data: $('#modifyForm').serialize(), //문자열 "name=홍길동&id=hong&pwd=111" / 문자열로 넘겨줌
   				success: function(){
   					alert('회원 정보 수정 완료');
   					location.href='/chapter06_SpringWebMaven/index.jsp';
   				},
   				error: function(err){
   		            console.log(err);
   		         }
   			});
   		}
   });
});



</script>
</body>
</html>