package exam1;

import java.util.Scanner;

public class Exam4_Quiz {
	public static void main(String[] args) {
		Scanner scanname = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		String name = scanname.nextLine();
		System.out.print(name);
		
		Scanner scanage = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		String age = scanage.nextLine();
		System.out.print(age);
		
		Scanner scanhome = new Scanner(System.in);
		System.out.print("사는곳을 입력하세요 : ");
		String home = scanhome.nextLine();
		System.out.print(home);
		
		
		System.out.println("\n 이름 : " + name + " 나이 : " + age + " 사는곳 : " + home);
		
		
		
		
	}

}
 	