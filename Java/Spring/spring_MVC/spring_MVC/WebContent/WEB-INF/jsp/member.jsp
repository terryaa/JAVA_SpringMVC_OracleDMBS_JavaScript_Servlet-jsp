<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>member.jsp</title>
<style>
#target {
	color: red;
	background-color: yellow;
	width: 50%;
	font-size: 18px;
	/* ���� �Ӽ� */
	display: none;
}
</style>
</head>
<body>
	<div id="content">
		<form method="post" action="memberjoin" id="memF">
			<fieldset>
				<legend>ȸ������ ��</legend>
				<p>
					<label>���̵�</label> 
					<input type="text" name="id" id="id">
					&nbsp;
					<input type="button" id="idChkBtn"
					value="�ߺ�Ȯ��">
				</p>
				<p id="target">�̹� ������� ���̵� �Դϴ�.</p>
				<p>
					<label>��й�ȣ</label>
					 <input type="password" name="pwd" id="pwd">
				</p>
				<p>
					<label>�̸�</label> 
					<input type="text" name="name" id="name">
				</p>
				<p>
					<label>��ȭ��ȣ</label> 
					<input type="text" name="tel" id="tel">
				</p>
				<p>
					<label>�����ȣ</label>
					 <input type="text" id="post" name="post"> 
					 <input
						type="button" id="postBtn" 
						value="�����ȣ ã��" >
				</p>
				<p>
					<label>�ּ�</label> 
					<input type="text" id="addr1" name="addr1">
				</p>
				<p>
					<label>�� �ּ�</label> 
					<input type="text" id="addr2" name="addr2">
				</p>
				<p>
					<input type="submit" value="ȸ������">
				</p>
			</fieldset>
		</form>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	$(function(){
		$('#postBtn').click(function(){
			 execDaumPostcode();
		});
		// ȸ�� ���̵� �ߺ�Ȯ��!
		$('#idChkBtn').click(function(){
			$.ajax({
				url:"idcheck?id="+$('#id').val(),
				success:function(data){
					if(data == 0){
						$('#target').show().css("color","blue").text("��밡��");
					}else{
						$('#target').show().css("color","red").text("�����");
					}
					
				}		
				
			});
		});
		
		
		function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // �˾����� �˻���� �׸��� Ŭ�������� ������ �ڵ带 �ۼ��ϴ� �κ�.

                // �� �ּ��� ���� ��Ģ�� ���� �ּҸ� �����Ѵ�.
                // �������� ������ ���� ���� ��쿣 ����('')���� �����Ƿ�, �̸� �����Ͽ� �б� �Ѵ�.
                var fullAddr = ''; // ���� �ּ� ����
                var extraAddr = ''; // ������ �ּ� ����

                // ����ڰ� ������ �ּ� Ÿ�Կ� ���� �ش� �ּ� ���� �����´�.
                if (data.userSelectedType === 'R') { // ����ڰ� ���θ� �ּҸ� �������� ���
                    fullAddr = data.roadAddress;

                } else { // ����ڰ� ���� �ּҸ� �������� ���(J)
                    fullAddr = data.jibunAddress;
                }

                // ����ڰ� ������ �ּҰ� ���θ� Ÿ���϶� �����Ѵ�.
                if(data.userSelectedType === 'R'){
                    //���������� ���� ��� �߰��Ѵ�.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // �ǹ����� ���� ��� �߰��Ѵ�.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // �������ּ��� ������ ���� ���ʿ� ��ȣ�� �߰��Ͽ� ���� �ּҸ� �����.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // �����ȣ�� �ּ� ������ �ش� �ʵ忡 �ִ´�.
                document.getElementById('post').value = data.zonecode; //5�ڸ� �������ȣ ���
                document.getElementById('addr1').value = fullAddr;

                // Ŀ���� ���ּ� �ʵ�� �̵��Ѵ�.
                document.getElementById('addr2').focus();
            }
        }).open();
    }
	});
   
</script>
</html>