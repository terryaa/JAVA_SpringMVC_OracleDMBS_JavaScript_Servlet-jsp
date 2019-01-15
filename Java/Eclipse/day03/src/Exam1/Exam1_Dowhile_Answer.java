package Exam1;

public class Exam1_Dowhile_Answer {
	public static void main(String[] args) throws InterruptedException {
		int j = 10;
		do {
			System.out.println(j);
			j--;
			Thread.sleep(1000);
		}
		while(j>=0);
	}
}
