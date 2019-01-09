package assign;

public class StringIndexOfExample {
	public static void main(String[] args) {
		String subject = "자바 프로그래밍";
		
		//자바 프로그래밍  이라는 문자열에서  프로그래밍  이라는 문자열이시작되는 지점을 찾아낸다.
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		
		//indexOf와 if를 이용하여 자바 라는 문자열이 subject에 포함되어있는지 검사한다.
		//포함되어있기때문에 indexof의 값은 -1이 아니게된다.
		if(subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책이군");
		} else {
			System.out.println("자바와 관련없는 책이군");
		}
	}
}

