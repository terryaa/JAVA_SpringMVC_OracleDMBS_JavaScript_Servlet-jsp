package exam1;

public class Exam2_Quiz {
	
	/*
	 * 퀴즈1
	 * 변수 a, b에 값을 각각 3,5로 대입한다.
	 * 그 값을 출력할 때 a = 5, b = 3으로 출력하시오.
	 * 
	 * 퀴즈2
	 * exam3_quiz 클래스를 새롭게 만들어서
	 * name이란 상수에 자신의 이름을 작성하고 나이는 age란 변수에 27 저장
	 * age의 값은 항상 27세보다 적은 만으로 출력하시오
	 * 나의 이름은 김길동입니다
	 * 만으로는 26세입니다
	 * 
	 * 퀴즈3
	 * exam4_quiz 클래스를 새롭게 만들어서
	 * scanner로 자신의 프로필 3개를 입력을 받아서
	 * 각각 문자열의 변수에 지정한 후에
	 * 한번에 출력하시오.
	 * 이름 : 김길동, 나이 : 26, 사는곳 : 서울 금천구 가산동
	 *
	 */

	public static void main(String[] args) {
		//quiz 1
		
		int a = 3;
		int b = 5;
		int c = (int) (a); // c=3
		a = (int) (b); //5 
		b = (int) (c); //3
		
		System.out.println("a = " + a + ", b = " + b);
		
	}
}
