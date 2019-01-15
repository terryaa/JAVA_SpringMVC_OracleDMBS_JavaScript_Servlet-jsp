package exam2;

import java.util.Scanner;

public class Exam3_AppleBusket {
	
	public static void main(String[] args) {
		//사과를 담는데 필요한 바구나(버켓)의 수를
		//만일 사과의 수가 n개이고 하나의 바구니에는 10개의 사과를 담을 수 있다면
		//13개의 바구니가 필요할 것이다.
		
		Scanner sc = new Scanner(System.in);
		int apple = Integer.parseInt(sc.nextLine());
		int n = apple/10;
		
		for(int i = 0; i<=n; i++) {
			if(apple >=10) {
				n++;
				apple = apple - 10;
			}
			
			else {
				System.out.println("바구니의 개수는 : " + n);
			}
			
			
		}
	}
		
		
		//사과의 개수가 123입력
		//바구니가 필요한 갯수 = 10개
		// 사과의 개수 200개
		// 바구니 필요한 갯수 20개
	}


