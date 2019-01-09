package assign;

import java.io.IOException;

public class KeyboardToStringExample {
	public static void main(String[] args) throws IOException {
		
		//입력받는 문자열을 저장할 byte 배
		byte[] bytes = new byte[100];  
		
		System.out.print("입력 : ");
		
		//byte배열의길이를 저장과 동시에 키보드로부터 문자열을 입력받는다
		int readByteNo = System.in.read(bytes);

		//바이트 배열을 문자열로 저장, 엔터를 누름으로서 입력되는 \r,\n을 제거하기위해 -2를한다
		//책에는 캐리지리턴\r 이 입력된다고하지만  디버깅 결과 \n만 입력되는것을 확인, -1로 수정해보니
		//정상적인결과가나옴
		String str = new String(bytes, 0, readByteNo-1);
		System.out.println(str);
	}
}
