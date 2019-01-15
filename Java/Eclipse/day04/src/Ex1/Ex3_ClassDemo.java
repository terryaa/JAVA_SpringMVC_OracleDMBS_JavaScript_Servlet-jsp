package Ex1;
/*
 * A팀이 있고 B팀이 있다. 
 * A팀 한테만 insertpay라는 method를 통해서 값을 저장하게 해주고 싶고
 * B팀은 그 값을 사용을 해야하니깐 그 값만을 보게끔 해주고 싶다. 
 * 사실 int pay 라는 method는 필요없음. 
 * 즉 A팀은 Read, write 둘다 되고 B팀은 Read만 가능하게끔.
 */
public class Ex3_ClassDemo {
	//A,B팀이든 PAY란 자원에 직접 접근하지 못하도록 한다.
	private int pay;
	
	
	
    public void insertPay(int pay, String pwd) {
    	if(pwd.equals(1)) {
    		this.pay=pay;
    	}
    	else {
    		System.out.println("에러");
    	}
		//this.멤버필드의 pay = 지역변수 pay

		
	}
	//멤버필드의 pay값을 반환해주는 함수
    public int viewPay() {
    	return pay;
    	
    }
	
}
