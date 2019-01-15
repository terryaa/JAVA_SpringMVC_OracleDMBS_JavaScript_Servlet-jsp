package ex2;

import java.util.Scanner;

public class Ex5_MarhRandom {
	public static void main(String[] args) {
		int comNum = (int) (Math.random()*10);
		System.out.println(comNum);
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1~10까지의 숫자중 하나를 입력하세요.");
		
		int systemin = Integer.parseInt(sc.nextLine());
		
		if(systemin == comNum) {
		System.out.println("Cpu의 값 : " + comNum + "입력하신 값 : " + systemin);
		System.out.println("true");
		
		} else {
			System.out.println("Cpu의 값 : " + comNum + "입력하신 값 : " + systemin);
			System.out.println("false");
		}
		
		/*도구 : Scanner , Interger.parseInt(), sout .... random
		 * 사용자 UI :
		 * 1 ~ 10까지의 수치중에서 하나를 입력하세요. : 5
		 * cpu의 값 : 5 / 입력한 값  : 5 / 결과 : 정답입니다.
		 * 비교연산 : A == B가 같으면 true
		 * 1 ~ 10 까지의 숫자중에서 하나를 입력하세요 : 5
		 * CPU의 값 : 8, 입력한 값 : 5 / 결과 : 틀렸습니다.
		 */
		
	}

}
