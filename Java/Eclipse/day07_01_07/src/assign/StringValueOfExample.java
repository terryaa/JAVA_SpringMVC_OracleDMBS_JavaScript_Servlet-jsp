package assign;

public class StringValueOfExample {
	public static void main(String[] args) {
		
		//valueof는 기본자료형을 매개변수로받아 그 값에 해당하는 String 객체를 만들어 리턴한다.
		//숫자들이 그대로 String이 되는것을 볼 수 있다.
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(10.5);
		String str3 = String.valueOf(true);		
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}
}

