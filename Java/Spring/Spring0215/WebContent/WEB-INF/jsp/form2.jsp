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
			<legend>VO ��ü ����ϱ�</legend>
			<form action="upupload" method="post" enctype="multipart/form-data">
			<!-- enctype="multipart/form-data -->
				<p>
				<!-- 
					*oninvalid = setCustomValidity("Ŀ���͸���¡ �޽���")
					[a-z] : �ҹ���
					[A-Z] : �빮��
					[a-zA-Z]{3} : �� ������
					[0-9]����
					*
					+
					$ : �� ���ڿ�
					^ : ���� ���ڿ�
					[^a-zA-Z] : �����ڴ� ����
					*oninput : ���� ��� �� ���¸� üũ
				 -->
				 	<!-- REQUIRED�� �ؾ� ������ �䱸��. ������ ���� (���⼱ ��������) -->
				 	�ۼ��� <input type="text" name="writer" id="writer"
				 	required="required" pattern="[^a-zA-Z0-9]+"
				 	oninvalid="this.setCustomValidity('�ѱ۸� �Է�')"
					oninput="this.setCustomValidity('')"
					>
					<!-- �����ϰ��ֵ��� �Է�. -->		
					</p>
					<p>
					�μ���ȣ <input type="number" name="title"
					min="10" step="10" max="50"
					required="required"
					>
					</p>
					<p>
					
					<!-- �����������ϴ°� -->
						Blog <input type="url" name="content" list="data"
						placeholder="url �Է�"
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
					�̹��� ���� : <input name="mfile" id="mfile" type="file">
					</p>
					
					
					<p>
						<input type="submit" value="send">
					</p>
			</form>
		</fieldset>
	
	
	</div>
	

</body>
</html>