package ex2;

import java.util.Scanner;

public class Ex6_if {
	public static void main(String[] args) {
		//{}안에는 지역변수라고 한다. 초기화해서 써야 한다.

		int n = 10;
		if(true) {
			
		}
		else {
			System.out.println(n);
		}
		
		
		Scanner s = new Scanner(System.in);
		System.out.println("나이를 입력하세요");
		int num = Integer.parseInt(s.nextLine());
			if(num <= 19) {
				System.out.println("접근 안됨");
			System.exit(0); // 시스템종료
			}
			System.out.println("ㅊㅋ");
		
}
}