package ex2;

import java.util.Scanner;

public class Ex6_if {
	public static void main(String[] args) {
		//{}�ȿ��� ����������� �Ѵ�. �ʱ�ȭ�ؼ� ��� �Ѵ�.

		int n = 10;
		if(true) {
			
		}
		else {
			System.out.println(n);
		}
		
		
		Scanner s = new Scanner(System.in);
		System.out.println("���̸� �Է��ϼ���");
		int num = Integer.parseInt(s.nextLine());
			if(num <= 19) {
				System.out.println("���� �ȵ�");
			System.exit(0); // �ý�������
			}
			System.out.println("����");
		
}
}