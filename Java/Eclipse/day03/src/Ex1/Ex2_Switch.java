package Ex1;

public class Ex2_Switch {
	public static void main(String[] args) {
		// jdk 7부터 String 문자열 비교 지원
		String s = "B";
		boolean b = true;
		char ch = 'A';
		float f = 3.14F;
		byte bb = 10;
		double bn = 10.1;
		long ll = 10L;
		switch(s) { //case "조건"; 실행; break;
		case "A" :
			System.out.println("문자열A");
			break;
		case "B" :
			System.out.println("문자열 B");
			break;
		default :
			System.out.println("없는 문자열!");
			
		}
		//스위치문 장점 : 가독성이 편하다.
		//스위치문을 만들어서 안되는 조건을 테스트 해보길 바랍니다.
		/*switch(b) {
		 * boolean 사용 안됨,
		}*/
		switch(ch) {
		case	'A' :
			System.out.println("문자 A");
			break;
		case 'B' :
			System.out.println("문자 B");
			break;
		}
		
		int num = 1;
		switch(num) {
		case 0 :
			System.out.println("0");
			break;
		case 1 : 
			System.out.println("1");
			break;
		}
		//switch(f) {
		//}
		//스위치문은 int string 이나 enum variable만 가능하다.
		
		
		
	}
}
