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
	//each()�� jQuery�� ����ؼ� �迭�� �����Ϸ��� �� ����ϴ� �޼����̴�. object���� ������ü����.
	//$.each(�迭��ü,function(index,item){});
	//$.(selector).each(function(index,item){});
	
	var array=[
		{name:'��浿',addr:'���� ����'},
		{name:'��¾�',addr:'���� ����'},
		{name:'������',addr:'���� ����'}
	];
	
	
	$(function(){
		var addMember={
				name:"������",addr:"���� ����"
		};
		array.push(addMember);
		$.each(array,function(idx,item){
// 			var print='';
// 			print +="<h1>["+item.addr+"]"+" "+item.name+"</h1>";
// 			document.getElementById("res").innerHTML+=print;
			$('#res').append("<h1> ["+item.addr+"]"+" "+item.name+"</h1>");
			$('#res h1').addClass("h");
		});
		//select�ڸ����� id�� ���������ƾ��ϰ� tag�����;��Ѵ�.
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