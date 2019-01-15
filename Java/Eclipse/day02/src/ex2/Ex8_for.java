package ex2;

public class Ex8_for {
	public static void main(String[] args) {
		
		int sum = 0;
		
		for (int i = 1; i<=100; i++) {
			sum = sum+i;
		}
		
		System.out.println("1~100까지의 합 : " + sum);
		
			for(int i = 1; i <= 9; i++) {
			
			
			for (int l = 1; l >= 9; l++) {
				System.out.println(i +"*"+l+"="+l*i);
			}
			}
}
}
