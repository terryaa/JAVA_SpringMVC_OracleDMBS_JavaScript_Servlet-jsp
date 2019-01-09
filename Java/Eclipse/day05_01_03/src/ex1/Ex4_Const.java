package ex1;

public class Ex4_Const {

	private String msg;
	private int num;
	public Ex4_Const() {
		System.out.println("Test1");
	}
	public Ex4_Const(String msg,int num) {
		this();
		System.out.println("Test2");
		this.msg=msg;
		this.num=num;
	}
	public Ex4_Const(String msg) {
		this.msg=msg;
		num=10;
	}
	public void print() {
		System.out.println("MSG:"+msg);
		System.out.println("Num:"+num);
	}
	public static void main(String[] args) {

		Ex4_Const ref3= new Ex4_Const("hihi2",50);
		ref3.print();
	}
}
