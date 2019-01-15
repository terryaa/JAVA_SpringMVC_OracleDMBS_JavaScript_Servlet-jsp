package Ex1;

public class Ex4_SwitchLabel {
	public static void main(String[] args) {
		
		loopout : for (int i = 0; i < 5; i++) {
					for(int j = 0; j < 5; j++) {
						//다중 for문처럼 바깥의 for문으로 탈출하고 싶을 때
						//나갈 곳에 라벨을 붙여서 break문에 표시를 해 두면 된다.
						//jdk 5부터 지원.
						if(j==3) {
							break loopout;
						}
						System.out.println(j + "," + i);
					}
		}
	}
}
