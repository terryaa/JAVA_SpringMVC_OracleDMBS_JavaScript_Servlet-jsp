package exam1;

public class Exam1Hello {
	//클래스 영역

	public static void main(String[] args) {
		// 메인 메서드 영역
		System.out.println("안녕하세요");
		System.out.println("저는 신동준입니다.");
		System.out.println("잘부탁드립니다");
		System.out.println("메인 메서드 실행");
		//test 메서드 호출
		test();
		System.out.println("메인 메서드 종료");
	}
	public static void test() { 
		//메서드 영역
		System.out.println("test 메서드를 실행");
	}
}
