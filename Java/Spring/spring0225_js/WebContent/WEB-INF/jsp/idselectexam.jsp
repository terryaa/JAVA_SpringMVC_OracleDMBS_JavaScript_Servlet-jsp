<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<body>

<h2>What Can JavaScript Do?</h2>
<input type="text" name="msg" id="msg" value="¾È³çÇÏ¼¼¿ä">


<p id="demo">JavaScript can change HTML content.</p>

<button type="button" onclick="myfun()">Click Me!</button>

<script>
function myfun(){
	document.getElementById('demo').innerHTML = 
    document.getElementById('msg').value;
}
</script>

</body>
</html>
