package Exam1;

import java.util.Scanner;

public class Exam3_Range {
public static void main(String[] args) {
	/*
	 * ���� : 3
	 * ���� : 9
	 * 1 2 3
	 * 4 5 6
	 * 7 8 9
	 * 
	 * 
	 * ������ 5���
	 * 1 2 3 4 5
	 * 6 7 8 9 10
	 * ���� : ������
	 * 1. for������ �ذᰡ����. ������ �̰� do-while��.  (for (int i = 1;))
	 * 2. ���ǽ� i<=number i++ <�����־�
	 * 3. println�̳� print��...����
	 * 
	 */
Scanner sc = new Scanner(System.in);



System.out.println("���� : ");
int range = Integer.parseInt(sc.nextLine());
System.out.println("���� : ");
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


