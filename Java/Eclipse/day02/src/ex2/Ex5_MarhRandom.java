package ex2;

import java.util.Scanner;

public class Ex5_MarhRandom {
	public static void main(String[] args) {
		int comNum = (int) (Math.random()*10);
		System.out.println(comNum);
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1~10������ ������ �ϳ��� �Է��ϼ���.");
		
		int systemin = Integer.parseInt(sc.nextLine());
		
		if(systemin == comNum) {
		System.out.println("Cpu�� �� : " + comNum + "�Է��Ͻ� �� : " + systemin);
		System.out.println("true");
		
		} else {
			System.out.println("Cpu�� �� : " + comNum + "�Է��Ͻ� �� : " + systemin);
			System.out.println("false");
		}
		
		/*���� : Scanner , Interger.parseInt(), sout .... random
		 * ����� UI :
		 * 1 ~ 10������ ��ġ�߿��� �ϳ��� �Է��ϼ���. : 5
		 * cpu�� �� : 5 / �Է��� ��  : 5 / ��� : �����Դϴ�.
		 * �񱳿��� : A == B�� ������ true
		 * 1 ~ 10 ������ �����߿��� �ϳ��� �Է��ϼ��� : 5
		 * CPU�� �� : 8, �Է��� �� : 5 / ��� : Ʋ�Ƚ��ϴ�.
		 */
		
	}

}
