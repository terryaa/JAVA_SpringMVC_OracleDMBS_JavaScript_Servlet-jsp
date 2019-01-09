package Ex1;

public class Ex3_StaticInnerMain {

	public static void main(String[] args) {
		//static은 생성없이 사용이 가능하다
		//여러 객체가 생성해서 참조(공유)하더라도 static 영역에 오직 하나만.
		//static을 소유한 외부 클래스.static자원
		//외부 클래스 this처럼 넣어야 함
		Ex2_StaticInner.Inner.printData();
		System.out.println("------------------");
		//printData2() 호출해보기
		new Ex2_StaticInner.Inner().printData2();
		Ex2_StaticInner.Inner ref = new Ex2_StaticInner.Inner();
		ref.printData2();

	//객체가 외부 클래스에서 생성해야 함
	}
}
