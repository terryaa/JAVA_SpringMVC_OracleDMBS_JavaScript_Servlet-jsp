package Ex2;

import java.util.Scanner;

public class Ex3_Main2 {
	//2. Ex3_remocon Ŭ������ ��ü�� ��������.
	//�����ڷ��� �������� = new ������ ��ü();
	//���ÿ��� ����� ex3_remocon�� ���� �ڷ������� �� ���� er����
	//heap������ new �����ڷ� ������ ��ü�� �ּ�(100)�� ����Ǿ� �ִ�.
	//�׷ιǷ� er������ EX3_Remocon ��ü�� �����ؼ� ����� �� �ִ�.

	public static void main(String[] args) {
		Ex3_Remocon er = new Ex3_Remocon();
		// 3. UI
		Scanner sc = new Scanner(System.in);
				while(true) {
					System.out.println("�����ѱ� 1, �������� 2 : ");
					String powerMsg = sc.nextLine();
					if(powerMsg.contentEquals("1")) {
						er.setPower(true);
					}
					else if(powerMsg.equals("2")) {
						er.setPower(false);
						
					}else {
						System.out.println("�߸��� ��ȣ�Դϴ�.");
					}
				}
	}
}
