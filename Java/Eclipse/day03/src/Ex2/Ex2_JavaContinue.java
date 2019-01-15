package Ex2;

public class Ex2_JavaContinue {
	public static void main(String[] args) {
		/*for (int i = 0; i < 10; i++) {
			if(i ==2 || i == 5) {
				continue; // i가 2 또는 5일 경우 다음 반복문으로 넘어간다.
				//2하고 5는 패싱이 된다. 
			}
			System.out.println(i);
		}
	*/
		for (int i = 0; i < 5; i++) {
			ex: for(int j = 0; j < 5; j++) {
				if(j==3) {
					continue ex;
				}
				//j가 3일 때 이하 문장을 수행하지 않고 ex로 넘어간다.
				System.out.println("i:" + i + " , j" + j);
			}
		}
	
	
	}
}
