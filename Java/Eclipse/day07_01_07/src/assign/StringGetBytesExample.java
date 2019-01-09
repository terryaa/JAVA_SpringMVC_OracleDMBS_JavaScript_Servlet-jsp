package assign;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {
	public static void main(String[] args) {
		String str = "안녕하세요";
		
		
		//시스템의 기본 문자셋을 이용하여 인코딩 및 디코딩 진행. 
		//안녕하세요 글자를 총 15바이트글자로 인식한다.(한1개당3바이트)
		byte[] bytes1 = str.getBytes();
		System.out.println("bytes1.length: " + bytes1.length);
		String str1 = new String(bytes1);
		System.out.println("bytes1->String: " + str1);
		
		//문자셋을 지정하는 메소드를 이용할시 잘못된 문자셋을 매개변수로 전달할경우
		//UnsupportedEncodingException이발생하기때문에, try-catch로 예외처리를해준다.
		try {
			
			//EUC-KR디코딩 및 인코딩한다.한글을 2바이트로 인식, 10바이트가생서오딘다.
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println("bytes2.length: " + bytes2.length);
			String str2 = new String(bytes2, "EUC-KR");
			System.out.println("bytes2->String: " + str2);
			
			//UTF-8을 이용하여 디코딩 및 인코딩한다. 한글은 3바이트로인식, 총 15바이트가된다.
			//기본 시스템의 문자셋이 UTF-8로 되있음을 알수있다.
			byte[] bytes3 = str.getBytes("UTF-8");
			System.out.println("bytes3.length: " + bytes3.length);
			String str3 = new String(bytes3, "UTF-8");
			System.out.println("bytes3->String: " + str3);		
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
