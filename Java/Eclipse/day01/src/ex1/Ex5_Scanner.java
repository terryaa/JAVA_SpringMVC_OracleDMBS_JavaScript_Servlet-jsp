package ex1;

import java.util.Scanner;
//자동으로 입력된거임. 외부의 클래스를 불러올 때 사용
public class Ex5_Scanner {
	public static void main(String[] args) {
		//키보드로 입력값을 받기 위한 클래스
		// 생성해서 한번 사용하기. 따라하기만.
		// 참조 자료형 변수명 = new 생성할 클래스명();
		Scanner sc = new Scanner(System.in);
		//system.out = 출력을 의미
		//system.in = 입력을 의미.
		// 참조변수에는 생성된 객체의 주소값이 저장 (100번지)
		System.out.print("입력 :");
		// sc참조 변수를 사용해서 nextline()을 호출해서 입력된 값을 문자열로 반환한다
		String msg = sc.nextLine(); // 사용자로부터 요청이 들어올때까지 기달림. 한줄단위로 입력 후 엔터값 받을 때 까지.
		System.out.println("res : " + msg);
	
	}
}
