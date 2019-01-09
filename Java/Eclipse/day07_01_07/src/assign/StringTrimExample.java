package assign;

public class StringTrimExample {
	public static void main(String[] args) {
		String tel1 = "  02";
		String tel2 = "123   ";
		String tel3 = "   1234   ";
		
		
		//공백(띄어쓰기) 가 포함되어있는 문자열에서 공백을 모두 제거한 문자열을 새로만들어 리턴한다
		//3개의 문자열이 새로생긴뒤 +로 합쳐서 공백없이 연결된 문자열을 최종결과로만들게된다.
		String tel = tel1.trim() + tel2.trim() + tel3.trim();
		System.out.println(tel);
	}
}

