package ex1;

public class Ex3_Const {
	private String msg;
	public Ex3_Const() {
		System.out.println("�ʱ�ȭ �Ǿ����ϴ�");
		msg="hello";
	}
	//3. �⺻ �����ڰ� �ƴ� ���ڰ��� �ִ� �����ڰ� �����ϴ� ��쿣 �����Ϸ��� <�⺻������> �� �������������.
	//�����ڴ� �ʵ带 �ʱ�ȭ�ϴ°��̸���
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
