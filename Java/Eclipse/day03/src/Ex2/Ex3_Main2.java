package Ex2;

import java.util.Scanner;

public class Ex3_Main2 {
	//2. Ex3_remocon 클래스를 객체로 생성하자.
	//참조자료형 참조변수 = new 생성할 객체();
	//스택에서 선언된 ex3_remocon을 참조 자료형으로 한 변수 er에는
	//heap영역에 new 연산자로 생성된 객체의 주소(100)가 저장되어 있다.
	//그로므로 er변수로 EX3_Remocon 객체를 참조해서 사용할 수 있다.

	public static void main(String[] args) {
		Ex3_Remocon er = new Ex3_Remocon();
		// 3. UI
		Scanner sc = new Scanner(System.in);
				while(true) {
					System.out.println("전원켜기 1, 전원끄기 2 : ");
					String powerMsg = sc.nextLine();
					if(powerMsg.contentEquals("1")) {
						er.setPower(true);
					}
					else if(powerMsg.equals("2")) {
						er.setPower(false);
						
					}else {
						System.out.println("잘못된 번호입니다.");
					}
				}
	}
}
