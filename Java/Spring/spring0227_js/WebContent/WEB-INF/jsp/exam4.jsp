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
�����ϰ� ����� ȣ���Ѵٴ���.. -->
<script>
$(document).ready(function(){
	/*fileter():���� ��ü�� Ž�� �� ���͸��Ѵ�.
	//$(select).filter(selector);
	//$(select).filter(function(index){});
	*/
	//1.�������ߴ� Ȧ����Ҹ� ã�Ƽ� ���� ��ü�� ������ �����غ���.
	$('tr:odd').css({backgroundColor:'orange',color:'red'});
	//2.filter�޼����� ���ڰ��� even�� ����Ҽ��ִ�.
	$('tr').filter(':even').css({backgroundColor:'yellow',color:'blue'});
	//filter�� �ƴѰ��� ����? callback�Լ��� �����ִ�.
	//-> 3d�ǹ���μ����غ���
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