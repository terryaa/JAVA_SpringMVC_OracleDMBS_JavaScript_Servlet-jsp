package exam2;

import java.util.Scanner;

public class Exam5_GAME {
	public static void main(String[] args) {
		
		
		int i;
		int win = 0 ;
		int lose = 0 ;
		double winrate;

		String cpuanswer;
		Scanner sc = new Scanner(System.in);
		//80~90 �̻��̸� �� �ְڴ�
		//�� ���ϸ� ����.
		//6��� ���ϸ� ��ǰ����.
		
		
		for(i=0; i <= 999999999; i++) {
		//i = ����
			int cpuresult = (int) (Math.random()*2);
			if(cpuresult == 1) {
				cpuanswer = "Ȧ";
			}
			else {
				cpuanswer = "¦";
			}
			
			if(i==0) {
		System.out.println("���� (1-Ȧ, 2-¦, 3-����)");
			}
			if(i>=1) {
		int youanswer = Integer.parseInt(sc.nextLine());
		if(youanswer == 3) {
			System.out.println("���� ����!!");
			System.out.println("��ü ���� �� : " + (i-1));
			System.out.println("�̱� Ƚ�� : " + win);
			winrate = ((win/(i-1))*100);
			double winwin;
			winwin = win;
			double allgame;
			allgame = i-1;
			
			winrate = (winwin/allgame)*100;
			System.out.println("�·� : " + winrate + "%");
			if(i<=6) {
				System.out.println("������");
			}
			else {
				if(winrate >= 80) {
					System.out.println("��ǰ�޾ư�");
				}
				else {
					System.out.println("����.");
				}
			}
			break;
			
		}
		
		System.out.println("--------------------------");
		System.out.println("���� (1-Ȧ, 2-¦, 3-����) :" + youanswer);
		System.out.println("--------------------------");
			System.out.println("No. :" + i);
			System.out.println("CPU :" + cpuanswer);
			
			
		if(youanswer == 1) {
			System.out.println("YOU : Ȧ");
				if(cpuresult==1) {
					System.out.println("WIN");
					win++;
					
				}
				else {
					System.out.println("LOSE");
					lose++;
				}
		}
		if(youanswer == 2) {
			System.out.println("YOU : ¦");
			if(cpuresult == 1) {
				System.out.println("LOSE");
				lose++;
			}
			else{
				System.out.println("WIN");
				win++;
			}
		}
		
		
		
			
		
		
			}
		}
		
	}
}
