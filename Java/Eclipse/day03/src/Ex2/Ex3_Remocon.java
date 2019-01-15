package Ex2;
// 클래스 설계 - 설계란 것은 도면, 사용하는 것은 객체
public class Ex3_Remocon {
	//속성
	boolean power;
	int chNum;
	//setPower가 호출 될 때 인자 값으로 boolean 값을 받아서
	//멤버 필드 power에 저장하고 그 값을 판별한 후 적절한 출력을 담당.
	
	public void setPower(boolean p) {
		//멤버변수에 저장
		power = p;
		if(p==true) { //프로그램으로 실행!
			System.out.println("전원이 켜졌습니다.");
			
		}
		else {
			System.out.println("전원이 꺼졌습니다.");
		}
		
	}
	
	//멤버 필드 chNum을 셋팅시킴
	public void setChNum(int ch) {
		chNum = ch;
	}
	public String viewControl() {
		return "지금 채널은 :" + chNum + "입니다.";
	}
}
