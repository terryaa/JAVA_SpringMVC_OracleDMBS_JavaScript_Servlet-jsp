package ex2;

import java.util.Scanner;

public class Ex5_Math {
	public static void main(String[] args) {
		Scanner scA = new Scanner(System.in);
		System.out.println("A의 값을 입력하세요");
		String numAA = scA.nextLine();
		
        int numAAInt = Integer.parseInt(numAA);
		
		Scanner scB = new Scanner(System.in);
		System.out.println("B의 값을 입력하세요");
		String numBB = scB.nextLine();
		
		int numBBInt = Integer.parseInt(numBB);
		
		int numA =  numAAInt;
		int numB = numBBInt;
		
		/*
		 * 정답
		 * Scanner sc = new Scanner(System.in);
		 * int numA = Integer.parseInt(sc.nextLine());	
		 */
		int resNum1 = numA + numB;
		int resNum2 = numA * numB;
		int resNum3 = numA - numB;
		int resNum4 = numA / numB;
		int resNum5 = numA % numB;
		System.out.println(resNum1);
		System.out.println("결과:"+resNum1);
		System.out.println("같다:" + (numA == numB));
		System.out.println("결과:" + resNum2);
		System.out.println("결과:" + (numA != numB));
		System.out.println("결과:" + resNum3);
		System.out.println("크다, 크거나 같다 :" 
							+ (numA > numB)+","+(numA >= numB));
		System.out.println("작다, 작거나 같다:" 
							+ (numA < numB)+","+(numA <= numB));
		System.out.println("결과:" + resNum4);
		System.out.println("결과:" + resNum5);
	
	}

}
