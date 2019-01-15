package ex2;

public class Ex5_Oper {
	public static void main(String[] args) {
		
		int a = 12;		// 0 0 0 0 1 1 0 0
		int b = 2;		// 0 0 0 0 0 0 1 1
	  //int b = 2;      // => 0 0 0 0 0 0 1 1
		
		// a : 비트연산할 변수 , b : 얼마나 쉬프트 할 것 인지
		// b만큼 쉬프트 연산하라
		// 그니깐 1 1 0 0인데 이걸 밀어내서 0 0 1 1 로 됨. 3임. 1 1 0 0 은 자고로 12임.
		int c = a >> b;
		System.out.println("12>>2 :" + c);
		}
}
