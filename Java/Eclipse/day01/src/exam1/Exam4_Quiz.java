package exam1;

import java.util.Scanner;

public class Exam4_Quiz {
	public static void main(String[] args) {
		Scanner scanname = new Scanner(System.in);
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = scanname.nextLine();
		System.out.print(name);
		
		Scanner scanage = new Scanner(System.in);
		System.out.print("���̸� �Է��ϼ��� : ");
		String age = scanage.nextLine();
		System.out.print(age);
		
		Scanner scanhome = new Scanner(System.in);
		System.out.print("��°��� �Է��ϼ��� : ");
		String home = scanhome.nextLine();
		System.out.print(home);
		
		
		System.out.println("\n �̸� : " + name + " ���� : " + age + " ��°� : " + home);
		
		
		
		
	}

}
 	