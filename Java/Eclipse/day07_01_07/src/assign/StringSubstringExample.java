package assign;

public class StringSubstringExample {
	public static void main(String[] args) {	
		String ssn = "880815-1234567 ";
		
		//substring을 이용해 인덱스 0부터 6전까지에 존재하는 문자열을 따로 때내어 리턴한다.
		
		String firstNum = ssn.substring(0, 6);
		System.out.println(firstNum);		
		
		//substring을 이용하여 인덱스 7부터 ssn의 문자열 끝까지 존재하는 문자들을 따로 때내어 리턴한다.
		String secondNum = ssn.substring(7);
		System.out.println(secondNum);
	} 
}

