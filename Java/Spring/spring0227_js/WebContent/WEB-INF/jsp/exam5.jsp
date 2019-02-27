<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<script>
	//each()는 jQuery를 사용해서 배열을 관리하려고 할 사용하는 메서드이다. object같은 상위객체느낌.
	//$.each(배열객체,function(index,item){});
	//$.(selector).each(function(index,item){});
	
	var array=[
		{name:'김길동',addr:'서울 신촌'},
		{name:'길승아',addr:'서울 신촌'},
		{name:'이지현',addr:'서울 구로'}
	];
	
	
	$(function(){
		var addMember={
				name:"박정아",addr:"서울 가산"
		};
		array.push(addMember);
		$.each(array,function(idx,item){
// 			var print='';
// 			print +="<h1>["+item.addr+"]"+" "+item.name+"</h1>";
// 			document.getElementById("res").innerHTML+=print;
			$('#res').append("<h1> ["+item.addr+"]"+" "+item.name+"</h1>");
			$('#res h1').addClass("h");
		});
		//select자리에는 id는 들어오지말아야하고 tag가들어와야한다.
		$('p').each(function(index,item){
			$(item).addClass('t');
			$(this).append(":"+array[index].name);
		});
	});
	
</script>
<style>
	.h{background:orange;}
	.t{background:pink;}
</style>
<body>
	<div id="res">
		<h1>hello world!</h1>
		<p>test1</p>
		<p>test2</p>
		<p>test3</p>
	</div>

</body>
</html>