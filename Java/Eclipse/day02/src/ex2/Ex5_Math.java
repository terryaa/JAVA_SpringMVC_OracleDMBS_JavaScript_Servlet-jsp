package ex2;

import java.util.Scanner;

public class Ex5_Math {
	public static void main(String[] args) {
		Scanner scA = new Scanner(System.in);
		System.out.println("A�� ���� �Է��ϼ���");
		String numAA = scA.nextLine();
		
        int numAAInt = Integer.parseInt(numAA);
		
		Scanner scB = new Scanner(System.in);
		System.out.println("B�� ���� �Է��ϼ���");
		String numBB = scB.nextLine();
		
		int numBBInt = Integer.parseInt(numBB);
		
		int numA =  numAAInt;
		int numB = numBBInt;
		
		/*
		 * ����
		 * Scanner sc = new Scanner(System.in);
		 * int numA = Integer.parseInt(sc.nextLine());	
		 */
		int resNum1 = numA + numB;
		int resNum2 = numA * numB;
		int resNum3 = numA - numB;
		int resNum4 = numA / numB;
		int resNum5 = numA % numB;
		System.out.println(resNum1);
		System.out.println("���:"+resNum1);
		System.out.println("����:" + (numA == numB));
		System.out.println("���:" + resNum2);
		System.out.println("���:" + (numA != numB));
		System.out.println("���:" + resNum3);
		System.out.println("ũ��, ũ�ų� ���� :" 
							+ (numA > numB)+","+(numA >= numB));
		System.out.println("�۴�, �۰ų� ����:" 
							+ (numA < numB)+","+(numA <= numB));
		System.out.println("���:" + resNum4);
		System.out.println("���:" + resNum5);
	
	}

}
