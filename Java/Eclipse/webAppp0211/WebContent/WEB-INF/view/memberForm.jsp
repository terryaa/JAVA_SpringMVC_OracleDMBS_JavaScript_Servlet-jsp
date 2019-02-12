<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>memberForm.jsp</title>
<style type="text/css">
#content {
	margin: auto;
	width: 450px;
}
#content fieldset {
	width: 100%;
}
input{
	background-color: #f0fccb;
}
</style>
<script>
function checkMemberId(){
	
	//for안에 input태그 속성중에 id속성 을 가져온다. 
	//id를 기준으로 객체를 가져온다.
	//자바는 html을 객체로생각하기떄문에 document. 이있는것이다.
	let idv=document.getElementById("id");
	alert("중복확인 버튼!"+idv.value);
	
}
</script>

</head>
<body>
<div id="content">
		<form method="post" action="test.kosta" id="memberForm">
		<input type="hidden" name="cmd"  value="memIn">
			<fieldset>
				<legend>Member Join</legend>
				<p>
					<label>ID : </label> 
					<input name="id" id="id">
					<input type="button" value="중복확인" onclick="checkMemberId()">
				</p>
				<p>
					<label>PWD : </label> <input type="password" name="pwd" id="pwd">
				</p>
				<p>
					<label>Name : </label> <input name="name" id="name">
				</p>
				<p>
					<label>email : </label> <input name="email" id="email">
				</p>
				<p>
					<label>tel : </label> <input name="tel" id="tel">
				</p>
				<p>
					<input type="submit">
				</p>
			</fieldset>
		</form>
		<textarea rows="" cols="">
		<Context>
	<Resource name="jdbc/myora"
		auth="Container"
		type="javax.sql.DataSource"
		driverClassName="oracle.jdbc.driver.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe"
		username="bigdate"
		password="big"
		maxActive="20"
		maxIdle="10"
		maxWait="-1"
	/>
</Context>
		</textarea>
	</div>
</body>
</html>