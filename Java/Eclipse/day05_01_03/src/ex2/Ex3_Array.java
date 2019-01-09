package ex2;

public class Ex3_Array {
	private int[] num1= {100,200};
	private int[] num2= {1000,2000,3000};
	private int[][] test;
	
	public Ex3_Array() {
		test=new int[2][];
		test[0]=num1;
		test[1]=num2;
	}
	public String getData() {
		StringBuffer mysb=new StringBuffer();
		int k=0;
		for(int[] i: test) {
			for(int j: i) {
				mysb.append("test[").append(k).append("][").append(j).append("]");
			}
			k++;
		
		}
		return mysb.toString();
	}
	public static void main(String[] args) {
		System.out.println(new Ex3_Array().getData());
	}
}
