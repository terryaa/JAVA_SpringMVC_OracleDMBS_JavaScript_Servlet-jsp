package Exam1;

public class Exam2_DoWhile_Sum {
	public static void main(String[] args) {
		//1���� 10���� ���� do while������ �ϱ�
		int i = 1;
		int sum = 0;
		do {
			sum = i + sum;
			i++;
			
		}
		while (i<=10);
		System.out.println("1~10������ �� :" + sum);
	}
}
