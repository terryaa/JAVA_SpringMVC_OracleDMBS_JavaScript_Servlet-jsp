package Ex2;

public class Ex2_Main {

	
	
		public static void main(String[] args) {
			Ex2_MethodDemo ref = new Ex2_MethodDemo();
			
			Ex2_ColorOffice eo1 = new Ex2_ColorOffice();
			Ex2_ColorOffice eo2 = new Ex2_ColorOffice();
			
			//�޼��� ���ڰ����� �츮���� �ּҸ� ���� �����Ѵٸ�
			//���� �ּҸ� ���� �ִٴ� ����
			//�� �޼��� ȣ��� ref �� Ȩ�� �ּҰ��� �����ϰ� �ִ�.
			
			eo1.jobPaint(ref, "�����");
			eo2.jobPaint(ref, "����");
			
			System.out.println("���� Ȯ�� : " + ref.viewColor());
			
		}
}
