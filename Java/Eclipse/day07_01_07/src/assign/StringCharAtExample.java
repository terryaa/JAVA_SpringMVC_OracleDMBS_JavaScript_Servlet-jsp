package assign;

public class StringCharAtExample {
	public static void main(String[] args) {
		String ssn = "010624-1230123";
		// String 객체에서 7번째 있는 문자를 리하여 sex에저
		char sex = ssn.charAt(7);
		//switch문을 통해성별을 판별한다
		switch (sex) {
			case '1':
			case '3':
				System.out.println("남자입니다");
				break;
			case '2':
			case '4':
				System.out.println("여자입니다.");
				break;
		}
	}
}
