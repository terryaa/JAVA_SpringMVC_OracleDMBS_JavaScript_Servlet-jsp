package ex1;

public class Ex3_Demotion {
	// 4byte 이하의 연산은 JVM 연산시 자동으로 4byte로 승격해서 연산함.
	//demotion , promotion
	// java EX3_Demotion => JVM이 실행 시 MAIN 메서드에서 호출(실행)
	public static void main(String[] args) {
	
	byte n1 = 10;
	byte n2 = 20;
	System.out.println(n1);
	System.out.println(n2);

	byte n3 = (byte) (n1 + n2);
	// 연습) short sh1, sh2에 값을 각각 100, 200을 대입.
	// shortsh3에 값을 저장한 후에 출력을 해봅시다.
	System.out.println(n1 +"+" +n2 + "= " + n3);
	
	short sh1 = 100;
	short sh2 = 200;
	short sh3 = (short) (sh1 + sh2);
	
	System.out.println(sh3);
	
	
	
	
	char c1 = 'A';
	short c2 = 1;
	char c3 = (char) (c1 + c2);
	System.out.println(c3);
	//캐스팅.캐스팅이란 형변환을 얘기한다. 캐릭터가 2바이트 쇼트가 2바이트. 근데 연산이 일어남. 이게 4바이트가 일어남. 
	// 즉 c3가 4바이트. 근데 2바이트 + 2바이트라서 연산이 안됨. 
	//여기서 4바이트이하의 연산특징이 나타남.
	}
}
