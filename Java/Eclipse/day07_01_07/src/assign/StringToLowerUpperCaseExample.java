package assign;

public class StringToLowerUpperCaseExample {
	public static void main(String[] args) {
		String str1 = "Java Programming";
		String str2 = "JAVA Programming";		
		
		System.out.println(str1.equals(str2));
		
		//str1, str2 두개 문자열을 모두 소문자로 바꾼 문자열을 리턴하여 2개의 새로운 문자열을 만들었다.
		String lowerStr1 = str1.toLowerCase();
		String lowerStr2 = str2.toLowerCase();
		
		//equals를 통해 두 문자열이 같음을 확인한
		System.out.println(lowerStr1.equals(lowerStr2));
		
		//대소문자의 차이가있는 str1,str2문자열을비교함에 있어 IgnoreCase를 사용하였다.
		//대소문자 차이를 무시하여 true가 리턴된다.
		System.out.println(str1.equalsIgnoreCase(str2));				
	}
}

