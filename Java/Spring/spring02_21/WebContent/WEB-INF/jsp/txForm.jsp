<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jQuery</title>
</head>
<body>
	<div id="article">
		<div id="header2">
			<h1> uri: jQuery : </h1><p id="time">2019.02.20.</p>
		</div>
		<div id="content">
			<div style="width: 450px; margin: auto;">
				<form method="post" action="testTx">
					<fieldset>
						<legend>Ʈ����� ó�� ���� ��</legend>
						<p><label>ID(Unique)</label><input type="text" name="id"></p>
						<p><label>PWD</label><input type="password" name="password"></p>
						<p><label>Name</label><input type="text" name="name"></p>
						<p><label>Address</label><input type="text" name="address"></p>
						<p><label>SSN(Unique)</label><input type="text" name="ssn"></p>
						<p><input type="submit" value="�Է�"></p>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>