<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">

  <title>input</title>
 </head>
 <body>
 <form  method="" action="result.do">
  <table border="1">
   <tr>
    <td align = "center", width = "70">X</td>
    <td width = "200">
      <input type="text" name="x" placeholder="X 입력" size="12">
    </td>
   </tr>

   <tr>
   <td align = "center">Y</td>
    <td>
      <input type="text" name="y" placeholder="Y 입력" size="12">
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

<!-- 데이터를 dto안에다 보관(=사물함 보관)하고 그걸 꺼내서 사용 -->