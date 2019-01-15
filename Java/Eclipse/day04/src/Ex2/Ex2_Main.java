package Ex2;

public class Ex2_Main {

	
	
		public static void main(String[] args) {
			Ex2_MethodDemo ref = new Ex2_MethodDemo();
			
			Ex2_ColorOffice eo1 = new Ex2_ColorOffice();
			Ex2_ColorOffice eo2 = new Ex2_ColorOffice();
			
			//메서드 인자값으로 우리집의 주소를 각각 전달한다면
			//같은 주소를 보고 있다는 개념
			//즉 메서드 호출시 ref 즉 홈의 주소값을 전달하고 있다.
			
			eo1.jobPaint(ref, "노란색");
			eo2.jobPaint(ref, "레드");
			
			System.out.println("색상 확인 : " + ref.viewColor());
			
		}
}
