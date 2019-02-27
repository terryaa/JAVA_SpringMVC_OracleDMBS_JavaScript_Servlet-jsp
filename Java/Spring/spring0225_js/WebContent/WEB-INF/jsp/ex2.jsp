<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %> 
<c:set var="resImg" value="resources/img"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- 
<button onclick="document.getElementById('myImage').src='pic_bulbon.gif'">Turn on the light</button>

<img id="myImage" src="${resImg }/pic_bulboff.gif" style="width:100px">

<button onclick="document.getElementById('myImage').src='pic_bulboff.gif'">Turn off the light</button>

 -->
 <p id="target">
 	<img id="myImage" src="${resImg }/pic_bulboff.gif" style="width:100px">
 </p>
 <button id="onBtn"> Turn on</button> 
 <button id="offBtn"> Turn off</button> 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script>
	$(function(){
		$('#onBtn').click(function(){
			imgOnoff(1)
		});
		$('#offBtn').click(function(){
			imgOnoff(2)
		});
	})
 
 
 	function imgOnoff(idx){
		let paths="";
 		if(idx===1){
 			console.log("1");
 			//1.첫번쨰 방법 img 태그 자체를 입력한다.
//  			let imgPath="<img id='myImage' src='${resImg}/pic_bulbon.gif' style='width:100px'>"
//  			$('#target').html(imgPath);
 			//----------JS
 		
//  			document.getElementById('target').innerHTML =
//  				"<img id='myImage' src='${resImg}/pic_bulbon.gif' style='width:100px'>";
 				
 			paths="${resImg}/pic_bulbon.gif";
 		}else{
 			console.log("2");
//  			let imgPath="<img id='myImage' src='${resImg}/pic_bulboff.gif' style='width:100px'>"
//  			$('#target').html(imgPath);
//  			document.getElementById('target').innerHTML =
//  				"<img id='myImage' src='${resImg}/pic_bulboff.gif' style='width:100px'>";
 				
 			paths="${resImg}/pic_bulboff.gif";
 		}
 		$('#myImage').attr('src',paths);
 		
 	}
 </script>
</body>
</html>