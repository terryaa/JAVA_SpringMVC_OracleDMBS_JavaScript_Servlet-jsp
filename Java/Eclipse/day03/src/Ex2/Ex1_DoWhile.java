package Ex2;

public class Ex1_DoWhile {
	public static void main(String[] args) {
		//do-while은 조건없이 한번은 무조건 수행하는게 중요한 포인트
		int i = 0;
		do {
			if(i % 2 == 0) {
				System.out.println("짝:"  +i);
			}else {
					System.out.println("홀:"+i);
				}
				i++;
			} while ( i <= 10);
		System.out.println("---------");
		}
	}

