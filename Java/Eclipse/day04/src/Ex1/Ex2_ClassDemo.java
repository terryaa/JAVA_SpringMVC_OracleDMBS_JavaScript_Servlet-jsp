package Ex1;
//클래스 구성
//1. 헤더
// { } = 헤더
//2. 멤버필드
//3. 멤버메서드
//클래스는 객체 지향으로 설계(재사용), 통상 메인메서드는 포함되지 않는다.
public class Ex2_ClassDemo {
	///*****멤버필드는 선언과 동시에 초기화가 됨!
	int pay;
	String team;
	// 메서드를 한번 만들어보면서 의미를 파악해봅시다.
	public void test() { //Ex2_ClassDemo 클래스가 객체로 생성 된 이후에 사용하는 메서드.
		System.out.println("pay : " + pay + ", Team : " + team);
		//이대로 출력하면 pay = 0 이고 team 은 null값임.
	}
	// 테스트 후 18~21 라인을 주석처리하고 Ex2_Main클래스를 만들어서 구현
/*	public static void main(String[] args) {
		Ex2_ClassDemo ref = new Ex2_ClassDemo();
		ref.test();
		
	}
*/

//의미있는 작업으로 메서드를 정의 해봅시다.
//pay에 어떤 값을 저장할 수 있도록 제공하는 메서드 만들기
//반환형을 결정할 때 고민해야 할 것 : 메서드 호출 후에 특정 값을 반환 받을 것인지
//받을 값이 없으면 메서드만 수행할 것 인지
//값을 넘는 작업에 대해서 반환 값을 받을 필요가 없다고 생각해서 void로 결정했음

public void insertPay(int p) {
	System.out.println("LOG1 : 지역변수 pay :" + p);
	System.out.println("LOG2 : 멤버필드 pay : " + pay);
	//만약에 지역변수의 pay = 10000;이면 지역변수를 우선으로 침. 
	//무슨말이냐면 위에 class Ex2_ClassDemo 안에서 pay가 0이더라도 여기서의 pay는 10000이므로 여기가 우선됨.
	//그러면 멤버필드에 있는걸 출력하고 싶으면 지역변수를 p로 바꾸던가 해야 함.
	
	
	
	//즉 int pay 이건 지역내에서만 int pay 사용하니깐 (int pay인거임)
}
	//해보기 1. 이번에는 team에 값을 지정하는 메서드를 만들어 봅시다.

	public void insertPayTeam(int p, String t) {
		pay = p;
		team = t;
	}


	//해보기 2. 이번에는 pay, team의 값을 동시에 지정하는 메서드를 만들어 봆디ㅏ.

public void paytem(String tt, int p) {
	tt = "ttteam";
	p = 23;
	System.out.println("지역변수 PAY :" + p);
	System.out.println("멤버필드 pay :" + p);
	System.out.println("지역변수 팀" + tt);
	System.out.println("멤버필드 팀" + team);
}






}




