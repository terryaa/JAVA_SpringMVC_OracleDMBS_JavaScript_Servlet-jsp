package ex1;

public class Ex2_Variable {
	public static void main(String[] args) {
		//변수구분 : 기본형 타입 8가지 , 참조 타입 (그 외)
		// 복습 포인트) 교재 38page
		// 정수형 : byte(1), short(2), int(4), long(8)
		// 실수형 : float(4), double(8)
		// 논리형 : boolean(1) (참/거짓) true/false
		int a = 3; // 변수를 선언 3이란 상수를 (=)대입한다
		int b; // 변수를 선언, 값은 할당이 안됨.
		b = 3; // 선언한 변수 b에 3을 대입.
		// int a; // 변수는 { } 영역 안에서 한번만 선언할 수 있다.
		// short 타입의 c 값에는 50을 저장할 수 있다. (-32768 ~ 32767)
		short c = 50;
		// byte 타입의 d에는 100값을 저장할 수 있다. (범위 : -128 ~ 127까지.)
		byte d = 100;
		//All값을 문자열로 모니터로 출력을 하는 함수
		System.out.println(a);
		System.out.print("변수 a의 값 : ");
		System.out.println(a);
		System.out.println("변수 b의 값 :" + b);
		System.out.println("---------");
		// "" => 문자열을 의미하고 참조 자료형으로 생각
		// 문자열 연결연산자 => +
		System.out.println("변수 c의 값 :" + c);
		System.out.println("변수 d의 값 :" + d);
		
		long e = 2000000033L; // L ~ 1 리터럴 접미사. 
		System.out.println(e);
		// 예) long형 8byte -> int 4byte
		long times = System.currentTimeMillis();
		int timess = (int) System.currentTimeMillis();
		// (int) <- 강제로 int로 전환시키는것임. 
		System.out.println("Times:" + times);
		System.out.println("timess:" + timess);
		// overflow로 인하여 -로 전환. 정확한 값이 안나옴. 
		
		
		
		
		//변수 명명규칙
		// 1. 대소문자 구분
		// 2. 숫자로 시작 x
		// 3. 특수문자 _, $ 두가지만 가능
		// 4. 예약어는 변수명으로 사용 불가
		// 5. 변수는 무조건 소문자로 시작해야한다. (필수)
		
		int x;
		int X; // 대소문자 구분
		int numberOptionApplication;
		// 숫자로 시작은 안되지만 혼용은 가능
		
		
		
		int num1;
		int num2 = 10;
		num2 = 20; // 마지막에 저장된 값만 기억함.
		//변수 = 변하는 수
		// 상수 = 일정한 수. final - 키워드를 사용하면 프로그램이 종료될 때 까지 변경 불가능.
		
		
		final int SIZE = 8; // 상수값
		System.out.println(SIZE);
		//SIZE = 10;
		//3.14 => double 이고, float(4) = F,f 리터럴 표기
		float g = 3.14f;
		double h = 3.14d;
		//boolean(1)
		boolean i = true;
		//자바에서는 한 문자를 유니코드(2byte)로 인식
		//'문자'=> "A"는 문자열(참조자료형)
		
		char j = 'A';
		
		System.out.println("boolean:" + i  + " ,\n char : " + j);
		// int k = 100;
		// long l = k;
		// 인지할필요없음. 프로모션이라고 함.  
		// 반대 상황은 디모션. 인지는해야지
	
	}

}
