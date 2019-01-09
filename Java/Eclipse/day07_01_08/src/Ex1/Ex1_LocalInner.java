package Ex1;

public class Ex1_LocalInner {
	private int a;
	public Ex1_LocalInner() { a = 100; }
	//로컬내부클래스안에서........지역변수이야기
	//jdk7 이하까지는 final이라고 명시
	//jdk 8버전 이후 부터는 final이 없어도 지역변수는 상수취급
	
	public void insertTest(int num) {
		int b = 200; //상수
		int c = num; //상수
			class Inner{ //메소드 영역 안에서 존재
				public void getData() {
					System.out.println("멤버필드 참조 : "+a);
					//메서드안의 상수는 참조할 수 있지만
					//지역변수는 참조할 수 없다.
					//System.out.println("지역변수 참조" + (b++)); //지역변수인데 상수를 변화줄려니깐 오류임
					//System.out.println("지역변수? + " + (c+=num)); //상수인데 변화줄려고 하니깐 오류임 
					//System.out.println(b); // b = 30;때문에 오류임 
				}
			}
			new Inner().getData();
			b = 30;
			System.out.println("b:" + b);
			
			
			
	}
	
	public static void main(String[] args) {
		new Ex1_LocalInner().insertTest(200);
	}


}
