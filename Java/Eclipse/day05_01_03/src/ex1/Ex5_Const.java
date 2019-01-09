package ex1;

public class Ex5_Const {

	public Ex5_Const() {
		this("test");
		System.out.println("=");
	}
	public Ex5_Const(String str) {
		this(true);
		System.out.println("*");
	}
	public Ex5_Const(float f) {
		this(10);
		System.out.println("$");
	}
	public Ex5_Const(int n) {
		System.out.println("^");
	}
	public Ex5_Const(boolean b) {
		this(3.14f);
		System.out.println(")#)#");
	}
}
