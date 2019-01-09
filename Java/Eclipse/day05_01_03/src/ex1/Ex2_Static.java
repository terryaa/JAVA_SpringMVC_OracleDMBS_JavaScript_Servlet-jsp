package ex1;

public class Ex2_Static {
	//Static은 공유
	//하나생성으로 모든 객체가 공유
//생성없이 접근 및 사용가능
	//static이 붙은 실제 모든 자원은 JVM의 영역중에 static 영역에 위치한다. 
	public static int  num1;
	private int num2;
	public void startTest() {
		num1++;
		num2++;
	}
	public static int getNum1() {
		return num1;
	}
	public int getNum2() {
		return num2;
	}
}
