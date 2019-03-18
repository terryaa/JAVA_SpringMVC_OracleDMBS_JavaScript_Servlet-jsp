<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<script>
	$(document).ready(function(){
		$('h1').html(function(index,html){
			console.log(index+":"+html);
			return '☆'+html+'☆';
		});
		//외부 데이터라고 생각하라. 
		var array=['red','green','blue'];
		$('h1').css({
			background:function(index){
				console.log(index);
				return array[index];
				
			}
		});
	});
	</script>
</head>
<body>
<h1>hello</h1>
<h1>hello</h1>
<h1>hello</h1>

</body>
</html>