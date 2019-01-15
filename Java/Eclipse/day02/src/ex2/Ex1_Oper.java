package ex2;

public class Ex1_Oper {
	public static void main(String[] args) {
		//일반 자료형일 경우 대입 연산자
		int a = 0;
		
		a += 10; // a = a + 10;
		
		System.out.println("1) " + (a-=5));
		System.out.println("2) "+ (a*=10));
		System.out.println("3) " + (a/2));
		System.out.println("4) " + (a%=2));
		
		
		
		
		
		
		
		//string 클래스는 불변적인 특징이 있기 때문에 += 연산을 하면
		//생성된 문자열 객체를 가비지 컬렉션이 모두 제거하는 불필요한 메모리가 낭비됨.
		// 자료형에서는 이정도만 이해 (클래스와 객체)
		String msg = "ABC";
		msg += "DEF";
		msg += "ZZZ";
		
		/*
		 * 여기서 문제점이 있음.
		 * 만약에 msg = ABC인데
		 * msg += "DEF"를 입력함
		 * 그러면 여기서 ABCDEF가 아니라, ABC 에 추가로 DEF를 추가함
		 * 그러면 ABC DEF ABCEDF 3개가 로드되는거임.
		 * 근데 이게 다 사용하는거니깐 메모리 낭비가 됨. 가비지가 아니므로 제거가 안됨.
		 * 이렇게 사용하지 않고 버퍼에 넣어서 사용해야 함.
		 */
		
		
		
		StringBuffer sb = new StringBuffer();
		sb.append("ABC").append("DEF:").append("ZZZ");
		System.out.println(sb);
		//Buffer 란 개념을 사용해서 문자열을 안전하게 저장해서 (append() 호출해서 버퍼에 저장)
		//사용할 수 있다.
	}
}
