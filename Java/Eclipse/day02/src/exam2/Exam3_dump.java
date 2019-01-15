package exam2;

import java.util.Scanner;

public class Exam3_dump {


public static void main(String[] args) {
	//사과를 담는데 필요한 바구나(버켓)의 수를
	//만일 사과의 수가 n개이고 하나의 바구니에는 10개의 사과를 담을 수 있다면

	//13개의 바구니가 필요할 것이다.
	
	Scanner sc = new Scanner(System.in);
	int apple = Integer.parseInt(sc.nextLine());
	
	int basketahrt = apple/10;
	int basketskajwl = apple%10;
	
	System.out.println("apple의 개수는 : " + apple);
	System.out.println("basket의 몫은 : " + basketahrt);
	System.out.println("basket의 " + basketskajwl);
	
	int basketresult = (basketskajwl <= 0) ? basketahrt : basketahrt+1;
	
	
	System.out.println("바구니의 총 개수는" + basketresult);
	
	
	//사과의 개수가 123입력
	//바구니가 필요한 갯수 = 10개
	// 사과의 개수 200개
	// 바구니 필요한 갯수 20개
}
}