<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">

  <title>input</title>
 </head>
 <body>
 <form  method="post" action="/chapter06_1/sungJuk/result.do"> <!-- namespace도 붙여줘야 한다 -->
  <table border="1">
   <tr>
    <td align = "center", width = "70">이름</td>
    <td width = "200">
      <input type="text" name="name" placeholder="이름 입력" size="12">
    </td>
   </tr>

   <tr>
   <td align = "center">국어</td>
    <td>
      <input type="text" name="kor" placeholder="국어 점수 입력" size="12">
    </td>
   </tr>
   
   <tr>
   <td align = "center">영어</td>
    <td>
      <input type="text" name="eng" placeholder="영어 점수 입력" size="12">
    </td>
   </tr>
   
   <tr>
   <td align = "center">수학</td>
    <td>
      <input type="text" name="math" placeholder="수학 점수 입력" size="12">
    </td>
   </tr>

   <tr>
    <td colspan="2" align="center">
      <input type="submit" value="계산">
      <input type="reset" value="취소">
    </td>
   </tr>
  </table>
  </form>
 </body>
</html>