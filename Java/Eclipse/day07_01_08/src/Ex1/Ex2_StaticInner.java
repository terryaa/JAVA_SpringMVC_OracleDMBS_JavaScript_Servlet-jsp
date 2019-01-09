package Ex1;

public class Ex2_StaticInner {
	int numA;
	private int numB;
	static int numC = 500;
	public void test() {
		System.out.println("Test!");
	
	}
	public Ex2_StaticInner() {
		numA = 10; numB = 100; numC=200;
	}
	
	//내부 클래스 안에서 static 자원이 있으면 무조건 static 내부 클래스로 지정해줘야 한다.
	
	public static class Inner {
		static int d = 10000;
		public static void printData() {
			//System.out.println("int A " + numA); 
			//오류가 나는 이유는 numA와 numB는 객체로 생성한 후에 불러와야함. 인스턴트 후손임. static자원은 못떠옴. 
			//System.out.println("int B " + numB);
			
			System.out.println("int C " + numC);
			System.out.println("int D " + d);
		}
		
		public class asdf {
			int e = 10000;
			public void print() {
				System.out.println("int e " + e);
			}
		}
		public void printData2() {
			System.out.println("c:" + numC);
			System.out.println("d:" + d);
		}
	}

}
