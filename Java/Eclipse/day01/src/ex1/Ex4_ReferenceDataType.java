package ex1;

public class Ex4_ReferenceDataType {
	public static void main(String[] args) {
		
		
		
		//문자열 이외에 객체를 참조하는 자료형
		// "" => 문자열 값을 지정할 변수의 자료형 String
		System.out.println("안녕하세요.");
		System.out.println(10); // 문자열로 변환
		int num1 = 100;
		System.out.println(num1); // 인자값을 정수 결국 문자열로 변환
		//String 문자열 참조자료형 변수를 선언
		String str;
		//글자와의 갯수는 상관없음.
		str = " asdfaskdlfjasdklfas";
		System.out.println(str);
		str = "                hi"; // 공백도 문자열로 인식한다.
		System.out.println(str);
		System.out.println("length : " + str.length());
		str = "hi" + "one" ; // 문자열 + 문자열 : 연결 의미
		str = "hi" + 10; // 문자열 + 비문자열 => 문자열
		str = true + "hi";
		//str = 100+200; 안됨,에러.
		
	}

}
