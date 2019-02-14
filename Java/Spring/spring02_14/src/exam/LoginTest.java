package exam;

import java.util.Scanner;

public class LoginTest {
	private boolean res;
	public LoginTest() {
		String[] msg= {"틀렸습니다.","아쉽군요.마지막 한버만 더!","접근 권한이 없습니다."};
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<msg.length;i++) {
			System.out.println("비밀번호입력:");
			String pwd=sc.nextLine();
			if(!pwd.equals("1")) {
				System.out.println(msg[i]);
				res=false;
			}
			else {
				res=true;
				break;
			}
				
		}
	}
	public boolean isRes() {
		return res;
	}
}
