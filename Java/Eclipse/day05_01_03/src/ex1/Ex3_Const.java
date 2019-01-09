package ex1;

public class Ex3_Const {
	private String msg;
	public Ex3_Const() {
		System.out.println("초기화 되었습니다");
		msg="hello";
	}
	//3. 기본 생성자가 아닌 인자값이 있는 생성자가 존재하는 경우엔 컴파일러가 <기본생성자> 를 만들어주지않음.
	//생성자는 필드를 초기화하는것이목적
	public void print() {
		System.out.println(msg);
	}
	public void print(String str) {
		msg=str;
		System.out.println(msg);
	}
	public static void main(String[] args) {
		Ex3_Const ref=new Ex3_Const();
		ref.print();
		ref.print("hi2");
	}
}
