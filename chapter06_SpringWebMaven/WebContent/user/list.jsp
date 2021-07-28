<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img alt="브라운" src="../image/smoke.jpg" width="80" height="80">
<table id="table" border="1" cellpadding="3" cellsapcing="0">
	<tr>
		<th width="100">이름</th>
		<th width="100">아이디</th>
		<th width="100">비밀번호</th>
	</tr>
</table>
<br><br>
<div class="search">
	<select name="searchOption" id="searchOption">
		<option value="name">이름</option>
		<option value="id">아이디</option>
	</select>
	<input type="text" id="searchText" name="searchText">
	<button id="searchBtn">검색</button>
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/list.js">
$('#searchBtn').click(function(){
	   $('#searchText').empty();
	   
	   //if(옵션==아이디)
	   $.ajax({
	      type: 'post',
	      url: '/chapter06_SpringWebMaven/user/getUser',
	      data: {'id': $('#searchId').val()},
	      dataType: 'json',
	      success: function(data){
	         //alert(JSON.stringify(data));
	         
	         //if($.isEmptyObject(data))
	         if(JSON.stringify(data) == '{}'){
	          alert('아이디를 입력해주세요');
	            
	         }else{
	        	 $.ajax({
	        			type: 'post',
	        			url: '/chapter06_SpringWebMaven/user/getUserList',
	        			dataType: 'json',
	        			success: function(data){
	        				//alert(JSON.stringify(data));
	        				
	        				var table;
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
	     		
	     	}
	      }
	     	
	     });
});
</script>
</body>
</html>