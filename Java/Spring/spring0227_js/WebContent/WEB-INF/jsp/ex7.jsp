<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {

		setInterval(function(){ 
			$('tr:odd').css("background", "pink");
			$('tr:even').css("background", "yellow");
			
		}, 300);
		setInterval(function(){
			$('tr:odd').css("background", "yellow");
			$('tr:even').css("background", "pink");
		},500);
		
	});
</script>
</head>
<body>
	<table>
		<c:forEach var="i" begin="0" end="9" step="1">
			<tr>
				<td>${i }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>