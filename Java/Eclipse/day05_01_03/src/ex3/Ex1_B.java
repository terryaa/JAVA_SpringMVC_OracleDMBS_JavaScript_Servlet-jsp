package ex3;

public class Ex1_B extends Ex1_A {
	int bb=2;
	
	public Ex1_B() {
		System.out.println("자식 생성사 호출");
	}
	public static void main(String[] args) {
		Ex1_B ref=new Ex1_B();
		System.out.println(ref.aa);
		System.out.println(ref.bb);
		
	}

}
