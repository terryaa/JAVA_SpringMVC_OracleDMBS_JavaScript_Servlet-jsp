package ex2;

public class Ex1_Array {
	
	private int[] num1= {1,2,3,4,5,6,7,8};
	public Ex1_Array() {
		System.out.println("�迭�� �ε����� ���� :"+num1[0]);
		System.out.println("�迭�� ����"+num1.length);
		System.out.println("----------------");
		for(int i=0;i<num1.length;i++) {
			System.out.println(num1[i]+"=");
		}
		//jdk 5���� �����ϴ� ����for���� ���°� ũ�⿡������̾����־����.
		for(int e:num1) {
			System.out.println(e+"*");
		}
		
	}
	public static void main(String[] args) {
		
	}
}
