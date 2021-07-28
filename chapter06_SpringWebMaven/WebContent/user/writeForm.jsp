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
<h3>회원가입</h3>
<form id="writeForm">
<table border="1" cellpadding="5" cellspacing="0">
	<tr>
	 <td align="center">이름</td>
	 <td>
	 	<input type="text" name="name" id="name" placeholder="이름 입력">
	 	<div id="nameDiv"></div>
	 </td>
	</tr>

	<tr>
	 <td align="center">아이디</td>
	 <td>
	 	<input type="text" name="id" id="id">
	 	<input type="button" id="checkIdBtn" value="중복체크" src="../js/user.js">
	 	<div id="idDiv"></div>
	 </td>
	</tr>
	
	<tr>
	 <td align="center">비밀번호</td>
	 <td>
	 	<input type="password" name="pwd" id="pwd">
	 	<div id="pwdDiv"></div>
	 </td>
	</tr>
	<tr>
	 <td colspan="2" align="center">
	  <input type="button" value="회원가입" id="writeBtn">
	  <input type="reset" value="다시작성">
	 </td>
	</tr>
</table>
<br><br>
<div id="writeResult"></div>
</form>
</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/user.js"></script> <!-- js에 있는 내용을 끌어올 것이다 -->

</body>
</html>

<!-- 
중복확인
writeForm.jsp(View)수정 - 스크립트로 function 넣어주기 - UserService 인터페이스 수정, UserServiceImpl 수정
- 매퍼 수정 - 컨트롤러 수정

 -->