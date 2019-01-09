package assign;

public class StringLengthExample {
	public static void main(String[] args) {
		String ssn = "7306241230123";
		//문자열 ssn의 길이를 length에 저
		int length = ssn.length();
		//길이가 13자리이면 주민번호이다라는 판별을 하는 if구문이다.
		if(length == 13) {
			System.out.println("주민번호 자리수가 맞습니다.");
		} else {
			System.out.println("주민번호 자리수가 틀립니다.");
		}
	}
}


