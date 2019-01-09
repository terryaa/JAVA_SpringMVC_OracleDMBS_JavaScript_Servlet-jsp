package assign;


//Byte배로 입력받은 데이터를 이용하여 String 객체를 생성(변환)한다.
public class ByteToStringExample {
	public static void main(String[] args) {
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97  };
		//byte 배열전체를 String으로 만드는 생성자를 이용하여 String 생
		String str1 = new String(bytes);
		System.out.println(str1);
		
		//byte배열에서offset 에서 시작하여 length길이만큼까지의 byte를때어내어 String으로 만드는 생자 호출
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
	}
}
