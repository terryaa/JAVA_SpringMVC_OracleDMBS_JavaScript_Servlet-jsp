package exam2;

import java.util.Scanner;

public class Exam3_AppleBusket {
	
	public static void main(String[] args) {
		//����� ��µ� �ʿ��� �ٱ���(����)�� ����
		//���� ����� ���� n���̰� �ϳ��� �ٱ��Ͽ��� 10���� ����� ���� �� �ִٸ�
		//13���� �ٱ��ϰ� �ʿ��� ���̴�.
		
		Scanner sc = new Scanner(System.in);
		int apple = Integer.parseInt(sc.nextLine());
		int n = apple/10;
		
		for(int i = 0; i<=n; i++) {
			if(apple >=10) {
				n++;
				apple = apple - 10;
			}
			
			else {
				System.out.println("�ٱ����� ������ : " + n);
			}
			
			
		}
	}
		
		
		//����� ������ 123�Է�
		//�ٱ��ϰ� �ʿ��� ���� = 10��
		// ����� ���� 200��
		// �ٱ��� �ʿ��� ���� 20��
	}


