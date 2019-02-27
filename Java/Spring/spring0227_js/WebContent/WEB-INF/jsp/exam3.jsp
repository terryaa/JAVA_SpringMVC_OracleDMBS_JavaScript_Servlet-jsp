<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	div{
		width:600px; height:200px;
	}
	.textstyle{
		font-size:14pt;line-height:20pt;margin:10px;
	}
</style>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	var first=$('div>:first-child');
	console.log(first.text());
	//rep(first);
	setInterval(function(){
		if($.trim(first.text())==="five")
			first.css('background','blue');
		else
			first.css('background','grey');
		first=first.next();
	}, 500);
});

function rep(sibling){
	if($.trim(sibling.text())==="five")
		sibling.css('background','blue');
	else
		sibling.css('background','grey');
	rep(sibling.next());
}
</script>
<body>
	<div>
		<em>  one  </em>
		<a>	five	</a>
		<a>	two	</a>
		<a>	three	</a>
		<a>	four	</a>
		<em>	six	</em>
	</div>

</body>
</html>