package exam2;

import java.util.Scanner;

public class Exam5_GAME {
	public static void main(String[] args) {
		
		
		int i;
		int win = 0 ;
		int lose = 0 ;
		double winrate;

		String cpuanswer;
		Scanner sc = new Scanner(System.in);
		//80~90 이상이면 뭘 주겠다
		//그 이하면 없음.
		//6경기 이하면 상품없음.
		
		
		for(i=0; i <= 999999999; i++) {
		//i = 경기수
			int cpuresult = (int) (Math.random()*2);
			if(cpuresult == 1) {
				cpuanswer = "홀";
			}
			else {
				cpuanswer = "짝";
			}
			
			if(i==0) {
		System.out.println("게임 (1-홀, 2-짝, 3-종료)");
			}
			if(i>=1) {
		int youanswer = Integer.parseInt(sc.nextLine());
		if(youanswer == 3) {
			System.out.println("게임 종료!!");
			System.out.println("전체 게임 수 : " + (i-1));
			System.out.println("이긴 횟수 : " + win);
			winrate = ((win/(i-1))*100);
			double winwin;
			winwin = win;
			double allgame;
			allgame = i-1;
			
			winrate = (winwin/allgame)*100;
			System.out.println("승률 : " + winrate + "%");
			if(i<=6) {
				System.out.println("응안줘");
			}
			else {
				if(winrate >= 80) {
					System.out.println("상품받아가");
				}
				else {
					System.out.println("없음.");
				}
			}
			break;
			
		}
		
		System.out.println("--------------------------");
		System.out.println("게임 (1-홀, 2-짝, 3-종료) :" + youanswer);
		System.out.println("--------------------------");
			System.out.println("No. :" + i);
			System.out.println("CPU :" + cpuanswer);
			
			
		if(youanswer == 1) {
			System.out.println("YOU : 홀");
				if(cpuresult==1) {
					System.out.println("WIN");
					win++;
					
				}
				else {
					System.out.println("LOSE");
					lose++;
				}
		}
		if(youanswer == 2) {
			System.out.println("YOU : 짝");
			if(cpuresult == 1) {
				System.out.println("LOSE");
				lose++;
			}
			else{
				System.out.println("WIN");
				win++;
			}
		}
		
		
		
			
		
		
			}
		}
		
	}
}
