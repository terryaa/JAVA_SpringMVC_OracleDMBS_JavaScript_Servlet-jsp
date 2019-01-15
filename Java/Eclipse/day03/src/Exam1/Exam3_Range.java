package Exam1;

import java.util.Scanner;

public class Exam3_Range {
public static void main(String[] args) {
	/*
	 * 범위 : 3
	 * 숫자 : 9
	 * 1 2 3
	 * 4 5 6
	 * 7 8 9
	 * 
	 * 
	 * 범위가 5라면
	 * 1 2 3 4 5
	 * 6 7 8 9 10
	 * 범위 : 가로축
	 * 1. for문으로 해결가능함. 하지만 이건 do-while문.  (for (int i = 1;))
	 * 2. 조건식 i<=number i++ <만들어넣어
	 * 3. println이냐 print냐...차이
	 * 
	 */
Scanner sc = new Scanner(System.in);



System.out.println("범위 : ");
int range = Integer.parseInt(sc.nextLine());
System.out.println("숫자 : ");
int number = Integer.parseInt(sc.nextLine());

int temp=1;
/*
for(int i=1; i<=number; i++) {
	
	if(temp < range) {
		System.out.print(i + " ");
		
		temp++;
	}
	else if(temp >= range) {
		System.out.println(i + "");
		temp = 1;
		
		
	}
	
*/		

int i = 1;
do {
	if(temp<range) {
		System.out.print(i + " " );
		temp++;
		i++;
	}
	else if(temp == range) {
		System.out.println( i + "");
		temp = 1;
		i++;
	}
	
	
	i++;
}
while(i<=number);





}}


