package Ex1;

public class Ex1_Main {
	public static void main(String[] args) {
		//이미 설계된 Ex1_ClassDemo를 객체로 생성하는 방법을 알고있다.
		ClassDemo ref = new ClassDemo();
		//참조는 .연산자를 사용해서 사용합니다.
		ref.pay=100000; 
		//생성된 Ex1_ClassDemo의 주소(100)으로 참조해서 변수 pay에 값을 10000을 기억
		System.out.println("기억된 pay : " + ref.pay);
		//Ex1_ClassDemo이 가지고 있는 필드 안에서 team이란 속성에 적당한 값을 저장하고 출력해봅시다.
		ref.team=234;
		
		/*
		 * Dogdemo 클래스를 만들고
		 * 강아지 이름 : dname : String
		 * 강아지 나이 : dage : int
		 * 
		 * DogDemoMain
		 * 
		 * DogDemo를 객체를 생성하고
		 * 강아지의 이름과 나이를 저장하고 출력하기
		 */
	}
}
