package assign;

public class StringEqualsExample {
	public static void main(String[] args) {
		//값은 같지만참조주소가 다르게 변수 2개와 string객체 2개 생성. 리터럴과 객
		String strVar1 = new String("신민철");
		String strVar2 = "신민철";

		//==비교연산은 변수에 저장된 번지수를 비교함으로다른 번지를 가르키는변수들이다르다고한다.
		if(strVar1 == strVar2) {
			System.out.println("같은 String 객체를 참조");
		} else {
			System.out.println("다른 String 객체를 참조");
		}
		
		//equals는 번지수안의 값을 가져와 비교함으로 같은 문자열을 가진다는 결과를 얻을수있다
		if(strVar1.equals(strVar2)) {
			System.out.println("같은 문자열을 가짐");
		} else {
			System.out.println("다른 문자열을 가짐");
		}
	}
}

