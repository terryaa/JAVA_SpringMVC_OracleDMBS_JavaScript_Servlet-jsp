package ex2;

public class Ex7_IfElse {
	public static void main(String[] args) {
		
		
		
		/*
		 * ���ǿ� �������� ���ϸ� if���� ������� �ʴ´�.
		 * �׷��� else�� ������ �θ� �� ���� ������ ��� �����ų �� �ִ�.
		 * if(����){���๮1;} 
		 * else{���๮2;}
		 * 
		 */
		
		
		int num = 10;
		int v=0;
		if(num==10){
			//�����Ϸ��� if���� ������ �ȵ� ���� �ִٰ� �����ؼ� if���� �ʱ�ȭ�ϸ� ������ ��
			//���� else���� �ʱ�ȭ ����� ��.(����Ʈ��)
			v = 10;
			System.out.println(num+"���� ��");
			
		}
		else {
		//v = 20;
			System.out.println(num + "���� ��");
		}
		System.out.println(v + "");
		
		//�����Ͽ����� ��.
		//�ʱ�ȭ�� �ؼ� ����ؾ� ��
		// v = 0; �̷������� �ʱ�ȭ�� ������� ��
		
		/*
		 * str1�� str2�� ��ü�� ����Ű�Ƿ� ���� �ڷ����̴�.
		 * ���� str1�� str2�� �ּҸ� �����ϰ� �ְ�
		 * new�� ���� ���� �����Ǿ��� ������ �� �ּҴ� �ٸ���.
		 * ������ ���ϰ� �ʹٸ� equals�� ����ؾ� �Ѵ�.
		 * 
		 * �Ϲ��� ��ü ��������� ���� ������� ��,
		 * ���Ǯ�� �����ϱ� ������
		 * str2������ ���̻� ���ο� ��ü�� �������� �ʰ�
		 * �̹� ������ str1�� ������ �ּҰ��� ���޹޴´�.
		 */
		String str1 = "Test";
		String str2 = "Test";
		
		if(str1 == str2) {
			System.out.println("str1, str2�� �ּҰ� ����.");
			
		}
		else {
			System.out.println("str1, str2�� �ּҰ� �ٸ���.");
		
		}
		
		if(str1.equals(str2)) {
			System.out.println("������ ����");}
		else {
				System.out.println("������ �ٸ���");
			}
		
		
		
		
		
		///////////////////////////////////////
		String val = "���";
		String col = "";
		if(val.contentEquals("���")) {
			col = "Red";
		}
		else if(val.contentEquals("�ٳ���")) {
			col = "Yellow";
		}
		else if(val.contentEquals("������")) {
			col = "Orange";
		}
		else {
			col = "White";
		}
		
		System.out.println(val + "��(��)" +  col + "�� �Դϴ�.");
		
		
		
		////////////////////////////////////////////////
		
		int score = 50;
		String grade ="";
		if(score >=50) {
			grade = "���";
			
		}
		else if(score>= 30) {
			grade = "�߱�";
		}
		else if (score >= 20) {
			grade = "�ʱ�";
			}
		else {
			grade = "����";
		}
		
		System.out.println("����: " + score + "\n ��� : " + grade);
		}
	
	
	///////////////////////////////////////////
		
	}













