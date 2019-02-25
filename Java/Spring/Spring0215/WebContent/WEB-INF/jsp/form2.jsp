<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>form2.jsp</title>
</head>
<body>
<div id="wrap">
		<fieldset>
			<legend>VO 객체 사용하기</legend>
			<form action="upupload" method="post" enctype="multipart/form-data">
			<!-- enctype="multipart/form-data -->
				<p>
				<!-- 
					*oninvalid = setCustomValidity("커스터마이징 메시지")
					[a-z] : 소문자
					[A-Z] : 대문자
					[a-zA-Z]{3} : 총 세문자
					[0-9]숫자
					*
					+
					$ : 끝 문자열
					^ : 시작 문자열
					[^a-zA-Z] : 영문자는 제외
					*oninput : 값이 들어 온 상태를 체크
				 -->
				 	<!-- REQUIRED를 해야 무조건 요구함. 패턴을 읽음 (여기선 영문제외) -->
				 	작성자 <input type="text" name="writer" id="writer"
				 	required="required" pattern="[^a-zA-Z0-9]+"
				 	oninvalid="this.setCustomValidity('한글만 입력')"
					oninput="this.setCustomValidity('')"
					>
					<!-- 감지하고있따가 입력. -->		
					</p>
					<p>
					부서번호 <input type="number" name="title"
					min="10" step="10" max="50"
					required="required"
					>
					</p>
					<p>
					
					<!-- 데이터정리하는곳 -->
						Blog <input type="url" name="content" list="data"
						placeholder="url 입력"
						required="required"						>
					</p>
					<datalist id="data">
						<option>
							http:\\blog.naver.com/javabook
						</option>
						<option>
							http:\\blog.naver.com/whiteshadow
						</option>							
					</datalist>
					
				<p>
					
					<p>
					이미지 파일 : <input name="mfile" id="mfile" type="file">
					</p>
					
					
					<p>
						<input type="submit" value="send">
					</p>
			</form>
		</fieldset>
	
	
	</div>
	

</body>
</html>