<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<!-- 
Jquery 함수필터선택자
contains(" ")  : 문자열을 포함하는 문서객체선택
eq(n) : n번쨰 위치하는 문서객체선책
gt(n) : n번쨰 초과위치하는문서객체선택
has(h1) : h1태그를 가지고 있는 문서 객체를 선택
lt(n) : n번째 미만에위치하는 문서객체를선택
not(선택자) : 선택자와일치하지않는문서객체를선택
nth-child(n):n번쨰위치하는문서객체선택
 -->
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('div p:contains("Test")').css("background","pink");
		//div안에 있는 모든 요소에서 Test문자열을 포함할떄
		$('div p:gt(0)').css("background","red");
		$('div:has("h1")').css({'background':'yellow', 'border':'1px'});
		$('p:nth-child(2n+1)').css('background','green');
		console.log($('div div h1').text());
		//== console.log('div>div').children().text());
		console.log($('div p:eq(1)').text());
		console.log($('#test1').next().text());
		console.log($('#target').parent().prev().text());
		console.log($.trim($('#target').parent().prev().text()));
	});
		
</script>
<div>
	<p>Test</p>
	<p id="test1">test it is</p>
	<p>thur</p>
	<p>fri</p>
	<p>sat</p>
	<p>sub</p>
	<p>mon</p>
	<p>tues</p>
	<h1>jQuerytest</h1>
	<div>
		<h1 id="target">jQUerytest2</h1>
	</div>
	
</div>

</body>
</html>