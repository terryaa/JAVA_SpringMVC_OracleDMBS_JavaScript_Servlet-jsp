<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- 
필터하고 펑션을 호출한다던가.. -->
<script>
$(document).ready(function(){
	/*fileter():문서 객체를 탐색 및 필터링한다.
	//$(select).filter(selector);
	//$(select).filter(function(index){});
	*/
	//1.예전에했던 홀수요소만 찾아서 문서 객체의 생상을 변경해보자.
	$('tr:odd').css({backgroundColor:'orange',color:'red'});
	//2.filter메서드의 인자값에 even을 사용할수있다.
	$('tr').filter(':even').css({backgroundColor:'yellow',color:'blue'});
	//filter와 아닌것의 차이? callback함수를 쓸수있다.
	//-> 3d의배수로수정해보기
	$('tr').filter(function(index){
		console.log(index);
		if((index%3)===0){
			$(this).css({backgroundColor:'pink',color:'blue'});
		}
	});
	
});
</script>
</head>
<body><div id="wrap">
<table><% for(int i=0;i<10;i++) { %>
<tr>
<td>value: <%=i %> </td>
</tr>
<%} %>

</table>
</div>

</body>
</html>