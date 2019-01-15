package ex2;

public class Ex2_Oper {
	public static void main(String[] args) {
		/*논리연산자 : && 논리곱, || 논리합, ! 부정
		 * true && true -> true / false && true 일 때 true는 실행되지 않는다.
		 * ||는 false || ture가 되더라고 true까지 실행한다.
		 */
		
		int a = 10;
		int b = 20;
		boolean c = ((a += 12)>b) || (a == (b+=2));
		boolean d = ((a += 12)>b) && (a == (b+=2));
		
		// or에서 처음에 true이면 뒤에껀 계산 아예 안하고 그냥 ture 출력.
		System.out.println("c=" +c);
		System.out.println("a=" +a);
		System.out.println("b=" +b);
		System.out.println("d=" + d);
		System.out.println("---------------");
		
	}

}
