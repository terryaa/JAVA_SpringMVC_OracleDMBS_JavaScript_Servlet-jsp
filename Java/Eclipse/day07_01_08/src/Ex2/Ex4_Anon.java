package Ex2;

public class Ex4_Anon {

	/*
	 * 익명은 참조 주소가 없이 객체를 생성하는 것을 의미하는데
	 * 익명 내부클래스는 인터페이스, 추상클래스를 new 연산자로 생성할 수 없고
	 * 익명 내부클래스로 정의한 후 자원을 호출하는 형태이다.
	 * 그 외에 일반 클래스도 익명 내부클래스를 만들어서 사용할 수 있따.
	 */
		//멤버영역에서 익명 내부클래스를 정의
		//익명 = 클래스 이름 자체가 없어서 익명인 것임.
		MyTest test = new MyTest() { //뉴 연산자는 번지생성
			
			@Override
			public void printData() {
				System.out.println("data2:" + data);
				
			}
		};
		public Ex4_Anon() {
			test.printData();
			
		}
		public void mytest() {
			//로컬 내부클래스 영역에서 사용이 됨
			new MyTest() {
				
				@Override
				public void printData() {
					System.out.println("data:" + data);
					
				}
			}.printData();
		}
		public static void main(String[] args) {
			//참조자료형, 변수 없이 바로 생성 후 메서도 호출
			//new Ex4_Anon().mytest();
			Ex4_Anon ref = new Ex4_Anon();
			ref.mytest();
		}
}
