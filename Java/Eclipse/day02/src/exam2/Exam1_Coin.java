package exam2;

import java.util.Scanner;

public class Exam1_Coin {
	public static void main(String[] args) {
		Scanner moneys = new Scanner(System.in);
			
		
		
		System.out.println("������ �����ÿ�");
		int money = Integer.parseInt(moneys.nextLine());
		
		//������� 5550�Է�.
		
		int money500 = money/500;
		int money1 = money - money500*500;
		int money100 = money1/100;
		int money2 = money1 - money100*100;
		int money50 = money2/50;
		int money3 = money2 - money50*50;
		int money10 = money3/10;
		int money4 = money3 - money10*10;
		
		System.out.println("500��¥�� ������" + money500);
		System.out.println("100��¥�� ������" + money100);
		System.out.println("50��¥�� ������" + money50);
		System.out.println("10��¥�� ������" + money10);
		
	}
}
