package assign;

public class StringReplaceExample {
	public static void main(String[] args) {
		String oldStr = "자바는 객체지향언어 입니다. 자바는 풍부한 API를 지원합니다.";
		
		//replace는 첫번째 매개변수의 문자열을 전부 찾아 두번재 매개변수의 문자열로 값을 바꾼뒤
		//새로운 string을 만들어 리턴한다.
		String newStr = oldStr.replace("자바", "JAVA");
		
		System.out.println(oldStr);
		System.out.println(newStr);
	}
}

