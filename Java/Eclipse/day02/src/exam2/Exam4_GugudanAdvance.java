package exam2;

import java.util.Scanner;

public class Exam4_GugudanAdvance {
	public static void main(String[] argus) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("단 입력");
		int dan = Integer.parseInt(sc.nextLine());
		//예를들어 6을 입력했다고 하자.
		System.out.println("범위 입력 (3,5,7)");
		int range = Integer.parseInt(sc.nextLine());
		//예를들어 범위를 5라고 입력했다고 하자.
		
		// dan == 6, range == 5
		
		
/*
		if(range == 3) {
			
		for(int j = dan-1; j <= dan-1 + range -1 ; j++) {
			System.out.println(j + "단");
			System.out.println("");
			for(int i = 1; i <=9; i++) {
			
			System.out.print(j + "*" +i+ "="+j*i + " ");
			System.out.println(" " );
		
			
			}
		}
		
		
		
			
				
				}
		else if (range == 5) {
			for(int j = dan-2; j <= dan-2 + range -1 ; j++) {
				for(int i = 1; i <=9; i++) {
				System.out.print(
					
						j +"*"+i+"="+j*i + " "
					
						);

			}

			
		}
		}
			else if (range == 7) {
				for(int j = dan-3; j <= dan-3 + range -1 ; j++) {
					for(int i = 1; i <=9; i++) {
					System.out.print(
						
							j +"*"+i+"="+j*i + " "
						
							);


		}
	}
}
		
		*/
		
		
/*
	
		for(int j = dan-1; j <= dan-1 + range -1 ; j++) {
			System.out.println("");
			for(int i = 0; i <=9; i++) {
				if(i == 0) {
					System.out.println("dan");
				}
				else {
			System.out.print(j + "*" +i+ "="+j*i + " ");
			System.out.println(" " );
				}
			
			}

		}
		*/
		
		
		
		
		
		
		
	
		for(int i = 0; i <=9; i++) {
		    for(int j = dan-1; j <= dan-1 + range -1 ; j++) {
		    	if(i==0) {
		    		System.out.print(j+"dan");
		    	}
			else {System.out.print(j + "*" +i+ "="+j*i + " ");
					
			}
			
			}
		    System.out.println("");
		}
	
	}

		
			
			
		
		
		
		
		
	}



		
		
		
	

