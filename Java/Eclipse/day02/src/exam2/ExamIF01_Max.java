package exam2;

import java.util.Scanner;

public class ExamIF01_Max {
	public static void main(String[] args) {
		
		// �Է� ���� ���� 3�������� �ִ밪�� ���
		
		Scanner nums = new Scanner(System.in);
		int num1 = Integer.parseInt(nums.nextLine());

		System.out.println("num1 : " + num1);
		int num2 = Integer.parseInt(nums.nextLine());
		System.out.println("num2 : " + num2);
		int num3 = Integer.parseInt(nums.nextLine());
		System.out.println("num3 : " + num3);
		
		
		
		/*if(num1 >= num2) {
			System.out.println("�ִ밪 : " + num1);
		}
		else if(num1 >= num3) {
			System.out.println("�ִ밪 : " + num1);
		}
		else if (num2 >= num3) {
			System.out.println("�ִ밪 : " + num2);
		}
		else {
			System.out.println("�ִ밪 : " + num3);
		}
		*/
		
		int max = num1;
		if ( max < num2) max = num2;
		if (max < num3) max = num3;
		
		System.out.println("�ִ밪" + max);
	}

}
