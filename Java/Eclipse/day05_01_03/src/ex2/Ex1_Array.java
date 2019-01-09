package ex2;

public class Ex1_Array {
	
	private int[] num1= {1,2,3,4,5,6,7,8};
	public Ex1_Array() {
		System.out.println("배열의 인덱스로 접근 :"+num1[0]);
		System.out.println("배열의 길이"+num1.length);
		System.out.println("----------------");
		for(int i=0;i<num1.length;i++) {
			System.out.println(num1[i]+"=");
		}
		//jdk 5부터 제공하는 향상된for문을 쓰는게 크기에상고나없이쓸수있어서좋다.
		for(int e:num1) {
			System.out.println(e+"*");
		}
		
	}
	public static void main(String[] args) {
		
	}
}
