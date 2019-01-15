package Exam1;

public class Exam2_DoWhile_Sum {
	public static void main(String[] args) {
		//1부터 10까지 합을 do while문으로 하기
		int i = 1;
		int sum = 0;
		do {
			sum = i + sum;
			i++;
			
		}
		while (i<=10);
		System.out.println("1~10까지의 합 :" + sum);
	}
}
