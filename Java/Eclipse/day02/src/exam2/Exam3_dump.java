package exam2;

import java.util.Scanner;

public class Exam3_dump {


public static void main(String[] args) {
	//����� ��µ� �ʿ��� �ٱ���(����)�� ����
	//���� ����� ���� n���̰� �ϳ��� �ٱ��Ͽ��� 10���� ����� ���� �� �ִٸ�

	//13���� �ٱ��ϰ� �ʿ��� ���̴�.
	
	Scanner sc = new Scanner(System.in);
	int apple = Integer.parseInt(sc.nextLine());
	
	int basketahrt = apple/10;
	int basketskajwl = apple%10;
	
	System.out.println("apple�� ������ : " + apple);
	System.out.println("basket�� ���� : " + basketahrt);
	System.out.println("basket�� " + basketskajwl);
	
	int basketresult = (basketskajwl <= 0) ? basketahrt : basketahrt+1;
	
	
	System.out.println("�ٱ����� �� ������" + basketresult);
	
	
	//����� ������ 123�Է�
	//�ٱ��ϰ� �ʿ��� ���� = 10��
	// ����� ���� 200��
	// �ٱ��� �ʿ��� ���� 20��
}
}